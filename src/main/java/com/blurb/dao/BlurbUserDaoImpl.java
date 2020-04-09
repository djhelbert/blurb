/** Copyright 2020 All Rights Reserved */
package com.blurb.dao;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.blurb.BlurbConstants;
import com.blurb.api.BlurbUser;
import com.blurb.exception.BlurbUserException;
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
  public void createBlurbUser(BlurbUser user) {
    final WritePolicy policy = new WritePolicy();
    policy.recordExistsAction = RecordExistsAction.UPDATE;

    final Key key = new Key(BlurbConstants.NAMESPACE, BlurbConstants.USERS, user.getUsername());
    final Bin bin1 = new Bin("username", user.getUsername());
    final Bin bin2 = new Bin("password", user.getPassword());
    final Bin bin3 = new Bin("email", user.getEmail());
    final Bin bin4 = new Bin("countrycode", user.getCountryCode());

    client.put(policy, key, bin1, bin2, bin3, bin4);
  }

  @Override
  public BlurbUser getBlurbUser(String username) throws BlurbUserException {
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
      throw new BlurbUserException(username);
    }
  }

}
