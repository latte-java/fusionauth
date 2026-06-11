/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.WebAuthnCredentialJSON;

@JSON
public record WebAuthnCredential(
    CoseAlgorithmIdentifier algorithm,
    AttestationType attestationType,
    Boolean authenticatorSupportsUserVerification,
    String credentialId,
    Map<String, Object> data,
    Boolean discoverable,
    String displayName,
    UUID id,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant insertInstant,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant lastUseInstant,
    String name,
    String publicKey,
    String relyingPartyId,
    Integer signCount,
    UUID tenantId,
    List<String> transports,
    String userAgent,
    UUID userId) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return WebAuthnCredentialJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return WebAuthnCredentialJSON.toJSONBytes(this);
  }

  public static WebAuthnCredential fromJSON(String json) {
    return WebAuthnCredentialJSON.fromJSON(json);
  }

  public static WebAuthnCredential fromJSONBytes(byte[] json) {
    return WebAuthnCredentialJSON.fromJSON(json);
  }

  public static final class Builder {
    private CoseAlgorithmIdentifier algorithm;
    private AttestationType attestationType;
    private Boolean authenticatorSupportsUserVerification;
    private String credentialId;
    private Map<String, Object> data;
    private Boolean discoverable;
    private String displayName;
    private UUID id;
    private Instant insertInstant;
    private Instant lastUseInstant;
    private String name;
    private String publicKey;
    private String relyingPartyId;
    private Integer signCount;
    private UUID tenantId;
    private List<String> transports;
    private String userAgent;
    private UUID userId;
    public Builder algorithm(CoseAlgorithmIdentifier algorithm) { this.algorithm = algorithm; return this; }
    public Builder attestationType(AttestationType attestationType) { this.attestationType = attestationType; return this; }
    public Builder authenticatorSupportsUserVerification(Boolean authenticatorSupportsUserVerification) { this.authenticatorSupportsUserVerification = authenticatorSupportsUserVerification; return this; }
    public Builder credentialId(String credentialId) { this.credentialId = credentialId; return this; }
    public Builder data(Map<String, Object> data) { this.data = data; return this; }
    public Builder discoverable(Boolean discoverable) { this.discoverable = discoverable; return this; }
    public Builder displayName(String displayName) { this.displayName = displayName; return this; }
    public Builder id(UUID id) { this.id = id; return this; }
    public Builder insertInstant(Instant insertInstant) { this.insertInstant = insertInstant; return this; }
    public Builder lastUseInstant(Instant lastUseInstant) { this.lastUseInstant = lastUseInstant; return this; }
    public Builder name(String name) { this.name = name; return this; }
    public Builder publicKey(String publicKey) { this.publicKey = publicKey; return this; }
    public Builder relyingPartyId(String relyingPartyId) { this.relyingPartyId = relyingPartyId; return this; }
    public Builder signCount(Integer signCount) { this.signCount = signCount; return this; }
    public Builder tenantId(UUID tenantId) { this.tenantId = tenantId; return this; }
    public Builder transports(List<String> transports) { this.transports = transports; return this; }
    public Builder userAgent(String userAgent) { this.userAgent = userAgent; return this; }
    public Builder userId(UUID userId) { this.userId = userId; return this; }
    public WebAuthnCredential build() { return new WebAuthnCredential(algorithm, attestationType, authenticatorSupportsUserVerification, credentialId, data, discoverable, displayName, id, insertInstant, lastUseInstant, name, publicKey, relyingPartyId, signCount, tenantId, transports, userAgent, userId); }
  }
}
