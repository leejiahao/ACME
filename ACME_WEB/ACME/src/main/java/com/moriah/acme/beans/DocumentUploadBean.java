package com.moriah.acme.beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.moriah.acme.entities.DocumentInfo;
import com.moriah.acme.entities.Employee;
import com.moriah.acme.service.AcmeService;
import com.moriah.acme.utils.AcmeConstants;
import com.moriah.acme.utils.AcmeUtils;
import com.moriah.acme.utils.FacesUtils;

@ManagedBean(name = "documentUploadBean")
@RequestScoped
public class DocumentUploadBean
{
    public DocumentUploadBean()
    {
    }

    public String handleFileUpload(FileUploadEvent event)
    {
        HttpSession session = FacesUtils.getSession();
        Employee employee = (Employee) session.getAttribute(AcmeConstants.EMPLOYEE);

        AcmeService service = AcmeUtils.getAcmeService();

        UploadedFile file = event.getFile();

        if (file != null)
        {
            DocumentInfo dataInfo = new DocumentInfo();
            dataInfo.setData(file.getContents());
            dataInfo.setDocumentName(file.getFileName());
            dataInfo.setSize(file.getSize());
            dataInfo.setOwnerName(employee.getEmployeeName());
            dataInfo.setOwnerId(employee.getEmployeeId());
            dataInfo.setUplodedDate(new Date());

            service.insertData(dataInfo);

            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);

            return "successfully uploaded";
        }
        return "uploading fail";
    }
}
