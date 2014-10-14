package com.moriah.acme;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.ConfigurationException;

public class AcmeConfig {
	
	private static CompositeConfiguration config = new CompositeConfiguration();
	static {
		try {
			config.addConfiguration(new PropertiesConfiguration("acme.properties"));
		} catch (ConfigurationException e) {
			
		}
	}
	
	public static String LINE_SEPARATOR = System.getProperty("line.separator");

	//public static String ACME_ROOT = config.getString("acme_root");
	//public static String ACME_ROOT = "D://temp/test/ACME";
	//public static String ACME_BIN = ACME_ROOT + LINE_SEPARATOR + "BIN";
	public static String ACME_JOB_STARTER ="D://temp/test/ACME_TEST/BIN/run_apv.sh";
	public static String ACME_JOB_PROGRAM = "D://temp/test/ACME_TEST/BIN/APV";
	public static String ACME_PROJECT_PATH = "D://temp/test/ACME_TEST/PROJECT";
	public static String ACME_JOB_PATH = "D://temp/test/ACME_TEST/JOB";
	public static String JOB_INPUT_PATH = "IN";
	public static String JOB_RUN_PATH = "RUN";
	public static String JOB_VERIFY_PATH = "verify";
	public static String JOB_FILE_SUFFIX = ".job";
	
	public static String CONTROL_CIRCUIT_PATH = "FRAME";
	public static String DRC_DECK_PATH = "DRC";
	public static String LVS_DECK_PATH = "LVS";
	public static String RC_DECK_PATH = "RC";
	public static String SPICE_MODEL_PATH = "SPICE";
}
