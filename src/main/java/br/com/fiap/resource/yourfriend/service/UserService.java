package br.com.fiap.resource.yourfriend.service;

import br.com.fiap.resource.yourfriend.dao.UserDao;
import br.com.fiap.resource.yourfriend.dao.implemantation.UserImplements;
import br.com.fiap.resource.yourfriend.domain.User;

import java.util.List;


public class UserService {

    UserDao userDao = new UserImplements();


    public List<User> getAllUser()  {
        return userDao.getAllUser();
    }

    public void insertUser(User user) {
        userDao.insert(user);
    }

    public List<User> verifiedByEmail(String email) {
        return userDao.findByEmail(email);
    };

    public  void delete(Integer id){
        userDao.delete(id);
    }

    public  void edit(User user, Integer id ){
        userDao.edit(user,id);
    }


}
