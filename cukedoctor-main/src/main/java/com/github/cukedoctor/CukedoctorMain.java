package com.github.cukedoctor;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.asciidoctor.*;

import java.io.File;
import java.util.List;

import static com.github.cukedoctor.util.Assert.hasText;

/**
 * Created by pestano on 08/06/15.
 * java -jar cukedoctor.jar -o docName -f html|pdf -p /path/to/cucumber-json-files/
 */
public class CukedoctorMain {

	@Parameter(names = "-f", description = "Document format - supported html, pdf and all. Default is 'html'", required = false, echoInput = true)
	private String format;

	@Parameter(names = "-p", description = "Path to cucumber json output files (can be a directory or a file). Default is current directory", required = false)
	private String path;

	@Parameter(names = "-t", description = "Documentation title (first section). Default is 'Living Documentation'", required = false)
	private String title;

	@Parameter(names = "-o", description = "File output name, can be a path eg: /home/doc which will result in doc.html|pdf in /home dir. Document title will be used if output name is not provided", required = false)
	private String outputName;

	@Parameter(names = "-toc", description = "Table of contents position. Default is 'right' ", required = false)
	private String toc;

	@Parameter(names = "-numbered", description = "Section numbering. Default is false ", required = false)
	private Boolean numbered;

	@Parameter(names = "-minimizable", description = "Turn features div minimizable", required = false)
	private Boolean minimizable;

	@Parameter(names = "-searchable", description = "Add input to search features by title", required = false)
	private Boolean searchable;


	public String execute(String args[]) {
		JCommander commandLine = null;
		try {
			commandLine = new JCommander(this);
			commandLine.parse(args);
		} catch (ParameterException pe) {
			commandLine.usage();
			throw pe;
		}

		if(!hasText(title)){
			title = "Living Documentation";
		}

		if (outputName == null) {
			outputName = title.replaceAll(" ", "-");
		}

		if (format == null || (format.equals("html") && !format.equals("html5") && !format.equals("pdf")  && !format.equals("all"))) {
			format = "html5";
		}

		if(!hasText(path)){
			path = "";
		}


		if(!hasText(outputName)){
			outputName = "documentation";
		}

		if(!hasText(toc)){
			toc = "right";
		}

		if(numbered == null){
			numbered = false;
		}

		if(minimizable == null){
			minimizable = Boolean.TRUE;
		}

		if(searchable == null){
			searchable = Boolean.TRUE;
		}

		System.out.println("Generating living documentation with args:");

		System.out.println("-f" + ": " + format);
		System.out.println("-p" + ": " + path);
		System.out.println("-t" + ": " + title);
		System.out.println("-o" + ": " + outputName);

		List<Feature> features = null;
		if (path.endsWith(".json")) {
			features = FeatureParser.parse(FileUtil.findJsonFile(path));
		} else {
			features = FeatureParser.parse(FileUtil.findJsonFiles(path));
		}

		if (features == null || features.isEmpty()) {
			System.out.println("No features found in path:" + path);
			return null;
		} else {
			System.out.println("Found " + features.size() + " feature(s)");
		}

		DocumentAttributes documentAttributes = new DocumentAttributes().
				backend(format).
				toc(toc).
				minimizable(minimizable).
				searchable(searchable).
				numbered(numbered);

		if(format.equalsIgnoreCase("pdf")){
			documentAttributes.pdfTheme(true).minimizable(false).docInfo(false);
		}else {
			documentAttributes.docInfo(true).pdfTheme(false);
		}
		if (outputName.contains(".")) {
			outputName = outputName.substring(0, outputName.lastIndexOf(".")) + ".adoc";
		} else {
			outputName = outputName + ".adoc";
		}
		documentAttributes.docTitle(title);

		String resultDoc = null;
		if("all".equals(format)){
			documentAttributes.backend("html5");
			resultDoc = this.execute(features, documentAttributes, outputName);
			documentAttributes.backend("pdf");
			this.execute(features, documentAttributes, outputName);
		}else{
			resultDoc = this.execute(features,documentAttributes,outputName);
		}
		return resultDoc;
	}

	public static void main(String args[]) {
		CukedoctorMain main = new CukedoctorMain();
		main.execute(args);
	}

	public String execute(List<Feature> features, DocumentAttributes attrs, String outputName){
		if(title == null){
			title = "Living Documentation";
		}
		if(attrs == null){
			attrs = new DocumentAttributes().docTitle(title);
		}
		if(!hasText(attrs.getBackend())){
			attrs.backend("html5");
		}
		if(outputName == null){
			outputName = title.replaceAll(" ", "_");
		}
		CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
		String doc = converter.renderDocumentation();
		File adocFile = FileUtil.saveFile(outputName, doc);
		Asciidoctor asciidoctor = Asciidoctor.Factory.create();
		asciidoctor.convertFile(adocFile, OptionsBuilder.options().backend(attrs.getBackend()).safe(SafeMode.UNSAFE).asMap());
		asciidoctor.shutdown();
		return doc;
	}

}
