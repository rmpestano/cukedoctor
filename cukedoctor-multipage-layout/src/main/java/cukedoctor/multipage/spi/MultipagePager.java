package cukedoctor.multipage.spi;

import com.github.cukedoctor.renderer.BaseRenderer;
import cukedoctor.multipage.model.Page;

import java.util.List;

/**
 * Determines how features are grouped into pages
 *
 * TODO: Do not extend BaseRenderer since this is not a renderer
 */
public interface MultipagePager extends BaseRenderer {
    List<Page> pages(List<String> jsonPaths);
}
