package com.github.cukedoctor.api.model;

import java.util.List;

/**
 * Created by pestano on 19/02/16.
 */
public class ScenarioTotalizations {

    private int totalPassedScenarios = 0;
    private int totalFailedScenarios = 0;
    private int totalScenarios = 0;
    private int totalPassedSteps = 0;
    private int totalFailedSteps = 0;
    private int totalSkippedSteps = 0;
    private int totalPendingSteps = 0;
    private int totalMissingSteps = 0;
    private int totalUndefinedSteps = 0;
    private int totalSteps = 0;
    private long totalDuration = 0;

    public ScenarioTotalizations(){

    }

    public ScenarioTotalizations(List<Feature> features) {
        for (Feature feature : features) {
            addFeatureTotals(feature);
        }
    }

    public void addFeatureTotals(Feature feature){
        totalPassedScenarios += feature.getScenarioResults().getNumberOfScenariosPassed();
        totalFailedScenarios += feature.getScenarioResults().getNumberOfScenariosFailed();
        totalScenarios += feature.getScenarioResults().getNumberOfScenarios();
        totalPassedSteps += feature.getStepResults().getNumberOfPasses();
        totalFailedSteps += feature.getStepResults().getNumberOfFailures();
        totalSkippedSteps += feature.getStepResults().getNumberOfSkipped();
        totalPendingSteps += feature.getStepResults().getNumberOfPending();
        totalMissingSteps += feature.getStepResults().getNumberOfMissing();
        totalUndefinedSteps += feature.getStepResults().getNumberOfUndefined();
        totalSteps += feature.getNumberOfSteps();
        totalDuration += feature.getStepResults().getTotalDuration();
    }


    public int getTotalPassedScenarios() {
        return totalPassedScenarios;
    }

    public int getTotalFailedScenarios() {
        return totalFailedScenarios;
    }

    public int getTotalScenarios() {
        return totalScenarios;
    }

    public int getTotalPassedSteps() {
        return totalPassedSteps;
    }

    public int getTotalFailedSteps() {
        return totalFailedSteps;
    }

    public int getTotalSkippedSteps() {
        return totalSkippedSteps;
    }

    public int getTotalPendingSteps() {
        return totalPendingSteps;
    }

    public int getTotalMissingSteps() {
        return totalMissingSteps;
    }

    public int getTotalUndefinedSteps() {
        return totalUndefinedSteps;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public long getTotalDuration() {
        return totalDuration;
    }
}
