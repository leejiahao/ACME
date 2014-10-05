package com.moriah.acme.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessUtils {
	private static final Logger log = LoggerFactory.getLogger(ProcessUtils.class);

	public static void exec(String command) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(command);
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		
		//while ((line = br.readLine()) != null) {
		//	log.info(line);
		//}
	}
}
