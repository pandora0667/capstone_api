package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Sensor;

public interface SensorDao {
  Sensor select(final String id, final String deviceID);
  int normallyInsert(final Sensor sensor);
  int accidentInsert(final Sensor sensor);
}
