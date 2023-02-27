package com.accenture.bars.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.bars.domain.Request;
import com.accenture.bars.exception.BarsException;

public class CSVInputFileImpl extends AbstractInputFile {
	
	public CSVInputFileImpl(File file) {
	}

	public CSVInputFileImpl() {
	}

	private static final Logger log 
						= LoggerFactory
						.getLogger(CSVInputFileImpl.class);


    public List <Request> readFile(File file) 
    		throws IOException, BarsException {
    	
        List<Request> requests = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String itemFile;
        try (
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			LocalDate startDate;
			LocalDate endDate;
			
			int billingCycle;
			int currentRow = 1;

			while ((itemFile = bufferedReader.readLine()) != null) {
			    String [] data = itemFile.split(",");

			    billingCycle = Integer.parseInt(data[0]);
			    if(billingCycle < MIN_BILLING_CYCLE 
			    				|| billingCycle 
			    				> MAX_BILLING_CYCLE) {
			    	
			        log.error(BarsException
			        		.BILLING_CYCLE_NOT_ON_RANGE 
			        		+ currentRow);
			    	throw new BarsException(BarsException
			    			.BILLING_CYCLE_NOT_ON_RANGE 
			    			+ currentRow);
			    }
			    try {
			        startDate = LocalDate.parse(data[1], formatter);
			    }catch (DateTimeParseException e){
			        log.error(BarsException.INVALID_START_DATE_FORMAT 
			        						+ currentRow);
			        throw new BarsException(BarsException
			        						.INVALID_START_DATE_FORMAT 
			        						+ currentRow);
			        	
			    } try {
			    	final int TWO = 2;
			        endDate = LocalDate.parse(data[TWO], formatter);
			    }catch (DateTimeParseException e){
			        log.error(BarsException.INVALID_END_DATE_FORMAT 
			        						+ currentRow);
			    	throw new BarsException(BarsException
			    							.INVALID_END_DATE_FORMAT 
			    							+ currentRow);
			    }
			    currentRow++;
			    requests.add(new Request
			    			(billingCycle
			    			, startDate
			    			, endDate));
			    }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

        return requests;
        }	
}
