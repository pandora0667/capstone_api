package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PgsqlUserDao implements UserDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public List<User> selectAll() throws Exception {
    return null;
  }

  @Override
  public User selectOne(String id) throws Exception {
    return null;
  }

  @Override
  public int insert(User user) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
      int count = sqlSession.insert("io.wisoft.capstone.dao.UserDao.insert", user);
      sqlSession.commit();
      return count;
    }
  }
}
