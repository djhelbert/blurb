/** Copyright 2020 All Rights Reserved */
package com.blurb.service;

import com.blurb.api.BlurbUser;
import com.blurb.dao.BlurbUserDao;
import com.blurb.exception.BlurbUserExistsException;
import com.blurb.exception.BlurbUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Blurb User Service Implementation
 *
 * @author djhel
 */
public class BlurbUserServiceImpl implements BlurbUserService {

  private BlurbUserDao dao;

  @Autowired
  public BlurbUserServiceImpl(BlurbUserDao dao) {
    this.dao = dao;
  }

  @Override
  public void createBlurbUser(BlurbUser user) throws BlurbUserExistsException {
    dao.createBlurbUser(user);
  }

  @Override
  public BlurbUser getBlurbUser(String username) throws BlurbUserNotFoundException {
    return dao.getBlurbUser(username);
  }
}
