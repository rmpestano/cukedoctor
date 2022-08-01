package com.github.cukedoctor.extension;

import java.util.Map;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.extension.BlockMacroProcessor;

/** Created by pestano on 20/07/15. */
public class CukedoctorMinMaxExtension extends BlockMacroProcessor {

  @Override
  public Object process(StructuralNode parent, String target, Map<String, Object> map) {
    if (!parent.getDocument().isBasebackend("pdf")) {
      String minMax =
          "<span class=\"fa fa-minus-square fa-fw\""
              + " style=\"cursor:pointer;float:right;margin-top:-30px\" "
              + " title=\"Minimize\" onclick=\"hideFeatureScenarios('"
              + target
              + "');document.getElementById('hidden-"
              + target
              + "').style.display = 'inline';this.style.display = 'none'\">  </span>\n\n"
              + "<span id=\"hidden-"
              + target
              + "\""
              + " class=\"fa fa-plus-square fa-fw\""
              + " style=\"cursor:pointer;float:right;display:none;margin-top:-30px\""
              + " title=\"Maximize feature\" onclick=\"showFeatureScenarios('"
              + target
              + "');"
              + "this.style.display = 'none'\">  </span>";
      return createBlock(parent, "pass", minMax);
    } else {
      return null;
    }
  }
}
