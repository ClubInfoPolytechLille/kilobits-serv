package com.tbe.database;

import com.tbe.json.Message;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface MessageDao {

    String strCreateMessageTable = "Create table if not exists Message ("
            + "Id Integer primary key autoincrement,"
            + "Texte txt,"
            + "IdUtilisateur varchar(30),"
            + "FOREIGN KEY (IdUtilisateur) REFERENCES Utilisateur(Id));";

    @SqlUpdate(strCreateMessageTable)
    void createMessageTable();

    @SqlQuery("Select * from message")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Message> getAllMessage();

    @SqlUpdate("insert into message(texte, idutilisateur), values (:texte, : idutilisateur)")
    @GetGeneratedKeys
    int addMessage(@Bind("texte") String texte,@Bind("idutilisateur") String idutilisateur);
}
