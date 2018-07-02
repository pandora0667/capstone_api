package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerDao implements InterfaceCustomerDao {

  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public List<Customer> selectList() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCustomerDao interfaceCustomerDao = sqlSession.getMapper(InterfaceCustomerDao.class);

      return interfaceCustomerDao.selectList();
    }
  }

  @Override
  public Customer selectOne(String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCustomerDao interfaceCustomerDao = sqlSession.getMapper(InterfaceCustomerDao.class);

      return interfaceCustomerDao.selectOne(id);
    }
  }

  @Override
  public int insert(final Customer customer) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCustomerDao interfaceCustomerDao = sqlSession.getMapper(InterfaceCustomerDao.class);
      int count = interfaceCustomerDao.insert(customer);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int update(final Customer customer) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCustomerDao interfaceCustomerDao = sqlSession.getMapper(InterfaceCustomerDao.class);
      return 0;
    }
  }

  @Override
  public int delete(final String id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      InterfaceCustomerDao interfaceCustomerDao = sqlSession.getMapper(InterfaceCustomerDao.class);
      int count = interfaceCustomerDao.delete(id);
      sqlSession.commit();
      return count;
    }
  }
}
