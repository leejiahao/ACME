package com.moriah.acme.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.moriah.acme.entities.DocumentInfo;
import com.moriah.acme.service.AcmeService;
import com.moriah.acme.utils.AcmeUtils;
import com.moriah.acme.utils.FacesUtils;

@ManagedBean(name = "documentDownloadBean")
@RequestScoped
public class DocumentDownloadBean
{
    private int documentId;

    public int getDocumentId()
    {
        return documentId;
    }

    public void setDocumentId(int documentId)
    {
        this.documentId = documentId;
    }

    /**
     * Download file used for downloading photo.
     * 
     * @param photoPath
     *            the photo path
     */
    public void download()
    { 
        
        
        
        AcmeService service = AcmeUtils.getAcmeService();

        setDocumentId(Integer.parseInt(FacesUtils.getRequest().getParameter("documentId")));
        DocumentInfo document = service.findDocumentByDocumentId(getDocumentId());

        final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance()
                .getExternalContext().getResponse();

        ServletOutputStream out = null;
        try
        {
            out = response.getOutputStream();
            out.write(document.getData(), 0, 4096);
        }
        catch (IOException e)
        {

        }
        finally
        {
            if (out != null)
            {
                try
                {
                    out.flush();
                    out.close();
                }
                catch (IOException e)
                {

                }
            }
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
}
