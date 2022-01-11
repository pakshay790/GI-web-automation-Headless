package modules.insuranceDNCN.tests;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import modules.common.pageobject.commonPage;
import modules.common.tests.CommonFunctions;
import modules.insuranceDNCN.pageobject.InsDNCNPage;
import modules.login.pageobject.*;
import modules.login.tests.LoginTest;
import projlib.Globals;
import utility.LoggerUtils;

import com.aventstack.extentreports.ExtentTest;

import gtlib.Genlib;

public class InsDNCNTest {

	public static HashMap<String, String> NewDNCN(String strData, ExtentTest test, String depVal) throws Exception {
		
		HashMap<String, String> hMapRetObj = new HashMap<String, String>();
		hMapRetObj.put("testRunStatus", Globals.FAIL);

		WebDriver driver = null;
		
		driver = CommonFunctions.setUp(driver);

		String[] datArr = strData.split("\\|");
		String[] arrMetaData = datArr[3].split("\\,");
		

		try {
			CommonFunctions.testSetUp(driver, datArr, test);
			LoggerUtils.logInfo("Login Successfully, welcome to dashboard");

			Genlib.sleep(5000);

			WebElement sideBar = commonPage.sidebar(driver);
			sideBar.click();
			LoggerUtils.logInfo("Sidebar menu clicked");
			Genlib.sleep(4000);

			WebElement sideBarInsurance = commonPage.sidebarInsurance(driver);
			sideBarInsurance.click();
			LoggerUtils.logInfo("Sidebar Insurance menu clicked");
			Genlib.sleep(4000);
			
			
			WebElement sideBarInsDNCN = InsDNCNPage.sideBarInsDNCN(driver);
			sideBarInsDNCN.click();
			LoggerUtils.logInfo("Sidebar Insurance Debit/Credit menu clicked");
			Genlib.sleep(4000);
			
			/*String tmp = driver.findElement(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")).getAttribute("value");
			System.out.println("Number " + tmp);
			Genlib.sleep(2000);*/
			WebElement txtPolicyNo = InsDNCNPage.txtPolicyNo(driver);
			txtPolicyNo.sendKeys(depVal);
			Genlib.sleep(1000); 
			WebElement txtPolicyNoVal = InsDNCNPage.txtPolicyNoVal(driver, depVal);
			txtPolicyNoVal.click();
			LoggerUtils.logInfo("Policy selected");
			test.pass("Policy selected"); 
			Genlib.sleep(2000);
			
			//driver.switchTo().alert().accept();
			
			WebElement txtSumInsured = InsDNCNPage.txtSumInsured(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", txtSumInsured);
	    	Genlib.sleep(4000);
	        
	        WebElement txtInterest1 = InsDNCNPage.txtInterestmarks1(driver);
	        js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", txtInterest1);
	        Genlib.sleep(2000);
	        
	        WebElement btnSave = InsDNCNPage.btnSave(driver);
			btnSave.click();
			LoggerUtils.logInfo("Save btton Clicked");
			test.pass("Save btton Clicked");
			Genlib.sleep(4000);
			
			WebElement alerMsg = InsDNCNPage.alertSuccess(driver);
			Genlib.sleep(2000);
			
			if (alerMsg.getText().equals("Note Created Successfully")) {
				
				WebElement btnAlertOk = InsDNCNPage.btnAlertOk(driver);
				btnAlertOk.click(); 
				LoggerUtils.logInfo("Ok btton Clicked");
				test.pass("Ok  btton Clicked");
				Genlib.sleep(4000);
				
				String tmp = driver.findElement(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")).getAttribute("value");
				LoggerUtils.logInfo("Debit Number fetched");
				Genlib.sleep(2000);
				
				hMapRetObj.put("testRunStatus", Globals.PASS);
				hMapRetObj.put("depUpdateVal", tmp);
				
				Genlib.sleep(2000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
				LoggerUtils.logInfo("Debit/Credit Note created");
				test.pass("Debit/Credit Note created").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");

			} else {
				hMapRetObj.put("testRunStatus", Globals.FAIL);
				hMapRetObj.put("depUpdateVal", "");
				LoggerUtils.logError("Failed in test case execution", null);
				Genlib.webDriverTearDown(driver);
			}
			System.out.println();
			
	        
			Genlib.sleep(20000);
			
			//Note Updated Successfully
			//Note Created Successfully
			

			/*
			
			WebElement btnSave = PolicyCreatePage.btnSave(driver);
			btnSave.click();
			LoggerUtils.logInfo("Save btton Clicked");
			test.pass("Save btton Clicked");
			Genlib.sleep(2000);
			
			WebElement alertmsg = PolicyCreatePage.alertSuccess(driver);
			Genlib.sleep(2000);
			System.out.println(alertmsg.getText());
			
			if ((!datArr[3].equals("duplicateCheck"))  && (alertmsg.getText().equals("Created Successfully"))) {
				alertmsg.click();
				hMapRetObj.put("testRunStatus", Globals.PASS);
				hMapRetObj.put("depUpdateVal", "");
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
				LoggerUtils.logInfo("Policy number should be unique!, Unable to Create Policy");
				test.pass("Policy number should be unique!, Unable to Create Policy").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");

			} 
			
			else if((datArr[3].equals("duplicateCheck")) && (alertmsg.getText().equals("Policy number should be unique!"))){
				alertmsg.click();
				hMapRetObj.put("testRunStatus", Globals.PASS);
				hMapRetObj.put("depUpdateVal", "");
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
				LoggerUtils.logInfo("Policy number should be unique!, Unable to Create Policy");
				test.pass("Policy number should be unique!, Unable to Create Policy").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");
			}
			else {
				
				hMapRetObj.put("testRunStatus", Globals.FAIL);
				hMapRetObj.put("depUpdateVal", "");
				LoggerUtils.logError("Failed in test case execution", null);
				Genlib.webDriverTearDown(driver);
			}*/

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
