/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum BreachedPasswordStatus {
  None,
  ExactMatch,
  SubAddressMatch,
  PasswordOnly,
  CommonPassword
}
