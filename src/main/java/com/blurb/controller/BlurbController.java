/** Copyright 2020 All Rights Reserved */
package com.blurb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author djhel
 */
@RestController
public class BlurbController {

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }
}
