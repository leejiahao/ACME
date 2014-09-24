package com.moriah.acme.ws.rs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.moriah.acme.entities.AcmeFile;

@Path("/file")
public class FileResource {
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "D://temp/Upload_Files/file/";
	
    @POST
    @Path("part-file-name")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String post(
            @FormDataParam("part") String s,
            @FormDataParam("part") FormDataContentDisposition d) {
        return s + ":" + d.getFileName();
    }
	
    @POST
    @Path("part-file-name-save")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String postAndSave(
            //@FormDataParam("part") String s,
            @FormDataParam("part") InputStream fileInputStream,
            @FormDataParam("part") FormDataContentDisposition contentDispositionHeader) {
        //return s + ":" + d.getFileName();
        
        //System.out.println("s:" + s);
        //System.out.println("fileInputStream:" + fileInputStream);
        //System.out.println("contentDispositionHeader:" + contentDispositionHeader);

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ contentDispositionHeader.getFileName();
		
		// save the file to the server
		saveFile(fileInputStream, filePath);
		
		String output = "File saved to server location : " + filePath;
		
		return output;
    }
	
	// save uploaded file to a defined location on the server
	private void saveFile(
			InputStream uploadedInputStream,
			String serverLocation) {
		try {
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/file")
    @Produces(MediaType.APPLICATION_JSON)
    public AcmeFile getAcmeFile() {
    	AcmeFile acmeFile = new AcmeFile();
    	acmeFile.setFileName("acme_file.txt");
        return acmeFile;
    }
    

    
    @GET
    @Path("/file_array")
    @Produces(MediaType.APPLICATION_JSON)
    public AcmeFile[] getAcmeFileArray() {
    	AcmeFile[] acmeFileArray = new AcmeFile[3];
    	acmeFileArray[0] = new AcmeFile();
    	acmeFileArray[0].setFileName("acme_file_one.txt");
    	acmeFileArray[1] = new AcmeFile();
    	acmeFileArray[1].setFileName("acme_file_two.txt");
    	acmeFileArray[2] = new AcmeFile();
    	acmeFileArray[2].setFileName("acme_file_three.txt");    	
    	
        return acmeFileArray;
    }
    
    
    @GET
    @Path("/file_list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeFile> getAcmeFileList() {
    	List<AcmeFile> acmeFileList = new ArrayList<AcmeFile>();
    	
    	AcmeFile[] acmeFileArray = new AcmeFile[3];
    	acmeFileArray[0] = new AcmeFile();
    	acmeFileArray[0].setFileName("acme_file_one.txt");
    	acmeFileArray[1] = new AcmeFile();
    	acmeFileArray[1].setFileName("acme_file_two.txt");
    	acmeFileArray[2] = new AcmeFile();
    	acmeFileArray[2].setFileName("acme_file_three.txt");
    	
    	acmeFileList.add(acmeFileArray[0]);
    	acmeFileList.add(acmeFileArray[1]);
    	acmeFileList.add(acmeFileArray[2]);

        return acmeFileList;
    }
    

    
    @GET
    @Path("/file_array_from_list")
    @Produces(MediaType.APPLICATION_JSON)
    public AcmeFile[] getAcmeFileArrayFromList() {
    	List<AcmeFile> acmeFileList = getAcmeFileList();
    	AcmeFile[] acmeFileArray = new AcmeFile[acmeFileList.size()];
    	
        return acmeFileList.toArray(acmeFileArray);
    }
}
