package br.com.fiap.resource.yourfriend.dao.implemantation;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.dao.UserDao;
import br.com.fiap.resource.yourfriend.dao.mapper.UserMapper;
import br.com.fiap.resource.yourfriend.domain.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserImplements implements UserDao {
    UserMapper user = new UserMapper();

    private static List<User> users;
    ConfigSql config = new ConfigSql();

//    public  UserImplements() {
//        users = new ArrayList<User>();
//    }

    @Override
    public User findByIdUser(Integer integer) {
        return null;
    }

    @Override
    public List findByEmail(String email) {
        return user.verifiedByEmail(email);

    }

    @Override
    public void insert(User newUser) {
        try{
            String sql = "INSERT INTO USERS(USER_NAME,USER_NICKNAME,USER_EMAIL,USER_PASSWORD,USER_ID) VALUES (?,?,?,?)";
            Connection coon = config.getConnection();
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setString(1,newUser.getName());
            ps.setString(2,newUser.getNickName());
            ps.setString(3,newUser.getEmail());
            ps.setString(4,newUser.getPassword());
            users.add(newUser);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            String sql = "SELECT * FROM USERS";
            Connection coon = config.getConnection();
            Statement stm = coon.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (users == null) {
                users = new ArrayList<User>();
                while (rs.next()) {
                    User userQuery = new User();
                    userQuery.setId(rs.getInt("user_id"));
                    userQuery.setNickName(rs.getString("user_nickname"));
                    userQuery.setPassword(Integer.toString(rs.getInt("user_password")));
                    userQuery.setEmail(rs.getString("user_email"));
                    userQuery.setName(rs.getString("user_name"));
                    users.add(userQuery);
                }
            }
            rs.close();
            stm.close();
            config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
    }


}
