package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Device;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PgsqlDeviceDao implements DeviceDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();



  @Override
  public List<Device> selectAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("io.wisoft.capstone.dao.DeviceDao.selectAll");
    }
  }

  @Override
  public List<Device> select(final String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("io.wisoft.capstone.dao.DeviceDao.select", id);
    }
  }

  @Override
  public int insert(final Device device) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.insert("io.wisoft.capstone.dao.DeviceDao.insert", device);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(final String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.delete("io.wisoft.capstone.dao.DeviceDao.delete", id);
      sqlSession.commit();
      return count;
    }
  }
}
