# FusionAuth client generator

`generate.rb` regenerates `org.lattejava.fusionauth` from `src/main/openapi.yaml` (Ruby, uses only stdlib YAML). Deterministic; safe to re-run.

```
ruby src/main/generator/generate.rb enums    # domain enums
ruby src/main/generator/generate.rb records  # domain records + IdentityProviderField
ruby src/main/generator/generate.rb client   # FusionAuthClient methods (between markers)
ruby src/main/generator/generate.rb all
```

## Outputs
- **Domain** (`…domain`): one `record` per schema (+ nested `Builder`, `@JSON`, `toJSON`/`fromJSON` companions) and one bare `enum` per enum schema. `IdentityProviderField` is the sealed `oneOf` interface; its 16 subtypes get `@JSONSubtype` from `discriminator.mapping` and drop the `type` property. `ZonedDateTime` is mapped to `Instant`, never emitted.
- **Client** (`FusionAuthClient.java`): one method per operation, injected between `// ===== GENERATED METHODS START/END =====`. Hand-written helpers (`execute`, `executeVoid`, `send`, `encode`, `query`, `queryList`, `error`, constructors) are the contract — generated around, never over.

## Method rules
- Name = `operationId`. Params: path → query → body record → `xFusionAuthTenantId`.
- `xFusionAuthTenantId`: type `UUID`, **always last**. Each method that takes it also gets an overload omitting it (delegates with `null`).
- Body operations return the `200` record. Empty-body operations return `int` (status code): `return executeVoid(...)`.
- All query params fold into one `query(name, value, …)` call (the helper takes `Object...`, expands `Iterable` values into repeated params, `.toString()`s scalars). Array params (spec `type: array`) are typed `List<String>`.
- Path params via `encode(...)`. `execute` returns `null` on 404; `executeVoid` returns the status (no throw on 404).

## Type mapping (beyond CLAUDE.md defaults)
- `format: uuid` → `UUID`; everything else per the rulebook in `docs/implementation/2026-06-10-fusionauth-domain-models.md`, with json `0.4.0` allowing `Map<String, List/Set<X>>` for `additionalProperties: {type: array}`.
- Non-identifier JSON keys (e.g. `x5t#S256`) → sanitized Java field + `@JSONField(name = "<key>")`.
- Path/query id params stay `String` (only `xFusionAuthTenantId` is `UUID`) — matches the current client.

## Note
A clean regeneration is consistent but will **not** byte-match the current tree (the records were authored with varied formatting, the spec was fixed without regenerating the domain layer, and the client was partly hand-edited). `generate.rb enums` reproduces the committed enums exactly; `records`/`client` compile but diverge in formatting and some types/signatures, and the existing tests assume the current hand-edited client API.
