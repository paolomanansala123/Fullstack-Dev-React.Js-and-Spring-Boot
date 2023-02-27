package com.accenture.bars.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.bars.domain.Record;
import com.accenture.bars.domain.Request;
import com.accenture.bars.exception.BarsException;

@RestController
public class BarsController {
	
	protected static final Logger log = LoggerFactory
			.getLogger(BarsController.class);
	
	@Autowired
	FileProcessor fileProcessor;
	
	public BarsController() {
		//Empty
	}
	
	@GetMapping("/bars")
	public List<Record> requestBilling(@RequestParam("filePath") String fileName) 
			throws BarsException, IOException {
      
        File file = new File("C:/BARS_TEST/" + fileName);
        List<Request> requests = fileProcessor.execute(file);
        List<Record> records = fileProcessor.retrieveRecordFromDB(requests);
        return records;
    }
    
}

