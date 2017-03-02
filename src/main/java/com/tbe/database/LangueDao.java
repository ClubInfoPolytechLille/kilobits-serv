package com.tbe.database;

import com.tbe.json.Langue;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface LangueDao {

	String strCreateLangueTable = "Create table if not exists Langue ("
			+ "Id Integer primary key auto_increment, "
			+ "Langue varchar(20) NOT NULL DEFAULT 'FR');";

	@SqlUpdate(strCreateLangueTable)
    void createLangueTable();

	@SqlQuery("Select * from langue")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Langue> getAllLangue();

	@SqlUpdate("insert into langue (langue) values (:langue)")
    @GetGeneratedKeys
    int addLangue(@Bind("langue") String langue);

}
