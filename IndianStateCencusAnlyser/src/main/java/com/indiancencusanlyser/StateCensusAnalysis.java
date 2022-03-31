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
	 * 5. Throw Custom exception
	 * 6. Invalid Type of records
	 */
	public void loadData(String filePath) throws IncorrectFileException,InvalidDelimiter {
		try {
			/**
			 * parsing a CSV file into CSVReader class constructor
			 */
			CSVReader reader = new CSVReader(new FileReader("src/main/resources/IndianStateCensus.csv"));
			String record[];
			record = reader.readNext();

			while ((record = reader.readNext()) != null) {
				if(record.length != 4)
					throw new InvalidDelimiter();
				censusData.add(new CSVStateCensus(record[0], Long.parseLong(record[1]), Integer.parseInt(record[2]),
						Double.parseDouble(record[3])));
			}

		} catch (FileNotFoundException ex) {
			throw new IncorrectFileException("This is an invalid file");
		} catch (CsvValidationException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}catch(NumberFormatException ex) {
			throw new IncorrectFileException("This is invalid type of record ");
		}

	}

	/**
	 * Checking the size of the list to check if we have all the entries.
	 * 
	 * @return - true if sized is 30
	 */
	public boolean checkData() {
		if (censusData.size() == 30)
			return true;
		return false;
	}
}
