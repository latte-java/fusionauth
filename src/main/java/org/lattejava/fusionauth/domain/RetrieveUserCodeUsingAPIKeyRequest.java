/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RetrieveUserCodeUsingAPIKeyRequestJSON;

@JSON
public record RetrieveUserCodeUsingAPIKeyRequest(
    UUID tenantId,
    String user_code) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RetrieveUserCodeUsingAPIKeyRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RetrieveUserCodeUsingAPIKeyRequestJSON.toJSONBytes(this);
  }
  
  public static RetrieveUserCodeUsingAPIKeyRequest fromJSON(String json) {
    return RetrieveUserCodeUsingAPIKeyRequestJSON.fromJSON(json);
  }
  
  public static RetrieveUserCodeUsingAPIKeyRequest fromJSONBytes(byte[] json) {
    return RetrieveUserCodeUsingAPIKeyRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID tenantId;
    private String user_code;
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public RetrieveUserCodeUsingAPIKeyRequest build() { return new RetrieveUserCodeUsingAPIKeyRequest(tenantId, user_code); }
  }
}
