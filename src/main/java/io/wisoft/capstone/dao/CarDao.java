package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Car;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CarDao implements InterfaceCarDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public int insert(final Car car) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCarDao interfaceCarDao = sqlSession.getMapper(InterfaceCarDao.class);
      int count = interfaceCarDao.insert(car);
      sqlSession.commit();
      return count;
    }
  }
  @Override
  public List<Car> selectList() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCarDao interfaceCarDao = sqlSession.getMapper(InterfaceCarDao.class);

      return interfaceCarDao.selectList();
    }
  }

  @Override
  public List<Car> selectCars(String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCarDao interfaceCarDao = sqlSession.getMapper(InterfaceCarDao.class);

      return interfaceCarDao.selectCars(id);
    }
  }


  @Override
  public int delete(String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCarDao interfaceCarDao = sqlSession.getMapper(InterfaceCarDao.class);
      int count = interfaceCarDao.delete(id);
      sqlSession.commit();
      return count;
    }
  }
}
