package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.renderer.CukedoctorTagsRenderer;

import static com.github.cukedoctor.sectionlayout.Constants.*;


public class SectionTagsRenderer extends CukedoctorTagsRenderer {

    @Override
    protected boolean isCukedoctorTag(Tag tag) {
        return super.isCukedoctorTag(tag) || isSectionTag(tag) || isAppendixTag(tag);
    }

    private boolean isSectionTag(Tag tag) {
        return tag.extractPattern(SectionTagPattern).isPresent() || tag.extractPattern(SubsectionTagPattern).isPresent() ;
    }

    private boolean isAppendixTag(Tag tag) {
        return tag.extractPattern(AppendixTagPattern).isPresent();
    }
}
