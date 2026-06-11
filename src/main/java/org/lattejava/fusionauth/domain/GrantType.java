/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum GrantType {
  authorization_code,
  implicit,
  password,
  client_credentials,
  refresh_token,
  unknown,
  device_code
}
