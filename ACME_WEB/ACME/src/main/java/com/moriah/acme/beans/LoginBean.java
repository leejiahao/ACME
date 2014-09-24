/**
 * Copyright 2012 Impetus Infotech.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.moriah.acme.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.moriah.acme.entities.Employee;
import com.moriah.acme.service.AcmeService;
import com.moriah.acme.utils.AcmeConstants;
import com.moriah.acme.utils.AcmeUtils;
import com.moriah.acme.utils.FacesUtils;

/**
 * <Prove description of functionality provided by this Type>
 * 
 * @author amresh.singh
 */

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean
{
    private Employee employee = new Employee();

    public LoginBean()
    {

    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public String logOff()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have successfully Logged off"));
        session.invalidate();
        return AcmeConstants.OUTCOME_LOGOFF_SUCCESSFUL;
    }

    public String deleteAccount()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        AcmeService service = AcmeUtils.getAcmeService();
        Employee employee = (Employee) session.getAttribute(AcmeConstants.EMPLOYEE);

        service.removeEmployee(employee);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Account successfully deleted"));
        session.invalidate();
        return "Account successfully deleted";
    }

    public String authenticate()
    {
        String outcome = null;

        // Validates Parameters
        if (StringUtils.isBlank(employee.getEmployeeName()))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter your user name"));
            outcome = AcmeConstants.OUTCOME_LOGIN_FAILED;
        }

        if (StringUtils.isBlank(employee.getPassword()))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter password"));
            outcome = AcmeConstants.OUTCOME_LOGIN_FAILED;
        }

        if (StringUtils.isNotBlank(outcome))
        {
            return outcome;
        }
        else
        {
        	AcmeService service = AcmeUtils.getAcmeService();
            Employee foundEmployee = service.findEmployeeByName(employee.getEmployeeName());
            boolean success = service.authenticateEmployee(foundEmployee, employee.getPassword());

            if (!success)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect User Name/Password"));
                outcome = AcmeConstants.OUTCOME_LOGIN_FAILED;
            }
            else
            {
                outcome = AcmeConstants.OUTCOME_LOGIN_SUCCESSFUL;
                HttpSession session = FacesUtils.getSession();
                session.setAttribute(AcmeConstants.EMPLOYEE, foundEmployee);
            }
            return outcome;
        }
    }
}
