package io.wisoft.capstone.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;

public class DatabaseConnection {
  private static final String MYBATIS_CONFIG_FILE = "mybatis/mybatis-config.xml";
  private static SqlSessionFactory sqlSessionFactory;

  public static SqlSessionFactory getInstance() {
    if (sqlSessionFactory == null)
      try (final Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG_FILE)) {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
      } catch (IOException ignore) {}

      return sqlSessionFactory;
  }
}
