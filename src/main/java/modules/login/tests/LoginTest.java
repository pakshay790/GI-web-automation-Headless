package modules.login.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import modules.login.pageobject.*;
import projlib.Globals;
import utility.LoggerUtils;
import gtlib.Genlib;


public class LoginTest {

	public static String testMain(String strData, ExtentTest test) throws Exception{
		String testRunStatus = "F";
		WebDriver driver = null;
		String[] datArr = strData.split("\\|");
		try {
			driver = setUp(driver);
			switch (datArr[0].toLowerCase()) {
			case "login_001": // Correct login
				testRunStatus = login_001(driver, datArr, test);
				break;
			case "login_002": // Incorrect login
				testRunStatus = login_002(driver, datArr, test);
				break;
				
			}
		} 
		catch (Exception e) {
			testRunStatus = "E";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
			LoggerUtils.logError("Failed in test case execution", e);
			test.fail("Program Exception").addScreenCaptureFromPath("file:///C:/tech/seleniumwork/tcweb/screenshots/" + datArr[0] + ".png");			
		} 
		finally {
			Genlib.webDriverTearDown(driver);
		}
		return testRunStatus;
	}



	private static String login_001(WebDriver driver, String[] datArr, ExtentTest test) throws Exception {
		String testRunStatus = "F";
		navLogin(driver, datArr, test);
		WebElement btnSubmit = LoginPage.btnSubmitLogin(driver);
		btnSubmit.click();
		testRunStatus = "P";
		return testRunStatus;
	}

	private static String login_002(WebDriver driver, String[] datArr, ExtentTest test) throws Exception {
		// TODO Auto-generated method stub
		String testRunStatus = "F";
		navLogin(driver, datArr, test);
		WebElement btnSubmit = LoginPage.btnSubmitLogin(driver);
		btnSubmit.click();
		testRunStatus = "P";
		return testRunStatus;
	}
	
	public static void navLogin(WebDriver driver, String[] datArr, ExtentTest test) throws Exception{
		WebElement userName = LoginPage.userName(driver);
		userName.clear();
		userName.sendKeys(datArr[4]);
		LoggerUtils.logInfo("User Name: " + datArr[4]);
		test.pass("User Name:" + datArr[4]);		
		
		WebElement userPwd = LoginPage.userPwd(driver);
		userPwd.clear();
		userPwd.sendKeys(datArr[5]);
		LoggerUtils.logInfo("Password: " + datArr[5]);
		test.pass("Password: " + datArr[5]);		

	}

	public static WebDriver setUp(WebDriver driver) {
		driver = Genlib.webDriverSetUp();
		String url = projlib.Globals.LOGIN_URL;
		driver.get(url);
		return driver;
	}

}
