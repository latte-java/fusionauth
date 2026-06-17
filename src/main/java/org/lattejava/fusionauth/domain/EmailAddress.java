/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailAddressJSON;

@JSON
public record EmailAddress(
    String address,
    String display) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailAddressJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return EmailAddressJSON.toJSONBytes(this);
  }
  
  public static EmailAddress fromJSON(String json) {
    return EmailAddressJSON.fromJSON(json);
  }
  
  public static EmailAddress fromJSONBytes(byte[] json) {
    return EmailAddressJSON.fromJSON(json);
  }

  public static final class Builder {
    private String address;
    private String display;
    public Builder address(String address) { this.address = address; return this; }
    public Builder display(String display) { this.display = display; return this; }
    public EmailAddress build() { return new EmailAddress(address, display); }
  }
}
