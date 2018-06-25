package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.User;

import java.util.List;

public interface UserDao {
  List<User> selectAll();
  User selectOne(final String id);
  int insert(final User user);
  int update(final User user);
  int delete(final String id);

}
