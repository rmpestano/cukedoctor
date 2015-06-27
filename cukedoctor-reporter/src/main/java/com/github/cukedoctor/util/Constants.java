package com.github.cukedoctor.util;

/**
 * Created by pestano on 04/06/15.
 */
public abstract class Constants {

	public static String newLine() {
		return System.getProperty("line.separator");
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

		public static String docTitle(String value) {
			return ":doctitle: " + value;
		}

		public static String docType(String value) {
			return ":doctype: " + value;
		}

		public static String docInfo(boolean docInfo) {
			return docInfo ? ":docinfo:":":!docinfo:";
		}


	}

}

