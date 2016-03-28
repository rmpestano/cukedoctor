package com.github.cukedoctor.config;

import com.github.cukedoctor.util.Constants;

/**
 * Created by pestano on 22/06/15.
 */
public abstract class CukedoctorConfig {

	public static final int ERROR_MESSAGE_SIZE = getProperty("ERROR_MESSAGE_SIZE",Integer.class) == null ? 400 : getProperty("ERROR_MESSAGE_SIZE",Integer.class);
	public static final String DOCUMENT_TITLE= getProperty("DOCUMENT_TITLE") == null ? "Documentation" : getProperty("DOCUMENT_TITLE");
	//base dir to search for intro chapter cukedoctor-intro.adoc file
    public static final String INTRO_CHAPTER_DIR = getProperty("INTRO_CHAPTER_DIR") == null ? Constants.baseDir : getProperty("INTRO_CHAPTER_DIR");


	private static <T> T getProperty(String property, Class<T> type) {
		if(System.getProperty(property) == null){
			return null;
		}
		return (T)System.getProperty(property);
	}

	private static String getProperty(String property) {
		if(System.getProperty(property) == null){
			return null;
		}
		return System.getProperty(property);
	}

}
