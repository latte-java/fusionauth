/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ActionRequestJSON;

@JSON
public record ActionRequest(
    ActionData action,
    Boolean broadcast,
    EventInfo eventInfo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ActionRequestJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return ActionRequestJSON.toJSONBytes(this);
  }
  
  public static ActionRequest fromJSON(String json) {
    return ActionRequestJSON.fromJSON(json);
  }
  
  public static ActionRequest fromJSONBytes(byte[] json) {
    return ActionRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private ActionData action;
    private Boolean broadcast;
    private EventInfo eventInfo;
    public Builder action(ActionData action) { this.action = action; return this; }
    public Builder broadcast(Boolean broadcast) { this.broadcast = broadcast; return this; }
    public Builder eventInfo(EventInfo eventInfo) { this.eventInfo = eventInfo; return this; }
    public ActionRequest build() { return new ActionRequest(action, broadcast, eventInfo); }
  }
}
