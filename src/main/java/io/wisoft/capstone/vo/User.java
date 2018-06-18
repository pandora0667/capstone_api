package io.wisoft.capstone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public class User {
  private String id;
  private String username;
  private String email;
  private String phone;
  private String password;

  public User () {}

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getPhone() {
    return phone;
  }

  public String getUsername() {
    return username;
  }

  public static class Builder {
    private final String id;
    private String username;
    private String email;
    private String phone;
    private String password;

    public Builder(final String id) {
      this.id = id;
      this.username = null;
      this.email = null;
      this.phone = null;
      this.password = null;
    }

    public Builder username(final String username) {
      this.username = username;
      return this;
    }

    public Builder email(final String email) {
      this.email = email;
      return this;
    }

    public Builder phone(final String phone) {
      this.phone = phone;
      return this;
    }

    public Builder password(final String password) {
      this.password = password;
      return this;
    }


    public User build() {
      return new User(this);
    }
  }

  public User(Builder builder) {
    this.id = builder.id;
    this.username = builder.username;
    this.email = builder.email;
    this.phone = builder.phone;
    this.password = builder.password;
  }
}
