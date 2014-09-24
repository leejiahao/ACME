package com.moriah.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.dao.AcmeDao;
import com.moriah.acme.entities.AcmeBasicGeom;

public class TechServiceImpl implements TechService {
    /**
     * logger used for logging statement.
     */
    private static final Logger log = LoggerFactory.getLogger(TechServiceImpl.class);
    
    private AcmeDao dao;
    
    public TechServiceImpl() {
    	
    }
    
    public AcmeDao getDao()
    {
        return dao;
    }

    public void setDao(AcmeDao dao)
    {
        this.dao = dao;
    }

	@Override
	public List<AcmeBasicGeom> getBasicGeomList() {
        String query = "Select e from " + AcmeBasicGeom.class.getSimpleName() + " e ";

        List<AcmeBasicGeom> basicGeomList = (List<AcmeBasicGeom>) dao.findByQuery(query);
        
        if (null == basicGeomList) {
        	basicGeomList = new ArrayList<AcmeBasicGeom>();
        }

        return basicGeomList;
	}

}
