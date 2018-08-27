/**
 * 
 */
package org.archid.civ4.utils;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author jim
 *
 */
public class FileUtils {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(FileUtils.class.getName());
	
	
	/**
	 * Creates the full folder path as defined by <code>pathname</code> if it does not already exist, any parent directories will also be created.
	 * Differs from {@link File#mkdirs()} in that it will return <code>true</code> if the path already exists.  
	 * 
	 * @param pathname absolute or relative path to the directory to ensure exists
	 * @return <code>true</code> if the path exists following the call; <code>false</code> otherwise
	 * @throws SecurityException - If a security manager exists and its {@link java.lang.SecurityManager#checkRead(java.lang.String)} method does not permit verification of the existence of the named directory and all necessary parent directories; or if the {@link java.lang.SecurityManager#checkWrite(java.lang.String)} method does not permit the named directory and all necessary parent directories to be created
	 * @see java.io.File#mkdirs()
	 */
	public static boolean ensureDirExists(String pathname) {
		File path = new File(pathname);
		if (path.exists())
			return true;
		else {
			// We need to perform this double check as this is not an atomic function so the file may have been created between the check for
			// its existence and now, which would result in the mkdirs() call returning false, but the path would actually exist so would
			// be an incorrect return value for this method
			boolean result = path.mkdirs();
			return result ? result : path.exists();
		}
	}
	
	/**
	 * Creates a new empty file at the specified path if it does not already exist, any parent directories will also be created if necessary.
	 * 
	 * @param filePath absolute or relative path to the file to ensure exists
	 * @return <code>true</code> if the file exists following the call; <code>false</code> otherwise
	 * @throws SecurityException - If a security manager exists and its {@link java.lang.SecurityManager#checkRead(java.lang.String)} method does not permit verification of the existence of all necessary parent directories; or if the {@link java.lang.SecurityManager#checkWrite(java.lang.String)} method does not permit the named file and all necessary parent directories to be created
	 */
	public static boolean ensureFileExists(String filePath) {
		File path = new File(filePath);
		if (path.exists())
			return true;
					
		// Check if there is a folder element
		boolean parentExists = false;
		File parent = path.getParentFile();
		if (parent != null)
			parentExists = ensureDirExists(parent.getAbsolutePath());
		
		if (!parentExists)
			return false;
		
		try {
			path.createNewFile();
			return true;
		} catch (IOException e) {
			log.warn("Could not create new file: " + filePath, e);
			return false;
		}
	}
	
	/**
	 * Creates a new empty file at the specified directory if it does not already exist, any parent directories will also be created if necessary.
	 * 
	 * @param dirPath absolute or relative path to the directory the file should exist in
	 * @param fileName name of the file to ensure exists
	 * @return <code>true</code> if the file exists following the call; <code>false</code> otherwise
	 * @throws SecurityException - If a security manager exists and its {@link SecurityManager#checkRead(String)} method does not permit verification of the existence of all necessary parent directories; or if the {@link SecurityManager#checkWrite(String)} method does not permit the named file and all necessary parent directories to be created
	 */
	public static boolean ensureFileExists(String dirPath, String fileName) {
		File parent = new File(dirPath);
		boolean parentExists = false;
		if (parent != null)
			parentExists = ensureDirExists(parent.getAbsolutePath());
		
		if (!parentExists)
			return false;
		
		File file = new File(parent, fileName);
		if (file.exists())
			return true;
		
		try {
			file.createNewFile();
			return true;
		} catch (IOException e) {
			log.warn("Could not create new file: " + file.getAbsolutePath(), e);
			return false;
		}

	}

}
