package com.github.cukedoctor.api;

import com.github.cukedoctor.api.builder.AttributesBuilder;
import com.github.cukedoctor.builder.CukedoctorDocumentBuilderImpl;
import io.github.robwin.markup.builder.MarkupDocBuilder;

/**
 * Created by pestano on 17/02/16.
 */
public interface CukedoctorDocumentBuilder extends MarkupDocBuilder {



    AttributesBuilder attributes();

    CukedoctorDocumentBuilder sideBarBlock(String text);


    CukedoctorDocumentBuilder append(Object... text);


    CukedoctorDocumentBuilder textLine(String text);

    void clear();

    public static class Factory {

        private static CukedoctorDocumentBuilder instance;

        public static synchronized CukedoctorDocumentBuilder instance() {
            if (instance == null) {
                instance = new CukedoctorDocumentBuilderImpl();
            }
            return instance;
        }

        public static synchronized CukedoctorDocumentBuilder newInstance() {
            instance = null;
            return instance();
        }
    }
}
