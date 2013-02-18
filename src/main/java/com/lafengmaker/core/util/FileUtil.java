package com.lafengmaker.core.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {
	public static boolean createFile(File file) throws IOException {
		if(! file.exists()) {
			makeDir(file.getParentFile());
		}
		return file.createNewFile();
	}
	public static File getFile(String path) throws Exception{
		File file =new File(path);
		if(! file.exists()) {
			makeDir(file.getParentFile());
			file.createNewFile();
		}
		return file;
	}
	public static void makeDir(File dir) {
		if(! dir.getParentFile().exists()) {
			makeDir(dir.getParentFile());
		}
		dir.mkdir();
	}
	public static void main(String args[]) {
		String filePath = "D:/temp/a/b/c/d/e/f/g.txt";
		File file = new File(filePath);
		try {
//			System.out.println("file.exists()? " + file.exists());
//			boolean created = createFile(file);
//			System.out.println(created?"File created":"File exists, not created.");
//			System.out.println("file.exists()? " + file.exists());
//			System.out.println("2.clas".split(".")[1]);
			System.out.println("2.c,las".split(",").length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



