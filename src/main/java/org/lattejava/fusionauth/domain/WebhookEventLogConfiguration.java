/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebhookEventLogConfigurationJSON;

@JSON
public record WebhookEventLogConfiguration(
    DeleteConfiguration delete,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebhookEventLogConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebhookEventLogConfigurationJSON.toJSONBytes(this);
  }

  public static WebhookEventLogConfiguration fromJSON(String json) {
    return WebhookEventLogConfigurationJSON.fromJSON(json);
  }

  public static WebhookEventLogConfiguration fromJSONBytes(byte[] json) {
    return WebhookEventLogConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private DeleteConfiguration delete;
    private Boolean enabled;
    public Builder delete(DeleteConfiguration delete) { this.delete = delete; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public WebhookEventLogConfiguration build() { return new WebhookEventLogConfiguration(delete, enabled); }
  }
}
