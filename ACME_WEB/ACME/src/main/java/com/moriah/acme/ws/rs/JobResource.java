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
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.AcmeConfig;
import com.moriah.acme.beans.JobCommand;
import com.moriah.acme.service.ServiceUtil;
import com.moriah.acme.service.JobService;
import com.moriah.acme.entities.AcmeJob;
import com.moriah.acme.utils.FileUtils;
import com.moriah.acme.utils.ProcessUtils;



/**
 * Root resource (exposed at "job" path)
 */
@Path("job")
public class JobResource {
	private static final Logger log = LoggerFactory.getLogger(JobResource.class);
	
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = AcmeConfig.ACME_JOB_PATH;

	private JobService jobService = ServiceUtil.getJobService();

	@POST
	@Path("/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createJob(
			@FormDataParam("tvId") String strTvId,
			@FormDataParam("jobName") String jobName,
			@FormDataParam("jobDesc") String jobDesc,
			@FormDataParam("circuitId") String strCircuitId,
			@FormDataParam("drcDeckId") String strDrcDeckId,
			@FormDataParam("lvsDeckId") String strLvsDeckId,
			@FormDataParam("rcDeckId") String strRcDeckId,
			@FormDataParam("spiceModelId") String strSpiceModelId,
            @FormDataParam("cellInfoFile") InputStream cellInfoFileInputStream,
            @FormDataParam("cellInfoFile") FormDataContentDisposition cellInfoFileContentDispositionHeader,
            @FormDataParam("placementFile") InputStream placementFileInputStream,
            @FormDataParam("placementFile") FormDataContentDisposition placementFileContentDispositionHeader,
            @FormDataParam("sourceCellGdsFile") InputStream sourceCellGdsFileInputStream,
            @FormDataParam("sourceCellGdsFile") FormDataContentDisposition sourceCellGdsFileContentDispositionHeader,
            @FormDataParam("netlistFile") InputStream netlistFileInputStream,
            @FormDataParam("netlistFile") FormDataContentDisposition netlistFileContentDispositionHeader,
            @FormDataParam("testbenchFile") InputStream testbenchFileInputStream,
            @FormDataParam("testbenchFile") FormDataContentDisposition testbenchFileContentDispositionHeader,
            @FormDataParam("composedGdsFile") InputStream composedGdsFileInputStream,
            @FormDataParam("composedGdsFile") FormDataContentDisposition composedGdsFileContentDispositionHeader
			) throws IOException {
		// job command
		JobCommand jobCommand = new JobCommand();

		// job id
		UUID jobId = UUID.randomUUID();

		log.info("createJob jobId: {} information successfully created.", jobId);
		log.info("createJob tvId: {} information successfully created.", strTvId);
		log.info("createJob circuitId: {} information successfully created.", strCircuitId);
		log.info("createJob drcDeckId: {} information successfully created.", strDrcDeckId);
		log.info("createJob lvsDeckId: {} information successfully created.", strLvsDeckId);
		log.info("createJob rcDeckId: {} information successfully created.", strRcDeckId);
		log.info("createJob spiceModelId: {} information successfully created.", strSpiceModelId);
		
		// job input path
		String jobPath = SERVER_UPLOAD_LOCATION_FOLDER	+ "/" + jobId;
		String jobInputPath = SERVER_UPLOAD_LOCATION_FOLDER	+ "/" + jobId + "/" + AcmeConfig.JOB_INPUT_PATH;
		
		// save the file to the server
		FileUtils.mkdir(jobInputPath);
		
		// job file
		String jobFile = jobInputPath + "/" + jobId + AcmeConfig.JOB_FILE_SUFFIX;
		
		// cell info file		
		String cellInfoFileName = cellInfoFileContentDispositionHeader.getFileName();
		String cellInfoFileFullName = jobInputPath + "/" + cellInfoFileName;
		FileUtils.saveFile(cellInfoFileInputStream, cellInfoFileFullName);
		
		jobCommand.setInfo(cellInfoFileFullName);
		
		// placement file		
		String placementFileName = placementFileContentDispositionHeader.getFileName();
		String placementFileFullName = jobInputPath + "/" + placementFileName;
		FileUtils.saveFile(placementFileInputStream, placementFileFullName);
		
		jobCommand.setPlace(placementFileFullName);
		
		// source cell GDS file		
		String sourceCellGdsFileName = sourceCellGdsFileContentDispositionHeader.getFileName();
		String sourceCellGdsFileFullName = jobInputPath + "/" + sourceCellGdsFileName;
		FileUtils.saveFile(sourceCellGdsFileInputStream, sourceCellGdsFileFullName);
		
		jobCommand.setSrcGds(sourceCellGdsFileFullName);
		
		// netlist
		String netlistFileName = netlistFileContentDispositionHeader.getFileName();
		String netlistFileFullName = jobInputPath + "/" + netlistFileName;
		FileUtils.saveFile(netlistFileInputStream, netlistFileFullName);
		
		jobCommand.setNetlist(netlistFileFullName);
		
		// testbench		
		String testbenchFileName = testbenchFileContentDispositionHeader.getFileName();
		String testbenchFileFullName = jobInputPath + "/" + testbenchFileName;
		FileUtils.saveFile(testbenchFileInputStream, testbenchFileFullName);
		
		jobCommand.setTestbench(testbenchFileFullName);

		// composed GDS		
		String composedGdsFileName = composedGdsFileContentDispositionHeader.getFileName();
		String composedGdsFileFullName = jobInputPath + "/" + composedGdsFileName;
		FileUtils.saveFile(composedGdsFileInputStream, composedGdsFileFullName);
		
		// write job file
		FileUtils.writeStringToFile(jobFile, jobCommand.toString());
		
		String output = "composedGdsFileFullName:" + composedGdsFileFullName;
		log.info("composedGdsFileFullName output: {} information successfully created.", output);

		UUID tvId = UUID.fromString(strTvId);
		UUID drcDeckId = UUID.fromString(strDrcDeckId);

		AcmeJob job = new AcmeJob();
		job.setTvId(tvId);
		job.setJobId(jobId);
		job.setJobName(jobName);
		job.setJobDesc(jobDesc);
		job.setOwner("CHLEEZO");
		job.setCreateUser("CHLEEZO");
		job.setUpdateUser("CHLEEZO");
		job.setStatus("Active");

		job.setCreateTime(Calendar.getInstance().getTime());
		job.setUpdateTime(Calendar.getInstance().getTime());

		jobService.createJob(job);
		
		// start command
		String command = AcmeConfig.ACME_JOB_STARTER + " " + jobFile;
		ProcessUtils.exec(command);
		log.info("createJob command: {} information successfully created.", command);
		
		log.info("createJob job: {} information successfully created.", job);
		
		return output;
	}
	
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJob> getJobByOwner(
    		@QueryParam("owner") String owner,
    		@CookieParam(value = "ACME_USER_ID") String userId
    		) {
    	log.info("getJobByOwner userId: {} information successfully received.", userId);
    	return jobService.findJobListByOwner(userId);
    }

}
