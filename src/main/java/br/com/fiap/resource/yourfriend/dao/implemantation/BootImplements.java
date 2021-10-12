package br.com.fiap.resource.yourfriend.dao.implemantation;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.dao.BotDao;
import br.com.fiap.resource.yourfriend.domain.Boot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BootImplements implements BotDao {

    private static  List<Boot> boot;
    ConfigSql config = new ConfigSql();


    @Override
    public List<Boot> getAllBot() {
        boot =null;
        try {
            String query = "SELECT boot_id,boot_relations,boot_media_social,boot_profession,user_id FROM BOOT";
            Connection coon = config.getConnection();
            Statement stm = coon.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(boot == null){
                boot = new ArrayList<Boot>();
                while(rs.next()){
                    Boot bootResult = new Boot();
                    bootResult.setId(rs.getInt("boot_id"));
                    bootResult.setProfession(rs.getString("boot_profession"));
                    bootResult.setSocialMedia(rs.getString("boot_media_social"));
                    bootResult.setRelations(rs.getString("boot_relations"));
                   //reolsver questao de logica usuario.Implementar o usario.
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Boot> findByIdBot(Integer id) {
        return null;
    }
}
