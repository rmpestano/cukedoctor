package com.github.cukedoctor.mojo.stub;

import org.apache.maven.model.Build;
import org.apache.maven.plugin.testing.stubs.MavenProjectStub;

/**
 * Created by pestano on 28/06/15.
 */
public class CukedoctorMojoStub extends MavenProjectStub {

	public CukedoctorMojoStub(){

	}

	@Override
	public Build getBuild() {
		Build b = new Build();
		b.setOutputDirectory("target/");
		return b;
	}
}
