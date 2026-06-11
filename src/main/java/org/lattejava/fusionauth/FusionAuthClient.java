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

  public APIKeyResponse createAPIKeyWithId(String keyId, APIKeyRequest request) {
    return execute("POST", "/api/api-key/" + encode(keyId), request.toJSON(), null, APIKeyResponse::fromJSON);
  }

  public void deleteAPIKeyWithId(String keyId) {
    executeVoid("DELETE", "/api/api-key/" + encode(keyId), null, null);
  }

  public APIKeyResponse patchAPIKeyWithId(String keyId, APIKeyRequest request) {
    return execute("PATCH", "/api/api-key/" + encode(keyId), request.toJSON(), null, APIKeyResponse::fromJSON);
  }

  public APIKeyResponse retrieveAPIKeyWithId(String keyId) {
    return execute("GET", "/api/api-key/" + encode(keyId), null, null, APIKeyResponse::fromJSON);
  }

  public APIKeyResponse updateAPIKeyWithId(String keyId, APIKeyRequest request) {
    return execute("PUT", "/api/api-key/" + encode(keyId), request.toJSON(), null, APIKeyResponse::fromJSON);
  }

  public ApplicationResponse createApplication(String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("POST", "/api/application", request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse retrieveApplication(String inactive, String xFusionAuthTenantId) {
    return execute("GET", "/api/application" + query("inactive", inactive), null, xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationSearchResponse searchApplicationsWithId(ApplicationSearchRequest request) {
    return execute("POST", "/api/application/search", request.toJSON(), null, ApplicationSearchResponse::fromJSON);
  }

  public ApplicationResponse createApplicationWithId(String applicationId, String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("POST", "/api/application/" + encode(applicationId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public void deleteApplicationWithId(String applicationId, String hardDelete, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/application/" + encode(applicationId) + query("hardDelete", hardDelete), null, xFusionAuthTenantId);
  }

  public ApplicationResponse patchApplicationWithId(String applicationId, String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("PATCH", "/api/application/" + encode(applicationId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse updateApplicationWithId(String applicationId, String reactivate, String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("PUT", "/api/application/" + encode(applicationId) + query("reactivate", reactivate), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse retrieveApplicationWithId(String applicationId, String xFusionAuthTenantId) {
    return execute("GET", "/api/application/" + encode(applicationId), null, xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public OAuthConfigurationResponse retrieveOauthConfigurationWithId(String applicationId, String xFusionAuthTenantId) {
    return execute("GET", "/api/application/" + encode(applicationId) + "/oauth-configuration", null, xFusionAuthTenantId, OAuthConfigurationResponse::fromJSON);
  }

  public ApplicationResponse createApplicationRole(String applicationId, String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/role", request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse createApplicationRoleWithId(String applicationId, String roleId, String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public void deleteApplicationRoleWithId(String applicationId, String roleId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), null, xFusionAuthTenantId);
  }

  public ApplicationResponse patchApplicationRoleWithId(String applicationId, String roleId, String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("PATCH", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationResponse updateApplicationRoleWithId(String applicationId, String roleId, String xFusionAuthTenantId, ApplicationRequest request) {
    return execute("PUT", "/api/application/" + encode(applicationId) + "/role/" + encode(roleId), request.toJSON(), xFusionAuthTenantId, ApplicationResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse createOAuthScope(String applicationId, String xFusionAuthTenantId, ApplicationOAuthScopeRequest request) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/scope", request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse createOAuthScopeWithId(String applicationId, String scopeId, String xFusionAuthTenantId, ApplicationOAuthScopeRequest request) {
    return execute("POST", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public void deleteOAuthScopeWithId(String applicationId, String scopeId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), null, xFusionAuthTenantId);
  }

  public ApplicationOAuthScopeResponse patchOAuthScopeWithId(String applicationId, String scopeId, String xFusionAuthTenantId, ApplicationOAuthScopeRequest request) {
    return execute("PATCH", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse retrieveOAuthScopeWithId(String applicationId, String scopeId, String xFusionAuthTenantId) {
    return execute("GET", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), null, xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ApplicationOAuthScopeResponse updateOAuthScopeWithId(String applicationId, String scopeId, String xFusionAuthTenantId, ApplicationOAuthScopeRequest request) {
    return execute("PUT", "/api/application/" + encode(applicationId) + "/scope/" + encode(scopeId), request.toJSON(), xFusionAuthTenantId, ApplicationOAuthScopeResponse::fromJSON);
  }

  public ConnectorResponse createConnector(ConnectorRequest request) {
    return execute("POST", "/api/connector", request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public ConnectorResponse createConnectorWithId(String connectorId, ConnectorRequest request) {
    return execute("POST", "/api/connector/" + encode(connectorId), request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public void deleteConnectorWithId(String connectorId) {
    executeVoid("DELETE", "/api/connector/" + encode(connectorId), null, null);
  }

  public ConnectorResponse patchConnectorWithId(String connectorId, ConnectorRequest request) {
    return execute("PATCH", "/api/connector/" + encode(connectorId), request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public ConnectorResponse retrieveConnectorWithId(String connectorId) {
    return execute("GET", "/api/connector/" + encode(connectorId), null, null, ConnectorResponse::fromJSON);
  }

  public ConnectorResponse updateConnectorWithId(String connectorId, ConnectorRequest request) {
    return execute("PUT", "/api/connector/" + encode(connectorId), request.toJSON(), null, ConnectorResponse::fromJSON);
  }

  public ConsentResponse createConsent(String xFusionAuthTenantId, ConsentRequest request) {
    return execute("POST", "/api/consent", request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentSearchResponse searchConsentsWithId(ConsentSearchRequest request) {
    return execute("POST", "/api/consent/search", request.toJSON(), null, ConsentSearchResponse::fromJSON);
  }

  public ConsentResponse createConsentWithId(String consentId, String xFusionAuthTenantId, ConsentRequest request) {
    return execute("POST", "/api/consent/" + encode(consentId), request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public void deleteConsentWithId(String consentId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/consent/" + encode(consentId), null, xFusionAuthTenantId);
  }

  public ConsentResponse patchConsentWithId(String consentId, String xFusionAuthTenantId, ConsentRequest request) {
    return execute("PATCH", "/api/consent/" + encode(consentId), request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentResponse retrieveConsentWithId(String consentId, String xFusionAuthTenantId) {
    return execute("GET", "/api/consent/" + encode(consentId), null, xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public ConsentResponse updateConsentWithId(String consentId, String xFusionAuthTenantId, ConsentRequest request) {
    return execute("PUT", "/api/consent/" + encode(consentId), request.toJSON(), xFusionAuthTenantId, ConsentResponse::fromJSON);
  }

  public SendResponse sendEmailWithId(String emailTemplateId, SendRequest request) {
    return execute("POST", "/api/email/send/" + encode(emailTemplateId), request.toJSON(), null, SendResponse::fromJSON);
  }

  public EmailTemplateResponse createEmailTemplate(String xFusionAuthTenantId, EmailTemplateRequest request) {
    return execute("POST", "/api/email/template", request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse retrieveEmailTemplate(String xFusionAuthTenantId) {
    return execute("GET", "/api/email/template", null, xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public PreviewResponse retrieveEmailTemplatePreviewWithId(PreviewRequest request) {
    return execute("POST", "/api/email/template/preview", request.toJSON(), null, PreviewResponse::fromJSON);
  }

  public EmailTemplateSearchResponse searchEmailTemplatesWithId(EmailTemplateSearchRequest request) {
    return execute("POST", "/api/email/template/search", request.toJSON(), null, EmailTemplateSearchResponse::fromJSON);
  }

  public EmailTemplateResponse createEmailTemplateWithId(String emailTemplateId, String xFusionAuthTenantId, EmailTemplateRequest request) {
    return execute("POST", "/api/email/template/" + encode(emailTemplateId), request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public void deleteEmailTemplateWithId(String emailTemplateId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/email/template/" + encode(emailTemplateId), null, xFusionAuthTenantId);
  }

  public EmailTemplateResponse patchEmailTemplateWithId(String emailTemplateId, String xFusionAuthTenantId, EmailTemplateRequest request) {
    return execute("PATCH", "/api/email/template/" + encode(emailTemplateId), request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse retrieveEmailTemplateWithId(String emailTemplateId, String xFusionAuthTenantId) {
    return execute("GET", "/api/email/template/" + encode(emailTemplateId), null, xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EmailTemplateResponse updateEmailTemplateWithId(String emailTemplateId, String xFusionAuthTenantId, EmailTemplateRequest request) {
    return execute("PUT", "/api/email/template/" + encode(emailTemplateId), request.toJSON(), xFusionAuthTenantId, EmailTemplateResponse::fromJSON);
  }

  public EntityResponse createEntity(String xFusionAuthTenantId, EntityRequest request) {
    return execute("POST", "/api/entity", request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityGrantSearchResponse searchEntityGrantsWithId(EntityGrantSearchRequest request) {
    return execute("POST", "/api/entity/grant/search", request.toJSON(), null, EntityGrantSearchResponse::fromJSON);
  }

  public EntitySearchResponse searchEntitiesWithId(EntitySearchRequest request) {
    return execute("POST", "/api/entity/search", request.toJSON(), null, EntitySearchResponse::fromJSON);
  }

  public EntitySearchResponse searchEntitiesByIdsWithId(String ids) {
    return execute("GET", "/api/entity/search" + query("ids", ids), null, null, EntitySearchResponse::fromJSON);
  }

  public EntityTypeResponse createEntityType(EntityTypeRequest request) {
    return execute("POST", "/api/entity/type", request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeSearchResponse searchEntityTypesWithId(EntityTypeSearchRequest request) {
    return execute("POST", "/api/entity/type/search", request.toJSON(), null, EntityTypeSearchResponse::fromJSON);
  }

  public EntityTypeResponse createEntityTypeWithId(String entityTypeId, EntityTypeRequest request) {
    return execute("POST", "/api/entity/type/" + encode(entityTypeId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public void deleteEntityTypeWithId(String entityTypeId) {
    executeVoid("DELETE", "/api/entity/type/" + encode(entityTypeId), null, null);
  }

  public EntityTypeResponse patchEntityTypeWithId(String entityTypeId, EntityTypeRequest request) {
    return execute("PATCH", "/api/entity/type/" + encode(entityTypeId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse retrieveEntityTypeWithId(String entityTypeId) {
    return execute("GET", "/api/entity/type/" + encode(entityTypeId), null, null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse updateEntityTypeWithId(String entityTypeId, EntityTypeRequest request) {
    return execute("PUT", "/api/entity/type/" + encode(entityTypeId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse createEntityTypePermission(String entityTypeId, EntityTypeRequest request) {
    return execute("POST", "/api/entity/type/" + encode(entityTypeId) + "/permission", request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse createEntityTypePermissionWithId(String entityTypeId, String permissionId, EntityTypeRequest request) {
    return execute("POST", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public void deleteEntityTypePermissionWithId(String entityTypeId, String permissionId) {
    executeVoid("DELETE", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), null, null);
  }

  public EntityTypeResponse patchEntityTypePermissionWithId(String entityTypeId, String permissionId, EntityTypeRequest request) {
    return execute("PATCH", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityTypeResponse updateEntityTypePermissionWithId(String entityTypeId, String permissionId, EntityTypeRequest request) {
    return execute("PUT", "/api/entity/type/" + encode(entityTypeId) + "/permission/" + encode(permissionId), request.toJSON(), null, EntityTypeResponse::fromJSON);
  }

  public EntityResponse createEntityWithId(String entityId, String xFusionAuthTenantId, EntityRequest request) {
    return execute("POST", "/api/entity/" + encode(entityId), request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public void deleteEntityWithId(String entityId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/entity/" + encode(entityId), null, xFusionAuthTenantId);
  }

  public EntityResponse patchEntityWithId(String entityId, String xFusionAuthTenantId, EntityRequest request) {
    return execute("PATCH", "/api/entity/" + encode(entityId), request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityResponse retrieveEntityWithId(String entityId, String xFusionAuthTenantId) {
    return execute("GET", "/api/entity/" + encode(entityId), null, xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public EntityResponse updateEntityWithId(String entityId, String xFusionAuthTenantId, EntityRequest request) {
    return execute("PUT", "/api/entity/" + encode(entityId), request.toJSON(), xFusionAuthTenantId, EntityResponse::fromJSON);
  }

  public void deleteEntityGrantWithId(String entityId, String recipientEntityId, String userId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/entity/" + encode(entityId) + "/grant" + query("recipientEntityId", recipientEntityId, "userId", userId), null, xFusionAuthTenantId);
  }

  public EntityGrantResponse retrieveEntityGrantWithId(String entityId, String recipientEntityId, String userId, String xFusionAuthTenantId) {
    return execute("GET", "/api/entity/" + encode(entityId) + "/grant" + query("recipientEntityId", recipientEntityId, "userId", userId), null, xFusionAuthTenantId, EntityGrantResponse::fromJSON);
  }

  public void upsertEntityGrantWithId(String entityId, String xFusionAuthTenantId, EntityGrantRequest request) {
    executeVoid("POST", "/api/entity/" + encode(entityId) + "/grant", request.toJSON(), xFusionAuthTenantId);
  }

  public FormResponse createForm(FormRequest request) {
    return execute("POST", "/api/form", request.toJSON(), null, FormResponse::fromJSON);
  }

  public FormFieldResponse createFormField(FormFieldRequest request) {
    return execute("POST", "/api/form/field", request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public FormFieldResponse createFormFieldWithId(String fieldId, FormFieldRequest request) {
    return execute("POST", "/api/form/field/" + encode(fieldId), request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public void deleteFormFieldWithId(String fieldId) {
    executeVoid("DELETE", "/api/form/field/" + encode(fieldId), null, null);
  }

  public FormFieldResponse patchFormFieldWithId(String fieldId, FormFieldRequest request) {
    return execute("PATCH", "/api/form/field/" + encode(fieldId), request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public FormFieldResponse retrieveFormFieldWithId(String fieldId) {
    return execute("GET", "/api/form/field/" + encode(fieldId), null, null, FormFieldResponse::fromJSON);
  }

  public FormFieldResponse updateFormFieldWithId(String fieldId, FormFieldRequest request) {
    return execute("PUT", "/api/form/field/" + encode(fieldId), request.toJSON(), null, FormFieldResponse::fromJSON);
  }

  public FormResponse createFormWithId(String formId, FormRequest request) {
    return execute("POST", "/api/form/" + encode(formId), request.toJSON(), null, FormResponse::fromJSON);
  }

  public void deleteFormWithId(String formId) {
    executeVoid("DELETE", "/api/form/" + encode(formId), null, null);
  }

  public FormResponse patchFormWithId(String formId, FormRequest request) {
    return execute("PATCH", "/api/form/" + encode(formId), request.toJSON(), null, FormResponse::fromJSON);
  }

  public FormResponse retrieveFormWithId(String formId) {
    return execute("GET", "/api/form/" + encode(formId), null, null, FormResponse::fromJSON);
  }

  public FormResponse updateFormWithId(String formId, FormRequest request) {
    return execute("PUT", "/api/form/" + encode(formId), request.toJSON(), null, FormResponse::fromJSON);
  }

  public GroupResponse createGroup(String xFusionAuthTenantId, GroupRequest request) {
    return execute("POST", "/api/group", request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public MemberResponse createGroupMembersWithId(MemberRequest request) {
    return execute("POST", "/api/group/member", request.toJSON(), null, MemberResponse::fromJSON);
  }

  public void deleteGroupMembersWithId(MemberDeleteRequest request) {
    executeVoid("DELETE", "/api/group/member", request.toJSON(), null);
  }

  public MemberResponse updateGroupMembersWithId(MemberRequest request) {
    return execute("PUT", "/api/group/member", request.toJSON(), null, MemberResponse::fromJSON);
  }

  public GroupMemberSearchResponse searchGroupMembersWithId(GroupMemberSearchRequest request) {
    return execute("POST", "/api/group/member/search", request.toJSON(), null, GroupMemberSearchResponse::fromJSON);
  }

  public GroupSearchResponse searchGroupsWithId(GroupSearchRequest request) {
    return execute("POST", "/api/group/search", request.toJSON(), null, GroupSearchResponse::fromJSON);
  }

  public GroupResponse createGroupWithId(String groupId, String xFusionAuthTenantId, GroupRequest request) {
    return execute("POST", "/api/group/" + encode(groupId), request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public void deleteGroupWithId(String groupId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/group/" + encode(groupId), null, xFusionAuthTenantId);
  }

  public GroupResponse patchGroupWithId(String groupId, String xFusionAuthTenantId, GroupRequest request) {
    return execute("PATCH", "/api/group/" + encode(groupId), request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public GroupResponse retrieveGroupWithId(String groupId, String xFusionAuthTenantId) {
    return execute("GET", "/api/group/" + encode(groupId), null, xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public GroupResponse updateGroupWithId(String groupId, String xFusionAuthTenantId, GroupRequest request) {
    return execute("PUT", "/api/group/" + encode(groupId), request.toJSON(), xFusionAuthTenantId, GroupResponse::fromJSON);
  }

  public void retrieveSystemHealthWithId() {
    executeVoid("GET", "/api/health", null, null);
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

  public IdentityProviderLinkResponse deleteUserLinkWithId(String identityProviderId, String identityProviderUserId, String userId) {
    return execute("DELETE", "/api/identity-provider/link" + query("identityProviderId", identityProviderId, "identityProviderUserId", identityProviderUserId, "userId", userId), null, null, IdentityProviderLinkResponse::fromJSON);
  }

  public IdentityProviderLinkResponse retrieveIdentityProviderLink(String identityProviderId, String userId, String identityProviderUserId) {
    return execute("GET", "/api/identity-provider/link" + query("identityProviderId", identityProviderId, "userId", userId, "identityProviderUserId", identityProviderUserId), null, null, IdentityProviderLinkResponse::fromJSON);
  }

  public IdentityProviderPendingLinkResponse retrievePendingLinkWithId(String pendingLinkId, String userId) {
    return execute("GET", "/api/identity-provider/link/pending/" + encode(pendingLinkId) + query("userId", userId), null, null, IdentityProviderPendingLinkResponse::fromJSON);
  }

  public LoginResponse identityProviderLoginWithId(String xFusionAuthTenantId, IdentityProviderLoginRequest request) {
    return execute("POST", "/api/identity-provider/login", request.toJSON(), xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public LookupResponse retrieveIdentityProviderLookup(String domain, String tenantId) {
    return execute("GET", "/api/identity-provider/lookup" + query("domain", domain, "tenantId", tenantId), null, null, LookupResponse::fromJSON);
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

  public IdentityProviderResponse createIdentityProviderWithId(String identityProviderId, IdentityProviderRequest request) {
    return execute("POST", "/api/identity-provider/" + encode(identityProviderId), request.toJSON(), null, IdentityProviderResponse::fromJSON);
  }

  public void deleteIdentityProviderWithId(String identityProviderId) {
    executeVoid("DELETE", "/api/identity-provider/" + encode(identityProviderId), null, null);
  }

  public IdentityProviderResponse patchIdentityProviderWithId(String identityProviderId, IdentityProviderRequest request) {
    return execute("PATCH", "/api/identity-provider/" + encode(identityProviderId), request.toJSON(), null, IdentityProviderResponse::fromJSON);
  }

  public IdentityProviderResponse retrieveIdentityProviderWithId(String identityProviderId) {
    return execute("GET", "/api/identity-provider/" + encode(identityProviderId), null, null, IdentityProviderResponse::fromJSON);
  }

  public IdentityProviderResponse updateIdentityProviderWithId(String identityProviderId, IdentityProviderRequest request) {
    return execute("PUT", "/api/identity-provider/" + encode(identityProviderId), request.toJSON(), null, IdentityProviderResponse::fromJSON);
  }

  public void verifyIdentityWithId(VerifyRequest request) {
    executeVoid("POST", "/api/identity/verify", request.toJSON(), null);
  }

  public VerifyCompleteResponse completeVerifyIdentityWithId(VerifyCompleteRequest request) {
    return execute("POST", "/api/identity/verify/complete", request.toJSON(), null, VerifyCompleteResponse::fromJSON);
  }

  public void sendVerifyIdentityWithId(VerifySendRequest request) {
    executeVoid("POST", "/api/identity/verify/send", request.toJSON(), null);
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

  public IPAccessControlListSearchResponse searchIPAccessControlListsWithId(IPAccessControlListSearchRequest request) {
    return execute("POST", "/api/ip-acl/search", request.toJSON(), null, IPAccessControlListSearchResponse::fromJSON);
  }

  public IPAccessControlListResponse createIPAccessControlListWithId(String accessControlListId, IPAccessControlListRequest request) {
    return execute("POST", "/api/ip-acl/" + encode(accessControlListId), request.toJSON(), null, IPAccessControlListResponse::fromJSON);
  }

  public IPAccessControlListResponse patchIPAccessControlListWithId(String accessControlListId, IPAccessControlListRequest request) {
    return execute("PATCH", "/api/ip-acl/" + encode(accessControlListId), request.toJSON(), null, IPAccessControlListResponse::fromJSON);
  }

  public IPAccessControlListResponse updateIPAccessControlListWithId(String accessControlListId, IPAccessControlListRequest request) {
    return execute("PUT", "/api/ip-acl/" + encode(accessControlListId), request.toJSON(), null, IPAccessControlListResponse::fromJSON);
  }

  public void deleteIPAccessControlListWithId(String ipAccessControlListId) {
    executeVoid("DELETE", "/api/ip-acl/" + encode(ipAccessControlListId), null, null);
  }

  public IPAccessControlListResponse retrieveIPAccessControlListWithId(String ipAccessControlListId) {
    return execute("GET", "/api/ip-acl/" + encode(ipAccessControlListId), null, null, IPAccessControlListResponse::fromJSON);
  }

  public IssueResponse issueJWTWithId(String applicationId, String refreshToken) {
    return execute("GET", "/api/jwt/issue" + query("applicationId", applicationId, "refreshToken", refreshToken), null, null, IssueResponse::fromJSON);
  }

  public PublicKeyResponse retrieveJwtPublicKey(String applicationId, String keyId) {
    return execute("GET", "/api/jwt/public-key" + query("applicationId", applicationId, "keyId", keyId), null, null, PublicKeyResponse::fromJSON);
  }

  public LoginResponse reconcileJWTWithId(IdentityProviderLoginRequest request) {
    return execute("POST", "/api/jwt/reconcile", request.toJSON(), null, LoginResponse::fromJSON);
  }

  public JWTRefreshResponse exchangeRefreshTokenForJWTWithId(RefreshRequest request) {
    return execute("POST", "/api/jwt/refresh", request.toJSON(), null, JWTRefreshResponse::fromJSON);
  }

  public RefreshTokenResponse retrieveRefreshTokensWithId(String userId) {
    return execute("GET", "/api/jwt/refresh" + query("userId", userId), null, null, RefreshTokenResponse::fromJSON);
  }

  public void deleteJwtRefresh(String userId, String applicationId, String token, RefreshTokenRevokeRequest request) {
    executeVoid("DELETE", "/api/jwt/refresh" + query("userId", userId, "applicationId", applicationId, "token", token), request.toJSON(), null);
  }

  public RefreshTokenResponse retrieveRefreshTokenByIdWithId(String tokenId) {
    return execute("GET", "/api/jwt/refresh/" + encode(tokenId), null, null, RefreshTokenResponse::fromJSON);
  }

  public void revokeRefreshTokenByIdWithId(String tokenId) {
    executeVoid("DELETE", "/api/jwt/refresh/" + encode(tokenId), null, null);
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

  public KeyResponse generateKeyWithId(String keyId, KeyRequest request) {
    return execute("POST", "/api/key/generate/" + encode(keyId), request.toJSON(), null, KeyResponse::fromJSON);
  }

  public KeyResponse importKey(KeyRequest request) {
    return execute("POST", "/api/key/import", request.toJSON(), null, KeyResponse::fromJSON);
  }

  public KeyResponse importKeyWithId(String keyId, KeyRequest request) {
    return execute("POST", "/api/key/import/" + encode(keyId), request.toJSON(), null, KeyResponse::fromJSON);
  }

  public KeySearchResponse searchKeysWithId(KeySearchRequest request) {
    return execute("POST", "/api/key/search", request.toJSON(), null, KeySearchResponse::fromJSON);
  }

  public void deleteKeyWithId(String keyId) {
    executeVoid("DELETE", "/api/key/" + encode(keyId), null, null);
  }

  public KeyResponse retrieveKeyWithId(String keyId) {
    return execute("GET", "/api/key/" + encode(keyId), null, null, KeyResponse::fromJSON);
  }

  public KeyResponse updateKeyWithId(String keyId, KeyRequest request) {
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

  public LambdaResponse createLambdaWithId(String lambdaId, LambdaRequest request) {
    return execute("POST", "/api/lambda/" + encode(lambdaId), request.toJSON(), null, LambdaResponse::fromJSON);
  }

  public void deleteLambdaWithId(String lambdaId) {
    executeVoid("DELETE", "/api/lambda/" + encode(lambdaId), null, null);
  }

  public LambdaResponse patchLambdaWithId(String lambdaId, LambdaRequest request) {
    return execute("PATCH", "/api/lambda/" + encode(lambdaId), request.toJSON(), null, LambdaResponse::fromJSON);
  }

  public LambdaResponse retrieveLambdaWithId(String lambdaId) {
    return execute("GET", "/api/lambda/" + encode(lambdaId), null, null, LambdaResponse::fromJSON);
  }

  public LambdaResponse updateLambdaWithId(String lambdaId, LambdaRequest request) {
    return execute("PUT", "/api/lambda/" + encode(lambdaId), request.toJSON(), null, LambdaResponse::fromJSON);
  }

  public LoginResponse loginWithId(String xFusionAuthTenantId, LoginRequest request) {
    return execute("POST", "/api/login", request.toJSON(), xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public LoginResponse loginPingWithRequestWithId(String xFusionAuthTenantId, LoginPingRequest request) {
    return execute("PUT", "/api/login", request.toJSON(), xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public LoginResponse loginPingWithId(String userId, String applicationId, String callerIPAddress, String xFusionAuthTenantId) {
    return execute("PUT", "/api/login/" + encode(userId) + "/" + encode(applicationId) + query("callerIPAddress", callerIPAddress), null, xFusionAuthTenantId, LoginResponse::fromJSON);
  }

  public void createLogout(String global, String refreshToken, LogoutRequest request) {
    executeVoid("POST", "/api/logout" + query("global", global, "refreshToken", refreshToken), request.toJSON(), null);
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

  public MessageTemplateResponse createMessageTemplateWithId(String messageTemplateId, MessageTemplateRequest request) {
    return execute("POST", "/api/message/template/" + encode(messageTemplateId), request.toJSON(), null, MessageTemplateResponse::fromJSON);
  }

  public void deleteMessageTemplateWithId(String messageTemplateId) {
    executeVoid("DELETE", "/api/message/template/" + encode(messageTemplateId), null, null);
  }

  public MessageTemplateResponse patchMessageTemplateWithId(String messageTemplateId, MessageTemplateRequest request) {
    return execute("PATCH", "/api/message/template/" + encode(messageTemplateId), request.toJSON(), null, MessageTemplateResponse::fromJSON);
  }

  public MessageTemplateResponse retrieveMessageTemplateWithId(String messageTemplateId) {
    return execute("GET", "/api/message/template/" + encode(messageTemplateId), null, null, MessageTemplateResponse::fromJSON);
  }

  public MessageTemplateResponse updateMessageTemplateWithId(String messageTemplateId, MessageTemplateRequest request) {
    return execute("PUT", "/api/message/template/" + encode(messageTemplateId), request.toJSON(), null, MessageTemplateResponse::fromJSON);
  }

  public MessengerResponse createMessenger(MessengerRequest request) {
    return execute("POST", "/api/messenger", request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public MessengerResponse createMessengerWithId(String messengerId, MessengerRequest request) {
    return execute("POST", "/api/messenger/" + encode(messengerId), request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public void deleteMessengerWithId(String messengerId) {
    executeVoid("DELETE", "/api/messenger/" + encode(messengerId), null, null);
  }

  public MessengerResponse patchMessengerWithId(String messengerId, MessengerRequest request) {
    return execute("PATCH", "/api/messenger/" + encode(messengerId), request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public MessengerResponse retrieveMessengerWithId(String messengerId) {
    return execute("GET", "/api/messenger/" + encode(messengerId), null, null, MessengerResponse::fromJSON);
  }

  public MessengerResponse updateMessengerWithId(String messengerId, MessengerRequest request) {
    return execute("PUT", "/api/messenger/" + encode(messengerId), request.toJSON(), null, MessengerResponse::fromJSON);
  }

  public LoginResponse passwordlessLoginWithId(PasswordlessLoginRequest request) {
    return execute("POST", "/api/passwordless/login", request.toJSON(), null, LoginResponse::fromJSON);
  }

  public void sendPasswordlessCodeWithId(PasswordlessSendRequest request) {
    executeVoid("POST", "/api/passwordless/send", request.toJSON(), null);
  }

  public PasswordlessStartResponse startPasswordlessLoginWithId(PasswordlessStartRequest request) {
    return execute("POST", "/api/passwordless/start", request.toJSON(), null, PasswordlessStartResponse::fromJSON);
  }

  public void activateReactorWithId(ReactorRequest request) {
    executeVoid("POST", "/api/reactor", request.toJSON(), null);
  }

  public ReactorMetricsResponse retrieveReactorMetricsWithId() {
    return execute("GET", "/api/reactor/metrics", null, null, ReactorMetricsResponse::fromJSON);
  }

  public DailyActiveUserReportResponse retrieveDailyActiveReportWithId(String applicationId, String start, String end) {
    return execute("GET", "/api/report/daily-active-user" + query("applicationId", applicationId, "start", start, "end", end), null, null, DailyActiveUserReportResponse::fromJSON);
  }

  public LoginReportResponse retrieveReportLogin(String applicationId, String loginId, String start, String end, String loginIdTypes, String userId) {
    return execute("GET", "/api/report/login" + query("applicationId", applicationId, "loginId", loginId, "start", start, "end", end, "loginIdTypes", loginIdTypes, "userId", userId), null, null, LoginReportResponse::fromJSON);
  }

  public MonthlyActiveUserReportResponse retrieveMonthlyActiveReportWithId(String applicationId, String start, String end) {
    return execute("GET", "/api/report/monthly-active-user" + query("applicationId", applicationId, "start", start, "end", end), null, null, MonthlyActiveUserReportResponse::fromJSON);
  }

  public RegistrationReportResponse retrieveRegistrationReportWithId(String applicationId, String start, String end) {
    return execute("GET", "/api/report/registration" + query("applicationId", applicationId, "start", start, "end", end), null, null, RegistrationReportResponse::fromJSON);
  }

  public TotalsReportResponse retrieveTotalReportWithExcludesWithId(String excludes) {
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

  public AuditLogResponse retrieveAuditLogWithId(String auditLogId) {
    return execute("GET", "/api/system/audit-log/" + encode(auditLogId), null, null, AuditLogResponse::fromJSON);
  }

  public EventLogSearchResponse searchEventLogsWithId(EventLogSearchRequest request) {
    return execute("POST", "/api/system/event-log/search", request.toJSON(), null, EventLogSearchResponse::fromJSON);
  }

  public EventLogResponse retrieveEventLogWithId(String eventLogId) {
    return execute("GET", "/api/system/event-log/" + encode(eventLogId), null, null, EventLogResponse::fromJSON);
  }

  public LoginRecordSearchResponse searchLoginRecordsWithId(LoginRecordSearchRequest request) {
    return execute("POST", "/api/system/login-record/search", request.toJSON(), null, LoginRecordSearchResponse::fromJSON);
  }

  public void reindexWithId(ReindexRequest request) {
    executeVoid("POST", "/api/system/reindex", request.toJSON(), null);
  }

  public VersionResponse retrieveVersionWithId() {
    return execute("GET", "/api/system/version", null, null, VersionResponse::fromJSON);
  }

  public WebhookAttemptLogResponse retrieveWebhookAttemptLogWithId(String webhookAttemptLogId) {
    return execute("GET", "/api/system/webhook-attempt-log/" + encode(webhookAttemptLogId), null, null, WebhookAttemptLogResponse::fromJSON);
  }

  public WebhookEventLogSearchResponse searchWebhookEventLogsWithId(WebhookEventLogSearchRequest request) {
    return execute("POST", "/api/system/webhook-event-log/search", request.toJSON(), null, WebhookEventLogSearchResponse::fromJSON);
  }

  public WebhookEventLogResponse retrieveWebhookEventLogWithId(String webhookEventLogId) {
    return execute("GET", "/api/system/webhook-event-log/" + encode(webhookEventLogId), null, null, WebhookEventLogResponse::fromJSON);
  }

  public TenantResponse createTenant(String xFusionAuthTenantId, TenantRequest request) {
    return execute("POST", "/api/tenant", request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
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

  public void deleteTenantManagerIdentityProviderTypeConfigurationWithId(String type) {
    executeVoid("DELETE", "/api/tenant-manager/identity-provider/" + encode(type), null, null);
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

  public PasswordValidationRulesResponse retrievePasswordValidationRulesWithTenantIdWithId(String tenantId) {
    return execute("GET", "/api/tenant/password-validation-rules/" + encode(tenantId), null, null, PasswordValidationRulesResponse::fromJSON);
  }

  public TenantSearchResponse searchTenantsWithId(TenantSearchRequest request) {
    return execute("POST", "/api/tenant/search", request.toJSON(), null, TenantSearchResponse::fromJSON);
  }

  public TenantResponse createTenantWithId(String tenantId, String xFusionAuthTenantId, TenantRequest request) {
    return execute("POST", "/api/tenant/" + encode(tenantId), request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public void deleteTenantWithId(String tenantId, String async, String xFusionAuthTenantId, TenantDeleteRequest request) {
    executeVoid("DELETE", "/api/tenant/" + encode(tenantId) + query("async", async), request.toJSON(), xFusionAuthTenantId);
  }

  public TenantResponse patchTenantWithId(String tenantId, String xFusionAuthTenantId, TenantRequest request) {
    return execute("PATCH", "/api/tenant/" + encode(tenantId), request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public TenantResponse retrieveTenantWithId(String tenantId, String xFusionAuthTenantId) {
    return execute("GET", "/api/tenant/" + encode(tenantId), null, xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public TenantResponse updateTenantWithId(String tenantId, String xFusionAuthTenantId, TenantRequest request) {
    return execute("PUT", "/api/tenant/" + encode(tenantId), request.toJSON(), xFusionAuthTenantId, TenantResponse::fromJSON);
  }

  public ThemeResponse createTheme(ThemeRequest request) {
    return execute("POST", "/api/theme", request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public ThemeSearchResponse searchThemesWithId(ThemeSearchRequest request) {
    return execute("POST", "/api/theme/search", request.toJSON(), null, ThemeSearchResponse::fromJSON);
  }

  public ThemeResponse createThemeWithId(String themeId, ThemeRequest request) {
    return execute("POST", "/api/theme/" + encode(themeId), request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public void deleteThemeWithId(String themeId) {
    executeVoid("DELETE", "/api/theme/" + encode(themeId), null, null);
  }

  public ThemeResponse patchThemeWithId(String themeId, ThemeRequest request) {
    return execute("PATCH", "/api/theme/" + encode(themeId), request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public ThemeResponse retrieveThemeWithId(String themeId) {
    return execute("GET", "/api/theme/" + encode(themeId), null, null, ThemeResponse::fromJSON);
  }

  public ThemeResponse updateThemeWithId(String themeId, ThemeRequest request) {
    return execute("PUT", "/api/theme/" + encode(themeId), request.toJSON(), null, ThemeResponse::fromJSON);
  }

  public LoginResponse twoFactorLoginWithId(TwoFactorLoginRequest request) {
    return execute("POST", "/api/two-factor/login", request.toJSON(), null, LoginResponse::fromJSON);
  }

  public SecretResponse generateTwoFactorSecretUsingJWTWithId() {
    return execute("GET", "/api/two-factor/secret", null, null, SecretResponse::fromJSON);
  }

  public void sendTwoFactorCodeForEnableDisableWithId(TwoFactorSendRequest request) {
    executeVoid("POST", "/api/two-factor/send", request.toJSON(), null);
  }

  public void sendTwoFactorCodeForLoginUsingMethodWithId(String twoFactorId, TwoFactorSendRequest request) {
    executeVoid("POST", "/api/two-factor/send/" + encode(twoFactorId), request.toJSON(), null);
  }

  public TwoFactorStartResponse startTwoFactorLoginWithId(TwoFactorStartRequest request) {
    return execute("POST", "/api/two-factor/start", request.toJSON(), null, TwoFactorStartResponse::fromJSON);
  }

  public TwoFactorStatusResponse retrieveTwoFactorStatusWithRequestWithId(TwoFactorStatusRequest request) {
    return execute("POST", "/api/two-factor/status", request.toJSON(), null, TwoFactorStatusResponse::fromJSON);
  }

  public TwoFactorStatusResponse retrieveTwoFactorStatusWithId(String twoFactorTrustId, String userId, String applicationId) {
    return execute("GET", "/api/two-factor/status/" + encode(twoFactorTrustId) + query("userId", userId, "applicationId", applicationId), null, null, TwoFactorStatusResponse::fromJSON);
  }

  public UserResponse createUser(String xFusionAuthTenantId, UserRequest request) {
    return execute("POST", "/api/user", request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse retrieveUser(String verificationId, String username, String loginId, String loginIdTypes, String email, String changePasswordId, String xFusionAuthTenantId) {
    return execute("GET", "/api/user" + query("verificationId", verificationId, "username", username, "loginId", loginId, "loginIdTypes", loginIdTypes, "email", email, "changePasswordId", changePasswordId), null, xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserActionResponse createUserAction(String xFusionAuthTenantId, UserActionRequest request) {
    return execute("POST", "/api/user-action", request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse retrieveUserAction(String inactive, String xFusionAuthTenantId) {
    return execute("GET", "/api/user-action" + query("inactive", inactive), null, xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionReasonResponse createUserActionReason(UserActionReasonRequest request) {
    return execute("POST", "/api/user-action-reason", request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse retrieveUserActionReason() {
    return execute("GET", "/api/user-action-reason", null, null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse createUserActionReasonWithId(String userActionReasonId, UserActionReasonRequest request) {
    return execute("POST", "/api/user-action-reason/" + encode(userActionReasonId), request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public void deleteUserActionReasonWithId(String userActionReasonId) {
    executeVoid("DELETE", "/api/user-action-reason/" + encode(userActionReasonId), null, null);
  }

  public UserActionReasonResponse patchUserActionReasonWithId(String userActionReasonId, UserActionReasonRequest request) {
    return execute("PATCH", "/api/user-action-reason/" + encode(userActionReasonId), request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse retrieveUserActionReasonWithId(String userActionReasonId) {
    return execute("GET", "/api/user-action-reason/" + encode(userActionReasonId), null, null, UserActionReasonResponse::fromJSON);
  }

  public UserActionReasonResponse updateUserActionReasonWithId(String userActionReasonId, UserActionReasonRequest request) {
    return execute("PUT", "/api/user-action-reason/" + encode(userActionReasonId), request.toJSON(), null, UserActionReasonResponse::fromJSON);
  }

  public UserActionResponse createUserActionWithId(String userActionId, String xFusionAuthTenantId, UserActionRequest request) {
    return execute("POST", "/api/user-action/" + encode(userActionId), request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public void deleteUserActionWithId(String userActionId, String hardDelete, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/user-action/" + encode(userActionId) + query("hardDelete", hardDelete), null, xFusionAuthTenantId);
  }

  public UserActionResponse patchUserActionWithId(String userActionId, String xFusionAuthTenantId, UserActionRequest request) {
    return execute("PATCH", "/api/user-action/" + encode(userActionId), request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse updateUserActionWithId(String userActionId, String reactivate, String xFusionAuthTenantId, UserActionRequest request) {
    return execute("PUT", "/api/user-action/" + encode(userActionId) + query("reactivate", reactivate), request.toJSON(), xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public UserActionResponse retrieveUserActionWithId(String userActionId, String xFusionAuthTenantId) {
    return execute("GET", "/api/user-action/" + encode(userActionId), null, xFusionAuthTenantId, UserActionResponse::fromJSON);
  }

  public ActionResponse actionUserWithId(ActionRequest request) {
    return execute("POST", "/api/user/action", request.toJSON(), null, ActionResponse::fromJSON);
  }

  public ActionResponse retrieveUserActioning(String userId, String active, String preventingLogin) {
    return execute("GET", "/api/user/action" + query("userId", userId, "active", active, "preventingLogin", preventingLogin), null, null, ActionResponse::fromJSON);
  }

  public ActionResponse cancelActionWithId(String actionId, ActionRequest request) {
    return execute("DELETE", "/api/user/action/" + encode(actionId), request.toJSON(), null, ActionResponse::fromJSON);
  }

  public ActionResponse modifyActionWithId(String actionId, ActionRequest request) {
    return execute("PUT", "/api/user/action/" + encode(actionId), request.toJSON(), null, ActionResponse::fromJSON);
  }

  public ActionResponse retrieveActionWithId(String actionId) {
    return execute("GET", "/api/user/action/" + encode(actionId), null, null, ActionResponse::fromJSON);
  }

  public UserDeleteResponse deleteUserBulk(String userIds, String dryRun, String hardDelete, UserDeleteRequest request) {
    return execute("DELETE", "/api/user/bulk" + query("userIds", userIds, "dryRun", dryRun, "hardDelete", hardDelete), request.toJSON(), null, UserDeleteResponse::fromJSON);
  }

  public ChangePasswordResponse createUserChangePassword(ChangePasswordRequest request) {
    return execute("POST", "/api/user/change-password", request.toJSON(), null, ChangePasswordResponse::fromJSON);
  }

  public void retrieveUserChangePassword(String loginId, String loginIdTypes, String ipAddress) {
    executeVoid("GET", "/api/user/change-password" + query("loginId", loginId, "loginIdTypes", loginIdTypes, "ipAddress", ipAddress), null, null);
  }

  public ChangePasswordResponse changePasswordWithId(String changePasswordId, ChangePasswordRequest request) {
    return execute("POST", "/api/user/change-password/" + encode(changePasswordId), request.toJSON(), null, ChangePasswordResponse::fromJSON);
  }

  public void retrieveUserChangePasswordWithId(String changePasswordId, String ipAddress) {
    executeVoid("GET", "/api/user/change-password/" + encode(changePasswordId) + query("ipAddress", ipAddress), null, null);
  }

  public UserCommentResponse commentOnUserWithId(String xFusionAuthTenantId, UserCommentRequest request) {
    return execute("POST", "/api/user/comment", request.toJSON(), xFusionAuthTenantId, UserCommentResponse::fromJSON);
  }

  public UserCommentSearchResponse searchUserCommentsWithId(UserCommentSearchRequest request) {
    return execute("POST", "/api/user/comment/search", request.toJSON(), null, UserCommentSearchResponse::fromJSON);
  }

  public UserCommentResponse retrieveUserCommentsWithId(String userId, String xFusionAuthTenantId) {
    return execute("GET", "/api/user/comment/" + encode(userId), null, xFusionAuthTenantId, UserCommentResponse::fromJSON);
  }

  public UserConsentResponse createUserConsent(UserConsentRequest request) {
    return execute("POST", "/api/user/consent", request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse retrieveUserConsentsWithId(String userId) {
    return execute("GET", "/api/user/consent" + query("userId", userId), null, null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse createUserConsentWithId(String userConsentId, UserConsentRequest request) {
    return execute("POST", "/api/user/consent/" + encode(userConsentId), request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse patchUserConsentWithId(String userConsentId, UserConsentRequest request) {
    return execute("PATCH", "/api/user/consent/" + encode(userConsentId), request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public UserConsentResponse retrieveUserConsentWithId(String userConsentId) {
    return execute("GET", "/api/user/consent/" + encode(userConsentId), null, null, UserConsentResponse::fromJSON);
  }

  public void revokeUserConsentWithId(String userConsentId) {
    executeVoid("DELETE", "/api/user/consent/" + encode(userConsentId), null, null);
  }

  public UserConsentResponse updateUserConsentWithId(String userConsentId, UserConsentRequest request) {
    return execute("PUT", "/api/user/consent/" + encode(userConsentId), request.toJSON(), null, UserConsentResponse::fromJSON);
  }

  public FamilyResponse createFamily(String xFusionAuthTenantId, FamilyRequest request) {
    return execute("POST", "/api/user/family", request.toJSON(), xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse retrieveFamiliesWithId(String userId, String xFusionAuthTenantId) {
    return execute("GET", "/api/user/family" + query("userId", userId), null, xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public PendingResponse retrievePendingChildrenWithId(String parentEmail) {
    return execute("GET", "/api/user/family/pending" + query("parentEmail", parentEmail), null, null, PendingResponse::fromJSON);
  }

  public void sendFamilyRequestEmailWithId(FamilyEmailRequest request) {
    executeVoid("POST", "/api/user/family/request", request.toJSON(), null);
  }

  public FamilyResponse updateUserFamilyWithId(String familyId, String xFusionAuthTenantId, FamilyRequest request) {
    return execute("PUT", "/api/user/family/" + encode(familyId), request.toJSON(), xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse createFamilyWithId(String familyId, String xFusionAuthTenantId, FamilyRequest request) {
    return execute("POST", "/api/user/family/" + encode(familyId), request.toJSON(), xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public FamilyResponse retrieveFamilyMembersByFamilyIdWithId(String familyId, String xFusionAuthTenantId) {
    return execute("GET", "/api/user/family/" + encode(familyId), null, xFusionAuthTenantId, FamilyResponse::fromJSON);
  }

  public void removeUserFromFamilyWithId(String familyId, String userId, String xFusionAuthTenantId) {
    executeVoid("DELETE", "/api/user/family/" + encode(familyId) + "/" + encode(userId), null, xFusionAuthTenantId);
  }

  public ForgotPasswordResponse forgotPasswordWithId(ForgotPasswordRequest request) {
    return execute("POST", "/api/user/forgot-password", request.toJSON(), null, ForgotPasswordResponse::fromJSON);
  }

  public void importUsersWithId(ImportRequest request) {
    executeVoid("POST", "/api/user/import", request.toJSON(), null);
  }

  public RecentLoginResponse retrieveUserRecentLogin(String userId, String offset, String limit) {
    return execute("GET", "/api/user/recent-login" + query("userId", userId, "offset", offset, "limit", limit), null, null, RecentLoginResponse::fromJSON);
  }

  public void importRefreshTokensWithId(RefreshTokenImportRequest request) {
    executeVoid("POST", "/api/user/refresh-token/import", request.toJSON(), null);
  }

  public RegistrationResponse register(String xFusionAuthTenantId, RegistrationRequest request) {
    return execute("POST", "/api/user/registration", request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse patchRegistrationWithId(String userId, String xFusionAuthTenantId, RegistrationRequest request) {
    return execute("PATCH", "/api/user/registration/" + encode(userId), request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse registerWithId(String userId, String xFusionAuthTenantId, RegistrationRequest request) {
    return execute("POST", "/api/user/registration/" + encode(userId), request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public RegistrationResponse updateRegistrationWithId(String userId, String xFusionAuthTenantId, RegistrationRequest request) {
    return execute("PUT", "/api/user/registration/" + encode(userId), request.toJSON(), xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public void deleteUserRegistrationWithId(String userId, String applicationId, String xFusionAuthTenantId, RegistrationDeleteRequest request) {
    executeVoid("DELETE", "/api/user/registration/" + encode(userId) + "/" + encode(applicationId), request.toJSON(), xFusionAuthTenantId);
  }

  public RegistrationResponse retrieveRegistrationWithId(String userId, String applicationId, String xFusionAuthTenantId) {
    return execute("GET", "/api/user/registration/" + encode(userId) + "/" + encode(applicationId), null, xFusionAuthTenantId, RegistrationResponse::fromJSON);
  }

  public SearchResponse searchUsersByIdsWithId(String ids) {
    return execute("GET", "/api/user/search" + query("ids", ids), null, null, SearchResponse::fromJSON);
  }

  public SearchResponse searchUsersByQueryWithId(SearchRequest request) {
    return execute("POST", "/api/user/search", request.toJSON(), null, SearchResponse::fromJSON);
  }

  public TwoFactorRecoveryCodeResponse generateTwoFactorRecoveryCodesWithId(String userId) {
    return execute("POST", "/api/user/two-factor/recovery-code/" + encode(userId), null, null, TwoFactorRecoveryCodeResponse::fromJSON);
  }

  public TwoFactorRecoveryCodeResponse retrieveTwoFactorRecoveryCodesWithId(String userId) {
    return execute("GET", "/api/user/two-factor/recovery-code/" + encode(userId), null, null, TwoFactorRecoveryCodeResponse::fromJSON);
  }

  public void deleteUserTwoFactorWithId(String userId, String methodId, String code, TwoFactorDisableRequest request) {
    executeVoid("DELETE", "/api/user/two-factor/" + encode(userId) + query("methodId", methodId, "code", code), request.toJSON(), null);
  }

  public TwoFactorResponse enableTwoFactorWithId(String userId, TwoFactorRequest request) {
    return execute("POST", "/api/user/two-factor/" + encode(userId), request.toJSON(), null, TwoFactorResponse::fromJSON);
  }

  public VerifyEmailResponse updateUserVerifyEmail(String applicationId, String email, String sendVerifyEmail) {
    return execute("PUT", "/api/user/verify-email" + query("applicationId", applicationId, "email", email, "sendVerifyEmail", sendVerifyEmail), null, null, VerifyEmailResponse::fromJSON);
  }

  public void createUserVerifyEmail(VerifyEmailRequest request) {
    executeVoid("POST", "/api/user/verify-email", request.toJSON(), null);
  }

  public VerifyRegistrationResponse updateUserVerifyRegistration(String email, String applicationId, String sendVerifyPasswordEmail) {
    return execute("PUT", "/api/user/verify-registration" + query("email", email, "applicationId", applicationId, "sendVerifyPasswordEmail", sendVerifyPasswordEmail), null, null, VerifyRegistrationResponse::fromJSON);
  }

  public void verifyUserRegistrationWithId(VerifyRegistrationRequest request) {
    executeVoid("POST", "/api/user/verify-registration", request.toJSON(), null);
  }

  public UserResponse createUserWithId(String userId, String xFusionAuthTenantId, UserRequest request) {
    return execute("POST", "/api/user/" + encode(userId), request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public void deleteUserWithId(String userId, String hardDelete, String xFusionAuthTenantId, UserDeleteSingleRequest request) {
    executeVoid("DELETE", "/api/user/" + encode(userId) + query("hardDelete", hardDelete), request.toJSON(), xFusionAuthTenantId);
  }

  public UserResponse patchUserWithId(String userId, String xFusionAuthTenantId, UserRequest request) {
    return execute("PATCH", "/api/user/" + encode(userId), request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse updateUserWithId(String userId, String reactivate, String xFusionAuthTenantId, UserRequest request) {
    return execute("PUT", "/api/user/" + encode(userId) + query("reactivate", reactivate), request.toJSON(), xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public UserResponse retrieveUserWithId(String userId, String xFusionAuthTenantId) {
    return execute("GET", "/api/user/" + encode(userId), null, xFusionAuthTenantId, UserResponse::fromJSON);
  }

  public void deleteWebAuthnCredentialsForUserWithId(String userId) {
    executeVoid("DELETE", "/api/webauthn" + query("userId", userId), null, null);
  }

  public WebAuthnCredentialResponse retrieveWebAuthnCredentialsForUserWithId(String userId) {
    return execute("GET", "/api/webauthn" + query("userId", userId), null, null, WebAuthnCredentialResponse::fromJSON);
  }

  public WebAuthnAssertResponse completeWebAuthnAssertionWithId(WebAuthnLoginRequest request) {
    return execute("POST", "/api/webauthn/assert", request.toJSON(), null, WebAuthnAssertResponse::fromJSON);
  }

  public void importWebAuthnCredentialWithId(WebAuthnCredentialImportRequest request) {
    executeVoid("POST", "/api/webauthn/import", request.toJSON(), null);
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

  public void deleteWebAuthnCredentialWithId(String id) {
    executeVoid("DELETE", "/api/webauthn/" + encode(id), null, null);
  }

  public WebAuthnCredentialResponse retrieveWebAuthnCredentialWithId(String id) {
    return execute("GET", "/api/webauthn/" + encode(id), null, null, WebAuthnCredentialResponse::fromJSON);
  }

  public WebhookResponse createWebhook(WebhookRequest request) {
    return execute("POST", "/api/webhook", request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public WebhookResponse retrieveWebhook() {
    return execute("GET", "/api/webhook", null, null, WebhookResponse::fromJSON);
  }

  public WebhookSearchResponse searchWebhooksWithId(WebhookSearchRequest request) {
    return execute("POST", "/api/webhook/search", request.toJSON(), null, WebhookSearchResponse::fromJSON);
  }

  public WebhookResponse createWebhookWithId(String webhookId, WebhookRequest request) {
    return execute("POST", "/api/webhook/" + encode(webhookId), request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public void deleteWebhookWithId(String webhookId) {
    executeVoid("DELETE", "/api/webhook/" + encode(webhookId), null, null);
  }

  public WebhookResponse patchWebhookWithId(String webhookId, WebhookRequest request) {
    return execute("PATCH", "/api/webhook/" + encode(webhookId), request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public WebhookResponse retrieveWebhookWithId(String webhookId) {
    return execute("GET", "/api/webhook/" + encode(webhookId), null, null, WebhookResponse::fromJSON);
  }

  public WebhookResponse updateWebhookWithId(String webhookId, WebhookRequest request) {
    return execute("PUT", "/api/webhook/" + encode(webhookId), request.toJSON(), null, WebhookResponse::fromJSON);
  }

  public DeviceApprovalResponse createDeviceApprove() {
    return execute("POST", "/oauth2/device/approve", null, null, DeviceApprovalResponse::fromJSON);
  }

  public void retrieveDeviceUserCode() {
    executeVoid("GET", "/oauth2/device/user-code", null, null);
  }

  public void createDeviceUserCode() {
    executeVoid("POST", "/oauth2/device/user-code", null, null);
  }

  public void retrieveDeviceValidate(String user_code, String client_id) {
    executeVoid("GET", "/oauth2/device/validate" + query("user_code", user_code, "client_id", client_id), null, null);
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

  private <T> T execute(String method, String path, String body, String tenantId, Function<String, T> parser) {
    HttpResponse<String> response = send(method, path, body, tenantId);
    if (response.statusCode() / 100 == 2) {
      String b = response.body();
      return (b == null || b.isEmpty()) ? null : parser.apply(b);
    }
    throw error(response);
  }

  private void executeVoid(String method, String path, String body, String tenantId) {
    HttpResponse<String> response = send(method, path, body, tenantId);
    if (response.statusCode() / 100 != 2) {
      throw error(response);
    }
  }

  private HttpResponse<String> send(String method, String path, String body, String tenantId) {
    try {
      HttpRequest.Builder builder = HttpRequest.newBuilder()
          .uri(URI.create(baseURL + path))
          .timeout(timeout)
          .header("Authorization", apiKey);
      if (tenantId != null) {
        builder.header("X-FusionAuth-TenantId", tenantId);
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

  private static String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8);
  }

  private static String query(String... nameValues) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i + 1 < nameValues.length; i += 2) {
      String value = nameValues[i + 1];
      if (value == null) {
        continue;
      }
      sb.append(sb.isEmpty() ? "?" : "&").append(nameValues[i]).append("=").append(encode(value));
    }
    return sb.toString();
  }
}
