package io.wisoft.capstone.vo;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@ToString

public class Accident {
  private int status;
  private String serial;
  private String accelerationX;
  private String accelerationY;
  private String accelerationZ;
  private String inclination;
  private String latitude;
  private String longitude;

  public Accident() {

  }

  public Accident(int status, String serial, String accelerationX, String accelerationY, String accelerationZ, String inclination, String latitude, String longitude) {
    this.status = status;
    this.serial = serial;
    this.accelerationX = accelerationX;
    this.accelerationY = accelerationY;
    this.accelerationZ = accelerationZ;
    this.inclination = inclination;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
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

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
}
