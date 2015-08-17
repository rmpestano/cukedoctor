package com.github.cukedoctor.extension;

import org.asciidoctor.ast.AbstractBlock;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.BlockProcessor;
import org.asciidoctor.extension.Postprocessor;
import org.asciidoctor.extension.Reader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pestano on 20/07/15.
 * adds javascript functions to html documentation
 */
public class CukedoctorScriptExtension extends Postprocessor{

    public CukedoctorScriptExtension(Map<String, Object> config) {
        super(config);
    }

    @Override
    public String process(Document document, String output) {
        if(document.basebackend("html")){
            org.jsoup.nodes.Document doc = Jsoup.parse(output, "UTF-8");

            Element contentElement = doc.getElementById("footer");
            addSearchScript(contentElement);
            addMinMaxScript(contentElement);
            return doc.html();

        }else{
            return output;
        }
    }

    private void addMinMaxScript(Element contentElement) {
        String minMaxScript = "<script type=\"text/javascript\">\n" +
                "\tfunction showFeatureScenarios(featureId){\n" +
                "\t\tvar element = document.getElementById(featureId).parentNode;\n" +
                "\t\tfor (var i = 0; i < element.childNodes.length; i++) {\n" +
                "    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"fa fa-minus-square fa-fw\") {\n" +
                "      \t\t     element.childNodes[i].style.display = 'inline';\n" +
                "    \t\t\t}\n" +
                "    \t\tif (element.childNodes[i].className == \"sidebarblock\") {\n" +
                "      \t\t     element.childNodes[i].style.display = 'block';\n" +
                "    \t\t\t}\t\t\t        \n" +
                "\t\t}\n" +
                "\t\t \n" +
                " \t\tdocument.getElementById(featureId).childNodes[0].click();\n" +
                "\t}\n" +
                "\n" +
                "\tfunction hideFeatureScenarios(featureId){\n" +
                "\t\tvar element = document.getElementById(featureId).parentNode;\n" +
                "\t\tfor (var i = 0; i < element.childNodes.length; i++) {\n" +
                "    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"sidebarblock\") { \n" +
                "      \t\t     element.childNodes[i].style.display = 'none';\t   \t\t    \n" +
                "                 \t}\n" +
                "\t\t      \n" +
                "\t\t}\n" +
                "\t   document.getElementById(featureId).childNodes[0].click();\n" +
                " \t}\n" +
                "\n" +
                "</script>";
        contentElement.after(minMaxScript);
    }

    private void addSearchScript(Element contentElement) {
        String searchScripts = "<script type = \"text/javascript\" >\n" +
                "var allLevel2ListItens = null;\n" +
                "\n" +
                "function searchFeature(criteria) {\n" +
                "    if (criteria != null && criteria.length >= 3) {\n" +
                "        var sect2List = document.getElementsByClassName(\"sect2\");\n" +
                "        var firstMatch = null;\n" +
                "        if (sect2List != null) {\n" +
                "            for (var i = 0; i < sect2List.length; i++) {\n" +
                "                var h3 = null;\n" +
                "                for (var j = 0; j < sect2List[i].childNodes.length; j++) {\n" +
                "                    if (sect2List[i].childNodes[j].tagName && sect2List[i].childNodes[j].tagName.toUpperCase() == \"H3\") {\n" +
                "                        h3 = sect2List[i].childNodes[j];\n" +
                "                        break;\n" +
                "                    }\n" +
                "                }\n" +
                "                if (h3 != null && h3.id != null) {\n" +
                "                    if (!h3.id.toLowerCase().match(criteria.toLowerCase())) {\n" +
                "                        sect2List[i].style.display = 'none';\n" +
                "                    } else {//match\n" +
                "                        sect2List[i].style.display = 'inline';\n" +
                "                        if (firstMatch == null) {\n" +
                "                            //used to scroll to after search\n" +
                "                            firstMatch = h3;\n" +
                "                        }\n" +
                "                        //filter toc\n" +
                "                        filterToc(criteria);\n" +
                "                    }\n" +
                "                }\n" +
                "            }//end for\n" +
                "\n" +
                "        }//sect2List != null\n" +
                "        if (firstMatch != null) {\n" +
                "            animate(document.body, \"scrollTop\", \"\", 0, firstMatch.offsetTop, 200, true);\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "    }//end criteria.length >=3\n" +
                "    else {//clear search\n" +
                "        clearSearch();\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "function clearSearch() {\n" +
                "    var sect2List = document.getElementsByClassName(\"sect2\");\n" +
                "    if (sect2List != null) {\n" +
                "        for (var i = 0; i < sect2List.length; i++) {\n" +
                "            sect2List[i].style.display = 'inline';\n" +
                "        }//end for\n" +
                "    }//end elements != null\n" +
                "\n" +
                "    if (allLevel2ListItens == null) {\n" +
                "        collectallLevel2IListItens();\n" +
                "    }\n" +
                "    for (var z = 0; z < allLevel2ListItens.length; z++) {\n" +
                "        allLevel2ListItens[z].style.display = 'inline';\n" +
                "    }\n" +
                "    if (document.getElementById('input-search')) {\n" +
                "        document.getElementById('input-search').value = 'Filter...';\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "function filterToc(criteria) {\n" +
                "    if (allLevel2ListItens == null) {\n" +
                "        collectallLevel2IListItens();\n" +
                "    }\n" +
                "    for (var z = 0; z < allLevel2ListItens.length; z++) {\n" +
                "        if (allLevel2ListItens[z].childNodes[0].tagName && allLevel2ListItens[z].childNodes[0].tagName.toLowerCase() == \"a\") {\n" +
                "            if (allLevel2ListItens[z].childNodes[0].getAttribute(\"href\").toUpperCase().substring(1).match(criteria.toUpperCase())) {\n" +
                "                allLevel2ListItens[z].style.display = 'inline';\n" +
                "            } else {\n" +
                "                allLevel2ListItens[z].style.display = 'none';\n" +
                "            }\n" +
                "        }\n" +
                "    }//end for allListItens\n" +
                "}\n" +
                "\n" +
                "function animate(elem, style, unit, from, to, time, prop) {\n" +
                "    if (!elem) return;\n" +
                "    var start = new Date().getTime(),\n" +
                "        timer = setInterval(function () {\n" +
                "            var step = Math.min(1, (new Date().getTime() - start) / time);\n" +
                "            if (prop) {\n" +
                "                elem[style] = (from + step * (to - from)) + unit;\n" +
                "            } else {\n" +
                "                elem.style[style] = (from + step * (to - from)) + unit;\n" +
                "            }\n" +
                "            if (step == 1) clearInterval(timer);\n" +
                "        }, 25);\n" +
                "    elem.style[style] = from + unit;\n" +
                "}\n" +
                "\n" +
                "function collectallLevel2IListItens() {\n" +
                "    allLevel2ListItens = new Array();\n" +
                "    var uls = document.getElementsByClassName('sectlevel2');\n" +
                "    for (var i = 0; i < uls.length; i++) {\n" +
                "        for (var j = 0; j < uls[i].childNodes.length; j++) {\n" +
                "            if (uls[i].childNodes[j].tagName) {\n" +
                "                if (uls[i].childNodes[j].tagName.toLowerCase() == 'li') {\n" +
                "                    allLevel2ListItens.push(uls[i].childNodes[j]);\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "        } //end for uls child\n" +
                "    }//end for uls\n" +
                "\n" +
                "}\n" +
                "</script>";
        contentElement.after(searchScripts);
    }
}
