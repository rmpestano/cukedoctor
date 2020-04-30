package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.github.cukedoctor.util.Assert.hasText;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public String extractPattern(String pattern) {
        int indexOfOrder = name.indexOf(pattern);
        if (hasText(name) && indexOfOrder != -1) {
            return name.substring(indexOfOrder + pattern.length()).trim();
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isOrder() {
        return getOrder() != null;
    }

    public String getOrder() {
        return extractPattern("order-");
    }

    public boolean isDiscrete() {
        return extractPattern("asciidoc") != null;
    }
}