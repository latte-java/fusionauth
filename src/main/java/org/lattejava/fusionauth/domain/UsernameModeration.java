/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UsernameModerationJSON;

@JSON
public record UsernameModeration(
    UUID applicationId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UsernameModerationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UsernameModerationJSON.toJSONBytes(this);
  }

  public static UsernameModeration fromJSON(String json) {
    return UsernameModerationJSON.fromJSON(json);
  }

  public static UsernameModeration fromJSONBytes(byte[] json) {
    return UsernameModerationJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID applicationId;
    private Boolean enabled;
    public Builder applicationId(UUID applicationId) { this.applicationId = applicationId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public UsernameModeration build() { return new UsernameModeration(applicationId, enabled); }
  }
}
