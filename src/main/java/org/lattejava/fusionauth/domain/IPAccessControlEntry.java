/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IPAccessControlEntryJSON;

@JSON
public record IPAccessControlEntry(
    IPAccessControlEntryAction action,
    String endIPAddress,
    String startIPAddress) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IPAccessControlEntryJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IPAccessControlEntryJSON.toJSONBytes(this);
  }

  public static IPAccessControlEntry fromJSON(String json) {
    return IPAccessControlEntryJSON.fromJSON(json);
  }

  public static IPAccessControlEntry fromJSONBytes(byte[] json) {
    return IPAccessControlEntryJSON.fromJSON(json);
  }

  public static final class Builder {
    private IPAccessControlEntryAction action;
    private String endIPAddress;
    private String startIPAddress;
    public Builder action(IPAccessControlEntryAction action) { this.action = action; return this; }
    public Builder endIPAddress(String endIPAddress) { this.endIPAddress = endIPAddress; return this; }
    public Builder startIPAddress(String startIPAddress) { this.startIPAddress = startIPAddress; return this; }
    public IPAccessControlEntry build() { return new IPAccessControlEntry(action, endIPAddress, startIPAddress); }
  }
}
