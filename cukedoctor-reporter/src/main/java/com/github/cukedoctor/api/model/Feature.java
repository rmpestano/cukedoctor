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
	private List<Scenario> elements = new ArrayList<>();
	private List<Scenario> scenarios = new ArrayList<>();
	private List<Tag> tags = new ArrayList<>();
	private StepResults stepResults;
	private ScenarioResults scenarioResults;

	public Feature() {

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
		return tags != null && !tags.isEmpty();
	}

	public boolean hasScenarios() {
		return !elements.isEmpty();
	}

	public Status getStatus() {
		return !scenarioResults.getFailedScenarios().isEmpty() ? Status.failed : Status.passed;
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


	public Integer getNumberOfScenarios() {
		Integer result = 0;
		if (elements != null) {
			List<Scenario> elementList = new ArrayList<Scenario>();
			for (Scenario element : elements) {
				if (!element.isBackground()) {
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

	public List<Scenario> getScenarios(){
		return scenarios;//scenario & scenario outline
	}

	public void initScenarios() {
		if(elements != null){
			for (Scenario element : elements) {
				if(!element.isBackground()){
					scenarios.add(element);
				}
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
			statusCounter.put(status,new AtomicInteger(0));
		}
		List<Scenario> passedScenarios = new ArrayList<Scenario>();
		List<Scenario> failedScenarios = new ArrayList<Scenario>();
		long totalDuration = 0L;

		if (scenarios != null) {
			for (Scenario scenario : scenarios) {
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

	private void calculateScenarioStats(List<Scenario> passedScenarios, List<Scenario> failedScenarios, Scenario element) {
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
		return id.hashCode();
	}
}
