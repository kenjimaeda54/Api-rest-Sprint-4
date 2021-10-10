package br.com.fiap.resource.yourfriend.dao.mapper;

import br.com.fiap.resource.yourfriend.domain.User;
import br.com.fiap.resource.yourfriend.domain.UserSelect;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<User> users;
    public static List<UserSelect> userSelect;

    public UserMapper() {
        if (users == null) {
            users = new ArrayList<User>();
        }

    }

    ;

    public void insertUser(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setId(user.getId());
        users.add(newUser);
    }

    public List verifiedByEmail(String email) {
        userSelect = null;
        List<User> user = users.stream().filter(it -> email.equals(it.getEmail())).collect(Collectors.toList());
        user.forEach(it -> {
                    if(userSelect == null){
                        userSelect = new ArrayList<UserSelect>();
                        UserSelect us = new UserSelect();
                        us.setPassword(it.getPassword());
                        us.setEmail(it.getEmail());
                        us.setId(it.getId());
                        us.setUserName(it.getUserName());
                        userSelect.add(us);
                    }
                }
        );
        return  userSelect;
    }

    public List<User> getUsers() {
        return users;
    }
}
