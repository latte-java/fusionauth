/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.LocationJSON;

@JSON
public record Location(
    String city,
    String country,
    Double latitude,
    Double longitude,
    String region,
    String zipcode,
    String displayString) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return LocationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return LocationJSON.toJSONBytes(this);
  }

  public static Location fromJSON(String json) {
    return LocationJSON.fromJSON(json);
  }

  public static Location fromJSONBytes(byte[] json) {
    return LocationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private String region;
    private String zipcode;
    private String displayString;
    public Builder city(String city) { this.city = city; return this; }
    public Builder country(String country) { this.country = country; return this; }
    public Builder latitude(Double latitude) { this.latitude = latitude; return this; }
    public Builder longitude(Double longitude) { this.longitude = longitude; return this; }
    public Builder region(String region) { this.region = region; return this; }
    public Builder zipcode(String zipcode) { this.zipcode = zipcode; return this; }
    public Builder displayString(String displayString) { this.displayString = displayString; return this; }
    public Location build() { return new Location(city, country, latitude, longitude, region, zipcode, displayString); }
  }
}
