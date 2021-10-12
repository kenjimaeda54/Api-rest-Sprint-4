package br.com.fiap.resource.yourfriend.dao;

import br.com.fiap.resource.yourfriend.domain.User;
import br.com.fiap.resource.yourfriend.domain.UserSelect;

import java.util.List;

public interface UserDao {
   void edit(User  user, Integer id);
   void delete(Integer id);
   List<UserSelect> findByEmail(String email);
   void insert(User user);
   List<User> getAllUser();
}
