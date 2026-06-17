/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.DeleteConfigurationJSON;

@JSON
public record DeleteConfiguration(
    Integer numberOfDaysToRetain,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return DeleteConfigurationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return DeleteConfigurationJSON.toJSONBytes(this);
  }
  
  public static DeleteConfiguration fromJSON(String json) {
    return DeleteConfigurationJSON.fromJSON(json);
  }
  
  public static DeleteConfiguration fromJSONBytes(byte[] json) {
    return DeleteConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private Integer numberOfDaysToRetain;
    private Boolean enabled;
    public Builder numberOfDaysToRetain(Integer numberOfDaysToRetain) { this.numberOfDaysToRetain = numberOfDaysToRetain; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public DeleteConfiguration build() { return new DeleteConfiguration(numberOfDaysToRetain, enabled); }
  }
}
