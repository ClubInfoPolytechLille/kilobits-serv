package com.tbe.database;

import com.tbe.json.Categorie;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface CategorieDao {

    String strCreateCategorieTable = "Create table if not exists Categorie ("
            + "Id Integer primary key auto_increment,"
            + "Nom varchar(20) NOT NULL, "
            + "Description varchar(500) NOT NULL);";

    @SqlUpdate(strCreateCategorieTable)
    void createCategorieTable();

    @SqlQuery("Select * from categorie")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Categorie> getAllCategorie();

    @SqlUpdate("insert into categorie (nom, description) values (:nom, :description);")
    @GetGeneratedKeys
    int addCategorie(@Bind("nom") String nom,@Bind("description") String description);
}
