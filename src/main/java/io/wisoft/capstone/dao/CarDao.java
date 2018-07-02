package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Car;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CarDao implements InterfaceCarDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public int insert(final Car car) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count  = sqlSession.insert("io.wisoft.capstone.dao.InterfaceCarDao.insert", car);
      sqlSession.commit();
      return count;
    }
  }
}
