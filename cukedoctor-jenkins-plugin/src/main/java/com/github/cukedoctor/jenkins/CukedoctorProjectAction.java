package com.github.cukedoctor.jenkins;

import java.io.File;

import hudson.model.AbstractProject;
import hudson.model.ProminentProjectAction;
import hudson.model.Run;

public class CukedoctorProjectAction extends CukedoctorBaseAction implements ProminentProjectAction {

    private final AbstractProject<?, ?> project;

    public CukedoctorProjectAction(AbstractProject<?, ?> project) {
        this.project = project;
    }

    @Override
    protected File dir() {
        Run<?, ?> run = this.project.getLastCompletedBuild();
        if (run != null) {
            File archiveDir = getBuildArchiveDir(run);

            if (archiveDir.exists()) {
                return archiveDir;
            }
        }

        return getProjectArchiveDir();
    }

    private File getProjectArchiveDir() {
        return new File(project.getRootDir(), CukedoctorBaseAction.BASE_URL);
    }

    /** Gets the directory where the HTML report is stored for the given build. */
    private File getBuildArchiveDir(Run<?, ?> run) {
        return new File(run.getRootDir(), CukedoctorBaseAction.BASE_URL);
    }

    @Override
    protected String getTitle() {
        return this.project.getDisplayName();
    }
}