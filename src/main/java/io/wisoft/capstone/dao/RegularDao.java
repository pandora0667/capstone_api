package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Regular;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class RegularDao implements InterfaceRegularDao {

  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public List<Regular> selectList(final String serial) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceRegularDao interfaceRegularDao = sqlSession.getMapper(InterfaceRegularDao.class);
      return interfaceRegularDao.selectList(serial);
    }
  }

  @Override
  public int insert(final Regular regular) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceRegularDao interfaceRegularDao = sqlSession.getMapper(InterfaceRegularDao.class);
      int count = interfaceRegularDao.insert(regular);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(final String serial) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceRegularDao interfaceRegularDao = sqlSession.getMapper(InterfaceRegularDao.class);
      int count = interfaceRegularDao.delete(serial);
      sqlSession.commit();

      return count;
    }
  }
}
