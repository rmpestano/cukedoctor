package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.github.cukedoctor.util.Assert.hasText;

/**
 * Created by pestano on 19/02/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLanguage(){
        int indexOfLanguage = value.indexOf("language:");
        if(hasText(value) && indexOfLanguage != -1){
            return value.substring(indexOfLanguage+10).trim();
        }
        return null;
    }
}
