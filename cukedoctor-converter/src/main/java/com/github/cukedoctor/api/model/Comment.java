package com.github.cukedoctor.api.model;

import static com.github.cukedoctor.util.Assert.hasText;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Optional;

/** Created by pestano on 19/02/16. */
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
    return value;
  }
}
