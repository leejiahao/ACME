package com.moriah.acme.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.dao.AcmeDao;
import com.moriah.acme.entities.AcmeJob;
import com.moriah.acme.entities.AcmeJobInfo;
import com.moriah.acme.entities.AcmeJobPlacement;
import com.moriah.acme.entities.AcmeJobTestline;
import com.moriah.acme.entities.AcmeJobControlCircuit;
import com.moriah.acme.entities.AcmeJobDrc;
import com.moriah.acme.entities.AcmeJobLvs;
import com.moriah.acme.entities.AcmeJobNetlist;
import com.moriah.acme.entities.AcmeJobRc;
import com.moriah.acme.entities.AcmeJobSrcGds;
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
	public void createSourceCellGdsOfJob(AcmeJobSrcGds jobSrcGds)
	{
        dao.insert(jobSrcGds);
        log.info("AcmeJobSourceCellGds jobSrcGds {} information successfully created.", jobSrcGds);
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
    
	// find JOB Cell Info
    @Override
	public List<AcmeJobInfo> findJobCellInfoListByJobId(String strJobId) {
        String query = "Select e from " + AcmeJobInfo.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobInfo> jobInfoList = (List<AcmeJobInfo>) dao.findByQuery(query);

        return jobInfoList;
    }
	
	// find JOB placement
    @Override
	public List<AcmeJobPlacement> findJobPlacementListByJobId(String strJobId) {
        String query = "Select e from " + AcmeJobPlacement.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobPlacement> jobPlacementList = (List<AcmeJobPlacement>) dao.findByQuery(query);

        return jobPlacementList;
    }
	
	// find JOB source cell GDS
    @Override
	public List<AcmeJobSrcGds> findJobSrcGdsListByJobId(String strJobId) {
        String query = "Select e from " + AcmeJobSrcGds.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobSrcGds> jobSrcGdsList = (List<AcmeJobSrcGds>) dao.findByQuery(query);

        return jobSrcGdsList;
    }
	
	// find JOB netlist
    @Override
	public List<AcmeJobNetlist> findJobNetlistListByJobId(String strJobId) {
        String query = "Select e from " + AcmeJobNetlist.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobNetlist> jobNetlistList = (List<AcmeJobNetlist>) dao.findByQuery(query);

        return jobNetlistList;
    }
	
	// find JOB testbench
    @Override
	public List<AcmeJobTestbench> findJobTestbenchListByJobId(String strJobId) {
        String query = "Select e from " + AcmeJobTestbench.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobTestbench> jobTestbenchList = (List<AcmeJobTestbench>) dao.findByQuery(query);

        return jobTestbenchList;
    }
    
    @Override
    public List<AcmeJobDrc> findJobDrcListByJobId(String strJobId)
    {
        String query = "Select e from " + AcmeJobDrc.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobDrc> jobDrcList = (List<AcmeJobDrc>) dao.findByQuery(query);

        return jobDrcList;
    }
    
    @Override
	public AcmeJobDrc getJobDrcById(UUID jobDrcId) {
    	AcmeJobDrc jobDrc = dao.findById(AcmeJobDrc.class, jobDrcId);
        log.info("getJobDrcById jobDrc {} information successfully read.", jobDrc);
        
        return jobDrc;
    }
    
    @Override
    public List<AcmeJobLvs> findJobLvsListByJobId(String strJobId)
    {
        String query = "Select e from " + AcmeJobLvs.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobLvs> jobLvsList = (List<AcmeJobLvs>) dao.findByQuery(query);

        return jobLvsList;
    }
    
    @Override
	public AcmeJobLvs getJobLvsById(UUID jobLvsId) {
    	AcmeJobLvs jobLvs = dao.findById(AcmeJobLvs.class, jobLvsId);
        log.info("getJobLvsById jobLvs {} information successfully read.", jobLvs);
        
        return jobLvs;
    }
    
    @Override
    public List<AcmeJobRc> findJobRcListByJobId(String strJobId)
    {
        String query = "Select e from " + AcmeJobRc.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobRc> jobRcList = (List<AcmeJobRc>) dao.findByQuery(query);

        return jobRcList;
    }
    
    @Override
	public AcmeJobRc getJobRcById(UUID jobRcId) {
    	AcmeJobRc jobRc = dao.findById(AcmeJobRc.class, jobRcId);
        log.info("getJobRcById jobRc {} information successfully read.", jobRc);
        
        return jobRc;
    }
    
    @Override
    public List<AcmeJobSpice> findJobSpiceListByJobId(String strJobId)
    {
        String query = "Select e from " + AcmeJobSpice.class.getSimpleName() + " e where e.jobId = " + strJobId;
        List<AcmeJobSpice> jobSpiceList = (List<AcmeJobSpice>) dao.findByQuery(query);

        return jobSpiceList;
    }
    
    @Override
	public AcmeJobSpice getJobSpiceById(UUID jobSpiceId) {
    	AcmeJobSpice jobSpice = dao.findById(AcmeJobSpice.class, jobSpiceId);
        log.info("getJobSpiceById jobSpice {} information successfully read.", jobSpice);
        
        return jobSpice;
    }
}
