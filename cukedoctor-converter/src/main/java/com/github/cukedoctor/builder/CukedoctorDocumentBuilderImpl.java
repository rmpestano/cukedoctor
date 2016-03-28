package com.github.cukedoctor.builder;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notEmpty;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.builder.AttributesBuilder;
import com.github.cukedoctor.markup.Asciidoc;
import com.github.cukedoctor.util.Constants;

import io.github.robwin.markup.builder.asciidoc.AsciiDocBuilder;

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
    public CukedoctorDocumentBuilder append(Object... text) {
        if(notEmpty(text)){
            for (Object o : text) {
                if(o.equals(Constants.newLine()) || hasText(o.toString())){
                    documentBuilder.append(o.toString());
                }
            }
        }
        return this;
    }

    @Override
    public CukedoctorDocumentBuilder textLine(String text) {
        if(text == Constants.newLine() || hasText(text)){
            super.textLine(text);
        }
        return this;
    }

    public void clear(){
        documentBuilder = new StringBuilder();
    }
}
