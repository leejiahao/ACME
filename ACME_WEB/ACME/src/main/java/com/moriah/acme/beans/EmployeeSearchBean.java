package com.moriah.acme.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import com.moriah.acme.entities.Employee;
import com.moriah.acme.service.AcmeService;
import com.moriah.acme.utils.AcmeConstants;
import com.moriah.acme.utils.AcmeUtils;
import com.moriah.acme.utils.FacesUtils;

@ManagedBean(name = "subordinateSearchBean")
@RequestScoped
public class EmployeeSearchBean
{
    private List<Employee> subordinates = new ArrayList<Employee>();

    private int managerId;

    private int noOfYears;

    private String searchText;

    private int searchBy;

    public String getSearchText()
    {
        return searchText;
    }

    public void setSearchText(String searchText)
    {
        this.searchText = searchText;
    }

    public int getSearchBy()
    {
        return searchBy;
    }

    public void setSearchBy(int searchBy)
    {
        this.searchBy = searchBy;
    }

    /**
     * @return the managerName
     */
    public int getManagerId()
    {
        return managerId;
    }

    /**
     * @param managerName
     *            the managerName to set
     */
    public void setManagerId(int managerId)
    {
        this.managerId = managerId;
    }

    public int getNoOfYears()
    {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears)
    {
        this.noOfYears = noOfYears;
    }

    public List<Employee> getSubordinates()
    {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates)
    {
        this.subordinates = subordinates;
    }

    public String searchSubordinates()
    {
        AcmeService service = AcmeUtils.getAcmeService();
        setManagerId(Integer.parseInt(FacesUtils.getRequest().getParameter("managerId")));
        List<Employee> subordinates = service.findSubOrdinates(getManagerId());
        if (subordinates != null)
        {
            this.subordinates = subordinates;
        }
        return "foundEmployess";
    }

    public String searchEmployee()
    {
    	AcmeService service = AcmeUtils.getAcmeService();
        Employee employee = null;
        switch (SearchType.getSearchType(searchBy))
        {
        case ID:
            employee = service.findEmployee(Integer.parseInt(getSearchText()));
            break;
        case NAME:
            employee = service.findEmployeeByName(getSearchText());
            break;
        }
        if (employee != null)
        {
            List<Employee> employees = new ArrayList<Employee>();
            employees.add(employee);
            this.subordinates = employees;
        }
        return "foundEmployess";
    }

    public String searchEmployeeByYearOfComplition()
    {
    	AcmeService service = AcmeUtils.getAcmeService();
        HttpSession session = FacesUtils.getSession();
        Employee employee = (Employee) session.getAttribute(AcmeConstants.EMPLOYEE);
        List<Employee> employees = service.findEmployeeByDateOfJoining(getNoOfYears(), employee.getCompany());
        if (employees != null)
        {
            this.subordinates = employees;
        }
        return "foundEmployess";
    }

}
