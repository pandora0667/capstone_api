package io.wisoft.capstone.vo;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@ToString


public class Regular {
  private String serial;
  private String accelerationX;
  private String accelerationY;
  private String accelerationZ;
  private String inclination;
  private String gyro;
  private String speed;

  public Regular() {

  }

  public Regular(final String serial, final String accelerationX, final String accelerationY,
                 final String accelerationZ, final String inclination, final String gyro, final String speed) {
    this.serial = serial;
    this.accelerationX = accelerationX;
    this.accelerationY = accelerationY;
    this.accelerationZ = accelerationZ;
    this.inclination = inclination;
    this.gyro = gyro;
    this.speed = speed;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(final String serial) {
    this.serial = serial;
  }

  public String getAccelerationX() {
    return accelerationX;
  }

  public void setAccelerationX(final String accelerationX) {
    this.accelerationX = accelerationX;
  }

  public String getAccelerationY() {
    return accelerationY;
  }

  public void setAccelerationY(final String accelerationY) {
    this.accelerationY = accelerationY;
  }

  public String getAccelerationZ() {
    return accelerationZ;
  }

  public void setAccelerationZ(final String accelerationZ) {
    this.accelerationZ = accelerationZ;
  }

  public String getInclination() {
    return inclination;
  }

  public void setInclination(final String inclination) {
    this.inclination = inclination;
  }

  public String getGyro() {
    return gyro;
  }

  public void setGyro(String gyro) {
    this.gyro = gyro;
  }

  public String getSpeed() {
    return speed;
  }

  public void setSpeed(String speed) {
    this.speed = speed;
  }
}
