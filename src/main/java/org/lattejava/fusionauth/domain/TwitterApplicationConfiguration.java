/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TwitterApplicationConfigurationJSON;

@JSON
public record TwitterApplicationConfiguration(
    String buttonText,
    String consumerKey,
    String consumerSecret,
    Map<String, Object> data,
    Boolean createRegistration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TwitterApplicationConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TwitterApplicationConfigurationJSON.toJSONBytes(this);
  }
  
  public static TwitterApplicationConfiguration fromJSON(String json) {
    return TwitterApplicationConfigurationJSON.fromJSON(json);
  }
  
  public static TwitterApplicationConfiguration fromJSONBytes(byte[] json) {
    return TwitterApplicationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String buttonText;
    private String consumerKey;
    private String consumerSecret;
    private Map<String, Object> data;
    private Boolean createRegistration;
    public Builder buttonText(String buttonText) { this.buttonText = buttonText; return this; }
    public Builder consumerKey(String consumerKey) { this.consumerKey = consumerKey; return this; }
    public Builder consumerSecret(String consumerSecret) { this.consumerSecret = consumerSecret; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder createRegistration(Boolean createRegistration) { this.createRegistration = createRegistration; return this; }
    public TwitterApplicationConfiguration build() { return new TwitterApplicationConfiguration(buttonText, consumerKey, consumerSecret, data, createRegistration); }
  }
}
