package com.github.cukedoctor;

import static com.github.cukedoctor.util.Assert.hasText;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

/**
 * Created by pestano on 08/06/15. java -jar cukedoctor.jar -o docName -f html|pdf -p
 * /path/to/cucumber-json-files/
 */
public class CukedoctorMain {

  @Parameter(
      names = "-f",
      description = "Document format - supported html, pdf and all. Default is 'html'",
      required = false,
      echoInput = true)
  private String format;

  @Parameter(
      names = "-p",
      description =
          "Path to cucumber json output files (can be a directory or a file). Default is current directory",
      required = false)
  private String path;

  @Parameter(
      names = "-t",
      description = "Documentation title (first section). Default is 'Living Documentation'",
      required = false)
  private String title;

  @Parameter(
      names = "-o",
      description =
          "File output name, can be a path eg: /home/doc which will result in doc.html|pdf in /home dir. Document title will be used if output name is not provided",
      required = false)
  private String outputName;

  @Parameter(
      names = "-toc",
      description = "Table of contents position. Default is 'right' ",
      required = false)
  private String toc;

  @Parameter(
      names = "-numbered",
      description = "Section numbering. Default is false ",
      required = false)
  private Boolean numbered = null;

  @Parameter(
      names = "-chapterLabel",
      description = "Chapter Label. Default is 'Chapter' ",
      required = false)
  private String chapterLabel;

  @Parameter(
      names = "-versionLabel",
      description = "Version Label. Default is 'Version' ",
      required = false)
  private String versionLabel;

  @Parameter(
      names = "-hardbreaks",
      description = "Sets asciidoctor hardbreaks attribute. Default is true ",
      arity = 1,
      required = false)
  private Boolean hardBreaks;

  @Parameter(names = "-docVersion", description = "Documentation version", required = false)
  private String docVersion;

  @Parameter(
      names = "-hideFeaturesSection",
      description = "Hides the 'features' section. Default is false ",
      required = false)
  private Boolean hideFeaturesSection;

  @Parameter(
      names = "-hideSummarySection",
      description = "Hides the 'summary' section. Default is false ",
      required = false)
  private Boolean hideSummarySection;

  @Parameter(
      names = "-hideScenarioKeyword",
      description = "Hides the 'Scenario' keyword in scenario name. Default is false ",
      required = false)
  private Boolean hideScenarioKeyword;

  @Parameter(
      names = "-hideStepTime",
      description = "Does not render step time. Default is false ",
      required = false)
  private Boolean hideStepTime;

  @Parameter(
      names = "-hideTags",
      description = "Does not render tags. Default is false ",
      required = false)
  private Boolean hideTags;

  @Parameter(
      names = "-cucumberResultPaths",
      description =
          "Restricts the search to a list of paths, The list is obtained by splitting cucumberResultPaths using File.pathSeparator",
      required = false)
  private String cucumberResultPaths;

  @Parameter(
      names = "-sourceHighlighter",
      description = "Configures source highlighter. Default is highlightjs",
      required = false)
  private String sourceHighlighter;

  @Parameter(
      names = "-allowUriRead",
      description = "Allow include content be referenced by an URI. Default is false",
      required = false)
  private Boolean allowUriRead;

  @Parameter(
      names = "-stem",
      description =
          "Sets asciidoctor stem attribute with the specified interpreter. By default, the stem attribute is set using asciidoctor's default interpreter ",
      required = false)
  private String stem;

  @Parameter(
      names = "-dataUri",
      description =
          "Sets AsciiDoc :data-uri: attribute, causing all images in the document to be embedded as data URIs. Default is false.",
      required = false)
  private Boolean dataUri;

  private static List<Feature> searchPathAndScan(String path) {
    if (path.endsWith(".json")) {
      return FeatureParser.parse(FileUtil.findJsonFile(path));
    } else {
      return FeatureParser.parse(FileUtil.findJsonFiles(path));
    }
  }

  /**
   * Entry point for the cukedoctor executable
   *
   * @param args command line arguments
   * @return the final document generated by cukedoctor
   */
  public String execute(String args[]) {
    JCommander commandLine = null;
    try {
      commandLine = new JCommander(this);
      commandLine.parse(args);
    } catch (ParameterException pe) {
      commandLine.usage();
      throw pe;
    }

    if (!hasText(title)) {
      title = "Living Documentation";
    }

    if (outputName == null) {
      outputName = title.replaceAll(" ", "-");
    }

    if (format == null || format.equals("html")) {
      format = "html5";
    }

    if (!hasText(path)) {
      path = "";
    }

    if (!hasText(outputName)) {
      outputName = "documentation";
    }

    if (!hasText(toc)) {
      toc = "right";
    }

    if (!hasText(chapterLabel)) {
      chapterLabel = "Chapter";
    }

    if (!hasText(versionLabel)) {
      versionLabel = "Version";
    }

    if (hardBreaks == null) {
      hardBreaks = Boolean.TRUE;
    }

    System.out.println("Generating living documentation with args:");

    System.out.println("-f" + ": " + format);
    System.out.println("-p" + ": " + path);
    System.out.println("-t" + ": " + title);
    System.out.println("-o" + ": " + outputName);

    List<Feature> features = null;
    if (cucumberResultPaths != null) {
      features = new ArrayList<>();
      String[] resultPaths = cucumberResultPaths.split(Pattern.quote(File.pathSeparator));
      for (String resultPath : resultPaths) {
        List<Feature> tempList = searchPathAndScan(resultPath);
        if (tempList != null) {
          features.addAll(tempList);
        }
      }
    } else {
      features = searchPathAndScan(path);
    }

    if (features == null || features.isEmpty()) {
      System.out.println("No features found in path:" + path);
      return null;
    } else {
      System.out.println("Found " + features.size() + " feature(s)");
    }

    final DocumentAttributes documentAttributes =
        GlobalConfig.newInstance()
            .getDocumentAttributes()
            .backend(format)
            .toc(toc)
            .revNumber(docVersion)
            .hardBreaks(hardBreaks)
            .numbered(numbered)
            .chapterLabel(chapterLabel)
            .versionLabel(versionLabel)
            .stem(stem);

    if (sourceHighlighter != null) {
      documentAttributes.sourceHighlighter(sourceHighlighter);
    }

    if (allowUriRead != null) {
      documentAttributes.allowUriRead(allowUriRead);
    }

    if (dataUri != null) {
      documentAttributes.dataUri(dataUri);
    }

    if (outputName.contains(".")) {
      outputName = outputName.substring(0, outputName.lastIndexOf(".")) + ".adoc";
    } else {
      outputName = outputName + ".adoc";
    }
    documentAttributes.docTitle(title);

    String resultDoc = null;
    final CukedoctorConfig cukedoctorConfig = cukedoctorConfig();
    if ("all".equals(format)) {
      documentAttributes.backend("html5");
      resultDoc = this.execute(features, documentAttributes, cukedoctorConfig, outputName);
      documentAttributes.backend("pdf");
      this.execute(features, documentAttributes, cukedoctorConfig, outputName);
    } else {
      resultDoc = this.execute(features, documentAttributes, cukedoctorConfig, outputName);
    }
    return resultDoc;
  }

  /**
   * Java entry point
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    CukedoctorMain main = new CukedoctorMain();
    main.execute(args);
  }

  /**
   * Entry point for cukedoctor executable, with detailed customization.
   *
   * @param features list of features to parse
   * @param documentAttributes attributes for generating the doc
   * @param cukedoctorConfig configuration for cukedoctor
   * @param outputName documentation final name
   * @return the documentation generated by cukedoctor
   */
  public String execute(
      List<Feature> features,
      DocumentAttributes documentAttributes,
      CukedoctorConfig cukedoctorConfig,
      String outputName) {
    if (title == null) {
      title = "Living Documentation";
    }
    if (documentAttributes == null) {
      documentAttributes = new DocumentAttributes().docTitle(title);
    }
    if (!hasText(documentAttributes.getBackend())) {
      documentAttributes.backend("html5");
    }
    if (outputName == null) {
      outputName = documentAttributes.getDocTitle().replaceAll(" ", "_");
    }

    CukedoctorConverter converter =
        Cukedoctor.instance(features, documentAttributes, cukedoctorConfig);
    String doc = converter.renderDocumentation();
    File adocFile = FileUtil.saveFile(outputName, doc);
    final Asciidoctor asciidoctor = getAsciidoctor();
    asciidoctor.requireLibrary("asciidoctor-diagram");
    if (documentAttributes.getBackend().equalsIgnoreCase("pdf")) {
      asciidoctor.unregisterAllExtensions();
    }
    OptionsBuilder ob =
        OptionsBuilder.options()
            .safe(SafeMode.UNSAFE)
            .backend(documentAttributes.getBackend())
            .attributes(documentAttributes.toMap());
    System.out.println("Document attributes\n" + documentAttributes.toMap());
    asciidoctor.convertFile(adocFile, ob);
    asciidoctor.shutdown();
    return doc;
  }

  private CukedoctorConfig cukedoctorConfig() {
    CukedoctorConfig cukedoctorConfig = new CukedoctorConfig();
    if (hideFeaturesSection != null) {
      cukedoctorConfig.setHideFeaturesSection(hideFeaturesSection);
    }
    if (hideSummarySection != null) {
      cukedoctorConfig.setHideSummarySection(hideSummarySection);
    }
    if (hideScenarioKeyword != null) {
      cukedoctorConfig.setHideScenarioKeyword(hideScenarioKeyword);
    }
    if (hideStepTime != null) {
      cukedoctorConfig.setHideStepTime(hideStepTime);
    }
    if (hideTags != null) {
      cukedoctorConfig.setHideTags(hideTags);
    }
    return cukedoctorConfig;
  }

  private Asciidoctor getAsciidoctor() {
    ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
    Asciidoctor asciidoctor;
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      Thread.currentThread().setContextClassLoader(classLoader);
      asciidoctor = org.asciidoctor.jruby.AsciidoctorJRuby.Factory.create(classLoader);
    } finally {
      Thread.currentThread().setContextClassLoader(oldCl);
    }
    return asciidoctor;
  }
}
