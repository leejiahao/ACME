package com.moriah.acme.service;

import java.util.List;
import java.util.UUID;

import com.moriah.acme.entities.AcmeJob;

public interface JobService {

	// create JOB
	public void createJob(AcmeJob job);
	
	// read JOB
	public AcmeJob readJob(UUID jobId);
	
	// read draft JOB
	public AcmeJob readDraftJob(String owner);
	
	// update JOB
	public void updateJob(AcmeJob job);
	
	// update DRC of JOB
	public void updateDrcDeckOfJob(UUID jobId, UUID deckId);
	
	// update LVS of JOB
	public void updateLvDecksOfJob(UUID jobId, UUID deckId);
	
	// update RC of JOB
	public void updateRcDeckOfJob(UUID jobId, UUID deckId);
	
	// update SPICE of JOB
	public void updateSpiceModelOfJob(UUID jobId, UUID deckId);
	
	// delete JOB
	public void deleteJob(AcmeJob job);
	
	// find JOBs
	public List<AcmeJob> findJobListByOwner(String owner);
	
}
