package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.ScenarioResults;
import com.github.cukedoctor.api.StepResults;
import com.github.cukedoctor.api.model.Element;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.util.Constants;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by pestano on 02/06/15.
 */
public class CukedoctorReporter {


    private static CukedoctorReporter instance;
    private List<Feature> features;
    private StringBuilder documentation;
    private DocumentAttributes documentAttributes;
    private String documentTitle;

    private CukedoctorReporter() {

    }


    /**
     * @param features      used to generate the documentation
     * @param documentTitle first section (H1) documentTitle
     * @param config        document attributes
     * @return a Cukedoctor reporter instance
     */
    public synchronized static CukedoctorReporter instance(List<Feature> features, String documentTitle, DocumentAttributes config) {

        if (features == null || features.isEmpty()) {
            throw new RuntimeException("No features found");
        }

        if (documentTitle == null || "".equals(documentTitle.trim())) {
            throw new RuntimeException("Provide document title");
        }

        if (instance == null) {
            instance = new CukedoctorReporter();
        }
        if (config == null) {
            config = new DocumentAttributes();
        }
        if(config.getDocTitle() == null){
            config.docTitle(documentTitle); //use documentTitle as docTitle attr if no title is provided
        }
        instance.documentAttributes = config;
        instance.features = features;
        instance.documentTitle = documentTitle;
        instance.documentation = new StringBuilder();
        return instance;
    }

    /**
     * @param features used to generate the documentation
     * @param title    first section (H1) documentTitle
     * @return a Cukedoctor reporter instance
     */
    public synchronized static CukedoctorReporter instance(List<Feature> features, String title) {

        return instance(features, title, new DocumentAttributes());
    }

    public static synchronized CukedoctorReporter getCurrentInstance() {
        if (instance == null) {
            throw new RuntimeException("There is no Cukedoctor report instance, call instance() method to createDocumentation one");
        }
        return instance;
    }


    protected DocumentAttributes getDocumentAttributes() {
        return documentAttributes;
    }

    protected List<Feature> getFeatures() {
        return features;
    }

    protected StringBuilder getDocumentation() {
        return documentation;
    }

    protected String getDocumentTitle() {
        return documentTitle;
    }

    /**
     * creates a string representation of the current document in Asciidoctor format
     */
    protected String createDocumentation() {
        renderAttributes();
        renderSummary();
        for (Feature feature : features) {
            renderFeature(feature);
        }

        return documentation.toString();
    }

    protected CukedoctorReporter renderFeature(Feature feature) {
        renderFeatureOverview(feature).
        renderFeatureTags(feature.getTags());
        renderFeatureScenarios(feature.getElements());
        return instance;
    }

    protected CukedoctorReporter renderFeatureScenarios(List<Element> elements) {
        throw new NotImplementedException();
    }

    protected CukedoctorReporter renderScenarioSteps(List<Step> steps) {
        throw new NotImplementedException();
    }

    protected CukedoctorReporter renderFeatureTags(List<Tag> tags) {
        throw new NotImplementedException();
    }

    protected CukedoctorReporter renderFeatureOverview(Feature feature) {
        throw new NotImplementedException();
    }

    protected CukedoctorReporter renderAttributes() {
        append(Constants.Markup.TOC,true).
                append(documentAttributes.getToc(),true).
                append(Constants.Markup.BACKEND).append(documentAttributes.getBackend(),true).
                append(Constants.Markup.DOC_TITLE).append(documentAttributes.getDocTitle(), true).
            append(Constants.Markup.DOC_TYPE).append(documentAttributes.getDocType(),true).
                append(Constants.Markup.ICONS).append(documentAttributes.getIcons(),true).
                append(documentAttributes.isNumbered() ? Constants.Markup.NUMBERED : Constants.Markup.NOT_NUMBERED,true).
                append(documentAttributes.isSectAnchors() ? Constants.Markup.SECT_ANCHORS : Constants.Markup.NOT_SECT_ANCHORS,true).
                append(documentAttributes.isSectLink() ? Constants.Markup.SECT_LINK : Constants.Markup.NOT_SECT_LINK,true);
        return instance;
    }

    /**
     * Document overall summary which gathers information about all features like
     * number of steps, execution time, total passed scenarios and so on
     */
    protected CukedoctorReporter renderSummary() {
        append(Constants.Markup.H1).append(documentTitle);


        for (Feature feature : features) {
            StepResults stepResults = feature.getStepResults();
            ScenarioResults scenarioResults = feature.getScenarioResults();
            //TODO render a table with features general results
        }
        return instance;
    }


    protected CukedoctorReporter append(String value) {
        if (value != null) {
            documentation.append(value.replaceAll("\\n", Constants.NEW_LINE));
        }
        return instance;
    }

    protected CukedoctorReporter append(String value, boolean newLine) {
        if (value != null) {
            documentation.append(value.replaceAll("\\n", Constants.NEW_LINE));
        }
        if(newLine){
            documentation.append(Constants.NEW_LINE);
        }
        return instance;
    }


}
