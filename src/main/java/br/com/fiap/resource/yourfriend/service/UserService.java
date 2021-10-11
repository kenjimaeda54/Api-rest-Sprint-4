package br.com.fiap.resource.yourfriend.service;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.dao.UserDao;
import br.com.fiap.resource.yourfriend.dao.implemantation.UserImplements;
import br.com.fiap.resource.yourfriend.domain.User;


import java.sql.SQLException;
import java.util.List;


public class UserService {

    UserDao userDao = new UserImplements();


    public List<User> getAllUser() throws SQLException {

        return userDao.getAllUser();
    }

    public void insertUser(User user) throws SQLException {
        userDao.insert(user);
    }

    public List verifiedByEmail(String email) {
        return userDao.findByEmail(email);
    }

    ;


}
