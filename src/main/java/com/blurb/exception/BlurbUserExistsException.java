/** Copyright 2020 All Rights Reserved */
package com.blurb.exception;

/**
 * Blurb User Exists Exception
 *
 * @author djhel
 */
public class BlurbUserExistsException extends Exception {

  public BlurbUserExistsException(String username) {
    super(username + " Already Exists");
  }
}
