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
import com.moriah.acme.service.ProjectService;
import com.moriah.acme.entities.AcmeJob;
import com.moriah.acme.entities.AcmeJobInfo;
import com.moriah.acme.entities.AcmeJobPlacement;
import com.moriah.acme.entities.AcmeJobSrcGds;
import com.moriah.acme.entities.AcmeJobNetlist;
import com.moriah.acme.entities.AcmeJobTestline;
import com.moriah.acme.entities.AcmeJobTestbench;
import com.moriah.acme.entities.AcmeJobDrc;
import com.moriah.acme.entities.AcmeJobLvs;
import com.moriah.acme.entities.AcmeJobRc;
import com.moriah.acme.entities.AcmeJobSpice;
import com.moriah.acme.entities.AcmeControlCircuit;
import com.moriah.acme.entities.AcmeDrcDeck;
import com.moriah.acme.entities.AcmeLvsDeck;
import com.moriah.acme.entities.AcmeRcDeck;
import com.moriah.acme.entities.AcmeSpiceModel;
import com.moriah.acme.utils.FileUtils;
import com.moriah.acme.utils.ProcessUtils;
import com.moriah.acme.utils.CellInfoUtils;


/**
 * Root resource (exposed at "job" path)
 */
@Path("job")
public class JobResource {
	private static final Logger log = LoggerFactory.getLogger(JobResource.class);
	
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = AcmeConfig.ACME_JOB_PATH;

	private JobService jobService = ServiceUtil.getJobService();
	private ProjectService projectService = ServiceUtil.getProjectService();

	@POST
	@Path("/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createJob(
			@CookieParam(value = "ACME_USER_ID") String userId,
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
			) throws JobException {
		String output = "ERROR";

		try {
			log.info("createJob userId: {} information successfully created.", userId);
	
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
	
			jobCommand.setPath(jobPath);;
			
			// job file
			String jobFile = jobInputPath + "/" + jobId + AcmeConfig.JOB_FILE_SUFFIX;
			
			// cell info file		
			String cellInfoFileName = cellInfoFileContentDispositionHeader.getFileName();
			String cellInfoFileFullName = jobInputPath + "/" + cellInfoFileName;
			FileUtils.saveFile(cellInfoFileInputStream, cellInfoFileFullName);
			
			jobCommand.setInfo(cellInfoFileFullName);
			
			// get testline list
			List<AcmeJobTestline> testlineList = CellInfoUtils.getAcmeJobTestlineListFromCellInfo(cellInfoFileFullName);
			
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
			if (null != composedGdsFileContentDispositionHeader) {
				String composedGdsFileName = composedGdsFileContentDispositionHeader.getFileName();
				String composedGdsFileFullName = jobInputPath + "/" + composedGdsFileName;
				FileUtils.saveFile(composedGdsFileInputStream, composedGdsFileFullName);
			}
			
			// Control Circuit
			AcmeControlCircuit controlCircuit = projectService.findControlCircuitById(strCircuitId);
			jobCommand.setControlCircuitType(controlCircuit.getCircuitType());
			jobCommand.setControlCircuitTop(controlCircuit.getCircuitGdsTopCell());
			jobCommand.setControlCircuit(controlCircuit.getCircuitGdsFilePath() + "/" + controlCircuit.getCircuitGdsFileName());
			jobCommand.setCoordinate(controlCircuit.getCoordinateFilePath() + "/" + controlCircuit.getCoordinateFileName());
			
			// control circuit netlist
			jobCommand.setControlCircuitNetlist(controlCircuit.getCoordinateFilePath() + "/" + controlCircuit.getNetlistFileName());
			
			// DRC deck
			AcmeDrcDeck drcDeck = projectService.findDrcDeckById(strDrcDeckId);
			jobCommand.setDrcDeck(drcDeck.getDeckFilePath() + "/" + drcDeck.getDeckFileName());
			
			// LVS deck
			AcmeLvsDeck lvsDeck = projectService.findLvsDeckById(strLvsDeckId);
			jobCommand.setLvsDeck(lvsDeck.getDeckFilePath() + "/" + lvsDeck.getDeckFileName());
			
			// SPICE model
			AcmeSpiceModel spiceModel = projectService.findSpiceModelById(strSpiceModelId);
			jobCommand.setSpiceModel(spiceModel.getModelFilePath() + "/" + spiceModel.getModelFileName());
			
			// write job file
			FileUtils.writeStringToFile(jobFile, jobCommand.toString());
			
			output = "composedGdsFileFullName:" + "composedGdsFileFullName";
			log.info("composedGdsFileFullName output: {} information successfully created.", output);
	
			UUID tvId = UUID.fromString(strTvId);
			UUID drcDeckId = UUID.fromString(strDrcDeckId);
	
			AcmeJob job = new AcmeJob();
			job.setTvId(tvId);
			job.setJobId(jobId);
			job.setJobName(jobName);
			job.setJobDesc(jobDesc);
			job.setOwner(userId);
			job.setCreateUser(userId);
			job.setUpdateUser(userId);
			job.setStatus("Active");
	
			job.setCreateTime(Calendar.getInstance().getTime());
			job.setUpdateTime(Calendar.getInstance().getTime());
			
			// create job info file
			List<AcmeJobInfo> infoList = new ArrayList<AcmeJobInfo>();
			
			AcmeJobInfo jobInfo = new AcmeJobInfo();
			UUID jobInfoId = UUID.randomUUID();
			jobInfo.setJobInfoId(jobInfoId);
			jobInfo.setCreateUser(userId);
			jobInfo.setUpdateUser(userId);
			jobInfo.setStatus("Active");
			jobInfo.setCreateTime(Calendar.getInstance().getTime());
			jobInfo.setUpdateTime(Calendar.getInstance().getTime());
			
			infoList.add(jobInfo);
			
			job.setAcmeJobInfoList(infoList);
			
			// create job placement file
			List<AcmeJobPlacement> placementList = new ArrayList<AcmeJobPlacement>();
			
			AcmeJobPlacement jobPlacement = new AcmeJobPlacement();
			UUID jobPlacementId = UUID.randomUUID();
			jobPlacement.setJobPlacementId(jobPlacementId);
			jobPlacement.setCreateUser(userId);
			jobPlacement.setUpdateUser(userId);
			jobPlacement.setStatus("Active");
			jobPlacement.setCreateTime(Calendar.getInstance().getTime());
			jobPlacement.setUpdateTime(Calendar.getInstance().getTime());
			
			placementList.add(jobPlacement);
			
			job.setAcmeJobPlacementList(placementList);
			
			// create job source GDS
			List<AcmeJobSrcGds> srcGdsList = new ArrayList<AcmeJobSrcGds>();
			
			AcmeJobSrcGds jobSrcGds = new AcmeJobSrcGds();
			UUID jobSrcGdsId = UUID.randomUUID();
			jobSrcGds.setJobSrcGdsId(jobSrcGdsId);
			jobSrcGds.setCreateUser(userId);
			jobSrcGds.setUpdateUser(userId);
			jobSrcGds.setStatus("Active");
			jobSrcGds.setCreateTime(Calendar.getInstance().getTime());
			jobSrcGds.setUpdateTime(Calendar.getInstance().getTime());
			
			srcGdsList.add(jobSrcGds);
			
			job.setAcmeJobSrcGdsList(srcGdsList);
			
			// create job netlist
			List<AcmeJobNetlist> netlistList = new ArrayList<AcmeJobNetlist>();
			
			AcmeJobNetlist jobNetlist = new AcmeJobNetlist();
			UUID jobNetlistId = UUID.randomUUID();
			jobNetlist.setJobNetlistId(jobNetlistId);
			jobNetlist.setCreateUser(userId);
			jobNetlist.setUpdateUser(userId);
			jobNetlist.setStatus("Active");
			jobNetlist.setCreateTime(Calendar.getInstance().getTime());
			jobNetlist.setUpdateTime(Calendar.getInstance().getTime());
			
			netlistList.add(jobNetlist);
			
			job.setAcmeJobNetlistList(netlistList);
			
			// create job testbench
			List<AcmeJobTestbench> testbenchList = new ArrayList<AcmeJobTestbench>();
			
			AcmeJobTestbench jobTestbench = new AcmeJobTestbench();
			UUID jobTestbenchId = UUID.randomUUID();
			jobTestbench.setJobTestbenchId(jobTestbenchId);
			jobTestbench.setCreateUser(userId);
			jobTestbench.setUpdateUser(userId);
			jobTestbench.setStatus("Active");
			jobTestbench.setCreateTime(Calendar.getInstance().getTime());
			jobTestbench.setUpdateTime(Calendar.getInstance().getTime());
			
			testbenchList.add(jobTestbench);
			
			job.setAcmeJobTestbenchList(testbenchList);
			
			// result lists
			List<AcmeJobDrc> jobDrcList = new ArrayList<AcmeJobDrc>();
			List<AcmeJobLvs> jobLvsList = new ArrayList<AcmeJobLvs>();
			List<AcmeJobRc> jobRcList = new ArrayList<AcmeJobRc>();
			List<AcmeJobSpice> jobSpiceList = new ArrayList<AcmeJobSpice>();
			
			// create job testlines
			for (AcmeJobTestline jobTestline: testlineList) {
				// create job testline
				UUID jobTestlineId = UUID.randomUUID();
				jobTestline.setJobTestlineId(jobTestlineId);
				jobTestline.setCreateUser(userId);
				jobTestline.setUpdateUser(userId);
				jobTestline.setStatus("Active");
				jobTestline.setCreateTime(Calendar.getInstance().getTime());
				jobTestline.setUpdateTime(Calendar.getInstance().getTime());
				
				// create job DRC result entities
				AcmeJobDrc jobDrc = new AcmeJobDrc();
				
				UUID jobDrcId = UUID.randomUUID();
				jobDrc.setJobDrcId(jobDrcId);
				jobDrc.setJobTestlineId(jobTestlineId);
				jobDrc.setTestlineName(jobTestline.getTestlineName());
				jobDrc.setCreateUser(userId);
				jobDrc.setUpdateUser(userId);
				jobDrc.setStatus("Active");
				jobDrc.setCreateTime(Calendar.getInstance().getTime());
				jobDrc.setUpdateTime(Calendar.getInstance().getTime());
				
				jobDrcList.add(jobDrc);
				
				// create job LVS result entities
				AcmeJobLvs jobLvs = new AcmeJobLvs();
				
				UUID jobLvsId = UUID.randomUUID();
				jobLvs.setJobLvsId(jobLvsId);
				jobLvs.setJobTestlineId(jobTestlineId);
				jobLvs.setTestlineName(jobTestline.getTestlineName());
				jobLvs.setCreateUser(userId);
				jobLvs.setUpdateUser(userId);
				jobLvs.setStatus("Active");
				jobLvs.setCreateTime(Calendar.getInstance().getTime());
				jobLvs.setUpdateTime(Calendar.getInstance().getTime());
				
				jobLvsList.add(jobLvs);
				
				// create job RC result entities
				AcmeJobRc jobRc = new AcmeJobRc();
				
				UUID jobRcId = UUID.randomUUID();
				jobRc.setJobRcId(jobRcId);
				jobRc.setJobTestlineId(jobTestlineId);
				jobRc.setTestlineName(jobTestline.getTestlineName());
				jobRc.setCreateUser(userId);
				jobRc.setUpdateUser(userId);
				jobRc.setStatus("Active");
				jobRc.setCreateTime(Calendar.getInstance().getTime());
				jobRc.setUpdateTime(Calendar.getInstance().getTime());
				
				jobRcList.add(jobRc);
				
				// create job SPICE result entities
				AcmeJobSpice jobSpice = new AcmeJobSpice();
				
				UUID jobSpiceId = UUID.randomUUID();
				jobSpice.setJobSpiceId(jobSpiceId);
				jobSpice.setJobTestlineId(jobTestlineId);
				jobSpice.setTestlineName(jobTestline.getTestlineName());
				jobSpice.setCreateUser(userId);
				jobSpice.setUpdateUser(userId);
				jobSpice.setStatus("Active");
				jobSpice.setCreateTime(Calendar.getInstance().getTime());
				jobSpice.setUpdateTime(Calendar.getInstance().getTime());
				
				jobSpiceList.add(jobSpice);
			}
			
			job.setAcmeJobTestlineList(testlineList);
			job.setAcmeJobDrcList(jobDrcList);
			job.setAcmeJobLvsList(jobLvsList);
			job.setAcmeJobRcList(jobRcList);
			job.setAcmeJobSpiceList(jobSpiceList);
			
			jobService.createJob(job);
			log.info("createJob job: {} information successfully created.", job);
			
			// start command
			String command = AcmeConfig.ACME_JOB_STARTER + " " + jobFile;
			ProcessUtils.exec(command);
			log.info("createJob command: {} information successfully created.", command);
			
			log.info("createJob job: {} information successfully created.", job);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new JobException("Submit job failed.", e);
		}
		
		return output;
	}
	
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJob> getJobByOwner(
    		@CookieParam(value = "ACME_USER_ID") String userId
    		) {
    	log.info("getJobByOwner userId: {} information successfully received.", userId);
    	List<AcmeJob> jobList = jobService.findJobListByOwner(userId);
    	log.info("getJobByOwner jobList.size(): {} information successfully received.", jobList.size());
    	
    	return jobList;
    }
    
    @GET
    @Path("/drc/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJobDrc> getJobDrcByJobId(
    		@CookieParam(value = "ACME_USER_ID") String userId,
    		@QueryParam("jobId") String strJobId
    		) {
    	log.info("getJobDrcByJobId userId: {} information successfully received.", userId);
    	log.info("getJobDrcByJobId strJobId: {} information successfully received.", strJobId);
    	List<AcmeJobDrc> jobDrcList = jobService.findJobDrcListByJobId(strJobId);
    	log.info("getJobDrcByJobId jobDrcList.size(): {} information successfully received.", jobDrcList.size());
    	
    	return jobDrcList;
    }
    
    @GET
    @Path("/lvs/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJobLvs> getJobLvsByJobId(
    		@CookieParam(value = "ACME_USER_ID") String userId,
    		@QueryParam("jobId") String strJobId
    		) {
    	log.info("getJobLvsByJobId userId: {} information successfully received.", userId);
    	log.info("getJobLvsByJobId strJobId: {} information successfully received.", strJobId);
    	List<AcmeJobLvs> jobLvsList = jobService.findJobLvsListByJobId(strJobId);
    	log.info("getJobLvsByJobId jobLvsList.size(): {} information successfully received.", jobLvsList.size());
    	
    	return jobLvsList;
    }
    
    @GET
    @Path("/rc/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJobRc> getJobRcByJobId(
    		@CookieParam(value = "ACME_USER_ID") String userId,
    		@QueryParam("jobId") String strJobId
    		) {
    	log.info("getJobRcByJobId userId: {} information successfully received.", userId);
    	log.info("getJobRcByJobId strJobId: {} information successfully received.", strJobId);
    	List<AcmeJobRc> jobRcList = jobService.findJobRcListByJobId(strJobId);
    	log.info("getJobRcByJobId jobRcList.size(): {} information successfully received.", jobRcList.size());
    	
    	return jobRcList;
    }
    
    @GET
    @Path("/spice/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJobSpice> getJobSpiceByJobId(
    		@CookieParam(value = "ACME_USER_ID") String userId,
    		@QueryParam("jobId") String strJobId
    		) {
    	log.info("getJobSpiceByJobId userId: {} information successfully received.", userId);
    	log.info("getJobSpiceByJobId strJobId: {} information successfully received.", strJobId);
    	List<AcmeJobSpice> jobSpiceList = jobService.findJobSpiceListByJobId(strJobId);
    	log.info("getJobSpiceByJobId jobSpiceList.size(): {} information successfully received.", jobSpiceList.size());
    	
    	return jobSpiceList;
    }

}
