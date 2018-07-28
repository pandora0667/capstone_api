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

  public Regular() {

  }

  public Regular(String serial, String accelerationX, String accelerationY, String accelerationZ, String inclination) {
    this.serial = serial;
    this.accelerationX = accelerationX;
    this.accelerationY = accelerationY;
    this.accelerationZ = accelerationZ;
    this.inclination = inclination;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public String getAccelerationX() {
    return accelerationX;
  }

  public void setAccelerationX(String accelerationX) {
    this.accelerationX = accelerationX;
  }

  public String getAccelerationY() {
    return accelerationY;
  }

  public void setAccelerationY(String accelerationY) {
    this.accelerationY = accelerationY;
  }

  public String getAccelerationZ() {
    return accelerationZ;
  }

  public void setAccelerationZ(String accelerationZ) {
    this.accelerationZ = accelerationZ;
  }

  public String getInclination() {
    return inclination;
  }

  public void setInclination(String inclination) {
    this.inclination = inclination;
  }
}
