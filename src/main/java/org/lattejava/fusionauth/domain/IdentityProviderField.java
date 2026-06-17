/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.IdentityProviderFieldJSON;

@JSON
@JSONTypeInfo(property = "type")
public sealed interface IdentityProviderField
    permits AppleIdentityProvider,
            EpicGamesIdentityProvider,
            ExternalJWTIdentityProvider,
            FacebookIdentityProvider,
            GoogleIdentityProvider,
            HYPRIdentityProvider,
            LinkedInIdentityProvider,
            NintendoIdentityProvider,
            OpenIdConnectIdentityProvider,
            SAMLv2IdPInitiatedIdentityProvider,
            SAMLv2IdentityProvider,
            SonyPSNIdentityProvider,
            SteamIdentityProvider,
            TwitchIdentityProvider,
            TwitterIdentityProvider,
            XboxIdentityProvider {

  default String toJSON() {
    return IdentityProviderFieldJSON.toJSON(this);
  }
  
  default byte[] toJSONBytes() {
    return IdentityProviderFieldJSON.toJSONBytes(this);
  }
  
  static IdentityProviderField fromJSON(String json) {
    return IdentityProviderFieldJSON.fromJSON(json);
  }
  
  static IdentityProviderField fromJSONBytes(byte[] json) {
    return IdentityProviderFieldJSON.fromJSON(json);
  }
}
