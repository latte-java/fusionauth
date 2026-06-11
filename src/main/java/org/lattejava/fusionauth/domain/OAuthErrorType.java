/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum OAuthErrorType {
  invalid_request,
  invalid_client,
  invalid_grant,
  invalid_token,
  consent_required,
  interaction_required,
  login_required,
  unauthorized_client,
  invalid_scope,
  server_error,
  unsupported_grant_type,
  unsupported_response_type,
  access_denied,
  change_password_required,
  not_licensed,
  two_factor_required,
  authorization_pending,
  expired_token,
  unsupported_token_type,
  invalid_dpop_proof,
  invalid_target
}
