package com.moriah.acme.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceUtil
{
	private static final String TECH_SERVICE_NAME = "techService";
	private static final String PROJECT_SERVICE_NAME = "projectService";
	private static final String JOB_SERVICE_NAME = "jobService";
	
	private static String APPLICATION_CONTEXT_FILE_NAME = "appContext.xml";
	
	/*
	 * TechService
	 */
	private static TechService techService = null;

    public static TechService getTechService()
    {
        if (techService == null)
        {
            BeanFactory beanfactory = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_FILE_NAME);
            techService = (TechService) beanfactory.getBean(TECH_SERVICE_NAME);
        }
        return techService;
    }
	
	/*
	 * ProjectService
	 */
	private static ProjectService tvService = null;

    public static ProjectService getProjectService()
    {
        if (tvService == null)
        {
            BeanFactory beanfactory = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_FILE_NAME);
            tvService = (ProjectService) beanfactory.getBean(PROJECT_SERVICE_NAME);
        }
        return tvService;
    }

	/*
	 * JobService
	 */
	private static JobService jobService = null;

    public static JobService getJobService()
    {
        if (jobService == null)
        {
            BeanFactory beanfactory = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_FILE_NAME);
            jobService = (JobService) beanfactory.getBean(JOB_SERVICE_NAME);
        }
        return jobService;
    }
}
