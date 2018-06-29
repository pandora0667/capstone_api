package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Collector;

import java.util.List;

public interface InterfaceCollectorDao {
  List<Collector> selectAll();
  List<Collector> select(final String id);
  int insert(final Collector collector);
  int delete(final String id);
}
