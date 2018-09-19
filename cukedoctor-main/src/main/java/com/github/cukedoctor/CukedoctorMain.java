package com.github.cukedoctor;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.asciidoctor.extension.ExtensionGroup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.CUKEDOCTOR_EXTENSION_GROUP_NAME;
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
    
    @Parameter(names = "-chapterLabel", description = "Chapter Label. Default is 'Chapter' ", required = false)
    private String chapterLabel;
    
    @Parameter(names = "-versionLabel", description = "Version Label. Default is 'Version' ", required = false)
    private String versionLabel;

    @Parameter(names = "-hardbreaks", description = "Sets asciidoctor hardbreaks attribute. Default is true ", required = false)
    private Boolean hardBreaks;

    @Parameter(names = "-docVersion", description = "Documentation version", required = false)
    private String docVersion;

    @Parameter(names = "-hideFeaturesSection", description = "Hides the 'features' section. Default is false ", required = false)
    private Boolean hideFeaturesSection;

    @Parameter(names = "-hideSummarySection", description = "Hides the 'summary' section. Default is false ", required = false)
    private Boolean hideSummarySection;

    @Parameter(names = "-hideScenarioKeyword", description = "Hides the 'Scenario' keyword in scenario name. Default is false ", required = false)
    private Boolean hideScenarioKeyword;

    @Parameter(names = "-hideStepTime", description = "Does not render step time. Default is false ", required = false)
    private Boolean hideStepTime;

    @Parameter(names = "-hideTags", description = "Does not render tags. Default is false ", required = false)
    private Boolean hideTags;

    @Parameter(names = "-cucumberResultPaths", description = "Restricts the search to a list of paths, The list is obtained by splitting cucumberResultPaths using File.pathSeparator", required = false)
    private String cucumberResultPaths;

    @Parameter(names = "-sourceHighlighter", description = "Configures source highlighter. Default is highlightjs", required = false)
    private String sourceHighlighter;

    @Parameter(names = "-allowUriRead", description = "Allow include content be referenced by an URI. Default is false", required = false)
    private Boolean allowUriRead;

    private static List<Feature> searchPathAndScan(String path) {
        if (path.endsWith(".json")) {
            return FeatureParser.parse(FileUtil.findJsonFile(path));
        } else {
            return FeatureParser.parse(FileUtil.findJsonFiles(path));
        }
    }

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

        if (format == null || (format.equals("html") && !format.equals("html5") && !format.equals("pdf") && !format.equals("all"))) {
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

        if (numbered == null) {
            numbered = false;
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
            features = new ArrayList<Feature>();
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


        DocumentAttributes documentAttributes = GlobalConfig.newInstance().getDocumentAttributes().
                backend(format).
                toc(toc).
                revNumber(docVersion).
                hardBreaks(hardBreaks).
                numbered(numbered).
                chapterLabel(chapterLabel).
                versionLabel(versionLabel);

        if(sourceHighlighter != null){
            documentAttributes.sourceHighlighter(sourceHighlighter);
        }

        if (outputName.contains(".")) {
            outputName = outputName.substring(0, outputName.lastIndexOf(".")) + ".adoc";
        } else {
            outputName = outputName + ".adoc";
        }
        documentAttributes.docTitle(title);

        String resultDoc = null;
        if ("all".equals(format)) {
            documentAttributes.backend("html5");
            resultDoc = this.execute(features, documentAttributes, outputName);
            documentAttributes.backend("pdf");
            this.execute(features, documentAttributes, outputName);
        } else {
            resultDoc = this.execute(features, documentAttributes, outputName);
        }
        return resultDoc;
    }

    public static void main(String args[]) {
        CukedoctorMain main = new CukedoctorMain();
        main.execute(args);
    }

    public String execute(List<Feature> features, DocumentAttributes attrs, String outputName) {
        if (title == null) {
            title = "Living Documentation";
        }
        if (attrs == null) {
            attrs = new DocumentAttributes().docTitle(title);
        }
        if (!hasText(attrs.getBackend())) {
            attrs.backend("html5");
        }
        if (outputName == null) {
            outputName = title.replaceAll(" ", "_");
        }

        if (hideFeaturesSection != null) {
            System.setProperty("HIDE_FEATURES_SECTION", Boolean.toString(hideFeaturesSection));
        }

        if (hideSummarySection != null) {
            System.setProperty("HIDE_SUMMARY_SECTION", Boolean.toString(hideSummarySection));
        }

        if (hideScenarioKeyword != null) {
            System.setProperty("HIDE_SCENARIO_KEYWORD", Boolean.toString(hideScenarioKeyword));
        }

        if (hideStepTime != null) {
            System.setProperty("HIDE_STEP_TIME", Boolean.toString(hideStepTime));
        }

        if (hideTags != null) {
            System.setProperty("HIDE_TAGS", Boolean.toString(hideTags));
        }

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        String doc = converter.renderDocumentation();
        File adocFile = FileUtil.saveFile(outputName, doc);
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        ExtensionGroup cukedoctorExtensionGroup = asciidoctor.createGroup(CUKEDOCTOR_EXTENSION_GROUP_NAME);
        if (attrs.getBackend().equalsIgnoreCase("pdf")) {
            cukedoctorExtensionGroup.unregister();
        }
        
        OptionsBuilder ob;
        ob = OptionsBuilder.options().backend(attrs.getBackend());
        ob.safe(SafeMode.UNSAFE);

        if (allowUriRead != null && allowUriRead) {
            Attributes attr = new Attributes();
            attr.setAllowUriRead(true);
            ob.attributes(attr);
        }
        
       String aaaa =  asciidoctor.convertFile(adocFile, ob.asMap());
        asciidoctor.shutdown();
        return doc;
    }

}
