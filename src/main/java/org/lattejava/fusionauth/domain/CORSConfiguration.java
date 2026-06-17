/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.CORSConfigurationJSON;

@JSON
public record CORSConfiguration(
    Boolean allowCredentials,
    List<String> allowedHeaders,
    List<HTTPMethod> allowedMethods,
    List<String> allowedOrigins,
    Boolean debug,
    List<String> exposedHeaders,
    Integer preflightMaxAgeInSeconds,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return CORSConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return CORSConfigurationJSON.toJSONBytes(this);
  }
  
  public static CORSConfiguration fromJSON(String json) {
    return CORSConfigurationJSON.fromJSON(json);
  }
  
  public static CORSConfiguration fromJSONBytes(byte[] json) {
    return CORSConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean allowCredentials;
    private List<String> allowedHeaders;
    private List<HTTPMethod> allowedMethods;
    private List<String> allowedOrigins;
    private Boolean debug;
    private List<String> exposedHeaders;
    private Integer preflightMaxAgeInSeconds;
    private Boolean enabled;
    public Builder allowCredentials(Boolean allowCredentials) { this.allowCredentials = allowCredentials; return this; }
    public Builder allowedHeaders(List<String> allowedHeaders) { this.allowedHeaders = allowedHeaders; return this; }
    public Builder allowedMethods(List<HTTPMethod> allowedMethods) { this.allowedMethods = allowedMethods; return this; }
    public Builder allowedOrigins(List<String> allowedOrigins) { this.allowedOrigins = allowedOrigins; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder exposedHeaders(List<String> exposedHeaders) { this.exposedHeaders = exposedHeaders; return this; }
    public Builder preflightMaxAgeInSeconds(Integer preflightMaxAgeInSeconds) { this.preflightMaxAgeInSeconds = preflightMaxAgeInSeconds; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public CORSConfiguration build() { return new CORSConfiguration(allowCredentials, allowedHeaders, allowedMethods, allowedOrigins, debug, exposedHeaders, preflightMaxAgeInSeconds, enabled); }
  }
}
