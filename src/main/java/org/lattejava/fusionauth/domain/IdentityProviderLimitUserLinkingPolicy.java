/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderLimitUserLinkingPolicyJSON;

@JSON
public record IdentityProviderLimitUserLinkingPolicy(
    Integer maximumLinks,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderLimitUserLinkingPolicyJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderLimitUserLinkingPolicyJSON.toJSONBytes(this);
  }

  public static IdentityProviderLimitUserLinkingPolicy fromJSON(String json) {
    return IdentityProviderLimitUserLinkingPolicyJSON.fromJSON(json);
  }

  public static IdentityProviderLimitUserLinkingPolicy fromJSONBytes(byte[] json) {
    return IdentityProviderLimitUserLinkingPolicyJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer maximumLinks;
    private Boolean enabled;
    public Builder maximumLinks(Integer maximumLinks) { this.maximumLinks = maximumLinks; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public IdentityProviderLimitUserLinkingPolicy build() { return new IdentityProviderLimitUserLinkingPolicy(maximumLinks, enabled); }
  }
}
