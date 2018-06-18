package io.wisoft.capstone.vo;

public class Sensors {
  private final double inclination;
  private final double latitude;
  private final double longitude;
  private final double accelerationX;
  private final double accelerationY;
  private final double accelerationZ;
  private final int time;

  public double getAccelerationX() {
    return accelerationX;
  }

  public double getAccelerationY() {
    return accelerationY;
  }

  public double getAccelerationZ() {
    return accelerationZ;
  }

  public double getInclination() {
    return inclination;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public int getTime() {
    return time;
  }

  public static class Builder {
    private final double inclination;
    private double latitude;
    private double longitude;
    private final double accelerationX;
    private final double accelerationY;
    private final double accelerationZ;
    private int time;

    public Builder(final double accelerationX, final double accelerationY, final double accelerationZ, final double inclination) {
      this.latitude = 0;
      this.longitude = 0;
      this.time = 0;
      this.inclination = inclination;
      this.accelerationX = accelerationX;
      this.accelerationY = accelerationY;
      this.accelerationZ = accelerationZ;
    }

    public Builder latitude(final double latitude) {
      this.latitude = latitude;
      return this;
    }

    public Builder longitude(final double longitude) {
      this.longitude = longitude;
      return this;
    }

    public Builder time(final int time) {
      this.time = time;
      return this;
    }

    public Sensors build() {
      return new Sensors(this);
    }
  }

  public Sensors(Builder builder) {
    this.inclination = builder.inclination;
    this.latitude = builder.latitude;
    this.longitude = builder.longitude;
    this.accelerationX = builder.accelerationX;
    this.accelerationY = builder.accelerationY;
    this.accelerationZ = builder.accelerationZ;
    this.time = builder.time;
  }
}
