/** Copyright 2020 All Rights Reserved */
package com.blurb.dao;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.blurb.BlurbConstants;
import com.blurb.api.BlurbUser;
import com.blurb.exception.BlurbUserExistsException;
import com.blurb.exception.BlurbUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Blurb User DAO Implementation
 *
 * @author djhel
 */
public class BlurbUserDaoImpl implements BlurbUserDao {

  private AerospikeClient client;

  @Autowired
  public BlurbUserDaoImpl(AerospikeClient client) {
    this.client = client;
  }

  @Override
  public void createBlurbUser(BlurbUser user) throws BlurbUserExistsException {
    final WritePolicy policy = new WritePolicy();
    policy.recordExistsAction = RecordExistsAction.CREATE_ONLY;

    final Key key = new Key(BlurbConstants.NAMESPACE, BlurbConstants.USERS, user.getUsername());
    final Bin bin1 = new Bin("username", user.getUsername());
    final Bin bin2 = new Bin("password", user.getPassword());
    final Bin bin3 = new Bin("email", user.getEmail());
    final Bin bin4 = new Bin("countrycode", user.getCountryCode());

    try {
      client.put(policy, key, bin1, bin2, bin3, bin4);
    } catch (AerospikeException err) {
      throw new BlurbUserExistsException(user.getUsername());
    }
  }

  @Override
  public BlurbUser getBlurbUser(String username) throws BlurbUserNotFoundException {
    final Key key = new Key(BlurbConstants.NAMESPACE, BlurbConstants.USERS, username);
    final Record userRecord = client.get(null, key);

    if (userRecord != null) {
      final BlurbUser user = new BlurbUser();
      user.setUsername(userRecord.getString("username"));
      user.setPassword(null);
      user.setEmail(userRecord.getString("email"));
      user.setCountryCode(userRecord.getString("countrycode"));

      return user;
    } else {
      throw new BlurbUserNotFoundException(username);
    }
  }

}
