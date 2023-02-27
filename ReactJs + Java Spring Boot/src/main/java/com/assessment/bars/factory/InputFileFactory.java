package com.accenture.bars.factory;

import java.io.File;
import java.util.Locale;

import com.accenture.bars.exception.BarsException;
import com.accenture.bars.file.AbstractInputFile;
import com.accenture.bars.file.CSVInputFileImpl;
import com.accenture.bars.file.TextInputFileImpl;

public class InputFileFactory {

    private static InputFileFactory factory;

    private InputFileFactory() {
     }

    public static InputFileFactory getInstance() {
        if (factory == null) {
            factory = new InputFileFactory();
         }
        return factory;
     }

    public AbstractInputFile getInputFile(File file) 
            throws BarsException {	
        	
        if (file.getName().toLowerCase(Locale.ENGLISH)
        		.endsWith(".txt")) {
            return new TextInputFileImpl();
                
        } else if (file.getName().toLowerCase(Locale.ENGLISH)
        		       .endsWith(".csv")) {
            return new CSVInputFileImpl();
                
        } else {
            throw new BarsException(BarsException.FILE_NOT_SUPPORTED);
        }
    }
}