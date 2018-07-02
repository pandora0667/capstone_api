package io.wisoft.capstone.dao;


import io.wisoft.capstone.vo.Car;

import java.util.List;

public interface InterfaceCarDao {
  List<Car> selectList();
  List<Car> selectCars(final String id);
  int insert(final Car car);
  int delete (final String id);
}
