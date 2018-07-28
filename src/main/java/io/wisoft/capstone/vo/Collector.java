package io.wisoft.capstone.vo;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@ToString

public class Collector {
  private String serial;
  private String license_plate;

  public Collector() {

  }

  public Collector(String serial, String license_plate) {
    this.serial = serial;
    this.license_plate = license_plate;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public String getLicense_plate() {
    return license_plate;
  }

  public void setLicense_plate(String license_plate) {
    this.license_plate = license_plate;
  }
}
