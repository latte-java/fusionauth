/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DeviceInfoJSON;

@JSON
public record DeviceInfo(
    String description,
    String lastAccessedAddress,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastAccessedInstant,
    String name,
    String type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DeviceInfoJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return DeviceInfoJSON.toJSONBytes(this);
  }

  public static DeviceInfo fromJSON(String json) {
    return DeviceInfoJSON.fromJSON(json);
  }

  public static DeviceInfo fromJSONBytes(byte[] json) {
    return DeviceInfoJSON.fromJSON(json);
  }

  public static final class Builder {
    private String description;
    private String lastAccessedAddress;
    private Instant lastAccessedInstant;
    private String name;
    private String type;
    public Builder description(String description) { this.description = description; return this; }
    public Builder lastAccessedAddress(String lastAccessedAddress) { this.lastAccessedAddress = lastAccessedAddress; return this; }
    public Builder lastAccessedInstant(Instant lastAccessedInstant) { this.lastAccessedInstant = lastAccessedInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(String type) { this.type = type; return this; }
    public DeviceInfo build() { return new DeviceInfo(description, lastAccessedAddress, lastAccessedInstant, name, type); }
  }
}
