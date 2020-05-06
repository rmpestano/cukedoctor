package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class SectionTagsRendererTests {

    @Test
    public void shouldIdentifySectionAsBuiltInTag() {
        assertTrue(new SectionTagsRenderer().isCukedoctorTag(new Tag("@section-Dinosaurs")));
    }

    @Test
    public void shouldIdentifySubSectionAsBuiltInTag() {
        assertTrue(new SectionTagsRenderer().isCukedoctorTag(new Tag("@subsection-Dinosaurs")));
    }

    @Test
    public void shouldIdentifyAppendixAsBuiltInTag() {
        assertTrue(new SectionTagsRenderer().isCukedoctorTag(new Tag("@appendix")));
    }
}