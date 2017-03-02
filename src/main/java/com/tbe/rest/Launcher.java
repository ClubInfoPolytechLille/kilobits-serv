package com.tbe.rest;

import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
@EnableAutoConfiguration
public class Launcher extends WebMvcConfigurerAdapter {

    private static DBI dbi = null;

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class);
	}

    static DBI getDbi() {
        if(dbi == null) {
            DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test", "username", "password");
            dbi = new DBI(ds);
        }
        return dbi;
    }

    static boolean tableExist(String tableName) throws SQLException {
        DatabaseMetaData dbm = getDbi().open().getConnection().getMetaData();
        ResultSet tables = dbm.getTables(null, null, tableName, null);
        boolean exist = tables.next();
        tables.close();
        return exist;
    }

}

