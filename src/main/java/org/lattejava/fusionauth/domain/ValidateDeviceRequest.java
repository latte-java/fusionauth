/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ValidateDeviceRequestJSON;

@JSON
public record ValidateDeviceRequest(
    String client_id,
    UUID tenantId,
    String user_code) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ValidateDeviceRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ValidateDeviceRequestJSON.toJSONBytes(this);
  }

  public static ValidateDeviceRequest fromJSON(String json) {
    return ValidateDeviceRequestJSON.fromJSON(json);
  }

  public static ValidateDeviceRequest fromJSONBytes(byte[] json) {
    return ValidateDeviceRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String client_id;
    private UUID tenantId;
    private String user_code;
    public Builder client_id(String client_id) { this.client_id = client_id; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public ValidateDeviceRequest build() { return new ValidateDeviceRequest(client_id, tenantId, user_code); }
  }
}
