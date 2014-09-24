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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.service.ServiceUtil;
import com.moriah.acme.service.ProjectService;
import com.moriah.acme.entities.AcmeTv;
import com.moriah.acme.entities.AcmeControlCircuit;
import com.moriah.acme.entities.AcmeDrcDeck;
import com.moriah.acme.entities.AcmeLvsDeck;
import com.moriah.acme.entities.AcmeRcDeck;
import com.moriah.acme.entities.AcmeSpiceModel;
import com.moriah.acme.entities.AcmeFile;

/**
 * Root resource (exposed at "project" path)
 */
@Path("project")
public class ProjectResource {
	private static final Logger log = LoggerFactory.getLogger(ProjectResource.class);
	
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "D://temp/test/ACME/";

	private ProjectService projectService = ServiceUtil.getProjectService();
	
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
	
	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public String createProject(
			@FormParam("tvName") String tvName,
			@FormParam("tvDesc") String tvDesc,
			@FormParam("techCd") String techCd,
			@FormParam("tm6") String tm6
			) {	
		UUID tvId = UUID.randomUUID(); 
		AcmeTv tv = new AcmeTv();
		tv.setTvId(tvId);
		tv.setTvName(tvName);
		tv.setTvDesc(tvDesc);
		tv.setTechCd(techCd);
		tv.setTm6(tm6);

		tv.setCreateUser("CHLEEZO");
		tv.setUpdateUser("CHLEEZO");
		tv.setStatus("Active");

		tv.setCreateTime(Calendar.getInstance().getTime());
		tv.setUpdateTime(Calendar.getInstance().getTime());

		projectService.createTv(tv);
		
		log.info("createProject tv: {} information successfully created.", tv);
		
		return "success";
	}
	
	/*
    @GET
    @Path("/list/{owner}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeJob> getJobByOwner(@PathParam("owner") String owner) {
    	return projectService.findJobListByOwner(owner);
    }
    */
	 
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
    @Path("/tree")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TreeNode> getAcmeTvTreeNodeList() {
    	List<TreeNode> acmeTvTreeNodeList = new ArrayList<TreeNode>();

    	List<AcmeTv> acmeTvList = getAcmeTvList();
    	
    	for (AcmeTv acmeTv:acmeTvList) {
    		TreeNode treeNode = new TreeNode();
    		treeNode.setId(acmeTv.getTvId().toString());
    		treeNode.setText(acmeTv.getTechCd() + "/" + acmeTv.getTvName());
    		treeNode.setState("closed");
    		
    		// Control Circuit
    		TreeNode ccTreeNode = new TreeNode();
    		ccTreeNode.setId(acmeTv.getTvId().toString() + ":CC");
    		ccTreeNode.setText("Control Circuit");
    		treeNode.addChild(ccTreeNode);
    		
    		// DRC
    		TreeNode drcTreeNode = new TreeNode();
    		drcTreeNode.setId(acmeTv.getTvId().toString() + ":DRC");
    		drcTreeNode.setText("DRC Deck");
    		treeNode.addChild(drcTreeNode);
    		
    		// LVS
    		TreeNode lvsTreeNode = new TreeNode();
    		lvsTreeNode.setId(acmeTv.getTvId().toString() + ":LVS");
    		lvsTreeNode.setText("LVS Deck");
    		treeNode.addChild(lvsTreeNode);
    		
    		// RC
    		TreeNode rcTreeNode = new TreeNode();
    		rcTreeNode.setId(acmeTv.getTvId().toString() + ":RC");
    		rcTreeNode.setText("RC Deck");
    		treeNode.addChild(rcTreeNode);
    		
    		// RC
    		TreeNode spiceTreeNode = new TreeNode();
    		spiceTreeNode.setId(acmeTv.getTvId().toString() + ":SPICE");
    		spiceTreeNode.setText("SPICE Model");
    		treeNode.addChild(spiceTreeNode);
    		
    		acmeTvTreeNodeList.add(treeNode);
    	}

        return acmeTvTreeNodeList;
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeTv> getAcmeTvList() {
    	String owner = "CHLEEZO";
    	List<AcmeTv> acmeTvList = projectService.findTvListByOwner(owner);

        return acmeTvList;
    }
    
	@POST
	@Path("/control_circuit/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createControlCircuit(
			@FormDataParam("tvId") String tvId,
			@FormDataParam("circuitName") String circuitName,
			@FormDataParam("circuitType") String circuitType,
			@FormDataParam("isPrimary") String strIsPrimary,
            @FormDataParam("circuitFile") InputStream fileInputStream,
            @FormDataParam("circuitFile") FormDataContentDisposition contentDispositionHeader
			) {	
		// 'P' or null: "createControlCircuit isPrimary: null information successfully created."
		log.info("createControlCircuit strIsPrimary: {} information successfully created.", strIsPrimary);

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ circuitName + "_CC_" + contentDispositionHeader.getFileName();
		
		// save the file to the server
		saveFile(fileInputStream, filePath);
		
		String output = "createControlCircuit:" + filePath;
		log.info("createControlCircuit output: {} information successfully created.", output);
		
		Boolean isPrimary = false;
		if (null != strIsPrimary && strIsPrimary.equals("P")) {
			isPrimary = true;
		}
		
		UUID circuitId = UUID.randomUUID(); 
		AcmeControlCircuit acmeControlCircuit = new AcmeControlCircuit();
		acmeControlCircuit.setTvId(UUID.fromString(tvId));
		acmeControlCircuit.setCircuitId(circuitId);
		acmeControlCircuit.setCircuitName(circuitName);
		acmeControlCircuit.setCircuitType(circuitType);
		acmeControlCircuit.setIsPrimary(isPrimary);

		acmeControlCircuit.setCreateUser("CHLEEZO");
		acmeControlCircuit.setUpdateUser("CHLEEZO");
		acmeControlCircuit.setStatus("Active");

		acmeControlCircuit.setCreateTime(Calendar.getInstance().getTime());
		acmeControlCircuit.setUpdateTime(Calendar.getInstance().getTime());

		projectService.createControlCircuit(acmeControlCircuit);
		
		log.info("createControlCircuit acmeControlCircuit: {} information successfully created.", acmeControlCircuit);
		
		return output;
	}

    @GET
    @Path("/control_circuit/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeControlCircuit> getAcmeControlCircuitList(
    		@QueryParam("tvId") String tvId,
    		@QueryParam("page") String page,
    		@QueryParam("rows") String rows
    		) {
    	List<AcmeControlCircuit> controlCircuitList = projectService.findControlCircuitListByTv(tvId);

        return controlCircuitList;
    }
    
	@POST
	@Path("/drc_deck/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createDrcDeck(
			@FormDataParam("tvId") String tvId,
			@FormDataParam("deckName") String deckName,
			@FormDataParam("deckType") String deckType,
			@FormDataParam("isPrimary") String strIsPrimary,
            @FormDataParam("deckFile") InputStream fileInputStream,
            @FormDataParam("deckFile") FormDataContentDisposition contentDispositionHeader
			) {	
		// 'P' or null: "createControlCircuit isPrimary: null information successfully created."
		log.info("createDrcDeck strIsPrimary: {} information successfully created.", strIsPrimary);

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ deckName + "_DRC_" + contentDispositionHeader.getFileName();
		
		// save the file to the server
		saveFile(fileInputStream, filePath);
		
		String output = "createDrcDeck:" + filePath;
		log.info("createDrcDeck output: {} information successfully created.", output);
		
		Boolean isPrimary = false;
		if (null != strIsPrimary && strIsPrimary.equals("P")) {
			isPrimary = true;
		}
		
		UUID deckId = UUID.randomUUID(); 
		AcmeDrcDeck deck = new AcmeDrcDeck();
		deck.setTvId(UUID.fromString(tvId));
		deck.setDeckId(deckId);
		deck.setDeckName(deckName);
		deck.setDeckType(deckType);
		deck.setIsPrimary(isPrimary);

		deck.setCreateUser("CHLEEZO");
		deck.setUpdateUser("CHLEEZO");
		deck.setStatus("Active");

		deck.setCreateTime(Calendar.getInstance().getTime());
		deck.setUpdateTime(Calendar.getInstance().getTime());

		projectService.createDrcDeck(deck);
		
		log.info("createDrcDeck deck: {} information successfully created.", deck);
		
		return output;
	}
    
    @GET
    @Path("/drc_deck/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeDrcDeck> getAcmeDrcDeckList(
    		@QueryParam("tvId") String tvId,
    		@QueryParam("page") String page,
    		@QueryParam("rows") String rows
    		) {
    	List<AcmeDrcDeck> drcDeckList = projectService.findDrcDeckListByTv(tvId);

        return drcDeckList;
    }
    
	@POST
	@Path("/lvs_deck/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createLvsDeck(
			@FormDataParam("tvId") String tvId,
			@FormDataParam("deckName") String deckName,
			@FormDataParam("deckType") String deckType,
			@FormDataParam("isPrimary") String strIsPrimary,
            @FormDataParam("deckFile") InputStream fileInputStream,
            @FormDataParam("deckFile") FormDataContentDisposition contentDispositionHeader
			) {	
		// 'P' or null: "createControlCircuit isPrimary: null information successfully created."
		log.info("createLvsDeck strIsPrimary: {} information successfully created.", strIsPrimary);

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ deckName + "_LVS_" + contentDispositionHeader.getFileName();
		
		// save the file to the server
		saveFile(fileInputStream, filePath);
		
		String output = "createLvsDeck:" + filePath;
		log.info("createLvsDeck output: {} information successfully created.", output);
		
		Boolean isPrimary = false;
		if (null != strIsPrimary && strIsPrimary.equals("P")) {
			isPrimary = true;
		}
		
		UUID deckId = UUID.randomUUID(); 
		AcmeLvsDeck deck = new AcmeLvsDeck();
		deck.setTvId(UUID.fromString(tvId));
		deck.setDeckId(deckId);
		deck.setDeckName(deckName);
		deck.setDeckType(deckType);
		deck.setIsPrimary(isPrimary);

		deck.setCreateUser("CHLEEZO");
		deck.setUpdateUser("CHLEEZO");
		deck.setStatus("Active");

		deck.setCreateTime(Calendar.getInstance().getTime());
		deck.setUpdateTime(Calendar.getInstance().getTime());

		projectService.createLvsDeck(deck);
		
		log.info("createLvsDeck deck: {} information successfully created.", deck);
		
		return output;
	}
    
    @GET
    @Path("/lvs_deck/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeLvsDeck> getAcmeLvsDeckList(
    		@QueryParam("tvId") String tvId,
    		@QueryParam("page") String page,
    		@QueryParam("rows") String rows
    		) {
    	List<AcmeLvsDeck> lvsDeckList = projectService.findLvsDeckListByTv(tvId);

        return lvsDeckList;
    }
    
	@POST
	@Path("/rc_deck/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createRcDeck(
			@FormDataParam("tvId") String tvId,
			@FormDataParam("deckName") String deckName,
			@FormDataParam("deckType") String deckType,
			@FormDataParam("isPrimary") String strIsPrimary,
            @FormDataParam("deckFile") InputStream fileInputStream,
            @FormDataParam("deckFile") FormDataContentDisposition contentDispositionHeader
			) {	
		// 'P' or null: "createControlCircuit isPrimary: null information successfully created."
		log.info("createRcDeck strIsPrimary: {} information successfully created.", strIsPrimary);

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ deckName + "_RC_" + contentDispositionHeader.getFileName();
		
		// save the file to the server
		saveFile(fileInputStream, filePath);
		
		String output = "createRcDeck:" + filePath;
		log.info("createRcDeck output: {} information successfully created.", output);
		
		Boolean isPrimary = false;
		if (null != strIsPrimary && strIsPrimary.equals("P")) {
			isPrimary = true;
		}
		
		UUID deckId = UUID.randomUUID(); 
		AcmeRcDeck deck = new AcmeRcDeck();
		deck.setTvId(UUID.fromString(tvId));
		deck.setDeckId(deckId);
		deck.setDeckName(deckName);
		deck.setDeckType(deckType);
		deck.setIsPrimary(isPrimary);

		deck.setCreateUser("CHLEEZO");
		deck.setUpdateUser("CHLEEZO");
		deck.setStatus("Active");

		deck.setCreateTime(Calendar.getInstance().getTime());
		deck.setUpdateTime(Calendar.getInstance().getTime());

		projectService.createRcDeck(deck);
		
		log.info("createRcDeck deck: {} information successfully created.", deck);
		
		return output;
	}
    
    @GET
    @Path("/rc_deck/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeRcDeck> getAcmeRcDeckList(
    		@QueryParam("tvId") String tvId,
    		@QueryParam("page") String page,
    		@QueryParam("rows") String rows
    		) {
    	List<AcmeRcDeck> rcDeckList = projectService.findRcDeckListByTv(tvId);

        return rcDeckList;
    }
    
	@POST
	@Path("/spice_model/new")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String createSpiceModel(
			@FormDataParam("tvId") String tvId,
			@FormDataParam("modelName") String modelName,
			@FormDataParam("modelType") String modelType,
			@FormDataParam("isPrimary") String strIsPrimary,
            @FormDataParam("modelFile") InputStream fileInputStream,
            @FormDataParam("modelFile") FormDataContentDisposition contentDispositionHeader
			) {	
		// 'P' or null: "createControlCircuit isPrimary: null information successfully created."
		log.info("createSpiceModel strIsPrimary: {} information successfully created.", strIsPrimary);

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER	+ modelName + "_SPICE_" + contentDispositionHeader.getFileName();
		
		// save the file to the server
		saveFile(fileInputStream, filePath);
		
		String output = "createSpiceModel:" + filePath;
		log.info("createSpiceModel output: {} information successfully created.", output);
		
		Boolean isPrimary = false;
		if (null != strIsPrimary && strIsPrimary.equals("P")) {
			isPrimary = true;
		}
		
		UUID deckId = UUID.randomUUID(); 
		AcmeSpiceModel model = new AcmeSpiceModel();
		model.setTvId(UUID.fromString(tvId));
		model.setModelId(deckId);
		model.setModelName(modelName);
		model.setModelType(modelType);
		model.setIsPrimary(isPrimary);

		model.setCreateUser("CHLEEZO");
		model.setUpdateUser("CHLEEZO");
		model.setStatus("Active");

		model.setCreateTime(Calendar.getInstance().getTime());
		model.setUpdateTime(Calendar.getInstance().getTime());

		projectService.createSpiceModel(model);
		
		log.info("createSpiceModel model: {} information successfully created.", model);
		
		return output;
	}
    
    @GET
    @Path("/spice_model/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcmeSpiceModel> getAcmeSpiceModelList(
    		@QueryParam("tvId") String tvId,
    		@QueryParam("page") String page,
    		@QueryParam("rows") String rows
    		) {
    	List<AcmeSpiceModel> spiceModelList = projectService.findSpiceModelListByTv(tvId);

        return spiceModelList;
    }

}
