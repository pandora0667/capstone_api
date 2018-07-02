package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Accident;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AccidentDao implements InterfaceAccidentDao {

  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public int insert(final Accident accident) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.insert("io.wisoft.capstone.dao.InterfaceAccidentDao.insert", accident);
      sqlSession.commit();
      return count;
    }
  }
}
