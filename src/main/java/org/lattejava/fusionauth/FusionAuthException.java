/*
 * Copyright (c) 2026 The Latte Project
 * SPDX-License-Identifier: MIT
 */
package org.lattejava.fusionauth;

import org.lattejava.fusionauth.domain.Errors;

/**
 * Thrown when a FusionAuth API call returns a non-2xx status or the transport fails. {@link #status} is
 * the HTTP status (0 for a transport failure), {@link #errors} is the parsed error body (null when the
 * body was empty or not parseable as Errors), and {@link #rawBody} is the unparsed response body.
 */
public class FusionAuthException extends RuntimeException {
  public final Errors errors;
  public final int status;
  public final String rawBody;

  public FusionAuthException(int status, Errors errors, String rawBody, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
    this.errors = errors;
    this.rawBody = rawBody;
  }
}
