package io.wisoft.capstone.vo;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@ToString

public class Car {
  private String customer_id;
  private String kind;
  private String license_plate;

  public Car() {

  }

  public Car(String customer_id, String kind, String license_plate) {
    this.customer_id = customer_id;
    this.kind = kind;
    this.license_plate = license_plate;
  }

  public String getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(String customer_id) {
    this.customer_id = customer_id;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getLicense_plate() {
    return license_plate;
  }

  public void setLicense_plate(String license_plate) {
    this.license_plate = license_plate;
  }
}
