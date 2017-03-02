package com.tbe.database;

import com.tbe.json.Service;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ServiceDao {

    String strCreateServiceTable = "Create table if not exists Service ("
            + "Id Integer primary key auto_increment,"
            + "IdCategorie Integer,"
            + "IdUtilisateur Integer,"
            + "FOREIGN KEY (IdCategorie) REFERENCES Categorie(Id),"
            + "FOREIGN KEY (IdUtilisateur) REFERENCES Utilisateur(Id));";

    @SqlUpdate(strCreateServiceTable)
    void createServiceTable();

    @SqlQuery("Select * from service")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Service> getAllService();

    @SqlUpdate("insert into service values (:idCategorie, :idUtilisateur)")
    @GetGeneratedKeys
    int addService(@Bind("idCategorie") String idcategorie,@Bind("idUtilisateur") String idutilisateur);

}
