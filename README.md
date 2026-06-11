# FusionAuth Java Client

A zero-dependency Java client for the [FusionAuth](https://fusionauth.io) API, generated clean-room
from the FusionAuth OpenAPI specification (API version 1.67.0).

The library has two layers:

- **Domain models** (`org.lattejava.fusionauth.domain`) — a Java `record` for every schema in the
  spec (~600 records plus enums and the polymorphic `IdentityProviderField` hierarchy). Each record
  has a fluent `Builder` and `toJSON()` / `fromJSON(...)` methods. JSON is handled at compile time by
  the [Latte JSON](https://github.com/lattejava/json) annotation processor — there is no runtime JSON
  dependency and no reflection.
- **HTTP client** (`org.lattejava.fusionauth.FusionAuthClient`) — one synchronous method per API
  operation (322 in total), built on the JDK's `java.net.http.HttpClient`.

## Requirements

- Java 25
- [Latte](https://lattejava.org) build tool

## Install

Add the dependency in `project.latte`:

```groovy
dependencies {
  group(name: "compile") {
    dependency(id: "org.lattejava:fusionauth:0.1.0")
  }
}
```

This is the only dependency you need. The JSON serialization is generated into this library at build
time (via the Latte JSON annotation processor) and ships inside it, so your application does **not**
depend on `org.lattejava:json` or any other runtime library.

In a modular project, require the module:

```java
module your.app {
  requires org.lattejava.fusionauth;
}
```

## Usage

Construct a client with an [API key](https://fusionauth.io/docs/v1/tech/apis/authentication) and your
FusionAuth base URL, then call one method per API operation. Methods are named after the spec's
`operationId` (e.g. `retrieveApplicationWithId`, `createApplicationWithId`). Operations that take a
resource id, optional query parameters, or the tenant header expose them as leading `String`
parameters — pass `null` for any you don't need.

```java
import module java.base;
import module org.lattejava.fusionauth;

FusionAuthClient client = new FusionAuthClient("your-api-key", "http://localhost:9011");

// Retrieve an application by id (the second arg is the optional X-FusionAuth-TenantId header).
ApplicationResponse response = client.retrieveApplicationWithId("3c219e58-ed0e-4b18-ad48-f4f92793ae32", null);
System.out.println(response.application().name());

// Create an application. Request/response bodies are domain records built with their Builder.
Application application = Application.builder()
    .name("My App")
    .build();

ApplicationResponse created = client.createApplicationWithId(
    UUID.randomUUID().toString(),
    null,
    ApplicationRequest.builder().application(application).build());

System.out.println("Created: " + created.application().id());
```

### Return values and errors

A method returns its `200` response record directly, or `void` for operations with an empty response
body. Any non-2xx response (or a transport failure) throws `FusionAuthException`:

```java
try {
  client.retrieveApplicationWithId("00000000-0000-0000-0000-000000000000", null);
} catch (FusionAuthException e) {
  System.out.println("HTTP status: " + e.status);   // e.g. 404
  System.out.println("Errors: " + e.errors);         // parsed Errors body (may be null)
  System.out.println("Raw body: " + e.rawBody);
}
```

### Working with models directly

Every domain record can serialize and deserialize itself:

```java
String json = application.toJSON();
Application parsed = Application.fromJSON(json);
```

`FusionAuthClient` uses these same methods internally, so request bodies and responses are converted
without any reflection.

## Build

```
latte build      # compile + jar
latte test       # run the test suite
latte clean      # remove build outputs
```

The integration tests in `FusionAuthClientTest` exercise the client against a running FusionAuth.
They expect a local instance at `http://localhost:9014` (a Docker Compose + kickstart setup lives in
`src/main/fusionauth/`) and are skipped automatically if the server is unreachable.

## License

MIT — see [LICENSE](LICENSE).
