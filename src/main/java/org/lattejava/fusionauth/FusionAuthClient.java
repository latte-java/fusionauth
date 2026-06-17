/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth;

import org.lattejava.fusionauth.domain.Errors;

import org.lattejava.fusionauth.domain.*;

import module java.base;
import module java.net.http;

/**
 * Synchronous FusionAuth API client. Construct with an API key and base URL, then call one method per
 * API operation. Non-2xx responses and transport failures throw {@link FusionAuthException}.
 */
public class FusionAuthClient {
  private final String apiKey;
  private final String baseURL;
  private final HttpClient httpClient;
  private final Duration timeout;

  public FusionAuthClient(String apiKey, String baseURL) {
    this(apiKey, baseURL, HttpClient.newHttpClient(), Duration.ofSeconds(30));
  }

  public FusionAuthClient(String apiKey, String baseURL, HttpClient httpClient, Duration timeout) {
    this.apiKey = apiKey;
    this.baseURL = baseURL.endsWith("/") ? baseURL.substring(0, baseURL.length() - 1) : baseURL;
    this.httpClient = httpClient;
    this.timeout = timeout;
  }

  // ===== GENERATED METHODS START =====
  public JWKSResponse retrieveJsonWebKeySetWithId() {
    return execute("GET", "/.well-known/jwks.json", null, null, JWKSResponse::fromJSON);
  }

  public OpenIdConfiguration retrieveOpenIdConfigurationWithId() {
    return execute("GET", "/.well-known/openid-configuration", null, null, OpenIdConfiguration::fromJSON);
  }

  public APIKeyResponse createAPIKey(APIKeyRequest request) {
    return execute("POST", "/api/api-key", request.toJSON(), null, APIKeyResponse::fromJSON);
  }

  public APIKeyResponse createAPIKeyWithId(UUID keyId, APIKeyRequest request) {
    return execute("POST", "/api/api-key/" + encode(keyId), request.toJSON(), null, APIKeyResponse::fromJSON);
  }

  public int deleteAPIKeyWithId(UUID keyId) {
    return executeVoid("DELETE", "/api/api-key/" + encode(keyId), null, null);
  }

  public APIKeyResponse patchAPIKeyWithId(UUID keyId, APIKeyRequest request) {
    return execute("PATCH", "/api/api-key/" + encode(keyId), request.toJSON(), null, APIKeyResponse::fromJSON);
  }

  public APIKeyResponse retrieveAPIKeyWithId(UUID keyId) {
    return execute("GET", "/api/api-key/" + encode(keyId), null, null, APIKeyResponse::fromJSON);
  }

  public APIKeyResponse updateAPIKeyWithId(UUID keyId, APIKeyRequest request) {
    return execute("PUT", "/api/api-key/" + encode(keyId), request.toJSON(), null, APIKeyResponse::fromJSON);
  }

  public ApplicationResponse createApplication(ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/application", request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse createApplication(ApplicationRequest request) {
    return createApplication(request, null);
  }

  public ApplicationResponse retrieveApplication(Boolean inactive, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/application" + query("inactive", inactive), null, xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse retrieveApplication(Boolean inactive) {
    return retrieveApplication(inactive, null);
  }

  public ApplicationSearchResponse searchApplicationsWithId(ApplicationSearchRequest request) {
    return execute("POST", "/api/application/search", request.toJSON(), null, ApplicationSearchResponse::fromJSON);
  }

  public ApplicationResponse createApplicationWithId(UUID applicationId, ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/application/" + encode(applicationId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse createApplicationWithId(UUID applicationId, ApplicationRequest request) {
    return createApplicationWithId(applicationId, request, null);
  }

  public int deleteApplicationWithId(UUID applicationId, Boolean hardDelete, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/application/" + encode(applicationId) + query("hardDelete", hardDelete), null, xFusionAuthTenantId);
  }

  public int deleteApplicationWithId(UUID applicationId, Boolean hardDelete) {
    return deleteApplicationWithId(applicationId, hardDelete, null);
  }

  public ApplicationResponse patchApplicationWithId(UUID applicationId, ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/application/" + encode(applicationId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse patchApplicationWithId(UUID applicationId, ApplicationRequest request) {
    return patchApplicationWithId(applicationId, request, null);
  }

  public ApplicationResponse updateApplicationWithId(UUID applicationId, Boolean reactivate, ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/application/" + encode(applicationId) + query("reactivate", reactivate), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse updateApplicationWithId(UUID applicationId, Boolean reactivate, ApplicationRequest request) {
    return updateApplicationWithId(applicationId, reactivate, request, null);
  }

  public ApplicationResponse retrieveApplicationWithId(UUID applicationId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/application/" + encode(applicationId), null, xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse retrieveApplicationWithId(UUID applicationId) {
    return retrieveApplicationWithId(applicationId, null);
  }

  public OAuthConfigurationResponse retrieveOauthConfigurationWithId(UUID applicationId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/application/" + encode(applicationId) + "/oauth-configuration", null, xFusionAuthTenantId, OAuthConfigurationResponse::fromJSON);
  }

  public OAuthConfigurationResponse retrieveOauthConfigurationWithId(UUID applicationId) {
    return retrieveOauthConfigurationWithId(applicationId, null);
  }

  public ApplicationResponse createApplicationRole(UUID applicationId, ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/role", request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse createApplicationRole(UUID applicationId, ApplicationRequest request) {
    return createApplicationRole(applicationId, request, null);
  }

  public ApplicationResponse createApplicationRoleWithId(UUID applicationId, UUID roleId, ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse createApplicationRoleWithId(UUID applicationId, UUID roleId, ApplicationRequest request) {
    return createApplicationRoleWithId(applicationId, roleId, request, null);
  }

  public int deleteApplicationRoleWithId(UUID applicationId, UUID roleId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), null, xFusionAuthTenantId);
  }

  public int deleteApplicationRoleWithId(UUID applicationId, UUID roleId) {
    return deleteApplicationRoleWithId(applicationId, roleId, null);
  }

  public ApplicationResponse patchApplicationRoleWithId(UUID applicationId, UUID roleId, ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse patchApplicationRoleWithId(UUID applicationId, UUID roleId, ApplicationRequest request) {
    return patchApplicationRoleWithId(applicationId, roleId, request, null);
  }

  public ApplicationResponse updateApplicationRoleWithId(UUID applicationId, UUID roleId, ApplicationRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse updateApplicationRoleWithId(UUID applicationId, UUID roleId, ApplicationRequest request) {
    return updateApplicationRoleWithId(applicationId, roleId, request, null);
  }

  public ApplicationOAuthScopeResponse createOAuthScope(UUID applicationId, ApplicationOAuthScopeRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/scope", request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse createOAuthScope(UUID applicationId, ApplicationOAuthScopeRequest request) {
    return createOAuthScope(applicationId, request, null);
  }

  public ApplicationOAuthScopeResponse createOAuthScopeWithId(UUID applicationId, UUID scopeId, ApplicationOAuthScopeRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse createOAuthScopeWithId(UUID applicationId, UUID scopeId, ApplicationOAuthScopeRequest request) {
    return createOAuthScopeWithId(applicationId, scopeId, request, null);
  }

  public int deleteOAuthScopeWithId(UUID applicationId, UUID scopeId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), null, xFusionAuthTenantId);
  }

  public int deleteOAuthScopeWithId(UUID applicationId, UUID scopeId) {
    return deleteOAuthScopeWithId(applicationId, scopeId, null);
  }

  public ApplicationOAuthScopeResponse patchOAuthScopeWithId(UUID applicationId, UUID scopeId, ApplicationOAuthScopeRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse patchOAuthScopeWithId(UUID applicationId, UUID scopeId, ApplicationOAuthScopeRequest request) {
    return patchOAuthScopeWithId(applicationId, scopeId, request, null);
  }

  public ApplicationOAuthScopeResponse retrieveOAuthScopeWithId(UUID applicationId, UUID scopeId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), null, xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse retrieveOAuthScopeWithId(UUID applicationId, UUID scopeId) {
    return retrieveOAuthScopeWithId(applicationId, scopeId, null);
  }

  public ApplicationOAuthScopeResponse updateOAuthScopeWithId(UUID applicationId, UUID scopeId, ApplicationOAuthScopeRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse updateOAuthScopeWithId(UUID applicationId, UUID scopeId, ApplicationOAuthScopeRequest request) {
    return updateOAuthScopeWithId(applicationId, scopeId, request, null);
  }

  public ConnectorResponse retrieveConnectors() {
    return execute("GET", "/api/connector", null, null, ConnectorResponse::fromJSON);
  }

  public ConnectorResponse createConnector(ConnectorRequest request) {
    return execute("POST", "/api/connector", request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public ConnectorResponse createConnectorWithId(UUID connectorId, ConnectorRequest request) {
    return execute("POST", "/api/connector/" + encode(connectorId), request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public int deleteConnectorWithId(UUID connectorId) {
    return executeVoid("DELETE", "/api/connector/" + encode(connectorId), null, null);
  }

  public ConnectorResponse patchConnectorWithId(UUID connectorId, ConnectorRequest request) {
    return execute("PATCH", "/api/connector/" + encode(connectorId), request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public ConnectorResponse retrieveConnectorWithId(UUID connectorId) {
    return execute("GET", "/api/connector/" + encode(connectorId), null, null, ConnectorResponse::fromJSON);
  }

  public ConnectorResponse updateConnectorWithId(UUID connectorId, ConnectorRequest request) {
    return execute("PUT", "/api/connector/" + encode(connectorId), request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public ConsentResponse createConsent(ConsentRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/consent", request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentResponse createConsent(ConsentRequest request) {
    return createConsent(request, null);
  }

  public ConsentSearchResponse searchConsents(String name, Integer numberOfResults, String orderBy, Integer startRow) {
    return execute("GET", "/api/consent/search" + query("name", name, "numberOfResults", numberOfResults, "orderBy", orderBy, "startRow", startRow), null, null, ConsentSearchResponse::fromJSON);
  }

  public ConsentSearchResponse searchConsentsWithId(ConsentSearchRequest request) {
    return execute("POST", "/api/consent/search", request.toJSON(), null, ConsentSearchResponse::fromJSON);
  }

  public ConsentResponse createConsentWithId(UUID consentId, ConsentRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/consent/" + encode(consentId), request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentResponse createConsentWithId(UUID consentId, ConsentRequest request) {
    return createConsentWithId(consentId, request, null);
  }

  public int deleteConsentWithId(UUID consentId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/consent/" + encode(consentId), null, xFusionAuthTenantId);
  }

  public int deleteConsentWithId(UUID consentId) {
    return deleteConsentWithId(consentId, null);
  }

  public ConsentResponse patchConsentWithId(UUID consentId, ConsentRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/consent/" + encode(consentId), request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentResponse patchConsentWithId(UUID consentId, ConsentRequest request) {
    return patchConsentWithId(consentId, request, null);
  }

  public ConsentResponse retrieveConsentWithId(UUID consentId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/consent/" + encode(consentId), null, xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentResponse retrieveConsentWithId(UUID consentId) {
    return retrieveConsentWithId(consentId, null);
  }

  public ConsentResponse updateConsentWithId(UUID consentId, ConsentRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/consent/" + encode(consentId), request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentResponse updateConsentWithId(UUID consentId, ConsentRequest request) {
    return updateConsentWithId(consentId, request, null);
  }

  public SendResponse sendEmailWithId(UUID emailTemplateId, SendRequest request) {
    return execute("POST", "/api/email/send/" + encode(emailTemplateId), request.toJSON(), null, SendResponse::fromJSON);
  }

  public EmailTemplateResponse createEmailTemplate(EmailTemplateRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/email/template", request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse createEmailTemplate(EmailTemplateRequest request) {
    return createEmailTemplate(request, null);
  }

  public EmailTemplateResponse retrieveEmailTemplate(UUID xFusionAuthTenantId) {
    return execute("GET", "/api/email/template", null, xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse retrieveEmailTemplate() {
    return retrieveEmailTemplate(null);
  }

  public PreviewResponse retrieveEmailTemplatePreviewWithId(PreviewRequest request) {
    return execute("POST", "/api/email/template/preview", request.toJSON(), null, PreviewResponse::fromJSON);
  }

  public EmailTemplateSearchResponse searchEmailTemplatesWithId(EmailTemplateSearchRequest request) {
    return execute("POST", "/api/email/template/search", request.toJSON(), null, EmailTemplateSearchResponse::fromJSON);
  }

  public EmailTemplateResponse createEmailTemplateWithId(UUID emailTemplateId, EmailTemplateRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/email/template/" + encode(emailTemplateId), request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse createEmailTemplateWithId(UUID emailTemplateId, EmailTemplateRequest request) {
    return createEmailTemplateWithId(emailTemplateId, request, null);
  }

  public int deleteEmailTemplateWithId(UUID emailTemplateId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/email/template/" + encode(emailTemplateId), null, xFusionAuthTenantId);
  }

  public int deleteEmailTemplateWithId(UUID emailTemplateId) {
    return deleteEmailTemplateWithId(emailTemplateId, null);
  }

  public EmailTemplateResponse patchEmailTemplateWithId(UUID emailTemplateId, EmailTemplateRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/email/template/" + encode(emailTemplateId), request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse patchEmailTemplateWithId(UUID emailTemplateId, EmailTemplateRequest request) {
    return patchEmailTemplateWithId(emailTemplateId, request, null);
  }

  public EmailTemplateResponse retrieveEmailTemplateWithId(UUID emailTemplateId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/email/template/" + encode(emailTemplateId), null, xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse retrieveEmailTemplateWithId(UUID emailTemplateId) {
    return retrieveEmailTemplateWithId(emailTemplateId, null);
  }

  public EmailTemplateResponse updateEmailTemplateWithId(UUID emailTemplateId, EmailTemplateRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/email/template/" + encode(emailTemplateId), request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse updateEmailTemplateWithId(UUID emailTemplateId, EmailTemplateRequest request) {
    return updateEmailTemplateWithId(emailTemplateId, request, null);
  }

  public EntityResponse createEntity(EntityRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/entity", request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityResponse createEntity(EntityRequest request) {
    return createEntity(request, null);
  }

  public EntityGrantSearchResponse searchEntityGrants(UUID entityId, String name, UUID userId, Integer numberOfResults, String orderBy, Integer startRow) {
    return execute("GET", "/api/entity/grant/search" + query("entityId", entityId, "name", name, "userId", userId, "numberOfResults", numberOfResults, "orderBy", orderBy, "startRow", startRow), null, null, EntityGrantSearchResponse::fromJSON);
  }

  public EntityGrantSearchResponse searchEntityGrantsWithId(EntityGrantSearchRequest request) {
    return execute("POST", "/api/entity/grant/search", request.toJSON(), null, EntityGrantSearchResponse::fromJSON);
  }

  public EntitySearchResponse searchEntitiesWithId(EntitySearchRequest request) {
    return execute("POST", "/api/entity/search", request.toJSON(), null, EntitySearchResponse::fromJSON);
  }

  public EntitySearchResponse searchEntitiesByIdsWithId(List<UUID> ids) {
    return execute("GET", "/api/entity/search" + query("ids", ids), null, null, EntitySearchResponse::fromJSON);
  }

  public EntityTypeResponse createEntityType(EntityTypeRequest request) {
    return execute("POST", "/api/entity/type", request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeSearchResponse searchEntityTypes(String name, Integer numberOfResults, String orderBy, Integer startRow) {
    return execute("GET", "/api/entity/type/search" + query("name", name, "numberOfResults", numberOfResults, "orderBy", orderBy, "startRow", startRow), null, null, EntityTypeSearchResponse::fromJSON);
  }

  public EntityTypeSearchResponse searchEntityTypesWithId(EntityTypeSearchRequest request) {
    return execute("POST", "/api/entity/type/search", request.toJSON(), null, EntityTypeSearchResponse::fromJSON);
  }

  public EntityTypeResponse createEntityTypeWithId(UUID entityTypeId, EntityTypeRequest request) {
    return execute("POST", "/api/entity/type/" + encode(entityTypeId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public int deleteEntityTypeWithId(UUID entityTypeId) {
    return executeVoid("DELETE", "/api/entity/type/" + encode(entityTypeId), null, null);
  }

  public EntityTypeResponse patchEntityTypeWithId(UUID entityTypeId, EntityTypeRequest request) {
    return execute("PATCH", "/api/entity/type/" + encode(entityTypeId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse retrieveEntityTypeWithId(UUID entityTypeId) {
    return execute("GET", "/api/entity/type/" + encode(entityTypeId), null, null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse updateEntityTypeWithId(UUID entityTypeId, EntityTypeRequest request) {
    return execute("PUT", "/api/entity/type/" + encode(entityTypeId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse createEntityTypePermission(UUID entityTypeId, EntityTypeRequest request) {
    return execute("POST", "/api/entity/type/" + encode(entityTypeId) + "/permission", request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public int deleteEntityTypePermission(UUID entityTypeId, String name) {
    return executeVoid("DELETE", "/api/entity/type/" + encode(entityTypeId) + "/permission" + query("name", name), null, null);
  }

  public EntityTypeResponse createEntityTypePermissionWithId(UUID entityTypeId, UUID permissionId, EntityTypeRequest request) {
    return execute("POST", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public int deleteEntityTypePermissionWithId(UUID entityTypeId, UUID permissionId) {
    return executeVoid("DELETE", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), null, null);
  }

  public EntityTypeResponse patchEntityTypePermissionWithId(UUID entityTypeId, UUID permissionId, EntityTypeRequest request) {
    return execute("PATCH", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse updateEntityTypePermissionWithId(UUID entityTypeId, UUID permissionId, EntityTypeRequest request) {
    return execute("PUT", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityResponse createEntityWithId(UUID entityId, EntityRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/entity/" + encode(entityId), request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityResponse createEntityWithId(UUID entityId, EntityRequest request) {
    return createEntityWithId(entityId, request, null);
  }

  public int deleteEntityWithId(UUID entityId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/entity/" + encode(entityId), null, xFusionAuthTenantId);
  }

  public int deleteEntityWithId(UUID entityId) {
    return deleteEntityWithId(entityId, null);
  }

  public EntityResponse patchEntityWithId(UUID entityId, EntityRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/entity/" + encode(entityId), request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityResponse patchEntityWithId(UUID entityId, EntityRequest request) {
    return patchEntityWithId(entityId, request, null);
  }

  public EntityResponse retrieveEntityWithId(UUID entityId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/entity/" + encode(entityId), null, xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityResponse retrieveEntityWithId(UUID entityId) {
    return retrieveEntityWithId(entityId, null);
  }

  public EntityResponse updateEntityWithId(UUID entityId, EntityRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/entity/" + encode(entityId), request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityResponse updateEntityWithId(UUID entityId, EntityRequest request) {
    return updateEntityWithId(entityId, request, null);
  }

  public int deleteEntityGrantWithId(UUID entityId, UUID recipientEntityId, UUID userId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/entity/" + encode(entityId) + "/grant" + query("recipientEntityId", recipientEntityId, "userId", userId), null, xFusionAuthTenantId);
  }

  public int deleteEntityGrantWithId(UUID entityId, UUID recipientEntityId, UUID userId) {
    return deleteEntityGrantWithId(entityId, recipientEntityId, userId, null);
  }

  public EntityGrantResponse retrieveEntityGrantWithId(UUID entityId, UUID recipientEntityId, UUID userId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/entity/" + encode(entityId) + "/grant" + query("recipientEntityId", recipientEntityId, "userId", userId), null, xFusionAuthTenantId, EntityGrantResponse::fromJSON);
  }

  public EntityGrantResponse retrieveEntityGrantWithId(UUID entityId, UUID recipientEntityId, UUID userId) {
    return retrieveEntityGrantWithId(entityId, recipientEntityId, userId, null);
  }

  public int upsertEntityGrantWithId(UUID entityId, EntityGrantRequest request, UUID xFusionAuthTenantId) {
    return executeVoid("POST", "/api/entity/" + encode(entityId) + "/grant", request.toJSON(), xFusionAuthTenantId);
  }

  public int upsertEntityGrantWithId(UUID entityId, EntityGrantRequest request) {
    return upsertEntityGrantWithId(entityId, request, null);
  }

  public FormResponse retrieveForms() {
    return execute("GET", "/api/form", null, null, FormResponse::fromJSON);
  }

  public FormResponse createForm(FormRequest request) {
    return execute("POST", "/api/form", request.toJSON(), null, FormResponse::fromJSON);
  }

  public FormFieldResponse retrieveFormFields() {
    return execute("GET", "/api/form/field", null, null, FormFieldResponse::fromJSON);
  }

  public FormFieldResponse createFormField(FormFieldRequest request) {
    return execute("POST", "/api/form/field", request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public FormFieldResponse createFormFieldWithId(UUID fieldId, FormFieldRequest request) {
    return execute("POST", "/api/form/field/" + encode(fieldId), request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public int deleteFormFieldWithId(UUID fieldId) {
    return executeVoid("DELETE", "/api/form/field/" + encode(fieldId), null, null);
  }

  public FormFieldResponse patchFormFieldWithId(UUID fieldId, FormFieldRequest request) {
    return execute("PATCH", "/api/form/field/" + encode(fieldId), request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public FormFieldResponse retrieveFormFieldWithId(UUID fieldId) {
    return execute("GET", "/api/form/field/" + encode(fieldId), null, null, FormFieldResponse::fromJSON);
  }

  public FormFieldResponse updateFormFieldWithId(UUID fieldId, FormFieldRequest request) {
    return execute("PUT", "/api/form/field/" + encode(fieldId), request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public FormResponse createFormWithId(UUID formId, FormRequest request) {
    return execute("POST", "/api/form/" + encode(formId), request.toJSON(), null, FormResponse::fromJSON);
  }

  public int deleteFormWithId(UUID formId) {
    return executeVoid("DELETE", "/api/form/" + encode(formId), null, null);
  }

  public FormResponse patchFormWithId(UUID formId, FormRequest request) {
    return execute("PATCH", "/api/form/" + encode(formId), request.toJSON(), null, FormResponse::fromJSON);
  }

  public FormResponse retrieveFormWithId(UUID formId) {
    return execute("GET", "/api/form/" + encode(formId), null, null, FormResponse::fromJSON);
  }

  public FormResponse updateFormWithId(UUID formId, FormRequest request) {
    return execute("PUT", "/api/form/" + encode(formId), request.toJSON(), null, FormResponse::fromJSON);
  }

  public GroupResponse createGroup(GroupRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/group", request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public GroupResponse createGroup(GroupRequest request) {
    return createGroup(request, null);
  }

  public MemberResponse createGroupMembersWithId(MemberRequest request) {
    return execute("POST", "/api/group/member", request.toJSON(), null, MemberResponse::fromJSON);
  }

  public int deleteGroupMembersWithId(UUID groupId, UUID userId, MemberDeleteRequest request) {
    return executeVoid("DELETE", "/api/group/member" + query("groupId", groupId, "userId", userId), request.toJSON(), null);
  }

  public MemberResponse updateGroupMembersWithId(MemberRequest request) {
    return execute("PUT", "/api/group/member", request.toJSON(), null, MemberResponse::fromJSON);
  }

  public int deleteGroupMemberWithId(UUID memberId) {
    return executeVoid("DELETE", "/api/group/member/" + encode(memberId), null, null);
  }

  public GroupMemberSearchResponse searchGroupMembersWithId(GroupMemberSearchRequest request) {
    return execute("POST", "/api/group/member/search", request.toJSON(), null, GroupMemberSearchResponse::fromJSON);
  }

  public GroupSearchResponse searchGroupsWithId(GroupSearchRequest request) {
    return execute("POST", "/api/group/search", request.toJSON(), null, GroupSearchResponse::fromJSON);
  }

  public GroupResponse createGroupWithId(UUID groupId, GroupRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/group/" + encode(groupId), request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public GroupResponse createGroupWithId(UUID groupId, GroupRequest request) {
    return createGroupWithId(groupId, request, null);
  }

  public int deleteGroupWithId(UUID groupId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/group/" + encode(groupId), null, xFusionAuthTenantId);
  }

  public int deleteGroupWithId(UUID groupId) {
    return deleteGroupWithId(groupId, null);
  }

  public GroupResponse patchGroupWithId(UUID groupId, GroupRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/group/" + encode(groupId), request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public GroupResponse patchGroupWithId(UUID groupId, GroupRequest request) {
    return patchGroupWithId(groupId, request, null);
  }

  public GroupResponse retrieveGroupWithId(UUID groupId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/group/" + encode(groupId), null, xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public GroupResponse retrieveGroupWithId(UUID groupId) {
    return retrieveGroupWithId(groupId, null);
  }

  public GroupResponse updateGroupWithId(UUID groupId, GroupRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/group/" + encode(groupId), request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public GroupResponse updateGroupWithId(UUID groupId, GroupRequest request) {
    return updateGroupWithId(groupId, request, null);
  }

  public int retrieveSystemHealthWithId() {
    return executeVoid("GET", "/api/health", null, null);
  }

  public IdentityProviderResponse createIdentityProvider(IdentityProviderRequest request) {
    return execute("POST", "/api/identity-provider", request.toJSON(), null, IdentityProviderResponse::fromJSON);
  }

  public IdentityProviderResponse retrieveIdentityProviderByTypeWithId(String type) {
    return execute("GET", "/api/identity-provider" + query("type", type), null, null, IdentityProviderResponse::fromJSON);
  }

  public IdentityProviderLinkResponse createUserLinkWithId(IdentityProviderLinkRequest request) {
    return execute("POST", "/api/identity-provider/link", request.toJSON(), null, IdentityProviderLinkResponse::fromJSON);
  }

  public IdentityProviderLinkResponse deleteUserLinkWithId(UUID identityProviderId, String identityProviderUserId, UUID userId) {
    return execute("DELETE", "/api/identity-provider/link" + query("identityProviderId", identityProviderId, "identityProviderUserId", identityProviderUserId, "userId", userId), null, null, IdentityProviderLinkResponse::fromJSON);
  }

  public IdentityProviderLinkResponse retrieveIdentityProviderLink(UUID identityProviderId, UUID userId, String identityProviderUserId) {
    return execute("GET", "/api/identity-provider/link" + query("identityProviderId", identityProviderId, "userId", userId, "identityProviderUserId", identityProviderUserId), null, null, IdentityProviderLinkResponse::fromJSON);
  }

  public IdentityProviderPendingLinkResponse retrievePendingLinkWithId(String pendingLinkId, UUID userId) {
    return execute("GET", "/api/identity-provider/link/pending/" + encode(pendingLinkId) + query("userId", userId), null, null, IdentityProviderPendingLinkResponse::fromJSON);
  }

  public LoginResponse identityProviderLoginWithId(IdentityProviderLoginRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/identity-provider/login", request.toJSON(), xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public LoginResponse identityProviderLoginWithId(IdentityProviderLoginRequest request) {
    return identityProviderLoginWithId(request, null);
  }

  public LookupResponse retrieveIdentityProviderLookup(String domain, UUID tenantId) {
    return execute("GET", "/api/identity-provider/lookup" + query("domain", domain, "tenantId", tenantId), null, null, LookupResponse::fromJSON);
  }

  public IdentityProviderSearchResponse searchIdentityProviders(UUID applicationId, String name, String source, UUID tenantId, String type, Integer numberOfResults, String orderBy, Integer startRow) {
    return execute("GET", "/api/identity-provider/search" + query("applicationId", applicationId, "name", name, "source", source, "tenantId", tenantId, "type", type, "numberOfResults", numberOfResults, "orderBy", orderBy, "startRow", startRow), null, null, IdentityProviderSearchResponse::fromJSON);
  }

  public IdentityProviderSearchResponse searchIdentityProvidersWithId(IdentityProviderSearchRequest request) {
    return execute("POST", "/api/identity-provider/search", request.toJSON(), null, IdentityProviderSearchResponse::fromJSON);
  }

  public IdentityProviderStartLoginResponse startIdentityProviderLoginWithId(IdentityProviderStartLoginRequest request) {
    return execute("POST", "/api/identity-provider/start", request.toJSON(), null, IdentityProviderStartLoginResponse::fromJSON);
  }

  public IdentityProviderConnectionTestResponse retrieveIdentityProviderConnectionTestResultsWithId(String connectionTestId) {
    return execute("GET", "/api/identity-provider/test" + query("connectionTestId", connectionTestId), null, null, IdentityProviderConnectionTestResponse::fromJSON);
  }

  public IdentityProviderConnectionTestResponse startIdentityProviderConnectionTestWithId(IdentityProviderConnectionTestRequest request) {
    return execute("POST", "/api/identity-provider/test", request.toJSON(), null, IdentityProviderConnectionTestResponse::fromJSON);
  }

  public IdentityProviderResponse createIdentityProviderWithId(UUID identityProviderId, IdentityProviderRequest request) {
    return execute("POST", "/api/identity-provider/" + encode(identityProviderId), request.toJSON(), null, IdentityProviderResponse::fromJSON);
  }

  public int deleteIdentityProviderWithId(UUID identityProviderId) {
    return executeVoid("DELETE", "/api/identity-provider/" + encode(identityProviderId), null, null);
  }

  public IdentityProviderResponse patchIdentityProviderWithId(UUID identityProviderId, IdentityProviderRequest request) {
    return execute("PATCH", "/api/identity-provider/" + encode(identityProviderId), request.toJSON(), null, IdentityProviderResponse::fromJSON);
  }

  public IdentityProviderResponse retrieveIdentityProviderWithId(UUID identityProviderId) {
    return execute("GET", "/api/identity-provider/" + encode(identityProviderId), null, null, IdentityProviderResponse::fromJSON);
  }

  public IdentityProviderResponse updateIdentityProviderWithId(UUID identityProviderId, IdentityProviderRequest request) {
    return execute("PUT", "/api/identity-provider/" + encode(identityProviderId), request.toJSON(), null, IdentityProviderResponse::fromJSON);
  }

  public int verifyIdentityWithId(VerifyRequest request) {
    return executeVoid("POST", "/api/identity/verify", request.toJSON(), null);
  }

  public VerifyCompleteResponse completeVerifyIdentityWithId(VerifyCompleteRequest request) {
    return execute("POST", "/api/identity/verify/complete", request.toJSON(), null, VerifyCompleteResponse::fromJSON);
  }

  public int sendVerifyIdentityWithId(VerifySendRequest request) {
    return executeVoid("POST", "/api/identity/verify/send", request.toJSON(), null);
  }

  public VerifyStartResponse startVerifyIdentityWithId(VerifyStartRequest request) {
    return execute("POST", "/api/identity/verify/start", request.toJSON(), null, VerifyStartResponse::fromJSON);
  }

  public IntegrationResponse patchIntegrationsWithId(IntegrationRequest request) {
    return execute("PATCH", "/api/integration", request.toJSON(), null, IntegrationResponse::fromJSON);
  }

  public IntegrationResponse updateIntegrationsWithId(IntegrationRequest request) {
    return execute("PUT", "/api/integration", request.toJSON(), null, IntegrationResponse::fromJSON);
  }

  public IPAccessControlListResponse createIPAccessControlList(IPAccessControlListRequest request) {
    return execute("POST", "/api/ip-acl", request.toJSON(), null, IPAccessControlListResponse::fromJSON);
  }

  public IPAccessControlListSearchResponse searchIPAccessControlLists(String name, Integer numberOfResults, String orderBy, Integer startRow) {
    return execute("GET", "/api/ip-acl/search" + query("name", name, "numberOfResults", numberOfResults, "orderBy", orderBy, "startRow", startRow), null, null, IPAccessControlListSearchResponse::fromJSON);
  }

  public IPAccessControlListSearchResponse searchIPAccessControlListsWithId(IPAccessControlListSearchRequest request) {
    return execute("POST", "/api/ip-acl/search", request.toJSON(), null, IPAccessControlListSearchResponse::fromJSON);
  }

  public IPAccessControlListResponse createIPAccessControlListWithId(UUID ipAccessControlListId, IPAccessControlListRequest request) {
    return execute("POST", "/api/ip-acl/" + encode(ipAccessControlListId), request.toJSON(), null, IPAccessControlListResponse::fromJSON);
  }

  public IPAccessControlListResponse patchIPAccessControlListWithId(UUID ipAccessControlListId, IPAccessControlListRequest request) {
    return execute("PATCH", "/api/ip-acl/" + encode(ipAccessControlListId), request.toJSON(), null, IPAccessControlListResponse::fromJSON);
  }

  public IPAccessControlListResponse updateIPAccessControlListWithId(UUID ipAccessControlListId, IPAccessControlListRequest request) {
    return execute("PUT", "/api/ip-acl/" + encode(ipAccessControlListId), request.toJSON(), null, IPAccessControlListResponse::fromJSON);
  }

  public int deleteIPAccessControlListWithId(UUID ipAccessControlListId) {
    return executeVoid("DELETE", "/api/ip-acl/" + encode(ipAccessControlListId), null, null);
  }

  public IPAccessControlListResponse retrieveIPAccessControlListWithId(UUID ipAccessControlListId) {
    return execute("GET", "/api/ip-acl/" + encode(ipAccessControlListId), null, null, IPAccessControlListResponse::fromJSON);
  }

  public IssueResponse issueJWTWithId(UUID applicationId, String refreshToken) {
    return execute("GET", "/api/jwt/issue" + query("applicationId", applicationId, "refreshToken", refreshToken), null, null, IssueResponse::fromJSON);
  }

  public PublicKeyResponse retrieveJwtPublicKey(UUID applicationId, String kid) {
    return execute("GET", "/api/jwt/public-key" + query("applicationId", applicationId, "kid", kid), null, null, PublicKeyResponse::fromJSON);
  }

  public LoginResponse reconcileJWTWithId(IdentityProviderLoginRequest request) {
    return execute("POST", "/api/jwt/reconcile", request.toJSON(), null, LoginResponse::fromJSON);
  }

  public JWTRefreshResponse exchangeRefreshTokenForJWTWithId(RefreshRequest request) {
    return execute("POST", "/api/jwt/refresh", request.toJSON(), null, JWTRefreshResponse::fromJSON);
  }

  public RefreshTokenResponse retrieveRefreshTokensWithId(UUID userId) {
    return execute("GET", "/api/jwt/refresh" + query("userId", userId), null, null, RefreshTokenResponse::fromJSON);
  }

  public int deleteJwtRefresh(UUID userId, UUID applicationId, String token, RefreshTokenRevokeRequest request) {
    return executeVoid("DELETE", "/api/jwt/refresh" + query("userId", userId, "applicationId", applicationId, "token", token), request.toJSON(), null);
  }

  public RefreshTokenResponse retrieveRefreshTokenByIdWithId(UUID tokenId) {
    return execute("GET", "/api/jwt/refresh/" + encode(tokenId), null, null, RefreshTokenResponse::fromJSON);
  }

  public int revokeRefreshTokenByIdWithId(UUID tokenId) {
    return executeVoid("DELETE", "/api/jwt/refresh/" + encode(tokenId), null, null);
  }

  public ValidateResponse validateJWTWithId() {
    return execute("GET", "/api/jwt/validate", null, null, ValidateResponse::fromJSON);
  }

  public JWTVendResponse vendJWTWithId(JWTVendRequest request) {
    return execute("POST", "/api/jwt/vend", request.toJSON(), null, JWTVendResponse::fromJSON);
  }

  public KeyResponse retrieveKeysWithId() {
    return execute("GET", "/api/key", null, null, KeyResponse::fromJSON);
  }

  public KeyResponse generateKey(KeyRequest request) {
    return execute("POST", "/api/key/generate", request.toJSON(), null, KeyResponse::fromJSON);
  }

  public KeyResponse generateKeyWithId(UUID keyId, KeyRequest request) {
    return execute("POST", "/api/key/generate/" + encode(keyId), request.toJSON(), null, KeyResponse::fromJSON);
  }

  public KeyResponse importKey(KeyRequest request) {
    return execute("POST", "/api/key/import", request.toJSON(), null, KeyResponse::fromJSON);
  }

  public KeyResponse importKeyWithId(UUID keyId, KeyRequest request) {
    return execute("POST", "/api/key/import/" + encode(keyId), request.toJSON(), null, KeyResponse::fromJSON);
  }

  public KeySearchResponse searchKeys(String algorithm, String name, String type, Integer numberOfResults, String orderBy, Integer startRow) {
    return execute("GET", "/api/key/search" + query("algorithm", algorithm, "name", name, "type", type, "numberOfResults", numberOfResults, "orderBy", orderBy, "startRow", startRow), null, null, KeySearchResponse::fromJSON);
  }

  public KeySearchResponse searchKeysWithId(KeySearchRequest request) {
    return execute("POST", "/api/key/search", request.toJSON(), null, KeySearchResponse::fromJSON);
  }

  public int deleteKeyWithId(UUID keyId) {
    return executeVoid("DELETE", "/api/key/" + encode(keyId), null, null);
  }

  public KeyResponse retrieveKeyWithId(UUID keyId) {
    return execute("GET", "/api/key/" + encode(keyId), null, null, KeyResponse::fromJSON);
  }

  public KeyResponse updateKeyWithId(UUID keyId, KeyRequest request) {
    return execute("PUT", "/api/key/" + encode(keyId), request.toJSON(), null, KeyResponse::fromJSON);
  }

  public LambdaResponse createLambda(LambdaRequest request) {
    return execute("POST", "/api/lambda", request.toJSON(), null, LambdaResponse::fromJSON);
  }

  public LambdaResponse retrieveLambdasByTypeWithId(String type) {
    return execute("GET", "/api/lambda" + query("type", type), null, null, LambdaResponse::fromJSON);
  }

  public LambdaSearchResponse searchLambdasWithId(LambdaSearchRequest request) {
    return execute("POST", "/api/lambda/search", request.toJSON(), null, LambdaSearchResponse::fromJSON);
  }

  public LambdaResponse createLambdaWithId(UUID lambdaId, LambdaRequest request) {
    return execute("POST", "/api/lambda/" + encode(lambdaId), request.toJSON(), null, LambdaResponse::fromJSON);
  }

  public int deleteLambdaWithId(UUID lambdaId) {
    return executeVoid("DELETE", "/api/lambda/" + encode(lambdaId), null, null);
  }

  public LambdaResponse patchLambdaWithId(UUID lambdaId, LambdaRequest request) {
    return execute("PATCH", "/api/lambda/" + encode(lambdaId), request.toJSON(), null, LambdaResponse::fromJSON);
  }

  public LambdaResponse retrieveLambdaWithId(UUID lambdaId) {
    return execute("GET", "/api/lambda/" + encode(lambdaId), null, null, LambdaResponse::fromJSON);
  }

  public LambdaResponse updateLambdaWithId(UUID lambdaId, LambdaRequest request) {
    return execute("PUT", "/api/lambda/" + encode(lambdaId), request.toJSON(), null, LambdaResponse::fromJSON);
  }

  public LoginResponse loginWithId(LoginRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/login", request.toJSON(), xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public LoginResponse loginWithId(LoginRequest request) {
    return loginWithId(request, null);
  }

  public LoginResponse loginPingWithRequestWithId(LoginPingRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/login", request.toJSON(), xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public LoginResponse loginPingWithRequestWithId(LoginPingRequest request) {
    return loginPingWithRequestWithId(request, null);
  }

  public LoginResponse loginPingWithId(UUID userId, UUID applicationId, String callerIPAddress, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/login/" + encode(userId) + "/" + encode(applicationId) + query("callerIPAddress", callerIPAddress), null, xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public LoginResponse loginPingWithId(UUID userId, UUID applicationId, String callerIPAddress) {
    return loginPingWithId(userId, applicationId, callerIPAddress, null);
  }

  public int createLogout(Boolean global, String refreshToken, LogoutRequest request) {
    return executeVoid("POST", "/api/logout" + query("global", global, "refreshToken", refreshToken), request.toJSON(), null);
  }

  public MessageTemplateResponse createMessageTemplate(MessageTemplateRequest request) {
    return execute("POST", "/api/message/template", request.toJSON(), null, MessageTemplateResponse::fromJSON);
  }

  public MessageTemplateResponse retrieveMessageTemplate() {
    return execute("GET", "/api/message/template", null, null, MessageTemplateResponse::fromJSON);
  }

  public PreviewMessageTemplateResponse retrieveMessageTemplatePreviewWithId(PreviewMessageTemplateRequest request) {
    return execute("POST", "/api/message/template/preview", request.toJSON(), null, PreviewMessageTemplateResponse::fromJSON);
  }

  public MessageTemplateResponse createMessageTemplateWithId(UUID messageTemplateId, MessageTemplateRequest request) {
    return execute("POST", "/api/message/template/" + encode(messageTemplateId), request.toJSON(), null, MessageTemplateResponse::fromJSON);
  }

  public int deleteMessageTemplateWithId(UUID messageTemplateId) {
    return executeVoid("DELETE", "/api/message/template/" + encode(messageTemplateId), null, null);
  }

  public MessageTemplateResponse patchMessageTemplateWithId(UUID messageTemplateId, MessageTemplateRequest request) {
    return execute("PATCH", "/api/message/template/" + encode(messageTemplateId), request.toJSON(), null, MessageTemplateResponse::fromJSON);
  }

  public MessageTemplateResponse retrieveMessageTemplateWithId(UUID messageTemplateId) {
    return execute("GET", "/api/message/template/" + encode(messageTemplateId), null, null, MessageTemplateResponse::fromJSON);
  }

  public MessageTemplateResponse updateMessageTemplateWithId(UUID messageTemplateId, MessageTemplateRequest request) {
    return execute("PUT", "/api/message/template/" + encode(messageTemplateId), request.toJSON(), null, MessageTemplateResponse::fromJSON);
  }

  public MessengerResponse retrieveMessengers() {
    return execute("GET", "/api/messenger", null, null, MessengerResponse::fromJSON);
  }

  public MessengerResponse createMessenger(MessengerRequest request) {
    return execute("POST", "/api/messenger", request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public MessengerResponse createMessengerWithId(UUID messengerId, MessengerRequest request) {
    return execute("POST", "/api/messenger/" + encode(messengerId), request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public int deleteMessengerWithId(UUID messengerId) {
    return executeVoid("DELETE", "/api/messenger/" + encode(messengerId), null, null);
  }

  public MessengerResponse patchMessengerWithId(UUID messengerId, MessengerRequest request) {
    return execute("PATCH", "/api/messenger/" + encode(messengerId), request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public MessengerResponse retrieveMessengerWithId(UUID messengerId) {
    return execute("GET", "/api/messenger/" + encode(messengerId), null, null, MessengerResponse::fromJSON);
  }

  public MessengerResponse updateMessengerWithId(UUID messengerId, MessengerRequest request) {
    return execute("PUT", "/api/messenger/" + encode(messengerId), request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public LoginResponse passwordlessLoginWithId(PasswordlessLoginRequest request) {
    return execute("POST", "/api/passwordless/login", request.toJSON(), null, LoginResponse::fromJSON);
  }

  public int sendPasswordlessCodeWithId(PasswordlessSendRequest request) {
    return executeVoid("POST", "/api/passwordless/send", request.toJSON(), null);
  }

  public PasswordlessStartResponse startPasswordlessLoginWithId(PasswordlessStartRequest request) {
    return execute("POST", "/api/passwordless/start", request.toJSON(), null, PasswordlessStartResponse::fromJSON);
  }

  public int activateReactorWithId(ReactorRequest request) {
    return executeVoid("POST", "/api/reactor", request.toJSON(), null);
  }

  public ReactorMetricsResponse retrieveReactorMetricsWithId() {
    return execute("GET", "/api/reactor/metrics", null, null, ReactorMetricsResponse::fromJSON);
  }

  public DailyActiveUserReportResponse retrieveDailyActiveReportWithId(UUID applicationId, Long start, Long end, List<String> loginIdTypes) {
    return execute("GET", "/api/report/daily-active-user" + query("applicationId", applicationId, "start", start, "end", end, "loginIdTypes", loginIdTypes), null, null, DailyActiveUserReportResponse::fromJSON);
  }

  public LoginReportResponse retrieveReportLogin(UUID applicationId, String loginId, Long start, Long end, List<String> loginIdTypes, UUID userId) {
    return execute("GET", "/api/report/login" + query("applicationId", applicationId, "loginId", loginId, "start", start, "end", end, "loginIdTypes", loginIdTypes, "userId", userId), null, null, LoginReportResponse::fromJSON);
  }

  public MonthlyActiveUserReportResponse retrieveMonthlyActiveReportWithId(UUID applicationId, Long start, Long end, List<String> loginIdTypes) {
    return execute("GET", "/api/report/monthly-active-user" + query("applicationId", applicationId, "start", start, "end", end, "loginIdTypes", loginIdTypes), null, null, MonthlyActiveUserReportResponse::fromJSON);
  }

  public RegistrationReportResponse retrieveRegistrationReportWithId(UUID applicationId, Long start, Long end, List<String> loginIdTypes) {
    return execute("GET", "/api/report/registration" + query("applicationId", applicationId, "start", start, "end", end, "loginIdTypes", loginIdTypes), null, null, RegistrationReportResponse::fromJSON);
  }

  public TotalsReportResponse retrieveTotalReportWithExcludesWithId(List<String> excludes) {
    return execute("GET", "/api/report/totals" + query("excludes", excludes), null, null, TotalsReportResponse::fromJSON);
  }

  public StatusResponse retrieveStatus() {
    return execute("GET", "/api/status", null, null, StatusResponse::fromJSON);
  }

  public SystemConfigurationResponse patchSystemConfigurationWithId(SystemConfigurationRequest request) {
    return execute("PATCH", "/api/system-configuration", request.toJSON(), null, SystemConfigurationResponse::fromJSON);
  }

  public SystemConfigurationResponse updateSystemConfigurationWithId(SystemConfigurationRequest request) {
    return execute("PUT", "/api/system-configuration", request.toJSON(), null, SystemConfigurationResponse::fromJSON);
  }

  public AuditLogResponse createAuditLogWithId(AuditLogRequest request) {
    return execute("POST", "/api/system/audit-log", request.toJSON(), null, AuditLogResponse::fromJSON);
  }

  public AuditLogSearchResponse searchAuditLogsWithId(AuditLogSearchRequest request) {
    return execute("POST", "/api/system/audit-log/search", request.toJSON(), null, AuditLogSearchResponse::fromJSON);
  }

  public AuditLogResponse retrieveAuditLogWithId(Long auditLogId) {
    return execute("GET", "/api/system/audit-log/" + encode(auditLogId), null, null, AuditLogResponse::fromJSON);
  }

  public EventLogSearchResponse searchEventLogsWithId(EventLogSearchRequest request) {
    return execute("POST", "/api/system/event-log/search", request.toJSON(), null, EventLogSearchResponse::fromJSON);
  }

  public EventLogResponse retrieveEventLogWithId(Long eventLogId) {
    return execute("GET", "/api/system/event-log/" + encode(eventLogId), null, null, EventLogResponse::fromJSON);
  }

  public LoginRecordSearchResponse searchLoginRecordsWithId(LoginRecordSearchRequest request) {
    return execute("POST", "/api/system/login-record/search", request.toJSON(), null, LoginRecordSearchResponse::fromJSON);
  }

  public int retrieveReindexStatus() {
    return executeVoid("GET", "/api/system/reindex", null, null);
  }

  public int reindexWithId(ReindexRequest request) {
    return executeVoid("POST", "/api/system/reindex", request.toJSON(), null);
  }

  public VersionResponse retrieveVersionWithId() {
    return execute("GET", "/api/system/version", null, null, VersionResponse::fromJSON);
  }

  public WebhookAttemptLogResponse retrieveWebhookAttemptLogWithId(UUID webhookAttemptLogId) {
    return execute("GET", "/api/system/webhook-attempt-log/" + encode(webhookAttemptLogId), null, null, WebhookAttemptLogResponse::fromJSON);
  }

  public WebhookEventLogSearchResponse searchWebhookEventLogsWithId(WebhookEventLogSearchRequest request) {
    return execute("POST", "/api/system/webhook-event-log/search", request.toJSON(), null, WebhookEventLogSearchResponse::fromJSON);
  }

  public WebhookEventLogResponse retrieveWebhookEventLogWithId(UUID webhookEventLogId) {
    return execute("GET", "/api/system/webhook-event-log/" + encode(webhookEventLogId), null, null, WebhookEventLogResponse::fromJSON);
  }

  public TenantResponse createTenant(TenantRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/tenant", request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public TenantResponse createTenant(TenantRequest request) {
    return createTenant(request, null);
  }

  public TenantManagerConfigurationResponse patchTenantManagerConfigurationWithId(TenantManagerConfigurationRequest request) {
    return execute("PATCH", "/api/tenant-manager", request.toJSON(), null, TenantManagerConfigurationResponse::fromJSON);
  }

  public TenantManagerConfigurationResponse updateTenantManagerConfigurationWithId(TenantManagerConfigurationRequest request) {
    return execute("PUT", "/api/tenant-manager", request.toJSON(), null, TenantManagerConfigurationResponse::fromJSON);
  }

  public TenantManagerIdentityProviderTypeConfigurationResponse createTenantManagerIdentityProviderTypeConfigurationWithId(String type, TenantManagerIdentityProviderTypeConfigurationRequest request) {
    return execute("POST", "/api/tenant-manager/identity-provider/" + encode(type), request.toJSON(), null, TenantManagerIdentityProviderTypeConfigurationResponse::fromJSON);
  }

  public int deleteTenantManagerIdentityProviderTypeConfigurationWithId(String type) {
    return executeVoid("DELETE", "/api/tenant-manager/identity-provider/" + encode(type), null, null);
  }

  public TenantManagerIdentityProviderTypeConfigurationResponse patchTenantManagerIdentityProviderTypeConfigurationWithId(String type, TenantManagerIdentityProviderTypeConfigurationRequest request) {
    return execute("PATCH", "/api/tenant-manager/identity-provider/" + encode(type), request.toJSON(), null, TenantManagerIdentityProviderTypeConfigurationResponse::fromJSON);
  }

  public TenantManagerIdentityProviderTypeConfigurationResponse updateTenantManagerIdentityProviderTypeConfigurationWithId(String type, TenantManagerIdentityProviderTypeConfigurationRequest request) {
    return execute("PUT", "/api/tenant-manager/identity-provider/" + encode(type), request.toJSON(), null, TenantManagerIdentityProviderTypeConfigurationResponse::fromJSON);
  }

  public PasswordValidationRulesResponse retrievePasswordValidationRulesWithId() {
    return execute("GET", "/api/tenant/password-validation-rules", null, null, PasswordValidationRulesResponse::fromJSON);
  }

  public PasswordValidationRulesResponse retrievePasswordValidationRulesWithTenantIdWithId(UUID tenantId) {
    return execute("GET", "/api/tenant/password-validation-rules/" + encode(tenantId), null, null, PasswordValidationRulesResponse::fromJSON);
  }

  public TenantSearchResponse searchTenantsWithId(TenantSearchRequest request) {
    return execute("POST", "/api/tenant/search", request.toJSON(), null, TenantSearchResponse::fromJSON);
  }

  public TenantResponse createTenantWithId(UUID tenantId, TenantRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/tenant/" + encode(tenantId), request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public TenantResponse createTenantWithId(UUID tenantId, TenantRequest request) {
    return createTenantWithId(tenantId, request, null);
  }

  public int deleteTenantWithId(UUID tenantId, Boolean async, TenantDeleteRequest request, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/tenant/" + encode(tenantId) + query("async", async), request.toJSON(), xFusionAuthTenantId);
  }

  public int deleteTenantWithId(UUID tenantId, Boolean async, TenantDeleteRequest request) {
    return deleteTenantWithId(tenantId, async, request, null);
  }

  public TenantResponse patchTenantWithId(UUID tenantId, TenantRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/tenant/" + encode(tenantId), request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public TenantResponse patchTenantWithId(UUID tenantId, TenantRequest request) {
    return patchTenantWithId(tenantId, request, null);
  }

  public TenantResponse retrieveTenantWithId(UUID tenantId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/tenant/" + encode(tenantId), null, xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public TenantResponse retrieveTenantWithId(UUID tenantId) {
    return retrieveTenantWithId(tenantId, null);
  }

  public TenantResponse updateTenantWithId(UUID tenantId, TenantRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/tenant/" + encode(tenantId), request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public TenantResponse updateTenantWithId(UUID tenantId, TenantRequest request) {
    return updateTenantWithId(tenantId, request, null);
  }

  public ThemeResponse retrieveThemes() {
    return execute("GET", "/api/theme", null, null, ThemeResponse::fromJSON);
  }

  public ThemeResponse createTheme(ThemeRequest request) {
    return execute("POST", "/api/theme", request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public ThemeSearchResponse searchThemesWithId(ThemeSearchRequest request) {
    return execute("POST", "/api/theme/search", request.toJSON(), null, ThemeSearchResponse::fromJSON);
  }

  public ThemeResponse createThemeWithId(UUID themeId, ThemeRequest request) {
    return execute("POST", "/api/theme/" + encode(themeId), request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public int deleteThemeWithId(UUID themeId) {
    return executeVoid("DELETE", "/api/theme/" + encode(themeId), null, null);
  }

  public ThemeResponse patchThemeWithId(UUID themeId, ThemeRequest request) {
    return execute("PATCH", "/api/theme/" + encode(themeId), request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public ThemeResponse retrieveThemeWithId(UUID themeId) {
    return execute("GET", "/api/theme/" + encode(themeId), null, null, ThemeResponse::fromJSON);
  }

  public ThemeResponse updateThemeWithId(UUID themeId, ThemeRequest request) {
    return execute("PUT", "/api/theme/" + encode(themeId), request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public LoginResponse twoFactorLoginWithId(TwoFactorLoginRequest request) {
    return execute("POST", "/api/two-factor/login", request.toJSON(), null, LoginResponse::fromJSON);
  }

  public SecretResponse generateTwoFactorSecretUsingJWTWithId() {
    return execute("GET", "/api/two-factor/secret", null, null, SecretResponse::fromJSON);
  }

  public int sendTwoFactorCodeForEnableDisableWithId(TwoFactorSendRequest request) {
    return executeVoid("POST", "/api/two-factor/send", request.toJSON(), null);
  }

  public int sendTwoFactorCodeForLoginUsingMethodWithId(String twoFactorId, TwoFactorSendRequest request) {
    return executeVoid("POST", "/api/two-factor/send/" + encode(twoFactorId), request.toJSON(), null);
  }

  public TwoFactorStartResponse startTwoFactorLoginWithId(TwoFactorStartRequest request) {
    return execute("POST", "/api/two-factor/start", request.toJSON(), null, TwoFactorStartResponse::fromJSON);
  }

  public TwoFactorStatusResponse retrieveTwoFactorStatusWithRequestWithId(TwoFactorStatusRequest request) {
    return execute("POST", "/api/two-factor/status", request.toJSON(), null, TwoFactorStatusResponse::fromJSON);
  }

  public TwoFactorStatusResponse retrieveTwoFactorStatusWithId(String twoFactorTrustId, UUID userId, UUID applicationId) {
    return execute("GET", "/api/two-factor/status/" + encode(twoFactorTrustId) + query("userId", userId, "applicationId", applicationId), null, null, TwoFactorStatusResponse::fromJSON);
  }

  public UserResponse createUser(UserRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user", request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse createUser(UserRequest request) {
    return createUser(request, null);
  }

  public UserResponse retrieveUser(String verificationId, String username, String loginId, List<String> loginIdTypes, String email, String changePasswordId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user" + query("verificationId", verificationId, "username", username, "loginId", loginId, "loginIdTypes", loginIdTypes, "email", email, "changePasswordId", changePasswordId), null, xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse retrieveUser(String verificationId, String username, String loginId, List<String> loginIdTypes, String email, String changePasswordId) {
    return retrieveUser(verificationId, username, loginId, loginIdTypes, email, changePasswordId, null);
  }

  public UserActionResponse createUserAction(UserActionRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user-action", request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse createUserAction(UserActionRequest request) {
    return createUserAction(request, null);
  }

  public UserActionResponse retrieveUserAction(Boolean inactive, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user-action" + query("inactive", inactive), null, xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse retrieveUserAction(Boolean inactive) {
    return retrieveUserAction(inactive, null);
  }

  public UserActionReasonResponse createUserActionReason(UserActionReasonRequest request) {
    return execute("POST", "/api/user-action-reason", request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse retrieveUserActionReason() {
    return execute("GET", "/api/user-action-reason", null, null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse createUserActionReasonWithId(UUID userActionReasonId, UserActionReasonRequest request) {
    return execute("POST", "/api/user-action-reason/" + encode(userActionReasonId), request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public int deleteUserActionReasonWithId(UUID userActionReasonId) {
    return executeVoid("DELETE", "/api/user-action-reason/" + encode(userActionReasonId), null, null);
  }

  public UserActionReasonResponse patchUserActionReasonWithId(UUID userActionReasonId, UserActionReasonRequest request) {
    return execute("PATCH", "/api/user-action-reason/" + encode(userActionReasonId), request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse retrieveUserActionReasonWithId(UUID userActionReasonId) {
    return execute("GET", "/api/user-action-reason/" + encode(userActionReasonId), null, null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse updateUserActionReasonWithId(UUID userActionReasonId, UserActionReasonRequest request) {
    return execute("PUT", "/api/user-action-reason/" + encode(userActionReasonId), request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public UserActionResponse createUserActionWithId(UUID userActionId, UserActionRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user-action/" + encode(userActionId), request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse createUserActionWithId(UUID userActionId, UserActionRequest request) {
    return createUserActionWithId(userActionId, request, null);
  }

  public int deleteUserActionWithId(UUID userActionId, Boolean hardDelete, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/user-action/" + encode(userActionId) + query("hardDelete", hardDelete), null, xFusionAuthTenantId);
  }

  public int deleteUserActionWithId(UUID userActionId, Boolean hardDelete) {
    return deleteUserActionWithId(userActionId, hardDelete, null);
  }

  public UserActionResponse patchUserActionWithId(UUID userActionId, UserActionRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/user-action/" + encode(userActionId), request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse patchUserActionWithId(UUID userActionId, UserActionRequest request) {
    return patchUserActionWithId(userActionId, request, null);
  }

  public UserActionResponse updateUserActionWithId(UUID userActionId, Boolean reactivate, UserActionRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/user-action/" + encode(userActionId) + query("reactivate", reactivate), request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse updateUserActionWithId(UUID userActionId, Boolean reactivate, UserActionRequest request) {
    return updateUserActionWithId(userActionId, reactivate, request, null);
  }

  public UserActionResponse retrieveUserActionWithId(UUID userActionId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user-action/" + encode(userActionId), null, xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse retrieveUserActionWithId(UUID userActionId) {
    return retrieveUserActionWithId(userActionId, null);
  }

  public ActionResponse actionUserWithId(ActionRequest request) {
    return execute("POST", "/api/user/action", request.toJSON(), null, ActionResponse::fromJSON);
  }

  public ActionResponse retrieveUserActioning(UUID userId, Boolean active, Boolean preventingLogin) {
    return execute("GET", "/api/user/action" + query("userId", userId, "active", active, "preventingLogin", preventingLogin), null, null, ActionResponse::fromJSON);
  }

  public ActionResponse cancelActionWithId(UUID actionId, ActionRequest request) {
    return execute("DELETE", "/api/user/action/" + encode(actionId), request.toJSON(), null, ActionResponse::fromJSON);
  }

  public ActionResponse modifyActionWithId(UUID actionId, ActionRequest request) {
    return execute("PUT", "/api/user/action/" + encode(actionId), request.toJSON(), null, ActionResponse::fromJSON);
  }

  public ActionResponse retrieveActionWithId(UUID actionId) {
    return execute("GET", "/api/user/action/" + encode(actionId), null, null, ActionResponse::fromJSON);
  }

  public UserDeleteResponse deleteUserBulk(List<UUID> userIds, Boolean dryRun, Boolean hardDelete, UserDeleteRequest request) {
    return execute("DELETE", "/api/user/bulk" + query("userIds", userIds, "dryRun", dryRun, "hardDelete", hardDelete), request.toJSON(), null, UserDeleteResponse::fromJSON);
  }

  public ChangePasswordResponse createUserChangePassword(ChangePasswordRequest request) {
    return execute("POST", "/api/user/change-password", request.toJSON(), null, ChangePasswordResponse::fromJSON);
  }

  public int retrieveUserChangePassword(String loginId, List<String> loginIdTypes, String ipAddress) {
    return executeVoid("GET", "/api/user/change-password" + query("loginId", loginId, "loginIdTypes", loginIdTypes, "ipAddress", ipAddress), null, null);
  }

  public ChangePasswordResponse changePasswordWithId(String changePasswordId, ChangePasswordRequest request) {
    return execute("POST", "/api/user/change-password/" + encode(changePasswordId), request.toJSON(), null, ChangePasswordResponse::fromJSON);
  }

  public int retrieveUserChangePasswordWithId(String changePasswordId, String ipAddress) {
    return executeVoid("GET", "/api/user/change-password/" + encode(changePasswordId) + query("ipAddress", ipAddress), null, null);
  }

  public UserCommentResponse commentOnUserWithId(UserCommentRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user/comment", request.toJSON(), xFusionAuthTenantId, UserCommentResponse::fromJSON);
  }

  public UserCommentResponse commentOnUserWithId(UserCommentRequest request) {
    return commentOnUserWithId(request, null);
  }

  public UserCommentSearchResponse searchUserCommentsWithId(UserCommentSearchRequest request) {
    return execute("POST", "/api/user/comment/search", request.toJSON(), null, UserCommentSearchResponse::fromJSON);
  }

  public UserCommentResponse retrieveUserCommentsWithId(UUID userId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user/comment/" + encode(userId), null, xFusionAuthTenantId, UserCommentResponse::fromJSON);
  }

  public UserCommentResponse retrieveUserCommentsWithId(UUID userId) {
    return retrieveUserCommentsWithId(userId, null);
  }

  public UserConsentResponse createUserConsent(UserConsentRequest request) {
    return execute("POST", "/api/user/consent", request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse retrieveUserConsentsWithId(UUID userId) {
    return execute("GET", "/api/user/consent" + query("userId", userId), null, null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse createUserConsentWithId(UUID userConsentId, UserConsentRequest request) {
    return execute("POST", "/api/user/consent/" + encode(userConsentId), request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse patchUserConsentWithId(UUID userConsentId, UserConsentRequest request) {
    return execute("PATCH", "/api/user/consent/" + encode(userConsentId), request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse retrieveUserConsentWithId(UUID userConsentId) {
    return execute("GET", "/api/user/consent/" + encode(userConsentId), null, null, UserConsentResponse::fromJSON);
  }

  public int revokeUserConsentWithId(UUID userConsentId) {
    return executeVoid("DELETE", "/api/user/consent/" + encode(userConsentId), null, null);
  }

  public UserConsentResponse updateUserConsentWithId(UUID userConsentId, UserConsentRequest request) {
    return execute("PUT", "/api/user/consent/" + encode(userConsentId), request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public FamilyResponse createFamily(FamilyRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user/family", request.toJSON(), xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse createFamily(FamilyRequest request) {
    return createFamily(request, null);
  }

  public FamilyResponse retrieveFamiliesWithId(UUID userId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user/family" + query("userId", userId), null, xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse retrieveFamiliesWithId(UUID userId) {
    return retrieveFamiliesWithId(userId, null);
  }

  public PendingResponse retrievePendingChildrenWithId(String parentEmail) {
    return execute("GET", "/api/user/family/pending" + query("parentEmail", parentEmail), null, null, PendingResponse::fromJSON);
  }

  public int sendFamilyRequestEmailWithId(FamilyEmailRequest request) {
    return executeVoid("POST", "/api/user/family/request", request.toJSON(), null);
  }

  public FamilyResponse updateUserFamilyWithId(UUID familyId, FamilyRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/user/family/" + encode(familyId), request.toJSON(), xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse updateUserFamilyWithId(UUID familyId, FamilyRequest request) {
    return updateUserFamilyWithId(familyId, request, null);
  }

  public FamilyResponse createFamilyWithId(UUID familyId, FamilyRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user/family/" + encode(familyId), request.toJSON(), xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse createFamilyWithId(UUID familyId, FamilyRequest request) {
    return createFamilyWithId(familyId, request, null);
  }

  public FamilyResponse retrieveFamilyMembersByFamilyIdWithId(UUID familyId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user/family/" + encode(familyId), null, xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse retrieveFamilyMembersByFamilyIdWithId(UUID familyId) {
    return retrieveFamilyMembersByFamilyIdWithId(familyId, null);
  }

  public int removeUserFromFamilyWithId(UUID familyId, UUID userId, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/user/family/" + encode(familyId) + "/" + encode(userId), null, xFusionAuthTenantId);
  }

  public int removeUserFromFamilyWithId(UUID familyId, UUID userId) {
    return removeUserFromFamilyWithId(familyId, userId, null);
  }

  public ForgotPasswordResponse forgotPasswordWithId(ForgotPasswordRequest request) {
    return execute("POST", "/api/user/forgot-password", request.toJSON(), null, ForgotPasswordResponse::fromJSON);
  }

  public int importUsersWithId(ImportRequest request) {
    return executeVoid("POST", "/api/user/import", request.toJSON(), null);
  }

  public RecentLoginResponse retrieveUserRecentLogin(UUID applicationId, UUID userId, Integer offset, Integer limit) {
    return execute("GET", "/api/user/recent-login" + query("applicationId", applicationId, "userId", userId, "offset", offset, "limit", limit), null, null, RecentLoginResponse::fromJSON);
  }

  public int importRefreshTokensWithId(RefreshTokenImportRequest request) {
    return executeVoid("POST", "/api/user/refresh-token/import", request.toJSON(), null);
  }

  public RegistrationResponse register(RegistrationRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user/registration", request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse register(RegistrationRequest request) {
    return register(request, null);
  }

  public RegistrationResponse patchRegistrationWithId(UUID userId, RegistrationRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/user/registration/" + encode(userId), request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse patchRegistrationWithId(UUID userId, RegistrationRequest request) {
    return patchRegistrationWithId(userId, request, null);
  }

  public RegistrationResponse registerWithId(UUID userId, RegistrationRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user/registration/" + encode(userId), request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse registerWithId(UUID userId, RegistrationRequest request) {
    return registerWithId(userId, request, null);
  }

  public RegistrationResponse updateRegistrationWithId(UUID userId, RegistrationRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/user/registration/" + encode(userId), request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse updateRegistrationWithId(UUID userId, RegistrationRequest request) {
    return updateRegistrationWithId(userId, request, null);
  }

  public int deleteUserRegistrationWithId(UUID userId, UUID applicationId, RegistrationDeleteRequest request, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/user/registration/" + encode(userId) + "/" + encode(applicationId), request.toJSON(), xFusionAuthTenantId);
  }

  public int deleteUserRegistrationWithId(UUID userId, UUID applicationId, RegistrationDeleteRequest request) {
    return deleteUserRegistrationWithId(userId, applicationId, request, null);
  }

  public RegistrationResponse retrieveRegistrationWithId(UUID userId, UUID applicationId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user/registration/" + encode(userId) + "/" + encode(applicationId), null, xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse retrieveRegistrationWithId(UUID userId, UUID applicationId) {
    return retrieveRegistrationWithId(userId, applicationId, null);
  }

  public SearchResponse searchUsersByIdsWithId(List<UUID> ids, String queryString, String query, Integer numberOfResults, Integer startRow, Boolean accurateTotal) {
    return execute("GET", "/api/user/search" + query("ids", ids, "queryString", queryString, "query", query, "numberOfResults", numberOfResults, "startRow", startRow, "accurateTotal", accurateTotal), null, null, SearchResponse::fromJSON);
  }

  public SearchResponse searchUsersByQueryWithId(SearchRequest request) {
    return execute("POST", "/api/user/search", request.toJSON(), null, SearchResponse::fromJSON);
  }

  public TwoFactorRecoveryCodeResponse generateTwoFactorRecoveryCodesWithId(UUID userId) {
    return execute("POST", "/api/user/two-factor/recovery-code/" + encode(userId), null, null, TwoFactorRecoveryCodeResponse::fromJSON);
  }

  public TwoFactorRecoveryCodeResponse retrieveTwoFactorRecoveryCodesWithId(UUID userId) {
    return execute("GET", "/api/user/two-factor/recovery-code/" + encode(userId), null, null, TwoFactorRecoveryCodeResponse::fromJSON);
  }

  public int deleteUserTwoFactorWithId(UUID userId, String methodId, String code, TwoFactorDisableRequest request) {
    return executeVoid("DELETE", "/api/user/two-factor/" + encode(userId) + query("methodId", methodId, "code", code), request.toJSON(), null);
  }

  public TwoFactorResponse enableTwoFactorWithId(UUID userId, TwoFactorRequest request) {
    return execute("POST", "/api/user/two-factor/" + encode(userId), request.toJSON(), null, TwoFactorResponse::fromJSON);
  }

  public VerifyEmailResponse updateUserVerifyEmail(UUID applicationId, String email, Boolean sendVerifyEmail) {
    return execute("PUT", "/api/user/verify-email" + query("applicationId", applicationId, "email", email, "sendVerifyEmail", sendVerifyEmail), null, null, VerifyEmailResponse::fromJSON);
  }

  public int createUserVerifyEmail(VerifyEmailRequest request) {
    return executeVoid("POST", "/api/user/verify-email", request.toJSON(), null);
  }

  public VerifyRegistrationResponse updateUserVerifyRegistration(String email, UUID applicationId, Boolean sendVerifyPasswordEmail) {
    return execute("PUT", "/api/user/verify-registration" + query("email", email, "applicationId", applicationId, "sendVerifyPasswordEmail", sendVerifyPasswordEmail), null, null, VerifyRegistrationResponse::fromJSON);
  }

  public int verifyUserRegistrationWithId(VerifyRegistrationRequest request) {
    return executeVoid("POST", "/api/user/verify-registration", request.toJSON(), null);
  }

  public UserResponse createUserWithId(UUID userId, UserRequest request, UUID xFusionAuthTenantId) {
    return execute("POST", "/api/user/" + encode(userId), request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse createUserWithId(UUID userId, UserRequest request) {
    return createUserWithId(userId, request, null);
  }

  public int deleteUserWithId(UUID userId, Boolean hardDelete, UserDeleteSingleRequest request, UUID xFusionAuthTenantId) {
    return executeVoid("DELETE", "/api/user/" + encode(userId) + query("hardDelete", hardDelete), request.toJSON(), xFusionAuthTenantId);
  }

  public int deleteUserWithId(UUID userId, Boolean hardDelete, UserDeleteSingleRequest request) {
    return deleteUserWithId(userId, hardDelete, request, null);
  }

  public UserResponse patchUserWithId(UUID userId, UserRequest request, UUID xFusionAuthTenantId) {
    return execute("PATCH", "/api/user/" + encode(userId), request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse patchUserWithId(UUID userId, UserRequest request) {
    return patchUserWithId(userId, request, null);
  }

  public UserResponse updateUserWithId(UUID userId, Boolean reactivate, UserRequest request, UUID xFusionAuthTenantId) {
    return execute("PUT", "/api/user/" + encode(userId) + query("reactivate", reactivate), request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse updateUserWithId(UUID userId, Boolean reactivate, UserRequest request) {
    return updateUserWithId(userId, reactivate, request, null);
  }

  public UserResponse retrieveUserWithId(UUID userId, UUID xFusionAuthTenantId) {
    return execute("GET", "/api/user/" + encode(userId), null, xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse retrieveUserWithId(UUID userId) {
    return retrieveUserWithId(userId, null);
  }

  public int deleteWebAuthnCredentialsForUserWithId(UUID userId) {
    return executeVoid("DELETE", "/api/webauthn" + query("userId", userId), null, null);
  }

  public WebAuthnCredentialResponse retrieveWebAuthnCredentialsForUserWithId(UUID userId) {
    return execute("GET", "/api/webauthn" + query("userId", userId), null, null, WebAuthnCredentialResponse::fromJSON);
  }

  public WebAuthnAssertResponse completeWebAuthnAssertionWithId(WebAuthnLoginRequest request) {
    return execute("POST", "/api/webauthn/assert", request.toJSON(), null, WebAuthnAssertResponse::fromJSON);
  }

  public int importWebAuthnCredentialWithId(WebAuthnCredentialImportRequest request) {
    return executeVoid("POST", "/api/webauthn/import", request.toJSON(), null);
  }

  public LoginResponse completeWebAuthnLoginWithId(WebAuthnLoginRequest request) {
    return execute("POST", "/api/webauthn/login", request.toJSON(), null, LoginResponse::fromJSON);
  }

  public WebAuthnRegisterCompleteResponse completeWebAuthnRegistrationWithId(WebAuthnRegisterCompleteRequest request) {
    return execute("POST", "/api/webauthn/register/complete", request.toJSON(), null, WebAuthnRegisterCompleteResponse::fromJSON);
  }

  public WebAuthnRegisterStartResponse startWebAuthnRegistrationWithId(WebAuthnRegisterStartRequest request) {
    return execute("POST", "/api/webauthn/register/start", request.toJSON(), null, WebAuthnRegisterStartResponse::fromJSON);
  }

  public WebAuthnStartResponse startWebAuthnLoginWithId(WebAuthnStartRequest request) {
    return execute("POST", "/api/webauthn/start", request.toJSON(), null, WebAuthnStartResponse::fromJSON);
  }

  public int deleteWebAuthnCredentialWithId(UUID id) {
    return executeVoid("DELETE", "/api/webauthn/" + encode(id), null, null);
  }

  public WebAuthnCredentialResponse retrieveWebAuthnCredentialWithId(UUID id) {
    return execute("GET", "/api/webauthn/" + encode(id), null, null, WebAuthnCredentialResponse::fromJSON);
  }

  public WebhookResponse createWebhook(WebhookRequest request) {
    return execute("POST", "/api/webhook", request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public WebhookResponse retrieveWebhook() {
    return execute("GET", "/api/webhook", null, null, WebhookResponse::fromJSON);
  }

  public WebhookSearchResponse searchWebhooks(String description, UUID tenantId, String url, Integer numberOfResults, String orderBy, Integer startRow) {
    return execute("GET", "/api/webhook/search" + query("description", description, "tenantId", tenantId, "url", url, "numberOfResults", numberOfResults, "orderBy", orderBy, "startRow", startRow), null, null, WebhookSearchResponse::fromJSON);
  }

  public WebhookSearchResponse searchWebhooksWithId(WebhookSearchRequest request) {
    return execute("POST", "/api/webhook/search", request.toJSON(), null, WebhookSearchResponse::fromJSON);
  }

  public WebhookResponse createWebhookWithId(UUID webhookId, WebhookRequest request) {
    return execute("POST", "/api/webhook/" + encode(webhookId), request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public int deleteWebhookWithId(UUID webhookId) {
    return executeVoid("DELETE", "/api/webhook/" + encode(webhookId), null, null);
  }

  public WebhookResponse patchWebhookWithId(UUID webhookId, WebhookRequest request) {
    return execute("PATCH", "/api/webhook/" + encode(webhookId), request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public WebhookResponse retrieveWebhookWithId(UUID webhookId) {
    return execute("GET", "/api/webhook/" + encode(webhookId), null, null, WebhookResponse::fromJSON);
  }

  public WebhookResponse updateWebhookWithId(UUID webhookId, WebhookRequest request) {
    return execute("PUT", "/api/webhook/" + encode(webhookId), request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public DeviceApprovalResponse createDeviceApprove() {
    return execute("POST", "/oauth2/device/approve", null, null, DeviceApprovalResponse::fromJSON);
  }

  public int retrieveDeviceUserCode() {
    return executeVoid("GET", "/oauth2/device/user-code", null, null);
  }

  public int createDeviceUserCode() {
    return executeVoid("POST", "/oauth2/device/user-code", null, null);
  }

  public int retrieveDeviceValidate(String user_code, String client_id) {
    return executeVoid("GET", "/oauth2/device/validate" + query("user_code", user_code, "client_id", client_id), null, null);
  }

  public DeviceResponse createDevice_authorize() {
    return execute("POST", "/oauth2/device_authorize", null, null, DeviceResponse::fromJSON);
  }

  public IntrospectResponse createIntrospect() {
    return execute("POST", "/oauth2/introspect", null, null, IntrospectResponse::fromJSON);
  }

  public AccessToken createToken() {
    return execute("POST", "/oauth2/token", null, null, AccessToken::fromJSON);
  }

  public UserinfoResponse retrieveUserInfoFromAccessTokenWithId() {
    return execute("GET", "/oauth2/userinfo", null, null, UserinfoResponse::fromJSON);
  }

  // ===== GENERATED METHODS END =====

  private FusionAuthException error(HttpResponse<String> response) {
    String body = response.body();
    Errors errors = null;
    if (body != null && !body.isEmpty()) {
      try {
        errors = Errors.fromJSON(body);
      } catch (RuntimeException ignored) {
      }
    }
    return new FusionAuthException(response.statusCode(), errors, body,
        "FusionAuth request failed with status [" + response.statusCode() + "]", null);
  }

  private <T> T execute(String method, String path, String body, UUID tenantId, Function<String, T> parser) {
    HttpResponse<String> response = send(method, path, body, tenantId);
    int status = response.statusCode();
    if (status / 100 == 2) {
      String b = response.body();
      return (b == null || b.isEmpty()) ? null : parser.apply(b);
    }
    if (status == 404) {
      return null;
    }
    throw error(response);
  }

  private int executeVoid(String method, String path, String body, UUID tenantId) {
    HttpResponse<String> response = send(method, path, body, tenantId);
    int status = response.statusCode();
    if (status / 100 != 2 && status != 404) {
      throw error(response);
    }
    return status;
  }

  private HttpResponse<String> send(String method, String path, String body, UUID tenantId) {
    try {
      HttpRequest.Builder builder = HttpRequest.newBuilder()
          .uri(URI.create(baseURL + path))
          .timeout(timeout)
          .header("Authorization", apiKey);
      if (tenantId != null) {
        builder.header("X-FusionAuth-TenantId", tenantId.toString());
      }
      if (body != null) {
        builder.header("Content-Type", "application/json");
        builder.method(method, HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8));
      } else {
        builder.method(method, HttpRequest.BodyPublishers.noBody());
      }
      return httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      if (e instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
      throw new FusionAuthException(0, null, null,
          "Transport failure calling [" + method + " " + path + "]", e);
    }
  }

  private static String encode(Object value) {
    return URLEncoder.encode(value.toString(), StandardCharsets.UTF_8);
  }

  private static String query(Object... nameValues) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i + 1 < nameValues.length; i += 2) {
      String name = (String) nameValues[i];
      Object value = nameValues[i + 1];
      if (value == null) {
        continue;
      }
      if (value instanceof Iterable<?> values) {
        for (Object element : values) {
          if (element != null) {
            sb.append(sb.isEmpty() ? "?" : "&").append(name).append("=").append(encode(element.toString()));
          }
        }
      } else {
        sb.append(sb.isEmpty() ? "?" : "&").append(name).append("=").append(encode(value.toString()));
      }
    }
    return sb.toString();
  }

  private static String queryList(String name, String... values) {
    StringBuilder sb = new StringBuilder();
    if (values != null) {
      for (String value : values) {
        if (value == null) {
          continue;
        }
        sb.append(sb.isEmpty() ? "?" : "&").append(name).append("=").append(encode(value));
      }
    }
    return sb.toString();
  }
}
