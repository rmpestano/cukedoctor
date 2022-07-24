package com.github.cukedoctor.api;

import static com.github.cukedoctor.util.Constants.Attributes.Name.LINKCSS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DocumentAttributesTest {
  @Test
  public void toMapMustNotIncludeAttributesWithNullValues() {
    DocumentAttributes attributes = new DocumentAttributes();
    attributes.setLinkCss(null);
    Assert.assertNull(attributes.isLinkCss());

    Map<String, Object> result = attributes.toMap();
    assertThat(result).doesNotContainKey(LINKCSS.getName());
  }

  @Test
  public void toMapMustIncludeAttributesWithNonNullValues() {
    DocumentAttributes attributes = new DocumentAttributes();
    attributes.setLinkCss(false);
    Assert.assertFalse(attributes.isLinkCss());

    Map<String, Object> result = attributes.toMap();
    assertThat(result).containsKey(LINKCSS.getName());
  }
}
