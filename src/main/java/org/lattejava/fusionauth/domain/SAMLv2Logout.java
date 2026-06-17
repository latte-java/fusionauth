/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2LogoutJSON;

@JSON
public record SAMLv2Logout(
    SAMLLogoutBehavior behavior,
    UUID defaultVerificationKeyId,
    UUID keyId,
    Boolean requireSignedRequests,
    SAMLv2SingleLogout singleLogout,
    CanonicalizationMethod xmlSignatureC14nMethod) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2LogoutJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SAMLv2LogoutJSON.toJSONBytes(this);
  }
  
  public static SAMLv2Logout fromJSON(String json) {
    return SAMLv2LogoutJSON.fromJSON(json);
  }
  
  public static SAMLv2Logout fromJSONBytes(byte[] json) {
    return SAMLv2LogoutJSON.fromJSON(json);
  }

  public static final class Builder {
    private SAMLLogoutBehavior behavior;
    private UUID defaultVerificationKeyId;
    private UUID keyId;
    private Boolean requireSignedRequests;
    private SAMLv2SingleLogout singleLogout;
    private CanonicalizationMethod xmlSignatureC14nMethod;
    public Builder behavior(SAMLLogoutBehavior behavior) { this.behavior = behavior; return this; }
    public Builder defaultVerificationKeyId(UUID defaultVerificationKeyId) { this.defaultVerificationKeyId = defaultVerificationKeyId; return this; }
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder requireSignedRequests(Boolean requireSignedRequests) { this.requireSignedRequests = requireSignedRequests; return this; }
    public Builder singleLogout(SAMLv2SingleLogout singleLogout) { this.singleLogout = singleLogout; return this; }
    public Builder xmlSignatureC14nMethod(CanonicalizationMethod xmlSignatureC14nMethod) { this.xmlSignatureC14nMethod = xmlSignatureC14nMethod; return this; }
    public SAMLv2Logout build() { return new SAMLv2Logout(behavior, defaultVerificationKeyId, keyId, requireSignedRequests, singleLogout, xmlSignatureC14nMethod); }
  }
}
