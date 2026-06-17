/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.UserDeleteResponseJSON;

@JSON
public record UserDeleteResponse(
    Boolean dryRun,
    Boolean hardDelete,
    Integer total,
    List<UUID> userIds) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return UserDeleteResponseJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return UserDeleteResponseJSON.toJSONBytes(this);
  }
  
  public static UserDeleteResponse fromJSON(String json) {
    return UserDeleteResponseJSON.fromJSON(json);
  }
  
  public static UserDeleteResponse fromJSONBytes(byte[] json) {
    return UserDeleteResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private Boolean dryRun;
    private Boolean hardDelete;
    private Integer total;
    private List<UUID> userIds;
    public Builder dryRun(Boolean dryRun) { this.dryRun = dryRun; return this; }
    public Builder hardDelete(Boolean hardDelete) { this.hardDelete = hardDelete; return this; }
    public Builder total(Integer total) { this.total = total; return this; }
    public Builder userIds(List<UUID> userIds) { this.userIds = userIds; return this; }
    public UserDeleteResponse build() { return new UserDeleteResponse(dryRun, hardDelete, total, userIds); }
  }
}
