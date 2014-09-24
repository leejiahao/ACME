package com.moriah.acme.ws.rs;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.service.ServiceUtil;
import com.moriah.acme.service.TechService;

import com.moriah.acme.entities.AcmeBasicGeom;


/**
 * Technology resource (exposed at "tech" path)
 */
@Path("tech")
public class TechResource {
	private static final Logger log = LoggerFactory.getLogger(TechResource.class);

	private TechService techService = ServiceUtil.getTechService();
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeBasicGeom> getAcmeBasicGeomList() {
    	List<AcmeBasicGeom> basicGeomList = techService.getBasicGeomList();

        return basicGeomList;
    }


}
