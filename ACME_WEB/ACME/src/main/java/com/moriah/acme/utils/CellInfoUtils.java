package com.moriah.acme.utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.moriah.acme.entities.AcmeJobTestline;

public class CellInfoUtils {
	public static final String TEST_LINE_NAME_HEADER = "TL_name";
	public static final String CELL_NAME_HEADER = "cell_name";
	public static final String PLACE_NAME_HEADER = "place";
	
	public static List<AcmeJobTestline> getAcmeJobTestlineListFromCellInfo(String cellInfoFileName) throws CellInfoException {
		List<AcmeJobTestline> testlineList = new ArrayList<AcmeJobTestline>();

		try {
			HashMap<String, String> testlineNameMap = new HashMap<String, String>();
			
			Reader in = new FileReader(cellInfoFileName);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withDelimiter('\t').withHeader(TEST_LINE_NAME_HEADER, CELL_NAME_HEADER, PLACE_NAME_HEADER).withSkipHeaderRecord(true).parse(in);
			for (CSVRecord record : records) {
			    String testlineName = record.get(TEST_LINE_NAME_HEADER);
			    
			    testlineNameMap.put(testlineName, testlineName);
			}
			
			for(String testlineName:testlineNameMap.keySet()) {
				AcmeJobTestline testline = new AcmeJobTestline();
				testline.setTestlineName(testlineName);
				
				testlineList.add(testline);
			}

		} catch (Exception e) {
			throw new CellInfoException("Parse testlines failed.", e);
		}
		
		return testlineList;
	}
}
