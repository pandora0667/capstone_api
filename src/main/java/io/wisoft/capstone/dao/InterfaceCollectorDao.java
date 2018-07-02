package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Collector;

import java.util.List;

public interface InterfaceCollectorDao {
  List<Collector> selectList();
  List<Collector> selectCollectors(final String licensePlate);
  int insert(final Collector collector);
  int delete(final String id);
}
