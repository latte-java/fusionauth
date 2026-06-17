/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationResponseJSON;

@JSON
public record ApplicationResponse(
    Application application,
    List<Application> applications,
    ApplicationRole role) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ApplicationResponseJSON.toJSONBytes(this);
  }
  
  public static ApplicationResponse fromJSON(String json) {
    return ApplicationResponseJSON.fromJSON(json);
  }
  
  public static ApplicationResponse fromJSONBytes(byte[] json) {
    return ApplicationResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Application application;
    private List<Application> applications;
    private ApplicationRole role;
    public Builder application(Application application) { this.application = application; return this; }
    public Builder applications(List<Application> applications) { this.applications = applications; return this; }
    public Builder role(ApplicationRole role) { this.role = role; return this; }
    public ApplicationResponse build() { return new ApplicationResponse(application, applications, role); }
  }
}
