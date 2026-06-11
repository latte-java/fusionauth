/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IPAccessControlListJSON;

@JSON
public record IPAccessControlList(
    Map<String, Object> data,
    List<IPAccessControlEntry> entries,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IPAccessControlListJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IPAccessControlListJSON.toJSONBytes(this);
  }

  public static IPAccessControlList fromJSON(String json) {
    return IPAccessControlListJSON.fromJSON(json);
  }

  public static IPAccessControlList fromJSONBytes(byte[] json) {
    return IPAccessControlListJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> data;
    private List<IPAccessControlEntry> entries;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder entries(List<IPAccessControlEntry> entries) { this.entries = entries; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public IPAccessControlList build() { return new IPAccessControlList(data, entries, id, insertInstant, lastUpdateInstant, name); }
  }
}
