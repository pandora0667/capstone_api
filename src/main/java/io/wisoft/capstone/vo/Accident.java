package io.wisoft.capstone.vo;

import lombok.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@ToString
// TODO status enum 으로 자료형 변경
public class Accident {
  private int status;
  private String serial;
  private String accelerationX;
  private String accelerationY;
  private String accelerationZ;
  private String inclination;
  private String latitude;
  private String longitude;
  private String temperature;
  private String gyro;

  public Accident() {

  }

  public Accident(final int status, final String serial, final String accelerationX, final String accelerationY,
                  final String accelerationZ, final String inclination, final String latitude, final String longitude,
                  final String gyro, final String temperature) {
    this.status = status;
    this.serial = serial;
    this.accelerationX = accelerationX;
    this.accelerationY = accelerationY;
    this.accelerationZ = accelerationZ;
    this.inclination = inclination;
    this.latitude = latitude;
    this.longitude = longitude;
    this.gyro = gyro;
    this.temperature = temperature;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(final int status) {
    this.status = status;
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

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(final String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(final String longitude) {
    this.longitude = longitude;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public String getGyro() {
    return gyro;
  }

  public void setGyro(String gyro) {
    this.gyro = gyro;
  }
}
