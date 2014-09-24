package com.moriah.acme.ws.rs;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.service.ServiceUtil;
import com.moriah.acme.service.JobService;
import com.moriah.acme.entities.AcmeJob;



/**
 * Root resource (exposed at "job" path)
 */
@Path("job")
public class JobResource {
	private static final Logger log = LoggerFactory.getLogger(JobResource.class);

	private JobService jobService = ServiceUtil.getJobService();
	
	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public String createJob(
			@FormParam("dept") String dept
			) {
		log.info("createJob dept: {} information successfully created.", dept);
		return "success";
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
