package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Device;

import java.util.List;

public interface DeviceDao {
  List<Device> selectAll();
  List<Device> select(final String id);
  int insert(final Device device);
  int delete(final String id);
}
