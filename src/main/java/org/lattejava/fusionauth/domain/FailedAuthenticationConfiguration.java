/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FailedAuthenticationConfigurationJSON;

@JSON
public record FailedAuthenticationConfiguration(
    FailedAuthenticationActionCancelPolicy actionCancelPolicy,
    Long actionDuration,
    ExpiryUnit actionDurationUnit,
    Boolean emailUser,
    Integer resetCountInSeconds,
    Integer tooManyAttempts,
    UUID userActionId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FailedAuthenticationConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FailedAuthenticationConfigurationJSON.toJSONBytes(this);
  }

  public static FailedAuthenticationConfiguration fromJSON(String json) {
    return FailedAuthenticationConfigurationJSON.fromJSON(json);
  }

  public static FailedAuthenticationConfiguration fromJSONBytes(byte[] json) {
    return FailedAuthenticationConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private FailedAuthenticationActionCancelPolicy actionCancelPolicy;
    private Long actionDuration;
    private ExpiryUnit actionDurationUnit;
    private Boolean emailUser;
    private Integer resetCountInSeconds;
    private Integer tooManyAttempts;
    private UUID userActionId;
    public Builder actionCancelPolicy(FailedAuthenticationActionCancelPolicy actionCancelPolicy) { this.actionCancelPolicy = actionCancelPolicy; return this; }
    public Builder actionDuration(Long actionDuration) { this.actionDuration = actionDuration; return this; }
    public Builder actionDurationUnit(ExpiryUnit actionDurationUnit) { this.actionDurationUnit = actionDurationUnit; return this; }
    public Builder emailUser(Boolean emailUser) { this.emailUser = emailUser; return this; }
    public Builder resetCountInSeconds(Integer resetCountInSeconds) { this.resetCountInSeconds = resetCountInSeconds; return this; }
    public Builder tooManyAttempts(Integer tooManyAttempts) { this.tooManyAttempts = tooManyAttempts; return this; }
    public Builder userActionId(UUID userActionId) { this.userActionId = userActionId; return this; }
    public FailedAuthenticationConfiguration build() { return new FailedAuthenticationConfiguration(actionCancelPolicy, actionDuration, actionDurationUnit, emailUser, resetCountInSeconds, tooManyAttempts, userActionId); }
  }
}
