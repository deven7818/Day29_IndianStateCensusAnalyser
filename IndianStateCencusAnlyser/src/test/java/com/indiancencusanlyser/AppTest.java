package com.indiancencusanlyser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Cases
 * 
 * @author Asus
 *
 */

public class AppTest {

	StateCensusAnalysis analyser;
	CSVStateCode codeAnalyser;

	@Before
	public void initialization() {
		analyser = new StateCensusAnalysis();
		codeAnalyser = new CSVStateCode();
	}

	@Test
	public void testRecordMatch() throws IncorrectFileException,InvalidDelimiter {
		analyser.loadData("src/main/resources/IndianStateCensus.csv");
		assertEquals(true, analyser.checkData());
	}

	@Test
	public void testFileCheckSad() throws IncorrectFileException, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndianStateCensus.csv");
	}
	
	@Test
	public void testTypeCheckSad() throws IncorrectFileException, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrong.csv");
	}
	
	@Test
	public void testDelimiterCheckSad() throws IncorrectFileException, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrong.csv");
	}
	

	@Test
	public void testHeaderCheckSad() throws IncorrectFileException, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrongHeader.csv");
	}
	
	@Test
	public void testCodeRecordMatch() throws Exception {
		codeAnalyser.loadData("src/main/resources/IndiaStateCode.csv");
		assertEquals(true, codeAnalyser.checkData(37));
	}
}
