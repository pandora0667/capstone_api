package io.wisoft.capstone.vo;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@ToString

public class Car {
  private String customerId;
  private String kind;
  private String licensePlate;

  public Car() {

  }

  public Car(final String customerId, final String kind, final String licensePlate) {
    this.customerId = customerId;
    this.kind = kind;
    this.licensePlate = licensePlate;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(final String customerId) {
    this.customerId = customerId;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(final String kind) {
    this.kind = kind;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(final String licensePlate) {
    this.licensePlate = licensePlate;
  }
}
