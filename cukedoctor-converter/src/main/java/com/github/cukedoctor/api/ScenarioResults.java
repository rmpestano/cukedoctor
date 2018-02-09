package com.github.cukedoctor.api;

import com.github.cukedoctor.api.model.Scenario;

import java.util.List;

/**
 * Created by pestano on 04/06/15.
 */
public class ScenarioResults {
	List<Scenario> passedScenarios;
	List<Scenario> failedScenarios;

	public ScenarioResults(List<Scenario> passedScenarios, List<Scenario> failedScenarios) {
		this.passedScenarios = passedScenarios;
		this.failedScenarios = failedScenarios;
	}

	public Integer getNumberOfScenariosPassed() {
		return passedScenarios.size();
	}

	public Integer getNumberOfScenariosFailed() {
		return failedScenarios.size();
	}

	public List<Scenario> getPassedScenarios() {
		return passedScenarios;
	}

	public List<Scenario> getFailedScenarios() {
		return failedScenarios;
	}

	public Integer getNumberOfScenarios() {
		return getNumberOfScenariosFailed() + getNumberOfScenariosPassed();
	}
}
