package modules.insuranceOR.tests;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import modules.common.pageobject.commonPage;
import modules.common.tests.CommonFunctions;
import modules.insuranceOR.pageobject.InsORPage;
import modules.login.pageobject.*;
import modules.login.tests.LoginTest;
import projlib.Globals;
import utility.LoggerUtils;

import com.aventstack.extentreports.ExtentTest;

import gtlib.Genlib;

public class InsORTest {

	public static HashMap<String, String> NewOR(String strData, ExtentTest test, String depVal) throws Exception {
		
		HashMap<String, String> hMapRetObj = new HashMap<String, String>();
		hMapRetObj.put("testRunStatus", Globals.FAIL);

		WebDriver driver = null;
		
		driver = setUp(driver);

		String[] datArr = strData.split("\\|");
		String[] arrMetaData = datArr[3].split("\\,");
		String[] depValArr = depVal.split("\\,");

		try {
			testSetUp(driver, datArr, test);
			CommonFunctions.logMsg("Login Successfully, welcome to dashboard", test);

			Genlib.sleep(5000);

			WebElement sideBar = commonPage.sidebar(driver);
			sideBar.click();
			CommonFunctions.logMsg("Sidebar menu clicked", test);
			

			WebElement sideBarAR = commonPage.sidebarAR(driver);
			sideBarAR.click();
			CommonFunctions.logMsg("Sidebar Account Receivables menu selected", test);
			
			WebElement sideBarOR = InsORPage.sideBarMenuOR(driver);
			sideBarOR.click();
			CommonFunctions.logMsg("Sidebar Official Receipt menu selected", test);
			
			WebElement txtCustomerName = InsORPage.txtCustomerName(driver);
			txtCustomerName.click(); 
			Genlib.sleep(1000); 
			WebElement txtCustomerNameVal = InsORPage.txtCustomerNameVal(driver,datArr[6]); 
			txtCustomerNameVal.click();
			CommonFunctions.logMsg("Customer name entered", test);
			
			WebElement txtPaymentMode = InsORPage.txtPaymentMode(driver);
			txtPaymentMode.click(); 
			Genlib.sleep(1000); 
			WebElement txtPaymentModeVal = InsORPage.txtPaymentModeVal(driver,datArr[7]); 
			txtPaymentModeVal.click();
			CommonFunctions.logMsg("Payment mode Selected", test);
			
			WebElement txtBankCode = InsORPage.txtBankCode(driver);
			txtBankCode.click(); 
			Genlib.sleep(1000); 
			WebElement txtBankCodeVal = InsORPage.txtBankCodeVal(driver,datArr[8]); 
			txtBankCodeVal.click();
			CommonFunctions.logMsg("Bank Account code Selected", test);
			
			WebElement txtAmountPaid = InsORPage.txtAmountPaid(driver);
			txtAmountPaid.clear();
			Genlib.sleep(1000);
			txtAmountPaid.sendKeys(datArr[10]);
			CommonFunctions.logMsg("Amount paid entered", test);
			
			/*//Add Pending Invoice implementation
			WebElement btnAddPendingInv= InsORPage.btnAddPendingInv(driver);
			btnAddPendingInv.click();
			CommonFunctions.logMsg("Add Pending Invoice button clicked", test);*/
			

			WebElement btnAutoKnockoff = InsORPage.btnAutoknockOff(driver);
			btnAutoKnockoff.click();
			CommonFunctions.logMsg("Auto Knockoff button clicked", test);
			
			WebElement btnSave = InsORPage.btnSave(driver);
			btnSave.click();
			CommonFunctions.logMsg("Save Button Clicked", test);
			
			WebElement alertMsg = InsORPage.alertSuccess(driver); 
			
			String msg = alertMsg.getText();
			Genlib.sleep(2000);
			
			if (msg.equals("Created Successfully")) {
				
				String tmp = driver.findElement(By.xpath("//body[1]/app-root[1]/app-page-receipt[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-partial-_arreceipt[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")).getAttribute("value");
				CommonFunctions.logMsg("Reference number fetched", test);
				hMapRetObj.put("testRunStatus", Globals.PASS);
				hMapRetObj.put("depUpdateVal", tmp);
				
				Genlib.sleep(2000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
				LoggerUtils.logInfo("Official Receipt created");
				test.pass("Official Receipt created").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");
				
			} else {
				
				hMapRetObj.put("testRunStatus", Globals.FAIL);
				hMapRetObj.put("depUpdateVal", "");
				LoggerUtils.logError("Unable to Create Official Receipt", null);
				Genlib.webDriverTearDown(driver);

			}
			
			Genlib.sleep(1000);
		} catch (Exception e) {
			hMapRetObj.put("testRunStatus", Globals.EXCEPTION);
			hMapRetObj.put("depUpdateVal", "");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
			LoggerUtils.logError("Failed in test case execution", e);
			test.fail("Program Exception")
					.addScreenCaptureFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");
		} finally {
			Genlib.webDriverTearDown(driver);
		}
		return hMapRetObj;
	}

	public static void testSetUp(WebDriver driver, String[] datArr, ExtentTest test) throws Exception {
		LoginTest.navLogin(driver, datArr, test);
		WebElement btnSubmit = LoginPage.btnSubmitLogin(driver);
		btnSubmit.click();
		// Applib.forceLogin(driver, datArr[5]);
		Genlib.sleep(1000);

	}

	public static WebDriver setUp(WebDriver driver) {
		driver = Genlib.webDriverSetUp();
		String url = projlib.Globals.LOGIN_URL;
		driver.get(url);
		return driver;
	}

}
