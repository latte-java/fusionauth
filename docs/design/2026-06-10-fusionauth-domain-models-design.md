# FusionAuth Domain Models (Latte JSON) — Design

- **Date:** 2026-06-10
- **Status:** Approved
- **Source spec:** `src/main/openapi.yaml` (FusionAuth API 1.67.0)
- **Depends on:** `org.lattejava:json:0.2.0` (annotation processor), Java 25

## Goal

Generate the complete **model layer** for a FusionAuth API client library, clean-room from the
OpenAPI spec (no reference to any prior/external client): a Java record (or enum, or sealed
interface) for every schema under `components.schemas`, each annotated for the Latte JSON library so
the annotation processor can generate its `*JSON` serialization companion.

This phase is **models only**. The HTTP client / endpoint layer is a separate, later phase.

## Scope

From the spec (`components.schemas` holds **691** top-level schemas):

- **601** object schemas → records (691 total − 89 enums − the `ZonedDateTime` alias).
- **89** enum schemas → Java enums.
- **1** polymorphic hierarchy: `IdentityProviderField` (the `oneOf` + `discriminator` schema),
  discriminated by the `type` property, with **16** subtypes (see
  `components.schemas.IdentityProviderField.discriminator.mapping`). Note: a separate
  `DomainBasedIdentityProvider` schema exists but is **not** part of the `oneOf` — it is a standalone
  record, not a subtype.
- **0** anonymous inline objects, **0** inline enums (every property is a scalar, a `$ref`, an
  array, or an `additionalProperties` map). This keeps codegen mechanical.
- No `allOf` / schema inheritance — every schema lists its full property set flat, so every record
  is standalone (including the polymorphic subtypes).

The `ZonedDateTime` schema is **not** emitted as a type; it is a type-mapping alias (see below).

## Package & file layout

- Single flat package: `org.lattejava.fusionauth.domain`.
- One source file per emitted type, named after the schema (e.g. `Application.java`,
  `APIKeyMetaData.java`, `Algorithm.java`).
- Source root: `src/main/java/org/lattejava/fusionauth/domain/`.
- Each file uses module imports: `import module java.base;` and `import module org.lattejava.json;`.

## Type-mapping rules

All record components use **boxed / reference types** (never primitives) so an absent JSON key
deserializes to `null`, and `@JSON(omitNulls = true)` (the default) drops it on serialization.

| OpenAPI construct | Java type |
|---|---|
| `$ref` → `ZonedDateTime` | `Instant` + `@JSONField(instant = InstantFormat.EPOCH_MILLIS)` |
| `$ref` → an enum schema | that enum type |
| `$ref` → an object schema | that record type |
| `$ref` → `IdentityProviderField` | the `IdentityProviderField` sealed interface |
| `string` + `format: uuid` or `format: UUID` | `UUID` |
| `string` + `format: URI` | `String` (Latte has no URI converter; lossless on the wire) |
| `string` + `format: binary` | `String` |
| `string` (no format) | `String` |
| `integer` + `format: int64` | `Long` |
| `integer` (no format) | `Integer` |
| `number` (incl. `format: double`) | `Double` |
| `boolean` | `Boolean` |
| `array` with `uniqueItems: true`, `items` typed | `Set<T>` (element mapped by these same rules) |
| `array`, `items` typed | `List<T>` |
| `array` with `items: {}` (no element schema) | `Set<String>` (uniqueItems) / `List<String>` — see edge cases |
| `object` with no `properties` and no `additionalProperties` (free-form object) | `Map<String, Object>` |
| `object` + `additionalProperties: {type: object}` | `Map<String, Object>` |
| `object` + `additionalProperties: {type: string}` | `Map<String, String>` |
| `object` + `additionalProperties: {type: array, ...}` | `Map<String, Object>` (free-form; values are arrays at runtime) |
| `object` + `additionalProperties: {$ref: X}` (X an object/enum) | `Map<String, X>` |

**Latte JSON support note:** json `0.3.0` supports `Map<String, Object>` (dynamic maps carrying
arbitrary JSON values — objects, arrays, scalars, nested — read/written via the `Any*` helpers). It
does **not** support a bare `Object` field nor `List<Object>`/`Set<Object>`. FusionAuth needs none of
those: every free-form value is a JSON object → `Map<String, Object>`, and the `items: {}` arrays are
string sets. `Map<String, Set/List<…>>` (nested collection as a map value) is also unsupported, which
is why an `additionalProperties: {type: array}` map is modeled as `Map<String, Object>`.

### Rationale for the chosen decisions

- **`ZonedDateTime` → `Instant` + `EPOCH_MILLIS`.** The spec's `ZonedDateTime` is `int64`
  epoch-millis on the wire, not an ISO string. Latte natively serializes `Instant` as epoch millis
  via `@JSONField(instant = InstantFormat.EPOCH_MILLIS)`, giving a real time type with a correct
  round-trip. (Mapping to `java.time.ZonedDateTime` would *not* round-trip, because Latte only
  parses `ZonedDateTime` from ISO strings.)
- **`URI` → `String`.** Latte's `Conversions` has no `URI` parser. `String` works today with zero
  changes to the `json` library and is lossless on the wire. Revisit if/when Latte gains URI
  support.

## Record & builder shape

- Type annotation: `@JSON` with defaults — `naming = IDENTITY` (FusionAuth JSON keys already match
  the Java field names), `omitNulls = true`, `strict = false`.
- Field names mirror the JSON keys **exactly**, including the few snake_case keys such as
  `client_id` and `client_secret`.
- Each record carries a nested `Builder`: a `static builder()` factory and a `static final class
  Builder` with one fluent setter per component (returns `this`) and a `build()` returning the
  record. **No** `from(record)` copy method (can be added later if needed).

Example:

```java
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

## Enums

Plain Java enums with constants taken verbatim from the spec's `enum` list. No `@JSON` needed —
Latte serializes enums by name and deserializes via `Conversions.toEnum`. Acronym-heavy constants
(e.g. `ES256`, `HS512`) are copied as-is.

## Polymorphism — `IdentityProviderField`

```java
@JSON
@JSONTypeInfo(property = "type")
public sealed interface IdentityProviderField
    permits AppleIdentityProvider, EpicGamesIdentityProvider, /* ... */ XboxIdentityProvider {
}
```

Each subtype is a standalone `@JSON` record implementing `IdentityProviderField`, carrying its full
flat field set, and annotated with `@JSONSubtype("<discriminator>")` where the discriminator value
comes from `IdentityProviderField.discriminator.mapping` (e.g. `@JSONSubtype("Apple")` on
`AppleIdentityProvider`, since the class name differs from the wire value `Apple`).

**Critical rule:** the subtype's own `type` discriminator property is written by Latte's polymorphism
machinery from the `@JSONSubtype` value and is **not** declared as a record component (confirmed
against the `Pet`/`Dog` fixtures: `Dog` has no `petType` component). So each of the 16 subtypes
**drops** its `type` property (`$ref: IdentityProviderType`) from the record.

The 16 subtypes and their discriminator values:

| Discriminator (`@JSONSubtype`) | Subtype record |
|---|---|
| `Apple` | `AppleIdentityProvider` |
| `EpicGames` | `EpicGamesIdentityProvider` |
| `ExternalJWT` | `ExternalJWTIdentityProvider` |
| `Facebook` | `FacebookIdentityProvider` |
| `Google` | `GoogleIdentityProvider` |
| `HYPR` | `HYPRIdentityProvider` |
| `LinkedIn` | `LinkedInIdentityProvider` |
| `Nintendo` | `NintendoIdentityProvider` |
| `OpenIdConnect` | `OpenIdConnectIdentityProvider` |
| `SAMLv2IdPInitiated` | `SAMLv2IdPInitiatedIdentityProvider` |
| `SAMLv2` | `SAMLv2IdentityProvider` |
| `SonyPSN` | `SonyPSNIdentityProvider` |
| `Steam` | `SteamIdentityProvider` |
| `Twitch` | `TwitchIdentityProvider` |
| `Twitter` | `TwitterIdentityProvider` |
| `Xbox` | `XboxIdentityProvider` |

## Edge cases

- **Reserved words.** Verified: **no** schema property name is a Java reserved word (the `default:`
  keys in the spec are HTTP response codes under `paths:`, not schema properties). So no field
  renames / `@JSONField(name = ...)` escaping are needed for keywords.
- **`data` fields.** The ubiquitous `data` property (`object` + `additionalProperties: {type:
  object}`) is an ordinary `Map<String, Object>` component — **not** `@JSONCatchAll`.
- **Empty array item schema.** A `type: array` field with `items: {}` (no element schema) maps the
  element to `String` — these 17 fields are string sets/lists in practice (`domains`, `roles`,
  `scopes`, `messageTypes`, `applicationIds`, `enabledGrants`, `threatsDetected`, `blockedDomains`,
  …), so `Set<String>` (uniqueItems) / `List<String>`. (`Set<Object>`/`List<Object>` are not
  supported by Latte JSON, and these are not genuinely free-form.) Distinct from a *map* whose values
  are arrays (`additionalProperties: {type: array}`, e.g. `APIKeyPermissions.endpoints`) → that is
  `Map<String, Object>`.

## Verification

1. `latte build` must compile cleanly. The annotation processor generates each `*JSON` companion
   and fails the build on any unsupported construct, so a clean compile is the primary gate that the
   models are well-formed and Latte-compatible.
2. A round-trip test (TestNG) deserializes then re-serializes a representative set of payloads
   (e.g. an `Application`, a `User`, an `IdentityProvider` subtype) and asserts fidelity.

## Execution plan

1. **Reference models (hand-written, verified to compile):** a plain record (`Application` or
   similar with varied field types), the full `IdentityProvider` sealed hierarchy, and one enum
   (`Algorithm`). Run `latte build` to confirm the patterns compile against the real processor.
2. **Bulk generation via multi-agent workflow:** fan out the remaining ~690 schemas in batches,
   each agent applying the locked type-mapping rules to produce records/enums. Shared, unambiguous
   rules make the batches independent.
3. **Compile gate + round-trip tests** over the full set; fix any stragglers.

## Out of scope (this phase)

- HTTP client, endpoints, request/response plumbing.
- Adding URI support to the `json` library.
- Any change to the `org.lattejava:json` library itself.
