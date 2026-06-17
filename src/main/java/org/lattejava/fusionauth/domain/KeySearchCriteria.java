/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KeySearchCriteriaJSON;

@JSON
public record KeySearchCriteria(
    KeyAlgorithm algorithm,
    String name,
    KeyType type,
    Integer numberOfResults,
    String orderBy,
    Integer startRow) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KeySearchCriteriaJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return KeySearchCriteriaJSON.toJSONBytes(this);
  }
  
  public static KeySearchCriteria fromJSON(String json) {
    return KeySearchCriteriaJSON.fromJSON(json);
  }
  
  public static KeySearchCriteria fromJSONBytes(byte[] json) {
    return KeySearchCriteriaJSON.fromJSON(json);
  }

  public static final class Builder {
    private KeyAlgorithm algorithm;
    private String name;
    private KeyType type;
    private Integer numberOfResults;
    private String orderBy;
    private Integer startRow;
    public Builder algorithm(KeyAlgorithm algorithm) { this.algorithm = algorithm; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(KeyType type) { this.type = type; return this; }
    public Builder numberOfResults(Integer numberOfResults) { this.numberOfResults = numberOfResults; return this; }
    public Builder orderBy(String orderBy) { this.orderBy = orderBy; return this; }
    public Builder startRow(Integer startRow) { this.startRow = startRow; return this; }
    public KeySearchCriteria build() { return new KeySearchCriteria(algorithm, name, type, numberOfResults, orderBy, startRow); }
  }
}
