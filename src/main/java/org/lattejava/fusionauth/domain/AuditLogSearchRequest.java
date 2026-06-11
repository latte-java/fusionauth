/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.AuditLogSearchRequestJSON;

@JSON
public record AuditLogSearchRequest(
    AuditLogSearchCriteria search) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return AuditLogSearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return AuditLogSearchRequestJSON.toJSONBytes(this);
  }

  public static AuditLogSearchRequest fromJSON(String json) {
    return AuditLogSearchRequestJSON.fromJSON(json);
  }

  public static AuditLogSearchRequest fromJSONBytes(byte[] json) {
    return AuditLogSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private AuditLogSearchCriteria search;
    public Builder search(AuditLogSearchCriteria search) { this.search = search; return this; }
    public AuditLogSearchRequest build() { return new AuditLogSearchRequest(search); }
  }
}
