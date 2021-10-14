package br.com.fiap.resource.yourfriend;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConfigSql {
        public static final String keyUser = "seu usario do banco";
        public  static  final  String KeyPwd = "sua senha do banco";
        public  static final  String baseUlr = "seu email do banco";

        public Connection getConnection() throws SQLException {
                OracleDataSource ods = new OracleDataSource();
                ods.setURL(ConfigSql.baseUlr);
                ods.setUser(ConfigSql.keyUser);
                ods.setPassword(ConfigSql.KeyPwd);
                Connection conn = ods.getConnection();
                return  conn;
        };



}
