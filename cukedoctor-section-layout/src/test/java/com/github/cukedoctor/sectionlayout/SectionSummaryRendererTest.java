package com.github.cukedoctor.sectionlayout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class SectionSummaryRendererTest {

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldRenderSummaryInOrder() {
    final Feature one =
        FeatureBuilder.instance()
            .name("one")
            .keyword("Feature")
            .tag("@order-1")
            .tag("@section-one")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build();
    final Feature two =
        FeatureBuilder.instance()
            .name("two")
            .keyword("Feature")
            .tag("order-2")
            .tag("@section-two")
            .tag("@subsection-one")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build();
    final Feature three =
        FeatureBuilder.instance()
            .name("three")
            .keyword("Feature")
            .tag("order-3")
            .tag("@section-two")
            .tag("@subsection-one")
            .scenario(ScenarioBuilder.instance().name("Fake").build())
            .build();
    final Feature four =
        FeatureBuilder.instance()
            .name("four")
            .keyword("Feature")
            .tag("order-4")
            .tag("@section-three")
            .scenario(ScenarioBuilder.instance().name("Fake").build())
            .build();
    final Feature five =
        FeatureBuilder.instance()
            .name("five")
            .keyword("Feature")
            .tag("order-5")
            .scenario(ScenarioBuilder.instance().name("Fake").build())
            .build();
    final Feature six =
        FeatureBuilder.instance()
            .name("six")
            .keyword("Feature")
            .tag("order-6")
            .tag("@subsection-one")
            .scenario(ScenarioBuilder.instance().name("Fake").build())
            .build();
    final Feature seven =
        FeatureBuilder.instance()
            .name("seven")
            .keyword("Feature")
            .tag("order-7")
            .tag("@appendix")
            .tag("@section-four")
            .tag("@subsection-one")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build();
    final Feature eight =
        FeatureBuilder.instance()
            .name("eight")
            .keyword("Feature")
            .tag("order-8")
            .tag("@appendix")
            .tag("@section-five")
            .scenario(ScenarioBuilder.instance().name("Fake").build())
            .build();

    SummaryRenderer underlyingRenderer = mock(SummaryRenderer.class);
    when(underlyingRenderer.renderSummary(any(List.class), any(CukedoctorDocumentBuilder.class)))
        .thenReturn("My Summary");

    final SectionSummaryRenderer renderer =
        new SectionSummaryRenderer(
            new ServiceLoaderUtil<>(Collections.singletonList(underlyingRenderer)));

    String result =
        renderer.renderSummary(
            Arrays.asList(six, five, three, four, one, two, seven, eight),
            CukedoctorDocumentBuilder.Factory.newInstance());
    assertEquals("My Summary", result);

    ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
    verify(underlyingRenderer)
        .renderSummary(argumentCaptor.capture(), any(CukedoctorDocumentBuilder.class));

    List<Feature> features = argumentCaptor.getValue();
    assertThat(features).containsExactly(one, two, three, four, five, six, seven, eight);
  }
}
