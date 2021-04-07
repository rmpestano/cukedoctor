package cukedoctor.multipage.spi;

import com.github.cukedoctor.renderer.BaseRenderer;
import cukedoctor.multipage.model.MultipageDocumentation;

/**
 * This interface determines how a rendered documentation should be persisted.
 *
 * TODO: Do not extend BaseRenderer since this is not a renderer
 */
public interface MultipagePersister extends BaseRenderer {
    void persist(MultipageDocumentation multipageDocumentation, String outputFolderLocation);
}
