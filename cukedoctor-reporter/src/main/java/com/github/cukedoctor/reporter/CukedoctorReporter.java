package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.ScenarioResults;
import com.github.cukedoctor.api.StepResults;
import com.github.cukedoctor.api.model.Element;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.DocWriter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Writer;
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
    private DocWriter writer;

    private CukedoctorReporter() {

    }


    /**
     * @param features      used to generate the documentation
     * @param documentTitle first section (H1) documentTitle
     * @param attrs        document attributes
     * @return a Cukedoctor reporter instance
     */
    public synchronized static CukedoctorReporter instance(List<Feature> features, String documentTitle, DocumentAttributes attrs) {

        if (features == null || features.isEmpty()) {
            throw new RuntimeException("No features found");
        }

        if (documentTitle == null || "".equals(documentTitle.trim())) {
            throw new RuntimeException("Provide document title");
        }

        if (instance == null) {
            instance = new CukedoctorReporter();
        }
        if (attrs == null) {
            attrs = new DocumentAttributes();
        }
        if (attrs.getDocTitle() == null) {
            attrs.docTitle(documentTitle); //use documentTitle as docTitle attr if no title is provided
        }
        instance.documentAttributes = attrs;
        instance.features = features;
        instance.documentTitle = documentTitle;
        instance.documentation = new StringBuilder();
        instance.writer = DocWriter.getInstance(instance.documentation);
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
        writer.write(Constants.Markup.TOC, documentAttributes.getToc(), Constants.NEW_LINE).
                write(Constants.Markup.BACKEND, documentAttributes.getBackend(), Constants.NEW_LINE).
                write(Constants.Markup.DOC_TITLE, documentAttributes.getDocTitle(), Constants.NEW_LINE).
                write(Constants.Markup.DOC_TYPE, documentAttributes.getDocType(), Constants.NEW_LINE).
                write(Constants.Markup.ICONS, documentAttributes.getIcons(), Constants.NEW_LINE).
                write(documentAttributes.isNumbered() ? Constants.Markup.NUMBERED : Constants.Markup.NOT_NUMBERED, true).
                write(documentAttributes.isSectAnchors() ? Constants.Markup.SECT_ANCHORS : Constants.Markup.NOT_SECT_ANCHORS, true).
                write(documentAttributes.isSectLink() ? Constants.Markup.SECT_LINK : Constants.Markup.NOT_SECT_LINK, true);
        return instance;
    }

    /**
     * Document overall summary which gathers information about all features like
     * number of steps, execution time, total passed scenarios and so on
     */
    protected CukedoctorReporter renderSummary() {
        writer.write(Constants.Markup.H1, documentTitle);

        for (Feature feature : features) {
            StepResults stepResults = feature.getStepResults();
            ScenarioResults scenarioResults = feature.getScenarioResults();
            //TODO render a table with features general results
        }
        return instance;
    }


}
