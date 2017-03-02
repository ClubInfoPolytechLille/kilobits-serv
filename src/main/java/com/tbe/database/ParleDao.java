package com.tbe.database;

import com.tbe.json.Parle;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ParleDao {

    String strCreateParleTable = "Create table if not exists Parle ("
            + "Id Integer primary key auto_increment,"
            + "Nom varchar(20) NOT NULL);";

    @SqlUpdate(strCreateParleTable)
    void createParleTable();

    @SqlQuery("Select * from parle")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Parle> getAllParle();

    @SqlUpdate("Insert into parle values :nom")
    @GetGeneratedKeys
    int addParle(@Bind("nom") String nom);
}
