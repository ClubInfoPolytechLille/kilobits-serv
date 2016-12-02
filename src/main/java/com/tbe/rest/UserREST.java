package com.tbe.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.org.apache.regexp.internal.RE;
import com.tbe.database.UsersRequest;
import com.tbe.json.User;

@Path("/users")
public class UserREST {

    @POST
    public Response createUser(User user){
        System.out.println("Post User");
        String result = UsersRequest.addUser(user);
        if (result == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Entity already exist").build();
        }
        return Response.status(Response.Status.CREATED).entity("News Created")
                .build();
    }

    @POST("/connect")
    public Response connectUser(User user){
        System.out.println("Connect user");
        return UsersRequest.connectUser(user);
    }

}
