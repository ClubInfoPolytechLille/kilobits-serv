package com.tbe.database;

import com.tbe.json.Besoin;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface BesoinDao {


    String strCreateBesoinTable = "Create table if not exists Besoin ("
            + "Id integer primary key autoincrement,"
            + "Titre varchar(20) NOT NULL,"
            + "Description varchar(500) NOT NULL);";

    @SqlUpdate(strCreateBesoinTable)
    void createBesoinTable();

    @SqlQuery("Select * from besoin")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Besoin> getAllBesoin();

    @SqlUpdate("Insert into besoin (titre, description) values (:titre, :description)")
    @GetGeneratedKeys
    int addBesoin(@Bind("titre") String titre,@Bind("description") String description);
}
