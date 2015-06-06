package com.github.cukedoctor.util;


/**
 * Created by pestano on 06/06/15.
 */
public class DocWriter {

	private static DocWriter instance;
	private StringBuilder doc;

	private DocWriter() {
	}

	public static synchronized DocWriter getInstance(StringBuilder doc) {
		instance = new DocWriter();
		instance.doc = doc;
		return instance;
	}

	public DocWriter write(String value) {
		if (value != null) {
			doc.append(value.replaceAll("\\n", Constants.NEW_LINE));//cucumber puts \n in new lines
		}
		return instance;
	}

	public DocWriter write(String value, boolean newLine) {
		if (value != null) {
			doc.append(value.replaceAll("\\n", Constants.NEW_LINE));//cucumber puts \n in new lines
		}
		if (newLine) {
			doc.append(Constants.NEW_LINE);
		}
		return instance;
	}

	public DocWriter write(String... value) {
		for (String s : value) {
			if (s == null || (s != Constants.NEW_LINE && s.trim().equals(""))) {
				return instance;
			}
		}
		for (String s : value) {
			write(s);
		}
		return instance;
	}

	public String build() {
		return doc.toString();
	}


}
