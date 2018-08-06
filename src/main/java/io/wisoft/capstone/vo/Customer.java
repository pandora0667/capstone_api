package io.wisoft.capstone.vo;


import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@ToString

public class Customer {
  private String customerId;
  private String username;
  private String email;
  private String phone;
  private String password;

  public Customer() {
  }

  public Customer(final String customerId, final String username, final String email,
                  final String phone, final String password) {
    this.customerId = customerId;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(final String customerId) {
    this.customerId = customerId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(final String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }
}