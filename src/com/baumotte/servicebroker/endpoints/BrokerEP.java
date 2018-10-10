package com.baumotte.servicebroker.endpoints;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.baumotte.servicebroker.entities.Service;
import com.baumotte.servicebroker.entities.ServiceList;

@Path("/servicebroker")
public class BrokerEP {
	
	private final ServiceList services;
	
	public BrokerEP() {
		this.services = new ServiceList();
		services.addService(new Service("http://localhost:8080/ticketing/rest/tickets/", "ticketing_tickets"));
		services.addService(new Service("http://localhost:8080/dbconnector/rest/queries/ticketing", "dbconnector_ticketing"));
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getService(/*@PathParam("name") String name*/) {
		return Response.status(Response.Status.OK).entity(services.getService("dbconnector_ticketing")).build();
	}

}
