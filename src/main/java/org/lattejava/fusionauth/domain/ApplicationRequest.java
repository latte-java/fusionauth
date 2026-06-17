/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationRequestJSON;

@JSON
public record ApplicationRequest(
    Application application,
    ApplicationRole role,
    UUID sourceApplicationId,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationRequestJSON.toJSONBytes(this);
  }
  
  public static ApplicationRequest fromJSON(String json) {
    return ApplicationRequestJSON.fromJSON(json);
  }
  
  public static ApplicationRequest fromJSONBytes(byte[] json) {
    return ApplicationRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Application application;
    private ApplicationRole role;
    private UUID sourceApplicationId;
    private EventInfo eventInfo;
    public Builder application(Application application) { this.application = application; return this; }
    public Builder role(ApplicationRole role) { this.role = role; return this; }
    public Builder sourceApplicationId(UUID sourceApplicationId) { this.sourceApplicationId = sourceApplicationId; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public ApplicationRequest build() { return new ApplicationRequest(application, role, sourceApplicationId, eventInfo); }
  }
}
