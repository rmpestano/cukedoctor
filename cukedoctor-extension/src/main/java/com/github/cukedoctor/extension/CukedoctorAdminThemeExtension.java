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
import java.io.File;
import org.apache.commons.io.IOUtils;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Postprocessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by pestano on 18/05/18. extends html document styles
 */
public class CukedoctorAdminThemeExtension extends Postprocessor {

    public static Logger log = Logger.getLogger(CukedoctorStyleExtension.class.getName());

    public static final String BASE_DIR = Files.exists(Paths.get("target")) ? Paths.get("target").toString()
            : Files.exists(Paths.get("bin")) ? Paths.get("bin").toString() : Paths.get("").toString();

    public static final String CUKEDOCTOR_CUSTOMIZATION_DIR = getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR") == null ? BASE_DIR : getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR");

    public CukedoctorAdminThemeExtension(Map<String, Object> config) {
        super(config);
    }

    private org.jsoup.nodes.Document htmlDocument;

    @Override
    public String process(Document document, String output) {
        if (document.isBasebackend("html") || document.isBasebackend("html5")) {
            htmlDocument = Jsoup.parse(output, "UTF-8");

            addResources(document);
            
            renderHead();

            Element body = renderBody();

            Element wrapper = newElementWithClass("div", "wrapper");

            Element mainHeader = renderMainHeader();

            Element navbar = renderNavbar();

            mainHeader.appendChild(navbar);

            wrapper.appendChild(mainHeader);

            Element mainSidebar = renderMainSidebar();

            wrapper.appendChild(mainSidebar);
            
            Element contentWrapper = renderContentWrapper();
            
            htmlDocument.getElementById("header").remove();//remove asciidoctor toc and title
            
            wrapper.appendChild(contentWrapper);
            
            renderSummary();
            //contentWrapper.appendChild(summary);
            //renderFeatures(contentWrapper);
            
            
            htmlDocument.getElementById("header").before(wrapper);

            renderScripts(wrapper);
            addCustomCss(htmlDocument);

            return htmlDocument.html();

        } else {
            return output;
        }
    }

    /**
     * Adds user defined css file Cukedoctor will search for a file named
     * "cukedoctor.css" under the directory defined in system property
     * CUKEDOCTOR_CUSTOMIZATION_DIR
     */
    private void addCustomCss(org.jsoup.nodes.Document document) {
        List<String> files = FileUtil.findFiles(CUKEDOCTOR_CUSTOMIZATION_DIR, "cukedoctor.css", true);
        if (files != null && !files.isEmpty()) {
            String themePath = files.get(0);
            themePath = themePath.replaceAll("\\\\", "/");
            try {
                String customCss = IOUtils.toString(new FileInputStream(themePath));
                Elements head = document.getElementsByTag("head");
                head.append(" <style> " + customCss);
            } catch (IOException e) {
                log.log(Level.SEVERE, "Could not copy cukedoctor css from: " + themePath, e);
            }
        }
    }

    private Element newElement(String tag) {
        return htmlDocument.createElement(tag);
    }

    private Element newElementWithClass(String tag, String cssClass) {
        return htmlDocument.createElement(tag).addClass(cssClass);
    }

    private void renderHead() {
        Element head = htmlDocument.getElementsByTag("head").get(0);
        
        Elements embededStyles = head.getElementsByTag("style");//remove asciidoctor embbeded styles
        for (Element embededStyle : embededStyles) {
            embededStyle.remove();
        }

        head.appendChild(newElement("meta")
                .attr("content", "width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no")
                .attr("name", "viewport"));

        head.appendChild(newElement("link")
                .attr("rel", "stylesheet")
                .attr("href", "https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"));

        head.appendChild(newElement("link")
                .attr("rel", "stylesheet")
                .attr("href", "theme/css/bootstrap.min.css"));

        head.appendChild(newElement("link")
                .attr("rel", "stylesheet")
                .attr("href", "theme/css/adminlte.min.css"));

        head.appendChild(newElement("link")
                .attr("rel", "stylesheet")
                .attr("href", "theme/css/_all-skins.min.css"));
        
         head.appendChild(newElement("link")
                .attr("rel", "stylesheet")
                .attr("href", "theme/css/custom.css"));
        
    }

    private void renderScripts(Element wrapper) {
        wrapper.after(newElement("script").attr("src", "theme/js/adminlte.min.js"))
                .after(newElement("script").attr("src", "theme/js/bootstrap.min.js"))
                .after(newElement("script").attr("src", "theme/js/jquery-ui.min.js"))
                .after(newElement("script").attr("src", "theme/js/jquery.min.js"));

    }

    private Element renderBody() {
        Element body = htmlDocument.getElementsByTag("body").get(0);
        body.addClass("skin-blue sidebar-mini fixed");
        return body.removeClass("book").removeClass("toc2")
                .removeClass("toc-right");
    }

    private Element renderNavbar() {
        Element navbar = newElement("nav").addClass("navbar navbar-static-top");
        Element sidebarToggle = newElement("a").attr("href", "#");
        sidebarToggle.addClass("sidebar-toggle")
                .attr("data-toggle","push-menu")
                .attr("role","button");
        sidebarToggle.appendChild(newElement("span")
                .addClass("sr-only")
                .text("Toggle navigation")
        );

        navbar.appendChild(sidebarToggle);
        Element navbarCustomMenu = newElement("div").addClass("navbar-custom-menu");
        Element navbarNav = newElement("ul").addClass("nav navbar-nav");

        Element controlSidebarItem = newElement("li");
        Element controlSidebarToggle = newElement("a").attr("href", "#")
                .attr("data-toggle", "control-sidebar");
        controlSidebarToggle.appendChild(newElement("i").addClass("fa fa-gears"));

        controlSidebarItem.appendChild(controlSidebarToggle);
        navbarNav.appendChild(controlSidebarItem);

        navbarCustomMenu.appendChild(navbarNav);
        navbar.appendChild(navbarCustomMenu);
        return navbar;
    }

    private Element renderMainHeader() {
        Element mainHeader = newElementWithClass("header", "main-header");
        Element headerLink = newElementWithClass("a", "logo")
                .attr("href", "/");

        Element logoMini = newElementWithClass("span", "logo-mini");

        logoMini.appendChild(newElement("b").text("Docs"));

        Element logoLG = newElement("span").addClass("logo-lg");

        logoLG.appendChild(newElement("b").text("Living"))
                .appendChild(newElement("span").text("Docs"));

        headerLink.appendChild(logoMini).appendChild(logoLG);

        mainHeader.appendChild(headerLink);

        return mainHeader;
    }

    private Element renderMainSidebar() {
        Element sidebar = newElement("div");
        Element sidebarForm = newElement("div").addClass("sidebar-form");

        Element sidebarFormInputGroup = newElement("div").addClass("input-group");

        sidebarForm.appendChild(sidebarFormInputGroup);

        Element sidebarFormInput = newElement("input").addClass("form-control")
                .attr("type", "text").attr("name", "q")
                .attr("title", "Search features")
                .attr("placeholder", "Search...").attr("onclick", "this.value='';searchMenu('')")
                .attr("onkeyup", "searchMenu(this.value)");

        sidebarFormInputGroup.appendChild(sidebarFormInput);

        Element sidebarFormSpan = newElement("span").addClass("input-group-btn");

        sidebarFormInput.appendChild(sidebarFormSpan);

        Element sidebarFormSpanButton = newElement("button").addClass("btn btn-flat")
                .attr("type", "submit").attr("name", "search")
                .attr("id", "search-btn").attr("name", "q");

        sidebarFormSpanButton.appendChild(newElement("i").addClass("fa fa-search"));

        sidebarFormSpan.appendChild(sidebarFormSpanButton);

        Element sidebarSection = newElement("section").addClass("sidebar");

        Element leftMenu = renderLeftMenu();

        sidebarSection.appendChild(leftMenu);

        sidebar.appendChild(sidebarForm);
        sidebar.appendChild(sidebarSection);

        Element mainSidebar = newElement("aside").addClass("main-sidebar");
        mainSidebar.appendChild(sidebar);

        return mainSidebar;
    }

    private Element renderLeftMenu() {
        Element leftMenu = newElement("ul").addClass("sidebar-menu tree")
                .attr("data-widget", "tree");
        
        Element homeItem = newElement("li");
        Element homeAnchor = newElement("a").attr("href", "#");
        homeAnchor.appendChild(newElement("i").addClass("fa fa-home"))
                 .text("Home");
         
        leftMenu.appendChild(homeItem);
        
        Element summaryItem = newElement("li");
        Element summaryItemAnchor = newElement("a").attr("href", "#");
        summaryItemAnchor.appendChild(newElement("i").addClass("fa fa-pie-chart"))
                 .text("Summary");
        
        leftMenu.appendChild(newElement("li").addClass("header").text("Features"));

        Elements tocElements = htmlDocument.getElementById("toc").select("ul.sectlevel2 > li");
        //each asciidoc toc level 2 will be a menu item (a feature) and each menuItem child (scenario) will be a submenu
        for (Element tocElement : tocElements) {
            Element feature = newElement("li").addClass("treeview");

            Element featureAnchor = newElement("a").attr("href", "#")
                    .attr("onclick", "alert('TODO: move scroll to the feature and make this menuitem active')");
            featureAnchor.appendChild(newElement("i").addClass("fa fa-file-text-o"));
            featureAnchor.appendChild(newElement("span").text(tocElement.select("> a").text()));
            Element featureAnchorSpan = newElement("span").addClass("pull-right-container");
            featureAnchorSpan.appendChild(newElement("i").addClass("fa fa-angle-left pull-right"));
            featureAnchor.appendChild(featureAnchorSpan);
            feature.appendChild(featureAnchor);

            Element scenarios = newElement("ul").addClass("treeview-menu");

            scenarios.appendChild(newElement("li").addClass("header").text("Scenarios"));

            Elements scenarioElements = tocElement.select("ul.sectlevel3 > li");

            for (Element scenario : scenarioElements) {
                Element scenarioItem = newElement("li");
                Element scenarioAnchor = newElement("a").attr("href", "#")
                        .attr("onclick", "alert('TODO: move scroll to the scenario and make this menuitem active')");

                scenarioAnchor.appendChild(newElement("i").addClass("fa fa-circle-o"));
                scenarioAnchor.appendChild(newElement("span").text(scenario.select("a").text()));
                scenarioItem.appendChild(scenarioAnchor);
                scenarios.appendChild(scenarioItem);
            }

            feature.appendChild(scenarios);

            leftMenu.appendChild(feature);
        }

        return leftMenu;
    }

    private void addResources(Document document) {
        Object docDir = document.getAttributes().get("docdir");
        new File(docDir.toString() + "/theme/").mkdir();
        new File(docDir.toString() + "/theme/css").mkdir();
        new File(docDir.toString() + "/theme/js").mkdir();
        new File(docDir.toString() + "/theme/fonts").mkdir();
        FileUtil.copyFile("/themes/cukedoctor/css/_all-skins.min.css", docDir + "/theme/css/_all-skins.min.css");
        FileUtil.copyFile("/themes/cukedoctor/css/adminlte.min.css", docDir + "/theme/css/adminlte.min.css");
        FileUtil.copyFile("/themes/cukedoctor/css/bootstrap.min.css", docDir + "/theme/css/bootstrap.min.css");
        FileUtil.copyFile("/themes/cukedoctor/css/custom.css", docDir + "/theme/css/custom.css");
        FileUtil.copyFile("/themes/cukedoctor/js/jquery.min.js", docDir + "/theme/js/jquery.min.js");
        FileUtil.copyFile("/themes/cukedoctor/js/jquery-ui.min.js", docDir + "/theme/js/jquery-ui.min.js");
        FileUtil.copyFile("/themes/cukedoctor/js/bootstrap.min.js", docDir + "/theme/js/bootstrap.min.js");
        FileUtil.copyFile("/themes/cukedoctor/js/adminlte.min.js", docDir + "/theme/js/adminlte.min.js");
        FileUtil.copyFile("/themes/cukedoctor/fonts/glyphicons-halflings-regular.eot", docDir + "/theme/fonts/glyphicons-halflings-regular.eot");
        FileUtil.copyFile("/themes/cukedoctor/fonts/glyphicons-halflings-regular.svg", docDir + "/theme/fonts/glyphicons-halflings-regular.svg");
        FileUtil.copyFile("/themes/cukedoctor/fonts/glyphicons-halflings-regular.ttf", docDir + "/theme/fonts/glyphicons-halflings-regular.ttf");
        FileUtil.copyFile("/themes/cukedoctor/fonts/glyphicons-halflings-regular.woff", docDir + "/theme/fonts/glyphicons-halflings-regular.woff");
        FileUtil.copyFile("/themes/cukedoctor/fonts/glyphicons-halflings-regular.woff2", docDir + "/theme/fonts/glyphicons-halflings-regular.woff2");
    }

    private Element renderContentWrapper() {
        Element contentWrapper = newElementWithClass("div", "content-wrapper");
        return contentWrapper;
    }

    private void renderFeatures(Element contentWrapper) {
        Element content =  htmlDocument.getElementById("content");
        //content.
        contentWrapper.appendChild(content);
    }

    private void renderSummary() {
        Elements summaryTotals = htmlDocument.select("#content .sect1:first-child tfoot tr code");
        for (Element total : summaryTotals) {
            System.out.println(total.text());
        }
        
        <div class="box box-default">
    <div class="box-header with-border">
        <h3 class="box-title">Scenarios</h3>

        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
            </button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
        </div>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
        <div class="row">
            <div class="col-md-8">
                <div class="chart-responsive">
                    <canvas id="pieChart" height="150"></canvas>
                </div>
                <!-- ./chart-responsive -->
            </div>
            <!-- /.col -->
            <div class="col-md-4">
                <ul class="chart-legend clearfix">
                    <li><i class="fa fa-circle-o text-red"></i> Chrome</li>
                    <li><i class="fa fa-circle-o text-green"></i> IE</li>
                    <li><i class="fa fa-circle-o text-yellow"></i> FireFox</li>
                    <li><i class="fa fa-circle-o text-aqua"></i> Safari</li>
                    <li><i class="fa fa-circle-o text-light-blue"></i> Opera</li>
                    <li><i class="fa fa-circle-o text-gray"></i> Navigator</li>
                </ul>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
</div>    
    }

}
