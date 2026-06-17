/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.TenantCaptchaConfigurationJSON;

@JSON
public record TenantCaptchaConfiguration(
    CaptchaMethod captchaMethod,
    String secretKey,
    String siteKey,
    Double threshold,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return TenantCaptchaConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return TenantCaptchaConfigurationJSON.toJSONBytes(this);
  }
  
  public static TenantCaptchaConfiguration fromJSON(String json) {
    return TenantCaptchaConfigurationJSON.fromJSON(json);
  }
  
  public static TenantCaptchaConfiguration fromJSONBytes(byte[] json) {
    return TenantCaptchaConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private CaptchaMethod captchaMethod;
    private String secretKey;
    private String siteKey;
    private Double threshold;
    private Boolean enabled;
    public Builder captchaMethod(CaptchaMethod captchaMethod) { this.captchaMethod = captchaMethod; return this; }
    public Builder secretKey(String secretKey) { this.secretKey = secretKey; return this; }
    public Builder siteKey(String siteKey) { this.siteKey = siteKey; return this; }
    public Builder threshold(Double threshold) { this.threshold = threshold; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public TenantCaptchaConfiguration build() { return new TenantCaptchaConfiguration(captchaMethod, secretKey, siteKey, threshold, enabled); }
  }
}
