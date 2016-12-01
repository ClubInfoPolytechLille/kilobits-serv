package com.tbe.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tbe.database.MembersRequest;
import com.tbe.database.ProjectsRequest;
import com.tbe.database.UsersRequest;
import com.tbe.json.Chat;
import com.tbe.json.Project;
import com.tbe.json.Salon;

@Path("/projects")
public class ProjectsREST {

	@GET
	public Project[] getAllProjects() {
		System.out.println("GET ALL PROJECTS");
		List<Project> projects = ProjectsRequest.getAllProject();
		Project[] p = new Project[projects.size()];
		for (int i = 0; i < p.length; ++i) {
			p[i] = projects.get(i);
		}
		return p;
	}
	
	@GET
	@Path("/url/{URLproject}")
	public int getIdProjects(@PathParam("URLproject") String url) {
		System.out.println("GET ID PROJECTS");
		return ProjectsRequest.getId(url); 
	}

	@GET
	@Path("/{idproject}")
	public Project getProject(@PathParam("idproject") int id) {
		System.out.println("GET Project " + id);
		return ProjectsRequest.getProject(id);
	}
	
	@DELETE
	@Path("/{idProject}")
	public Response delete(@PathParam("idProject") int idProject){
		int i =  ProjectsRequest.delete(idProject);
		if (i>0){
			return Response.status(Response.Status.OK)
					.entity("update").build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Project no exist").build();
		}
	}
	
	@PUT
	public Response updateProject(Project project){
		System.out.println("Update Project : \nid: " + project.getId() +"\nname: " + project.getName() + "\npunchline: " + project.getDescription() + "\ndescription: " + project.getDescription() + "\nurl: " + project.getUrl());
		int i =  ProjectsRequest.update(project.getId(), project.getName(), project.getPunchline(), project.getDescription(), project.getUrl());
		if (i>0){
			return Response.status(Response.Status.OK)
					.entity("update").build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Project no exist").build();
		}
	}
}
