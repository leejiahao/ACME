package com.moriah.acme.beans;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.moriah.acme.AcmeConfig;

public class JobCommand {
	
	private String program;
	private String path;
	private String info;
	private String place;
	private String coordinate;
	private String srcGds;
	private String netlist;
	private String testbench;
	private String controlCircuit;
	private String controlCircuitTop;
	private String controlCircuitType;
	private String controlCircuitNetlist;
	private String drcDeck;
	private String lvsDeck;
	private String rcDeck;
	private String spiceModel;

	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		StringBuffer jobCommandContent = new StringBuffer();
		
		// program
		jobCommandContent.append("APV_PROGRAM=");
		jobCommandContent.append(AcmeConfig.ACME_JOB_PROGRAM);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// path
		jobCommandContent.append("APV_JOB_PATH=");
		jobCommandContent.append(path);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// info
		jobCommandContent.append("APV_JOB_INFO=");
		jobCommandContent.append(info);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// place
		jobCommandContent.append("APV_JOB_PLACE=");
		jobCommandContent.append(place);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// coordinate
		jobCommandContent.append("APV_JOB_COORDINATE=");
		jobCommandContent.append(coordinate);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// SRC GDS
		jobCommandContent.append("APV_JOB_SRC_GDS=");
		jobCommandContent.append(srcGds);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// NETLIST
		jobCommandContent.append("APV_JOB_NETLIST=");
		jobCommandContent.append(netlist);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// TESTBENCH
		jobCommandContent.append("APV_JOB_TESTBENCH=");
		jobCommandContent.append(testbench);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// CONTROL_CIRCUIT
		jobCommandContent.append("APV_JOB_CONTROL_CIRCUIT=");
		jobCommandContent.append(controlCircuit);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// CONTROL_CIRCUIT_TOP
		jobCommandContent.append("APV_JOB_CONTROL_CIRCUIT_TOP=");
		jobCommandContent.append(controlCircuitTop);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// CONTROL_CIRCUIT_TYPE
		jobCommandContent.append("APV_JOB_CONTROL_CIRCUIT_TYPE=");
		jobCommandContent.append(controlCircuitType);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// CONTROL_CIRCUIT_NETLIST
		jobCommandContent.append("APV_JOB_CONTROL_CIRCUIT_NETLIST=");
		jobCommandContent.append(controlCircuitNetlist);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// DRC_DECK
		jobCommandContent.append("APV_JOB_DRC_DECK=");
		jobCommandContent.append(drcDeck);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// LVS_DECK
		jobCommandContent.append("APV_JOB_LVS_DECK=");
		jobCommandContent.append(lvsDeck);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// RC_DECK
		jobCommandContent.append("APV_JOB_RC_DECK=");
		jobCommandContent.append(rcDeck);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		// SPICE_MODEL
		jobCommandContent.append("APV_JOB_SPICE_MODEL=");
		jobCommandContent.append(spiceModel);
		jobCommandContent.append(AcmeConfig.LINE_SEPARATOR);
		
		return jobCommandContent.toString();
	}
	
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getSrcGds() {
		return srcGds;
	}

	public void setSrcGds(String srcGds) {
		this.srcGds = srcGds;
	}

	public String getControlCircuit() {
		return controlCircuit;
	}

	public void setControlCircuit(String controlCircuit) {
		this.controlCircuit = controlCircuit;
	}

	public String getControlCircuitTop() {
		return controlCircuitTop;
	}

	public void setControlCircuitTop(String controlCircuitTop) {
		this.controlCircuitTop = controlCircuitTop;
	}

	public String getControlCircuitType() {
		return controlCircuitType;
	}

	public void setControlCircuitType(String controlCircuitType) {
		this.controlCircuitType = controlCircuitType;
	}

	public String getDrcDeck() {
		return drcDeck;
	}

	public void setDrcDeck(String drcDeck) {
		this.drcDeck = drcDeck;
	}

	public String getLvsDeck() {
		return lvsDeck;
	}

	public void setLvsDeck(String lvsDeck) {
		this.lvsDeck = lvsDeck;
	}

	public String getRcDeck() {
		return rcDeck;
	}

	public void setRcDeck(String rcDeck) {
		this.rcDeck = rcDeck;
	}

	public String getSpiceModel() {
		return spiceModel;
	}

	public void setSpiceModel(String spiceModel) {
		this.spiceModel = spiceModel;
	}

	public String getNetlist() {
		return netlist;
	}

	public void setNetlist(String netlist) {
		this.netlist = netlist;
	}

	public String getTestbench() {
		return testbench;
	}

	public void setTestbench(String testbench) {
		this.testbench = testbench;
	}

	public String getControlCircuitNetlist() {
		return controlCircuitNetlist;
	}

	public void setControlCircuitNetlist(String controlCircuitNetlist) {
		this.controlCircuitNetlist = controlCircuitNetlist;
	}
}
