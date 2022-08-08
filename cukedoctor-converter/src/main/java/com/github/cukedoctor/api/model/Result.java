package com.github.cukedoctor.api.model;

import static com.github.cukedoctor.util.Constants.getProp;
import static com.github.cukedoctor.util.Constants.newLine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.cukedoctor.config.GlobalConfig;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

  private Status status;

  @JsonProperty("error_message")
  private String errorMessage;

  private Long duration;

  public Result() {}

  public Result(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Long getDuration() {
    return duration == null ? 0L : duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public String getErrorMessage() {
    if (errorMessage != null) {
      Integer errorMessageLength = getProp("ERROR_MESSAGE_SIZE", Integer.class);
      if (errorMessageLength == null) {
        errorMessageLength = GlobalConfig.getInstance().getLayoutConfig().getErrorMessageLength();
      }
      if (errorMessage.length() > errorMessageLength) {
        errorMessage = errorMessage.substring(0, errorMessageLength) + "..." + newLine();
      }
    }
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
