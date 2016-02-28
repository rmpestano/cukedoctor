package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.spi.TagsRenderer;

/**
 * Created by pestano on 28/02/16.
 */
public class CukedoctorTagsRenderer extends AbstractBaseRenderer implements TagsRenderer {

    @Override
    public String renderScenarioTags(Feature feature, Scenario scenario) {
        docBuilder.clear();
        StringBuilder tags = new StringBuilder("[small]#tags: ");
        if (feature.hasTags()) {
            for (Tag featureTag : feature.getTags()) {
                tags.append(featureTag.getName()).append(",");
            }
        }
        if (scenario.hasTags()) {
            for (Tag scenarioTag : scenario.getTags()) {
                tags.append(scenarioTag.getName()).append(",");
            }
        }
        if (tags.indexOf(",") != -1) {//delete last comma
            tags.deleteCharAt(tags.lastIndexOf(","));
        }
        tags.append("#");
        docBuilder.textLine(tags.toString());
        docBuilder.newLine();
        return docBuilder.toString();
    }
}
