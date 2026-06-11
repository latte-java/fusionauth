/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ContextJSON;

@JSON
public record Context(
    String accessToken,
    MultiFactorAction action,
    Application application,
    Set<String> authenticationThreats,
    String authenticationType,
    EventInfo eventInfo,
    Trust mfaTrust,
    Policies policies) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ContextJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ContextJSON.toJSONBytes(this);
  }

  public static Context fromJSON(String json) {
    return ContextJSON.fromJSON(json);
  }

  public static Context fromJSONBytes(byte[] json) {
    return ContextJSON.fromJSON(json);
  }

  public static final class Builder {
    private String accessToken;
    private MultiFactorAction action;
    private Application application;
    private Set<String> authenticationThreats;
    private String authenticationType;
    private EventInfo eventInfo;
    private Trust mfaTrust;
    private Policies policies;
    public Builder accessToken(String accessToken) { this.accessToken = accessToken; return this; }
    public Builder action(MultiFactorAction action) { this.action = action; return this; }
    public Builder application(Application application) { this.application = application; return this; }
    public Builder authenticationThreats(Set<String> authenticationThreats) { this.authenticationThreats = authenticationThreats; return this; }
    public Builder authenticationType(String authenticationType) { this.authenticationType = authenticationType; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public Builder mfaTrust(Trust mfaTrust) { this.mfaTrust = mfaTrust; return this; }
    public Builder policies(Policies policies) { this.policies = policies; return this; }
    public Context build() { return new Context(accessToken, action, application, authenticationThreats, authenticationType, eventInfo, mfaTrust, policies); }
  }
}
