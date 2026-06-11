/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifyStartRequestJSON;

@JSON
public record VerifyStartRequest(
    UUID applicationId,
    ExistingUserStrategy existingUserStrategy,
    String loginId,
    String loginIdType,
    Map<String, Object> state,
    VerificationStrategy verificationStrategy) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifyStartRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return VerifyStartRequestJSON.toJSONBytes(this);
  }

  public static VerifyStartRequest fromJSON(String json) {
    return VerifyStartRequestJSON.fromJSON(json);
  }

  public static VerifyStartRequest fromJSONBytes(byte[] json) {
    return VerifyStartRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private ExistingUserStrategy existingUserStrategy;
    private String loginId;
    private String loginIdType;
    private Map<String, Object> state;
    private VerificationStrategy verificationStrategy;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder existingUserStrategy(ExistingUserStrategy existingUserStrategy) { this.existingUserStrategy = existingUserStrategy; return this; }
    public Builder loginId(String loginId) { this.loginId = loginId; return this; }
    public Builder loginIdType(String loginIdType) { this.loginIdType = loginIdType; return this; }
    public Builder state(Map<String, Object> state) { this.state = state; return this; }
    public Builder verificationStrategy(VerificationStrategy verificationStrategy) { this.verificationStrategy = verificationStrategy; return this; }
    public VerifyStartRequest build() { return new VerifyStartRequest(applicationId, existingUserStrategy, loginId, loginIdType, state, verificationStrategy); }
  }
}
