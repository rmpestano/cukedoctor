/*
 * The MIT License
 *
 * Copyright 2016 pestano.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.cukedoctor.jenkins;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.jenkins.model.FormatType;
import com.github.cukedoctor.jenkins.model.TocType;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import hudson.util.FormValidation;
import hudson.util.ListBoxModel;
import net.sf.json.JSONObject;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.github.cukedoctor.util.Assert.hasText;

/**
 * @author rmpestano
 */
public class CukedoctorPublisher extends Recorder {

    private String featuresDir;

    private boolean numbered;

    private boolean sectAnchors;

    private TocType toc;

    private FormatType format;

    private String title;


    @DataBoundConstructor
    public CukedoctorPublisher(String featuresDir, FormatType format, TocType toc, boolean numbered, boolean sectAnchors, String titile) {
        this.featuresDir = featuresDir;
        this.numbered = numbered;
        this.toc = toc;
        this.format = format;
        this.sectAnchors = sectAnchors;
        this.title = titile;
    }

    @Override
    public BuildStepDescriptor getDescriptor() {
        return (DescriptorImpl) super.getDescriptor();
    }

    @Override
    public Action getProjectAction(AbstractProject<?, ?> project) {
        return new CukedoctorProjectAction(project);
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
            throws IOException, InterruptedException {

        if (!hasText(featuresDir)) {
            featuresDir = build.getWorkspace().getRemote();
        } else{
            featuresDir = (build.getWorkspace().getRemote() + "/"+featuresDir).replaceAll("//","/");
        }

        List<Feature> features = FeatureParser.findAndParse(featuresDir);
        if (!features.isEmpty()) {
            if (!hasText(title)) {
                title = "Living Documentation";
            }

            if(format == null){
                format = FormatType.ALL;
            }

            if(toc == null){
                toc = TocType.RIGHT;
            }

            listener.getLogger().println("Found " + features.size() + " feature(s).");
            listener.getLogger().println("Generating living documentation with following arguments: ");
            listener.getLogger().println("Features dir: " + featuresDir);
            listener.getLogger().println("Format: " + format.getFormat());
            listener.getLogger().println("Toc: " + toc.getToc());
            listener.getLogger().println("Title: " + title);
            listener.getLogger().println("Numbered: " + Boolean.toString(numbered));
            listener.getLogger().println("Section anchors: " + Boolean.toString(sectAnchors));

            File targetBuildDirectory = new File(build.getRootDir(), "living-documentation");
            if (!targetBuildDirectory.exists()) {
                targetBuildDirectory.mkdirs();
            }

            DocumentAttributes documentAttributes = new DocumentAttributes().
                    backend(format.getFormat()).
                    toc(toc.getToc()).
                    numbered(numbered).
                    sectAnchors(sectAnchors).
                    docTitle(title);

            if(format.getFormat().equalsIgnoreCase("pdf")){
                documentAttributes.pdfTheme(true).docInfo(false);
            }else {
                documentAttributes.docInfo(true).pdfTheme(false);
            }

            String outputPath = targetBuildDirectory.getAbsolutePath();
            if("all".equals(format.getFormat())){
                documentAttributes.backend("html5");
                this.execute(features, documentAttributes,outputPath);
                documentAttributes.backend("pdf");
                this.execute(features, documentAttributes,outputPath);
            }else{
                this.execute(features,documentAttributes,outputPath);
            }

        } else {
            listener.getLogger().println(String.format("No features Found in %s. \nLiving documentation will not be generated.", featuresDir));

        }

        return true;
    }

    private void execute(List<Feature> features, DocumentAttributes attrs,String outputPath) {
        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        String doc = converter.renderDocumentation();
        File adocFile = FileUtil.saveFile(outputPath+"/documentation.adoc", doc);
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        if(attrs.getBackend().equalsIgnoreCase("pdf")){
            asciidoctor.unregisterAllExtensions();
        }
        asciidoctor.convertFile(adocFile, OptionsBuilder.options().backend(attrs.getBackend()).safe(SafeMode.UNSAFE).asMap());
        asciidoctor.shutdown();
    }


    @Override
    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }


    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

        public DescriptorImpl() {
            load();
        }

        @Override
        public String getHelpFile() {
            return "/plugin/cukedoctor-jenkins/help.html";
        }


        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types
            return true;
        }

        public FormValidation doCheck(@AncestorInPath AbstractProject project,
                                      @QueryParameter String value) throws IOException, ServletException {
            FilePath ws = project.getSomeWorkspace();
            return ws != null ? ws.validateRelativeDirectory(value) : FormValidation.ok();
        }

        /**
         * This human readable name is used in the configuration screen.
         */
        public String getDisplayName() {
            return "Living documentation";
        }

        public ListBoxModel doFillTocItems() {
            ListBoxModel items = new ListBoxModel();
            for (TocType tocType : TocType.values()) {
                items.add(tocType.getToc(), tocType.name());
            }
            return items;
        }

        public ListBoxModel doFillFormatItems() {
            ListBoxModel items = new ListBoxModel();
            for (FormatType formatType : FormatType.values()) {
                items.add(formatType.getFormat(), formatType.name());
            }
            return items;
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            req.bindJSON(this, formData);
            save();
            //return super.configure(req,formData);
            return true;
        }

    }
}
