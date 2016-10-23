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


	//lazy evaluation
	public static Boolean hideSummarySection(){
		return getProperty("HIDE_SUMMARY_SECTION") == null ? GlobalConfig.getInstance().isHideSummarySection() : Boolean.valueOf(getProperty("HIDE_SUMMARY_SECTION"));
	}

	public static Boolean hideFeaturesSection(){
		return getProperty("HIDE_FEATURES_SECTION") == null ? GlobalConfig.getInstance().isHideFeaturesSection() : Boolean.valueOf(getProperty("HIDE_FEATURES_SECTION"));
	}

	public static Boolean hideStepTime(){
		return getProperty("HIDE_STEP_TIME") == null ? GlobalConfig.getInstance().isHideStepTime() : Boolean.valueOf(getProperty("HIDE_STEP_TIME"));
	}

	public static Boolean hideScenarioKeyword(){
		return getProperty("HIDE_SCENARIO_KEYWORD") == null ? GlobalConfig.getInstance().isHideScenarioKeyword() : Boolean.valueOf(getProperty("HIDE_SCENARIO_KEYWORD"));
	}

	public static Boolean hideTags(){
		return getProperty("HIDE_TAGS") == null ? GlobalConfig.getInstance().isHideTags() : Boolean.valueOf(getProperty("HIDE_TAGS"));
	}


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
