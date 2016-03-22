package com.github.cukedoctor.extension;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;

import com.github.cukedoctor.extension.util.FileUtil;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.File;
import java.util.Map;

/**
 * Created by pestano on 20/07/15.
 * adds search box to rendered html documentation
 */
public class CukedoctorThemeExtension extends Postprocessor {

    public CukedoctorThemeExtension(Map<String, Object> config) {
        super(config);
    }

    @Override
    public String process(Document document, String output) {
        if (document.basebackend("html") && System.getProperty(THEME_DISABLE_EXT_KEY) == null) {
            Object docDir = document.getAttributes().get("docdir");
            if (docDir != null && new File(docDir.toString()).exists()) {
                File themeDir = new File(docDir.toString() + "/themes/");
                boolean created = false;
                created = themeDir.mkdir();
                if (created) {
                    FileUtil.copyFile("/themes/colony.css", docDir + "/themes/colony.css");
                    FileUtil.copyFile("/themes/foundation.css", docDir + "/themes/foundation.css");
                    FileUtil.copyFile("/themes/rubygems.css", docDir + "/themes/rubygems.css");
                    FileUtil.copyFile("/themes/iconic.css", docDir + "/themes/iconic.css");
                    FileUtil.copyFile("/themes/readthedocs.css", docDir + "/themes/readthedocs.css");
                    FileUtil.copyFile("/themes/rocket-panda.css", docDir + "/themes/rocket-panda.css");
                    FileUtil.copyFile("/themes/maker.css", docDir + "/themes/maker.css");
                    FileUtil.copyFile("/themes/github.css", docDir + "/themes/github.css");
                }
            }

            org.jsoup.nodes.Document doc = Jsoup.parse(output, "UTF-8");
            Object tocPosition = document.document().getAttributes().get("toc-position");
            boolean isTocRight = tocPosition != null && tocPosition.toString().equalsIgnoreCase("right");
            Element contentElement = doc.getElementsByAttributeValue("id", "header").get(0);
            contentElement.before("<div name=\"themes\" id=\"themes\" style=\"" +
                    "" + (!isTocRight ? "float:right;" : "") +
                    "width:150px;font-size:10px;position:relative;top:0;right:0px\"><b>Theme:&nbsp;</b>\n" +
                    "<select style=\"width:100px;font-size:10px;\" name=\"select\" onchange=\"window.location.href = window.location.href.substring(0,window.location.href.indexOf('?')) + '?theme='+ this.value\">\n" +
                    "  <option value=\"asciidoctor\" selected>Asciidoctor</option> \n" +
                    "  <option value=\"colony\">Colony</option>\n" +
                    "  <option value=\"foundation\" >Foundation</option>\n" +
                    "  <option value=\"github\">Github</option>\n" +
                    "  <option value=\"iconic\">Iconic</option>\n" +
                    "  <option value=\"maker\">Maker</option>\n" +
                    "  <option value=\"rocket-panda\">Rocket Panda</option>\n" +
                    "  <option value=\"readthedocs\">Read the Docs</option>\n" +
                    "  <option value=\"rubygems\">Rubygems</option>\n" +
                    "</select>\n" +
                    "</div>");
            return doc.html();

        } else {
            return output;
        }
    }

}
