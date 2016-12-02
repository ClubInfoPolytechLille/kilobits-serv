package com.tbe.rest;

import com.tbe.database.EvenementRequest;
import com.tbe.json.Evenement;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/evenements")
public class EvenementREST {

	@GET
	public Evenement[] getAllEvenements() {
		System.out.println("GET ALL evenement");
		List<Evenement> evenements = EvenementRequest.getAllEvenement();
		Evenement[] p = new Evenement[evenements.size()];
		for (int i = 0; i < p.length; ++i) {
			p[i] = evenements.get(i);
		}
		return p;
	}

    @POST
    public Response postEvenement(Evenement evenement) {
        // System.out.println("Post Evenement\nidFonc:" + evenement.getIdFonctionnality() + "\nidMember" + evenement.getIdMember());
        int result = EvenementRequest.addEvenement(evenement.getLieu(), evenement.getDat(), evenement.getDescription());

        if (result == -1) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Evenement already exist").build();
        }
        return Response.status(Response.Status.CREATED)
                .entity("Evenement Created").build();
    }

}
