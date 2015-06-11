package com.github.cukedoctor.util;

import org.apache.maven.shared.utils.io.DirectoryScanner;
import org.apache.maven.shared.utils.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pestano on 02/06/15.
 */
public class FileUtil {

	/**
	 * @param path full path to the json feature result
	 * @return absolute path to to json result file
	 */
	public static String findJsonFile(String path) {
		try {
			if(path == null){
				path = "";
			}

			if(path.startsWith("/")){//remove slash to use relative paths
				path = path.substring(1);
			}
			return Paths.get(path.trim()).toAbsolutePath().toString();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, "Could not load feature from " + path);
			return null;
		}

	}

	/**
	 * @param startDir initial directory to scan for features
	 * @return all found json files path that represent cucumber features
	 */
	public static List<String> findJsonFiles(String startDir) {
		try {
			if(startDir == null){
				startDir = "";
			}

			if(startDir.startsWith("/")){//remove slash to use relative paths
				startDir = startDir.substring(1);
			}
			DirectoryScanner scanner = new DirectoryScanner();
			scanner.setIncludes(new String[]{"**/*.json"});
			scanner.setBasedir(new File(Paths.get(startDir.trim()).toAbsolutePath().toString()));
			scanner.scan();
			List<String> absolutePaths = new ArrayList<>(scanner.getIncludedFiles().length);
			for (int i = 0; i < scanner.getIncludedFiles().length; i++) {
				absolutePaths.add(new File(scanner.getBasedir(), scanner.getIncludedFiles()[i]).getAbsolutePath());
			}
			//scanner.getIncludedFiles()
			return absolutePaths;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, "Could not load features from " + startDir);
			return null;
		}

	}

	public static void saveFile(String name, String data){
		if(name == null){
			throw new RuntimeException("Provide file name");
		}

		if(!name.startsWith("/")){
			name = "/"+name;
		}
		try {
			String relativePath = Paths.get("").toAbsolutePath().toString();
			//String relativePath = new File(FileUtil.class.getClassLoader().getResource("").toURI()).getAbsolutePath();

			File f = new File(relativePath+name.substring(0,name.lastIndexOf("/")));//create subdirs (if there any)
			f.mkdirs();
			File file = new File(relativePath+name);
			file.createNewFile();
			FileUtils.fileWrite(file,"UTF-8",data);
			Logger.getLogger(FileUtil.class.getName()).info("Wrote: "+file.getAbsolutePath());
		} catch (IOException e) {
			Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, "Could not create file " + name,e);
		}
	}

	public static File loadFile(String path) {
		if(path == null){
			path = "";
		}

		if(path.startsWith("/")){//remove slash to use relative paths
			path = path.substring(1);
		}
		return new File(Paths.get(path.trim()).toAbsolutePath().toString());
	}
}
