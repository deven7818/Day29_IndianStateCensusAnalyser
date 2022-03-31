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

	@Before
	public void initialization() {
		analyser = new StateCensusAnalysis();
	}

	@Test
	public void testRecordMatch() throws IncorrectFileException {
		analyser.loadData("src/main/resources/IndianStateCensus.csv");
		assertEquals(true, analyser.checkData());
	}

	@Test
	public void testFileCheckSad() throws IncorrectFileException {
		analyser.loadData("src/main/resources/IndianStateCensus.csv");
	}
	
	@Test
	public void testTypeCheckSad() throws IncorrectFileException {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrong.csv");
	}
}
