/** Copyright 2020 All Rights Reserved */
package com.blurb.config;

import com.aerospike.client.AerospikeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration
 *
 * @author djhel
 */
@Configuration
public class SpringConfig {

  /**
   * Get Aerospike Client
   * 
   * @return Aerospike Client
   */
  @Bean
  public AerospikeClient aeorspikeClient() {
    return new AerospikeClient("127.0.0.1", 3000);
  }
}
