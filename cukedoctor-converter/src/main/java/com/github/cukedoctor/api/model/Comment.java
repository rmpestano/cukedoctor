package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Optional;

import static com.github.cukedoctor.util.Assert.hasText;

/**
 * Created by pestano on 19/02/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    private String value;
    private Integer line;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Optional<String> getLanguage() {
        return extractPattern("language: ");
    }

    protected Optional<String> extractPattern(String pattern) {
        int indexOfLanguage = value.indexOf(pattern);
        if (hasText(value) && indexOfLanguage != -1) {
            return Optional.of(value.substring(indexOfLanguage + pattern.length()).trim());
        }

        return Optional.empty();
    }

    public Optional<String> getOrder() {
        return extractPattern("order: ");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return value;
    }
}
