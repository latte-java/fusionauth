/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderConnectionTestResultJSON;

@JSON
public record IdentityProviderConnectionTestResult(
    String email,
    UUID identityProviderId,
    String identityProviderUserId,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant startInstant,
    List<IdentityProviderLoginStep> steps,
    Boolean success,
    String username) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderConnectionTestResultJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderConnectionTestResultJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderConnectionTestResult fromJSON(String json) {
    return IdentityProviderConnectionTestResultJSON.fromJSON(json);
  }
  
  public static IdentityProviderConnectionTestResult fromJSONBytes(byte[] json) {
    return IdentityProviderConnectionTestResultJSON.fromJSON(json);
  }

  public static final class Builder {
    private String email;
    private UUID identityProviderId;
    private String identityProviderUserId;
    private Instant startInstant;
    private List<IdentityProviderLoginStep> steps;
    private Boolean success;
    private String username;
    public Builder email(String email) { this.email = email; return this; }
    public Builder identityProviderId(UUID identityProviderId) { this.identityProviderId = identityProviderId; return this; }
    public Builder identityProviderUserId(String identityProviderUserId) { this.identityProviderUserId = identityProviderUserId; return this; }
    public Builder startInstant(Instant startInstant) { this.startInstant = startInstant; return this; }
    public Builder steps(List<IdentityProviderLoginStep> steps) { this.steps = steps; return this; }
    public Builder success(Boolean success) { this.success = success; return this; }
    public Builder username(String username) { this.username = username; return this; }
    public IdentityProviderConnectionTestResult build() { return new IdentityProviderConnectionTestResult(email, identityProviderId, identityProviderUserId, startInstant, steps, success, username); }
  }
}
