package com.accenture.bars.controller;

import com.accenture.bars.domain.Record;
import com.accenture.bars.domain.Request;
import com.accenture.bars.entity.Billing;
import com.accenture.bars.exception.BarsException;
import com.accenture.bars.factory.InputFileFactory;
import com.accenture.bars.file.AbstractInputFile;
import com.accenture.bars.repository.BillingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileProcessor {

	private BillingRepository billingRepository;
	
	@Autowired
	public FileProcessor(BillingRepository theBillingRepository) {
		this.billingRepository = theBillingRepository;
		}

	public List<Request> execute(File file) throws BarsException, IOException {
		InputFileFactory inputFileFactory = InputFileFactory.getInstance();
		AbstractInputFile abstractInputFile = inputFileFactory.getInputFile(file);
		abstractInputFile.setFile(file);
		List<Request> requests = abstractInputFile.readFile(file);
		return requests;
		}

	public List<Record> retrieveRecordFromDB(List<Request> requests) 
			throws BarsException{
		Logger log = LoggerFactory.getLogger(BarsController.class);
		List<Record> records = new ArrayList<>();

		for (Request request : requests) {
			Billing billing = billingRepository.findByBillingCycleAndStartDateAndEndDate(
							request.getBillingCycle(),
							request.getStartDate(),
							request.getEndDate());

			if (billing != null) {
				Record record = new Record();
				record.setBillingCycle
						(billing.getBillingCycle());
				record.setStartDate
						(billing.getStartDate());
				record.setEndDate
						(billing.getEndDate());
				record.setAccountName
						(billing.getAccountId()
								.getAccountName());
				record.setFirstName
						(billing.getAccountId()
								.getCustomerId()
								.getFirstName());	
				record.setLastName
						(billing.getAccountId()
								.getCustomerId()
								.getLastName());	
				record.setAmount
						(billing.getAmount());				
				records.add(record);
			

			} else {

				log.info(BarsException.NO_RECORDS_TO_WRITE);
				throw new BarsException(BarsException.NO_RECORDS_TO_WRITE);
			}
		}

		if (records.isEmpty()) {
			log.info(BarsException.NO_REQUESTS_TO_READ);
			throw new BarsException(BarsException.NO_REQUESTS_TO_READ);
		} else { 
			return records;
		}
		
	}
	
}


	