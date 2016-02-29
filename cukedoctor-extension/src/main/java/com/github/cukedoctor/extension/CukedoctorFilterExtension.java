package com.github.cukedoctor.extension;

import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.Map;

/**
 * Created by pestano on 20/07/15.
 * adds search box to rendered html documentation
 */
public class CukedoctorFilterExtension extends Postprocessor{

    public CukedoctorFilterExtension(Map<String, Object> config) {
        super(config);
    }

    @Override
    public String process(Document document, String output) {
        if(document.basebackend("html") && System.getProperty("cukedoctor.disable.filter") == null){
            org.jsoup.nodes.Document doc = Jsoup.parse(output, "UTF-8");

            Element contentElement = doc.getElementsByClass("sect1").get(0);
            contentElement.before("<span style=\"float:right\">\n" +
                    "\t<input value=\"Filter...\" onclick=\"this.value=''\" title=\"Filter features by title\" onblur=\"searchFeature(this.value);\"/>\n" +
                    "</span>");
            return doc.html();

        }else{
            return output;
        }
    }

}
