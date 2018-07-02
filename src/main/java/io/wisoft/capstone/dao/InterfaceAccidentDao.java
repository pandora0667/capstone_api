package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Accident;

import java.util.List;

public interface InterfaceAccidentDao {
  List<Accident> selectList(final String serial);
  int insert(final Accident accident);
  int delete(final String id);
}
