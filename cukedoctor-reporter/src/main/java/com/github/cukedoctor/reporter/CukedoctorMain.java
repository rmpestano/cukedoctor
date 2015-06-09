package com.github.cukedoctor.reporter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;

import java.beans.ParameterDescriptor;
import java.util.List;
import java.util.Map;

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
	
	
	public void execute(String args[]){
		JCommander commandLine = new JCommander(this,args);

		if (title == null) {
			title = docName.trim().substring(0, 1).toUpperCase() + docName.trim().substring(1);//Document title should be upper
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
			return;
		} else {
			System.out.println("Found " + features.size() + " feature(s)");
		}
		if (docName.toLowerCase().endsWith("html")) {
			generateHtml(features);
		} else if (docName.toLowerCase().endsWith("pdf")) {
			generatePdf(features);
		} else {
			String doc = CukedoctorReporter.instance(features, title).createDocumentation();
			FileUtil.saveFile(docName, doc);
		}

	}

  public static void main(String args[]) {
    CukedoctorMain main = new CukedoctorMain();
		main.execute(args);
  }

  private static void generateHtml(List<Feature> features) {
    throw new UnsupportedOperationException("Not implemented");
  }

  private static void generatePdf(List<Feature> features) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
