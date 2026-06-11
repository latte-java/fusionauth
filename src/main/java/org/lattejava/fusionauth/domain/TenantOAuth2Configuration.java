/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantOAuth2ConfigurationJSON;

@JSON
public record TenantOAuth2Configuration(
    UUID clientCredentialsAccessTokenPopulateLambdaId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantOAuth2ConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return TenantOAuth2ConfigurationJSON.toJSONBytes(this);
  }

  public static TenantOAuth2Configuration fromJSON(String json) {
    return TenantOAuth2ConfigurationJSON.fromJSON(json);
  }

  public static TenantOAuth2Configuration fromJSONBytes(byte[] json) {
    return TenantOAuth2ConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID clientCredentialsAccessTokenPopulateLambdaId;
    public Builder clientCredentialsAccessTokenPopulateLambdaId(UUID clientCredentialsAccessTokenPopulateLambdaId) { this.clientCredentialsAccessTokenPopulateLambdaId = clientCredentialsAccessTokenPopulateLambdaId; return this; }
    public TenantOAuth2Configuration build() { return new TenantOAuth2Configuration(clientCredentialsAccessTokenPopulateLambdaId); }
  }
}
