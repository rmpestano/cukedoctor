package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by rafael-pestano on 01/07/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocString {

  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
