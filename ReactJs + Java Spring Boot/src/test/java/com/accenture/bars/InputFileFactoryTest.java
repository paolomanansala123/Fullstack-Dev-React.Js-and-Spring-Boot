package com.accenture.bars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.bars.exception.BarsException;
import com.accenture.bars.factory.InputFileFactory;
import com.accenture.bars.file.AbstractInputFile;
import com.accenture.bars.file.CSVInputFileImpl;
import com.accenture.bars.file.TextInputFileImpl;

public class InputFileFactoryTest {
	
	@Autowired
	InputFileFactory factory;
	
	@Test
	void testGetInstance() {
		assertNotNull(InputFileFactory.getInstance());
	}
	
	@Test
	void testGetInputFileTxt() throws BarsException {
		File file = new File("C:\\BARS_TEST\\valid-txt.txt");
		assertEquals(TextInputFileImpl.class, InputFileFactory.getInstance().
		getInputFile(file).getClass());
	}
	
	@Test
	void testGetInputFileCsv() throws BarsException {
		File file = new File("C:\\BARS_TEST\\valid-csv.csv");
		assertEquals(CSVInputFileImpl.class, InputFileFactory.getInstance().
		getInputFile(file).getClass());
	}
	
	@Test
	void testFileNotSupported() {
		try {
			File file = new File("C:\\BARS_TEST\\unsupported-file.png");
			
			InputFileFactory inputFileFactory = InputFileFactory.getInstance();
			AbstractInputFile absInputFile;
			
			absInputFile = inputFileFactory.getInputFile(file);
			
			absInputFile.setFile(file);
		} catch(BarsException e) {
			assertEquals("File is not supported for processing." ,e.getMessage());
		}
	}
		

}
