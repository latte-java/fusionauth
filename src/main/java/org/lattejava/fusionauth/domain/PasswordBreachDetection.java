/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.PasswordBreachDetectionJSON;

@JSON
public record PasswordBreachDetection(
    BreachMatchMode matchMode,
    UUID notifyUserEmailTemplateId,
    BreachAction onLogin,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return PasswordBreachDetectionJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return PasswordBreachDetectionJSON.toJSONBytes(this);
  }
  
  public static PasswordBreachDetection fromJSON(String json) {
    return PasswordBreachDetectionJSON.fromJSON(json);
  }
  
  public static PasswordBreachDetection fromJSONBytes(byte[] json) {
    return PasswordBreachDetectionJSON.fromJSON(json);
  }

  public static final class Builder {
    private BreachMatchMode matchMode;
    private UUID notifyUserEmailTemplateId;
    private BreachAction onLogin;
    private Boolean enabled;
    public Builder matchMode(BreachMatchMode matchMode) { this.matchMode = matchMode; return this; }
    public Builder notifyUserEmailTemplateId(UUID notifyUserEmailTemplateId) { this.notifyUserEmailTemplateId = notifyUserEmailTemplateId; return this; }
    public Builder onLogin(BreachAction onLogin) { this.onLogin = onLogin; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public PasswordBreachDetection build() { return new PasswordBreachDetection(matchMode, notifyUserEmailTemplateId, onLogin, enabled); }
  }
}
