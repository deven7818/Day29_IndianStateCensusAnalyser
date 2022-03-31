package com.indiancencusanlyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 * Class to read the CSV file
 * @author Asus
 *
 */
public class StateCensusAnalysis {

	ArrayList<CSVStateCensus> censusData = new ArrayList<CSVStateCensus>();

	/**
	 * Method to load data and display as CSV
	 * 1. The CSVReader class is used to read a CSV file. The class provides CSVReader class constructor to parse a CSV file.
	 * 2. Using a while loop to read the file line by line.
	 * 3. Adding the data to the list.
	 * 4. Display the list.
	 */
	public void loadData() {
		try {
			/**
			 * parsing a CSV file into CSVReader class constructor
			 */
			CSVReader reader = new CSVReader(new FileReader("src/main/resources/IndianStateCensus.csv"));
			String record[];
			record = reader.readNext();

			while ((record = reader.readNext()) != null) {
				censusData.add(new CSVStateCensus(record[0], Long.parseLong(record[1]), Integer.parseInt(record[2]),
						Double.parseDouble(record[3])));
			}
			for (CSVStateCensus data : censusData) {
				System.out.println(data);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (CsvValidationException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Checking the size of the list to check if we have all the entries.
	 * 
	 * @return - true if sized is 29
	 */
	public boolean checkData() {
		if (censusData.size() == 29)
			return true;
		return false;
	}
}
