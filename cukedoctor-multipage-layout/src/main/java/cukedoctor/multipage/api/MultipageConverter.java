package cukedoctor.multipage.api;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import cukedoctor.multipage.defaults.DefaultMultipagePersister;
import cukedoctor.multipage.defaults.OnePagePerFeatureMultipagePager;
import cukedoctor.multipage.model.Page;
import cukedoctor.multipage.model.MultipageDocumentation;
import cukedoctor.multipage.spi.MultipagePersister;
import cukedoctor.multipage.spi.MultipagePager;

import java.util.List;

/**
 * This class serves as a replacement to the {@link com.github.cukedoctor.converter.CukedoctorConverterImpl} and can
 * handle multipage documentation.
 *
 * Main usage is to create a documentation sites with tools like antora.
 */
public class MultipageConverter {
    private MultipagePager pager;
    private MultipagePersister persister;

    private String jsonFilesLocation = "target/test-classes/json-output/";
    private String outputFolderLocation = "docs/modules/living/pages/";

    public MultipageConverter() {
        loadDependencies();
    }

    private void loadDependencies() {
        this.pager = new ServiceLoaderUtil<MultipagePager>().initialise(MultipagePager.class, OnePagePerFeatureMultipagePager.class, null, null, null);
        this.persister = new ServiceLoaderUtil<MultipagePersister>().initialise(MultipagePersister.class, DefaultMultipagePersister.class, null, null, null);
    }

    private MultipageDocumentation generateMultipageDocumentation() {
        List<String> pathToCucumberJsonFiles = FileUtil.findJsonFiles(jsonFilesLocation);
        List<Page> pages = pager.pages(pathToCucumberJsonFiles);

        MultipageDocumentation multipageDocumentation = new MultipageDocumentation(pages);

        for (Page page : pages) {
            CukedoctorConverter converter = Cukedoctor.instance(page.getFeatures(), page.getDocumentAttributes());
            converter.setFilename("docs/modules/living/pages/" + page.getPageTitle() + ".adoc");
            page.setRender(converter.renderDocumentation());
        }

        return multipageDocumentation;
    }

    public void saveDocumentation() {
        this.persister.persist(this.generateMultipageDocumentation(), outputFolderLocation);
    }

    public String getOutputFolderLocation() {
        return outputFolderLocation;
    }

    public MultipageConverter setOutputFolderLocation(String outputFolderLocation) {
        this.outputFolderLocation = outputFolderLocation;
        return this;
    }

    public String getJsonFilesLocation() {
        return jsonFilesLocation;
    }

    public MultipageConverter setJsonFilesLocation(String jsonFilesLocation) {
        this.jsonFilesLocation = jsonFilesLocation;
        return this;
    }
}
