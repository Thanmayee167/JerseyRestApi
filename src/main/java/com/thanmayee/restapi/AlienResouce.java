package com.thanmayee.restapi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResouce {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAlien() {

		Alien alien = new Alien();
		alien.setId(1);
		alien.setName("Sai");
		alien.setColour("Green");

		Alien alien1 = new Alien();
		alien1.setId(2);
		alien1.setName("Thanmayee");
		alien1.setColour("yellow");

		return List.of(alien, alien1);
	}
}
