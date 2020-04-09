/** Copyright 2020 All Rights Reserved */
package com.blurb.service;

import com.blurb.api.BlurbUser;
import com.blurb.exception.BlurbUserException;

/**
 * User Service
 *
 * @author djhel
 */
public interface BlurbUserService {

  public void createBlurbUser(BlurbUser user);

  public BlurbUser getBlurbUser(String username) throws BlurbUserException;
}
