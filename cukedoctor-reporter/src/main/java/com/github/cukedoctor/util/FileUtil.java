package com.github.cukedoctor.util;

import org.apache.maven.shared.utils.io.DirectoryScanner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pestano on 02/06/15.
 */
public class FileUtil {

  /**
   *
   * @param path
   *          full path to the json feature result
   * @return absolute path to to json result file
   */
  public static String findJsonFile(String path) {
    try {
      return new File(FileUtil.class.getClassLoader().getResource(path).toURI()).getAbsolutePath();
    } catch (Exception e) {
      e.printStackTrace();
      Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, "Could not load feature from " + path);
      return null;
    }

  }

  /**
   *
   * @param startDir
   *          initial directory to scan for features
   * @return all found json files path that represent cucumber features
   */
  public static List<String> findJsonFiles(String startDir) {
    try {
      DirectoryScanner scanner = new DirectoryScanner();
      scanner.setIncludes(new String[] { "**/*.json" });
      scanner.setBasedir(new File(FileUtil.class.getClassLoader().getResource(startDir).toURI()));
      scanner.scan();
      List<String> absolutePaths = new ArrayList<>(scanner.getIncludedFiles().length);
        for (int i = 0; i < scanner.getIncludedFiles().length; i++) {
            absolutePaths.add(new File(scanner.getBasedir(),scanner.getIncludedFiles()[i]).getAbsolutePath());
        }
        //scanner.getIncludedFiles()
      return absolutePaths;
    } catch (Exception e) {
      e.printStackTrace();
      Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, "Could not load features from " + startDir);
      return null;
    }

  }
}
