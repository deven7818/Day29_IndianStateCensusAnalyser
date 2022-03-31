package com.indiancencusanlyser;

/**
 * Custom exception
 * 
 * @author Asus
 *
 */
@SuppressWarnings("serial")
public class IncorrectFileException extends Exception {

	public IncorrectFileException() {
		super();
	}

	public IncorrectFileException(String message) {
		super(message);
	}
}
