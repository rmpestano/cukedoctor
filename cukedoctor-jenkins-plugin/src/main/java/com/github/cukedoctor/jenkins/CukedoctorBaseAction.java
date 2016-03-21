package com.github.cukedoctor.jenkins;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.FilePath;
import hudson.model.Action;
import hudson.model.DirectoryBrowserSupport;

public abstract class CukedoctorBaseAction implements Action {

    protected static final String BASE_URL = "living-documentation";

    private static final String DEFAULT_PAGE = "index.html";

    public String getUrlName() {
        return BASE_URL;
    }

    public String getDisplayName() {
        return "Living documentation";
    }

    public String getIconFileName() {
        return "/plugin/cukedoctor-jenkins/cuke.png";
    }

    public void doDynamic(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "");
        DirectoryBrowserSupport dbs = new DirectoryBrowserSupport(this, new FilePath(dir()), getTitle(), getUrlName(),
                false);

        dbs.setIndexFileName(DEFAULT_PAGE);
        dbs.generateResponse(req, rsp, this);
    }

    protected abstract String getTitle();

    protected abstract File dir();
}
