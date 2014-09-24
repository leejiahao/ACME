package com.moriah.acme.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.dao.AcmeDao;
import com.moriah.acme.entities.AcmeJob;
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
    
	// update DRC of JOB
    @Override
	public void updateDrcDeckOfJob(UUID jobId, UUID drcDeckId)
    {
        AcmeJob job = dao.findById(AcmeJob.class, jobId);
        //job.setDrcDeckId(drcDeckId);
        dao.merge(job);
        log.info("AcmeJob job {} information successfully updated.", job);
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
	
	// update RC of JOB
    @Override
	public void updateRcDeckOfJob(UUID jobId, UUID rcDeckId)
    {
        AcmeJob job = dao.findById(AcmeJob.class, jobId);
        //job.setRcDeckId(rcDeckId);
        dao.merge(job);
        log.info("AcmeJob job {} information successfully updated.", job);
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
