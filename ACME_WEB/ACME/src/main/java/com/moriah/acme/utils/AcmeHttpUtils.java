package com.moriah.acme.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moriah.acme.service.ProjectService;

public class AcmeHttpUtils
{
    public static ProjectService getTvService()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        ProjectService tvService = (ProjectService) session.getAttribute("tvService");
        if (tvService == null)
        {
            BeanFactory beanfactory = new ClassPathXmlApplicationContext("appContext.xml");
            tvService = (ProjectService) beanfactory.getBean("tvService");
            session.setAttribute("tvService", tvService);
        }
        return tvService;
    }
}
