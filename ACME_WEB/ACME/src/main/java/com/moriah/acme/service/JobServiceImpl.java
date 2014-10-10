package com.moriah.acme.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.dao.AcmeDao;
import com.moriah.acme.entities.AcmeJob;
import com.moriah.acme.entities.AcmeJobTestline;
import com.moriah.acme.entities.AcmeJobControlCircuit;
import com.moriah.acme.entities.AcmeJobDrc;
import com.moriah.acme.entities.AcmeJobLvs;
import com.moriah.acme.entities.AcmeJobNetlist;
import com.moriah.acme.entities.AcmeJobRc;
import com.moriah.acme.entities.AcmeJobSourceCellGds;
import com.moriah.acme.entities.AcmeJobSpice;
import com.moriah.acme.entities.AcmeJobTestbench;
import com.moriah.acme.entities.AcmeTv;

public class JobServiceImpl implements JobService {
    /**
     * logger used for logging statement.
     */
    private static final Logger log = LoggerFactory.getLogger(JobServiceImpl.class);

    private AcmeDao dao;

    public JobServiceImpl()
    {
    }

    public AcmeDao getDao()
    {
        return dao;
    }

    public void setDao(AcmeDao dao)
    {
        this.dao = dao;
    }
    
	// create JOB
    @Override
	public void createJob(AcmeJob job)
    {
        dao.insert(job);
        log.info("AcmeJob job {} information successfully created.", job);
    }
	
	// read JOB
    @Override
	public AcmeJob readJob(UUID jobId) {
    	AcmeJob job = dao.findById(AcmeJob.class, jobId);
        log.info("AcmeJob job {} information successfully read.", job);
        
        return job;
    }
    
    @Override
	public AcmeJob readDraftJob(String owner) {
    	AcmeJob job = null;
        String query = "Select e from " + AcmeJob.class.getSimpleName() + " e where e.employeeName = " + owner;
        List<AcmeJob> jobs = (List<AcmeJob>) dao.findByQuery(query);
        if (!jobs.isEmpty() && jobs.get(0) != null)
        {
            job = jobs.get(0);
        }
        log.info("AcmeJob job {} information successfully read.", job);
        return job;
    }
    
	// update JOB
    @Override
	public void updateJob(AcmeJob job)
    {
        dao.merge(job);
        log.info("AcmeJob job {} information successfully updated.", job);
    }

    // create JOB testline
    @Override
    public void createJobTestline(AcmeJobTestline jobTestline) {
        dao.insert(jobTestline);
        log.info("AcmeJobTestline jobTestline {} information successfully created.", jobTestline);
    }
    
	// create Source Cell Gds of JOB
    @Override
	public void createSourceCellGdsOfJob(AcmeJobSourceCellGds jobSourceCellGds)
	{
        dao.insert(jobSourceCellGds);
        log.info("AcmeJobSourceCellGds jobSourceCellGds {} information successfully created.", jobSourceCellGds);
	}
	
	// create Control Circuit of JOB
	@Override
	public void createControlCircuitOfJob(AcmeJobControlCircuit jobControlCircuit)
	{
        dao.insert(jobControlCircuit);
        log.info("AcmeJobControlCircuit jobControlCircuit {} information successfully created.", jobControlCircuit);
	}
	
	// create Netlist of JOB
	@Override
	public void createNetlistOfJob(AcmeJobNetlist jobNetlist)
	{
        dao.insert(jobNetlist);
        log.info("AcmeJobNetlist jobNetlist {} information successfully created.", jobNetlist);
	}
	
	// create Testbench of JOB
	@Override
	public void createTestbenchOfJob(AcmeJobTestbench jobTestbench)
	{
        dao.insert(jobTestbench);
        log.info("AcmeJobTestbench jobTestbench {} information successfully created.", jobTestbench);
	}
	
	// create DRC of JOB
	@Override
	public void createDrcDeckOfJob(AcmeJobDrc jobDrc)
	{
        dao.insert(jobDrc);
        log.info("AcmeJobLvs jobLvs {} information successfully created.", jobDrc);
	}
    
	// update DRC of JOB
    @Override
	public void updateDrcDeckOfJob(UUID jobId, UUID drcDeckId)
    {
        AcmeJob job = dao.findById(AcmeJob.class, jobId);
        //job.setDrcDeckId(drcDeckId);
        dao.merge(job);
        log.info("AcmeJob job {} information successfully updated.", job);
    }
    
	// create LVS of JOB
    @Override
	public void createLvsDeckOfJob(AcmeJobLvs jobLvs)
	{
        dao.insert(jobLvs);
        log.info("AcmeJobLvs jobLvs {} information successfully created.", jobLvs);
	}

	// update LVS of JOB
    @Override
	public void updateLvDecksOfJob(UUID jobId, UUID lvsDeckId)
    {
        AcmeJob job = dao.findById(AcmeJob.class, jobId);
        //job.setLvsDeckId(lvsDeckId);
        dao.merge(job);
        log.info("AcmeJob job {} information successfully updated.", job);
    }
    
	// create RC of JOB
    @Override
	public void createRcDeckOfJob(AcmeJobRc jobRc)
	{
        dao.insert(jobRc);
        log.info("AcmeJobRc jobRc {} information successfully created.", jobRc);
	}
	
	// update RC of JOB
    @Override
	public void updateRcDeckOfJob(UUID jobId, UUID rcDeckId)
    {
        AcmeJob job = dao.findById(AcmeJob.class, jobId);
        //job.setRcDeckId(rcDeckId);
        dao.merge(job);
        log.info("AcmeJob job {} information successfully updated.", job);
    }
    
	// create SPICE of JOB
    @Override
	public void createSpiceModelOfJob(AcmeJobSpice jobSpice)
	{
        dao.insert(jobSpice);
        log.info("AcmeJobSpice jobSpice {} information successfully created.", jobSpice);
	}
	
	// update SPICE of JOB
    @Override
	public void updateSpiceModelOfJob(UUID jobId, UUID spiceModelId)
    {
        AcmeJob job = dao.findById(AcmeJob.class, jobId);
        //job.setSpiceModelId(spiceModelId);
        dao.merge(job);
        log.info("AcmeJob job {} information successfully updated.", job);
    }
	
	// delete JOB
    @Override
	public void deleteJob(AcmeJob job)
    {
        dao.remove(job);
        log.info("AcmeJob job {} information successfully deleted.", job);
    }
    
    @Override
    public List<AcmeJob> findJobListByOwner(String owner)
    {
        String query = "Select e from " + AcmeJob.class.getSimpleName() + " e where e.owner = " + owner;
        List<AcmeJob> jobs = (List<AcmeJob>) dao.findByQuery(query);

        return jobs;
    }
}
