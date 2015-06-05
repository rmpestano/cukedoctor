package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Constants;
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

    @Test(expected = RuntimeException.class)
    public void shouldFailToGetNullInstance(){
      CukedoctorReporter.getCurrentInstance();
    }

  @Test
  public void shouldGetCurrentInstance() {
    List<Feature> features = FeatureParser.parse(onePassingOneFailing);


    CukedoctorReporter.instance(features,"Title");
    CukedoctorReporter.getCurrentInstance();
  }

    @Test
    public void shouldRenderAttributes() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);

        String expected = ":toc:" + Constants.NEW_LINE +
                "right" +   Constants.NEW_LINE +
                ":backend:html5" + Constants.NEW_LINE +
                ":doctitle:Title" + Constants.NEW_LINE +
                ":doctype:article" + Constants.NEW_LINE +
                ":icons:font" + Constants.NEW_LINE +
                ":!numbered:" + Constants.NEW_LINE +
                ":sectanchors:" + Constants.NEW_LINE +
                ":sectlink:" + Constants.NEW_LINE;
        String document = CukedoctorReporter.instance(features,"Title").renderAttributes().getDocumentation().toString();
        assertEquals(document,expected);
    }


}
