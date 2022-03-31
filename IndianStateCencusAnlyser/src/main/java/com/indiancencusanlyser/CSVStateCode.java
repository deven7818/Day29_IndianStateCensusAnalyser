package com.indiancencusanlyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVStateCode {
	ArrayList<CSVStateCodeData> codeData = new ArrayList<CSVStateCodeData>();
	String[] header;

	public void loadData(String file) throws Exception {

		String[] record;

		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			header = reader.readNext();

			while ((record = reader.readNext()) != null) {
				if (record.length != 4)
					throw new InvalidDelimiter(" Invalid delimiter ");

				codeData.add(new CSVStateCodeData(Integer.parseInt(record[0]), record[1], Integer.parseInt(record[2]),
						record[3]));
			}

		} catch (FileNotFoundException ex) {
			throw new IncorrectFileException(" We could not find the correct file");
		} catch (CsvValidationException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NumberFormatException ex) {
			throw new IncorrectFileException(" There was an invalid type in the csv file");
		}
	}

	public boolean checkHeader() throws IncorrectFileException {
		boolean headerCorrect = (header[0].compareTo("Sr.No") + header[1].compareTo("StateName")
				+ header[2].compareTo("TIN") + header[3].compareTo("StateCode") == 0);

		if (!headerCorrect)
			throw new IncorrectFileException(" This is an invalid header");

		return true;
	}

	public boolean checkData(int recordCount) {
		System.out.println("the no of records: " + codeData.size());
		if (codeData.size() == recordCount)
			return true;
		return false;
	}
}