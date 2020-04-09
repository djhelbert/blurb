/** Copyright 2020 All Rights Reserved */
package com.blurb.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration
 *
 * @author djhel
 */
@Configuration
public class SpringConfig {

  @Bean
  public AerospikeClient aeorspikeClient() {
    final ClientPolicy policy = new ClientPolicy();
    policy.timeout = 500;

    final AerospikeClient client = new AerospikeClient(policy, "localhost", 3000);
    return client;
  }
}
