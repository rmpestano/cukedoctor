package com.github.cukedoctor.builder;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.builder.AttributesBuilder;
import com.github.cukedoctor.markup.Asciidoc;
import com.github.cukedoctor.util.Constants;
import io.github.robwin.markup.builder.MarkupDocBuilder;
import io.github.robwin.markup.builder.asciidoc.AsciiDocBuilder;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notEmpty;

/**
 * Created by pestano on 17/02/16.
 */
public class CukedoctorDocumentBuilderImpl extends AsciiDocBuilder implements CukedoctorDocumentBuilder {


    private AttributesBuilder attrsBuilder;


    @Override
    public AttributesBuilder attributes() {
        if(attrsBuilder == null){
            attrsBuilder = new AttributesBuilderImpl(this);
        }
        return attrsBuilder;
    }

    @Override
    public CukedoctorDocumentBuilder sideBarBlock(String text) {
        delimitedTextLine(Asciidoc.SIDEBAR_BLOCK, text);
        return this;
    }

    @Override
    public CukedoctorDocumentBuilder append(String... text) {
        if(notEmpty(text)){
            for (String s : text) {
                if(s == Constants.newLine() || hasText(s)){
                    documentBuilder.append(s);
                }
            }
        }
        return this;
    }

    @Override
    public MarkupDocBuilder textLine(String text) {
        if(text == Constants.newLine() || hasText(text)){
            return super.textLine(text);
        }
        return this;
    }
}
