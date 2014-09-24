package com.moriah.acme.service;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moriah.acme.dao.AcmeDao;
import com.moriah.acme.entities.AcmeJob;
import com.moriah.acme.entities.AcmeTv;
import com.moriah.acme.entities.AcmeControlCircuit;
import com.moriah.acme.entities.AcmeDrcDeck;
import com.moriah.acme.entities.AcmeLvsDeck;
import com.moriah.acme.entities.AcmeRcDeck;
import com.moriah.acme.entities.AcmeSpiceModel;

public class ProjectServiceImpl implements ProjectService {
    /**
     * logger used for logging statement.
     */
    private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private AcmeDao dao;

    public ProjectServiceImpl()
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
    
    @Override
    public void createTv(AcmeTv tv)
    {
        dao.insert(tv);
        log.info("AcmeTv tv {} information successfully created.", tv);
    }
    
    @Override
    public AcmeTv readTv(UUID tvId)
    {
    	AcmeTv tv = dao.findById(AcmeTv.class, tvId);
        log.info("AcmeTv tv {} information successfully read.", tv);
        
        return tv;
    }
    
    @Override
    public void updateTv(AcmeTv tv)
    {
        dao.merge(tv);
        log.info("AcmeTv tv {} information successfully updated.", tv);
    }
    
    @Override
    public void deleteTv(AcmeTv tv)
    {
        dao.remove(tv);
        log.info("AcmeTv tv {} information successfully deleted.", tv);
    }
    
    @Override
    public List<AcmeTv> findTvListByOwner(String owner)
    {
        String query = "Select e from " + AcmeTv.class.getSimpleName() + " e where e.createUser = " + owner;

        List<AcmeTv> tvList = (List<AcmeTv>) dao.findByQuery(query);
        
        if (null == tvList) {
        	tvList = new ArrayList<AcmeTv>();
        }

        return tvList;
    }
    
    @Override
    public List<AcmeControlCircuit> findControlCircuitListByTv(String uuid)
    {
        String query = "Select e from " + AcmeControlCircuit.class.getSimpleName() + " e where e.tvId = " + uuid;

        List<AcmeControlCircuit> controlCircuitList = (List<AcmeControlCircuit>) dao.findByQuery(query);
        
        if (null == controlCircuitList) {
        	controlCircuitList = new ArrayList<AcmeControlCircuit>();
        }

        return controlCircuitList;
    }
    
    @Override
    public void createControlCircuit(AcmeControlCircuit controlCircuit)
    {
        dao.insert(controlCircuit);
        log.info("AcmeControlCircuit controlCircuit {} information successfully created.", controlCircuit);
    }
    
    @Override
    public List<AcmeDrcDeck> findDrcDeckListByTv(String uuid)
    {
        String query = "Select e from " + AcmeDrcDeck.class.getSimpleName() + " e where e.tvId = " + uuid;

        List<AcmeDrcDeck> drcDeckList = (List<AcmeDrcDeck>) dao.findByQuery(query);
        
        if (null == drcDeckList) {
        	drcDeckList = new ArrayList<AcmeDrcDeck>();
        }

        return drcDeckList;
    }
    
    @Override
    public void createDrcDeck(AcmeDrcDeck deck)
    {
        dao.insert(deck);
        log.info("AcmeDrcDeck deck {} information successfully created.", deck);
    }
    
    @Override
    public AcmeDrcDeck readDrcDeck(UUID deckId)
    {
    	AcmeDrcDeck deck = dao.findById(AcmeDrcDeck.class, deckId);
        log.info("AcmeDrcDeck deck {} information successfully read.", deck);
        
        return deck;
    }
    
    @Override
    public void updateDrcDeck(AcmeDrcDeck deck)
    {
        dao.merge(deck);
        log.info("AcmeDrcDeck deck {} information successfully updated.", deck);
    }
    
    @Override
    public void deleteDrcDeck(AcmeDrcDeck deck)
    {
        dao.remove(deck);
        log.info("AcmeDrcDeck deck {} information successfully deleted.", deck);
    }
    
    @Override
    public List<AcmeLvsDeck> findLvsDeckListByTv(String uuid)
    {
        String query = "Select e from " + AcmeLvsDeck.class.getSimpleName() + " e where e.tvId = " + uuid;

        List<AcmeLvsDeck> lvsDeckList = (List<AcmeLvsDeck>) dao.findByQuery(query);
        
        if (null == lvsDeckList) {
        	lvsDeckList = new ArrayList<AcmeLvsDeck>();
        }

        return lvsDeckList;
    }
    
    @Override
    public void createLvsDeck(AcmeLvsDeck deck)
    {
        dao.insert(deck);
        log.info("AcmeLvsDeck deck {} information successfully created.", deck);
    }
    
    @Override
    public AcmeLvsDeck readLvsDeck(UUID deckId)
    {
    	AcmeLvsDeck deck = dao.findById(AcmeLvsDeck.class, deckId);
        log.info("AcmeLvsDeck deck {} information successfully read.", deck);
        
        return deck;
    }
    
    @Override
    public void updateLvsDeck(AcmeLvsDeck deck)
    {
        dao.merge(deck);
        log.info("AcmeLvsDeck deck {} information successfully updated.", deck);
    }
    
    @Override
    public void deleteLvsDeck(AcmeLvsDeck deck)
    {
        dao.remove(deck);
        log.info("AcmeLvsDeck deck {} information successfully deleted.", deck);
    }
    
    @Override
    public List<AcmeRcDeck> findRcDeckListByTv(String uuid)
    {
        String query = "Select e from " + AcmeRcDeck.class.getSimpleName() + " e where e.tvId = " + uuid;

        List<AcmeRcDeck> rcDeckList = (List<AcmeRcDeck>) dao.findByQuery(query);
        
        if (null == rcDeckList) {
        	rcDeckList = new ArrayList<AcmeRcDeck>();
        }

        return rcDeckList;
    }
    
    @Override
    public void createRcDeck(AcmeRcDeck deck)
    {
        dao.insert(deck);
        log.info("AcmeRcDeck deck {} information successfully created.", deck);
    }
    
    @Override
    public AcmeRcDeck readRcDeck(UUID deckId)
    {
    	AcmeRcDeck deck = dao.findById(AcmeRcDeck.class, deckId);
        log.info("AcmeRcDeck deck {} information successfully read.", deck);
        
        return deck;
    }
    
    @Override
    public void updateRcDeck(AcmeRcDeck deck)
    {
        dao.merge(deck);
        log.info("AcmeRcDeck deck {} information successfully updated.", deck);
    }
    
    @Override
    public void deleteRcDeck(AcmeRcDeck deck)
    {
        dao.remove(deck);
        log.info("AcmeRcDeck deck {} information successfully deleted.", deck);
    }
    
    @Override
    public List<AcmeSpiceModel> findSpiceModelListByTv(String uuid)
    {
        String query = "Select e from " + AcmeSpiceModel.class.getSimpleName() + " e where e.tvId = " + uuid;

        List<AcmeSpiceModel> spiceModelList = (List<AcmeSpiceModel>) dao.findByQuery(query);
        
        if (null == spiceModelList) {
        	spiceModelList = new ArrayList<AcmeSpiceModel>();
        }

        return spiceModelList;
    }
    
    @Override
    public void createSpiceModel(AcmeSpiceModel model)
    {
        dao.insert(model);
        log.info("AcmeRcDeck model {} information successfully created.", model);
    }
    
    @Override
    public AcmeSpiceModel readSpiceModel(UUID modelId)
    {
    	AcmeSpiceModel model = dao.findById(AcmeSpiceModel.class, modelId);
        log.info("AcmeSpiceModel model {} information successfully read.", model);
        
        return model;
    }
    
    @Override
    public void updateSpiceModel(AcmeSpiceModel model)
    {
        dao.merge(model);
        log.info("AcmeSpiceModel model {} information successfully updated.", model);
    }
    
    @Override
    public void deleteSpiceModel(AcmeSpiceModel model)
    {
        dao.remove(model);
        log.info("AcmeSpiceModel model {} information successfully deleted.", model);
    }
}
