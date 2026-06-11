/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.FamilyConfigurationJSON;

@JSON
public record FamilyConfiguration(
    Boolean allowChildRegistrations,
    UUID confirmChildEmailTemplateId,
    Boolean deleteOrphanedAccounts,
    Integer deleteOrphanedAccountsDays,
    UUID familyRequestEmailTemplateId,
    Integer maximumChildAge,
    Integer minimumOwnerAge,
    Boolean parentEmailRequired,
    UUID parentRegistrationEmailTemplateId,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return FamilyConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return FamilyConfigurationJSON.toJSONBytes(this);
  }

  public static FamilyConfiguration fromJSON(String json) {
    return FamilyConfigurationJSON.fromJSON(json);
  }

  public static FamilyConfiguration fromJSONBytes(byte[] json) {
    return FamilyConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean allowChildRegistrations;
    private UUID confirmChildEmailTemplateId;
    private Boolean deleteOrphanedAccounts;
    private Integer deleteOrphanedAccountsDays;
    private UUID familyRequestEmailTemplateId;
    private Integer maximumChildAge;
    private Integer minimumOwnerAge;
    private Boolean parentEmailRequired;
    private UUID parentRegistrationEmailTemplateId;
    private Boolean enabled;
    public Builder allowChildRegistrations(Boolean allowChildRegistrations) { this.allowChildRegistrations = allowChildRegistrations; return this; }
    public Builder confirmChildEmailTemplateId(UUID confirmChildEmailTemplateId) { this.confirmChildEmailTemplateId = confirmChildEmailTemplateId; return this; }
    public Builder deleteOrphanedAccounts(Boolean deleteOrphanedAccounts) { this.deleteOrphanedAccounts = deleteOrphanedAccounts; return this; }
    public Builder deleteOrphanedAccountsDays(Integer deleteOrphanedAccountsDays) { this.deleteOrphanedAccountsDays = deleteOrphanedAccountsDays; return this; }
    public Builder familyRequestEmailTemplateId(UUID familyRequestEmailTemplateId) { this.familyRequestEmailTemplateId = familyRequestEmailTemplateId; return this; }
    public Builder maximumChildAge(Integer maximumChildAge) { this.maximumChildAge = maximumChildAge; return this; }
    public Builder minimumOwnerAge(Integer minimumOwnerAge) { this.minimumOwnerAge = minimumOwnerAge; return this; }
    public Builder parentEmailRequired(Boolean parentEmailRequired) { this.parentEmailRequired = parentEmailRequired; return this; }
    public Builder parentRegistrationEmailTemplateId(UUID parentRegistrationEmailTemplateId) { this.parentRegistrationEmailTemplateId = parentRegistrationEmailTemplateId; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public FamilyConfiguration build() { return new FamilyConfiguration(allowChildRegistrations, confirmChildEmailTemplateId, deleteOrphanedAccounts, deleteOrphanedAccountsDays, familyRequestEmailTemplateId, maximumChildAge, minimumOwnerAge, parentEmailRequired, parentRegistrationEmailTemplateId, enabled); }
  }
}
