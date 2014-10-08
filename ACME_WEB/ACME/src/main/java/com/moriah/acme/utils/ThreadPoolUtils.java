package com.moriah.acme.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtils {
	private static final int NTHREDS = 10;
	private static ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
	
	public void execute(Runnable command) {
		executor.execute(command);
	}
}
