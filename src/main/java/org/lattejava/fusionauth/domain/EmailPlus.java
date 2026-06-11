/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.EmailPlusJSON;

@JSON
public record EmailPlus(
    UUID emailTemplateId,
    Integer maximumTimeToSendEmailInHours,
    Integer minimumTimeToSendEmailInHours,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return EmailPlusJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return EmailPlusJSON.toJSONBytes(this);
  }

  public static EmailPlus fromJSON(String json) {
    return EmailPlusJSON.fromJSON(json);
  }

  public static EmailPlus fromJSONBytes(byte[] json) {
    return EmailPlusJSON.fromJSON(json);
  }

  public static final class Builder {
    private UUID emailTemplateId;
    private Integer maximumTimeToSendEmailInHours;
    private Integer minimumTimeToSendEmailInHours;
    private Boolean enabled;
    public Builder emailTemplateId(UUID emailTemplateId) { this.emailTemplateId = emailTemplateId; return this; }
    public Builder maximumTimeToSendEmailInHours(Integer maximumTimeToSendEmailInHours) { this.maximumTimeToSendEmailInHours = maximumTimeToSendEmailInHours; return this; }
    public Builder minimumTimeToSendEmailInHours(Integer minimumTimeToSendEmailInHours) { this.minimumTimeToSendEmailInHours = minimumTimeToSendEmailInHours; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public EmailPlus build() { return new EmailPlus(emailTemplateId, maximumTimeToSendEmailInHours, minimumTimeToSendEmailInHours, enabled); }
  }
}
