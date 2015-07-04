package com.github.cukedoctor.util;

import com.github.cukedoctor.api.DocWriter;

import static com.github.cukedoctor.util.Constants.*;


/**
 * Created by pestano on 06/06/15.
 */
public class DocWriterImpl implements DocWriter<StringBuilder> {

	private static DocWriterImpl instance;
	private StringBuilder doc;

	private DocWriterImpl() {
	}

	public static synchronized DocWriterImpl getInstance(StringBuilder doc) {
		instance = new DocWriterImpl();
		instance.doc = doc;
		return instance;
	}

	public DocWriterImpl write(Object value) {
		if (value != null) {
			doc.append(value);
		}
		return instance;
	}

	public DocWriterImpl write(Object... value) {
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

	public StringBuilder getCurrentDoc() {
		return doc;
	}

	@Override
	public void clear() {
		doc = new StringBuilder();
	}
}
