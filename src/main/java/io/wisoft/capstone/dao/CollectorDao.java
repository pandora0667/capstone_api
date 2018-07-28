package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Collector;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CollectorDao implements InterfaceCollectorDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public List<Collector> selectList() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCollectorDao interfaceCollectorDao = sqlSession.getMapper(InterfaceCollectorDao.class);

      return interfaceCollectorDao.selectList();
    }
  }

  @Override
  public List<Collector> selectCollectors(final String serial) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCollectorDao interfaceCollectorDao = sqlSession.getMapper(InterfaceCollectorDao.class);
      return interfaceCollectorDao.selectCollectors(serial);
    }
  }

  @Override
  public int insert(final Collector collector) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCollectorDao interfaceCollectorDao = sqlSession.getMapper(InterfaceCollectorDao.class);
      int retValue = interfaceCollectorDao.insert(collector);
      sqlSession.commit();
      return retValue;
    }
  }

  @Override
  public int update(final Collector collector) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCollectorDao interfaceCollectorDao = sqlSession.getMapper(InterfaceCollectorDao.class);
      int retValue = interfaceCollectorDao.update(collector);
      sqlSession.commit();
      return retValue;
    }
  }

  @Override
  public int delete(final String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCollectorDao interfaceCollectorDao = sqlSession.getMapper(InterfaceCollectorDao.class);
      int retValue = interfaceCollectorDao.delete(id);
      sqlSession.commit();
      return retValue;
    }
  }
}
