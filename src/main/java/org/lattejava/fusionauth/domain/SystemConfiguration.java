/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SystemConfigurationJSON;

@JSON
public record SystemConfiguration(
    AuditLogConfiguration auditLogConfiguration,
    CORSConfiguration corsConfiguration,
    Map<String, Object> data,
    EventLogConfiguration eventLogConfiguration,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    LoginRecordConfiguration loginRecordConfiguration,
    String reportTimezone,
    SystemTrustedProxyConfiguration trustedProxyConfiguration,
    UIConfiguration uiConfiguration,
    UsageDataConfiguration usageDataConfiguration,
    WebhookEventLogConfiguration webhookEventLogConfiguration) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SystemConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return SystemConfigurationJSON.toJSONBytes(this);
  }
  
  public static SystemConfiguration fromJSON(String json) {
    return SystemConfigurationJSON.fromJSON(json);
  }
  
  public static SystemConfiguration fromJSONBytes(byte[] json) {
    return SystemConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuditLogConfiguration auditLogConfiguration;
    private CORSConfiguration corsConfiguration;
    private Map<String, Object> data;
    private EventLogConfiguration eventLogConfiguration;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private LoginRecordConfiguration loginRecordConfiguration;
    private String reportTimezone;
    private SystemTrustedProxyConfiguration trustedProxyConfiguration;
    private UIConfiguration uiConfiguration;
    private UsageDataConfiguration usageDataConfiguration;
    private WebhookEventLogConfiguration webhookEventLogConfiguration;
    public Builder auditLogConfiguration(AuditLogConfiguration auditLogConfiguration) { this.auditLogConfiguration = auditLogConfiguration; return this; }
    public Builder corsConfiguration(CORSConfiguration corsConfiguration) { this.corsConfiguration = corsConfiguration; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder eventLogConfiguration(EventLogConfiguration eventLogConfiguration) { this.eventLogConfiguration = eventLogConfiguration; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder loginRecordConfiguration(LoginRecordConfiguration loginRecordConfiguration) { this.loginRecordConfiguration = loginRecordConfiguration; return this; }
    public Builder reportTimezone(String reportTimezone) { this.reportTimezone = reportTimezone; return this; }
    public Builder trustedProxyConfiguration(SystemTrustedProxyConfiguration trustedProxyConfiguration) { this.trustedProxyConfiguration = trustedProxyConfiguration; return this; }
    public Builder uiConfiguration(UIConfiguration uiConfiguration) { this.uiConfiguration = uiConfiguration; return this; }
    public Builder usageDataConfiguration(UsageDataConfiguration usageDataConfiguration) { this.usageDataConfiguration = usageDataConfiguration; return this; }
    public Builder webhookEventLogConfiguration(WebhookEventLogConfiguration webhookEventLogConfiguration) { this.webhookEventLogConfiguration = webhookEventLogConfiguration; return this; }
    public SystemConfiguration build() { return new SystemConfiguration(auditLogConfiguration, corsConfiguration, data, eventLogConfiguration, insertInstant, lastUpdateInstant, loginRecordConfiguration, reportTimezone, trustedProxyConfiguration, uiConfiguration, usageDataConfiguration, webhookEventLogConfiguration); }
  }
}
