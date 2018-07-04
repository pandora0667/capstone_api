package io.wisoft.capstone.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
  private String customer_id;
  private String username;
  private String email;
  private String phone;
  private String password;
}