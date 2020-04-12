/** Copyright 2020 All Rights Reserved */
package com.blurb.api;

import java.util.List;

/**
 * Blurb User
 *
 * @author djhel
 */
public class BlurbUser {

  private String username;
  private String password;
  private String email;
  private String countryCode;
  private List<String> follows;
  
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public List<String> getFollows() {
    return follows;
  }

  public void setFollows(List<String> follows) {
    this.follows = follows;
  }
}
