
public class UserInformation {
  private final String deviceID;
  private final String email;
  private final String phone;
  private final String password;
  private final String carType;
  private final String carNumber;

  public static class Builder {
    private final String deviceID;
    private String email;
    private String phone;
    private String password;
    private String carType;
    private String carNumber;

    public Builder(final String deviceID) {
      this.deviceID = deviceID;
      this.email = null;
      this.phone = null;
      this.password = null;
      this.carType = null;
      this.carNumber = null;
    }

    public Builder email(final String email) {
      this.email = email;
      return this;
    }

    public Builder phone(final String phone) {
      this.phone = phone;
      return this;
    }

    public Builder password(final String password) {
      this.password = password;
      return this;
    }

    public Builder carType(final String carType) {
      this.carType = carType;
      return this;
    }

    public Builder carNumber(final String carNumber) {
      this.carNumber = carNumber;
      return this;
    }

    public UserInformation build() {
      return new UserInformation(this);
    }
  }

  public UserInformation(Builder builder) {
    this.deviceID = builder.deviceID;
    this.email = builder.email;
    this.phone = builder.phone;
    this.password = builder.password;
    this.carType = builder.carType;
    this.carNumber = builder.carNumber;
  }
}
