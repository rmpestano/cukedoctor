package com.github.cukedoctor.multipage.api;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.multipage.defaults.OnePagePerFeatureMultipagePager;
import com.github.cukedoctor.multipage.model.MultipageDocumentation;
import com.github.cukedoctor.multipage.spi.MultipagePager;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import com.github.cukedoctor.multipage.defaults.DefaultMultipagePersister;
import com.github.cukedoctor.multipage.model.Page;
import com.github.cukedoctor.multipage.spi.MultipagePersister;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as a replacement to the {@link com.github.cukedoctor.converter.CukedoctorConverterImpl} and can
 * handle multipage documentation.
 *
 * Main usage is to create a documentation sites with tools like antora.
 */
public class MultipageConverter {
    public static final String DEFAULT_JSONS_FILE_LOCATION = "target/test-classes/json-output";
    public static final String DEFAULT_OUTPUT_FOLDER = "docs/modules/living/pages";

    private MultipagePager pager;
    private MultipagePersister persister;

    private List<Page> pages;

    private File jsonFilesLocation = new File(DEFAULT_JSONS_FILE_LOCATION);
    private File outputFolderLocation = new File(DEFAULT_OUTPUT_FOLDER);
    private DocumentAttributes attrs;

    public MultipageConverter() {
        pages = new ArrayList<>();
        loadDependencies();
    }

    private void loadDependencies() {
        this.pager = new ServiceLoaderUtil<MultipagePager>().initialise(MultipagePager.class, OnePagePerFeatureMultipagePager.class, null, null, null);
        this.persister = new ServiceLoaderUtil<MultipagePersister>().initialise(MultipagePersister.class, DefaultMultipagePersister.class, null, null, null);
    }

    private MultipageDocumentation generateMultipageDocumentation() {
        List<String> pathToCucumberJsonFiles = FileUtil.findJsonFiles(jsonFilesLocation.getPath());
        pages = pager.pages(pathToCucumberJsonFiles, this.attrs);

        MultipageDocumentation multipageDocumentation = new MultipageDocumentation(pages);

        for (Page page : pages) {
            CukedoctorConverter converter = Cukedoctor.instance(page.getFeatures(), page.getDocumentAttributes());
            converter.setFilename(outputFolderLocation.getPath() + File.pathSeparator + page.getPageTitle() + ".adoc");
            page.setRender(converter.renderDocumentation());
        }

        return multipageDocumentation;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void saveDocumentation() {
        this.persister.persist(this.generateMultipageDocumentation(), outputFolderLocation);
    }

    public String getOutputFolderLocation() {
        return outputFolderLocation.getPath();
    }

    public MultipageConverter setOutputFolderLocation(String outputFolderLocation) {
        this.outputFolderLocation = new File(outputFolderLocation);
        return this;
    }

    public String getJsonFilesLocation() {
        return jsonFilesLocation.getPath();
    }

    public MultipageConverter setJsonFilesLocation(String jsonFilesLocation) {
        this.jsonFilesLocation = new File(jsonFilesLocation);
        return this;
    }

    public MultipageConverter attrs(DocumentAttributes attrs) {
        this.attrs = attrs;
        return this;
    }
}
