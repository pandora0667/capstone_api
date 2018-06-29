package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Collector;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CollectorDao implements InterfaceCollectorDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();



  @Override
  public List<Collector> selectAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("io.wisoft.capstone.dao.InterfaceCollectorDao.selectAll");
    }
  }

  @Override
  public List<Collector> select(final String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("io.wisoft.capstone.dao.InterfaceCollectorDao.select", id);
    }
  }

  @Override
  public int insert(final Collector collector) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.insert("io.wisoft.capstone.dao.InterfaceCollectorDao.insert", collector);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(final String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.delete("io.wisoft.capstone.dao.InterfaceCollectorDao.delete", id);
      sqlSession.commit();
      return count;
    }
  }
}
