package com.tbe.database;

import com.tbe.json.Organise;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface OrganiseDao {

    String strCreateOrganiseTable = "Create table if not exists Organise ("
            + "Id varchar(20) primary key,"
            + "Evenement varchar(30),"
            + "Utilisateur varchar(30),"
            + "FOREIGN KEY (Evenement) REFERENCES Evenement(Id),"
            + "FOREIGN KEY (Utilisateur) REFERENCES Utilisateur(Id));";

    @SqlUpdate(strCreateOrganiseTable)
    void createOrganiseTable();

    @SqlQuery("Select * from organise")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Organise> getAllOrganise();

    @SqlUpdate("Insert into organise (evenement, utilisateur) values (:evenement, :utilisateur)")
    @GetGeneratedKeys
    int addOrganise(@Bind("evenements") String evenement,@Bind("utilisateur") String utilisateur);
}
