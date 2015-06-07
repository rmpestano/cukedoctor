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
				.name("my step").durations(1500000).status(Status.passed).build();
		Step step2 = StepBuilder.instance().match(new Match("/match2"))
				.name("my step 2").status(Status.passed).durations(500000).build();

		Result result = new Result();
		result.setDuration(1000000L);
		result.setStatus(Status.failed);

		Step step3 = StepBuilder.instance().match(new Match("/match2"))
				.name("my step 3").result(result).build();


		Element passingScenario = ScenarioBuilder.instance().name("scenario 1")
				.type(Type.scenario).description("scenario desc")
				.step(step1).step(step2).build();

		Element failingScenario = ScenarioBuilder.instance().name("scenario 2")
				.type(Type.scenario).keyword("keyword")
				.step(step1).step(step2).step(step3).step(step3).build();

		feature = FeatureBuilder.instance().id("id").name("feature").keyword("keyword").
				uri("uri").description("feature description").
				scenario(passingScenario).scenario(failingScenario).build();

	}

	@Test
	public void shouldProcessSteps() {
		feature.processSteps();
		assertThat(feature.getNumberOfScenarios()).isEqualTo(2);
		assertThat(feature.getNumberOfSteps()).isEqualTo(5); //2 steps in scenario 1 and 3 in scenario 2
		assertThat(feature.getStatus()).isEqualTo(Status.failed);
		assertThat(feature.getStepResults().getTotalDuration()).isEqualTo(5000000L);
		assertThat(feature.getDurationOfSteps()).isEqualTo("005ms");
		assertThat(feature.getNumberOfFailures()).isEqualTo(1); //1 in scenario 2
		assertThat(feature.getNumberOfPasses()).isEqualTo(4);//2 passes in each scenario
		assertThat(feature.getNumberOfPending()).isEqualTo(0);
		assertThat(feature.getNumberOfSkipped()).isEqualTo(0);
	}
}
