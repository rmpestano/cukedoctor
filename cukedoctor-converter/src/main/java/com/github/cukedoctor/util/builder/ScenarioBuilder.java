package com.github.cukedoctor.util.builder;

import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.api.model.Type;

import java.util.ArrayList;

/**
 * Created by pestano on 04/06/15.
 */
public class ScenarioBuilder {

	private Scenario scenario;
	private static ScenarioBuilder instance;


	private ScenarioBuilder(Scenario scenario) {
		this.scenario = scenario;
	}

	private Scenario getScenario() {
		return scenario;
	}

	public static synchronized ScenarioBuilder instance() {
		instance = new ScenarioBuilder(new Scenario());
		return instance;
	}

	public static synchronized ScenarioBuilder instance(Scenario scenario) {
		instance = new ScenarioBuilder(scenario);
		return instance;

	}


	public ScenarioBuilder name(String name) {
		instance.getScenario().setName(name);
		return instance;
	}


	public ScenarioBuilder type(Type type) {
		instance.getScenario().setType(type);
		return instance;
	}

	public ScenarioBuilder description(String desc) {
		instance.getScenario().setDescription(desc);
		return instance;
	}

	public ScenarioBuilder keyword(String keyword) {
		instance.getScenario().setKeyword(keyword);
		return instance;
	}

	public ScenarioBuilder step(Step step) {
		if(instance.getScenario().getSteps() == null){
			instance.getScenario().setSteps(new ArrayList<Step>());
		}

		if(!instance.getScenario().getSteps().contains(step)){
			instance.getScenario().getSteps().add(step);
		}
		return instance;
	}

	public ScenarioBuilder tag(Tag tag) {
		if(instance.getScenario().getTags() == null){
			instance.getScenario().setTags(new ArrayList<Tag>());
		}

		if(!instance.getScenario().getTags().contains(tag)){
			instance.getScenario().getTags().add(tag);
		}
		return instance;
	}


	public Scenario build() {
		return scenario;
	}
}
