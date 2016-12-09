package com.tbe.database;

import com.tbe.json.Evenement;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.sql.Date;
import java.util.List;

public interface EvenementDao {

    String strCreateEvenementTable = "Create table if not exists Evenement ("
            + "Id integer primary key autoincrement,"
            + "Lieu varchar(20) NOT NULL,"
            + "Dat varchar(20) NOT NULL,"
            + "Description varchar(500) NOT NULL);";

    @SqlUpdate(strCreateEvenementTable)
    void createEvenementTable();

    @SqlQuery("Select * from evenement")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Evenement> getAllEvenement();

    @SqlUpdate("insert into evenement (lieu, dat, description) values (:lieu, :dat, :description);")
    @GetGeneratedKeys
    int addEvenement(@Bind("lieu") String lieu,@Bind("dat") Date dat,@Bind("description") String description);

}
