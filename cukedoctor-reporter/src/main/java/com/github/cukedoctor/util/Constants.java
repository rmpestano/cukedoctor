package com.github.cukedoctor.util;

/**
 * Created by pestano on 04/06/15.
 */
public abstract class Constants {

	public static String newLine(){
		return System.getProperty("line.separator");
	}

	public static String bold(String value){
		return "*"+value+"*";
	}

	public static String style(String style, String value){
		return "[" + style +"]#"+value+"#";
	}



	public interface Markup {

		String H1 = "= ";
		String H2 = "== ";
		String H3 = "=== ";

		String TABLE = "|===";
		String TABLE_COL = "|";

		String TOC = ":toc: ";
		String ICONS = ":icons: ";
		String NUMBERED = ":numbered:";
		String NOT_NUMBERED = ":!numbered:";
		String LINKCSS = ":linkcss:";
		String NOT_LINKCSS = ":!linkcss:";
		String SECT_ANCHORS = ":sectanchors:";
		String NOT_SECT_ANCHORS = ":!sectanchors:";
		String SECT_LINK = ":sectlink:";
		String NOT_SECT_LINK = ":!sectlink:";
		String BACKEND = ":backend: ";
		String DOC_TITLE = ":doctitle: ";
		String DOC_FILE = ":docfile: ";
		String DOC_TYPE = ":doctype: ";
		String DOCINFO = ":docinfo:";
		String NOT_DOCINFO = ":!docinfo:";
	}
}

