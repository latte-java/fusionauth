/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.KeyJSON;

@JSON
public record Key(
    KeyAlgorithm algorithm,
    String certificate,
    CertificateInformation certificateInformation,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant expirationInstant,
    Boolean hasPrivateKey,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    String issuer,
    String kid,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUpdateInstant,
    Integer length,
    String name,
    String privateKey,
    String publicKey,
    String secret,
    KeyType type) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return KeyJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return KeyJSON.toJSONBytes(this);
  }
  
  public static Key fromJSON(String json) {
    return KeyJSON.fromJSON(json);
  }
  
  public static Key fromJSONBytes(byte[] json) {
    return KeyJSON.fromJSON(json);
  }

  public static final class Builder {
    private KeyAlgorithm algorithm;
    private String certificate;
    private CertificateInformation certificateInformation;
    private Instant expirationInstant;
    private Boolean hasPrivateKey;
    private UUID id;
    private Instant insertInstant;
    private String issuer;
    private String kid;
    private Instant lastUpdateInstant;
    private Integer length;
    private String name;
    private String privateKey;
    private String publicKey;
    private String secret;
    private KeyType type;
    public Builder algorithm(KeyAlgorithm algorithm) { this.algorithm = algorithm; return this; }
    public Builder certificate(String certificate) { this.certificate = certificate; return this; }
    public Builder certificateInformation(CertificateInformation certificateInformation) { this.certificateInformation = certificateInformation; return this; }
    public Builder expirationInstant(Instant expirationInstant) { this.expirationInstant = expirationInstant; return this; }
    public Builder hasPrivateKey(Boolean hasPrivateKey) { this.hasPrivateKey = hasPrivateKey; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder kid(String kid) { this.kid = kid; return this; }
    public Builder lastUpdateInstant(Instant lastUpdateInstant) { this.lastUpdateInstant = lastUpdateInstant; return this; }
    public Builder length(Integer length) { this.length = length; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder privateKey(String privateKey) { this.privateKey = privateKey; return this; }
    public Builder publicKey(String publicKey) { this.publicKey = publicKey; return this; }
    public Builder secret(String secret) { this.secret = secret; return this; }
    public Builder type(KeyType type) { this.type = type; return this; }
    public Key build() { return new Key(algorithm, certificate, certificateInformation, expirationInstant, hasPrivateKey, id, insertInstant, issuer, kid, lastUpdateInstant, length, name, privateKey, publicKey, secret, type); }
  }
}
