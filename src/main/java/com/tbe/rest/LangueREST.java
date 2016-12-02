package com.tbe.rest;

import com.tbe.database.MembersRequest;
import com.tbe.database.LangueRequest;
import com.tbe.json.Fonctionnality;
import com.tbe.json.Member;
import com.tbe.json.Langue;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/langues")
public class LangueREST {

	@GET
	public Langue[] getAllLangues() {
		System.out.println("GET ALL langue");
		List<Langue> langues = LangueRequest.getAllLangue();
		Langue[] p = new Langue[langues.size()];
		for (int i = 0; i < p.length; ++i) {
			p[i] = langues.get(i);
		}
		return p;
	}

}
