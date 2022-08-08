package com.github.cukedoctor.util;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Match;
import com.github.cukedoctor.api.model.Result;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Type;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import com.github.cukedoctor.util.builder.StepBuilder;

public final class Features {
  private Features() {}

  public static Feature aFeatureWithTwoScenarios() {

    return FeatureBuilder.instance()
        .description("Feature description")
        .scenario(
            ScenarioBuilder.instance()
                .name("scenario 1")
                .description("description")
                .keyword("Scenario")
                .type(Type.scenario)
                .build())
        .scenario(
            ScenarioBuilder.instance()
                .name("scenario 2")
                .description("description 2")
                .keyword("Scenario")
                .type(Type.scenario)
                .build())
        .name("Feature name")
        .build();
  }

  public static Feature aFeatureWithOneScenarioWithOnePassingStep() {

    return FeatureBuilder.instance()
        .description("Feature description")
        .scenario(
            ScenarioBuilder.instance()
                .name("scenario")
                .description("description")
                .keyword("Scenario")
                .type(Type.scenario)
                .step(
                    StepBuilder.instance()
                        .name("passing step")
                        .result(new Result(Status.passed))
                        .keyword("Given")
                        .build())
                . // step
                build())
        . // build scenario
        name("Feature name")
        .build();
  }

  public static Feature aFeatureWithOneScenarioWithOnePassingAndOneFailingStep() {

    return FeatureBuilder.instance()
        .description("Feature description")
        .scenario(
            ScenarioBuilder.instance()
                .name("scenario")
                .description("description")
                .keyword("Scenario")
                .type(Type.scenario)
                .step(
                    StepBuilder.instance()
                        .name("passing step")
                        .result(new Result(Status.passed))
                        .match(new Match("match 1"))
                        .keyword("Given")
                        .build())
                .step(
                    StepBuilder.instance()
                        .name("failing step")
                        .result(new Result(Status.failed))
                        .match(new Match("match 2"))
                        .keyword("When")
                        .build())
                .build())
        . // build scenario
        name("Feature name")
        .build();
  }

  public static Feature aFeatureWithOneScenarioWithMultipleSteps() {

    return FeatureBuilder.instance()
        .description("Feature description")
        .scenario(
            ScenarioBuilder.instance()
                .name("scenario")
                .description("description")
                .keyword("Scenario")
                .type(Type.scenario)
                .step(
                    StepBuilder.instance()
                        .name("passing step")
                        .result(new Result(Status.passed))
                        .match(new Match("match 1"))
                        .keyword("Given")
                        .build())
                .step(
                    StepBuilder.instance()
                        .name("failing step")
                        .result(new Result(Status.failed))
                        .match(new Match("match 2"))
                        .keyword("When")
                        .build())
                .step(
                    StepBuilder.instance()
                        .name("pending step")
                        .result(new Result(Status.pending))
                        .match(new Match("match 3"))
                        .keyword("When")
                        .build())
                .step(
                    StepBuilder.instance()
                        .name("missing step")
                        .result(new Result(Status.missing))
                        .match(new Match("match 4"))
                        .keyword("When")
                        .build())
                .step(
                    StepBuilder.instance()
                        .name("undefined step")
                        .result(new Result(Status.undefined))
                        .match(new Match("match 5"))
                        .keyword("When")
                        .build())
                .step(
                    StepBuilder.instance()
                        .name("skipped step")
                        .result(new Result(Status.skipped))
                        .match(new Match("match 6"))
                        .keyword("Then")
                        .build())
                .build())
        .name("Feature name")
        .build();
  }

  public static Feature aFeatureWithMultipleScenariosAndSteps() {
    Scenario scenario1 =
        ScenarioBuilder.instance()
            .name("scenario")
            .description("description")
            .keyword("Scenario")
            .type(Type.scenario)
            .step(
                StepBuilder.instance()
                    .name("passing step")
                    .result(new Result(Status.passed))
                    .match(new Match("match 1"))
                    .keyword("Given")
                    .build())
            .step(
                StepBuilder.instance()
                    .name("failing step")
                    .result(new Result(Status.failed))
                    .match(new Match("match 2"))
                    .keyword("When")
                    .build())
            .build();

    Scenario scenario2 =
        ScenarioBuilder.instance()
            .name("scenario")
            .description("description")
            .keyword("Scenario")
            .type(Type.scenario)
            .step(
                StepBuilder.instance()
                    .name("skipped step")
                    .result(new Result(Status.skipped))
                    .match(new Match("match 6"))
                    .keyword("Then")
                    .build())
            . // skipped step
            build();

    Scenario scenario3 =
        ScenarioBuilder.instance()
            .name("scenario")
            .description("description")
            .keyword("Scenario")
            .type(Type.scenario)
            .step(
                StepBuilder.instance()
                    .name("undefined step")
                    .result(new Result(Status.undefined))
                    .match(new Match("match1"))
                    .keyword("Given")
                    .build())
            .build();

    return FeatureBuilder.instance()
        .description("Feature description")
        .scenario(scenario1)
        .scenario(scenario2)
        .scenario(scenario3)
        .name("Feature name")
        .build();
  }

  public static Feature aFeatureWithNoScenarios() {
    return FeatureBuilder.instance()
        .description("Feature description")
        .name("Feature name")
        .build();
  }
}
