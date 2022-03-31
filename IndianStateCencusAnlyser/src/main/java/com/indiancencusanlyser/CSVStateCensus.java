package com.indiancencusanlyser;

public class CSVStateCensus {
	String state;
	long population;
	int areaInSqKm;
	double densityPerSqKm;
	
	/**
	 *  Parameterized constructor
	 */
	public CSVStateCensus(String state, long population, int areaInSqKm, double densityPerSqKm) {
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	
	@Override
	public String toString() {
		return "CSVStateCensus [state=" + state + ", population=" + population + ", areaInSqKm=" + areaInSqKm
				+ ", densityPerSqKm=" + densityPerSqKm + "]";
	}

}
