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



    @Override
    public User findByIdUser(Integer integer) {
        return null;
    }

    @Override
    public List findByEmail(String email) {
        return null;

    }

    @Override
    public void insert(User newUser) throws SQLException {
            String sql = "INSERT INTO users(user_name,user_nickname,user_email,user_password) VALUES (?,?,?,?)";
            Connection coon = config.getConnection();
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setString(1,newUser.getName());
            ps.setString(2,newUser.getNickName());
            ps.setString(3,newUser.getEmail());
            ps.setString(4,newUser.getPassword());
            ps.execute();
            ps.close();
            coon.close();
    }

    @Override
    public List<User> getAllUser() throws SQLException {
            users = null;
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
                    userQuery.setPassword(rs.getString("user_password"));
                    userQuery.setEmail(rs.getString("user_email"));
                    userQuery.setName(rs.getString("user_name"));
                    users.add(userQuery);
                }
            }
            rs.close();
            stm.close();
            coon.close();

        return users;
    }


}
