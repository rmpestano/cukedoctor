package com.github.cukedoctor.extension.util;

import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.maven.shared.utils.io.IOUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Created by pestano on 02/06/15.
 */
public class FileUtil {

    public static Logger log = Logger.getLogger(FileUtil.class.getName());
    public static final Pattern ADOC_FILE_EXTENSION = Pattern.compile("([^\\s]+(\\.(?i)(ad|adoc|asciidoc|asc))$)");

    /**
     * Saves a file into filesystem. Note that name can be saved as absolute (if it has a leading slash) or relative to current path.
     * EX: /target/name.adoc will save the file into
     *
     * @param name file name
     * @param data file content
     * @return
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
            FileUtils.fileWrite(file, "UTF-8", data);
            log.info("Wrote: " + file.getAbsolutePath());
            return file;
        } catch (IOException e) {
            log.log(Level.SEVERE, "Could not create file " + name, e);
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

			/*if (dest.startsWith("/")) { //remove slash to use relative paths. Dest file is saved using folder where Cukedoctor is executed as relative path
                dest = dest.substring(1);
			}*/
            try {
                InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(source);
                //OutputStream out = new FileOutputStream(new File(Paths.get(dest).toAbsolutePath().toString()));
                //IOUtil.copy(in, out);
                return saveFile(dest, IOUtil.toString(in));
            } catch (IOException e) {
                log.log(Level.SEVERE, "Could not copy source file: " + source + " to dest file: " + dest, e);
            }
        }
        return null;


    }
}
