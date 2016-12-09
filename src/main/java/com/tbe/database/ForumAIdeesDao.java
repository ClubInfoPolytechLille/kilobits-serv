package com.tbe.database;

import com.tbe.json.ForumAIdees;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ForumAIdeesDao {

    String strCreateForumAIdeesTable = "Create table if not exists ForumAIdees ("
            + "Id integer primary key autoincrement,"
            + "Nom varchar(20) NOT NULL,"
            + "Description varchar(500) NOT NULL);";

    @SqlUpdate(strCreateForumAIdeesTable)
    void createForumAIdeesTable();

    @SqlQuery("Select * from forumAIdees")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<ForumAIdees> getAllForumAIdees();

    @SqlUpdate("insert into forumAIdees (nom, description) values (:nom, :description)")
    @GetGeneratedKeys
    int addForumAIdees(@Bind("nom") String nom,@Bind("description") String description);
}
