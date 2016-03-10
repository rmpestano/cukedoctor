package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.cukedoctor.util.Constants;

import java.util.List;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notEmpty;

/**
 * represents a scenario is most of the cases but can be also a background
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scenario {

	private String name;
	private String description;
	private String keyword;
	private List<Step> steps;
	private List<Tag> tags;
	private Type type;
	private List<Example> examples;


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

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	public List<Example> getExamples() {
		return examples;
	}

	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

	public boolean isBackground() {
		return Type.background.equals(type);
	}

	public Status getStatus() {
		if(hasSteps()){
			for (Step step : steps) {
				if (!step.isPassing()) {//if one or more steps are not passing, its considered a failed scenario
					return Status.failed;
				}
			}
		}
		return Status.passed;
	}


	public boolean hasSteps() {
		return steps != null && !steps.isEmpty();
	}

	public boolean hasExamples() {
		return examples != null && !examples.isEmpty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Scenario element = (Scenario) o;

		if (!name.equals(element.name)) return false;
		return type == element.type;

	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}

	public boolean hasTags() {
		return tags != null && !tags.isEmpty();
	}

	public boolean hasIgnoreDocsTag() {
		if(hasTags()){
			for (Tag tag : tags) {
				if(Constants.SKIP_DOCS.equalsIgnoreCase(tag.getName())){
					return true;
				}
			}
		}
		return false;
	}

	public Step getStepByName(String stepName) {
		if(hasText(stepName) && hasSteps()) {
			for (Step step : steps) {
				if (step.getName().trim().equals(stepName.trim())) {
					return step;
				}
			}
		}
		return null;
	}
}
