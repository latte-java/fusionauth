/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.ApplicationSearchRequestJSON;

@JSON
public record ApplicationSearchRequest(
    ApplicationSearchCriteria search,
    List<String> expand) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return ApplicationSearchRequestJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return ApplicationSearchRequestJSON.toJSONBytes(this);
  }

  public static ApplicationSearchRequest fromJSON(String json) {
    return ApplicationSearchRequestJSON.fromJSON(json);
  }

  public static ApplicationSearchRequest fromJSONBytes(byte[] json) {
    return ApplicationSearchRequestJSON.fromJSON(json);
  }

  public static final class Builder {
    private ApplicationSearchCriteria search;
    private List<String> expand;
    public Builder search(ApplicationSearchCriteria search) { this.search = search; return this; }
    public Builder expand(List<String> expand) { this.expand = expand; return this; }
    public ApplicationSearchRequest build() { return new ApplicationSearchRequest(search, expand); }
  }
}
