/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LogHistoryJSON;

@JSON
public record LogHistory(
    List<HistoryItem> historyItems) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LogHistoryJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LogHistoryJSON.toJSONBytes(this);
  }

  public static LogHistory fromJSON(String json) {
    return LogHistoryJSON.fromJSON(json);
  }

  public static LogHistory fromJSONBytes(byte[] json) {
    return LogHistoryJSON.fromJSON(json);
  }

  public static final class Builder {
    private List<HistoryItem> historyItems;
    public Builder historyItems(List<HistoryItem> historyItems) { this.historyItems = historyItems; return this; }
    public LogHistory build() { return new LogHistory(historyItems); }
  }
}
