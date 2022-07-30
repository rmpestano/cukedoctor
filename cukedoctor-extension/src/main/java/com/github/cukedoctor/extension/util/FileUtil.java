package com.github.cukedoctor.extension.util;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;

/**
 * Created by pestano on 02/06/15.
 */
public class FileUtil {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(FileUtil.class.getName());
    public static final Pattern ADOC_FILE_EXTENSION = Pattern.compile("([^\\s]+(\\.(?i)(ad|adoc|asciidoc|asc))$)");

    /**
     * Saves a file into filesystem. Note that name can be saved as absolute (if it has a leading slash) or relative to current path.
     * EX: /target/name.adoc will save the file into
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

        /**
         * if filename is not absolute use current path as base dir
         */
        if (!new File(fullyQualifiedName).isAbsolute()) {
            fullyQualifiedName = Paths.get("").toAbsolutePath().toString() + "/" + name;
        }
        try {
            //create subdirs (if there any)
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
            log.error("Could not create file " + name, e);
            return null;
        }
    }

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
        return new File(Paths.get("").toAbsolutePath().toString() + path.trim());
    }

    public static boolean removeFile(String path) {
        File fileToRemove = loadFile(path);
        return fileToRemove.delete();
    }


    public static File copyFile(String source, String dest) {

        if (source != null && dest != null) {
            try (InputStream in = FileUtil.class.getResourceAsStream(source)) {
                return saveFile(dest, IOUtils.toString(in));
            } catch (IOException e) {
                log.error("Could not copy source file: " + source + " to dest file: " + dest, e);
            }
        }
        return null;
    }

    public static List<String> findFiles(String startDir, final String sulfix) {
        return findFiles(startDir, sulfix, false);
    }

    public static List<String> findFiles(String startDir, final String sulfix, final boolean singleResult) {
        final List<String> absolutePaths = new ArrayList<>();
        if (startDir == null) {
            startDir = "";
        }

        Path startPath = Paths.get(startDir);

        if (!Files.exists(startPath)) {
            if (startDir.startsWith("/")) {// try to find using relative paths
                startDir = startDir.substring(1);
                startPath = Paths.get(startDir);
            }
        }

        if (!Files.exists(startPath)) {
            startPath = Paths.get("");
        }

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
                    final String fileName = file.getFileName().toString();
                    if (fileName.endsWith(sulfix)) {
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
            log.warn("Problems scanning " + sulfix + " files in path:" + startDir, e.getMessage());
        }
        return absolutePaths;
    }

    /**
     * @param source resource from classpath
     * @param dest   dest path
     * @return copied file
     */
    public static File copyFileFromClassPath(String source, String dest) {
        if (source != null && dest != null) {
            try {
                InputStream in = FileUtil.class.getResourceAsStream(source);
                return saveFile(dest, IOUtils.toString(in));
            } catch (IOException e) {
                log.error("Could not copy source file: " + source + " to dest file: " + dest, e);
            }
        }
        return null;


    }

    public static String readFileContent(File target) {
        StringBuilder content = new StringBuilder();
        try (InputStream openStream = new FileInputStream(target)) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openStream))) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }
                bufferedReader.close();

            } catch (Exception e) {
                log.warn("Could not read file content: " + target);
            }

        } catch (Exception e) {
            log.warn("Could not read file content: " + target);
        }

        return content.toString();
    }

    public static File loadTestFile(String fileName) {
        return new File(Paths.get("").toAbsolutePath().toString() + "/target/test-classes/" + fileName);
    }

    public static String removeSpecialChars(String content) {

        return content.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\t", "");

    }
}
