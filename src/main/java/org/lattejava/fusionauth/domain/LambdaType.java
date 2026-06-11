/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum LambdaType {
  JWTPopulate,
  OpenIDReconcile,
  SAMLv2Reconcile,
  SAMLv2Populate,
  AppleReconcile,
  ExternalJWTReconcile,
  FacebookReconcile,
  GoogleReconcile,
  HYPRReconcile,
  TwitterReconcile,
  LDAPConnectorReconcile,
  LinkedInReconcile,
  EpicGamesReconcile,
  NintendoReconcile,
  SonyPSNReconcile,
  SteamReconcile,
  TwitchReconcile,
  XboxReconcile,
  ClientCredentialsJWTPopulate,
  SCIMServerGroupRequestConverter,
  SCIMServerGroupResponseConverter,
  SCIMServerUserRequestConverter,
  SCIMServerUserResponseConverter,
  SelfServiceRegistrationValidation,
  UserInfoPopulate,
  LoginValidation,
  MFARequirement
}
