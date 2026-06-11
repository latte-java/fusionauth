/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ActionResponseJSON;

@JSON
public record ActionResponse(
    UserActionLog action,
    List<UserActionLog> actions) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ActionResponseJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ActionResponseJSON.toJSONBytes(this);
  }

  public static ActionResponse fromJSON(String json) {
    return ActionResponseJSON.fromJSON(json);
  }

  public static ActionResponse fromJSONBytes(byte[] json) {
    return ActionResponseJSON.fromJSON(json);
  }

  public static final class Builder {
    private UserActionLog action;
    private List<UserActionLog> actions;
    public Builder action(UserActionLog action) { this.action = action; return this; }
    public Builder actions(List<UserActionLog> actions) { this.actions = actions; return this; }
    public ActionResponse build() { return new ActionResponse(action, actions); }
  }
}
