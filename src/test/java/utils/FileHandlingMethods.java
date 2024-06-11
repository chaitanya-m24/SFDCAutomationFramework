package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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
	public static String readUserMenuTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.USERMENU_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	public static String readAccountTestData(String key) throws IOException{
		File f = new File(FileConstants.ACCOUNT_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(key);
		
	}
	public static String readOpportunitiesTestData(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(FileConstants.OPPORTUNITIES_TESTDATA);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		}
	
}
 