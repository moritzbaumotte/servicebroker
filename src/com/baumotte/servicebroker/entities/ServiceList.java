package com.baumotte.servicebroker.entities;

import java.util.ArrayList;

public class ServiceList {
	
	private final ArrayList<Service> services;
	
	public ServiceList() {
		this.services = new ArrayList<>();
	}
	
	public ServiceList(ArrayList<Service> services) {
		this.services = services;
	}
	
	public Service getService(String name) {
		//todo: add check if the service is available and if not, return the failover service
		for(Service s : services)
			if(s.getName().equals(name))
				return s;
		return null;
	}
	
	public void addService(Service service) {
		this.services.add(service);
	}

}
