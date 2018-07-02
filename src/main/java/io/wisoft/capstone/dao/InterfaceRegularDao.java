package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Regular;

import java.util.List;

public interface InterfaceRegularDao {
  List<Regular> selectList(final String serial);
  int insert(final Regular regular);
  int delete(final String serial);
}
