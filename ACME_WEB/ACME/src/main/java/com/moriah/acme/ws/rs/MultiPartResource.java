/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.moriah.acme.ws.rs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

/**
 * @author Michal Gajdos (michal.gajdos at oracle.com)
 */
@Path("/form")
public class MultiPartResource {
	
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "D://temp/Upload_Files/";

    @POST
    @Path("part")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String post(@FormDataParam("part") String s) {
        return s;
    }

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

    @POST
    @Path("xml-jaxb-part")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String post(
            @FormDataParam("string") String s,
            @FormDataParam("string") FormDataContentDisposition sd,
            @FormDataParam("bean") Bean b,
            @FormDataParam("bean") FormDataContentDisposition bd) {
        return s + ":" + sd.getFileName() + "," + b.value + ":" + bd.getFileName();
    }
    
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
			@FormDataParam("file") String s,
			@FormDataParam("file") Bean b,
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader) {
System.out.println("s:" + s);
System.out.println("b:" + b);
System.out.println("fileInputStream:" + fileInputStream);
System.out.println("contentDispositionHeader:" + contentDispositionHeader);
		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ contentDispositionHeader.getFileName();

		// save the file to the server
		saveFile(fileInputStream, filePath);

		String output = "File saved to server location : " + filePath;

		return Response.status(200).entity(output).build();

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
}
