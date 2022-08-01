package com.github.cukedoctor.extension.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Created by pestano on 02/06/15. */
public class FileUtil {

  private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

  /** Pattern for Asciidoc files extension */
  public static final Pattern ADOC_FILE_EXTENSION =
      Pattern.compile("([^\\s]+(\\.(?i)(ad|adoc|asciidoc|asc))$)");

  /**
   * Saves a file into filesystem. Note that name can be saved as absolute (if it has a leading
   * slash) or relative to current path. EX: /target/name.adoc will save the file into
   *
   * @param name file name
   * @param data file content
   * @return saved file
   */
  public static File saveFile(String name, String data) {
    if (name == null) {
      name = "";
    }
    String fullyQualifiedName = name;

    /** if filename is not absolute use current path as base dir */
    if (!new File(fullyQualifiedName).isAbsolute()) {
      fullyQualifiedName = Paths.get("").toAbsolutePath() + "/" + name;
    }
    try {
      // create subdirs (if there any)
      if (fullyQualifiedName.contains("/")) {
        File f = new File(fullyQualifiedName.substring(0, fullyQualifiedName.lastIndexOf("/")));
        f.mkdirs();
      }
      File file = new File(fullyQualifiedName);
      file.createNewFile();
      FileUtils.write(file, data, "UTF-8");
      log.info("Wrote: " + file.getAbsolutePath());
      return file;
    } catch (IOException e) {
      log.error("Could not create file {}", name, e);
      return null;
    }
  }

  /**
   * Gets a file from its path, either relative or absolute.
   *
   * @param path path of the file
   * @return the {@link File} to load.
   */
  public static File loadFile(String path) {
    if (path == null) {
      path = "/";
    }

    File f = new File(path);
    if (f.exists()) {
      return f.getAbsoluteFile();
    }

    if (!path.startsWith("/")) {
      path = "/" + path;
    }
    return new File(Paths.get("").toAbsolutePath() + path.trim());
  }

  /**
   * Deletes a file from filesystem.
   *
   * @param path the path to delete
   * @return {@code true} or {@code false} depending on the outcome of the deletion
   */
  public static boolean removeFile(String path) {
    File fileToRemove = loadFile(path);
    return fileToRemove.delete();
  }

  /**
   * Copy source file to dest file.
   *
   * @param source initial file
   * @param dest copied file
   * @return the dest file copied.
   */
  public static File copyFile(String source, String dest) {

    if (source != null && dest != null) {
      try (InputStream in = FileUtil.class.getResourceAsStream(source)) {
        return saveFile(dest, IOUtils.toString(in));
      } catch (IOException e) {
        log.error("Could not copy source file: {} to dest file: {}", dest, e);
      }
    }
    return null;
  }

  /**
   * List files with a given suffix. Search starts from startDir.
   *
   * @param startDir the directory to start searching files
   * @param suffix suffix to lookup in fies names
   * @return the list of files found.
   */
  public static List<String> findFiles(String startDir, final String suffix) {
    return findFiles(startDir, suffix, false);
  }

  /**
   * List files with a given suffix. Search starts from startDir. Leaves the option to stop
   * searching when a file has been found.
   *
   * @param startDir the directory to start searching files
   * @param suffix suffix to lookup in fies names
   * @param singleResult flag to determine if result is returned once a first file has been found.
   * @return the list of files found.
   */
  public static List<String> findFiles(
      String startDir, final String suffix, final boolean singleResult) {
    final List<String> absolutePaths = new ArrayList<>();
    if (startDir == null) {
      startDir = "";
    }

    Path startPath = Paths.get(startDir);

    if (!Files.exists(startPath)) {
      if (startDir.startsWith("/")) { // try to find using relative paths
        startDir = startDir.substring(1);
        startPath = Paths.get(startDir);
      }
    }

    if (!Files.exists(startPath)) {
      startPath = Paths.get("");
    }

    try {
      Files.walkFileTree(
          startPath,
          new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs)
                throws IOException {
              final String fileName = file.getFileName().toString();
              if (fileName.endsWith(suffix)) {
                absolutePaths.add(file.toAbsolutePath().toString());
                if (singleResult) {
                  return FileVisitResult.TERMINATE;
                }
              }
              if (attrs.isDirectory()) {
                return super.visitFile(file, attrs);
              } else {
                return FileVisitResult.SKIP_SUBTREE;
              }
            }
          });
    } catch (IOException e) {
      log.warn("Problems scanning {} files in path: {}", suffix, startDir, e);
    }
    return absolutePaths;
  }

  /**
   * @param source resource from classpath
   * @param dest dest path
   * @return copied file
   */
  public static File copyFileFromClassPath(String source, String dest) {
    if (source != null && dest != null) {
      try {
        InputStream in = FileUtil.class.getResourceAsStream(source);
        return saveFile(dest, IOUtils.toString(in));
      } catch (IOException e) {
        log.error("Could not copy source file: {} to dest file: {}", source, dest, e);
      }
    }
    return null;
  }

  /**
   * Parses content of a file into a string.
   *
   * @param target the file to parse
   * @return the content of the file.
   */
  public static String readFileContent(File target) {
    StringBuilder content = new StringBuilder();
    try (InputStream openStream = Files.newInputStream(target.toPath())) {
      try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openStream))) {
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
          content.append(line);
        }
      } catch (Exception e) {
        log.warn("Could not read file content: {}", target);
      }
    } catch (Exception e) {
      log.warn("Could not read file content: {}", target);
    }

    return content.toString();
  }

  /**
   * Loads a test file from the {@code target/test-classes} directory.
   *
   * @param fileName the name of the file to load
   * @return the {@link File} instance.
   */
  public static File loadTestFile(String fileName) {
    return new File(Paths.get("").toAbsolutePath() + "/target/test-classes/" + fileName);
  }

  /**
   * Cleans content from spaces, new lines and tabulations.
   *
   * @param content the content to clean
   * @return the clean content.
   */
  public static String removeSpecialChars(String content) {
    return content.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\t", "");
  }
}
