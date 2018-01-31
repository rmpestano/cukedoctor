package com.github.cukedoctor.extension;

import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.extension.BlockMacroProcessor;
import org.asciidoctor.extension.Reader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pestano on 20/07/15.
 */
public class CukedoctorMinMaxExtension extends BlockMacroProcessor {

    public CukedoctorMinMaxExtension(String name, Map<String, Object> config) {
        super(name, config);
    }

    @Override
    public Object process(StructuralNode parent, String target, Map<String, Object> map) {
        String backend = parent.getAttribute("backend") != null ? parent.getAttribute("backend").toString() : "";
        if (backend.contains("html")) {
            StringBuilder minMax = new StringBuilder();
            minMax.append("<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\" ").
                    append(" title=\"Minimize\" onclick=\"hideFeatureScenarios('").
                    append(target).
                    append("');document.getElementById('hidden-").
                    append(target).
                    append("').style.display = 'inline';this.style.display = 'none'\">  </span>\n\n").
                    append("<span id=\"hidden-").append(target).append("\"").
                    append(" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" title=\"Maximize feature\" onclick=\"showFeatureScenarios('").
                    append(target).append("');").append("this.style.display = 'none'\">  </span>");

            return createBlock(parent, "pass", Arrays.asList(minMax.toString()), this.getConfig(),new HashMap<Object, Object>());
        } else {
            return parent;
        }
    }

}
