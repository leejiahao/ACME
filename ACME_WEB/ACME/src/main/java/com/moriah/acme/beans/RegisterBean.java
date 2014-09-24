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

import org.primefaces.event.FlowEvent;

import com.moriah.acme.entities.Employee;
import com.moriah.acme.service.AcmeService;
import com.moriah.acme.utils.AcmeUtils;

/**
 * <Prove description of functionality provided by this Type>
 * 
 * @author Kuldeep.Mishra
 */

@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean
{
    private Employee employee = new Employee();

    private int managerId;

    public RegisterBean()
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

    public int getManagerId()
    {
        return managerId;
    }

    public void setManagerId(int managerId)
    {
        this.managerId = managerId;
    }

    public String onFlowProcess(FlowEvent event)
    {
        return event.getNewStep();
    }

    public String save()
    {
        AcmeService service = AcmeUtils.getAcmeService();

        Employee manager = service.findEmployee(managerId);

        employee.setManager(manager);
        employee.setTimestamp(employee.getJoiningDate().getTime());

        service.insertEmployee(employee);

        FacesMessage msg = new FacesMessage("SignUp Successful! Welcome, " + employee.getEmployeeName());

        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "signUpSuccessful";
    }
}
