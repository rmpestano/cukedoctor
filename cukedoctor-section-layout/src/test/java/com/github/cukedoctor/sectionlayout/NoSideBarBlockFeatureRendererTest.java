package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class NoSideBarBlockFeatureRendererTest {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("HIDE_STEP_TIME", "true");
        System.setProperty("cukedoctor.disable-extensions", "true");
    }

    @Test
    public void shouldRenderDescriptionInLine() {
        Feature feature = FeatureBuilder.instance().id("My Feature").name("My Feature").description("My feature's description").build();

        String expected = "[[My-Feature, My Feature]]" + newLine() +
                "= *My Feature*" + newLine() +
                newLine() + newLine() +
                "My feature's description" + newLine() + newLine();

        String result = new NoSideBarBlockFeatureRenderer().renderFeature(feature, CukedoctorDocumentBuilder.Factory.newInstance());

        assertEquals(expected, result);
    }
}