/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain.tests;

import module java.base;
import module org.lattejava.fusionauth;
import module org.testng;

/**
 * Representative round-trip coverage across the type-mapping surface: nested @JSON records, enums,
 * free-form Map<String, Object> data, Set/List of String, Instant (EPOCH_MILLIS), UUID, and the
 * polymorphic IdentityProviderField hierarchy.
 */
public class ModelRoundTripTest {
  @Test
  public void applicationWithNestedRecordsEnumsAndData() {
    Application app = Application.builder()
        .id(UUID.fromString("00000000-0000-0000-0000-0000000000aa"))
        .name("My App")
        .active(Boolean.TRUE)
        .insertInstant(Instant.ofEpochMilli(1_700_000_000_000L))
        .data(Map.of("color", "blue", "rank", 7L))
        .jwtConfiguration(JWTConfiguration.builder()
            .enabled(Boolean.TRUE)
            .timeToLiveInSeconds(3600)
            .refreshTokenUsagePolicy(RefreshTokenUsagePolicy.OneTimeUse)
            .build())
        .roles(List.of(ApplicationRole.builder().name("admin").isDefault(Boolean.TRUE).build()))
        .build();

    Application parsed = Application.fromJSON(app.toJSON());

    Assert.assertEquals(parsed.id(), app.id());
    Assert.assertEquals(parsed.name(), "My App");
    Assert.assertEquals(parsed.active(), Boolean.TRUE);
    Assert.assertEquals(parsed.insertInstant(), Instant.ofEpochMilli(1_700_000_000_000L));
    Assert.assertEquals(parsed.data().get("color"), "blue");
    Assert.assertEquals(parsed.jwtConfiguration().refreshTokenUsagePolicy(), RefreshTokenUsagePolicy.OneTimeUse);
    Assert.assertEquals(parsed.jwtConfiguration().timeToLiveInSeconds(), Integer.valueOf(3600));
    Assert.assertEquals(parsed.roles().getFirst().name(), "admin");
  }

  @Test
  public void userRegistrationWithSetAndListAndData() {
    UserRegistration reg = UserRegistration.builder()
        .id(UUID.fromString("00000000-0000-0000-0000-0000000000bb"))
        .username("alice")
        .roles(Set.of("admin", "user"))
        .preferredLanguages(List.of("en", "fr"))
        .data(Map.of("nested", Map.of("k", "v")))
        .verified(Boolean.TRUE)
        .build();

    UserRegistration parsed = UserRegistration.fromJSON(reg.toJSON());

    Assert.assertEquals(parsed.username(), "alice");
    Assert.assertEquals(parsed.roles(), Set.of("admin", "user"));
    Assert.assertEquals(parsed.preferredLanguages(), List.of("en", "fr"));
    Assert.assertEquals(parsed.data().get("nested"), Map.of("k", "v"));
    Assert.assertEquals(parsed.verified(), Boolean.TRUE);
  }

  @Test
  public void identityProviderPolymorphismRoundTrips() {
    GoogleIdentityProvider google = GoogleIdentityProvider.builder()
        .name("Google")
        .debug(Boolean.TRUE)
        .client_id("client-123")
        .build();

    String json = google.toJSON();
    Assert.assertTrue(json.contains("\"type\":\"Google\""), "discriminator written: " + json);

    IdentityProviderField parsed = IdentityProviderField.fromJSON(json);
    Assert.assertTrue(parsed instanceof GoogleIdentityProvider, "deserialized to concrete subtype");
    Assert.assertEquals(((GoogleIdentityProvider) parsed).client_id(), "client-123");
  }
}
