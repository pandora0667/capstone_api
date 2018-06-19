package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Car;

import java.util.List;

public interface CarDao {
  List<Car> getUserCars(final String id) throws Exception;
}
