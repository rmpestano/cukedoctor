package com.github.cukedoctor.config;

/**
 * Created by pestano on 22/06/15.
 */
public abstract class CukedoctorConfig {

	public static final int ERROR_MESSAGE_SIZE = getProperty("ERROR_MESSAGE_SIZE",Integer.class) == null ? 350 : getProperty("ERROR_MESSAGE_SIZE",Integer.class);
	public static final String DOCUMENT_TITLE= getProperty("DOCUMENT_TITLE") == null ? "Documentation" : getProperty("DOCUMENT_TITLE");


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
