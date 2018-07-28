package io.wisoft.capstone.vo;

import lombok.*;


@ToString


public class Customer {
  private String customer_id;
  private String username;
  private String email;
  private String phone;
  private String password;

  public Customer() {

  }

  public Customer(String customer_id, String username, String email, String phone, String password) {
    this.customer_id = customer_id;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }

  public String getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(String customer_id) {
    this.customer_id = customer_id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}