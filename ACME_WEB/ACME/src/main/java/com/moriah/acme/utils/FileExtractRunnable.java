package com.moriah.acme.utils;

import java.io.IOException;

public class FileExtractRunnable implements Runnable {
	private String archiveFileName;
	private String destPath;
	
	public FileExtractRunnable(String archiveFileName, String destPath) {
		this.archiveFileName = archiveFileName;
		this.destPath = destPath;
	}
	
	@Override
	public void run() {
		try {
			FileUtils.extractArchive(archiveFileName, destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
