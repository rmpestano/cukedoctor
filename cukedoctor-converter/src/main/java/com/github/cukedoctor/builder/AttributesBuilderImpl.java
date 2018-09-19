package com.github.cukedoctor.builder;

import com.github.cukedoctor.api.builder.AttributesBuilder;
import com.github.cukedoctor.util.Constants;
import io.github.robwin.markup.builder.asciidoc.AsciiDocBuilder;

import static com.github.cukedoctor.util.Assert.hasText;

/**
 * Created by pestano on 17/02/16.
 */
public class AttributesBuilderImpl implements AttributesBuilder {

    private AsciiDocBuilder docBuilder;

    public AttributesBuilderImpl(AsciiDocBuilder docBuilder){
        this.docBuilder = docBuilder;
    }

    @Override
    public AttributesBuilder toc(String value) {
        docBuilder.textLine(Constants.Atributes.toc(value));
        return this;
    }

    @Override
    public AttributesBuilder backend(String value) {
        docBuilder.textLine(Constants.Atributes.backend(value));
        return this;
    }

    @Override
    public AttributesBuilder docTitle(String value) {
        docBuilder.textLine(Constants.Atributes.docTitle(value));
        return this;
    }

    @Override
    public AttributesBuilder docType(String value) {
        docBuilder.textLine(Constants.Atributes.docType(value));
        return this;
    }

    @Override
    public AttributesBuilder icons(String value) {
        docBuilder.textLine(Constants.Atributes.icons(value));
        return this;
    }

    @Override
    public AttributesBuilder numbered(boolean value) {
        docBuilder.textLine(Constants.Atributes.numbered(value));
        return this;
    }

    @Override
    public AttributesBuilder linkcss(boolean value) {
        docBuilder.textLine(Constants.Atributes.linkcss(value));
        return this;
    }

    @Override
    public AttributesBuilder sectAnchors(boolean value) {
        docBuilder.textLine(Constants.Atributes.sectAnchors(value));
        return this;
    }

    @Override
    public AttributesBuilder sectLink(boolean value) {
        docBuilder.textLine(Constants.Atributes.sectLink(value));
        return this;
    }

    @Override
    public AttributesBuilder docInfo(boolean value) {
        docBuilder.textLine(Constants.Atributes.docInfo(value));
        return this;
    }

    @Override
    public AttributesBuilder hardBreaks(boolean value) {
        docBuilder.textLine(Constants.Atributes.hardBreaks(value));
        return this;
    }

    @Override
    public AttributesBuilder sourceHighlighter(String value) {
        docBuilder.textLine(Constants.Atributes.sourceHighlighter(value));
        return this;
    }

    @Override
    public AttributesBuilder tocLevels(String value) {
        docBuilder.textLine(Constants.Atributes.tocLevels(value));
        return this;
    }
    

    @Override
    public AttributesBuilder chapterLabel(String value) {
	docBuilder.textLine(Constants.Atributes.chapterLabel(value));
        return this;
    }
    
    @Override
    public AttributesBuilder versionLabel(String value) {
	docBuilder.textLine(Constants.Atributes.versionLabel(value));
        return this;
    }

    @Override
    public AttributesBuilder pdfStyle(String value) {
        docBuilder.textLine(Constants.Atributes.pdfStyle(value));
        return this;
    }

    @Override
    public AsciiDocBuilder asciiDocBuilder(){
        return docBuilder;
    }

    @Override
    public AttributesBuilder revNumber(String value) {
        if(hasText(value)){
            docBuilder.textLine(Constants.Atributes.revNumber(value));
        } else{
            //verify system property
            String revNumberSysProp = System.getProperty("docVersion");
            if(revNumberSysProp != null){
                docBuilder.textLine(Constants.Atributes.revNumber(revNumberSysProp));
            }
        }
        return this;
    }



}
