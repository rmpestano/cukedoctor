package com.github.cukedoctor.extension;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;

import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

/**
 * Created by pestano on 20/07/15.
 * adds search box to rendered html documentation
 */
public class CukedoctorFilterExtension extends Postprocessor {

    public CukedoctorFilterExtension(Map<String, Object> config) {
        super(config);
    }

    @Override
    public String process(Document document, String output) {
        if (document.basebackend("html") && System.getProperty(FILTER_DISABLE_EXT_KEY) == null) {
            org.jsoup.nodes.Document doc = Jsoup.parse(output, "UTF-8");

            Elements sect1 = doc.getElementsByClass("sect1");
            if (!sect1.isEmpty()) {
                Element contentElement = doc.getElementsByClass("sect1").get(0);
                contentElement.before("<span style=\"float:right\">\n" +
                        "\t<input value=\"Filter...\" onclick=\"this.value=''\" title=\"Filter features by title\" onblur=\"searchFeature(this.value);\"/>\n" +
                        "</span>");
            }
            return doc.html();
        } else {
            return output;
        }
    }

}
