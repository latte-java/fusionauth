/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DeviceResponseJSON;

@JSON
public record DeviceResponse(
    String device_code,
    Integer expires_in,
    Integer interval,
    String user_code,
    String verification_uri,
    String verification_uri_complete) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DeviceResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return DeviceResponseJSON.toJSONBytes(this);
  }
  
  public static DeviceResponse fromJSON(String json) {
    return DeviceResponseJSON.fromJSON(json);
  }
  
  public static DeviceResponse fromJSONBytes(byte[] json) {
    return DeviceResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private String device_code;
    private Integer expires_in;
    private Integer interval;
    private String user_code;
    private String verification_uri;
    private String verification_uri_complete;
    public Builder device_code(String device_code) { this.device_code = device_code; return this; }
    public Builder expires_in(Integer expires_in) { this.expires_in = expires_in; return this; }
    public Builder interval(Integer interval) { this.interval = interval; return this; }
    public Builder user_code(String user_code) { this.user_code = user_code; return this; }
    public Builder verification_uri(String verification_uri) { this.verification_uri = verification_uri; return this; }
    public Builder verification_uri_complete(String verification_uri_complete) { this.verification_uri_complete = verification_uri_complete; return this; }
    public DeviceResponse build() { return new DeviceResponse(device_code, expires_in, interval, user_code, verification_uri, verification_uri_complete); }
  }
}
