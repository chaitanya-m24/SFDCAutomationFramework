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
			System.getProperty("user.dir")+"/src/test/java/reports/Sample.PNG";
	public static final String REPORT_PATH = 
			System.getProperty("user.dir")+"/src/test/java/reports/"+CommonUtils.getTimeStamp()+".html";
}
