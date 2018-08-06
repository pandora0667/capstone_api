package io.wisoft.capstone.vo;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@ToString

public class Collector {
  private String serial;
  private String licensePlate;

  public Collector() {

  }

  public Collector(final String serial, final String licensePlate) {
    this.serial = serial;
    this.licensePlate = licensePlate;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(final String serial) {
    this.serial = serial;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(final String licensePlate) {
    this.licensePlate = licensePlate;
  }
}
