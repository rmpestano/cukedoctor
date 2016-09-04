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

            Element contentElement = doc.getElementById("footer");
            if (System.getProperty(STYLE_DISABLE_EXT_KEY) == null) {
                addStyleClass(contentElement);
            }

            return doc.html();

        } else {
            return output;
        }
    }

    private void addStyleClass(Element contentElement) {
        String styleClass = " <style>  \n" + "\n" + "#content:padding:0!important;\n" + ".sidebarblock, .sectionbody, .content{\n" + "overflow:auto!important;\n" + "}\n";

        contentElement.after(styleClass);
    }


}
