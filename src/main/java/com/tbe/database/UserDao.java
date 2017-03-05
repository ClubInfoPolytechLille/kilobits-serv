package com.tbe.database;


import com.tbe.json.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDao {

    String strCreateUtilisateurTable = "Create table if not exists utilisateur ("
            + "id Integer primary key auto_increment,"
            + "pseudo varchar(30) NOT NULL, "
            + "nom varchar(30) NOT NULL, "
            + "prenom varchar(30) NOT NULL, "
            + "mdp varchar(30) NOT NULL DEFAULT '0000', "
            + "ville INTEGER, "
            + "estMobile BOOL NOT NULL DEFAULT 'false', "
            + "typ BOOL NOT NULL DEFAULT 'false', "
            + "divers VARCHAR(30), "
            + "dispo BOOL DEFAULT 'false',"
            + "FOREIGN KEY (ville) REFERENCES ville(id) );";

    @SqlUpdate(strCreateUtilisateurTable)
    void createUserTable();

    @SqlQuery("Select * from utilisateur")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> getAllUser();

    @SqlUpdate("Insert into utilisateur(pseudo, nom, prenom, mdp, ville, estMobile, typ, divers, dispo) " +
            "values ( :pseudo, :nom, :prenom, :mdp, :ville, :estMobile, " +
            ":typ, :divers, :dispo)")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int addUser(@BindBean User user);


    @SqlQuery("SELECT * FROM utilisateur WHERE pseudo = :user.pseudo AND mdp = :user.mdp")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User connectUser(@BindBean("user") User user);

    @SqlUpdate("DELETE FROM utilisateur WHERE id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    int remove(@Bind("id") int id);
}
