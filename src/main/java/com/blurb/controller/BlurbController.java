/** Copyright 2020 All Rights Reserved */
package com.blurb.controller;

import com.blurb.api.BlurbUser;
import com.blurb.exception.BlurbUserExistsException;
import com.blurb.exception.BlurbUserNotFoundException;
import com.blurb.service.BlurbUserService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Blurb Controller
 *
 * @author djhel
 */
@RestController
public class BlurbController {

  private BlurbUserService userService;

  @Autowired
  public BlurbController(BlurbUserService userService) {
    this.userService = userService;
  }
  
  @RequestMapping("/ping")
  public String index() {
    return "pong";
  }

  @GetMapping("/user")
  public BlurbUser getUser(@RequestParam(value = "username") String username) throws BlurbUserNotFoundException {
    return userService.getBlurbUser(username);
  }

  @PostMapping("/user")
  public ResponseEntity<Object> createStudent(@RequestBody BlurbUser user) throws BlurbUserExistsException {
    userService.createBlurbUser(user);

    final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUsername()).toUri();

    return ResponseEntity.created(location).build();
  }
}
