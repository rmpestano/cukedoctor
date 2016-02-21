package com.github.cukedoctor.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.spi.ExtensionRegistry;

public class CukedoctorExtensionRegistry implements ExtensionRegistry {

	@Override
	public void register(Asciidoctor asciidoctor) {
		//null means extension is enabled (by default)
	    asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorScriptExtension.class);
		if(System.getProperty("cukedoctor.disable.filter") == null){
			asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorFilterExtension.class);
		}
		if(System.getProperty("cukedoctor.disable.minmax") == null){
			asciidoctor.javaExtensionRegistry().blockMacro("minmax", CukedoctorMinMaxExtension.class);
		}

		if(System.getProperty("cukedoctor.disable.theme") == null){
			asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorThemeExtension.class);
		}

	}

}
