package com.baumotte.servicebroker.entities;

public class Service {
	
	private final String URL;
	private final String name;
	
	public Service(String URL, String name) {
		this.URL = URL;
		this.name = name;
	}

	public String getURL() {
		return URL;
	}

	public String getName() {
		return name;
	}

}
