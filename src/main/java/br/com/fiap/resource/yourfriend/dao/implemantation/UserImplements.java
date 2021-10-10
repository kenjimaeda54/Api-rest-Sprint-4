package br.com.fiap.resource.yourfriend.dao.implemantation;

import br.com.fiap.resource.yourfriend.dao.UserDao;
import br.com.fiap.resource.yourfriend.dao.mapper.UserMapper;
import br.com.fiap.resource.yourfriend.domain.User;
import br.com.fiap.resource.yourfriend.domain.UserSelect;

import java.util.List;
import java.util.Optional;

//aqui ficar a logica do banco de dados
public class UserImplements implements UserDao {
    UserMapper user = new UserMapper();

    @Override
    public User findByIdUser(Integer integer) {
        return null;
    }

    @Override
    public List findByEmail(String email) {
       return  user.verifiedByEmail(email);

    }

    @Override
    public void insert(User newUser) {
      user.insertUser(newUser);
    }

    @Override
    public List<User> getAllUser() {
        return  user.getUsers();
    }
}
