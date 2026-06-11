# FusionAuth HTTP Client (Phase 2) — Design

- **Date:** 2026-06-11
- **Status:** Approved
- **Source spec:** `src/main/openapi.yaml` (`paths:` section, lines 10314–19360)
- **Depends on:** Phase-1 domain records (`org.lattejava.fusionauth.domain`), JDK `java.net.http`, Java 25

## Goal

Generate a complete, synchronous FusionAuth API client — one Java method per OpenAPI operation —
built on the JDK `java.net.http.HttpClient`, reusing the Phase-1 domain records for request/response
serialization. Clean-room from the OpenAPI spec.

## Scope

- **322 operations** across 176 paths (132 POST, 83 GET, 38 PUT, 39 DELETE, 30 PATCH).
- All requests/responses are `application/json`. No multipart, binary, or streaming.
- Every operation has exactly one `200` success response (a single `$ref` schema) and a `default`
  error response (almost always `Errors`).
- Auth: an API key in the `Authorization` header (`securitySchemes.ApiKeyAuth`).
- Parameters: 189 `path`, 90 `query`, 1 `header` (`X-FusionAuth-TenantId`).
- `operationId`s are globally unique; path-param variants use the `…WithId` suffix convention
  (e.g. `createApplication` vs `createApplicationWithId`).

## Package & module

- New class `org.lattejava.fusionauth.FusionAuthClient` (the **root** package) plus
  `org.lattejava.fusionauth.FusionAuthException`.
- `module-info.java`: add `exports org.lattejava.fusionauth;` and `requires java.net.http;`. No new
  external dependency.

## `FusionAuthClient`

A single class holding a `java.net.http.HttpClient`, the base URL, and the API key.

- **Construction:**
  - `FusionAuthClient(String apiKey, String baseURL)` — builds a default `HttpClient`.
  - `FusionAuthClient(String apiKey, String baseURL, HttpClient httpClient, Duration timeout)` — for
    caller-supplied transport/timeout.
- **One public method per operation**, named exactly by `operationId`. Method parameters, in order:
  1. path parameters (in path order),
  2. query parameters (in spec order),
  3. the `X-FusionAuth-TenantId` header parameter, where present,
  4. the request body (its domain record type), where present.
- **Parameter typing:** path/query/header params are `String` (the spec declares them
  `type: string`, with no `uuid` format on path params — spec-faithful, consistent with the models).
  The request body is its concrete domain record type.
- **Return type:** the operation's `200` response record type, returned directly.
- **Throws** `FusionAuthException` on any non-2xx response or transport failure.

Examples:

```java
ApplicationResponse retrieveApplicationWithId(String applicationId);
ApplicationResponse createApplicationWithId(String applicationId, ApplicationRequest request);
JWKSResponse retrieveJsonWebKeySetWithId();
SystemConfigurationResponse retrieveSystemConfiguration();
```

## Request flow (one shared private helper, reflection-free)

Each generated method is a one-liner delegating to a generic helper. The helper:

1. Builds the URI: `baseURL` + the path with `{param}` segments substituted (URL-encoded), plus a
   query string assembled from the non-null query params (URL-encoded).
2. Sets headers: `Authorization: <apiKey>` always; `Content-Type: application/json` when there is a
   body; the `X-FusionAuth-TenantId` header where the operation declares it.
3. Sends via `HttpClient` (`HttpResponse.BodyHandlers.ofString()`).
4. On **2xx**: parses the body with the response type's `fromJSON` and returns it.
5. On **non-2xx**: throws `FusionAuthException` (parsing `Errors` from the body when possible).

**No reflection.** Serialization uses the domain records' concrete, processor-generated methods:
`request.toJSON()` for the body and `ResponseType::fromJSON` passed to the helper as a
`java.util.function.Function<String, T>` method reference. The helper never inspects types at
runtime; the concrete parser is supplied by codegen at each call site. Sketch:

```java
private <T> T execute(String method, String path, String body, String tenantId,
                      Function<String, T> parser) { ... }

public ApplicationResponse retrieveApplicationWithId(String applicationId) {
  return execute("GET", "/api/application/" + encode(applicationId), null, null,
                 ApplicationResponse::fromJSON);
}

public ApplicationResponse createApplicationWithId(String applicationId, ApplicationRequest request) {
  return execute("POST", "/api/application/" + encode(applicationId), request.toJSON(), null,
                 ApplicationResponse::fromJSON);
}
```

Query-bearing methods assemble the query string from their params before calling `execute` (a small
`query(name, value, …)` helper that skips nulls and URL-encodes).

## Error handling — `FusionAuthException`

`public class FusionAuthException extends RuntimeException`, carrying:
- `int status` — the HTTP status (or `0` for a transport failure),
- `Errors errors` — the parsed error body, or `null` if the body was empty / not JSON-parseable,
- `String rawBody` — the unparsed response body for diagnostics.

Thrown on any non-2xx response. `IOException`/`InterruptedException` from `HttpClient` are caught and
re-thrown as `FusionAuthException` (status `0`) so callers handle a single exception type. The
message wraps runtime values in `[brackets]` per the project's error-message convention.

## Codegen approach

Operations are highly uniform, so a **deterministic generator** is preferred over agents. The
generator parses each operation into a structured record — `operationId`, HTTP method, path,
ordered path params, query params, header param, request-body type (or none), `200` response type —
and emits a templated method. All 322 methods are assembled (alphabetically by `operationId`) into
`FusionAuthClient.java` along with the hand-written constructors and helpers.

Validation: the extractor is checked on a sample of operations (no-body GET, path-param POST,
query-param GET, the header-param operation) before the full run. Any operation the parser cannot
fully classify is reported and handled explicitly — never silently dropped. A post-generation check
asserts the method count equals the operation count (322).

## Testing — integration against a live FusionAuth

Tests run against the local FusionAuth provided via Docker Compose + kickstart at
`http://localhost:9014`, API key `33052c8a-c283-4e96-9d2a-eb1215c69f8f-not-for-prod`. They verify
the client end-to-end (URL building, path/query encoding, auth header, body serialization, response
deserialization, error mapping). Representative cases:

1. **Simple authenticated GET:** `retrieveSystemConfiguration()` → 200, non-null response.
2. **Path-param GET against kickstart data:** `retrieveApplicationWithId("<known id>")` → asserts the
   application name. (Use the default FusionAuth application id present in every instance.)
3. **CRUD round-trip:** `createApplicationWithId(randomId, request)` → `retrieveApplicationWithId` →
   `updateApplicationWithId` → `deleteApplicationWithId`, asserting each step. Exercises
   POST/GET/PUT/DELETE and request-body serialization, then cleans up after itself.
4. **Error mapping:** `retrieveApplicationWithId("<nonexistent uuid>")` → expects a
   `FusionAuthException` with the server's status (e.g. 404).

Tests assume the local server is running; they are integration tests and will fail fast with a clear
message if `http://localhost:9014` is unreachable. A connectivity precheck (e.g. `/api/status`) gates
the suite.

## Out of scope (this phase)

- Asynchronous (`CompletableFuture`) variants.
- Retry/backoff, connection pooling tuning, or rate-limit handling.
- A Latte-native HTTP client (the `org.lattejava:http` module is server-only; the JDK client is used
  instead).
- Grouped/resource sub-clients (single `FusionAuthClient` chosen).
