/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.HTTPHeadersJSON;

@JSON
public record HTTPHeaders() {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return HTTPHeadersJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return HTTPHeadersJSON.toJSONBytes(this);
  }

  public static HTTPHeaders fromJSON(String json) {
    return HTTPHeadersJSON.fromJSON(json);
  }

  public static HTTPHeaders fromJSONBytes(byte[] json) {
    return HTTPHeadersJSON.fromJSON(json);
  }

  public static final class Builder {
    public HTTPHeaders build() { return new HTTPHeaders(); }
  }
}
