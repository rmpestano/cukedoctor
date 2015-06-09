package com.github.cukedoctor.reporter;

import com.beust.jcommander.ParameterException;
import com.github.cukedoctor.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pestano on 08/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorMainTest {

	@Test
	public void shouldCreateDocumentationViaMainClass() {
		new CukedoctorMain().execute(new String[] {
				"-n", "\"target/test-classes/document.adoc\"",
				"-p", "\"target/test-classes/json-output\"",
				"-t", "Living Documentation"
		});
		assertTrue(FileUtil.loadFile("target/test-classes/document.adoc").exists());
	}

	@Test
	public void shouldCreateDocumentationUsingDocNameAsTitle() {
		new CukedoctorMain().execute(new String[] {
				"-n", "\"target/test-classes/living Documentation.adoc\"",
				"-p", "\"target/test-classes/json-output\"",
				"-t", "Living Documentation"
		});
		assertTrue(FileUtil.loadFile("target/test-classes/living Documentation.adoc").exists());
	}

	@Test
	public void shouldFailToCreateDocumentationWithoutDocNameParam() {
		try {
			new CukedoctorMain().execute(new String[] {
					"-p", "\"target/test-classes/json-output\"",
					"-t", "Living Documentation"
			});
		} catch (ParameterException pe) {
			assertEquals(pe.getMessage(),"The following option is required: -n ");
			return;
		}

		Assert.fail("Should not reach here");
	}

	@Test
	public void shouldFailToCreateDocumentationWithoutPathParam() {
		try {
			new CukedoctorMain().execute(new String[] {
					"-n", "\"target/test-classes/living Documentation.adoc\"",
					"-t", "Living Documentation"
			});
		} catch (ParameterException pe) {
			assertEquals(pe.getMessage(),"The following option is required: -p ");
			return;
		}

		Assert.fail("Should not reach here");
	}


}
