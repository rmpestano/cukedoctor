package com.github.cukedoctor.api.model;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.cukedoctor.api.ScenarioResults;
import com.github.cukedoctor.api.StepResults;
import com.github.cukedoctor.util.Constants;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature implements Comparable<Feature> {

  private String id;
  private String name;
  private String uri;
  private String description;
  private String keyword;
  private List<Scenario> elements = new ArrayList<>();
  private List<Scenario> scenarios = new ArrayList<>();
  private List<Tag> tags = new ArrayList<>();
  private StepResults stepResults;
  private ScenarioResults scenarioResults;
  private List<Comment> comments;
  @JsonIgnore private String language;

  @JsonIgnore private Integer order;

  @JsonIgnore
  private boolean
      backgroundRendered; // backgrounds runs for each scenario so we will render it only in the
  // first one

  public Feature() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUri() {
    return this.uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public boolean hasTags() {
    return notEmpty(tags);
  }

  public boolean hasScenarios() {
    return !elements.isEmpty();
  }

  public Status getStatus() {
    return notEmpty(scenarioResults.getFailedScenarios()) ? Status.failed : Status.passed;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public List<Scenario> getElements() {
    return elements;
  }

  public void setElements(List<Scenario> elements) {
    this.elements = elements;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public StepResults getStepResults() {
    return stepResults;
  }

  public ScenarioResults getScenarioResults() {
    return scenarioResults;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public boolean isBackgroundRendered() {
    return backgroundRendered;
  }

  public void setBackgroundRendered(boolean backgroundRendered) {
    this.backgroundRendered = backgroundRendered;
  }

  /**
   * @return total number of scenarios
   * @deprecated use {@link Feature#getScenarioResults()}
   */
  @Deprecated
  public Integer getNumberOfScenarios() {
    Integer result = 0;
    if (scenarios != null) {
      List<Scenario> elementList = new ArrayList<Scenario>();
      for (Scenario element : scenarios) {
        if (!element.hasExamples()) {
          elementList.add(element);
        }
      }
      result = elementList.size();
    }
    return result;
  }

  public Integer getNumberOfSteps() {
    return stepResults.getNumberOfSteps();
  }

  public Integer getNumberOfPasses() {
    return stepResults.getNumberOfPasses();
  }

  public Integer getNumberOfFailures() {
    return stepResults.getNumberOfFailures();
  }

  public Integer getNumberOfPending() {
    return stepResults.getNumberOfPending();
  }

  public Integer getNumberOfSkipped() {
    return stepResults.getNumberOfSkipped();
  }

  public Integer getNumberOfMissing() {
    return stepResults.getNumberOfMissing();
  }

  public Integer getNumberOfUndefined() {
    return stepResults.getNumberOfUndefined();
  }

  public String getDurationOfSteps() {
    return stepResults.getTotalDurationAsString();
  }

  public Integer getNumberOfScenariosPassed() {
    return scenarioResults.getNumberOfScenariosPassed();
  }

  public Integer getNumberOfScenariosFailed() {
    return scenarioResults.getNumberOfScenariosFailed();
  }

  public List<Scenario> getScenarios() {
    return scenarios; // scenario & scenario outline
  }

  public void initScenarios() {
    if (elements != null) {
      for (Scenario element : elements) {
        scenarios.add(element);
      }
    }
  }

  public void processSteps() {
    if (!isCucumberFeature()) {
      return;
    }
    List<Step> allSteps = new ArrayList<Step>();
    Map<Status, AtomicInteger> statusCounter = new HashMap<>();
    for (Status status : Status.values()) {
      statusCounter.put(status, new AtomicInteger(0));
    }
    List<Scenario> passedScenarios = new ArrayList<Scenario>();
    List<Scenario> failedScenarios = new ArrayList<Scenario>();
    long totalDuration = 0L;

    if (scenarios != null) {
      for (Scenario scenario : scenarios) {
        if (scenario.hasExamples()) {
          continue;
        }
        calculateScenarioStats(passedScenarios, failedScenarios, scenario);
        if (scenario.hasSteps()) {
          for (Step step : scenario.getSteps()) {
            allSteps.add(step);
            statusCounter.get(step.getStatus()).incrementAndGet();
            totalDuration += step.getDuration();
          }
        }
      }
    }
    scenarioResults = new ScenarioResults(passedScenarios, failedScenarios);
    stepResults = new StepResults(allSteps, statusCounter, totalDuration);
  }

  private void calculateScenarioStats(
      List<Scenario> passedScenarios, List<Scenario> failedScenarios, Scenario element) {
    if (element.isBackground()) {
      return; // background scenarios are not considered as scenrario
    }
    if (element.getStatus() == Status.passed) {
      passedScenarios.add(element);
    } else if (element.getStatus() == Status.failed) {
      failedScenarios.add(element);
    }
  }

  public boolean isCucumberFeature() {
    return this.getName() != null
        && this.getKeyword() != null
        && (this.elements != null && !this.elements.isEmpty());
  }

  public String getLanguage() {
    if (language == null && comments != null) {
      for (Comment comment : comments) {
        final Optional<String> lang = comment.getLanguage();
        if (lang.isPresent() && hasText(lang.get())) {
          language = lang.get();
        }
      }
    }
    if (language == null) {
      this.language = "";
    }

    return language;
  }

  public int getOrder() {
    if (order == null && comments != null) {
      for (Comment comment : comments) {
        trySetOrder(comment.getOrder(), "comment");
      }
    }

    if (order == null && hasTags()) {
      for (Tag tag : getTags()) {
        trySetOrder(tag.getOrder(), "tag");
      }
    }

    if (order == null) {
      this.order = Integer.MAX_VALUE;
    }

    return order;
  }

  private void trySetOrder(Optional<String> order, String source) {
    if (order.isPresent() && hasText(order.get())) {
      try {
        this.order = Integer.parseInt(order.get());
      } catch (Exception e) {
        Logger.getLogger(getClass().getName())
            .warning(
                String.format(
                    "Could not get order of feature %s from %s cause: %s",
                    name, source, e.getMessage()));
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Feature feature = (Feature) o;

    return !(id != null ? !id.equals(feature.id) : feature.id != null);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 42;
  }

  public boolean hasIgnoreDocsTag() {
    if (hasTags()) {
      for (Tag tag : tags) {
        if (Constants.SKIP_DOCS.equalsIgnoreCase(tag.getName())) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int compareTo(Feature other) {
    int result = Integer.compare(getOrder(), other.getOrder());

    // same order or no-order use name
    if (result == 0) {
      result = name.compareTo(other.getName());
    }

    return result;
  }

  public Scenario getScenarioByName(String name) {

    if (hasText(name) && hasScenarios()) {
      for (Scenario scenario : scenarios) {
        if (hasText(scenario.getName()) && scenario.getName().trim().equals(name)) {
          return scenario;
        }
      }
    }
    return null;
  }

  public boolean hasTag(String pattern) {
    return extractTag(pattern).isPresent();
  }

  public Optional<String> extractTag(String pattern) {
    if (!hasTags()) {
      return Optional.empty();
    }
    return getTags().stream()
        .map(tag -> tag.extractPattern(pattern))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .findFirst();
  }
}
