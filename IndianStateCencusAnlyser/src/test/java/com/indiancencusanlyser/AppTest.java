package com.indiancencusanlyser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Cases
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
	public void testRecordMatch() {
		analyser.loadData();
		assertEquals(true, analyser.checkData());
	}
}
