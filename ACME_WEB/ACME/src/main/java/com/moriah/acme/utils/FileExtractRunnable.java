package com.moriah.acme.utils;

import java.io.IOException;

public class FileExtractRunnable implements Runnable {
	private String tgzFileName;
	private String destPath;
	
	public FileExtractRunnable(String tgzFileName, String destPath) {
		this.tgzFileName = tgzFileName;
		this.destPath = destPath;
	}
	
	@Override
	public void run() {
		try {
			FileUtils.extractTgz(tgzFileName, destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
