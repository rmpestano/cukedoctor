package com.github.cukedoctor.util.builder;

import com.github.cukedoctor.api.model.Element;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.api.model.Type;

import java.util.ArrayList;

/**
 * Created by pestano on 04/06/15.
 */
public class ScenarioBuilder {

	private Element scenario;
	private static ScenarioBuilder instance;


	private ScenarioBuilder(Element scenario) {
		this.scenario = scenario;
	}

	private Element getScenario() {
		return scenario;
	}

	public static synchronized ScenarioBuilder instance() {
		instance = new ScenarioBuilder(new Element());
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


	public Element build() {
		return scenario;
	}
}
