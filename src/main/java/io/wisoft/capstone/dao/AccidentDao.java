package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Accident;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AccidentDao implements InterfaceAccidentDao {

  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public List<Accident> selectList(final String serial) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceAccidentDao interfaceAccidentDao = sqlSession.getMapper(InterfaceAccidentDao.class);
      return interfaceAccidentDao.selectList(serial);
    }
  }

  @Override
  public int insert(final Accident accident) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceAccidentDao interfaceAccidentDao = sqlSession.getMapper(InterfaceAccidentDao.class);
      int count = interfaceAccidentDao.insert(accident);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(final String serial) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceAccidentDao interfaceAccidentDao = sqlSession.getMapper(InterfaceAccidentDao.class);
      int count = interfaceAccidentDao.delete(serial);
      sqlSession.commit();

      return count;
    }
  }
}
