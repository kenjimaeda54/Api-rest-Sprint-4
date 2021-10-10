package br.com.fiap.resource.yourfriend.service;

import br.com.fiap.resource.yourfriend.dao.UserDao;
import br.com.fiap.resource.yourfriend.dao.implemantation.UserImplements;
import br.com.fiap.resource.yourfriend.domain.User;
import br.com.fiap.resource.yourfriend.domain.UserSelect;

import java.util.List;
import java.util.Optional;


public class UserService  {

//    User user = new User();

     UserDao userDao = new UserImplements();

     public  List<User> getAllUser() {
        return  userDao.getAllUser();
     }

     public void  insertUser(User user){
         userDao.insert(user);
     }

     public List verifiedByEmail(String email) {
         return userDao.findByEmail(email);
     };




//    public User register(User user) {
//       return (User) userDao.create(user);
//
//    }
//
//    public Integer getUserId(Integer id){
//         User userId = userDao.findByIdUser(id);
//         if(userId == null){
//             throw  new RuntimeException("Usuário não cadastrado");
//         }
//         return userId.getId();
//    };



}
