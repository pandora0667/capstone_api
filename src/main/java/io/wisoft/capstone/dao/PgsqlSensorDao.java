package io.wisoft.capstone.dao;


import io.wisoft.capstone.vo.Sensor;

public class PgsqlSensorDao implements SensorDao{

  @Override
  public Sensor select(final String id, final String deviceID) {
    return new Sensor();
  }

  @Override
  public int normallyInsert(final Sensor sensor) {
    return 0;
  }

  @Override
  public int accidentInsert(final Sensor sensor) {
    return 0;
  }
}
