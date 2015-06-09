package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Constants.*;


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

	public DocWriter write(Object value) {
		if (value != null) {
			doc.append(value);
		}
		return instance;
	}

	public DocWriter write(Object value, boolean newLine) {
		if (value != null) {
			doc.append(value);
		}
		if (newLine) {
			doc.append(Constants.newLine());
		}
		return instance;
	}

	public DocWriter write(Object... value) {
		for (Object s : value) {
			if (s == null || (s.toString() != newLine() && s.toString().trim().equals(""))) {
				return instance;
			}
		}
		for (Object s : value) {
			write(s);
		}
		return instance;
	}


}
