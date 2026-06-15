# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

A FusionAuth API client library for Java 25, **generated clean-room from `src/main/openapi.yaml`** (the official FusionAuth OpenAPI spec, API version 1.67.0). Almost nothing under `src/main/java` is hand-written — it is generated from the spec. Treat `src/main/openapi.yaml` as the source of truth and do not reference any external/prior FusionAuth client. See `README.md` for the consumer-facing overview.

## Build & test

Built with **Latte** (`project.latte`), not Maven/Gradle. Requires **Java 25** on the PATH. Targets run via the `latte` CLI from the repo root:

- `latte build` — compile + JAR (runs the annotation processor; no tests)
- `latte test` — TestNG suite (depends on `build`)
- `latte test --test=FusionAuthClientTest` — run a single test class (the flag matches by class name)
- `latte clean` — remove `build/`
- `latte int` — local integration publish (depends on `test`)
- `latte release` — full release (depends on `clean` + `test`)
- `latte idea` — regenerate the IntelliJ `.iml`

The library's only dependency is the compile-time `org.lattejava:json` annotation processor. Consumers depend solely on `org.lattejava:fusionauth` — there is no runtime JSON dependency (see below).

### Integration tests need a live server

`FusionAuthClientTest` runs against a real FusionAuth at `http://localhost:9014`. A Docker Compose + kickstart setup lives in `src/main/fusionauth/`. The tests **self-skip** (TestNG `SkipException`) if the server is unreachable, so a green `latte test` with skips means the server wasn't running — start it to actually exercise the client. (Note: the TestNG plugin only discovers test classes whose names end in `Test`.)

## Architecture

Two layers, both generated from the spec:

1. **Domain models** — `org.lattejava.fusionauth.domain` (flat package, ~600 records + 89 enums + the polymorphic `IdentityProviderField` sealed hierarchy). Each model is a `record` with a nested fluent `Builder` and instance/static `toJSON()` / `toJSONBytes()` / `fromJSON(...)` / `fromJSONBytes(...)` convenience methods.
2. **HTTP client** — `org.lattejava.fusionauth.FusionAuthClient` (root package), a single class with one synchronous method per OpenAPI operation (322), built on the JDK `java.net.http.HttpClient`. Methods are named by the spec's `operationId`; params are ordered path → query → header (all `String`) → request body (a domain record); a method returns its `200` response record (or `void` for empty-body operations) and throws `FusionAuthException` (carrying `status`, parsed `Errors`, and `rawBody`) on any non-2xx or transport failure.

### Latte JSON processor — why there's no runtime JSON dependency

The `@JSON` annotation (and `@JSONField`, `@JSONTypeInfo`, `@JSONSubtype`, `@JSONCatchAll`) is **`SOURCE`-retention**. At compile time the processor generates a `<Type>JSON` companion into `org.lattejava.fusionauth.domain.internal` and the runtime helper set into the module's `.internal` package — **all emitted into this module**. So `module-info.java` declares `requires static org.lattejava.json` (compile-only) and exports both `...domain` and `...domain.internal`. The model `toJSON()`/`fromJSON()` methods and the client delegate to these generated companions directly (method references, never reflection).

### How the code is generated (regeneration workflow)

Generation tooling lives under `build/gen/` (gitignored) and is described in `docs/design/` and `docs/implementation/` (dated specs + plans — read these before regenerating):

- **Enums**: produced deterministically from the spec's `enum:` lists.
- **Records**: produced by parsing each schema and applying a fixed type-mapping rulebook (documented in the domain-models design doc). Key mappings: `$ref ZonedDateTime` → `Instant` + `@JSONField(instant = InstantFormat.EPOCH_MILLIS)` (FusionAuth sends epoch-millis); `LocalDate` → `LocalDate`; `Locale`/`ZoneId` → `String`; `uuid` → `UUID`; `int64` → `Long`; free-form `additionalProperties` objects → `Map<String, Object>`; component types are always boxed.
- **Client methods**: `build/gen/extract-ops.awk` turns the spec's `paths:` into a TSV manifest; `build/gen/gen-methods.awk` turns the manifest into the 322 client methods, injected between the `// ===== GENERATED METHODS START/END =====` markers in `FusionAuthClient.java` (the constructors and private `execute`/`executeVoid`/`send`/`query`/`encode`/`error` helpers around those markers are hand-written and are the contract the generator targets).

### Spec-vs-reality divergences

FusionAuth's published OpenAPI spec has known inaccuracies where a generated type must deliberately diverge from the spec to match the live API. The established example: `Errors.fieldErrors` is declared `type: array` in the spec but the API actually returns `Map<String, List<Error>>` (keyed by field path), so the record is typed that way. When a model doesn't match live responses, verify against the running server and prefer reality over the spec.

## Conventions

Authoritative code conventions live in `.claude/rules/` (auto-loaded for the files they target) — notably `code-conventions.md` (2-space indent / 4-space continuation, 120-col lines, **acronyms fully uppercase** e.g. `JSONWebKey`/`HTTPHeaders`, member ordering), `error-messages.md` (wrap runtime values in `[brackets]`), and `copyright.md` (every `.java` starts with the exact SPDX header). Don't duplicate or contradict these.

## Gotchas

- **Spurious `@JSON ... is not @JSON-annotated` errors** after a dependency/version bump come from a stale prior JAR on the build classpath (the `@JSON` annotation isn't in compiled `.class` files). Run `latte clean` then `latte build`.
- **`Error` name collision**: the domain type `org.lattejava.fusionauth.domain.Error` clashes with `java.lang.Error`. Inside the `domain` package it resolves by same-package; **anywhere else**, add an explicit `import org.lattejava.fusionauth.domain.Error;` (an explicit single-type import overrides the implicit `java.lang` import).
- **FusionAuth soft-deletes by default** — e.g. `deleteApplicationWithId` deactivates rather than removes; pass `hardDelete="true"` to get a 404 on a subsequent retrieve.
