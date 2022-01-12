package modules.common.tests;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.LoggerUtils;

import com.aventstack.extentreports.ExtentTest;

import gtlib.Genlib;
import modules.login.pageobject.LoginPage;
import modules.login.tests.LoginTest;

public class CommonFunctions {

	static JavascriptExecutor js ;
	public static HashMap<String, String> AddPendingInvoices(String strData, ExtentTest test, String depVal) throws Exception {
		return null;
	}
		
	public static void logMsg(String str,ExtentTest test,int wait) {
		
		LoggerUtils.logInfo(str);
		test.pass(str); 
		Genlib.sleep(wait);
	}
	
	public static WebDriver setUp(WebDriver driver) {
		driver = Genlib.webDriverSetUp();
		String url = projlib.Globals.LOGIN_URL;
		driver.get(url);
		return driver;
	}
	
	public static void testSetUp(WebDriver driver, String[] datArr, ExtentTest test) throws Exception {
		LoginTest.navLogin(driver, datArr, test);
		WebElement btnSubmit = LoginPage.btnSubmitLogin(driver);
		btnSubmit.click();
		// Applib.forceLogin(driver, datArr[5]);
		Genlib.sleep(1000);
//		js = (JavascriptExecutor) driver;
//		js.executeScript("document.body.style.zoom='90%';");

	}
		
	

	

}
