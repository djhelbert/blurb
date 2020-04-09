/** Copyright 2020 All Rights Reserved */
package com.blurb.service;

import com.blurb.api.BlurbUser;
import com.blurb.exception.BlurbUserExistsException;
import com.blurb.exception.BlurbUserNotFoundException;

/**
 * User Service
 *
 * @author djhel
 */
public interface BlurbUserService {

  /**
   * Create User
   *
   * @param user
   * @throws BlurbUserExistsException
   */
  public void createBlurbUser(BlurbUser user) throws BlurbUserExistsException;

  /**
   * Get User
   *
   * @param username
   * @return
   * @throws BlurbUserNotFoundException
   */
  public BlurbUser getBlurbUser(String username) throws BlurbUserNotFoundException;
}
