package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.User;

import java.util.List;

public interface UserDao {
  List<User> selectAll() throws Exception;
  User selectOne(final String id) throws Exception;
  int insert(final User user) throws Exception;
}
