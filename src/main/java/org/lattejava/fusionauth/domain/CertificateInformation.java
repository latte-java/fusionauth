/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.CertificateInformationJSON;

@JSON
public record CertificateInformation(
    String issuer,
    String md5Fingerprint,
    String serialNumber,
    String sha1Fingerprint,
    String sha1Thumbprint,
    String sha256Fingerprint,
    String sha256Thumbprint,
    String subject,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant validFrom,
    @JSONField(instant = InstantFormat.EPOCH_MILLIS) Instant validTo) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return CertificateInformationJSON.toJSON(this);
  }
  
  public byte[] toJSONBytes() {
    return CertificateInformationJSON.toJSONBytes(this);
  }
  
  public static CertificateInformation fromJSON(String json) {
    return CertificateInformationJSON.fromJSON(json);
  }
  
  public static CertificateInformation fromJSONBytes(byte[] json) {
    return CertificateInformationJSON.fromJSON(json);
  }

  public static final class Builder {
    private String issuer;
    private String md5Fingerprint;
    private String serialNumber;
    private String sha1Fingerprint;
    private String sha1Thumbprint;
    private String sha256Fingerprint;
    private String sha256Thumbprint;
    private String subject;
    private Instant validFrom;
    private Instant validTo;
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder md5Fingerprint(String md5Fingerprint) { this.md5Fingerprint = md5Fingerprint; return this; }
    public Builder serialNumber(String serialNumber) { this.serialNumber = serialNumber; return this; }
    public Builder sha1Fingerprint(String sha1Fingerprint) { this.sha1Fingerprint = sha1Fingerprint; return this; }
    public Builder sha1Thumbprint(String sha1Thumbprint) { this.sha1Thumbprint = sha1Thumbprint; return this; }
    public Builder sha256Fingerprint(String sha256Fingerprint) { this.sha256Fingerprint = sha256Fingerprint; return this; }
    public Builder sha256Thumbprint(String sha256Thumbprint) { this.sha256Thumbprint = sha256Thumbprint; return this; }
    public Builder subject(String subject) { this.subject = subject; return this; }
    public Builder validFrom(Instant validFrom) { this.validFrom = validFrom; return this; }
    public Builder validTo(Instant validTo) { this.validTo = validTo; return this; }
    public CertificateInformation build() { return new CertificateInformation(issuer, md5Fingerprint, serialNumber, sha1Fingerprint, sha1Thumbprint, sha256Fingerprint, sha256Thumbprint, subject, validFrom, validTo); }
  }
}
