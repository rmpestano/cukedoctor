package cukedoctor.multipage.defaults;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.FileUtil;
import cukedoctor.multipage.model.MultipageDocumentation;
import cukedoctor.multipage.model.Page;
import cukedoctor.multipage.spi.MultipagePersister;

public class DefaultMultipagePersister implements MultipagePersister {
    @Override
    public void persist(MultipageDocumentation multipageDocumentation, String outputFolderLocation) {
        for(Page page: multipageDocumentation.getPages()) {
            FileUtil.saveFile(outputFolderLocation + page.getPageTitle() + ".adoc", page.getRender());
        }
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
