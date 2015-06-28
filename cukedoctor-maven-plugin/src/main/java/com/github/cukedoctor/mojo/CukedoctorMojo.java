package com.github.cukedoctor.mojo;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorReporter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

/**
 * @phase install
 */
@Mojo(name = "execute",
		defaultPhase = LifecyclePhase.INSTALL)
public class CukedoctorMojo extends AbstractMojo {

	/**
	 * Disable the plugin.
	 */
	@Parameter(defaultValue = "false")
	private boolean skip;

	@Parameter(defaultValue = "${project.build.directory}", required = true)
	private String jsonPath;

	@Parameter(required = true)
	String outputFile;

	@Parameter(required = false)
	private String documentTitle;

	@Parameter(required = false)
	Format format;

	@Component
	MavenProject project;


	public void execute() throws MojoExecutionException, MojoFailureException {
		if(!skip){
			List<Feature> features = FeatureParser.findAndParse(jsonPath);
			if(features == null || features.isEmpty()){
				getLog().warn("No cucumber json files found in "+ jsonPath +" or "+ Paths.get("").toAbsolutePath().toString() + jsonPath);
			}

			resolveFormat();
			DocumentAttributes documentAttributes = new DocumentAttributes().backend(format.name().toLowerCase());
			if(format.equals(Format.pdf)){
				documentAttributes.pdfTheme(true).docInfo(false);
			}else{
				documentAttributes.docInfo(true).pdfTheme(false);
			}

			if(documentTitle == null){
				documentTitle = "Living Documentation";
			}
			CukedoctorReporter reporter = Cukedoctor.instance(features, documentTitle, documentAttributes);
			String targetFile = "";
			if (outputFile.contains(".")) {
				targetFile = outputFile.substring(0, outputFile.lastIndexOf(".")) + ".adoc";
			} else {
				targetFile = outputFile + ".adoc";
			}
			String targetDir = resolveTargetDir();
			String pathToSave = targetDir + targetFile;
			reporter.setFilename(pathToSave);
			String adoc = reporter.renderDocumentation();
			File adocFile = FileUtil.saveFile(pathToSave, adoc);
			Asciidoctor asciidoctor = Asciidoctor.Factory.create();
			asciidoctor.convertFile(adocFile, OptionsBuilder.options().backend(documentAttributes.getBackend()).safe(SafeMode.UNSAFE).asMap());
			getLog().info("Generated documentation at: "+adocFile.getParent());
		}
	}

	String resolveTargetDir() {
		String dir = project.getBuild().getOutputDirectory();
		if(dir == null){
			dir = "target/";
		}
		if(!dir.endsWith("/")){
			dir = dir+"/";
		}
		return dir;

	}

	private void resolveFormat() {
		if(format == null){
			//infer format from outputFile
			if(outputFile.endsWith(".")){
				String sulfix = outputFile.substring(outputFile.lastIndexOf("."));
				if(sulfix.equalsIgnoreCase("pdf")){
					format = Format.pdf;
				} else if(sulfix.endsWith("html")){
					format = Format.html5;
				}
			} else{//defaults to html5
				format = Format.html5;
			}
		}
	}


}
