package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.cukedoctor.config.GlobalConfig;

import static com.github.cukedoctor.util.Constants.getProp;
import static com.github.cukedoctor.util.Constants.newLine;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private Status status;
    private String error_message;
    private Long duration;

    public Result() {

    }

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
        if (error_message != null) {
            Integer errorMessageLength = getProp("ERROR_MESSAGE_SIZE", Integer.class);
            if (errorMessageLength == null) {
                errorMessageLength = GlobalConfig.getInstance().getLayoutConfig().getErrorMessageLength();
            }
            if (error_message.length() > errorMessageLength) {
                error_message = error_message.substring(0, errorMessageLength) + "..." + newLine();
            }
        }
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
