package com.github.cukedoctor.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.ExtensionGroup;
import org.asciidoctor.jruby.extension.spi.ExtensionRegistry;

/** {@link ExtensionRegistry} for Cukedoctor */
public class CukedoctorExtensionRegistry implements ExtensionRegistry {

  /** Cukedoctor group name for declaring extensions to asciidoctor. */
  public static final String CUKEDOCTOR_EXTENSION_GROUP_NAME = "com.github.cukedoctor";
  /** Key for disabling all extensions */
  public static final String DISABLE_ALL_EXT_KEY = "cukedoctor.disable-extensions";
  /** Key for disabling filter extension */
  public static final String FILTER_DISABLE_EXT_KEY = "cukedoctor.disable.filter";
  /** Key for disabling theme extension */
  public static final String THEME_DISABLE_EXT_KEY = "cukedoctor.disable.theme";
  /** Key for disabling min-max extension */
  public static final String MINMAX_DISABLE_EXT_KEY = "cukedoctor.disable.minmax";
  /** Key for disabling style extension */
  public static final String STYLE_DISABLE_EXT_KEY = "cukedoctor.disable.style";
  /** Key for disabling footer extension */
  public static final String FOOTER_DISABLE_EXT_KEY = "cukedoctor.disable.footer";

  @Override
  public void register(Asciidoctor asciidoctor) {
    // null means extension is enabled (by default)
    if (System.getProperty(DISABLE_ALL_EXT_KEY) != null) {
      return;
    }

    ExtensionGroup cukedoctorExtensionGroup =
        asciidoctor.createGroup(CUKEDOCTOR_EXTENSION_GROUP_NAME);
    cukedoctorExtensionGroup.postprocessor(CukedoctorScriptExtension.class);

    if (System.getProperty(FILTER_DISABLE_EXT_KEY) == null) {
      cukedoctorExtensionGroup.postprocessor(CukedoctorFilterExtension.class);
    }
    if (System.getProperty(MINMAX_DISABLE_EXT_KEY) == null) {
      cukedoctorExtensionGroup.blockMacro("minmax", CukedoctorMinMaxExtension.class);
    }

    if (System.getProperty(THEME_DISABLE_EXT_KEY) == null) {
      cukedoctorExtensionGroup.postprocessor(CukedoctorThemeExtension.class);
    }

    if (System.getProperty(FOOTER_DISABLE_EXT_KEY) == null) {
      cukedoctorExtensionGroup.postprocessor(CukedoctorFooterExtension.class);
    }
    if (System.getProperty(STYLE_DISABLE_EXT_KEY) == null) {
      cukedoctorExtensionGroup.postprocessor(CukedoctorStyleExtension.class);
    }

    cukedoctorExtensionGroup.register();
  }
}
