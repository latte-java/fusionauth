/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.CleanSpeakConfigurationJSON;

@JSON
public record CleanSpeakConfiguration(
    String apiKey,
    List<UUID> applicationIds,
    String url,
    UsernameModeration usernameModeration,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return CleanSpeakConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return CleanSpeakConfigurationJSON.toJSONBytes(this);
  }
  
  public static CleanSpeakConfiguration fromJSON(String json) {
    return CleanSpeakConfigurationJSON.fromJSON(json);
  }
  
  public static CleanSpeakConfiguration fromJSONBytes(byte[] json) {
    return CleanSpeakConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String apiKey;
    private List<UUID> applicationIds;
    private String url;
    private UsernameModeration usernameModeration;
    private Boolean enabled;
    public Builder apiKey(String apiKey) { this.apiKey = apiKey; return this; }
    public Builder applicationIds(List<UUID> applicationIds) { this.applicationIds = applicationIds; return this; }
    public Builder url(String url) { this.url = url; return this; }
    public Builder usernameModeration(UsernameModeration usernameModeration) { this.usernameModeration = usernameModeration; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public CleanSpeakConfiguration build() { return new CleanSpeakConfiguration(apiKey, applicationIds, url, usernameModeration, enabled); }
  }
}
