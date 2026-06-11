/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EventConfigurationDataJSON;

@JSON
public record EventConfigurationData(
    TransactionType transactionType,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EventConfigurationDataJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EventConfigurationDataJSON.toJSONBytes(this);
  }

  public static EventConfigurationData fromJSON(String json) {
    return EventConfigurationDataJSON.fromJSON(json);
  }

  public static EventConfigurationData fromJSONBytes(byte[] json) {
    return EventConfigurationDataJSON.fromJSON(json);
  }

  public static final class Builder {
    private TransactionType transactionType;
    private Boolean enabled;
    public Builder transactionType(TransactionType transactionType) { this.transactionType = transactionType; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public EventConfigurationData build() { return new EventConfigurationData(transactionType, enabled); }
  }
}
