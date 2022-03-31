package com.indiancencusanlyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 * Class to read the CSV file
 * 
 * @author Asus
 *
 */
public class StateCensusAnalysis {

	ArrayList<CSVStateCensus> censusData = new ArrayList<CSVStateCensus>();

	/**
	 * Method to load data and display as CSV 
	 * 1. The CSVReader class is used to read file. 
	 * 2. Using a while loop to read the file line by line. 
	 * 3. Adding the data to the list.
	 * 4. Display the list.
	 */
	public void loadData(String filePath) throws IncorrectFileException {
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

		} catch (FileNotFoundException ex) {
			throw new IncorrectFileException("This is an invalid file");
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
