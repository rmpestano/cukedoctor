package com.github.cukedoctor.multipage.spi;

import com.github.cukedoctor.multipage.model.MultipageDocumentation;
import com.github.cukedoctor.renderer.BaseRenderer;
import java.io.File;

/**
 * This interface determines how a rendered documentation should be persisted.
 *
 * <p>TODO: Do not extend BaseRenderer since this is not a renderer
 */
public interface MultipagePersister extends BaseRenderer {
  void persist(MultipageDocumentation multipageDocumentation, File outputFolderLocation);
}
