package com.tbe.database;

import com.tbe.json.Ville;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

/**
 * Created by badet on 02/03/2017.
 */
public interface VilleDao {

    String strCreateVilleTable = "Create table if not exists ville ("
            + "id Integer primary key auto_increment,"
            + "name varchar(30) NOT NULL);";

    @SqlUpdate(strCreateVilleTable)
    void createVilleTable();

    @SqlUpdate("insert into ville (name) values (:name)")
    @GetGeneratedKeys
    int addVille(@Bind("name") String name);

    @SqlQuery("Select * from ville")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Ville> getAllVille();

}
