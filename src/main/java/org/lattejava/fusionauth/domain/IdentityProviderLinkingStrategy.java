/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum IdentityProviderLinkingStrategy {
  CreatePendingLink,
  Disabled,
  LinkAnonymously,
  LinkByEmail,
  LinkByEmailForExistingUser,
  LinkByUsername,
  LinkByUsernameForExistingUser,
  Unsupported
}
