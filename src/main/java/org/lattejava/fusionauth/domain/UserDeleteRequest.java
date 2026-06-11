/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserDeleteRequestJSON;

@JSON
public record UserDeleteRequest(
    Boolean dryRun,
    Boolean hardDelete,
    Integer limit,
    String query,
    String queryString,
    List<UUID> userIds,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserDeleteRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return UserDeleteRequestJSON.toJSONBytes(this);
  }

  public static UserDeleteRequest fromJSON(String json) {
    return UserDeleteRequestJSON.fromJSON(json);
  }

  public static UserDeleteRequest fromJSONBytes(byte[] json) {
    return UserDeleteRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean dryRun;
    private Boolean hardDelete;
    private Integer limit;
    private String query;
    private String queryString;
    private List<UUID> userIds;
    private EventInfo eventInfo;
    public Builder dryRun(Boolean dryRun) { this.dryRun = dryRun; return this; }
    public Builder hardDelete(Boolean hardDelete) { this.hardDelete = hardDelete; return this; }
    public Builder limit(Integer limit) { this.limit = limit; return this; }
    public Builder query(String query) { this.query = query; return this; }
    public Builder queryString(String queryString) { this.queryString = queryString; return this; }
    public Builder userIds(List<UUID> userIds) { this.userIds = userIds; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public UserDeleteRequest build() { return new UserDeleteRequest(dryRun, hardDelete, limit, query, queryString, userIds, eventInfo); }
  }
}
