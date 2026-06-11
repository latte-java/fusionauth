/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum UserState {
  Authenticated,
  AuthenticatedNotRegistered,
  AuthenticatedNotVerified,
  AuthenticatedRegistrationNotVerified
}
