package com.moriah.acme.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.rauschig.jarchivelib.ArchiverFactory;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.CompressionType;

//import org.apache.commons.io.FileUtils;

public class FileUtils {
	// save uploaded file to a defined location on the server
	public static void saveFile(
			InputStream uploadedInputStream,
			String serverLocation) {
		try {
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void mkdir(String fullFilePath) throws IOException {
		File fullPath = new File(fullFilePath);
		org.apache.commons.io.FileUtils.forceMkdir(fullPath);
	}
	
	public static void writeStringToFile(String fileFullName, String data) throws IOException {
		File file = new File(fileFullName);
		org.apache.commons.io.FileUtils.writeStringToFile(file, data);
	}
	
	public static void extractTgz(String tgzFileName, String destPath) throws IOException {
		File archive = new File(tgzFileName);
		File destination = new File(destPath);
		
		Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
		archiver.extract(archive, destination);
	}
}
