package com.github.cukedoctor.sectionlayout;

import static com.github.cukedoctor.sectionlayout.Constants.APPENDIX_TAG_PATTERN;
import static com.github.cukedoctor.sectionlayout.Constants.SECTION_TAG_PATTERN;
import static com.github.cukedoctor.sectionlayout.Constants.SUBSECTION_TAG_PATTERN;

import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.renderer.CukedoctorTagsRenderer;

/** Custom renderer for cukedoctor tags */
public class SectionTagsRenderer extends CukedoctorTagsRenderer {

  @Override
  protected boolean isCukedoctorTag(Tag tag) {
    return super.isCukedoctorTag(tag) || isSectionTag(tag) || isAppendixTag(tag);
  }

  private boolean isSectionTag(Tag tag) {
    return tag.extractPattern(SECTION_TAG_PATTERN).isPresent()
        || tag.extractPattern(SUBSECTION_TAG_PATTERN).isPresent();
  }

  private boolean isAppendixTag(Tag tag) {
    return tag.extractPattern(APPENDIX_TAG_PATTERN).isPresent();
  }
}
