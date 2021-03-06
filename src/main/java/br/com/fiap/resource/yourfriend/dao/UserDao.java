package br.com.fiap.resource.yourfriend.dao;

import br.com.fiap.resource.yourfriend.domain.User;

import java.util.List;

public interface UserDao {
   void edit(User  user, Integer id);
   void delete(Integer id);
   List<User> findByEmail(String email);
   void insert(User user);
   List<User> getAllUser();
}
