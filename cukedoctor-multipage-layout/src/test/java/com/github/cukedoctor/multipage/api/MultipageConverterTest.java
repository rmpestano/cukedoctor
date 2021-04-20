package com.github.cukedoctor.multipage.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultipageConverterTest {

    @Test
    public void output_folder_should_work_without_final_slash() {
        MultipageConverter converter = new MultipageConverter()
                .setOutputFolderLocation("docs/modules");

        assertEquals("docs/modules", converter.getOutputFolderLocation());

        converter.setOutputFolderLocation("docs/modules/");

        assertEquals("docs/modules", converter.getOutputFolderLocation());
    }

    @Test
    public void json_file_location_should_work_without_final_slash() {
        MultipageConverter converter = new MultipageConverter()
                .setJsonFilesLocation("target/json");

        assertEquals("target/json", converter.getJsonFilesLocation());

        converter.setJsonFilesLocation("target/json/");

        assertEquals("target/json", converter.getJsonFilesLocation());
    }

    @Test
    public void should_have_a_default_output_location() {
        MultipageConverter converter = new MultipageConverter();

        assertEquals(MultipageConverter.DEFAULT_OUTPUT_FOLDER, converter.getOutputFolderLocation());
    }

    @Test
    public void should_have_a_default_json_files_location() {
        MultipageConverter converter = new MultipageConverter();

        assertEquals(MultipageConverter.DEFAULT_JSONS_FILE_LOCATION, converter.getJsonFilesLocation());
    }
}
