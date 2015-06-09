package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("line")
public class Row {

	private String[] cells;

	public Row() {

	}

	public String[] getCells() {
		return cells;
	}
}

