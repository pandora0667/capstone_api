public class SensorInformation {
  private final double latitude;
  private final double longitude;
  private final double accelerationX;
  private final double accelerationY;
  private final double accelerationZ;
  private final int time;

  public static class Builder {
    private double latitude;
    private double longitude;
    private final double accelerationX;
    private final double accelerationY;
    private final double accelerationZ;
    private int time;

    public Builder(final double accelerationX, final double accelerationY, final double accelerationZ) {
      this.latitude = 0;
      this.longitude = 0;
      this.time = 0;
      this.accelerationX = accelerationX;
      this.accelerationY = accelerationY;
      this.accelerationZ = accelerationZ;
    }

    public Builder latitude(final double longitude) {
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

    public SensorInformation build() {
      return new SensorInformation(this);
    }
  }

  public SensorInformation(Builder builder) {
    this.latitude = builder.latitude;
    this.longitude = builder.longitude;
    this.accelerationX = builder.accelerationX;
    this.accelerationY = builder.accelerationY;
    this.accelerationZ = builder.accelerationZ;
    this.time = builder.time;
  }
}
