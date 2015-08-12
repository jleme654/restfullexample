package com.mkyong.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Track;

@Path("/json/metallica")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}
	
	@GET
	@Path("/getBand")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getBandTrackInJSON(@QueryParam("band") String singer) {

		Track track = new Track();
		track.setTitle("Com Deus");
		track.setSinger(singer);

		return track;

	}
	
	@GET
	@Path("/getBandTitle")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getBandTitleTrackInJSON(@QueryParam("title") String title, @QueryParam("band") String singer) {

		Track track = new Track();
		track.setTitle(title);
		track.setSinger(singer);

		return track;

	}
	
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Track> getAllTrackInJSON() {
		ArrayList<Track> lista = new ArrayList<Track>();
		
		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");
		lista.add(track);
		
		track.setTitle("Deus me ama");
		track.setSinger("Thalles");
		lista.add(track);
		
		track.setTitle("Eu nasci de novo");
		track.setSinger("Andre Valadao");
		lista.add(track);

		return lista;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
	
}