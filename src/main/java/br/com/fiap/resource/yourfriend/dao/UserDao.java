package br.com.fiap.resource.yourfriend.dao;

import br.com.fiap.resource.yourfriend.domain.User;

import java.util.List;

public interface UserDao {


   User findByIdUser(Integer integer);
   List findByEmail(String email);
   void insert(User user);
   List<User> getAllUser();
}
