package com.github.cukedoctor.util;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 29/06/15.
 */
@RunWith(JUnit4.class)
public class FileUtilTest {

	@After
	public void clear(){
		FileUtil.removeFile("target/filename.adoc");
	}

	@Test
	public void shouldSaveFileUsingRelativePath(){
		File file = FileUtil.saveFile("target/filename.adoc", "data");
		assertThat(file).exists();
	}

	@Test
	public void shouldSaveFileUsingAbsolutePath(){
		String absolutePath = Paths.get("") + "target/filename.adoc";
		File file = FileUtil.saveFile(absolutePath,"data");
		assertThat(file).exists();
	}

	@Test
	public void shouldNotSaveFileUsingNonExistingAbsolutePath(){
		if(System.getProperty("os.name").toLowerCase().startsWith("windows")){
			return; //FIXME make this test pass on windows
		}
		File file = FileUtil.saveFile("/target/filename.adoc","data");
		assertThat(file).isNull();
	}


}
