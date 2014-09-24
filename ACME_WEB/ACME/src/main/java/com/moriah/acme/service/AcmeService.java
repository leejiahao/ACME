package com.moriah.acme.service;

import java.util.List;

import com.moriah.acme.entities.DocumentInfo;
import com.moriah.acme.entities.Employee;
import com.moriah.acme.entities.SubordinatesCounter;

/**
 * @author Kuldeep.Mishra
 * 
 */
public interface AcmeService
{
    void insertEmployee(Employee employee);

    void insertData(DocumentInfo data);

    Employee findEmployee(Object id);

    Employee findEmployeeByName(String employeeName);

    List<DocumentInfo> findDocumentByEmployeeId(String employeeId);

    List<DocumentInfo> findDocumentByEmployeeName(String employeeName);

    DocumentInfo findDocumentByDocumentId(int documentId);

    void removeEmployee(Employee employee);

    boolean authenticateEmployee(Employee employee, String password);

    List<Employee> findSubOrdinates(int managerId);

    List<Employee> findEmployeeByDateOfJoining(int noOfYears, String company);

    void incrementCounter(SubordinatesCounter counter);
}
