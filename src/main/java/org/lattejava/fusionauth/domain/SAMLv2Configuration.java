/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

import module java.base;
import module org.lattejava.json;

import org.lattejava.fusionauth.domain.internal.SAMLv2ConfigurationJSON;

@JSON
public record SAMLv2Configuration(
    SAMLv2AssertionEncryptionConfiguration assertionEncryptionConfiguration,
    String audience,
    List<String> authorizedRedirectURLs,
    Boolean debug,
    UUID defaultVerificationKeyId,
    SAMLv2IdPInitiatedLoginConfiguration initiatedLogin,
    String issuer,
    UUID keyId,
    LoginHintConfiguration loginHintConfiguration,
    SAMLv2Logout logout,
    String logoutURL,
    Boolean requireSignedRequests,
    CanonicalizationMethod xmlSignatureC14nMethod,
    XMLSignatureLocation xmlSignatureLocation,
    String callbackURL,
    Boolean enabled) {
  public static Builder builder() { return new Builder(); }

  public String toJSON() {
    return SAMLv2ConfigurationJSON.toJSON(this);
  }

  public byte[] toJSONBytes() {
    return SAMLv2ConfigurationJSON.toJSONBytes(this);
  }

  public static SAMLv2Configuration fromJSON(String json) {
    return SAMLv2ConfigurationJSON.fromJSON(json);
  }

  public static SAMLv2Configuration fromJSONBytes(byte[] json) {
    return SAMLv2ConfigurationJSON.fromJSON(json);
  }

  public static final class Builder {
    private SAMLv2AssertionEncryptionConfiguration assertionEncryptionConfiguration;
    private String audience;
    private List<String> authorizedRedirectURLs;
    private Boolean debug;
    private UUID defaultVerificationKeyId;
    private SAMLv2IdPInitiatedLoginConfiguration initiatedLogin;
    private String issuer;
    private UUID keyId;
    private LoginHintConfiguration loginHintConfiguration;
    private SAMLv2Logout logout;
    private String logoutURL;
    private Boolean requireSignedRequests;
    private CanonicalizationMethod xmlSignatureC14nMethod;
    private XMLSignatureLocation xmlSignatureLocation;
    private String callbackURL;
    private Boolean enabled;
    public Builder assertionEncryptionConfiguration(SAMLv2AssertionEncryptionConfiguration assertionEncryptionConfiguration) { this.assertionEncryptionConfiguration = assertionEncryptionConfiguration; return this; }
    public Builder audience(String audience) { this.audience = audience; return this; }
    public Builder authorizedRedirectURLs(List<String> authorizedRedirectURLs) { this.authorizedRedirectURLs = authorizedRedirectURLs; return this; }
    public Builder debug(Boolean debug) { this.debug = debug; return this; }
    public Builder defaultVerificationKeyId(UUID defaultVerificationKeyId) { this.defaultVerificationKeyId = defaultVerificationKeyId; return this; }
    public Builder initiatedLogin(SAMLv2IdPInitiatedLoginConfiguration initiatedLogin) { this.initiatedLogin = initiatedLogin; return this; }
    public Builder issuer(String issuer) { this.issuer = issuer; return this; }
    public Builder keyId(UUID keyId) { this.keyId = keyId; return this; }
    public Builder loginHintConfiguration(LoginHintConfiguration loginHintConfiguration) { this.loginHintConfiguration = loginHintConfiguration; return this; }
    public Builder logout(SAMLv2Logout logout) { this.logout = logout; return this; }
    public Builder logoutURL(String logoutURL) { this.logoutURL = logoutURL; return this; }
    public Builder requireSignedRequests(Boolean requireSignedRequests) { this.requireSignedRequests = requireSignedRequests; return this; }
    public Builder xmlSignatureC14nMethod(CanonicalizationMethod xmlSignatureC14nMethod) { this.xmlSignatureC14nMethod = xmlSignatureC14nMethod; return this; }
    public Builder xmlSignatureLocation(XMLSignatureLocation xmlSignatureLocation) { this.xmlSignatureLocation = xmlSignatureLocation; return this; }
    public Builder callbackURL(String callbackURL) { this.callbackURL = callbackURL; return this; }
    public Builder enabled(Boolean enabled) { this.enabled = enabled; return this; }
    public SAMLv2Configuration build() { return new SAMLv2Configuration(assertionEncryptionConfiguration, audience, authorizedRedirectURLs, debug, defaultVerificationKeyId, initiatedLogin, issuer, keyId, loginHintConfiguration, logout, logoutURL, requireSignedRequests, xmlSignatureC14nMethod, xmlSignatureLocation, callbackURL, enabled); }
  }
}
