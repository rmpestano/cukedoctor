package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by pestano on 04/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Argument {

	private String val;

	public String getVal() {
		return val;
	}

}
