package com.thanmayee.restapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResource {

	private AlienRepository alienRepository = AlienRepository.getInstance();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // Supports XML & JSON
	public List<Alien> getAliens() {
		return alienRepository.getAliens();
	}

	@GET
	@Path("/alien/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // Supports XML & JSON
	public Alien getAlien(@PathParam("id") int id) {
		return alienRepository.getAlien(id);
	}

	@POST
	@Path("/alien")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // Accepts XML & JSON
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // Returns XML & JSON
	public Alien createAlien(Alien alien) {
		alienRepository.addAlien(alien);
		return alien;
	}

	@PUT
	@Path("/alien")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // Accepts XML & JSON
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // Returns XML & JSON
	public Alien updateAlien(Alien alien) {
		alienRepository.updateAlien(alien);
		return alien;
	}

	@DELETE
	@Path("/alien/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // Supports XML & JSON
	public String deleteAlien(@PathParam("id") int id) {
		alienRepository.deleteAlien(id);
		return "{\"message\": \"Alien deleted successfully\"}"; // JSON response by default
	}
}
