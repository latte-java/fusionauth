/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventInfoJSON;

@JSON
public record EventInfo(
    Map<String, Object> data,
    String deviceDescription,
    String deviceName,
    String deviceType,
    String ipAddress,
    Location location,
    String os,
    String userAgent) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventInfoJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EventInfoJSON.toJSONBytes(this);
  }

  public static EventInfo fromJSON(String json) {
    return EventInfoJSON.fromJSON(json);
  }

  public static EventInfo fromJSONBytes(byte[] json) {
    return EventInfoJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private String deviceDescription;
    private String deviceName;
    private String deviceType;
    private String ipAddress;
    private Location location;
    private String os;
    private String userAgent;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder deviceDescription(String deviceDescription) { this.deviceDescription = deviceDescription; return this; }
    public Builder deviceName(String deviceName) { this.deviceName = deviceName; return this; }
    public Builder deviceType(String deviceType) { this.deviceType = deviceType; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder location(Location location) { this.location = location; return this; }
    public Builder os(String os) { this.os = os; return this; }
    public Builder userAgent(String userAgent) { this.userAgent = userAgent; return this; }
    public EventInfo build() { return new EventInfo(data, deviceDescription, deviceName, deviceType, ipAddress, location, os, userAgent); }
  }
}
