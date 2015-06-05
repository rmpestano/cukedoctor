package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by pestano on 02/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorReporterTest {

   private static String onePassingOneFailing;

    @BeforeClass
    public static void loadFeatures() {
        onePassingOneFailing = FileUtil.findJsonFile("json-output/one_passing_one_failing.json");
    }


    @Test(expected = RuntimeException.class)
    public void shouldFailToCreateDocumentationWithoutFeatures(){
        CukedoctorReporter.instance(new ArrayList<Feature>(),"A test");
    }

    @Test(expected = RuntimeException.class)
    public void shouldFailToCreateDocumentationWithoutTitle(){
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        CukedoctorReporter.instance(features," ");
    }

    @Test
    public void shouldRenderAttributes() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);

        String expected = ":toc:\n" +
                "right\n" +
                ":backend:html5\n" +
                ":doctitle:Title\n" +
                ":doctype:article\n" +
                ":icons:font\n" +
                ":!numbered:\n" +
                ":sectanchors:\n" +
                ":sectlink:\n";
        String document = CukedoctorReporter.instance(features,"Title").renderAttributes().getDocumentation().toString();
        assertEquals(document,expected);
    }


}
