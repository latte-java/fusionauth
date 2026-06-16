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

    ApplicationResponse created = client.createApplicationWithId(id, ApplicationRequest.builder().application(app).build());
    Assert.assertEquals(created.application().name(), "IT-" + id);

    ApplicationResponse fetched = client.retrieveApplicationWithId(id, null);
    Assert.assertNotNull(fetched.application());
    Assert.assertEquals(fetched.application().id().toString(), id);
    Assert.assertEquals(fetched.application().name(), "IT-" + id);

    Application renamed = Application.builder().name("IT-renamed-" + id).build();
    ApplicationResponse updated = client.updateApplicationWithId(id, null, ApplicationRequest.builder().application(renamed).build());
    Assert.assertEquals(updated.application().name(), "IT-renamed-" + id);

    // hardDelete=true: FusionAuth soft-deletes (deactivates) by default, which leaves the application
    // retrievable; a hard delete removes it so a subsequent retrieve returns 404, which the client maps to null.
    client.deleteApplicationWithId(id, "true", null);

    Assert.assertNull(client.retrieveApplicationWithId(id, null), "hard-deleted application should return null (404)");
  }

  // Verifies searchUsersByIdsWithId emits a repeated query param (ids=a&ids=b) that the live API
  // honors: create two users, search by both Ids, and expect both back.
  @Test
  public void searchUsersByIdsUsesRepeatedQueryParam() {
    String id1 = UUID.randomUUID().toString();
    String id2 = UUID.randomUUID().toString();
    client.createUserWithId(id1, userRequest("it-" + id1 + "@example.com"));
    client.createUserWithId(id2, userRequest("it-" + id2 + "@example.com"));

    try {
      SearchResponse response = client.searchUsersByIdsWithId(id1, id2);
      Assert.assertNotNull(response);
      Assert.assertEquals(response.total(), Long.valueOf(2));
      Set<String> returned = response.users().stream().map(u -> u.id().toString()).collect(Collectors.toSet());
      Assert.assertEquals(returned, Set.of(id1, id2));
    } finally {
      UserDeleteSingleRequest delete = UserDeleteSingleRequest.builder().build();
      client.deleteUserWithId(id1, "true", delete);
      client.deleteUserWithId(id2, "true", delete);
    }
  }

  private static UserRequest userRequest(String email) {
    return UserRequest.builder()
                      .user(User.builder().email(email).password("password").build())
                      .build();
  }

  @Test
  public void retrievesDefaultApplicationById() {
    ApplicationResponse response = client.retrieveApplicationWithId("3c219e58-ed0e-4b18-ad48-f4f92793ae32", null);
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.application());
  }

  @Test
  public void returnsNullOnMissingApplication() {
    ApplicationResponse response = client.retrieveApplicationWithId("00000000-0000-0000-0000-0000000000ff", null);
    Assert.assertNull(response, "a missing application should return null (404)");
  }

  // Verifies Errors.fieldErrors deserializes as a typed Map<String, List<Error>>: creating an
  // application with no name yields a 400 whose fieldErrors are keyed by field path ("application.name").
  @Test
  public void fieldValidationErrorsDeserializeAsTypedMap() {
    String id = UUID.randomUUID().toString();
    try {
      var req = ApplicationRequest.builder()
                                  .application(Application.builder().build())
                                  .build();
      client.createApplicationWithId(id, req);
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
