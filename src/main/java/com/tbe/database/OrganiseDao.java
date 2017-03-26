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
            + "evenement integer,"
            + "utilisateur integer," +
            "Primary key (evenement, utilisateur),"
            + "FOREIGN KEY (evenement) REFERENCES evenement(Id),"
            + "FOREIGN KEY (utilisateur) REFERENCES utilisateur(Id));";

    @SqlUpdate(strCreateOrganiseTable)
    void createOrganiseTable();

    @SqlQuery("Select * from organise")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Organise> getAllOrganise();

    @SqlUpdate("Insert into organise (evenement, utilisateur) values (:evenement, :utilisateur)")
    @GetGeneratedKeys
    int addOrganise(@Bind("evenements") int evenement,@Bind("utilisateur") int utilisateur);

    @SqlUpdate("Delete from organise where evenement=:evenement and utilisateur=:utilisateur")
    int deleteOrganise(@Bind("evenement") int evenement,@Bind("utilisateur") int utilisateur);

    @SqlQuery("Select * from organise where utilisateur=user and evenement=event")
    Organise getOrganise(@Bind("user") int user,@Bind("event") int event);
}
