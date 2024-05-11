package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileHandlingMethods {
	public static String readLoginTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	
	
	
}
