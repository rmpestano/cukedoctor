package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Embedding {
  private String data;
  private String mimeType;
  private String name;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @JsonProperty("mime_type")
  public String getMimeType() {
    return mimeType;
  }

  @JsonProperty("mime_type")
  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
