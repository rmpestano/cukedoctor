package com.github.cukedoctor.api.model;

import static com.github.cukedoctor.util.Assert.hasText;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

  private String name;

  public Tag() {}

  public Tag(String name) {
    this.name = name;
  }

  public Optional<String> extractPattern(String pattern) {
    int indexOfOrder = name.indexOf(pattern);
    if (hasText(name) && indexOfOrder != -1) {
      return Optional.of(name.substring(indexOfOrder + pattern.length()).trim());
    }

    return Optional.empty();
  }

  public String getName() {
    return name;
  }

  public boolean isOrder() {
    return getOrder().isPresent();
  }

  public Optional<String> getOrder() {
    return extractPattern("@order-");
  }

    public boolean isDiscrete() {
        return extractPattern("@asciidoc").isPresent();
    }

    public boolean isLanguage() {
        return getLanguage().isPresent();
    }

    public Optional<String> getLanguage() {
        return extractPattern("@language-");
    }
}

