package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.ScenarioResults;
import com.github.cukedoctor.api.StepResults;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.ScenarioTotalizations;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.Formatter;

import java.util.List;

import static com.github.cukedoctor.util.Constants.Markup.*;
import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 26/02/16.
 */
public class CukedoctorSummaryRenderer extends AbstractBaseRenderer implements SummaryRenderer {

    private ScenarioTotalizations scenarioTotalizationsCache;

    public CukedoctorSummaryRenderer() {
    }

    public CukedoctorSummaryRenderer(CukedoctorConfig cukedoctorConfig) {
        this.cukedoctorConfig = cukedoctorConfig;
    }

    @Override
    public String renderSummary(List<Feature> features) {
        calculateTotalizations(features);
        docBuilder.textLine(H2(bold(i18n.getMessage("title.summary"))));

        //TODO convert to AsciidocMarkupBuilder
        docBuilder.append("[cols=\"12*^m\", options=\"header,footer\"]", newLine(),
            "|===", newLine() +
                "3+|" + i18n.getMessage("title.scenario") + "s 7+|" + i18n.getMessage("summary.steps") + " 2+|", i18n.getMessage("title.features"), ": ", features.size() +
                "", newLine(), newLine() +
                "|[green]#*", i18n.getMessage("result.passed"), "*#", newLine(),
            "|[red]#*", i18n.getMessage("result.failed"), "*#", newLine(),
            "|Total", newLine(),
            "|[green]#*", i18n.getMessage("result.passed"), "*#", newLine(),
            "|[red]#*", i18n.getMessage("result.failed"), "*#", newLine(),
            "|[purple]#*", i18n.getMessage("result.skipped"), "*#", newLine(),
            "|[maroon]#*", i18n.getMessage("result.pending"), "*#", newLine(),
            "|[yellow]#*", i18n.getMessage("result.undefined"), "*#", newLine(),
            "|[blue]#*", i18n.getMessage("result.missing"), "*#", newLine(),
            "|Total", newLine(),
            "|"+ i18n.getMessage("summary.duration"), newLine(),
            "|Status" ).newLine();


        for (Feature feature : features) {
            //TODO convert to AsciidocMarkupBuilder
            docBuilder.append(newLine(), "12+^", tableCol(), "*<<", feature.getName().replaceAll(",", "").replaceAll(" ", "-"), ">>*", newLine());
            StepResults stepResults = feature.getStepResults();
            ScenarioResults scenarioResults = feature.getScenarioResults();

            docBuilder.append(tableCol(), scenarioResults.getNumberOfScenariosPassed(), newLine());
            docBuilder.append(tableCol(), scenarioResults.getNumberOfScenariosFailed(), newLine());
            docBuilder.append(tableCol(), scenarioResults.getNumberOfScenarios(), newLine());
            docBuilder.append(tableCol(), stepResults.getNumberOfPasses(), newLine());
            docBuilder.append(tableCol(), stepResults.getNumberOfFailures(), newLine());
            docBuilder.append(tableCol(), stepResults.getNumberOfSkipped(), newLine());
            docBuilder.append(tableCol(), stepResults.getNumberOfPending(), newLine());
            docBuilder.append(tableCol(), stepResults.getNumberOfUndefined(), newLine());
            docBuilder.append(tableCol(), stepResults.getNumberOfMissing(), newLine());
            docBuilder.append(tableCol(), stepResults.getNumberOfSteps(), newLine());
            docBuilder.append(tableCol(), stepResults.getTotalDurationAsString(), newLine());
            docBuilder.append(tableCol(), Status.getStatusColor(feature.getStatus()), newLine());
        }
        renderTotalsRow();
        docBuilder.textLine(table());
        return docBuilder.toString();
    }

    private void calculateTotalizations(List<Feature> features) {
        if(scenarioTotalizationsCache == null){
            scenarioTotalizationsCache = new ScenarioTotalizations(features);
        }
    }

    //should be only called inside renderSummary()
    private void renderTotalsRow() {
        docBuilder.append("12+^|*"+ i18n.getMessage("summary.total")+"*", newLine()).
            append(tableCol(), scenarioTotalizationsCache.getTotalPassedScenarios(), tableCol(), scenarioTotalizationsCache.getTotalFailedScenarios()).
                append(tableCol(), scenarioTotalizationsCache.getTotalScenarios()).
                append(tableCol(), scenarioTotalizationsCache.getTotalPassedSteps(), tableCol(), scenarioTotalizationsCache.getTotalFailedSteps()).
                append(tableCol(), scenarioTotalizationsCache.getTotalSkippedSteps(), tableCol(), scenarioTotalizationsCache.getTotalPendingSteps()).
                append(tableCol(), scenarioTotalizationsCache.getTotalUndefinedSteps(), tableCol(), scenarioTotalizationsCache.getTotalMissingSteps()).
            append(tableCol(), scenarioTotalizationsCache.getTotalSteps(), " 2+", tableCol(), Formatter.formatTime(scenarioTotalizationsCache.getTotalDuration()));
        docBuilder.newLine();
    }
}
