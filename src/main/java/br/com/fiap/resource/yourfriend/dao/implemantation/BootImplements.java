package br.com.fiap.resource.yourfriend.dao.implemantation;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.dao.BotDao;
import br.com.fiap.resource.yourfriend.domain.Boot;
import br.com.fiap.resource.yourfriend.domain.User;
import br.com.fiap.resource.yourfriend.domain.UserSelect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BootImplements implements BotDao {

    private static List<Boot> boot;
    private static List<UserSelect> userSelects;
    ConfigSql config = new ConfigSql();


    @Override
    public List<Boot> getAllBot() {
        boot = null;
        userSelects = null;
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
                    ps.setInt(1, rsBot.getInt("user_id"));
                    try (ResultSet res = ps.executeQuery()) {
                        if (userSelects == null) {
                            userSelects = new ArrayList<UserSelect>();
                            while (res.next()) {
                                UserSelect user = new UserSelect();
                                user.setId(res.getInt("user_id"));
                                user.setEmail(res.getString("user_password"));
                                user.setNickName(res.getString("user_nickname"));
                                user.setPassword(res.getString("user_password"));
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
    public List<Boot> findByIdBot(Integer id) {
        return null;
    }
}
