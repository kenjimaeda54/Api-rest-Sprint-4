package br.com.fiap.resource.yourfriend.dao;

import br.com.fiap.resource.yourfriend.domain.User;
import br.com.fiap.resource.yourfriend.domain.UserSelect;

import java.util.List;
import java.util.Optional;

public interface UserDao {
   User findByIdUser(Integer integer);
   List findByEmail(String email);
   void insert(User user);
   List<User> getAllUser();
}
