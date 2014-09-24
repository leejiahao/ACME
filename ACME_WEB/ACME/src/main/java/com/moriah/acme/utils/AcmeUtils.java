package com.moriah.acme.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moriah.acme.service.ProjectService;
import com.moriah.acme.service.AcmeService;

public class AcmeUtils
{
	private static ProjectService tvService = null;
	private static AcmeService acmeService = null;

    public static ProjectService getTvService()
    {
        if (tvService == null)
        {
            BeanFactory beanfactory = new ClassPathXmlApplicationContext("appContext.xml");
            tvService = (ProjectService) beanfactory.getBean("tvService");
        }
        return tvService;
    }
    
    public static AcmeService getAcmeService()
    {
        if (acmeService == null)
        {
            BeanFactory beanfactory = new ClassPathXmlApplicationContext("appContext.xml");
            acmeService = (AcmeService) beanfactory.getBean("tvService");
        }
        return acmeService;
    }
}
