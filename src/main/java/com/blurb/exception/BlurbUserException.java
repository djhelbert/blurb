/** Copyright 2020 All Rights Reserved */
package com.blurb.exception;

/**
 * Blurb User Exception
 * @author djhel
 */
public class BlurbUserException extends Exception {
  public BlurbUserException(String username) {
    super (username + " Not Found");
  }
}
