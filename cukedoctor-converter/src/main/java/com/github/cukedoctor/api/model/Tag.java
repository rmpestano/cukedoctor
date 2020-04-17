package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.github.cukedoctor.util.Assert.hasText;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

	private String name;

	public Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getOrder(){
		int indexOfOrder = name.indexOf("order-");
		if(hasText(name) && indexOfOrder != -1){
			return name.substring(indexOfOrder+6).trim();
		}
		return null;
	}
}
