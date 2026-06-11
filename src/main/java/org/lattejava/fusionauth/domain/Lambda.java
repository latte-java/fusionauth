/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LambdaJSON;

@JSON
public record Lambda(
    String body,
    Boolean debug,
    LambdaEngineType engineType,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    String name,
    LambdaType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LambdaJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LambdaJSON.toJSONBytes(this);
  }

  public static Lambda fromJSON(String json) {
    return LambdaJSON.fromJSON(json);
  }

  public static Lambda fromJSONBytes(byte[] json) {
    return LambdaJSON.fromJSON(json);
  }

  public static final class Builder {
    private String body;
    private Boolean debug;
    private LambdaEngineType engineType;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUpdateInstant;
    private String name;
    private LambdaType type;
    public Builder body(String body) { this.body = body; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder engineType(LambdaEngineType engineType) { this.engineType = engineType; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder type(LambdaType type) { this.type = type; return this; }
    public Lambda build() { return new Lambda(body, debug, engineType, id, insertInstant, lastUpdateInstant, name, type); }
  }
}
