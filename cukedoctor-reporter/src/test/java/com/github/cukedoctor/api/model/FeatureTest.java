package com.github.cukedoctor.api.model;

import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import com.github.cukedoctor.util.builder.StepBuilder;
import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by pestano on 06/06/15.
 */
@RunWith(JUnit4.class)
public class FeatureTest {

	Feature feature;

	@Before
	public void fixture() {
		Step step1 = StepBuilder.instance().match(new Match("/match"))
				.name("my step").status(Status.passed).build();
		Step step2 = StepBuilder.instance().match(new Match("/match2"))
				.name("my step 2").status(Status.passed).build();

		Step failedStep = StepBuilder.instance().match(new Match("/match2"))
				.name("my step 2").status(Status.failed).build();


		Element passingScenario = ScenarioBuilder.instance().name("scenario 1")
				.type(Type.scenario)
				.step(step1).step(step2).build();

		Element failingScenario = ScenarioBuilder.instance().name("scenario 2")
				.type(Type.scenario)
				.step(step1).step(step2).step(failedStep).build();

		feature = FeatureBuilder.instance().id("id").name("feature").keyword("keyword").
				scenario(passingScenario).scenario(failingScenario).build();

	}

	@Test
	public void shouldProcessSteps() {
		feature.processSteps();
		assertThat(feature.getNumberOfScenarios()).isEqualTo(2);
		assertThat(feature.getNumberOfSteps()).isEqualTo(5); //2 steps in scenario 1 and 3 in scenario 2
		assertThat(feature.getStatus()).isEqualTo(Status.failed);
		assertThat(feature.getNumberOfFailures()).isEqualTo(1); //1 in scenario 2
		assertThat(feature.getNumberOfPasses()).isEqualTo(4);//2 passes in each scenario
		assertThat(feature.getNumberOfPending()).isEqualTo(0);
		assertThat(feature.getNumberOfSkipped()).isEqualTo(0);
	}
}
