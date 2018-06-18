package io.wisoft.capstone.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class User {
  private String id;
  private String username;
  private String email;
  private String phone;
  private String password;
}