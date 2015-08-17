package com.github.cukedoctor.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.spi.ExtensionRegistry;

public class CukedoctorExtensionRegistry implements ExtensionRegistry {

	@Override
	public void register(Asciidoctor asciidoctor) {
		asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorScriptExtension.class);
		asciidoctor.javaExtensionRegistry().postprocessor(CukedoctorFilterExtension.class);
		asciidoctor.javaExtensionRegistry().blockMacro("minmax",CukedoctorMinMaxExtension.class);
	}

}
