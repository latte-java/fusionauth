/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderLinkResponseJSON;

@JSON
public record IdentityProviderLinkResponse(
    IdentityProviderLink identityProviderLink,
    List<IdentityProviderLink> identityProviderLinks) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderLinkResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return IdentityProviderLinkResponseJSON.toJSONBytes(this);
  }

  public static IdentityProviderLinkResponse fromJSON(String json) {
    return IdentityProviderLinkResponseJSON.fromJSON(json);
  }

  public static IdentityProviderLinkResponse fromJSONBytes(byte[] json) {
    return IdentityProviderLinkResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderLink identityProviderLink;
    private List<IdentityProviderLink> identityProviderLinks;
    public Builder identityProviderLink(IdentityProviderLink identityProviderLink) { this.identityProviderLink = identityProviderLink; return this; }
    public Builder identityProviderLinks(List<IdentityProviderLink> identityProviderLinks) { this.identityProviderLinks = identityProviderLinks; return this; }
    public IdentityProviderLinkResponse build() { return new IdentityProviderLinkResponse(identityProviderLink, identityProviderLinks); }
  }
}
