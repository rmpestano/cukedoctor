package com.github.cukedoctor.multipage.defaults;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.multipage.model.MultipageDocumentation;
import com.github.cukedoctor.multipage.model.Page;
import com.github.cukedoctor.multipage.spi.MultipagePersister;
import com.github.cukedoctor.util.FileUtil;
import io.github.robwin.markup.builder.asciidoc.AsciiDocBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DefaultMultipagePersister implements MultipagePersister {
    private final static Logger logger = LoggerFactory.getLogger(DefaultMultipagePersister.class);

    @Override
    public void persist(MultipageDocumentation multipageDocumentation, File outputFolderLocation) {
        AsciiDocBuilder builder = new AsciiDocBuilder();

        List<String> entries = new ArrayList<>();

        for(Page page: multipageDocumentation.getPages()) {
            entries.add(builder.crossReference(page.getPageTitle()).toString());
            builder = new AsciiDocBuilder();

            String fileToSave = outputFolderLocation.getPath() + File.separator + page.getPageTitle() + ".adoc";
            logger.debug("Saving file {}", fileToSave);

            FileUtil.saveFile(fileToSave, page.getRender());
        }
        builder.unorderedList(entries);

        FileUtil.saveFile(outputFolderLocation + File.separator + "nav.adoc", builder.toString());
    }

    @Override
    public void setI18n(I18nLoader i18nProvider) {

    }

    @Override
    public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {

    }

    @Override
    public void setDocumentAttributes(DocumentAttributes documentAttributes) {

    }

    @Override
    public void setCukedoctorConfig(CukedoctorConfig cukedoctorConfig) {

    }
}
