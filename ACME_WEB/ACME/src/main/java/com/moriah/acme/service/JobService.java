package com.moriah.acme.service;

import java.util.List;
import java.util.UUID;

import com.moriah.acme.entities.AcmeJob;
import com.moriah.acme.entities.AcmeJobInfo;
import com.moriah.acme.entities.AcmeJobPlacement;
import com.moriah.acme.entities.AcmeJobSrcGds;
import com.moriah.acme.entities.AcmeJobNetlist;
import com.moriah.acme.entities.AcmeJobTestbench;
import com.moriah.acme.entities.AcmeJobTestline;
import com.moriah.acme.entities.AcmeJobDrc;
import com.moriah.acme.entities.AcmeJobLvs;
import com.moriah.acme.entities.AcmeJobRc;
import com.moriah.acme.entities.AcmeJobSpice;
import com.moriah.acme.entities.AcmeJobControlCircuit;

public interface JobService {

	// create JOB
	public void createJob(AcmeJob job);
	
	// read JOB
	public AcmeJob readJob(UUID jobId);
	
	// read draft JOB
	public AcmeJob readDraftJob(String owner);
	
	// update JOB
	public void updateJob(AcmeJob job);
	
	// create JOB testline
	public void createJobTestline(AcmeJobTestline jobTestline);
	
	// create Source Cell Gds of JOB
	public void createSourceCellGdsOfJob(AcmeJobSrcGds jobSrcGds);
	
	// create Control Circuit of JOB
	public void createControlCircuitOfJob(AcmeJobControlCircuit jobControlCircuit);
	
	// create Netlist of JOB
	public void createNetlistOfJob(AcmeJobNetlist jobNetlist);
	
	// create Testbench of JOB
	public void createTestbenchOfJob(AcmeJobTestbench jobTestbench);
	
	// create DRC of JOB
	public void createDrcDeckOfJob(AcmeJobDrc jobDrc);
	
	// update DRC of JOB
	public void updateDrcDeckOfJob(UUID jobId, UUID deckId);
	
	// create LVS of JOB
	public void createLvsDeckOfJob(AcmeJobLvs jobLvs);
	
	// update LVS of JOB
	public void updateLvDecksOfJob(UUID jobId, UUID deckId);
	
	// create RC of JOB
	public void createRcDeckOfJob(AcmeJobRc jobRc);
	
	// update RC of JOB
	public void updateRcDeckOfJob(UUID jobId, UUID deckId);
	
	// create SPICE of JOB
	public void createSpiceModelOfJob(AcmeJobSpice jobSpice);
	
	// update SPICE of JOB
	public void updateSpiceModelOfJob(UUID jobId, UUID deckId);
	
	// delete JOB
	public void deleteJob(AcmeJob job);
	
	// find JOBs
	public List<AcmeJob> findJobListByOwner(String owner);
	
	// find JOB Cell Info
	public List<AcmeJobInfo> findJobCellInfoListByJobId(String strJobId);
	
	// find JOB placement
	public List<AcmeJobPlacement> findJobPlacementListByJobId(String strJobId);
	
	// find JOB source cell GDS
	public List<AcmeJobSrcGds> findJobSrcGdsListByJobId(String strJobId);
	
	// find JOB netlist
	public List<AcmeJobNetlist> findJobNetlistListByJobId(String strJobId);
	
	// find JOB testbench
	public List<AcmeJobTestbench> findJobTestbenchListByJobId(String strJobId);
	
	// find JOB DRC results
	public List<AcmeJobDrc> findJobDrcListByJobId(String strJobId);
	
	// find JOB DRC entity
	public AcmeJobDrc getJobDrcById(UUID jobDrcId);
	
	// find JOB LVS results
	public List<AcmeJobLvs> findJobLvsListByJobId(String strJobId);
	
	// find JOB LVS entity
	public AcmeJobLvs getJobLvsById(UUID jobLvsId);
	
	// find JOB RC results
	public List<AcmeJobRc> findJobRcListByJobId(String strJobId);
	
	// find JOB RC entity
	public AcmeJobRc getJobRcById(UUID jobRcId);
	
	// find JOB SPICE results
	public List<AcmeJobSpice> findJobSpiceListByJobId(String strJobId);
	
	// find JOB SPICE entity
	public AcmeJobSpice getJobSpiceById(UUID jobSpiceId);
	
}
