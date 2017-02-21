package com.tbe.rest;

import org.skife.jdbi.v2.DBI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.sqlite.SQLiteDataSource;

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
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:"+System.getProperty("java.io.tmpdir")
                    +System.getProperty("file.separator")+"kilobits.db");
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

