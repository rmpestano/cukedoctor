package com.github.cukedoctor.extension;

import com.github.cukedoctor.extension.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.STYLE_DISABLE_EXT_KEY;
import static java.nio.charset.Charset.defaultCharset;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.newInputStream;

/**
 * Created by pestano on 20/07/15.
 * extends html document styles
 */
public class CukedoctorStyleExtension extends Postprocessor {

    private static final Logger LOG = Logger.getLogger(CukedoctorStyleExtension.class.getName());

    public static final String BASE_DIR = exists(Paths.get("target")) ? Paths.get("target").toString() :
            exists(Paths.get("bin")) ? Paths.get("bin").toString() : Paths.get("").toString();

    public static final String CUKEDOCTOR_CUSTOMIZATION_DIR = getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR") == null ? BASE_DIR : getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR");

    @Override
    public String process(Document document, String output) {
        if (document.isBasebackend("html")) {
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
        if (!files.isEmpty()) {
            String themePath = files.get(0);
            themePath = themePath.replaceAll("\\\\", "/");
            try {
                String customCss = IOUtils.toString(newInputStream(Paths.get(themePath)), defaultCharset());
                Elements head = document.getElementsByTag("head");
                head.append(" <style> " + customCss + "</style>");
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Could not copy cukedoctor css from: " + themePath, e);
            }
        }
    }

    private static String getProperty(String property) {
        return System.getProperty(property);
    }


}
