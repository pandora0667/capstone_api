package io.wisoft.capstone.vo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Sensor {
  private double inclination;
  private double latitude;
  private double longitude;
  private double accelerationX;
  private double accelerationY;
  private double accelerationZ;
  private int sTime;
  private int statusCode;
  private Date accidentTime;
}
