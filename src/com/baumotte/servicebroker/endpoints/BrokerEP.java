package com.baumotte.servicebroker.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		services.addService(new Service("http://localhost:8081/ticketing/rest/tickets", "ticketing_tickets"));
		services.addService(new Service("http://localhost:8081/dbconnector/rest/queries/ticketing", "dbconnector_ticketing"));
	}
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getService(@PathParam("name") String name) {
		return Response.status(Response.Status.OK).entity(services.getService(name)).build();
	}

}
