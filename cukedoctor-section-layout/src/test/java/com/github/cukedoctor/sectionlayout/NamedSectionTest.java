package com.github.cukedoctor.sectionlayout;


import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class NamedSectionTest {
    @Test
    public void canConstruct() {
        new NamedSection("MySection");
    }

    @Test
    public void canRender() {
        final NamedSection section = new NamedSection("My Section");
        section.addFeature(FeatureBuilder.instance().name("My First Child").build());
        section.addFeature(FeatureBuilder.instance().name("My Second Child").build());

        final String expectedDocument = "[[My-Section, My Section]]" + newLine() +
                "= *My Section*" + newLine() + newLine() + newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "== *My First Child*" + newLine() +
                newLine() +
                "[[My-Second-Child, My Second Child]]" + newLine() +
                "== *My Second Child*" + newLine() +
                newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }
}
