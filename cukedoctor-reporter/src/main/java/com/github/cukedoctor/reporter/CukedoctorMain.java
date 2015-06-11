package com.github.cukedoctor.reporter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;

import java.util.List;

/**
 * Created by pestano on 08/06/15.
 * <p/>
 * java -jar cukedoctor.jar -n docName.html|pdf -p
 * "/path/to/cucumber-json-files/"
 */
public class CukedoctorMain {

	@Parameter(names = "-n", description = "Document name (with extension - supported html and pdf)", required = true, echoInput = true)
	private String docName;

	@Parameter(names = "-p", description = "Path to cucumber json output files (can be a directory or a file) ", required = true)
	private String path;

	@Parameter(names = "-t", description = "Documentation title (first section). Document name will be used if title is not provided", required = false)
	private String title;


	public String execute(String args[]) {
		JCommander commandLine = null;
		try {
			commandLine = new JCommander(this);
			commandLine.parse(args);
		} catch (ParameterException pe) {
			commandLine.usage();
			throw pe;
		}
		if (title == null) {
			//Use docName as title with first char in uppercase
			int indexOfFirstDocTitleChar = docName.contains("/") ? docName.lastIndexOf("/") + 1 : 0;
			title = docName.trim().substring(indexOfFirstDocTitleChar, indexOfFirstDocTitleChar + 1).toUpperCase() + docName.trim().substring(indexOfFirstDocTitleChar + 1);
		}

		System.out.println("Generating living documentation with args:");

		System.out.println("-n" + ": " + docName);
		System.out.println("-p" + ": " + path);
		System.out.println("-t" + ": " + title);

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
		String doc = Cukedoctor.instance(features, title).createDocumentation();
		if (docName.toLowerCase().endsWith("html")) {
			generateHtml(doc);
		} else if (docName.toLowerCase().endsWith("pdf")) {
			generatePdf(doc);
		} else {
			FileUtil.saveFile(docName, doc);
		}
		return doc;
	}

	public static void main(String args[]) {
		CukedoctorMain main = new CukedoctorMain();
		main.execute(args);
	}

	private static void generateHtml(String docContent) {
		throw new UnsupportedOperationException("Not implemented");
	}

	private static void generatePdf(String docContent) {
		throw new UnsupportedOperationException("Not implemented");
	}
}
