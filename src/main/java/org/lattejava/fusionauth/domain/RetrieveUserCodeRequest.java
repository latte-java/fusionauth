/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.RetrieveUserCodeRequestJSON;

@JSON
public record RetrieveUserCodeRequest(
    String client_id,
    String client_secret,
    UUID tenantId,
    String user_code) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return RetrieveUserCodeRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return RetrieveUserCodeRequestJSON.toJSONBytes(this);
  }
  
  public static RetrieveUserCodeRequest fromJSON(String json) {
    return RetrieveUserCodeRequestJSON.fromJSON(json);
  }
  
  public static RetrieveUserCodeRequest fromJSONBytes(byte[] json) {
    return RetrieveUserCodeRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private String client_secret;
    private UUID tenantId;
    private String user_code;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder client_secret(String client_secret) { this.client_secret = client_secret; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public RetrieveUserCodeRequest build() { return new RetrieveUserCodeRequest(client_id, client_secret, tenantId, user_code); }
  }
}
