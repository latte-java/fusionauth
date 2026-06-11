/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth.domain;

public enum IdentityVerifiedReason {
  Skipped,
  Trusted,
  Unverifiable,
  Implicit,
  Pending,
  Completed,
  Disabled,
  Administrative,
  Import
}
