package io.wisoft.capstone.dao;

import io.wisoft.capstone.vo.Customer;

import java.util.List;

public interface InterfaceCustomerDao {
  List<Customer> selectList();
  Customer selectOne(final String id);
  int insert(final Customer customer);
  int update(final Customer customer);
  int delete(final String id);

}
