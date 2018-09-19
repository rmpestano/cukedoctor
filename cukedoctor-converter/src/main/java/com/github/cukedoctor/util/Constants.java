package com.github.cukedoctor.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.getProperty;

/**
 * Created by pestano on 04/06/15.
 */
public abstract class Constants {

	public static final String SKIP_DOCS = "@skipDocs";
	public static final String BASE_DIR =  Files.exists(Paths.get("target")) ? Paths.get("target").toString() :
			Files.exists(Paths.get("bin")) ? Paths.get("bin").toString() : Paths.get("").toString();

	public static final String STOP_WATCH = "cukedoctor.stopwatch";

	public static final String DISCRETE = "[discrete]";

	public static final String DOCUMENT_TITLE = getProperty("DOCUMENT_TITLE") == null ? "Documentation" : getProperty("DOCUMENT_TITLE");


	public static String newLine() {
		return System.getProperty("line.separator");
	}

	public static String home() {
		String homeDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		if(!homeDir.endsWith("/")){
			homeDir += "/";
		}

		if(isWindows() && homeDir.startsWith("/")){
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

	public abstract static class Atributes {


		public static String toc(String value) {
			if(value == null || "".equals(value.trim())){
				return "";
			}
			return ":toc: " +value;
		}

		public static String tocLevels(String value) {
			return ":toclevels: " + value;
		}

		public static String icons(String value) {
			return ":icons: " + value;
		}

		public static String numbered(boolean numbered) {
			return numbered ? ":numbered:":":!numbered:";
		}

		public static String hardBreaks(boolean hardBreaks) {
			return hardBreaks ? ":hardbreaks:":":!hardbreaks:";
		}


		public static String linkcss(boolean linkcss) {
			return linkcss ? ":linkcss:":":!linkcss:";
		}


		public static String sectAnchors(boolean sectAnchors) {
			return sectAnchors ? ":sectanchors:":":!sectanchors:";
		}


		public static String sectLink(boolean sectLink) {
			return sectLink ? ":sectlink:":":!sectlink:";
		}


		public static String backend(String value) {
			return ":backend: " + value;
		}

		public static String revNumber(String value) {
			return ":revnumber: " + value;
		}

		public static String revDate(String value) {
			return ":revdate: " + value;
		}

		public static String docTitle(String value) {
			return ":doctitle: " + value;
		}

		public static String docType(String value) {
			return ":doctype: " + value;
		}

		public static String docInfo(boolean docInfo) {
			return docInfo ? ":docinfo:":":!docinfo:";
		}

		public static String sourceHighlighter(String value) {
			return ":source-highlighter: " + value;
		}

		public static String pdfStyle(String value) {
			return ":pdf-style: " + value;
		}

		public static String versionLabel(String value) {
		    	return ":version-label: " + value;
		}

		public static String chapterLabel(String value) {
		    	return ":chapter-label: " + value;
		}
	}

	public static <T> T getProp(String property, Class<T> type) {
		if(property == null) {
			return null;
		}
		return type.cast(getProperty(property));
	}

	public static Boolean getBooleanProperty(String property) {
		String value = getProperty(property);
		if(value == null) {
			return null;
		}
		return Boolean.valueOf(getProperty(property));
	}


}

