/** Copyright 2020 All Rights Reserved */
package com.blurb.dao;

import com.blurb.api.BlurbUser;
import com.blurb.exception.BlurbUserException;

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
  public void createBlurbUser(BlurbUser user);

  /**
   * Get USer
   * 
   * @param username Username
   * @return Blurb User
   * @throws BlurbUserException 
   */
  public BlurbUser getBlurbUser(String username) throws BlurbUserException;
}
