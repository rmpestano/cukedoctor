package com.github.cukedoctor.extension;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;

import java.util.Map;

import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 * Created by pestano on 20/07/15.
 * extends html document styles
 */
public class CukedoctorStyleExtension extends Postprocessor{

    public CukedoctorStyleExtension(Map<String, Object> config) {
        super(config);
    }

    @Override
    public String process(Document document, String output) {
        if (document.basebackend("html")) {
            org.jsoup.nodes.Document doc = Jsoup.parse(output, "UTF-8");


            if (System.getProperty(STYLE_DISABLE_EXT_KEY) == null) {
                Element contentElement = doc.getElementById("footer");
                addFooterStyle(contentElement);
                addCukedoctorCss(document);
            }

            return doc.html();

        } else {
            return output;
        }
    }

    private void addFooterStyle(Element contentElement) {
        String styleClass = " <style>  \n" + "\n" + "#content:padding:0!important;\n" + ".sidebarblock, .sectionbody, .content{\n" + "overflow:auto!important;\n" + "}\n";

        contentElement.after(styleClass);
    }

    private void addCukedoctorCss(Document document) {


    }


}
