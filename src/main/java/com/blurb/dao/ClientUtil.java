/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blurb.dao;

import com.aerospike.client.policy.WritePolicy;

/**
 * Client Utility
 *
 * @author djhel
 */
public class ClientUtil {

  private ClientUtil() {
  }

  public static final WritePolicy getWritePolicy() {
    final WritePolicy policy = new WritePolicy();
    policy.setTimeout(100);
    return policy;
  }
}
