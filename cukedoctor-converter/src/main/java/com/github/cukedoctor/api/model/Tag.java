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

    private static String extractPattern(String pattern, String text) {
        int indexOfOrder = text.indexOf(pattern);
        if (hasText(text) && indexOfOrder != -1) {
            return text.substring(indexOfOrder + pattern.length()).trim();
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
        return extractPattern("order-", name);
    }

    public boolean isDiscrete() {
        return extractPattern("cukedoctor-discrete", name) != null;
    }
}