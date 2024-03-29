package com.github.cukedoctor.converter;

import static com.github.cukedoctor.util.Assert.hasElements;
import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notNull;
import static com.github.cukedoctor.util.Constants.Markup.bold;
import static com.github.cukedoctor.util.Constants.newLine;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.renderer.CukedoctorHeaderRenderer;
import com.github.cukedoctor.renderer.CukedoctorSummaryRenderer;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.spi.HeaderRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import java.util.Collections;
import java.util.List;

/** Created by pestano on 02/06/15. */
public class CukedoctorConverterImpl implements CukedoctorConverter {

  private final List<Feature> features;
  private final DocumentAttributes documentAttributes;
  private String filename;
  private final CukedoctorDocumentBuilder docBuilder;
  private final I18nLoader i18n;
  private SummaryRenderer summaryRenderer;
  private FeatureRenderer featureRenderer;
  private HeaderRenderer headerRenderer;
  private final CukedoctorConfig cukedoctorConfig;

  public CukedoctorConverterImpl(List<Feature> features, DocumentAttributes attrs) {
    this(features, attrs, new CukedoctorConfig());
  }

  public CukedoctorConverterImpl(
      List<Feature> features, DocumentAttributes attrs, CukedoctorConfig cukedoctorConfig) {
    this(features, attrs, cukedoctorConfig, CukedoctorDocumentBuilder.Factory.newInstance());
  }

  public CukedoctorConverterImpl(
      List<Feature> features,
      DocumentAttributes attrs,
      CukedoctorConfig cukedoctorConfig,
      CukedoctorDocumentBuilder docBuilder) {
    this.cukedoctorConfig = cukedoctorConfig;
    this.features = features;
    Collections.sort(this.features);
    this.documentAttributes = attrs;
    this.docBuilder = docBuilder;
    i18n = I18nLoader.newInstance(features);
    loadRenderers();
  }

  private void loadRenderers() {
    headerRenderer =
        new ServiceLoaderUtil<HeaderRenderer>()
            .initialise(
                HeaderRenderer.class,
                CukedoctorHeaderRenderer.class,
                i18n,
                documentAttributes,
                cukedoctorConfig);
    summaryRenderer =
        new ServiceLoaderUtil<SummaryRenderer>()
            .initialise(
                SummaryRenderer.class,
                CukedoctorSummaryRenderer.class,
                i18n,
                documentAttributes,
                cukedoctorConfig);
    featureRenderer =
        new ServiceLoaderUtil<FeatureRenderer>()
            .initialise(
                FeatureRenderer.class,
                CukedoctorFeatureRenderer.class,
                i18n,
                documentAttributes,
                cukedoctorConfig);
  }

  public DocumentAttributes getDocumentAttributes() {
    return documentAttributes;
  }

  public List<Feature> getFeatures() {
    return features;
  }

  public String getDocumentation() {
    return docBuilder.toString();
  }

  /** @return a String representation of generated documentation */
  public synchronized String renderDocumentation() {
    System.setProperty(Constants.STOP_WATCH, String.valueOf(System.currentTimeMillis()));
    docBuilder.clear();
    addCustomPdfTheme(); // needs to be added before renderAttributes because it adds pdf-style doc
    // attr
    renderAttributes();
    docBuilder.newLine();
    docBuilder.title(bold(getDocumentationTitle()));
    renderIntro();
    if (!cukedoctorConfig.isHideSummarySection()) {
      renderSummary();
    } else {
      docBuilder.newLine();
    }
    renderFeatures(features);

    return docBuilder.toString();
  }

  private void renderIntro() {
    List<String> files =
        FileUtil.findFiles(
            cukedoctorConfig.getIntroChapterDir(),
            "cukedoctor-intro.adoc",
            true,
            cukedoctorConfig.getIntroChapterRelativePath());
    if (!files.isEmpty()) {
      String introPath = files.get(0);
      introPath = introPath.replace("\\", "/");
      docBuilder.append("include::", introPath, "[leveloffset=+1]", newLine(), newLine());
    }
  }

  public String getDocumentationTitle() {
    if (documentAttributes != null && hasText(documentAttributes.getDocTitle())) {
      return documentAttributes.getDocTitle();
    } else {
      return Constants.DOCUMENT_TITLE;
    }
  }

  public CukedoctorConverter renderAttributes() {
    docBuilder.append(
        headerRenderer.renderDocumentHeader(documentAttributes, docBuilder.createPeerBuilder()));
    return this;
  }

  public CukedoctorConverter addCustomPdfTheme() {
    if (notNull(documentAttributes)
        && documentAttributes.getBackend() != null
        && documentAttributes.getBackend().equalsIgnoreCase("pdf")) {
      // name must be filename-theme.yml
      String pdfThemeName = "cukedoctor-pdf.yml";
      // search theme.yml
      List<String> files =
          FileUtil.findFiles(cukedoctorConfig.getCustomizationDir(), pdfThemeName, true);
      if (hasElements(files)) {
        String themePath = files.get(0);
        themePath = themePath.replace("\\", "/");
        documentAttributes.pdfStyle(themePath);
      }
    }
    return this;
  }

  @Override
  public CukedoctorConverter addCustomCss() {
    return this;
  }

  public CukedoctorConverter renderSummary() {
    docBuilder.textLine(summaryRenderer.renderSummary(features, docBuilder.createNestedBuilder()));
    return this;
  }

  public CukedoctorConverter renderFeatures(List<Feature> features) {
    docBuilder.append((featureRenderer.renderFeatures(features, docBuilder.createNestedBuilder())));
    return this;
  }

  @Override
  public CukedoctorConverter renderFeatures() {
    return this.renderFeatures(features);
  }

  @Override
  public CukedoctorConverter setFilename(String filename) {
    if (filename == null) {
      filename = getDocumentationTitle();
    }
    if (!filename.contains(".")) {
      filename = filename + ".adoc";
    }
    filename = filename.replace(" ", "_"); // remove blank spaces with underline

    if (!FileUtil.ADOC_FILE_EXTENSION.matcher(filename).matches()) {
      throw new RuntimeException(
          "Invalid filename extension for file: "
              + filename
              + ". Valid formats are: ad, adoc, asciidoc and asc");
    }

    this.filename = filename;
    return this;
  }

  @Override
  public String getFilename() {
    return filename;
  }

  public CukedoctorConverter saveDocumentation() {
    FileUtil.saveFile(filename, renderDocumentation());
    return this;
  }
}
