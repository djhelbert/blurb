/** Copyright 2020 All Rights Reserved */
package com.blurb.exception;

/**
 * Blurb User Exception
 *
 * @author djhel
 */
public class BlurbUserNotFoundException extends Exception {

  public BlurbUserNotFoundException(String username) {
    super(username + " Not Found");
  }
}
