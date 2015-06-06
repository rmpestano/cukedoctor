package com.github.cukedoctor.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.cukedoctor.api.ScenarioResults;
import com.github.cukedoctor.api.StepResults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

	private String id;
	private String name;
	private String uri;
	private String description;
	private String keyword;
	private List<Element> elements;
	private List<Tag> tags;
	private StepResults stepResults;
	private ScenarioResults scenarioResults;

	public Feature() {
		processSteps();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUri() {
		return this.uri;
	}

	public boolean hasTags() {
		return !tags.isEmpty();
	}

	public boolean hasScenarios() {
		return !elements.isEmpty();
	}

	public Status getStatus() {
		return scenarioResults.getFailedScenarios().isEmpty() ? Status.failed : Status.passed;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUri(String uri) {
		this.uri = uri;
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

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
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


	public int getNumberOfScenarios() {
		int result = 0;
		if (elements != null) {
			List<Element> elementList = new ArrayList<Element>();
			for (Element element : elements) {
				if (!element.isBackground()) {
					elementList.add(element);
				}
			}
			result = elementList.size();
		}
		return result;
	}

	public int getNumberOfSteps() {
		return stepResults.getNumberOfSteps();
	}

	public int getNumberOfPasses() {
		return stepResults.getNumberOfPasses();
	}

	public int getNumberOfFailures() {
		return stepResults.getNumberOfFailures();
	}

	public int getNumberOfPending() {
		return stepResults.getNumberOfPending();
	}

	public int getNumberOfSkipped() {
		return stepResults.getNumberOfSkipped();
	}

	public int getNumberOfMissing() {
		return stepResults.getNumberOfMissing();
	}

	public int getNumberOfUndefined() {
		return stepResults.getNumberOfUndefined();
	}

	public String getDurationOfSteps() {
		return stepResults.getTotalDurationAsString();
	}

	public int getNumberOfScenariosPassed() {
		return scenarioResults.getNumberOfScenariosPassed();
	}

	public int getNumberOfScenariosFailed() {
		return scenarioResults.getNumberOfScenariosFailed();
	}

	public void processSteps() {
		if (!isCucumberFeature()) {
			return;
		}
		List<Step> allSteps = new ArrayList<Step>();
		Map<Status, AtomicInteger> statusCounter = new HashMap<>();
		List<Element> passedScenarios = new ArrayList<Element>();
		List<Element> failedScenarios = new ArrayList<Element>();
		long totalDuration = 0L;

		if (elements != null) {
			for (Element element : elements) {
				calculateScenarioStats(passedScenarios, failedScenarios, element);
				if (element.hasSteps()) {
					for (Step step : element.getSteps()) {
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

	private void calculateScenarioStats(List<Element> passedScenarios, List<Element> failedScenarios, Element element) {
		if (!element.isBackground()) {
			if (element.getStatus() == Status.passed) {
				passedScenarios.add(element);
			} else if (element.getStatus() == Status.failed) {
				failedScenarios.add(element);
			}
		}
	}


	public boolean isCucumberFeature() {
		return this.getName() != null && this.getKeyword() != null && (this.elements != null && !this.elements.isEmpty());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Feature feature = (Feature) o;

		if (!name.equals(feature.name)) return false;
		return !(id != null ? !id.equals(feature.id) : feature.id != null);

	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + (uri != null ? uri.hashCode() : 0);
		return result;
	}


}
