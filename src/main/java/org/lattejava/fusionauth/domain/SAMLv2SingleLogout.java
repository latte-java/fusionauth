/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2SingleLogoutJSON;

@JSON
public record SAMLv2SingleLogout(
    UUID keyId,
    String url,
    CanonicalizationMethod xmlSignatureC14nMethod,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2SingleLogoutJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2SingleLogoutJSON.toJSONBytes(this);
  }

  public static SAMLv2SingleLogout fromJSON(String json) {
    return SAMLv2SingleLogoutJSON.fromJSON(json);
  }

  public static SAMLv2SingleLogout fromJSONBytes(byte[] json) {
    return SAMLv2SingleLogoutJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID keyId;
    private String url;
    private CanonicalizationMethod xmlSignatureC14nMethod;
    private Boolean enabled;
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder url(String url) { this.url = url; return this; }
    public Builder xmlSignatureC14nMethod(CanonicalizationMethod xmlSignatureC14nMethod) { this.xmlSignatureC14nMethod = xmlSignatureC14nMethod; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public SAMLv2SingleLogout build() { return new SAMLv2SingleLogout(keyId, url, xmlSignatureC14nMethod, enabled); }
  }
}
