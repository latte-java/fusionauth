/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
module org.lattejava.fusionauth.tests {
  requires java.net.http;
  requires org.lattejava.fusionauth;
  requires org.testng;

  opens org.lattejava.fusionauth.domain.tests to org.testng;
  opens org.lattejava.fusionauth.tests to org.testng;
}
