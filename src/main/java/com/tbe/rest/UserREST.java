package com.tbe.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tbe.database.UsersRequest;
import com.tbe.json.User;

@Path("/users")
public class UserREST {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{username}&{userpassword}")
	public User getUser(@PathParam("username") String username,
			@PathParam("userpassword") String password) {
		username = username.toLowerCase();
		System.out.println("GET USER " + username + " : " + password);
		return UsersRequest.getUser(username, password);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{username}")
	public User getUser(@PathParam("username") String username) {
		username = username.toLowerCase();
		System.out.println("GET USER " + username);
		return UsersRequest.getUser(username);
	}

	@PUT
	@Path("/{username}")
	public Response update(User user, @PathParam("username") String username) {
		int i = UsersRequest.update(user, username);
		if (i > 0) {
			return Response.status(Response.Status.OK).entity("update").build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("User already exist or no exists").build();
		}

	}

	@DELETE
	@Path("/{username}")
	public Response delete(@PathParam("username") String username) {
		int i = UsersRequest.delete(username);
		if (i > 0) {
			return Response.status(Response.Status.OK).entity("delete").build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("can't delete users : " + username).build();
		}
	}
}
