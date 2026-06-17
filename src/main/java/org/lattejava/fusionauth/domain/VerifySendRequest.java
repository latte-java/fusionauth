/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.VerifySendRequestJSON;

@JSON
public record VerifySendRequest(
    String verificationId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return VerifySendRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return VerifySendRequestJSON.toJSONBytes(this);
  }
  
  public static VerifySendRequest fromJSON(String json) {
    return VerifySendRequestJSON.fromJSON(json);
  }
  
  public static VerifySendRequest fromJSONBytes(byte[] json) {
    return VerifySendRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private String verificationId;
    public Builder verificationId(String verificationId) { this.verificationId = verificationId; return this; }
    public VerifySendRequest build() { return new VerifySendRequest(verificationId); }
  }
}
