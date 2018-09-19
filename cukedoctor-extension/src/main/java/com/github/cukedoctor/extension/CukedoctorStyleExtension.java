package com.github.cukedoctor.extension;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.cukedoctor.extension.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by pestano on 20/07/15.
 * extends html document styles
 */
public class CukedoctorStyleExtension extends Postprocessor {

    public static Logger log = Logger.getLogger(CukedoctorStyleExtension.class.getName());

    public static final String BASE_DIR =  Files.exists(Paths.get("target")) ? Paths.get("target").toString() :
            Files.exists(Paths.get("bin")) ? Paths.get("bin").toString() : Paths.get("").toString();

    public static final String CUKEDOCTOR_CUSTOMIZATION_DIR = getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR") == null ? BASE_DIR : getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR");


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
                addCukedoctorCss(doc);
            }

            return doc.html();

        } else {
            return output;
        }
    }

    private void addFooterStyle(Element contentElement) {
        String styleClass = " <style>  \n" + "\n" + "#content:padding:0!important;\n" + ".sidebarblock, .sectionbody, .content{\n" + "overflow:auto!important;\n" + "}\ndiv.sidebarblock {overflow-y:hidden;overflow-x:auto}\n body .exampleblock > .content{ background:#fff}";

        contentElement.after(styleClass);
    }

    private void addCukedoctorCss(org.jsoup.nodes.Document document) {
        List<String> files = FileUtil.findFiles(CUKEDOCTOR_CUSTOMIZATION_DIR, "cukedoctor.css", true);
        if(files != null && !files.isEmpty()) {
            String themePath = files.get(0);
            themePath = themePath.replaceAll("\\\\","/");
            try {
                String customCss = IOUtils.toString(new FileInputStream(themePath));
                Elements head = document.getElementsByTag("head");
                head.append(" <style> "+customCss);
            } catch (IOException e) {
                log.log(Level.SEVERE, "Could not copy cukedoctor css from: " + themePath, e);
            }
        }
    }

    private static String getProperty(String property) {
        if(System.getProperty(property) == null){
            return null;
        }
        return System.getProperty(property);
    }



}
