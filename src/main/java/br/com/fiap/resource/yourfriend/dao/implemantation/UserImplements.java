package br.com.fiap.resource.yourfriend.dao.implemantation;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.dao.UserDao;
import br.com.fiap.resource.yourfriend.domain.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserImplements implements UserDao {

    private static List<User> users;
    ConfigSql config = new ConfigSql();


    @Override
    public void edit(User user, Integer id) {
        try {
            String query = "UPDATE users SET user_name=?,user_nickname=?,user_email=?,user_password=? WHERE user_id=?";
            Connection conn = config.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getNickName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, id);
            ps.execute();
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            String query = "DELETE FROM users WHERE user_id=?";
            Connection coon = config.getConnection();
            PreparedStatement ps = coon.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            coon.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<User> findByEmail(String email) {
        try {
            String queryUser = "SELECT * FROM  USERS";
            Connection coon = config.getConnection();
            Statement stm = coon.createStatement();
            ResultSet rs = stm.executeQuery(queryUser);
            if (users == null) {
                users = new ArrayList<User>();
                User user = new User();
                while (rs.next()) {
                    if (email.equals(rs.getString("user_email"))) {
                        user.setName(rs.getString("user_name"));
                        user.setEmail(rs.getString("user_email"));
                        user.setPassword(rs.getString("user_password"));
                        user.setNickName(rs.getString("user_nickname"));
                        user.setId(rs.getInt("user_id"));
                        users.add(user);
                    }
                }

                return users;

            } else {
                List<User> user = users.stream().filter(it -> email.equals(it.getEmail())).collect(Collectors.toList());
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void insert(User newUser) {
        try {
            String sql = "INSERT INTO users(user_name,user_nickname,user_email,user_password) VALUES (?,?,?,?)";
            Connection coon = config.getConnection();
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setString(1, newUser.getName());
            ps.setString(2, newUser.getNickName());
            ps.setString(3, newUser.getEmail());
            ps.setString(4, newUser.getPassword());
            ps.execute();
            ps.close();
            coon.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<User> getAllUser() {
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
    }


}
