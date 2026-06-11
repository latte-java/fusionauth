# FusionAuth HTTP Client Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Generate a synchronous `org.lattejava.fusionauth.FusionAuthClient` with one method per OpenAPI operation (322 total), built on the JDK `java.net.http.HttpClient`, (de)serializing via the Phase-1 domain records.

**Architecture:** A single `FusionAuthClient` class with hand-written constructors + private transport helpers, plus 322 deterministically-generated one-line methods. A validated awk extractor turns the spec's `paths:` into a flat TSV manifest; a validated awk generator turns the manifest into Java methods; the two are assembled into one source file. Errors throw `FusionAuthException`. Tested end-to-end against a live local FusionAuth.

**Tech Stack:** Java 25, JDK `java.net.http`, Latte build tool, TestNG, the Phase-1 `org.lattejava.fusionauth.domain` records (which expose `toJSON()`/`fromJSON(String)`).

**Validated facts (from prototyping during planning):**
- 322 operations: 132 POST, 83 GET, 38 PUT, 39 DELETE, 30 PATCH.
- 265 return a `200` `$ref` response type; **57 return no body → the method returns `void`**.
- 199 have a request body; all bodies are `application/json` with a `$ref` schema.
- Params: all names are valid Java identifiers **except** the one header param `X-FusionAuth-TenantId` → Java param `xFusionAuthTenantId` (wire header name unchanged).
- The error (`default`) body is usually `Errors` (sometimes `OAuthError` or absent) → parsed best-effort as `Errors`, nullable.
- Live test server: `http://localhost:9014`, API key `33052c8a-c283-4e96-9d2a-eb1215c69f8f-not-for-prod`, default application id `3c219e58-ed0e-4b18-ad48-f4f92793ae32`.

**File structure:**
- `src/main/java/module-info.java` — add `requires java.net.http;` + `exports org.lattejava.fusionauth;` (modify)
- `src/main/java/org/lattejava/fusionauth/FusionAuthException.java` — error type (create)
- `src/main/java/org/lattejava/fusionauth/FusionAuthClient.java` — the client (create; preamble hand-written, methods generated)
- `build/gen/extract-ops.awk`, `build/gen/gen-methods.awk` — generation tooling (create; gitignored)
- `src/test/java/org/lattejava/fusionauth/tests/FusionAuthClientIT.java` — integration tests (create)

---

## Task 1: Module wiring + `FusionAuthException` + client preamble + smoke test

Establishes the transport machinery with ONE hand-written method, verified against the live server before generating all 322.

**Files:**
- Modify: `src/main/java/module-info.java`
- Create: `src/main/java/org/lattejava/fusionauth/FusionAuthException.java`
- Create: `src/main/java/org/lattejava/fusionauth/FusionAuthClient.java`
- Create: `src/test/java/org/lattejava/fusionauth/tests/FusionAuthClientIT.java`

- [ ] **Step 1: Add to `module-info.java`** the two directives (keep existing exports). The file becomes:

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
module org.lattejava.fusionauth {
  requires java.net.http;
  requires static org.lattejava.json;

  exports org.lattejava.fusionauth;
  exports org.lattejava.fusionauth.domain;
  exports org.lattejava.fusionauth.domain.internal;
}
```

- [ ] **Step 2: Create `FusionAuthException.java`**

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth;

import org.lattejava.fusionauth.domain.Errors;

/**
 * Thrown when a FusionAuth API call returns a non-2xx status or the transport fails. {@link #status} is
 * the HTTP status (0 for a transport failure), {@link #errors} is the parsed error body (null when the
 * body was empty or not parseable as Errors), and {@link #rawBody} is the unparsed response body.
 */
public class FusionAuthException extends RuntimeException {
  public final Errors errors;
  public final int status;
  public final String rawBody;

  public FusionAuthException(int status, Errors errors, String rawBody, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
    this.errors = errors;
    this.rawBody = rawBody;
  }
}
```

- [ ] **Step 3: Create `FusionAuthClient.java`** with the preamble (fields, constructors, helpers) and ONE hand-written method for the smoke test:

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth;

import org.lattejava.fusionauth.domain.Errors;
import org.lattejava.fusionauth.domain.SystemConfigurationResponse;

import module java.base;
import module java.net.http;

/**
 * Synchronous FusionAuth API client. Construct with an API key and base URL, then call one method per
 * API operation. Non-2xx responses and transport failures throw {@link FusionAuthException}.
 */
public class FusionAuthClient {
  private final String apiKey;
  private final String baseURL;
  private final HttpClient httpClient;
  private final Duration timeout;

  public FusionAuthClient(String apiKey, String baseURL) {
    this(apiKey, baseURL, HttpClient.newHttpClient(), Duration.ofSeconds(30));
  }

  public FusionAuthClient(String apiKey, String baseURL, HttpClient httpClient, Duration timeout) {
    this.apiKey = apiKey;
    this.baseURL = baseURL.endsWith("/") ? baseURL.substring(0, baseURL.length() - 1) : baseURL;
    this.httpClient = httpClient;
    this.timeout = timeout;
  }

  // ===== GENERATED METHODS START =====
  public SystemConfigurationResponse retrieveSystemConfiguration() {
    return execute("GET", "/api/system-configuration", null, null, SystemConfigurationResponse::fromJSON);
  }
  // ===== GENERATED METHODS END =====

  private FusionAuthException error(HttpResponse<String> response) {
    String body = response.body();
    Errors errors = null;
    if (body != null && !body.isEmpty()) {
      try {
        errors = Errors.fromJSON(body);
      } catch (RuntimeException ignored) {
      }
    }
    return new FusionAuthException(response.statusCode(), errors, body,
        "FusionAuth request failed with status [" + response.statusCode() + "]", null);
  }

  private <T> T execute(String method, String path, String body, String tenantId, Function<String, T> parser) {
    HttpResponse<String> response = send(method, path, body, tenantId);
    if (response.statusCode() / 100 == 2) {
      String b = response.body();
      return (b == null || b.isEmpty()) ? null : parser.apply(b);
    }
    throw error(response);
  }

  private void executeVoid(String method, String path, String body, String tenantId) {
    HttpResponse<String> response = send(method, path, body, tenantId);
    if (response.statusCode() / 100 != 2) {
      throw error(response);
    }
  }

  private HttpResponse<String> send(String method, String path, String body, String tenantId) {
    try {
      HttpRequest.Builder builder = HttpRequest.newBuilder()
          .uri(URI.create(baseURL + path))
          .timeout(timeout)
          .header("Authorization", apiKey);
      if (tenantId != null) {
        builder.header("X-FusionAuth-TenantId", tenantId);
      }
      if (body != null) {
        builder.header("Content-Type", "application/json");
        builder.method(method, HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8));
      } else {
        builder.method(method, HttpRequest.BodyPublishers.noBody());
      }
      return httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      if (e instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
      throw new FusionAuthException(0, null, null,
          "Transport failure calling [" + method + " " + path + "]", e);
    }
  }

  private static String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8);
  }

  private static String query(String... nameValues) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i + 1 < nameValues.length; i += 2) {
      String value = nameValues[i + 1];
      if (value == null) {
        continue;
      }
      sb.append(sb.isEmpty() ? "?" : "&").append(nameValues[i]).append("=").append(encode(value));
    }
    return sb.toString();
  }
}
```

Note: the `execute`/`executeVoid`/`send`/`query`/`encode` helpers and `error` are the exact contract the generator targets — do not rename them. The `// GENERATED METHODS START/END` markers delimit where Task 3 injects the 322 methods.

- [ ] **Step 4: Create the integration test** `FusionAuthClientIT.java` (smoke):

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.tests;

import org.lattejava.fusionauth.FusionAuthClient;
import org.lattejava.fusionauth.domain.SystemConfigurationResponse;

import module java.base;
import module org.testng;

public class FusionAuthClientIT {
  private static final String API_KEY = "33052c8a-c283-4e96-9d2a-eb1215c69f8f-not-for-prod";
  private static final String BASE_URL = "http://localhost:9014";

  private FusionAuthClient client;

  @BeforeClass
  public void checkServer() throws Exception {
    HttpClient http = HttpClient.newHttpClient();
    try {
      HttpResponse<String> r = http.send(
          HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/api/status")).timeout(Duration.ofSeconds(3)).build(),
          HttpResponse.BodyHandlers.ofString());
      if (r.statusCode() != 200) {
        throw new SkipException("FusionAuth not healthy at " + BASE_URL + " (status " + r.statusCode() + ")");
      }
    } catch (IOException e) {
      throw new SkipException("FusionAuth not reachable at " + BASE_URL + "; start the local Docker Compose first");
    }
    client = new FusionAuthClient(API_KEY, BASE_URL);
  }

  @Test
  public void retrievesSystemConfiguration() {
    SystemConfigurationResponse response = client.retrieveSystemConfiguration();
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.systemConfiguration());
  }
}
```

If `SystemConfigurationResponse` has no `systemConfiguration()` accessor, read `build/gen/schemas/SystemConfigurationResponse.yaml` (or the generated record) and assert on a field it actually declares — do not invent one.

- [ ] **Step 5: Build + run the smoke test**

Run: `latte test --test=FusionAuthClientIT`
Expected: PASS (or SKIPPED with a clear message if the server is down — start it and re-run). If it fails to compile, fix the preamble; if it fails at runtime, inspect the thrown `FusionAuthException` (status/rawBody).

- [ ] **Step 6: Commit**

```bash
git add src/main/java/module-info.java src/main/java/org/lattejava/fusionauth/FusionAuthException.java src/main/java/org/lattejava/fusionauth/FusionAuthClient.java src/test/java/org/lattejava/fusionauth/tests/FusionAuthClientIT.java
git commit -m "Add FusionAuthClient transport machinery + smoke test"
```

---

## Task 2: Operation extractor + method generator (validated tooling)

Produces the manifest and the 322 Java methods. Both awk scripts below were prototyped during planning and produce correct output; reproduce them exactly.

**Files:**
- Create: `build/gen/extract-ops.awk`
- Create: `build/gen/gen-methods.awk`

- [ ] **Step 1: Create `build/gen/extract-ops.awk`** (emits TSV: `operationId \t METHOD \t path \t pathParams \t queryParams \t headerParams \t requestType \t responseType`)

```awk
function flush() {
  if (opId != "") {
    printf "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", opId, toupper(method), path, pp, qp, hp, reqType, respType
  }
  opId=""; method=""; pp=""; qp=""; hp=""; reqType=""; respType=""
  state=""; curParamIn=""; curParamName=""; resp_status=""
}
function addparam() {
  if (curParamName=="" || curParamIn=="") { curParamName=""; curParamIn=""; return }
  if (curParamIn=="path") pp = pp (pp==""?"":",") curParamName
  else if (curParamIn=="query") qp = qp (qp==""?"":",") curParamName
  else if (curParamIn=="header") hp = hp (hp==""?"":",") curParamName
  curParamName=""; curParamIn=""
}
BEGIN{ inpaths=0 }
/^paths:/ { inpaths=1; next }
!inpaths { next }
/^  "?\// { flush(); path=$0; sub(/^  /,"",path); sub(/:[ ]*$/,"",path); gsub(/"/,"",path); next }
/^    (get|post|put|patch|delete|head|options):/ { flush(); method=$0; sub(/^    /,"",method); sub(/:.*/,"",method); next }
/^      operationId:/ { addparam(); v=$0; sub(/^      operationId:[ ]*/,"",v); opId=v; next }
/^      parameters:/ { addparam(); state="params"; next }
/^      requestBody:/ { addparam(); state="reqbody"; next }
/^      responses:/ { addparam(); state="resp"; resp_status=""; next }
state=="params" && /^      - / { addparam();
  if ($0 ~ /name:/) { v=$0; sub(/.*name:[ ]*/,"",v); curParamName=v }
  if ($0 ~ /in:/)   { v=$0; sub(/.*in:[ ]*/,"",v); curParamIn=v }
  next }
state=="params" && /^        name:/ { v=$0; sub(/^        name:[ ]*/,"",v); curParamName=v; next }
state=="params" && /^        in:/   { v=$0; sub(/^        in:[ ]*/,"",v); curParamIn=v; next }
state=="reqbody" && /\$ref/ && reqType=="" { v=$0; sub(/.*schemas\//,"",v); gsub(/["]/,"",v); sub(/[ ]*$/,"",v); reqType=v; next }
state=="resp" && /^        '?[0-9a-zA-Z]+'?:/ { rs=$0; sub(/^        /,"",rs); sub(/:.*/,"",rs); gsub(/'/,"",rs); resp_status=rs; next }
state=="resp" && resp_status=="200" && /\$ref/ && respType=="" { v=$0; sub(/.*schemas\//,"",v); gsub(/["]/,"",v); sub(/[ ]*$/,"",v); respType=v; next }
END{ flush() }
```

- [ ] **Step 2: Create `build/gen/gen-methods.awk`** (emits one Java method per TSV line; lowercases the header-param name to `xFusionAuthTenantId`)

```awk
function jname(n) { gsub(/-/,"",n); return tolower(substr(n,1,1)) substr(n,2) }
function pathExpr(p,   tok, out, rest) {
  out = "\""; rest = p
  while (match(rest, /\{[a-zA-Z0-9_]+\}/)) {
    tok = substr(rest, RSTART+1, RLENGTH-2)
    out = out substr(rest, 1, RSTART-1) "\" + encode(" tok ") + \""
    rest = substr(rest, RSTART+RLENGTH)
  }
  out = out rest "\""
  gsub(/ \+ ""$/, "", out)
  gsub(/^"" \+ /, "", out)
  return out
}
BEGIN{ FS="\t" }
{
  opId=$1; method=$2; path=$3; pp=$4; qp=$5; hp=$6; reqType=$7; respType=$8
  params=""; np=0
  n=split(pp, parr, ","); for(i=1;i<=n;i++) if(parr[i]!=""){ params=params (np++? ", ":"") "String " parr[i] }
  n=split(qp, qarr, ","); for(i=1;i<=n;i++) if(qarr[i]!=""){ params=params (np++? ", ":"") "String " qarr[i] }
  hparam=""
  if (hp!="") { hparam=jname(hp); params=params (np++? ", ":"") "String " hparam }
  if (reqType!="") { params=params (np++? ", ":"") reqType " request" }
  pe = pathExpr(path)
  qe = ""; m=0; qpairs=""
  n=split(qp, qarr, ","); for(i=1;i<=n;i++) if(qarr[i]!=""){ qpairs=qpairs (m++? ", ":"") "\"" qarr[i] "\", " qarr[i] }
  if (m>0) qe = " + query(" qpairs ")"
  tenantArg = (hp!="") ? hparam : "null"
  bodyArg = (reqType!="") ? "request.toJSON()" : "null"
  printf "  public %s %s(%s) {\n", (respType!=""?respType:"void"), opId, params
  if (respType!="")
    printf "    return execute(\"%s\", %s%s, %s, %s, %s::fromJSON);\n", method, pe, qe, bodyArg, tenantArg, respType
  else
    printf "    executeVoid(\"%s\", %s%s, %s, %s);\n", method, pe, qe, bodyArg, tenantArg
  printf "  }\n\n"
}
```

- [ ] **Step 3: Run the extractor and validate the manifest**

Run:
```bash
cd /Users/bpontarelli/dev/latte-java/fusionauth
mkdir -p build/gen
awk -f build/gen/extract-ops.awk src/main/openapi.yaml > build/gen/operations.tsv
echo "ops: $(wc -l < build/gen/operations.tsv)"
echo "missing opId/method/path: $(awk -F'\t' '$1==""||$2==""||$3==""' build/gen/operations.tsv | wc -l)"
echo "void (no response type): $(awk -F'\t' '$8==""' build/gen/operations.tsv | wc -l)"
```
Expected: `ops: 322`, `missing: 0`, `void: 57`. If any differ, the spec changed — inspect before continuing.

- [ ] **Step 4: Generate the methods and validate the count**

Run:
```bash
awk -f build/gen/gen-methods.awk build/gen/operations.tsv > build/gen/methods.txt
echo "methods: $(grep -c '^  public ' build/gen/methods.txt)"
```
Expected: `methods: 322`.

(No commit — `build/` is gitignored. The committed artifact is the assembled `FusionAuthClient.java` in Task 3.)

---

## Task 3: Assemble and compile the full `FusionAuthClient`

Replaces the single smoke-test method with all 322 generated methods.

**Files:**
- Modify: `src/main/java/org/lattejava/fusionauth/FusionAuthClient.java`

- [ ] **Step 1: Inject the generated methods** between the markers. Run a script that replaces everything between `// ===== GENERATED METHODS START =====` and `// ===== GENERATED METHODS END =====` with `build/gen/methods.txt`:

```bash
cd /Users/bpontarelli/dev/latte-java/fusionauth
f=src/main/java/org/lattejava/fusionauth/FusionAuthClient.java
awk '
  /GENERATED METHODS START/ { print; while ((getline line < "build/gen/methods.txt") > 0) print line; skip=1; next }
  /GENERATED METHODS END/ { skip=0 }
  !skip { print }
' "$f" > "$f.new" && mv "$f.new" "$f"
echo "public members now: $(grep -cE '^  public ' "$f")"
```
Expected: `public members now: 324` — the 322 generated public methods plus the 2 public constructors. (The smoke-test `retrieveSystemConfiguration` is one of the 322 and is replaced by its generated equivalent.) So generated methods = 324 − 2 = 322.

- [ ] **Step 2: Add required imports.** The generated methods reference ~360 distinct domain request/response types. Add a single wildcard import so the file compiles without listing each:

Replace the specific domain imports in the preamble:
```java
import org.lattejava.fusionauth.domain.Errors;
import org.lattejava.fusionauth.domain.SystemConfigurationResponse;
```
with:
```java
import org.lattejava.fusionauth.domain.Errors;

import org.lattejava.fusionauth.domain.*;
```
(`Errors` is referenced in the `error()` helper; the wildcard covers every generated request/response type. Same-module package, so no `requires` needed.)

- [ ] **Step 3: Compile gate**

Run: `latte build`
Expected: BUILD SUCCESS. Likely failure modes and fixes:
  - **`cannot find symbol` for a type** → a response/request schema wasn't generated in Phase 1, or the type name differs; verify the type exists in `org.lattejava.fusionauth.domain`.
  - **duplicate method / duplicate variable** → an operation has a path param and query param of the same name (Java param collision). Find it (`awk -F'\t' '...'`) and disambiguate in the generator (suffix the query param) — then regenerate and re-inject.
  - **`fromJSON`/`toJSON` not found on a type** → that domain type lacks the convenience methods; confirm Phase-1 rollout covered it.

- [ ] **Step 4: Commit**

```bash
git add src/main/java/org/lattejava/fusionauth/FusionAuthClient.java
git commit -m "Generate all 322 FusionAuthClient methods from the OpenAPI spec"
```

---

## Task 4: Integration test suite against live FusionAuth

Verifies the machinery end-to-end: GET, path/query params, request-body serialization (POST/PUT), DELETE (void), and error mapping.

**Files:**
- Modify: `src/test/java/org/lattejava/fusionauth/tests/FusionAuthClientIT.java`

- [ ] **Step 1: Add a retrieve-against-kickstart test.** The default application id `3c219e58-ed0e-4b18-ad48-f4f92793ae32` exists in every FusionAuth instance.

```java
  @Test
  public void retrievesDefaultApplicationById() {
    ApplicationResponse response = client.retrieveApplicationWithId("3c219e58-ed0e-4b18-ad48-f4f92793ae32", null, null);
    Assert.assertNotNull(response.application());
    Assert.assertNotNull(response.application().name());
  }
```
Add `import org.lattejava.fusionauth.domain.ApplicationResponse;` and `import org.lattejava.fusionauth.domain.Application;` (or a wildcard `import org.lattejava.fusionauth.domain.*;`). Verify `ApplicationResponse.application()` exists by reading the record; adjust if the accessor name differs.

- [ ] **Step 2: Add a CRUD round-trip test** (creates a unique application, retrieves, updates, deletes — self-cleaning):

```java
  @Test
  public void applicationCrudRoundTrip() {
    String id = UUID.randomUUID().toString();
    Application app = Application.builder().name("IT-" + id).build();

    ApplicationResponse created = client.createApplicationWithId(id, null, ApplicationRequest.builder().application(app).build());
    Assert.assertEquals(created.application().name(), "IT-" + id);

    ApplicationResponse fetched = client.retrieveApplicationWithId(id, null, null);
    Assert.assertEquals(fetched.application().id(), id);

    Application renamed = Application.builder().name("IT-renamed-" + id).build();
    ApplicationResponse updated = client.updateApplicationWithId(id, null, ApplicationRequest.builder().application(renamed).build());
    Assert.assertEquals(updated.application().name(), "IT-renamed-" + id);

    client.deleteApplicationWithId(id, null, null);  // returns void

    try {
      client.retrieveApplicationWithId(id, null, null);
      Assert.fail("expected FusionAuthException after delete");
    } catch (FusionAuthException expected) {
      Assert.assertEquals(expected.status, 404);
    }
  }
```
Read the actual signatures of `createApplicationWithId`, `updateApplicationWithId`, `deleteApplicationWithId`, and `retrieveApplicationWithId` in the generated `FusionAuthClient.java` and match the argument order/count exactly (path id, then any query/header params as `null`, then the request body). Read `ApplicationRequest`/`Application`/`ApplicationResponse` records to confirm `application()`/`id()`/`name()` accessors and the `ApplicationRequest.application(...)` builder; adjust names if they differ.

- [ ] **Step 3: Add an explicit error-mapping test:**

```java
  @Test
  public void throwsOnMissingApplication() {
    try {
      client.retrieveApplicationWithId("00000000-0000-0000-0000-0000000000ff", null, null);
      Assert.fail("expected FusionAuthException");
    } catch (FusionAuthException e) {
      Assert.assertEquals(e.status, 404);
    }
  }
```

- [ ] **Step 4: Run the suite**

Run: `latte test --test=FusionAuthClientIT`
Expected: all tests PASS (or SKIPPED if the server is down). Investigate any thrown `FusionAuthException` via its `status`/`rawBody`.

- [ ] **Step 5: Commit**

```bash
git add src/test/java/org/lattejava/fusionauth/tests/FusionAuthClientIT.java
git commit -m "Add FusionAuthClient integration tests against live FusionAuth"
```

---

## Task 5: Final verification

- [ ] **Step 1: Method-count sanity check**

Run: `grep -cE '^  public ' src/main/java/org/lattejava/fusionauth/FusionAuthClient.java`
Expected: `324` (322 generated operation methods + 2 public constructors).

- [ ] **Step 2: Full build + test**

Run: `latte test`
Expected: BUILD SUCCESS; all suites pass (Phase-1 model round-trip tests + Phase-2 integration tests).

- [ ] **Step 3: Confirm clean tree**

Run: `git status --short`
Expected: empty (all work committed; `build/` gitignored).

---

## Done criteria

- `FusionAuthClient` exposes 322 public methods (one per operation), compiling against the Phase-1 domain records with no reflection (concrete `request.toJSON()` and `Type::fromJSON` method references).
- `latte build` clean; integration tests pass against the live FusionAuth at `localhost:9014` (retrieve, CRUD round-trip, void delete, 404 → `FusionAuthException`).
- Out of scope (future): async variants, retries, grouped sub-clients, a Latte-native HTTP transport.
