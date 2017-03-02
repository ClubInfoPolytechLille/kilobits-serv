package com.tbe.database;

import com.tbe.json.Participe;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ParticipeDao {

    String strCreateParticipeTable = "Create table if not exists Participe ("
            + "Id integer primary key auto_increment,"
            + "Nombre int,"
            + "Evenement varchar(30),"
            + "Utilisateur varchar(30),"
            + "FOREIGN KEY (Evenement) REFERENCES Evenement(Id),"
            + "FOREIGN KEY (Utilisateur) REFERENCES Utilisateur(Id));";

    @SqlUpdate(strCreateParticipeTable)
    void createParticipeTable();

    @SqlQuery("Select * from participe")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Participe> getAllParticipe();

    @SqlUpdate("insert into participe values (:nombre, :ev, :utilisateur)")
    @GetGeneratedKeys
    int addParticipe(@Bind("nombre") int nombre,@Bind("ev") String evenement,@Bind("utilisateur") String utilisateur );
}
