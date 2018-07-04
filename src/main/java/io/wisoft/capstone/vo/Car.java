package io.wisoft.capstone.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Car {
  private String customer_id;
  private String kind;
  private String license_plate;
}
