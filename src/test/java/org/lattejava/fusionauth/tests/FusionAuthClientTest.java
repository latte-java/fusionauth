/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.tests;

import org.lattejava.fusionauth.domain.Error;

import module java.base;
import module java.net.http;
import module org.lattejava.fusionauth;
import module org.testng;

public class FusionAuthClientTest {
  private static final String API_KEY = "33052c8a-c283-4e96-9d2a-eb1215c69f8f-not-for-prod";
  private static final String BASE_URL = "http://localhost:9014";

  private FusionAuthClient client;

  @BeforeClass
  public void checkServer() throws Exception {
    try (HttpClient http = HttpClient.newHttpClient()) {
      HttpResponse<String> r = http.send(
          HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/api/status")).timeout(Duration.ofSeconds(3)).build(),
          HttpResponse.BodyHandlers.ofString()
      );
      if (r.statusCode() != 200) {
        throw new SkipException("FusionAuth not healthy at " + BASE_URL + " (status " + r.statusCode() + ")");
      }
    } catch (IOException e) {
      throw new SkipException("FusionAuth not reachable at " + BASE_URL + "; start the local Docker Compose first");
    }

    client = new FusionAuthClient(API_KEY, BASE_URL);
  }

  @Test
  public void applicationCrudRoundTrip() {
    String id = UUID.randomUUID().toString();
    Application app = Application.builder().name("IT-" + id).build();

    ApplicationResponse created = client.createApplicationWithId(id, null,
        ApplicationRequest.builder().application(app).build());
    Assert.assertEquals(created.application().name(), "IT-" + id);

    ApplicationResponse fetched = client.retrieveApplicationWithId(id, null);
    Assert.assertNotNull(fetched.application());
    Assert.assertEquals(fetched.application().id().toString(), id);
    Assert.assertEquals(fetched.application().name(), "IT-" + id);

    Application renamed = Application.builder().name("IT-renamed-" + id).build();
    ApplicationResponse updated = client.updateApplicationWithId(id, null, null,
        ApplicationRequest.builder().application(renamed).build());
    Assert.assertEquals(updated.application().name(), "IT-renamed-" + id);

    // hardDelete=true: FusionAuth soft-deletes (deactivates) by default, which leaves the application
    // retrievable; a hard delete removes it so a subsequent retrieve returns 404.
    client.deleteApplicationWithId(id, "true", null);

    try {
      client.retrieveApplicationWithId(id, null);
      Assert.fail("expected FusionAuthException after delete");
    } catch (FusionAuthException expected) {
      Assert.assertEquals(expected.status, 404);
    }
  }

  @Test
  public void retrievesDefaultApplicationById() {
    ApplicationResponse response = client.retrieveApplicationWithId("3c219e58-ed0e-4b18-ad48-f4f92793ae32", null);
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.application());
  }

  @Test
  public void throwsOnMissingApplication() {
    try {
      client.retrieveApplicationWithId("00000000-0000-0000-0000-0000000000ff", null);
      Assert.fail("expected FusionAuthException");
    } catch (FusionAuthException e) {
      Assert.assertEquals(e.status, 404);
    }
  }

  // Verifies Errors.fieldErrors deserializes as a typed Map<String, List<Error>>: creating an
  // application with no name yields a 400 whose fieldErrors are keyed by field path ("application.name").
  @Test
  public void fieldValidationErrorsDeserializeAsTypedMap() {
    String id = UUID.randomUUID().toString();
    try {
      client.createApplicationWithId(id, null,
          ApplicationRequest.builder().application(Application.builder().build()).build());
      Assert.fail("expected FusionAuthException for the missing application name");
    } catch (FusionAuthException e) {
      Assert.assertEquals(e.status, 400);
      Assert.assertNotNull(e.errors, "errors body should parse: " + e.rawBody);
      Map<String, List<Error>> fieldErrors = e.errors.fieldErrors();
      Assert.assertNotNull(fieldErrors);
      List<Error> nameErrors = fieldErrors.get("application.name");
      Assert.assertNotNull(nameErrors, "expected a field error keyed by application.name: " + fieldErrors);
      Assert.assertFalse(nameErrors.isEmpty());
      Assert.assertNotNull(nameErrors.getFirst().code());
    }
  }
}
