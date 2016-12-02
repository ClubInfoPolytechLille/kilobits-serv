package com.tbe.rest;

import com.tbe.database.LangueRequest;
import com.tbe.json.Langue;

import javax.ws.rs.*;
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

    @POST
    public Response postLangue(Langue langue) {
        // System.out.println("Post Langue\nidFonc:" + langue.getIdFonctionnality() + "\nidMember" + langue.getIdMember());
        int result = LangueRequest.addLangue(langue.getLangue());

        if (result == -1) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Langue already exist").build();
        }
        return Response.status(Response.Status.CREATED)
                .entity("Langue Created").build();
    }

}
