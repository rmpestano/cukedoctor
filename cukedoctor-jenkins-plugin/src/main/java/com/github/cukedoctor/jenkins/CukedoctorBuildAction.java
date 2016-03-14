package com.github.cukedoctor.jenkins;

import java.io.File;

import hudson.model.Run;

public class CukedoctorBuildAction extends CukedoctorBaseAction {

    private final Run<?, ?> build;

    public CukedoctorBuildAction(Run<?, ?> build) {
        this.build = build;
    }

    @Override
    protected String getTitle() {
        return this.build.getDisplayName();
    }

    @Override
    protected File dir() {
        return new File(build.getRootDir(), BASE_URL);
    }
}
