package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Constants.Attributes.Name.*;
import static java.lang.System.getProperty;

import java.nio.file.Files;
import java.nio.file.Paths;

/** Created by pestano on 04/06/15. */
public abstract class Constants {

  public static final String SKIP_DOCS = "@skipDocs";
  public static final String BASE_DIR =
      Files.exists(Paths.get("target"))
          ? Paths.get("target").toString()
          : Files.exists(Paths.get("bin")) ? Paths.get("bin").toString() : Paths.get("").toString();

  public static final String STOP_WATCH = "cukedoctor.stopwatch";

  public static final String DISCRETE = "[discrete]";

  public static final String DOCUMENT_TITLE =
      getProperty("DOCUMENT_TITLE") == null ? "Documentation" : getProperty("DOCUMENT_TITLE");

  public static String newLine() {
    return System.getProperty("line.separator");
  }

  public static String home() {
    String homeDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    if (!homeDir.endsWith("/")) {
      homeDir += "/";
    }

    if (isWindows() && homeDir.startsWith("/")) {
      homeDir = homeDir.substring(1);
    }

    return homeDir;
  }

  private static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase().startsWith("windows");
  }

  public abstract static class Markup {

    public static String bold(String value) {
      return "*" + value + "*";
    }

    public static String style(String style, String value) {
      return "[" + style + "]#" + value + "#";
    }

    public static String H1(String value) {
      return "= " + value;
    }

    public static String H2(String value) {
      return "== " + value;
    }

    public static String H3(String value) {
      return "=== " + value;
    }

    public static String H4(String value) {
      return "==== " + value;
    }

    public static String table() {
      return "|===";
    }

    public static String tableCol() {
      return "|";
    }

    public static String listing() {
      return "----";
    }

    public static String exampleBlock() {
      return "=====";
    }
  }

  public abstract static class Attributes {

    public enum Name {
      TOC("toc"),
      TOCLEVELS("toclevels"),
      ICONS("icons"),
      NUMBERED("numbered"),
      HARDBREAKS("hardbreaks"),
      LINKCSS("linkcss"),
      SECTANCHORS("sectanchors"),
      SECTLINK("sectlink"),
      BACKEND("backend"),
      REVNUMBER("revnumber"),
      DOCTITLE("doctitle"),
      DOCTYPE("doctype"),
      DOCINFO("docinfo"),
      SOURCEHIGHLIGHTER("source-highlighter"),
      PDFSTYLE("pdf-style"),
      VERSIONLABEL("version-label"),
      CHAPTERLABEL("chapter-label"),
      STEM("stem"),
      ALLOWURIREAD("allow-uri-read"),
      DATAURI("data-uri");

      final String name;

      Name(String name) {
        this.name = name;
      }

            public String getName() {
                return name;
            }

        }

    private static String toAdocAttr(String attrName, Object attrValue) {
      if (attrValue == null || "".equals(attrValue.toString().trim())) {
        return "";
      }
      StringBuilder adocAttr = new StringBuilder();
      adocAttr.append(":");
      if (Boolean.class.isAssignableFrom(attrValue.getClass())) {
        boolean bool = Boolean.parseBoolean(attrValue.toString());
        if (!bool) {
          adocAttr.append("!");
        }
        adocAttr.append(attrName).append(":");
      } else {
        adocAttr.append(attrName).append(":").append(" ").append(attrValue.toString());
      }
      return adocAttr.toString();
    }

    public static String toc(String value) {
      return toAdocAttr(TOC.name, value);
    }

    public static String tocLevels(String value) {
      return toAdocAttr(TOCLEVELS.name, value);
    }

    public static String icons(String value) {
      return toAdocAttr(ICONS.name, value);
    }

    public static String numbered(boolean numbered) {
      return toAdocAttr(NUMBERED.name, numbered);
    }

    public static String hardBreaks(boolean hardBreaks) {
      return toAdocAttr(HARDBREAKS.name, hardBreaks);
    }

    public static String linkcss(boolean linkcss) {
      return toAdocAttr(LINKCSS.name, linkcss);
    }

    public static String sectAnchors(boolean sectAnchors) {
      return toAdocAttr(SECTANCHORS.name, sectAnchors);
    }

    public static String sectLink(boolean sectLink) {
      return toAdocAttr(SECTLINK.name, sectLink);
    }

    public static String backend(String backend) {
      return toAdocAttr(BACKEND.name, backend);
    }

    public static String revNumber(String revNumber) {
      return toAdocAttr(REVNUMBER.name, revNumber);
    }

    public static String docTitle(String docTitle) {
      return toAdocAttr(DOCTITLE.name, docTitle);
    }

    public static String docType(String docType) {
      return toAdocAttr(DOCTYPE.name, docType);
    }

    public static String docInfo(boolean docInfo) {
      return toAdocAttr(DOCINFO.name, docInfo);
    }

    public static String sourceHighlighter(String sourceHighlighter) {
      return toAdocAttr(SOURCEHIGHLIGHTER.name, sourceHighlighter);
    }

    public static String pdfStyle(String pdfStyle) {
      return toAdocAttr(PDFSTYLE.name, pdfStyle);
    }

    public static String versionLabel(String versionLabel) {
      return toAdocAttr(VERSIONLABEL.name, versionLabel);
    }

    public static String chapterLabel(String chapterLabel) {
      return toAdocAttr(CHAPTERLABEL.name, chapterLabel);
    }

    public static String stem(String stem) {
      return toAdocAttr(STEM.name, stem);
    }

    public static String allowUriRead(boolean allowUriRead) {
      return toAdocAttr(ALLOWURIREAD.name, allowUriRead);
    }

    public static String dataUri(Boolean value) {
      return toAdocAttr(DATAURI.name, value);
    }
  }

  public static <T> T getProp(String property, Class<T> type) {
    if (property == null) {
      return null;
    }
    return type.cast(getProperty(property));
  }

  public static Boolean getBooleanProperty(String property) {
    String value = getProperty(property);
    if (value == null) {
      return null;
    }
    return Boolean.valueOf(getProperty(property));
  }
}
