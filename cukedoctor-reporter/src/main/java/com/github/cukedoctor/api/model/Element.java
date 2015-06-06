package com.github.cukedoctor.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Element {

	private String name;
	private String description;
	private String keyword;
	private List<Step> steps;
	private List<Tag> tags;
	private Type type;


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

	public boolean isBackground() {
		return Type.background.equals(type);
	}

	public Status getStatus() {

		for (Step step : steps) {
			if (!step.isPassing()) {//if one or more steps are not passing, its considered a failed scenario
				return Status.failed;
			}
		}
		return Status.passed;
	}


	public boolean hasSteps() {
		return steps != null && !steps.isEmpty();
	}
}
