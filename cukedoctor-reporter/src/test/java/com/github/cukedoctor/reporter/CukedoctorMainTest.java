package com.github.cukedoctor.reporter;

import com.github.cukedoctor.util.FileUtil;
import org.apache.commons.cli.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.net.URISyntaxException;

import static org.junit.Assert.assertTrue;

/**
 * Created by pestano on 08/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorMainTest {

	@Test
	public void shouldCreateDocumentationViaMainClass() throws ParseException, URISyntaxException {
		String[] args = new String[3];
		args[0] = "-n target/test-classes/document.adoc";
		args[1] = "-p target/test-classes/json-output";
		args[2] = "-t Living Documentation";
		CukedoctorMain.main(args);
		assertTrue(FileUtil.loadFile("target/test-classes/document.adoc").exists());
	}


}
