/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JSONWebKeyJSON;

@JSON
public record JSONWebKey(
    Algorithm alg,
    String crv,
    String d,
    String dp,
    String dq,
    String e,
    String kid,
    KeyType kty,
    String n,
    Map<String, Object> other,
    String p,
    String q,
    String qi,
    String use,
    String x,
    List<String> x5c,
    String x5t,
    @JSONField(name = "x5t#S256") String x5tS256,
    String y) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JSONWebKeyJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return JSONWebKeyJSON.toJSONBytes(this);
  }
  
  public static JSONWebKey fromJSON(String json) {
    return JSONWebKeyJSON.fromJSON(json);
  }
  
  public static JSONWebKey fromJSONBytes(byte[] json) {
    return JSONWebKeyJSON.fromJSON(json);
  }

  public static final class Builder {
    private Algorithm alg;
    private String crv;
    private String d;
    private String dp;
    private String dq;
    private String e;
    private String kid;
    private KeyType kty;
    private String n;
    private Map<String, Object> other;
    private String p;
    private String q;
    private String qi;
    private String use;
    private String x;
    private List<String> x5c;
    private String x5t;
    private String x5tS256;
    private String y;
    public Builder alg(Algorithm alg) { this.alg = alg; return this; }
    public Builder crv(String crv) { this.crv = crv; return this; }
    public Builder d(String d) { this.d = d; return this; }
    public Builder dp(String dp) { this.dp = dp; return this; }
    public Builder dq(String dq) { this.dq = dq; return this; }
    public Builder e(String e) { this.e = e; return this; }
    public Builder kid(String kid) { this.kid = kid; return this; }
    public Builder kty(KeyType kty) { this.kty = kty; return this; }
    public Builder n(String n) { this.n = n; return this; }
    public Builder other(Map<String, Object> other) { this.other = other; return this; }
    public Builder p(String p) { this.p = p; return this; }
    public Builder q(String q) { this.q = q; return this; }
    public Builder qi(String qi) { this.qi = qi; return this; }
    public Builder use(String use) { this.use = use; return this; }
    public Builder x(String x) { this.x = x; return this; }
    public Builder x5c(List<String> x5c) { this.x5c = x5c; return this; }
    public Builder x5t(String x5t) { this.x5t = x5t; return this; }
    public Builder x5tS256(String x5tS256) { this.x5tS256 = x5tS256; return this; }
    public Builder y(String y) { this.y = y; return this; }
    public JSONWebKey build() { return new JSONWebKey(alg, crv, d, dp, dq, e, kid, kty, n, other, p, q, qi, use, x, x5c, x5t, x5tS256, y); }
  }
}
