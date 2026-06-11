/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain.tests;

import module java.base;
import module org.lattejava.fusionauth;
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

    byte[] json = key.toJSONBytes();
    APIKey parsed = APIKey.fromJSONBytes(json);

    Assert.assertEquals(parsed.id(), key.id());
    Assert.assertEquals(parsed.name(), key.name());
    Assert.assertEquals(parsed.keyManager(), Boolean.TRUE);
    Assert.assertEquals(parsed.insertInstant(), Instant.ofEpochMilli(1_659_380_719_000L));
    Assert.assertEquals(parsed.metaData().attributes(), Map.of("a", "b"));
  }

  // Exercises the free-form Map<String, Object> support added in json 0.3.0: a map whose values
  // are an array (the natural shape FusionAuth's endpoints/data fields take on the wire).
  @Test
  public void freeFormMapRoundTrips() {
    APIKeyPermissions permissions = APIKeyPermissions.builder()
        .endpoints(Map.of("/api/user", List.of("GET", "POST"), "/api/group", List.of("GET")))
        .build();

    String json = permissions.toJSON();
    APIKeyPermissions parsed = APIKeyPermissions.fromJSON(json);

    // On read, the JSON array deserializes to its natural shape (an ArrayList).
    Assert.assertEquals(parsed.endpoints().get("/api/user"), List.of("GET", "POST"));
    Assert.assertEquals(parsed.endpoints().get("/api/group"), List.of("GET"));
  }
}
