package testDrivers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import projlib.Globals;
import utility.ExcelUtils;
import utility.LoggerUtils;


public class TestDriver 
{
	ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void beforeSuite(){
		
		htmlReporter = new ExtentHtmlReporter(Globals.EXTENT_REPORT);
		//htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// make the charts visible on report open 
		htmlReporter.config().setChartVisibilityOnOpen(true);

		// report title
		htmlReporter.config().setDocumentTitle("GI Web App Regreesion");

		// encoding, default = UTF-8
		htmlReporter.config().setEncoding("UTF-8");

		// protocol (http, https)
		//htmlReporter.config().setProtocol(Protocol.HTTPS);

		// report or build name
		htmlReporter.config().setReportName("Regression Test for Build-001");

		// chart location - top, bottom
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

		// theme - standard, dark
		htmlReporter.config().setTheme(Theme.DARK);

		// set timeStamp format
		//htmlReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss a");

		// add custom css
		//htmlReporter.config().setCSS("css-string");

		// add custom javascript
		//htmlReporter.config().setJS("js-string");
		
	}
	
	@Parameters({"test-id", "test-config", "test-config-sheet"})
	@Test
    public void tDriver(String testId, String testConfig, String testConfigSheet) throws InvocationTargetException
    {
    	//String testRunStatus = "F";
    	int colCount = 0;
    	int rowNum = 0;
        String sheetName = "";
        String datFile = "";
    	LoggerUtils.loggerSetup();
        String strData = "";
        HashMap<String, String> hMapConfig = new HashMap<String, String>();
        HashMap<String, String> hMapRetObj = new HashMap<String, String>();
        hMapRetObj.put("testRunStatus", Globals.FAIL);
        hMapRetObj.put("depUpdateVal", "");
        String depVal = "";
        String depData = "";
        try {
        	
        	LoggerUtils.logInfo("******************************************");
        	LoggerUtils.logInfo("Test Case ID: " + testId);
        	LoggerUtils.logInfo("******************************************");

        	// Reading the config file
        	colCount = 21;
        	hMapConfig = ExcelUtils.readToHashMap(Globals.CONFIG_FILE_DIR + testConfig + ".xlsx" , testConfigSheet, testId, colCount);
        	
        	test = extent.createTest(testId + ": " + hMapConfig.get("TestDesc"));
        	
        	// to check for dependency & fetch the required dependency valu
        	if (hMapConfig.get("DepChkFile").trim().length() > 0) {
        		// Reading the dependency file
        		String depFile = Globals.DEP_FILE_DIR + hMapConfig.get("DepChkFile").trim() + ".xlsx";
            	strData = ExcelUtils.readExcelRowWithKeyVal(depFile
            			, hMapConfig.get("DepChkSheet").trim(), hMapConfig.get("TestId").trim()
            			, Integer.parseInt(hMapConfig.get("DepChkColCount")));
            	String [] arrDep = strData.split("\\|");
            	//depVal = arrDep[2];
            	
            	// Reading the dependency result file
            	String depResFile = Globals.RESULT_FILE_DIR + arrDep[2] + ".xlsx";
            	depData = ExcelUtils.readExcelRowWithKeyVal(depResFile
            			, arrDep[3], arrDep[1]
            			, Integer.parseInt(arrDep[4]));
            	String [] arrDepRes = depData.split("\\|");
            	
            	depVal = arrDepRes[Integer.parseInt(arrDep[5])];
            	if (arrDepRes[1].equals("P")) {
            		
            	} else {
                	test.fail("Dependency Test Not Run/Passed - " + arrDepRes[0]);
                	LoggerUtils.logInfo("Dependency Test Not Run/Passed - " + arrDepRes[0]);            	
            		Assert.assertEquals(hMapRetObj.get("testRunStatus"), Globals.PASS);
            	}
        	}
        	
        	colCount = Integer.parseInt(hMapConfig.get("TestColCount"));
        	datFile = Globals.DATA_FILE_DIR + hMapConfig.get("TestDataFile") + ".xlsx";
        	sheetName = hMapConfig.get("TestSheet");
        	strData = ExcelUtils.readExcelRowWithKeyVal(datFile, 
        			sheetName, testId, colCount);
        	String [] arrData = strData.split("\\|");
        	rowNum = Integer.parseInt(arrData[arrData.length - 1]);
        	
			// invoking the test class
            Class cls = Class.forName(arrData[1]);
            Object obj = cls.newInstance();
            
			Object [] methodParams = new Object [] {new String(strData), test, new String(depVal)};
            Class [] params = new Class [3];
            params[0] = String.class;
            params[1] = ExtentTest.class;
            params[2] = String.class;
            
            
            Method method = cls.getDeclaredMethod(arrData[2], params);
        	StopWatch stopWatch = new StopWatch();
        	stopWatch.start();

            hMapRetObj = (HashMap<String, String>) method.invoke(obj, methodParams);
        	stopWatch.stop();
        	String strTime = String.valueOf(stopWatch.getTime());


        	
            if (hMapRetObj.get("testRunStatus").equals(Globals.PASS))
            {
            	if (hMapConfig.get("DepUpdFile").trim().length() > 0) {
        			ExcelUtils.setCellDataWithKeyVal(Globals.RESULT_FILE_DIR + hMapConfig.get("DepUpdFile") + ".xlsx"
        					, hMapConfig.get("DepUpdSheet"), hMapConfig.get("TestId")
        					, Integer.parseInt(hMapConfig.get("DepUpdColCount"))
        					, Integer.parseInt(hMapConfig.get("DepUpdKeyCol"))
        					, Integer.parseInt(hMapConfig.get("DepUpdUpdateCol"))
        					, hMapRetObj.get("depUpdateVal"));
            	}
            	System.out.println("Test Completed Successfully - " + testId);
            	test.pass("Test Completed Successfully - " + testId);
            	LoggerUtils.logInfo("Test Completed Successfully - " + testId);            	
            }
            else
            {
            	System.out.println("Test Failed - " + testId);
            	test.fail("Test Failed - " + testId);
            	LoggerUtils.logInfo("Test Failed - " + testId);            	
            }

        } catch (Exception e) {
        	e.printStackTrace();
        	hMapRetObj.put("testRunStatus", Globals.EXCEPTION);
        	LoggerUtils.logError("Error in TestDriver - " + testId, e);
        }
        //public static String setCellDataWithKeyVal(String file, String sheetName, String key, int colCount, 
    		//	int keyValCol, int setCol, String setVal) {
		try {
			ExcelUtils.setCellDataWithKeyVal(Globals.RESULT_FILE_DIR + hMapConfig.get("ResFile") + ".xlsx"
					, hMapConfig.get("ResSheet"), hMapConfig.get("TestId"), Integer.parseInt(hMapConfig.get("ResColCount"))
					, Integer.parseInt(hMapConfig.get("ResKeyCol")), Integer.parseInt(hMapConfig.get("ResUpdateCol"))
					, hMapRetObj.get("testRunStatus"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		Assert.assertEquals(hMapRetObj.get("testRunStatus"), Globals.PASS);
        //System.exit(testRunStatus);

	}

	@AfterSuite
	public void endReport(){
		extent.flush();
    }
	
}