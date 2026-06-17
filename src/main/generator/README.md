# FusionAuth client generator

Regenerates `org.lattejava.fusionauth` from `src/main/openapi.yaml`. Not yet rebuilt; this is the spec for it.

## Outputs
- **Domain** (`…domain`): one `record` per schema + enums, with `@JSON` companions. Standard type rules (see CLAUDE.md).
- **Client** (`FusionAuthClient.java`): one method per operation, injected between `// ===== GENERATED METHODS START/END =====`. Hand-written helpers (`execute`, `executeVoid`, `send`, `encode`, `query`, `queryList`, `error`, constructors) are the contract — generate around them, never over them.

## Method rules
- Name = `operationId`. Params: path → query → body record → `xFusionAuthTenantId`.
- `xFusionAuthTenantId`: type `UUID`, **always last**. Each method that takes it also gets an overload omitting it (delegates with `null`).
- Body operations return the `200` record. Empty-body operations return `int` (status code): `return executeVoid(...)`.
- Array query params (spec `type: array`, e.g. `ids`, `userIds`) → `String...` + `queryList(name, values)`. Scalar query params → `query(...)`.
- Path params via `encode(...)`. `execute` returns `null` on 404; `executeVoid` returns the status (no throw on 404).

## Type mapping (beyond CLAUDE.md defaults)
- `format: uuid` → `UUID`. Applies to `xFusionAuthTenantId` only for now.
- **Open decision:** path/query id params are `format: uuid` in the spec but the current client uses `String`. Generator must choose: keep `String`, or emit `UUID` (divergence from today's client).
