/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnStartRequestJSON;

@JSON
public record WebAuthnStartRequest(
    UUID applicationId,
    UUID credentialId,
    String loginId,
    List<String> loginIdTypes,
    Map<String, Object> state,
    UUID userId,
    WebAuthnWorkflow workflow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnStartRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnStartRequestJSON.toJSONBytes(this);
  }
  
  public static WebAuthnStartRequest fromJSON(String json) {
    return WebAuthnStartRequestJSON.fromJSON(json);
  }
  
  public static WebAuthnStartRequest fromJSONBytes(byte[] json) {
    return WebAuthnStartRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private UUID credentialId;
    private String loginId;
    private List<String> loginIdTypes;
    private Map<String, Object> state;
    private UUID userId;
    private WebAuthnWorkflow workflow;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder credentialId(UUID credentialId) { this.credentialId = credentialId; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdTypes(List<String> loginIdTypes) { this.loginIdTypes = loginIdTypes; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder workflow(WebAuthnWorkflow workflow) { this.workflow = workflow; return this; }
    public WebAuthnStartRequest build() { return new WebAuthnStartRequest(applicationId, credentialId, loginId, loginIdTypes, state, userId, workflow); }
  }
}
