package com.tbe.database;


import com.tbe.json.User;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDao {

    String strCreateUtilisateurTable = "Create table if not exists Utilisateur ("
            + "Id Integer primary key autoincrement,"
            + "Pseudo varchar(30) NOT NULL, "
            + "Nom varchar(30) NOT NULL, "
            + "Prenom varchar(30) NOT NULL, "
            + "Mdp varchar(30) NOT NULL DEFAULT '0000', "
            + "Ville varchar(30), "
            + "EstMobile BOOL NOT NULL DEFAULT 'false', "
            + "Typ BOOL NOT NULL DEFAULT 'false', " // Par default t'es migrant en false
            + "Divers VARCHAR(30), "
            + "Dispo BOOL DEFAULT 'false');";

    @SqlUpdate(strCreateUtilisateurTable)
    void createUserTable();

    @SqlQuery("Select * from utilisateur")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> getAllUser();

    @SqlUpdate("Insert into utilisateur(pseudo, nom, prenom, mdp, ville, EstMobile, Typ, Divers, Dispo) " +
            "values ( :user.pseudo, :user.nom, :user.prenom, :user.mdp, :user.ville, :user.estMobile, " +
            ":user.typ, :user.divers, :user.dispo)")
    @RegisterMapperFactory(BeanMapperFactory.class)
    String addUser(@BindBean("user") User user);


    @SqlQuery("SELECT * FROM utilisateur WHERE pseudo = :user.pseudo AND mdp = :user.mdp")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User connectUser(@BindBean("user") User user);

}
