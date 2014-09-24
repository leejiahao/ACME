package com.moriah.acme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.entities.AcmeTv;

public class Ptest {
	private static final Logger log = LoggerFactory.getLogger(Ptest.class);
	public static void main(String[] args) {
		AcmeTv tv = new AcmeTv();
		log.info("AcmeTv tv {} information successfully inserted.", tv);
	}

}
