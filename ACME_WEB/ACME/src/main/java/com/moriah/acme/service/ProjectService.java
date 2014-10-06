package com.moriah.acme.service;

import java.util.List;
import java.util.UUID;

import com.moriah.acme.entities.AcmeTv;
import com.moriah.acme.entities.AcmeControlCircuit;
import com.moriah.acme.entities.AcmeDrcDeck;
import com.moriah.acme.entities.AcmeLvsDeck;
import com.moriah.acme.entities.AcmeRcDeck;
import com.moriah.acme.entities.AcmeSpiceModel;

public interface ProjectService {

	// create TV
	public void createTv(AcmeTv tv);
	
	// read TV
	public AcmeTv readTv(UUID tvId);

	// update TV
	public void updateTv(AcmeTv tv);

	// delete TV
	public void deleteTv(AcmeTv tv);
	
	// find TVs
	public List<AcmeTv> findTvListByOwner(String owner);
	
	// find control circuit list
	public List<AcmeControlCircuit> findControlCircuitListByTv(String tvId);
	
	// find control circuit by id
	public AcmeControlCircuit findControlCircuitById(String strCircuitId);
	
	// create control circuit
	public void createControlCircuit(AcmeControlCircuit controlCircuit);
	
	// find DRC deck list
	public List<AcmeDrcDeck> findDrcDeckListByTv(String tvId);
	
	// find DRC deck by id
	public AcmeDrcDeck findDrcDeckById(String strDeckId);
	
	// create DRC deck
	public void createDrcDeck(AcmeDrcDeck deck);
	
	// read DRC deck
	public AcmeDrcDeck readDrcDeck(UUID deckId);
	
	// update DRC deck
	public void updateDrcDeck(AcmeDrcDeck deck);
	
	// delete DRC deck
	public void deleteDrcDeck(AcmeDrcDeck deck);
	
	// find LVS deck list
	public List<AcmeLvsDeck> findLvsDeckListByTv(String tvId);
	
	// find LVS deck by id
	public AcmeLvsDeck findLvsDeckById(String strDeckId);
	
	// create LVS deck
	public void createLvsDeck(AcmeLvsDeck deck);
	
	// read LVS deck
	public AcmeLvsDeck readLvsDeck(UUID deckId);
	
	// update LVS deck
	public void updateLvsDeck(AcmeLvsDeck deck);
	
	// delete LVS deck
	public void deleteLvsDeck(AcmeLvsDeck deck);
	
	// find RC deck list
	public List<AcmeRcDeck> findRcDeckListByTv(String tvId);
	
	// find RC deck by id
	public AcmeRcDeck findRcDeckById(String strDeckId);
	
	// create RC deck
	public void createRcDeck(AcmeRcDeck deck);
	
	// read RC deck
	public AcmeRcDeck readRcDeck(UUID deckId);
	
	// update RC deck
	public void updateRcDeck(AcmeRcDeck deck);
	
	// delete RC deck
	public void deleteRcDeck(AcmeRcDeck deck);
	
	// find SPICE model list
	public List<AcmeSpiceModel> findSpiceModelListByTv(String tvId);
	
	// find SPICE model by id
	public AcmeSpiceModel findSpiceModelById(String strModelId);
	
	// create SPICE model
	public void createSpiceModel(AcmeSpiceModel model);
	
	// read SPICE model
	public AcmeSpiceModel readSpiceModel(UUID modelId);
	
	// update SPICE model
	public void updateSpiceModel(AcmeSpiceModel model);
	
	// delete SPICE model
	public void deleteSpiceModel(AcmeSpiceModel model);
}
