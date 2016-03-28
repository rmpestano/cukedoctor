package com.github.cukedoctor.util.builder;

import java.util.ArrayList;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Match;
import com.github.cukedoctor.api.model.Result;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Type;

/**
 * Created by pestano on 04/06/15.
 */
public class FeatureBuilder {

	private Feature feature;
	private static FeatureBuilder instance;


	private FeatureBuilder(Feature feature) {
		this.feature = feature;
	}

	private Feature getFeature() {
		return feature;
	}

	public static synchronized FeatureBuilder instance() {
		instance = new FeatureBuilder(new Feature());
		return instance;
	}

	public static synchronized FeatureBuilder instance(Feature feature) {
		instance = new FeatureBuilder(feature);
		return instance;
	}


	public FeatureBuilder id(String id) {
		feature.setId(id);
		return instance;
	}

	public FeatureBuilder name(String name) {
		feature.setName(name);
		return instance;
	}

	public FeatureBuilder uri(String uri) {
		feature.setUri(uri);
		return instance;
	}

	public FeatureBuilder description(String desc) {
		feature.setDescription(desc);
		return instance;
	}

	public FeatureBuilder scenario(Scenario scenario) {
		if (feature.getElements() == null) {
			feature.setElements(new ArrayList<Scenario>());
		}
		feature.getElements().add(scenario);
		return instance;
	}

	public FeatureBuilder keyword(String keyword) {
		feature.setKeyword(keyword);
		return instance;
	}

	public Feature build() {
		feature.initScenarios();
		return instance.getFeature();
	}

	public Feature aFeatureWithTwoScenarios() {

		final Feature feature = FeatureBuilder.instance().description("Feature description").
				scenario(ScenarioBuilder.instance().name("scenario 1").description("description")
						.keyword("Scenario").type(Type.scenario).build()).
				scenario(ScenarioBuilder.instance().name("scenario 2").description("description 2")
						.keyword("Scenario").type(Type.scenario).build()).
				name("Feature name").build();

		return feature;
	}

	public Feature aFeatureWithOneScenarioWithOnePassingStep() {

		final Feature feature = FeatureBuilder.instance().description("Feature description").
				scenario(ScenarioBuilder.instance().name("scenario").description("description")
						.keyword("Scenario").type(Type.scenario).
								step(StepBuilder.instance().name("passing step")
										.result(new Result(Status.passed))
										.keyword("Given").build()). //step
								build()).//build scenario
				name("Feature name").build();

		return feature;
	}

	public Feature aFeatureWithOneScenarioWithOnePassingAndOneFailingStep() {

		final Feature feature = FeatureBuilder.instance().description("Feature description").
				scenario(ScenarioBuilder.instance().name("scenario").description("description")
						.keyword("Scenario").type(Type.scenario).
								step(StepBuilder.instance().name("passing step")
										.result(new Result(Status.passed))
										.match(new Match("match 1"))
										.keyword("Given").build()).
								step(StepBuilder.instance().name("failing step")
										.result(new Result(Status.failed))
										.match(new Match("match 2"))
										.keyword("When").build()).
								build()).//build scenario
				name("Feature name").build();

		return feature;
	}

	public Feature aFeatureWithOneScenarioWithMultipleSteps() {

		final Feature feature = FeatureBuilder.instance().description("Feature description").
				scenario(ScenarioBuilder.instance().name("scenario").description("description")
						.keyword("Scenario").type(Type.scenario).
								step(StepBuilder.instance().name("passing step")
										.result(new Result(Status.passed))
										.match(new Match("match 1"))
										.keyword("Given").build()).
								step(StepBuilder.instance().name("failing step")
										.result(new Result(Status.failed))
										.match(new Match("match 2"))
										.keyword("When").build()).
								step(StepBuilder.instance().name("pending step")
										.result(new Result(Status.pending))
										.match(new Match("match 3"))
										.keyword("When").build()).
								step(StepBuilder.instance().name("missing step")
										.result(new Result(Status.missing))
										.match(new Match("match 4"))
										.keyword("When").build()).
								step(StepBuilder.instance().name("undefined step")
										.result(new Result(Status.undefined))
										.match(new Match("match 5"))
										.keyword("When").build()).
								step(StepBuilder.instance().name("skipped step")
										.result(new Result(Status.skipped))
										.match(new Match("match 6"))
										.keyword("Then").build()).
								build()).
				name("Feature name").build();

		return feature;
	}

	public Feature aFeatureWithMultipleScenariosAndSteps() {
		Scenario scenario1 = ScenarioBuilder.instance().name("scenario").description("description")
				.keyword("Scenario").type(Type.scenario).
						step(StepBuilder.instance().name("passing step")
								.result(new Result(Status.passed))
								.match(new Match("match 1"))
								.keyword("Given").build()).
						step(StepBuilder.instance().name("failing step")
								.result(new Result(Status.failed))
								.match(new Match("match 2"))
								.keyword("When").build()).
						build();

		Scenario scenario2 = ScenarioBuilder.instance().name("scenario").description("description")
				.keyword("Scenario").type(Type.scenario).
						step(StepBuilder.instance().name("skipped step")
								.result(new Result(Status.skipped))
								.match(new Match("match 6"))
								.keyword("Then").build()). //skipped step
						build();

		Scenario scenario3 = ScenarioBuilder.instance().name("scenario").description("description")
				.keyword("Scenario").type(Type.scenario).
						step(StepBuilder.instance().name("undefined step")
								.result(new Result(Status.undefined))
								.match(new Match("match1"))
								.keyword("Given").build()).
						build();

		final Feature feature = FeatureBuilder.instance().description("Feature description").
				scenario(scenario1).
				scenario(scenario2).
				scenario(scenario3).
				name("Feature name").build();
		return feature;

	}
}
