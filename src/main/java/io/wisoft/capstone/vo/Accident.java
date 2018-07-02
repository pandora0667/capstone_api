package io.wisoft.capstone.vo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Accident {
  private int status;
  private String serial;
  private String accelerationX;
  private String accelerationY;
  private String accelerationZ;
  private String inclination;
  private String latitude;
  private String longitude;
}
