/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JWTJSON;

@JSON
public record JWT(
    Map<String, Object> aud,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant exp,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant iat,
    String iss,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant nbf,
    Map<String, Object> otherClaims,
    String sub,
    String jti) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JWTJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JWTJSON.toJSONBytes(this);
  }

  public static JWT fromJSON(String json) {
    return JWTJSON.fromJSON(json);
  }

  public static JWT fromJSONBytes(byte[] json) {
    return JWTJSON.fromJSON(json);
  }

  public static final class Builder {
    private Map<String, Object> aud;
    private Instant exp;
    private Instant iat;
    private String iss;
    private Instant nbf;
    private Map<String, Object> otherClaims;
    private String sub;
    private String jti;
    public Builder aud(Map<String, Object> aud) { this.aud = aud; return this; }
    public Builder exp(Instant exp) { this.exp = exp; return this; }
    public Builder iat(Instant iat) { this.iat = iat; return this; }
    public Builder iss(String iss) { this.iss = iss; return this; }
    public Builder nbf(Instant nbf) { this.nbf = nbf; return this; }
    public Builder otherClaims(Map<String, Object> otherClaims) { this.otherClaims = otherClaims; return this; }
    public Builder sub(String sub) { this.sub = sub; return this; }
    public Builder jti(String jti) { this.jti = jti; return this; }
    public JWT build() { return new JWT(aud, exp, iat, iss, nbf, otherClaims, sub, jti); }
  }
}
