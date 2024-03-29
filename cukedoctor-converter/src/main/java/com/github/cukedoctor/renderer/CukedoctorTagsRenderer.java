package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.spi.TagsRenderer;
import java.util.HashSet;
import java.util.List;

/** Created by pestano on 28/02/16. */
public class CukedoctorTagsRenderer extends AbstractBaseRenderer implements TagsRenderer {

  @Override
  public String renderScenarioTags(Feature feature, Scenario scenario) {
    docBuilder.clear();

    int expectedSize =
        (feature.hasTags() ? feature.getTags().size() : 0)
            + (scenario.hasTags() ? scenario.getTags().size() : 0);
    if (expectedSize == 0) return "";

    HashSet<String> tagNames = new HashSet<>(expectedSize);
    extractTagNames(tagNames, feature.getTags());
    extractTagNames(tagNames, scenario.getTags());
    if (tagNames.isEmpty()) return "";

    docBuilder.clear();
    StringBuilder tags = new StringBuilder("[small]#tags: ");
    for (String tagName : tagNames) {
      tags.append(tagName).append(",");
    }

    if (tags.indexOf(",") != -1) { // delete last comma
      tags.deleteCharAt(tags.lastIndexOf(","));
    }

    tags.append("#");
    docBuilder.textLine(tags.toString());
    docBuilder.newLine();
    return docBuilder.toString();
  }

  private void extractTagNames(HashSet<String> tagNames, List<Tag> tags) {
    if (tags == null) return;

    for (Tag tag : tags) {
      if (!isCukedoctorTag(tag)) {
        tagNames.add(tag.getName());
      }
    }
  }

  protected boolean isCukedoctorTag(Tag tag) {
    return tag.isOrder() || tag.isLanguage() || tag.isDiscrete();
  }
}
