package modules.paymenttoInsr.tests;

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
import modules.login.pageobject.*;
import modules.login.tests.LoginTest;
import modules.paymenttoInsr.pageobject.PaytoInsrPage;
import projlib.Globals;
import utility.LoggerUtils;

import com.aventstack.extentreports.ExtentTest;

import gtlib.Genlib;

public class PaytoInsrTest {

	public static HashMap<String, String> NewPayment(String strData, ExtentTest test, String depVal) throws Exception {
		
		HashMap<String, String> hMapRetObj = new HashMap<String, String>();
		hMapRetObj.put("testRunStatus", Globals.FAIL);

		WebDriver driver = null;
		
		driver = CommonFunctions.setUp(driver);

		String[] datArr = strData.split("\\|");
		String[] arrMetaData = datArr[3].split("\\,");

		try {
			CommonFunctions.testSetUp(driver, datArr, test);
			LoggerUtils.logInfo("Login Successfully, welcome to dashboard");

			Genlib.sleep(4000);

			WebElement sideBar = commonPage.sidebar(driver);
			sideBar.click();
			LoggerUtils.logInfo("Sidebar menu clicked");
			
			Genlib.sleep(4000);

			WebElement sideBarAR = commonPage.sidebarAP(driver);
			sideBarAR.click();
			LoggerUtils.logInfo("Sidebar Account Payables menu selected");
			Genlib.sleep(4000);
			
			WebElement paytoInsurer = PaytoInsrPage.menuPaymenttoInsurer(driver);
			paytoInsurer.click();
			LoggerUtils.logInfo("Payment ot Insurer menu selected");
			Genlib.sleep(3000);
			
			WebElement txtInsurerName = PaytoInsrPage.txtInsurerName(driver);
			txtInsurerName.click(); 
			Genlib.sleep(1000); 
			WebElement txtCustomerNameVal = PaytoInsrPage.txtCustomerNameVal(driver,datArr[6]); 
			txtCustomerNameVal.click();
			LoggerUtils.logInfo("Insurer Selected");
			test.pass("Insurer Selected"); 
			Genlib.sleep(3000);
			
			WebElement txtPaymentMode = PaytoInsrPage.txtPaymentMode(driver);
			txtPaymentMode.click(); 
			Genlib.sleep(1000); 
			WebElement txtPaymentModeVal = PaytoInsrPage.txtPaymentModeVal(driver,datArr[7]); 
			txtPaymentModeVal.click();
			LoggerUtils.logInfo("Payment mode Selected");
			test.pass("Payment mode Selected"); 
			Genlib.sleep(3000);
			
			WebElement txtBankCode = PaytoInsrPage.txtBankCode(driver);
			txtBankCode.click(); 
			Genlib.sleep(1000); 
			WebElement txtBankCodeVal = PaytoInsrPage.txtBankCodeVal(driver,datArr[8]); 
			txtBankCodeVal.click();
			LoggerUtils.logInfo("Bank Account code Selected");
			test.pass("Bank Account code Selected"); 
			Genlib.sleep(3000);
			
			WebElement txtAmountPaid = PaytoInsrPage.txtAmountPaid(driver);
			txtAmountPaid.clear();
			Genlib.sleep(1000);
			txtAmountPaid.sendKeys(datArr[10]);
			LoggerUtils.logInfo("Amount paid entered");
			test.pass("Amount paid entered"); 
			Genlib.sleep(3000);
			
			WebElement btnAutoKnockoff = PaytoInsrPage.btnAutoknockOff(driver);
			btnAutoKnockoff.click();
			Genlib.sleep(3000);
			LoggerUtils.logInfo("Auto Knockoff button clicked");
			test.pass("Auto Knockoff button clicked"); 
			
			WebElement btnSave = PaytoInsrPage.btnSave(driver);
			btnSave.click();
			
			LoggerUtils.logInfo("Save Button Clicked");
			test.pass("Save Button Clicked");
			Genlib.sleep(5000);
			
			
			WebElement alertMsg = PaytoInsrPage.alertSuccess(driver);
			
			String msg = alertMsg.getText();
			Genlib.sleep(1000);
			if (msg.equals("Created successfully")) {
				
				String tmp = driver.findElement(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")).getAttribute("value");
				LoggerUtils.logInfo("Reference number fetched");
				Genlib.sleep(2000);
				//System.out.println(tmp);
				
				hMapRetObj.put("testRunStatus", Globals.PASS);
				hMapRetObj.put("depUpdateVal", tmp);
				
				Genlib.sleep(2000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
				LoggerUtils.logInfo("Payment to Insurer Created");
				test.pass("Official Receipt created").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");
				
			} else {
				
				hMapRetObj.put("testRunStatus", Globals.FAIL);
				hMapRetObj.put("depUpdateVal", "");
				LoggerUtils.logError("Unable to Create Payment", null);
				Genlib.webDriverTearDown(driver);

			}
			//System.out.println(msg); 


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

	
}
