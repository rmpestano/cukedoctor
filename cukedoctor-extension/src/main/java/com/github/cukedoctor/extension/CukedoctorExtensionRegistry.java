package com.github.cukedoctor.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.spi.ExtensionRegistry;

public class CukedoctorExtensionRegistry implements ExtensionRegistry {

	public static final String FILTER_DISABLE_EXT_KEY = "cukedoctor.disable.filter";
	public static final String THEME_DISABLE_EXT_KEY = "cukedoctor.disable.theme";
	public static final String MINMAX_DISABLE_EXT_KEY = "cukedoctor.disable.minmax";
	public static final String STYLE_DISABLE_EXT_KEY = "cukedoctor.disable.style";
	public static final String FOOTER_DISABLE_EXT_KEY = "cukedoctor.disable.footer";

	@Override
	public void register(Asciidoctor asciidoctor) {
		//null means extension is enabled (by default)
		asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorScriptExtension.class);
		if(System.getProperty(FILTER_DISABLE_EXT_KEY) == null){
			asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorFilterExtension.class);
		}
		if(System.getProperty(MINMAX_DISABLE_EXT_KEY) == null){
			asciidoctor.javaExtensionRegistry().blockMacro("minmax", CukedoctorMinMaxExtension.class);
		}

		if(System.getProperty(THEME_DISABLE_EXT_KEY) == null){
			asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorThemeExtension.class);
		}

		if(System.getProperty(FOOTER_DISABLE_EXT_KEY) == null){
			asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorFooterExtension.class);
		}
		if(System.getProperty(STYLE_DISABLE_EXT_KEY) == null){
			asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorStyleExtension.class);
		}

	}

}
