package br.com.fiap.resource.yourfriend.dao;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
   User findByIdUser(Integer integer);
   List findByEmail(String email);
   void insert(User user) throws SQLException;
   List<User> getAllUser() throws SQLException;
}
