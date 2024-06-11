package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String LOGIN_TESTDATA_FILE_PATH = 
			System.getProperty("user.dir")+"/src/test/java/testdata/loginTestData.properties";
	public static final String SCREENSHOTS_FOLDER_PATH = 
			System.getProperty("user.dir")+"/src/test/java/Screenshots/"+CommonUtils.getTimeStamp()+".PNG";
	public static final String FILE_PATH = 
			System.getProperty("user.dir")+"/src/test/java/testdata/SampleDoc.xlsx";
	public static final String IMAGE_PATH = 
			System.getProperty("user.dir")+"/src/test/java/testdata/pic.png";
	public static final String REPORT_PATH = 
			System.getProperty("user.dir")+"/src/test/java/reports/"+CommonUtils.getTimeStamp()+".html";
	public static final String USERMENU_TESTDATA_FILE_PATH = 
			System.getProperty("user.dir")+"/src/test/java/testdata/usermenuTestData.properties";
	public static final String ACCOUNT_TESTDATA_FILE_PATH = 
			System.getProperty("user.dir")+"/src/test/java/testdata/AccountTestData.properties";
	public static final String OPPORTUNITIES_TESTDATA = 
			System.getProperty("user.dir")+"/src/test/java/testdata/OpportunitiesTestData.Properties";

}
