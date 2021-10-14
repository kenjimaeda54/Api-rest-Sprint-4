package br.com.fiap.resource.yourfriend.dao.implemantation;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.dao.BotDao;
import br.com.fiap.resource.yourfriend.domain.Boot;
import br.com.fiap.resource.yourfriend.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BootImplements implements BotDao {

    private static List<Boot> boot;
    private static List<User> userSelects;
    ConfigSql config = new ConfigSql();


    @Override
    public List<Boot> getAllBot() {
        boot = null;
        try {
            String bootQuery = "SELECT * FROM BOOTS";
            String userQuery = "SELECT * FROM USERS WHERE user_id=?";
            Connection coon = config.getConnection();
            Statement stm = coon.createStatement();
            ResultSet rsBot = stm.executeQuery(bootQuery);
            PreparedStatement ps = coon.prepareStatement(userQuery);
            if (boot == null) {
                boot = new ArrayList<Boot>();
                while (rsBot.next()) {
                    Boot bootResult = new Boot();
                    bootResult.setId(rsBot.getInt("boot_id"));
                    bootResult.setProfession(rsBot.getString("boot_profession"));
                    bootResult.setSocialMedia(rsBot.getString("boot_medial_social"));
                    bootResult.setRelations(rsBot.getString("boot_relations"));
                    bootResult.setUserId(rsBot.getInt("user_id"));
                    ps.setInt(1, rsBot.getInt("user_id"));
                    try (ResultSet res = ps.executeQuery()) {
                        userSelects = null;
                        if (userSelects == null) {
                            userSelects = new ArrayList<User>();
                            while (res.next()) {
                                User user = new User();
                                user.setId(res.getInt("user_id"));
                                user.setEmail(res.getString("user_email"));
                                user.setNickName(res.getString("user_nickname"));
                                user.setPassword(res.getString("user_password"));
                                user.setName(res.getString("user_name"));
                                userSelects.add(user);
                            }
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    bootResult.setUser(userSelects);
                    boot.add(bootResult);

                }
                rsBot.close();
                ps.close();
                stm.close();
                coon.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boot;
    }

    @Override
    public void insertPhrases(Boot boot) {
            try {
                String sql = "INSERT INTO BOOTS(BOOT_RELATIONS,BOOT_MEDIAL_SOCIAL,BOOT_PROFESSION,USER_ID) VALUES(?,?,?,?)";
                Connection conn = config.getConnection();
                PreparedStatement ps =conn.prepareStatement(sql);
                ps.setString(1,boot.getRelations());
                ps.setString(2,boot.getSocialMedia());
                ps.setString(3,boot.getProfession());
                ps.setInt(4,boot.getUserId());
                ps.execute();
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


}
