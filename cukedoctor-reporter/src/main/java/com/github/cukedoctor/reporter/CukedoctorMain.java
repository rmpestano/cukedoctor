package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.apache.commons.cli.*;

import java.util.List;

/**
 * Created by pestano on 08/06/15.
 * <p/>
 * java -jar cukedoctor.jar -n docName.html|pdf  -p "/path/to/cucumber-json-files/"
 */
public class CukedoctorMain {

	public static void main(String args[]) throws ParseException {


		Option optName = Option.builder("n").desc("Document name (with extension - supported html and pdf").
				hasArg().argName("n").required().build();

		Option optPath = Option.builder("p").desc("Path to cucumber json output files").
				hasArg().argName("p").required().build();

		Option optTitle = Option.builder("t").desc("Document title (first section)").
				hasArg().argName("t").required().build();

		CommandLineParser parser = new DefaultParser();
		CommandLine commandLine = null;
		commandLine = parser.parse(new Options().addOption(optName).
				addOption(optPath).addOption(optTitle), args);


		String docName = null;
		String docTitle = null;
		String path = null;


		docName = commandLine.getOptionValue('n').trim();

		path = commandLine.getOptionValue('p').trim();

		docTitle = commandLine.getOptionValue('t').trim();

		System.out.println("Generating living documentation with args:");
		for (Option o : commandLine.getOptions()) {
			System.out.println(o.getValue());
		}


		List<Feature> features = FeatureParser.parse(FileUtil.findJsonFiles(path));

		if (features == null || features.isEmpty()) {
			System.out.println("No features found in path:" + path);
			return;
		}
		if (docName.toLowerCase().endsWith("html")) {
			generateHtml(features);
		} else if (docName.toLowerCase().endsWith("pdf")) {
			generatePdf(features);
		} else {
			String doc = CukedoctorReporter.instance(features, docTitle).createDocumentation();
			FileUtil.saveFile(docName, doc);
		}

	}

	private static void generateHtml(List<Feature> features) {
		throw new UnsupportedOperationException("Not implemented");
	}

	private static void generatePdf(List<Feature> features) {
		throw new UnsupportedOperationException("Not implemented");
	}
}
