/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.BaseLoginRequestJSON;

@JSON
public record BaseLoginRequest(
    UUID applicationId,
    String ipAddress,
    MetaData metaData,
    Boolean newDevice,
    Boolean noJWT,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return BaseLoginRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return BaseLoginRequestJSON.toJSONBytes(this);
  }

  public static BaseLoginRequest fromJSON(String json) {
    return BaseLoginRequestJSON.fromJSON(json);
  }

  public static BaseLoginRequest fromJSONBytes(byte[] json) {
    return BaseLoginRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private String ipAddress;
    private MetaData metaData;
    private Boolean newDevice;
    private Boolean noJWT;
    private EventInfo eventInfo;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
    public Builder metaData(MetaData metaData) { this.metaData = metaData; return this; }
    public Builder newDevice(Boolean newDevice) { this.newDevice = newDevice; return this; }
    public Builder noJWT(Boolean noJWT) { this.noJWT = noJWT; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public BaseLoginRequest build() { return new BaseLoginRequest(applicationId, ipAddress, metaData, newDevice, noJWT, eventInfo); }
  }
}
