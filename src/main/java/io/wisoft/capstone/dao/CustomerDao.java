package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerDao implements InterfaceCustomerDao {
  private SqlSessionFactory sqlSessionFactory = DatabaseConnection.getInstance();

  @Override
  public List<Customer> selectAll() {
    return null;
  }

  @Override
  public Customer selectOne(String id) {
    return null;
  }

  @Override
  public int insert(Customer customer) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
      int count = sqlSession.insert("io.wisoft.capstone.dao.InterfaceUserDao.insert", customer);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int update(final Customer customer) {
    return 0;
  }

  @Override
  public int delete(final String id) {
    return 0;
  }
}
