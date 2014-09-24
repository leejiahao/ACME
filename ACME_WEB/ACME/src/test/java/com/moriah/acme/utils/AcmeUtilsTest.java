package com.moriah.acme.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.moriah.acme.service.ProjectService;

import com.moriah.acme.entities.AcmeTv;

public class AcmeUtilsTest {
	private ProjectService tvService = AcmeUtils.getTvService();

	@Test
	public void testGetTvService() {
		AcmeTv tv = new AcmeTv();
		tvService.createTv(tv);
	}

}
