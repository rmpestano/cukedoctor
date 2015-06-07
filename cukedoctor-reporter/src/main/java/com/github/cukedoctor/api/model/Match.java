package com.github.cukedoctor.api.model;

import java.util.List;

public class Match {

	private String location;
	private List<Argument> arguments;

	public Match() {
	}

	public Match(String location) {
		this.location = location;
	}

	public List<Argument> getArguments() {
		return arguments;
	}

	public String getLocation() {
		return location;
	}

}
