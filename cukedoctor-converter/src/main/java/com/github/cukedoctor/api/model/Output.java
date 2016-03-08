package com.github.cukedoctor.api.model;

/**
 * Created by rafael-pestano on 08/03/2016.
 */
public class Output {

  private String value;

  public Output(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
