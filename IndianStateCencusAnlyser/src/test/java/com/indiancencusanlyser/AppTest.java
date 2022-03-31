package com.indiancencusanlyser;

import org.junit.Test;


public class AppTest {
	
	@Test
	public void testCensusAnalyser() {
		StateCensusAnalysis analyser = new StateCensusAnalysis();
		analyser.loadData();
	}
}
