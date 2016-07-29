package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by pestano on 21/06/15.
 */
@JsonIgnoreProperties(value = {"description","keyword","line","id","comments"})
public class Example {

	private String name;
	private Row[] rows;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Row[] getRows() {
		return rows;
	}

	public void setRows(Row[] rows) {
		this.rows = rows;
	}

}
