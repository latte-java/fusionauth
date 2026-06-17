/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnRegisterStartRequestJSON;

@JSON
public record WebAuthnRegisterStartRequest(
    String displayName,
    String name,
    String userAgent,
    UUID userId,
    WebAuthnWorkflow workflow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnRegisterStartRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return WebAuthnRegisterStartRequestJSON.toJSONBytes(this);
  }
  
  public static WebAuthnRegisterStartRequest fromJSON(String json) {
    return WebAuthnRegisterStartRequestJSON.fromJSON(json);
  }
  
  public static WebAuthnRegisterStartRequest fromJSONBytes(byte[] json) {
    return WebAuthnRegisterStartRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String displayName;
    private String name;
    private String userAgent;
    private UUID userId;
    private WebAuthnWorkflow workflow;
    public Builder displayName(String displayName) { this.displayName = displayName; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder userAgent(String userAgent) { this.userAgent = userAgent; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public Builder workflow(WebAuthnWorkflow workflow) { this.workflow = workflow; return this; }
    public WebAuthnRegisterStartRequest build() { return new WebAuthnRegisterStartRequest(displayName, name, userAgent, userId, workflow); }
  }
}
