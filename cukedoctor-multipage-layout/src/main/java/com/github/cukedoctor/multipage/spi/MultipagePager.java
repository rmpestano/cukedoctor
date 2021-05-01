package com.github.cukedoctor.multipage.spi;

import com.github.cukedoctor.multipage.model.Page;
import com.github.cukedoctor.renderer.BaseRenderer;

import java.util.List;

/**
 * Determines how features are grouped into pages
 *
 * TODO: Do not extend BaseRenderer since this is not a renderer
 */
public interface MultipagePager extends BaseRenderer {
    List<Page> pages(List<String> jsonPaths);
}
