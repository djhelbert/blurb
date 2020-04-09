/** Copyright 2020 All Rights Reserved */
package com.blurb.dao;

import com.blurb.api.BlurbUser;
import com.blurb.exception.BlurbUserExistsException;
import com.blurb.exception.BlurbUserNotFoundException;

/**
 * Blurb User DAO
 *
 * @author djhel
 */
public interface BlurbUserDao {

  /**
   * Create User
   * 
   * @param user 
   */
  public void createBlurbUser(BlurbUser user) throws BlurbUserExistsException;

  /**
   * Get User
   * 
   * @param username Username
   * @return Blurb User
   * @throws BlurbUserNotFoundException 
   */
  public BlurbUser getBlurbUser(String username) throws BlurbUserNotFoundException;
}
