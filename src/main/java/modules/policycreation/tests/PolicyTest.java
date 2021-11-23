package modules.policycreation.tests;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import modules.login.pageobject.*;
import modules.login.tests.LoginTest;
import modules.policycreation.pageobject.PolicyPage;
import projlib.Globals;
import utility.LoggerUtils;

import com.aventstack.extentreports.ExtentTest;

import gtlib.Genlib;


public class PolicyTest {

	public static HashMap<String, String> NewPolicy(String strData, ExtentTest test, String depVal) throws Exception {
		/* Farmer Registration with voter id
		 */
		HashMap<String, String> hMapRetObj = new HashMap<String, String>();
		hMapRetObj.put("testRunStatus", Globals.FAIL);
		
		WebDriver driver = null;
		driver = setUp(driver);
		
		String[] datArr = strData.split("\\|");
		String[] arrMetaData = datArr[3].split("\\,");
		
		try {
			testSetUp(driver, datArr, test);
			LoggerUtils.logInfo("Login Successfully, welcome to dashboard");
			
			Genlib.sleep(2000);
			
			WebElement lbl = PolicyPage.lblDashboard(driver);
			
			
			System.out.println("Inner");
			if(lbl.getText().equals("Policies")) {
				System.out.println("Outer");
				hMapRetObj.put("testRunStatus", Globals.PASS);
				hMapRetObj.put("depUpdateVal", "");
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
				LoggerUtils.logInfo("Test passed");
				test.pass("Test passed").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");
				
			}
			else {
				System.out.println("Inner");
				hMapRetObj.put("testRunStatus", Globals.FAIL);
				hMapRetObj.put("depUpdateVal", "");
				LoggerUtils.logError("Failed in test case execution", null);
			}
				
			
			
				
			
			
		
		} 
		catch (Exception e ) {
			hMapRetObj.put("testRunStatus", Globals.EXCEPTION);
			hMapRetObj.put("depUpdateVal", "");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
			LoggerUtils.logError("Failed in test case execution", e);
			test.fail("Program Exception").addScreenCaptureFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");			
		}
		finally {
			Genlib.webDriverTearDown(driver);
		}
		return hMapRetObj;
	}
	
	public static void testSetUp(WebDriver driver, String[] datArr, ExtentTest test) throws Exception {
		LoginTest.navLogin(driver, datArr, test);
		WebElement btnSubmit = LoginPage.btnSubmitLogin(driver);
		btnSubmit.click();
		//Applib.forceLogin(driver, datArr[5]);
		Genlib.sleep(1000);
		
			
	}

	public static WebDriver setUp(WebDriver driver) {
		driver = Genlib.webDriverSetUp();
		String url = projlib.Globals.LOGIN_URL;
		driver.get(url);
		return driver;
	}

}
