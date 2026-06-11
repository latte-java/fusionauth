/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookSignatureConfigurationJSON;

@JSON
public record WebhookSignatureConfiguration(
    UUID signingKeyId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookSignatureConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookSignatureConfigurationJSON.toJSONBytes(this);
  }

  public static WebhookSignatureConfiguration fromJSON(String json) {
    return WebhookSignatureConfigurationJSON.fromJSON(json);
  }

  public static WebhookSignatureConfiguration fromJSONBytes(byte[] json) {
    return WebhookSignatureConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID signingKeyId;
    private Boolean enabled;
    public Builder signingKeyId(UUID signingKeyId) { this.signingKeyId = signingKeyId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public WebhookSignatureConfiguration build() { return new WebhookSignatureConfiguration(signingKeyId, enabled); }
  }
}
