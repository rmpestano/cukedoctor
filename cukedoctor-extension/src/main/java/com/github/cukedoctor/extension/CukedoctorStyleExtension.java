package com.github.cukedoctor.extension;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.STYLE_DISABLE_EXT_KEY;

import com.github.cukedoctor.extension.util.FileUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Created by pestano on 20/07/15. extends html document styles */
public class CukedoctorStyleExtension extends Postprocessor {

  private static final Logger log = LoggerFactory.getLogger(CukedoctorStyleExtension.class);

  /** Base directory, either {@code target} or {@code bin} depending on the execution context. */
  public static final String BASE_DIR =
      Files.exists(Paths.get("target"))
          ? Paths.get("target").toString()
          : Files.exists(Paths.get("bin")) ? Paths.get("bin").toString() : Paths.get("").toString();

  /**
   * Customization directory, default or overloaded by customizing {@code
   * CUKEDOCTOR_CUSTOMIZATION_DIR}.
   */
  public static final String CUKEDOCTOR_CUSTOMIZATION_DIR =
      getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR") == null
          ? BASE_DIR
          : getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR");

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
    String styleClass =
        " <style>  \n"
            + "\n"
            + "#content:padding:0!important;\n"
            + ".sidebarblock, .sectionbody, .content{\n"
            + "overflow:auto!important;\n"
            + "}\n"
            + "div.sidebarblock {overflow-y:hidden;overflow-x:auto}\n"
            + " body .exampleblock > .content{ background:#fff}";
    contentElement.after(styleClass);
  }

  private void addCukedoctorCss(org.jsoup.nodes.Document document) {
    List<String> files = FileUtil.findFiles(CUKEDOCTOR_CUSTOMIZATION_DIR, "cukedoctor.css", true);
    if (!files.isEmpty()) {
      String themePath = files.get(0);
      themePath = themePath.replace("\\", "/");
      try {
        String customCss = IOUtils.toString(new FileInputStream(themePath), StandardCharsets.UTF_8);
        Elements head = document.getElementsByTag("head");
        head.append(" <style> " + customCss + "</style>");
      } catch (IOException e) {
        log.error("Could not copy cukedoctor css from: {}", themePath, e);
      }
    }
  }

  private static String getProperty(String property) {
    if (System.getProperty(property) == null) {
      return null;
    }
    return System.getProperty(property);
  }
}
