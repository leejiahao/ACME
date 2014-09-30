package com.moriah.acme.ws.rs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.service.ServiceUtil;
import com.moriah.acme.service.JobService;
import com.moriah.acme.entities.AcmeJob;

import com.moriah.acme.utils.FileUtils;



/**
 * Root resource (exposed at "job" path)
 */
@Path("job")
public class JobResource {
	private static final Logger log = LoggerFactory.getLogger(JobResource.class);
	
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "D://temp/test/ACME/JOB/";

	private JobService jobService = ServiceUtil.getJobService();

	@POST
	@Path("/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createJob(
			@FormDataParam("tvId") String strTvId,
			@FormDataParam("drcDeckId") String strDrcDeckId,
            @FormDataParam("completeGdsFile") InputStream completeGdsFileInputStream,
            @FormDataParam("completeGdsFile") FormDataContentDisposition completeGdsFileContentDispositionHeader
			) {	
		// 'P' or null: "createControlCircuit isPrimary: null information successfully created."
		log.info("createJob tvId: {} information successfully created.", strTvId);

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ strTvId + "_COMPLETE_GDS_" + completeGdsFileContentDispositionHeader.getFileName();
		
		// save the file to the server
		FileUtils.saveFile(completeGdsFileInputStream, filePath);
		
		String output = "createDrcDeck:" + filePath;
		log.info("createDrcDeck output: {} information successfully created.", output);

		UUID tvId = UUID.fromString(strTvId);
		UUID drcDeckId = UUID.fromString(strDrcDeckId);

		UUID jobId = UUID.randomUUID(); 
		AcmeJob job = new AcmeJob();
		job.setTvId(tvId);
		job.setJobId(jobId);

		job.setCreateUser("CHLEEZO");
		job.setUpdateUser("CHLEEZO");
		job.setStatus("Active");

		job.setCreateTime(Calendar.getInstance().getTime());
		job.setUpdateTime(Calendar.getInstance().getTime());

		jobService.createJob(job);
		
		log.info("createJob job: {} information successfully created.", job);
		
		return output;
	}
	
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJob> getJobByOwner(
    		@QueryParam("owner") String owner
    		) {
    	return jobService.findJobListByOwner(owner);
    }

}
