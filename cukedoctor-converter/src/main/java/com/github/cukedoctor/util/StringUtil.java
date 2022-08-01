package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Constants.newLine;

public class StringUtil {

  private StringUtil() {}

  public static String trimAllLines(String text) {
    if (!hasText(text)) {
      return text;
    }

    StringBuilder trimmedDescription = new StringBuilder();
    String[] lines = normaliseLineEndings(text).split(newLine());
    boolean shouldTrim = true;
    boolean foundFirstNotEmptyLine = false;
    int leadingWhitespaceCharsToTrim = 0;
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];

      if (!foundFirstNotEmptyLine && line != null && !line.isEmpty()) {
        leadingWhitespaceCharsToTrim = countLeadingWhitespace(line);
        foundFirstNotEmptyLine = true;
      }

      line = trimStart(line, leadingWhitespaceCharsToTrim);

      if (line.trim().startsWith(Constants.Markup.listing())) {
        // enable trimming on end listing
        shouldTrim = !shouldTrim; // remove trimming on start listing
      }

      if (shouldTrim) {
        trimmedDescription.append(trimEnd(line));
      } else {
        trimmedDescription.append(line);
      }

      if (i < lines.length - 1) {
        trimmedDescription.append(newLine());
      }
    }

    return trimmedDescription.toString();
  }

  static int countLeadingWhitespace(String text) {
    if (text == null) return 0;

    int i = 0;
    while (i < text.length()) {
      char c = text.charAt(i);
      if (c != ' ' && c != '\t') {
        break;
      }

      i += Character.charCount(c);
    }

    return i;
  }

  static String trimStart(String text, int count) {
    if (count < 1) return text;

    if (text == null) return null;

    int i = 0;
    while (i < text.length() && i < count) {
      char c = text.charAt(i);
      if (c != ' ' && c != '\t') {
        break;
      }

      i += Character.charCount(c);
    }

    return text.substring(i);
  }

  static String trimEnd(String text) {
    if (text == null) return null;

    // https://stackoverflow.com/a/48053234
    return text.replaceFirst("\\s++$", "");
  }

  public static String normaliseLineEndings(String s) {
    if (s == null) return null;

    return s.replaceAll("\\r\\n|\\r|\\n", System.lineSeparator());
  }
}
