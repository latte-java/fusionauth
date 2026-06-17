/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FaviconJSON;

@JSON
public record Favicon(
    String href,
    String rel,
    String sizes,
    String type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FaviconJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return FaviconJSON.toJSONBytes(this);
  }
  
  public static Favicon fromJSON(String json) {
    return FaviconJSON.fromJSON(json);
  }
  
  public static Favicon fromJSONBytes(byte[] json) {
    return FaviconJSON.fromJSON(json);
  }

  public static final class Builder {
    private String href;
    private String rel;
    private String sizes;
    private String type;
    public Builder href(String href) { this.href = href; return this; }
    public Builder rel(String rel) { this.rel = rel; return this; }
    public Builder sizes(String sizes) { this.sizes = sizes; return this; }
    public Builder type(String type) { this.type = type; return this; }
    public Favicon build() { return new Favicon(href, rel, sizes, type); }
  }
}
