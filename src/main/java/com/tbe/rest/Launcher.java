package com.tbe.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.tbe.database.DataBase;

@ApplicationPath("/v1/")
public class Launcher extends Application {

	public Set<Class<?>> getClasses() {
		new DataBase();
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(UserREST.class);

        s.add(LangueREST.class);

		return s;
	}
}