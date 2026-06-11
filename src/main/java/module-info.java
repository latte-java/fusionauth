/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
module org.lattejava.fusionauth {
  requires java.net.http;
  requires static org.lattejava.json;

  exports org.lattejava.fusionauth;
  exports org.lattejava.fusionauth.domain;
  exports org.lattejava.fusionauth.domain.internal;
}
