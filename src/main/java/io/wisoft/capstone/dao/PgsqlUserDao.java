package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PgsqlUserDao implements UserDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public List<User> selectAll() {
    return null;
  }

  @Override
  public User selectOne(String id) {
    return null;
  }

  @Override
  public int insert(User user) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
      int count = sqlSession.insert("io.wisoft.capstone.dao.UserDao.insert", user);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int update(final User user) {
    return 0;
  }

  @Override
  public int delete(final String id) {
    return 0;
  }
}
