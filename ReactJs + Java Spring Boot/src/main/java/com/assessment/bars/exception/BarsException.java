package com.accenture.bars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BarsException extends RuntimeException {
	
	public static final String 
						INVALID_START_DATE_FORMAT 
						= "ERROR: Invalid Start Date format at row ";
	public static final String 
						INVALID_END_DATE_FORMAT 
						= "ERROR: Invalid End Date format at row ";
	public static final String 
						INVALID_BILLING_CYCLE 
						= "ERROR: Invalid Billing Cycle value at row ";
	public static final String 
						BILLING_CYCLE_NOT_ON_RANGE 
						= "ERROR: Billing Cycle not or range at row ";
	public static final String 
						PATH_DOES_NOT_EXIST 
						= "Please input an existing request file path.";
	public static final String 
						NO_SUPPORTED_FILE 
						= "No supported request file found in the file path.";
	public static final String 
						FILE_NOT_SUPPORTED 
						= "File is not supported for processing.";
	public static final String 
						NO_REQUESTS_TO_READ 
						= "No request(s) to read from the input file.";
	public static final String 
						NO_RECORDS_TO_WRITE 
						= "No record(s) to write to the output file.";
	
	
	public BarsException(String message, Throwable cause) {
		super(message, cause);
	}
	public BarsException(String message) {
		super(message);
	}
	
	public BarsException() {
		
	}
	
}
