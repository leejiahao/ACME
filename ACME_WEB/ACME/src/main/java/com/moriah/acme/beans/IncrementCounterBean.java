package com.moriah.acme.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import com.moriah.acme.entities.Employee;
import com.moriah.acme.entities.SubordinatesCounter;
import com.moriah.acme.service.AcmeService;
import com.moriah.acme.utils.AcmeConstants;
import com.moriah.acme.utils.AcmeUtils;
import com.moriah.acme.utils.FacesUtils;

@ManagedBean(name = "incrementCounterBean")
@RequestScoped
public class IncrementCounterBean
{
    private SubordinatesCounter counter = new SubordinatesCounter();

    public IncrementCounterBean()
    {

    }

    public SubordinatesCounter getCounter()
    {
        return counter;
    }

    public void setCounter(SubordinatesCounter counter)
    {
        this.counter = counter;
    }

    public String incrementCounter()
    {
        AcmeService service = AcmeUtils.getAcmeService();

        HttpSession session = FacesUtils.getSession();
        Employee employee = (Employee) session.getAttribute(AcmeConstants.EMPLOYEE);
        counter.setEmployeeId(employee.getEmployeeId());
        
        service.incrementCounter(counter);
        
        return "success";
    }

}
