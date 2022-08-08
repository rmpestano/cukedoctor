package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/** Created by rafael-pestano on 01/07/2015. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocString {

  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("content_type")
  private String contentType;

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String value) {
    this.contentType = value;
  }

  public boolean isDiscrete() {
    return Objects.equals(contentType, "asciidoc");
  }

  @Override
  public String toString() {
    return value;
  }
}
