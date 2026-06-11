/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.JSONWebKeyInfoProviderJSON;

@JSON
public record JSONWebKeyInfoProvider() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return JSONWebKeyInfoProviderJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return JSONWebKeyInfoProviderJSON.toJSONBytes(this);
  }

  public static JSONWebKeyInfoProvider fromJSON(String json) {
    return JSONWebKeyInfoProviderJSON.fromJSON(json);
  }

  public static JSONWebKeyInfoProvider fromJSONBytes(byte[] json) {
    return JSONWebKeyInfoProviderJSON.fromJSON(json);
  }

  public static final class Builder {
    public JSONWebKeyInfoProvider build() { return new JSONWebKeyInfoProvider(); }
  }
}
