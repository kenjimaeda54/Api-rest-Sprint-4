package br.com.fiap.resource.yourfriend;

import oracle.jdbc.pool.OracleDataSource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationPath("/api")
public class HelloApplication extends Application {


    String baseUlr = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    Connection coon;

    public HelloApplication() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(baseUlr);
        ods.setUser(ConfigSql.keyUser);
        ods.setPassword(ConfigSql.KeyPwd);
        coon = ods.getConnection();
    }

}


