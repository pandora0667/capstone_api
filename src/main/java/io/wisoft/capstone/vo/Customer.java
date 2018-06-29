package io.wisoft.capstone.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
  private String id;
  private String name;
  private String email;
  private String phone;
  private String password;
}