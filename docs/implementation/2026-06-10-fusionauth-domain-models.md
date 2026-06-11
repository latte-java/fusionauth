# FusionAuth Domain Models Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Generate a Latte-JSON record (or enum, or sealed interface) for every one of the 601 object schemas, 89 enums, and the 1 polymorphic hierarchy in the FusionAuth OpenAPI spec, clean-room from `src/main/openapi.yaml` (no reference to any prior/external client), under `org.lattejava.fusionauth.domain`, compiling cleanly with the `org.lattejava:json` annotation processor.

**Architecture:** Records with hand-written nested `Builder`s, `@JSON`-annotated, in a flat package. Three reference models are hand-written and compile-verified first to lock every codegen pattern (plain record, polymorphism, enum); then a multi-agent Workflow fans out the remaining ~690 schemas in disjoint file batches following a fixed type-mapping rulebook; a final `latte build` compile gate plus a round-trip TestNG suite verify the set.

**Tech Stack:** Java 25 (records, module imports), Latte build tool, `org.lattejava:json:0.2.0` (compile-time annotation processor; companions emitted into `<package>.internal`, no runtime dependency), TestNG.

**Spec facts (verified):**
- `components.schemas` holds **691** top-level schemas; the block ends just before `securitySchemes:` (line **10305**), and `paths:` begins at **10314**. All extraction is scoped to the schemas block (stop before `securitySchemes` so the `ApiKeyAuth` security scheme is not miscounted).
- **691** total schemas = **601** records + **89** enums + the **1** `ZonedDateTime` alias (not emitted). One polymorphic union: `IdentityProviderField`, 16 subtypes.
- No anonymous inline objects, no inline enums, no reserved-word property names, no `allOf`.

**Type-mapping rulebook (authoritative — every generator step and agent uses this verbatim):**

| OpenAPI construct | Java type |
|---|---|
| `$ref` → `ZonedDateTime` | `Instant` + `@JSONField(instant = InstantFormat.EPOCH_MILLIS)` |
| `$ref` → an enum schema (see enum-name list) | that enum type |
| `$ref` → `IdentityProviderField` | the `IdentityProviderField` sealed interface |
| `$ref` → any other object schema | that record type |
| `string` + `format: uuid`/`UUID` | `UUID` |
| `string` + `format: URI` | `String` |
| `string` + `format: binary` | `String` |
| `string` (no format) | `String` |
| `integer` + `format: int64` | `Long` |
| `integer` (no format) | `Integer` |
| `number` (incl. `format: double`) | `Double` |
| `boolean` | `Boolean` |
| `array` + `uniqueItems: true`, typed `items` | `Set<T>` |
| `array`, typed `items` | `List<T>` |
| `array` with `items: {}` (no element schema) | element type `String` (→ `Set<String>` / `List<String>`) |
| `object`, no `properties`, no `additionalProperties` (free-form) | `Map<String, Object>` |
| `object` + `additionalProperties: {type: object}` | `Map<String, Object>` |
| `object` + `additionalProperties: {type: string}` | `Map<String, String>` |
| `object` + `additionalProperties: {type: array, ...}` | `Map<String, Object>` (free-form; values are arrays at runtime) |
| `object` + `additionalProperties: {$ref: X}` (X object/enum) | `Map<String, X>` |

**Latte JSON `0.3.0` support:** `Map<String, Object>` (dynamic maps of arbitrary JSON values) IS supported; a bare `Object` field, `List<Object>`/`Set<Object>`, and `Map<String, Set/List<…>>` (nested collection as a map value) are NOT. FusionAuth needs only `Map<String, Object>` for free-form data.

All record components use **boxed/reference types** (never primitives). `@JSON` uses defaults (`naming = IDENTITY`, `omitNulls = true`, `strict = false`). Field names mirror JSON keys exactly (including `client_id`, `client_secret`).

---

## Task 1: Project skeleton + module-info + first enum

**Files:**
- Create: `src/main/java/module-info.java`
- Create: `src/main/java/org/lattejava/fusionauth/domain/Algorithm.java`

- [ ] **Step 1: Create `module-info.java`**

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
module org.lattejava.fusionauth {
  exports org.lattejava.fusionauth.domain;
  exports org.lattejava.fusionauth.domain.internal;
}
```

Notes: The processor emits each companion into `<package>.internal` (i.e. `org.lattejava.fusionauth.domain.internal`) and the runtime helper set into the module's `.internal` package — both are generated **into this module**, so there is no `requires org.lattejava.json`. `org.lattejava.json` is a `compile-processors` dependency only (already in `project.latte`). Exporting `...domain.internal` makes the generated `XxxJSON.toJSON/fromJSON` entry points callable. If `latte build` later reports the helper set landed in a different `.internal` package, add an `exports` for it then.

- [ ] **Step 2: Create the `Algorithm` enum**

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum Algorithm {
  ES256,
  ES384,
  ES512,
  HS256,
  HS384,
  HS512,
  PS256,
  PS384,
  PS512,
  RS256,
  RS384,
  RS512,
  none
}
```

Verify the constant list against the spec before committing:

Run: `awk '/^    Algorithm:/{f=1} f&&/enum:/{e=1;next} e&&/^      - /{print} e&&/^    [A-Za-z]/{exit}' src/main/openapi.yaml`
Expected: the lines `- ES256` … through the last constant. Reconcile any difference (the block above is from the current spec; trust the spec if it differs).

- [ ] **Step 3: Build**

Run: `latte build`
Expected: BUILD SUCCESS. (A bare enum needs no companion; this verifies the module + toolchain compile.)

- [ ] **Step 4: Commit**

```bash
git add src/main/java/module-info.java src/main/java/org/lattejava/fusionauth/domain/Algorithm.java
git commit -m "Add module-info and first enum (Algorithm)"
```

---

## Task 2: Reference plain records + round-trip test (locks the record/builder + Map/Set/UUID/Instant patterns)

**Files:**
- Create: `src/main/java/org/lattejava/fusionauth/domain/APIKeyMetaData.java`
- Create: `src/main/java/org/lattejava/fusionauth/domain/APIKeyPermissions.java`
- Create: `src/main/java/org/lattejava/fusionauth/domain/APIKey.java`
- Create: `src/test/java/module-info.java`
- Create: `src/test/java/org/lattejava/fusionauth/domain/APIKeyRoundTripTest.java`

- [ ] **Step 1: Create `APIKeyMetaData`** (Map<String,String>)

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

@JSON
public record APIKeyMetaData(Map<String, String> attributes) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Map<String, String> attributes;

    public Builder attributes(Map<String, String> attributes) {
      this.attributes = attributes;
      return this;
    }

    public APIKeyMetaData build() {
      return new APIKeyMetaData(attributes);
    }
  }
}
```

- [ ] **Step 2: Create `APIKeyPermissions`** (Map<String, Set<Object>> — `endpoints` is `additionalProperties: {type: array, uniqueItems: true, items: {}}`)

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

@JSON
public record APIKeyPermissions(Map<String, Set<Object>> endpoints) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Map<String, Set<Object>> endpoints;

    public Builder endpoints(Map<String, Set<Object>> endpoints) {
      this.endpoints = endpoints;
      return this;
    }

    public APIKeyPermissions build() {
      return new APIKeyPermissions(endpoints);
    }
  }
}
```

- [ ] **Step 3: Create `APIKey`** (exercises UUID, Instant/EPOCH_MILLIS, nested record refs, Boolean, String)

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

@JSON
public record APIKey(
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expirationInstant,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    UUID ipAccessControlListId,
    String key,
    Boolean keyManager,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    APIKeyMetaData metaData,
    String name,
    APIKeyPermissions permissions,
    Boolean retrievable,
    UUID tenantId) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Instant expirationInstant;
    private UUID id;
    private Instant insertInstant;
    private UUID ipAccessControlListId;
    private String key;
    private Boolean keyManager;
    private Instant lastUpdateInstant;
    private APIKeyMetaData metaData;
    private String name;
    private APIKeyPermissions permissions;
    private Boolean retrievable;
    private UUID tenantId;

    public Builder expirationInstant(Instant expirationInstant) { this.expirationInstant = expirationInstant; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder ipAccessControlListId(UUID ipAccessControlListId) { this.ipAccessControlListId = ipAccessControlListId; return this; }
    public Builder key(String key) { this.key = key; return this; }
    public Builder keyManager(Boolean keyManager) { this.keyManager = keyManager; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder metaData(APIKeyMetaData metaData) { this.metaData = metaData; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder permissions(APIKeyPermissions permissions) { this.permissions = permissions; return this; }
    public Builder retrievable(Boolean retrievable) { this.retrievable = retrievable; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }

    public APIKey build() {
      return new APIKey(expirationInstant, id, insertInstant, ipAccessControlListId, key, keyManager,
          lastUpdateInstant, metaData, name, permissions, retrievable, tenantId);
    }
  }
}
```

Before continuing, confirm these field lists match the spec:

Run: `awk '/^    APIKey:/{f=1} f{print} f&&/^    APIKeyMetaData:/{exit}' src/main/openapi.yaml`
Expected: properties `expirationInstant, id, insertInstant, ipAccessControlListId, key, keyManager, lastUpdateInstant, metaData, name, permissions, retrievable, tenantId`. Reconcile if the spec differs.

- [ ] **Step 4: Create test `module-info.java`**

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
module org.lattejava.fusionauth.tests {
  requires org.lattejava.fusionauth;
  requires org.testng;

  opens org.lattejava.fusionauth.domain to org.testng;
}
```

- [ ] **Step 5: Write the round-trip test (expected to FAIL to compile until companions exist)**

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import org.lattejava.fusionauth.domain.internal.APIKeyJSON;

import module java.base;
import module org.testng;

public class APIKeyRoundTripTest {
  @Test
  public void roundTrip() {
    APIKey key = APIKey.builder()
        .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
        .name("test-key")
        .keyManager(Boolean.TRUE)
        .insertInstant(Instant.ofEpochMilli(1_659_380_719_000L))
        .metaData(APIKeyMetaData.builder().attributes(Map.of("a", "b")).build())
        .build();

    byte[] json = APIKeyJSON.toJSON(key).getBytes(StandardCharsets.UTF_8);
    APIKey parsed = APIKeyJSON.fromJSON(json);

    Assert.assertEquals(parsed.id(), key.id());
    Assert.assertEquals(parsed.name(), key.name());
    Assert.assertEquals(parsed.keyManager(), Boolean.TRUE);
    Assert.assertEquals(parsed.insertInstant(), Instant.ofEpochMilli(1_659_380_719_000L));
    Assert.assertEquals(parsed.metaData().attributes(), Map.of("a", "b"));
  }
}
```

Note: the static companion API is `String toJSON(T)` and `T fromJSON(byte[])` / `T fromJSON(String)` (confirmed in the generated `*JSON` sources). If the generated signature differs, adapt the call sites — do not change the record.

- [ ] **Step 6: Build + test**

Run: `latte test --test=APIKeyRoundTripTest`
Expected: PASS. If the `org.lattejava.fusionauth.domain.internal` import fails to resolve, the companion package export in `module-info` is wrong — fix Step 1's `exports` to match the actual generated package, then re-run.

- [ ] **Step 7: Commit**

```bash
git add src/main/java/org/lattejava/fusionauth/domain/APIKey.java src/main/java/org/lattejava/fusionauth/domain/APIKeyMetaData.java src/main/java/org/lattejava/fusionauth/domain/APIKeyPermissions.java src/test/java/module-info.java src/test/java/org/lattejava/fusionauth/domain/APIKeyRoundTripTest.java
git commit -m "Add APIKey reference records and round-trip test"
```

---

## Task 3: Polymorphism reference — `IdentityProviderField` + one subtype + polymorphic round-trip

This locks the sealed-interface + `@JSONSubtype` pattern before the bulk run. Only the interface and **one** subtype (`AppleIdentityProvider`) are hand-written here; the other 15 subtypes are produced by the Workflow (Task 5) using the same pattern.

**Files:**
- Create: `src/main/java/org/lattejava/fusionauth/domain/IdentityProviderField.java`
- Create: `src/main/java/org/lattejava/fusionauth/domain/AppleIdentityProvider.java`
- Create: `src/test/java/org/lattejava/fusionauth/domain/IdentityProviderRoundTripTest.java`

- [ ] **Step 1: Create the sealed interface**

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module org.lattejava.json;

@JSON
@JSONTypeInfo(property = "type")
public sealed interface IdentityProviderField
    permits AppleIdentityProvider, EpicGamesIdentityProvider, ExternalJWTIdentityProvider,
            FacebookIdentityProvider, GoogleIdentityProvider, HYPRIdentityProvider,
            LinkedInIdentityProvider, NintendoIdentityProvider, OpenIdConnectIdentityProvider,
            SAMLv2IdPInitiatedIdentityProvider, SAMLv2IdentityProvider, SonyPSNIdentityProvider,
            SteamIdentityProvider, TwitchIdentityProvider, TwitterIdentityProvider,
            XboxIdentityProvider {
}
```

Note: a `sealed ... permits` clause requires **all** permitted types to exist at compile time. So `IdentityProviderField` cannot compile until all 16 subtypes exist. Therefore: hand-write `AppleIdentityProvider` here, and for this task only, **temporarily** generate the other 15 as part of this task (they are part of the Workflow's identity-provider batch in Task 5; pull that batch forward). Simplest sequencing: run Task 5's identity-provider batch first (it produces all 16 subtypes), then this interface compiles. If executing strictly in order, create the 15 remaining subtypes as empty-but-correct records now via the same agent prompt scoped to just those schemas.

- [ ] **Step 2: Create `AppleIdentityProvider`** — record implementing the interface, `@JSONSubtype("Apple")`, with the `type` discriminator property **dropped**.

First read the schema to get its exact fields:

Run: `awk '/^    AppleIdentityProvider:/{f=1} f{print} f&&/^    [A-Z]/&&!/AppleIdentityProvider:/{exit}' src/main/openapi.yaml`

Then write the record from those fields, applying the rulebook, omitting the `type` property:

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

@JSON
@JSONSubtype("Apple")
public record AppleIdentityProvider(
    // ... fields from the spec, EXCEPT `type`, each mapped per the rulebook,
    //     e.g. UUID id, Map<String, Object> data, Boolean enabled, String keyId,
    //          Map<String, AppleApplicationConfiguration> applicationConfiguration, ...
    ) implements IdentityProviderField {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    // one private field + fluent setter per component, then build()
  }
}
```

(The `applicationConfiguration` field on identity providers is `object` + `additionalProperties: {$ref: <X>ApplicationConfiguration}` → `Map<String, XApplicationConfiguration>`; `tenantConfiguration` → `Map<String, IdentityProviderTenantConfiguration>`. Generate those referenced config records as part of Task 5 — they are ordinary schemas.)

- [ ] **Step 3: Write the polymorphic round-trip test**

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import org.lattejava.fusionauth.domain.internal.IdentityProviderFieldJSON;

import module java.base;
import module org.testng;

public class IdentityProviderRoundTripTest {
  @Test
  public void appleRoundTrips() {
    AppleIdentityProvider apple = AppleIdentityProvider.builder()
        .enabled(Boolean.TRUE)
        .build();

    String json = IdentityProviderFieldJSON.toJSON(apple);
    Assert.assertTrue(json.contains("\"type\":\"Apple\""), "discriminator written: " + json);

    IdentityProviderField parsed = IdentityProviderFieldJSON.fromJSON(json);
    Assert.assertTrue(parsed instanceof AppleIdentityProvider);
  }
}
```

Adjust the builder calls to whatever fields `AppleIdentityProvider` actually has (use a Boolean/`enabled` field if present; otherwise pick any present field). The two assertions — discriminator emitted as `"type":"Apple"`, and deserialization resolves back to `AppleIdentityProvider` — are the contract that matters.

- [ ] **Step 4: Build + test**

Run: `latte test --test=IdentityProviderRoundTripTest`
Expected: PASS. This proves the `@JSONTypeInfo`/`@JSONSubtype` codegen round-trips with the discriminator dropped from the component list.

- [ ] **Step 5: Commit**

```bash
git add src/main/java/org/lattejava/fusionauth/domain/IdentityProviderField.java src/main/java/org/lattejava/fusionauth/domain/*IdentityProvider.java src/test/java/org/lattejava/fusionauth/domain/IdentityProviderRoundTripTest.java
git commit -m "Add IdentityProviderField polymorphic hierarchy and round-trip test"
```

---

## Task 4: Extract the generation manifest (enum names + record names)

Produces the two inputs the Workflow needs: the **enum-name set** (so agents map `$ref → enum` vs `$ref → record`) and the **ordered list of every schema to generate**. No code is written; these feed Task 5.

**Files:**
- Create: `build/gen/enum-names.txt`
- Create: `build/gen/all-schema-names.txt`
- Create: `build/gen/record-names.txt`

- [ ] **Step 1: Extract enum names** (a schema is an enum iff it has an `enum:` key directly under it)

Run:
```bash
mkdir -p build/gen
# Schemas block ends just before the securitySchemes: key — bound extraction there.
sec=$(grep -n '^  securitySchemes:' src/main/openapi.yaml | head -1 | cut -d: -f1)
awk -v sec="$sec" 'NR<sec' src/main/openapi.yaml \
 | awk '/^    [A-Za-z]/{name=$0; sub(/:.*/,"",name); sub(/^ +/,"",name)} /^      enum:/{print name}' \
 | sort -u > build/gen/enum-names.txt
wc -l build/gen/enum-names.txt
```
Expected: `89 build/gen/enum-names.txt`.

- [ ] **Step 2: Extract all schema names** (scoped to `components.schemas`, stopping before `securitySchemes`)

Run:
```bash
sec=$(grep -n '^  securitySchemes:' src/main/openapi.yaml | head -1 | cut -d: -f1)
awk -v sec="$sec" 'NR<sec' src/main/openapi.yaml \
 | awk '/^  schemas:/{f=1;next} f&&/^    [A-Za-z]/{name=$0; sub(/:.*/,"",name); sub(/^ +/,"",name); print name}' \
 | sort -u > build/gen/all-schema-names.txt
wc -l build/gen/all-schema-names.txt
```
Expected: `691` (601 records + 89 enums + the `ZonedDateTime` alias) — confirm the number.

- [ ] **Step 3: Derive the record-name list** (all schemas, minus enums, minus the `ZonedDateTime` alias)

Run:
```bash
comm -23 build/gen/all-schema-names.txt build/gen/enum-names.txt | grep -vx 'ZonedDateTime' > build/gen/record-names.txt
wc -l build/gen/record-names.txt
```
Expected: `601` (691 total − 89 enums − the `ZonedDateTime` alias). Confirm.

- [ ] **Step 4: Sanity-check the already-written models are in the list** and will be skipped by the Workflow

Run: `grep -E '^(APIKey|APIKeyMetaData|APIKeyPermissions|AppleIdentityProvider|IdentityProviderField)$' build/gen/record-names.txt`
Expected: those names print (the Workflow prompt in Task 5 skips any file that already exists).

- [ ] **Step 5: Commit the manifest**

```bash
git add build/gen/enum-names.txt build/gen/all-schema-names.txt build/gen/record-names.txt
git commit -m "Add generation manifest (enum + record name lists)"
```

---

## Task 5: Bulk generation via multi-agent Workflow

Fans out every remaining enum and record across parallel agents. Each agent reads `src/main/openapi.yaml` directly for its assigned schemas, applies the rulebook, and writes one `.java` file per schema into the domain package. Batches are disjoint sets of files, so parallel agents never touch the same file (no worktree isolation needed).

**Files:**
- Create: `docs/superpowers/workflows/generate-models.workflow.js` (saved by the Workflow tool on first run; iterate via `scriptPath`)
- Create: ~690 files under `src/main/java/org/lattejava/fusionauth/domain/`

- [ ] **Step 1: Paste the extracted name lists into the Workflow script.** Read `build/gen/enum-names.txt` and `build/gen/record-names.txt` and inline them as the `ENUMS` and `RECORDS` JS arrays in the script below (the lists are the deterministic output of Task 4). Also inline the 16-row `IDP_SUBTYPES` map from the design doc's discriminator table.

- [ ] **Step 2: Run the Workflow** with this script (the rulebook is embedded in `RULES` so every agent is identical):

```javascript
export const meta = {
  name: 'generate-fusionauth-models',
  description: 'Generate Latte-JSON records/enums for all FusionAuth schemas',
  phases: [{ title: 'Enums' }, { title: 'Records' }],
}

const DIR = 'src/main/java/org/lattejava/fusionauth/domain'
const SPEC = 'src/main/openapi.yaml'

// Paste from build/gen/enum-names.txt:
const ENUMS = [ /* "Algorithm", "AttestationType", ... */ ]
// Paste from build/gen/record-names.txt:
const RECORDS = [ /* "AccessToken", "ActionData", ... */ ]
// 16 polymorphic subtypes → discriminator value (design-doc table):
const IDP_SUBTYPES = { AppleIdentityProvider: 'Apple', EpicGamesIdentityProvider: 'EpicGames', /* ...all 16... */ }

const RULES = `
You generate Java 25 source for the Latte JSON library. Package: org.lattejava.fusionauth.domain.
Read the schema(s) from ${SPEC} (component schemas are between lines 17 and 10313; find each by its
'    <Name>:' header at 4-space indent). For EACH assigned schema write exactly one file
${DIR}/<Name>.java. If the file already exists, SKIP it (do not overwrite).

File header (verbatim):
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

ENUMS: a schema with an 'enum:' list → a plain Java enum (NO @JSON, NO java.base import needed).
Constants verbatim from the spec, in spec order. Example:
public enum Foo { A, B, none }

RECORDS: every other schema → a record annotated @JSON with a nested Builder.
- @JSON with no attributes (defaults: naming=IDENTITY, omitNulls=true).
- One record component per property, IN SPEC ORDER, field name == JSON key EXACTLY.
- All component types are BOXED/reference types (never primitives).
- Builder: 'public static Builder builder()' + 'public static final class Builder' with one private
  field and one fluent setter (returns this) per component, and 'build()' calling the canonical ctor.

TYPE MAPPING (apply to every property and array element):
- \$ref ZonedDateTime  -> Instant, and annotate the component '@JSONField(instant = InstantFormat.EPOCH_MILLIS)'
- \$ref to an ENUM (one of: ${'${ENUMS_CSV}'}) -> that enum type
- \$ref IdentityProviderField -> IdentityProviderField
- \$ref to anything else -> that type name
- string + format uuid/UUID -> UUID
- string + format URI -> String
- string + format binary -> String
- string (no format) -> String
- integer + format int64 -> Long
- integer (no format) -> Integer
- number (any) -> Double
- boolean -> Boolean
- array + 'uniqueItems: true' with a typed 'items' -> Set<ELEM>
- array (otherwise) with a typed 'items' -> List<ELEM>
- array whose items is '{}' (empty schema, no type) -> ELEM is String (Set<String> if uniqueItems else List<String>)
- object with NO 'properties' and NO 'additionalProperties' (free-form object) -> Map<String,Object>
- object + additionalProperties {type:object} -> Map<String,Object>
- object + additionalProperties {type:string} -> Map<String,String>
- object + additionalProperties {type:array,...} -> Map<String,Object>   (free-form: the map VALUES are arrays at runtime; Map<String,Set/List<X>> is NOT supported)
- object + additionalProperties {\$ref:X} where X is an object or enum -> Map<String,X>
NOTE: Latte JSON supports Map<String,Object> (arbitrary JSON values) but NOT a bare Object field, NOT List<Object>/Set<Object>, and NOT nested collections as a Map value. Never emit Object except as the value type of a Map<String,Object>.

POLYMORPHIC SUBTYPES: if the schema name is one of these 16, it is a subtype of IdentityProviderField.
Add 'implements IdentityProviderField', annotate '@JSONSubtype("<value>")' using this map, and DROP the
'type' property from the components (it is written by the discriminator, not a field):
${'${IDP_JSON}'}

Write valid, compiling Java. Do not invent fields. Do not add javadoc. Return a one-line summary
listing the files you wrote and any you skipped.
`

const ENUMS_CSV = ENUMS.join(', ')
const IDP_JSON = JSON.stringify(IDP_SUBTYPES)
const rules = RULES.replace('${ENUMS_CSV}', ENUMS_CSV).replace('${IDP_JSON}', IDP_JSON)

function chunk(arr, n) { const out = []; for (let i = 0; i < arr.length; i += n) out.push(arr.slice(i, i + n)); return out }

phase('Enums')
const enumBatches = chunk(ENUMS, 30)
await parallel(enumBatches.map((b, i) => () =>
  agent(`${rules}\n\nGenerate these ENUM schemas: ${b.join(', ')}`,
    { label: `enums-${i}`, phase: 'Enums' })))

phase('Records')
const recordBatches = chunk(RECORDS, 12)
const results = await parallel(recordBatches.map((b, i) => () =>
  agent(`${rules}\n\nGenerate these RECORD schemas: ${b.join(', ')}`,
    { label: `records-${i}`, phase: 'Records' })))

log(`Dispatched ${enumBatches.length} enum batches and ${recordBatches.length} record batches`)
return { enumBatches: enumBatches.length, recordBatches: recordBatches.length, summaries: results.filter(Boolean) }
```

Expected: ~690 new files under the domain package. The tool result includes the saved `scriptPath`; if a batch fails, re-run only the failed schema names via `agent(...)` or a follow-up Workflow.

- [ ] **Step 3: Quick count check**

Run: `ls src/main/java/org/lattejava/fusionauth/domain/*.java | wc -l`
Expected: ≈ 690 (601 records + 89 enums; ZonedDateTime intentionally absent). Investigate a large shortfall before proceeding.

- [ ] **Step 4: Commit the generated set**

```bash
git add src/main/java/org/lattejava/fusionauth/domain
git commit -m "Generate FusionAuth domain models from OpenAPI spec"
```

---

## Task 6: Compile gate — `latte build` and fix failures

The annotation processor fails the build on any unsupported construct, so a clean compile is the primary correctness gate.

- [ ] **Step 1: Build**

Run: `latte build`
Expected eventually: BUILD SUCCESS. First run will likely surface errors.

- [ ] **Step 2: Triage and fix iteratively.** For each compile error, fix the single offending file by re-reading its schema in `src/main/openapi.yaml` and re-applying the rulebook. Common causes and fixes:
  - **`cannot find symbol` for a type** → a referenced schema wasn't generated (check `build/gen/record-names.txt`); generate the missing file.
  - **`sealed ... permits` mismatch** → a subtype doesn't `implements IdentityProviderField`, or `IdentityProviderField` lists a name that doesn't exist; reconcile the 16-subtype set.
  - **duplicate component / discriminator present** → an IdP subtype still declares a `type` field; remove it.
  - **`@JSON` processor error about helpers/module** → adjust `module-info.java` exports for the actual generated `.internal` package(s).
  - **raw/`Object` collection rejected by processor** → if the processor rejects `Set<Object>`/`Map<String,Object>` element handling, re-read that schema; map an empty-items array element to the processor's supported any-type (consult `json` fixtures `extras`/`catchall`).

For systematic (not one-off) errors affecting many files, fix the rulebook understanding and re-dispatch a Workflow batch over just the affected schema names rather than hand-editing dozens of files.

- [ ] **Step 3: Re-build until clean**

Run: `latte build`
Expected: BUILD SUCCESS.

- [ ] **Step 4: Commit fixes**

```bash
git add -A
git commit -m "Fix compile errors in generated domain models"
```

---

## Task 7: Round-trip verification suite + final check

Broadens the round-trip tests beyond the three references to representative complex models, confirming serialize→deserialize fidelity across the type-mapping surface.

**Files:**
- Create: `src/test/java/org/lattejava/fusionauth/domain/ModelRoundTripTest.java`

- [ ] **Step 1: Write round-trip tests for representative models** covering each mapping family: a big nested record (`Application`), a record with `List`/`Set` (`ApplicationOAuthScope` or similar), one with enums (`JWTConfiguration` uses `Algorithm`), one with `Map<String,Object>` `data`, an `Instant` field, and one polymorphic subtype beyond `Apple` (e.g. `GoogleIdentityProvider`). For each: build an instance via its `Builder`, `toJSON`, `fromJSON`, assert the populated fields are equal.

```java
/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import org.lattejava.fusionauth.domain.internal.ApplicationJSON;

import module java.base;
import module org.testng;

public class ModelRoundTripTest {
  @Test
  public void applicationRoundTrips() {
    Application app = Application.builder()
        .id(UUID.fromString("00000000-0000-0000-0000-0000000000aa"))
        .name("My App")
        .active(Boolean.TRUE)
        .build();

    String json = ApplicationJSON.toJSON(app);
    Application parsed = ApplicationJSON.fromJSON(json);

    Assert.assertEquals(parsed.id(), app.id());
    Assert.assertEquals(parsed.name(), "My App");
    Assert.assertEquals(parsed.active(), Boolean.TRUE);
  }

  // Add analogous @Test methods for the other representative models named above,
  // each importing its companion from org.lattejava.fusionauth.domain.internal.
}
```

Use only fields each model actually declares (read the schema first). Keep assertions to the fields you set.

- [ ] **Step 2: Run the full test suite**

Run: `latte test`
Expected: all tests PASS, including `APIKeyRoundTripTest`, `IdentityProviderRoundTripTest`, and `ModelRoundTripTest`.

- [ ] **Step 3: Final full build**

Run: `latte build`
Expected: BUILD SUCCESS.

- [ ] **Step 4: Commit**

```bash
git add src/test/java/org/lattejava/fusionauth/domain/ModelRoundTripTest.java
git commit -m "Add round-trip verification suite for domain models"
```

---

## Done criteria

- `latte build` succeeds: every `@JSON` type generated its companion without processor errors.
- `latte test` passes: round-trip fidelity verified for plain records, collections, enums, `Instant`/`EPOCH_MILLIS`, `Map` fields, and the polymorphic hierarchy.
- ~690 source files exist under `org.lattejava.fusionauth.domain` (601 records + 89 enums; `ZonedDateTime` intentionally mapped to `Instant`, not emitted).
- Out of scope (later phases): the HTTP client / endpoint layer, and any change to the `org.lattejava:json` library.
