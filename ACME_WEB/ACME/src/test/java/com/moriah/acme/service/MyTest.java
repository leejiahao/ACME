package com.moriah.acme.service;

import org.junit.Test;

import com.moriah.acme.entities.AcmeTv;

public class MyTest {
	private ProjectService projectService = ServiceUtil.getProjectService();

	@Test
	public void testCreateTv() {
		AcmeTv tv = new AcmeTv();
		projectService.createTv(tv);
	}

}
