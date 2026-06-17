/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderLinkRequestJSON;

@JSON
public record IdentityProviderLinkRequest(
    IdentityProviderLink identityProviderLink,
    String pendingIdPLinkId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return IdentityProviderLinkRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return IdentityProviderLinkRequestJSON.toJSONBytes(this);
  }
  
  public static IdentityProviderLinkRequest fromJSON(String json) {
    return IdentityProviderLinkRequestJSON.fromJSON(json);
  }
  
  public static IdentityProviderLinkRequest fromJSONBytes(byte[] json) {
    return IdentityProviderLinkRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private IdentityProviderLink identityProviderLink;
    private String pendingIdPLinkId;
    private EventInfo eventInfo;
    public Builder identityProviderLink(IdentityProviderLink identityProviderLink) { this.identityProviderLink = identityProviderLink; return this; }
    public Builder pendingIdPLinkId(String pendingIdPLinkId) { this.pendingIdPLinkId = pendingIdPLinkId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public IdentityProviderLinkRequest build() { return new IdentityProviderLinkRequest(identityProviderLink, pendingIdPLinkId, eventInfo); }
  }
}
