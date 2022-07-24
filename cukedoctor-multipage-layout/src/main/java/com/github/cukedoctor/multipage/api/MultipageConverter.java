package com.github.cukedoctor.multipage.api;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.multipage.defaults.DefaultMultipagePersister;
import com.github.cukedoctor.multipage.defaults.OnePagePerFeatureMultipagePager;
import com.github.cukedoctor.multipage.model.MultipageDocumentation;
import com.github.cukedoctor.multipage.model.Page;
import com.github.cukedoctor.multipage.spi.MultipagePager;
import com.github.cukedoctor.multipage.spi.MultipagePersister;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as a replacement to the {@link
 * com.github.cukedoctor.converter.CukedoctorConverterImpl} and can handle multipage documentation.
 *
 * <p>Main usage is to create a documentation sites with tools like antora.
 */
public class MultipageConverter {
  public static class MultipageConverterBuilder {

    private DocumentAttributes attrs;

    private CukedoctorConfig cukedoctorConfig;
    private String jsonFilesLocation;
    private String outputFolderLocation;

    public MultipageConverterBuilder attrs(DocumentAttributes attrs) {
      this.attrs = attrs;
      return this;
    }

    public MultipageConverterBuilder cukedoctorConfig(CukedoctorConfig cukedoctorConfig) {
      this.cukedoctorConfig = cukedoctorConfig;
      return this;
    }

    public MultipageConverterBuilder jsonFileLocation(String jsonFilesLocation) {
      this.jsonFilesLocation = jsonFilesLocation;
      return this;
    }

    public MultipageConverter build() {
      MultipageConverter converter = new MultipageConverter(attrs, cukedoctorConfig);

      if (jsonFilesLocation != null && !jsonFilesLocation.equals("")) {
        converter.setJsonFilesLocation(jsonFilesLocation);
      }
      if (outputFolderLocation != null && !outputFolderLocation.equals("")) {
        converter.setOutputFolderLocation(outputFolderLocation);
      }

      return converter;
    }

    public MultipageConverterBuilder outputFolderLocation(String outputFolderLocation) {
      this.outputFolderLocation = outputFolderLocation;

      return this;
    }
  }

  public static final String DEFAULT_JSONS_FILE_LOCATION = "target/test-classes/json-output";
  public static final String DEFAULT_OUTPUT_FOLDER = "docs/modules/living/pages";

  private MultipagePager pager;
  private MultipagePersister persister;

  private List<Page> pages;

  private File jsonFilesLocation = new File(DEFAULT_JSONS_FILE_LOCATION);
  private File outputFolderLocation = new File(DEFAULT_OUTPUT_FOLDER);
  private final DocumentAttributes attrs;
  private CukedoctorConfig cukedoctorConfig;

  protected MultipageConverter() {
    this(new DocumentAttributes(), new CukedoctorConfig());
    pages = new ArrayList<>();
  }

  protected MultipageConverter(DocumentAttributes attrs, CukedoctorConfig cukedoctorConfig) {
    this.cukedoctorConfig = cukedoctorConfig;
    if (this.cukedoctorConfig == null) {
      this.cukedoctorConfig = new CukedoctorConfig();
    }

    this.attrs = attrs;
    loadDependencies();
  }

  public static MultipageConverterBuilder builder() {
    return new MultipageConverterBuilder();
  }

  private void loadDependencies() {
    this.pager =
        new ServiceLoaderUtil<MultipagePager>()
            .initialise(
                MultipagePager.class,
                OnePagePerFeatureMultipagePager.class,
                null,
                attrs,
                cukedoctorConfig);
    this.persister =
        new ServiceLoaderUtil<MultipagePersister>()
            .initialise(
                MultipagePersister.class,
                DefaultMultipagePersister.class,
                null,
                attrs,
                cukedoctorConfig);
  }

  private MultipageDocumentation generateMultipageDocumentation() {
    List<String> pathToCucumberJsonFiles = FileUtil.findJsonFiles(jsonFilesLocation.getPath());
    pages = pager.pages(pathToCucumberJsonFiles);

    MultipageDocumentation multipageDocumentation = new MultipageDocumentation(pages);
    cukedoctorConfig
        .setHideSummarySection(true)
        .setHideFeaturesSection(true)
        .setHideStepTime(true)
        .setHideScenarioKeyword(true)
        .setHideTags(true);

    for (Page page : pages) {
      CukedoctorConverter converter =
          Cukedoctor.instance(page.getFeatures(), page.getDocumentAttributes(), cukedoctorConfig);
      converter.setFilename(
          outputFolderLocation.getPath() + File.pathSeparator + page.getPageTitle() + ".adoc");
      page.setRender(converter.renderDocumentation());
    }

    return multipageDocumentation;
  }

  public List<Page> getPages() {
    return pages;
  }

  public CukedoctorConfig getCukedoktorConfig() {
    return cukedoctorConfig;
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
}
