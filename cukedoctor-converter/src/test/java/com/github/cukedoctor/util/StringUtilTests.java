package com.github.cukedoctor.util;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringUtilTests {

  @Test
  public void shouldTrimEndOfNullString() {
    assertNull(StringUtil.trimEnd(null));
  }

  @Test
  public void shouldTrimEndOfEmptyString() {
    assertEquals("", StringUtil.trimEnd(""));
  }

  @Test
  public void shouldTrimEndOfStringWithNoTrailingWhitespace() {
    assertEquals(" \t my string", StringUtil.trimEnd(" \t my string"));
  }

  @Test
  public void shouldTrimEndOfStringWithTrailingWhitespace() {
    assertEquals("my string", StringUtil.trimEnd("my string \t \t" + lineSeparator()));
  }

  @Test
  public void shouldCountLeadingWhitespaceOfNullString() {
    assertEquals(0, StringUtil.countLeadingWhitespace(null));
  }

  @Test
  public void shouldCountLeadingWhitespaceOfEmptyString() {
    assertEquals(0, StringUtil.countLeadingWhitespace(""));
  }

  @Test
  public void shouldCountLeadingWhitespaceOfStringWithNoLeadingWhitespace() {
    assertEquals(0, StringUtil.countLeadingWhitespace("my string \t \t"));
  }

  @Test
  public void shouldCountLeadingWhitespace() {
    assertEquals(3, StringUtil.countLeadingWhitespace("\t  my string"));
  }

  @Test
  public void shouldTrimStartOfNullString() {
    assertNull(StringUtil.trimStart(null, 42));
  }

  @Test
  public void shouldTrimStartOfEmptyString() {
    assertEquals("", StringUtil.trimStart("", 42));
  }

  @Test
  public void shouldTrimStartOfStringWhereThereIsNoLeadingWhitepace() {
    assertEquals("my string \t \t", StringUtil.trimStart("my string \t \t", 3));
  }

  @Test
  public void shouldTrimStartOfStringWhereCountMatchesLeadingWhitespace() {
    assertEquals("my string", StringUtil.trimStart("\t  my string", 3));
  }

  @Test
  public void shouldTrimStartOfStringWhereCounIsLessThanLeadingWhitespace() {
    assertEquals(" my string", StringUtil.trimStart("\t  my string", 2));
  }

  @Test
  public void shouldTrimStartOfStringWhereCountIsGreaterThanLeadingWhitespace() {
    assertEquals("my string", StringUtil.trimStart("\t  my string", 4));
  }

  @Test
  public void shouldTrimAllLines() {
    final String fixture =
        " \t \tThis is the description for Feature One. The first non-blank line of this"
            + " description in the feature file began with four whitespace characters."
            + lineSeparator()
            + "    \t Therefore, cukedoctor will ignore up to the first four"
            + lineSeparator()
            + "whitespace characters"
            + lineSeparator()
            + "  in all other lines in the same description,"
            + lineSeparator()
            + "    if any are present."
            + lineSeparator()
            + ""
            + lineSeparator()
            + ""
            + lineSeparator()
            + "This includes"
            + lineSeparator()
            + "  further lines"
            + lineSeparator()
            + "    in a different"
            + lineSeparator()
            + "      paragraph"
            + lineSeparator()
            + "       \tin the same description.";

    final String expected =
        "This is the description for Feature One. The first non-blank line of this description in"
            + " the feature file began with four whitespace characters."
            + lineSeparator()
            + "\t Therefore, cukedoctor will ignore up to the first four"
            + lineSeparator()
            + "whitespace characters"
            + lineSeparator()
            + "in all other lines in the same description,"
            + lineSeparator()
            + "if any are present."
            + lineSeparator()
            + ""
            + lineSeparator()
            + ""
            + lineSeparator()
            + "This includes"
            + lineSeparator()
            + "further lines"
            + lineSeparator()
            + "in a different"
            + lineSeparator()
            + "  paragraph"
            + lineSeparator()
            + "   \tin the same description.";

    assertEquals(expected, StringUtil.trimAllLines(fixture));
  }
}
