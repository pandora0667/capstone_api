package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Regular;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class RegularDao implements InterfaceRegularDao {

  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public int insert(final Regular regular) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.insert("io.wisoft.capstone.dao.InterfaceRegularDao.insert", regular);
      sqlSession.commit();
      return count;
    }
  }
}
