package projlib;

import java.util.Properties;

import gtlib.Genlib;

public class Globals 
{
	
	static Properties prop = Genlib.readConfig("config.properties");
	
	public static final String LOGIN_URL = prop.getProperty("loginUrl");
	public static final String TESTS_ROOT = prop.getProperty("testsRoot");
	public static final String CONFIG_FILE_DIR = prop.getProperty("configFileDir");
	public static final String RESULT_FILE_DIR = prop.getProperty("resultFileDir");
	public static final String DEP_FILE_DIR = prop.getProperty("depFileDir");
	public static final String DATA_FILE_DIR = prop.getProperty("dataFileDir");
	public static final String CHROME_DRIVER_PATH = prop.getProperty("chromeDriver");
	public static final String CHROME_DATA_DIR = prop.getProperty("chromeDataDir");
	public static final String IE_DRIVER_PATH = prop.getProperty("ieDriver");
	public static final String FIREFOX_DRIVER_PATH = prop.getProperty("firefoxDriver");
	public static final String SUITE_NAME = prop.getProperty("suiteName");
	public static final String TESTNG_FILE_NAME = prop.getProperty("testNGFileName");
	public static final String BROWSER = prop.getProperty("browser");
	public static final String SCREENSHOT_DIR = prop.getProperty("screenshot");
	public static final String LOG4J_FILE = prop.getProperty("log4j");
	public static final String FAIL = "F";
	public static final String PASS = "P";
	public static final String EXCEPTION = "E";
	//public static final String PROG_FILEUPLOAD = "C:\\Software Setup\\AutoIT\\File Upload.exe"; 
	public static final String PROG_FILEUPLOAD = prop.getProperty("fileUpload");
	public static final String EXTENT_REPORT = prop.getProperty("extentReport");
	

	static Properties logMsgProp = Genlib.readConfig("LogMessages.properties");
	
}
