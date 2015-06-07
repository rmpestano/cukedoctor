package com.github.cukedoctor.util;

/**
 * Created by pestano on 04/06/15.
 */
public abstract class Constants {

	public static String newLine(){
		return System.getProperty("line.separator");
	}

	public interface Markup {

		String H1 = "= ";
		String H2 = "== ";

		String TABLE = "|===";
		String TABLE_COL = "|";
		String ALIGN_LEFT = "<";

		String TOC = ":toc:";
		String ICONS = ":icons:";
		String NUMBERED = ":numbered:";
		String NOT_NUMBERED = ":!numbered:";
		String SECT_ANCHORS = ":sectanchors:";
		String NOT_SECT_ANCHORS = ":!sectanchors:";
		String SECT_LINK = ":sectlink:";
		String NOT_SECT_LINK = ":!sectlink:";
		String BACKEND = ":backend:";
		String DOC_TITLE = ":doctitle:";
		String DOC_FILE = ":docfile:";
		String DOC_TYPE = ":doctype:";
	}
}

