/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.MetaDataJSON;

@JSON
public record MetaData(
    Map<String, Object> data,
    DeviceInfo device,
    List<String> resources,
    Set<String> scopes) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return MetaDataJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return MetaDataJSON.toJSONBytes(this);
  }
  
  public static MetaData fromJSON(String json) {
    return MetaDataJSON.fromJSON(json);
  }
  
  public static MetaData fromJSONBytes(byte[] json) {
    return MetaDataJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private DeviceInfo device;
    private List<String> resources;
    private Set<String> scopes;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder device(DeviceInfo device) { this.device = device; return this; }
    public Builder resources(List<String> resources) { this.resources = resources; return this; }
    public Builder scopes(Set<String> scopes) { this.scopes = scopes; return this; }
    public MetaData build() { return new MetaData(data, device, resources, scopes); }
  }
}
