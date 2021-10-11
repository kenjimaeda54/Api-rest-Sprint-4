package br.com.fiap.resource.yourfriend;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConfigSql {
        public static final String keyUser = "RM87925";
        public  static  final  String KeyPwd = "080689";
        public  static final  String baseUlr = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

        public Connection getConnection() throws SQLException {
                OracleDataSource ods = new OracleDataSource();
                ods.setURL(ConfigSql.baseUlr);
                ods.setUser(ConfigSql.keyUser);
                ods.setPassword(ConfigSql.KeyPwd);
                Connection conn = ods.getConnection();
                return  conn;
        };

}
