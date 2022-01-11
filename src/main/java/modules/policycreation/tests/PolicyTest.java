package modules.policycreation.tests;

import java.io.File;
import java.util.HashMap;

import javax.xml.xpath.XPath;

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
import modules.policycreation.pageobject.PolicyCreatePage;
import modules.policycreation.pageobject.PolicyPage;
import projlib.Globals;
import utility.LoggerUtils;

import com.aventstack.extentreports.ExtentTest;

import gtlib.Genlib;

public class PolicyTest {

	public static HashMap<String, String> NewPolicy(String strData, ExtentTest test, String depVal) throws Exception {
		
		HashMap<String, String> hMapRetObj = new HashMap<String, String>();
		hMapRetObj.put("testRunStatus", Globals.FAIL);

		WebDriver driver = null;
		
		driver = setUp(driver);

		String[] datArr = strData.split("\\|");
		String[] arrMetaData = datArr[3].split("\\,");
		String[] depValue = depVal.split("\\|");

		try {
			testSetUp(driver, datArr, test);
			CommonFunctions.logMsg("Login Successfully, welcome to dashboard", test);

			Genlib.sleep(2000);

			WebElement sideBar = commonPage.sidebar(driver);
			sideBar.click();
			CommonFunctions.logMsg("Sidebar menu clicked", test);
			
			WebElement sideBarInsurance = commonPage.sidebarInsurance(driver);
			sideBarInsurance.click();
			CommonFunctions.logMsg("Sidebar Insurance menu clicked", test);
			
			WebElement sideBarPolicyCreate = PolicyPage.sideBarPolicyProfile(driver);
			sideBarPolicyCreate.click();
			CommonFunctions.logMsg("Sidebar Policy profile menu clicked", test);
			Genlib.sleep(1000);
			WebElement txtPolicyNumber = PolicyCreatePage.txtPolicyNumber(driver);
			txtPolicyNumber.sendKeys(datArr[7]);
			CommonFunctions.logMsg("Policy number entered", test);
			Genlib.sleep(1000);
			  
			WebElement txtInsured = PolicyCreatePage.txtInsuredCode(driver);
			txtInsured.click(); 
			Genlib.sleep(1000); 
			WebElement txtInsuredCodeVal = PolicyCreatePage.txtInsuredCodeVal(driver,datArr[12]); 
			txtInsuredCodeVal.click();
			CommonFunctions.logMsg("Insured details entered", test);
			
			if (datArr[13].equals("Yes")) {
				WebElement chkBillTO = PolicyCreatePage.billToSameasCustomer(driver);
				chkBillTO.click(); 
				CommonFunctions.logMsg("Bill to same as Insured ", test);
				  
			} else {
				WebElement txtBillTO = PolicyCreatePage.txtBillCode(driver);
				txtBillTO.click();
				Genlib.sleep(1000); 
				
				WebElement txtBillTOval = PolicyCreatePage.txtBillCodeVal(driver, datArr[14]);
				txtBillTOval.click();
				CommonFunctions.logMsg("Bill to details entered ", test);
			}
			  
			WebElement txtInsurer = PolicyCreatePage.txtInsurer(driver);
			txtInsurer.click();
			Genlib.sleep(1000);
			WebElement txtInsurerVal = PolicyCreatePage.txtInsurerVal(driver,datArr[15]); 
			txtInsurerVal.click();
			CommonFunctions.logMsg("Insurer details entered", test);
			
			if (!datArr[16].equals("")) {
				
				WebElement txtIntroducer = PolicyCreatePage.txtIntroducer(driver);
				txtIntroducer.click();
				Genlib.sleep(1000);
				WebElement txtIntroducerVal = PolicyCreatePage.txtIntroducerVal(driver,datArr[16]);
				txtIntroducerVal.click();
				CommonFunctions.logMsg("Introducer details entered", test);
				
			}

			WebElement txtClass = PolicyCreatePage.txtClass(driver);
			txtClass.click();
			Genlib.sleep(2000);

			WebElement txtClassVal = PolicyCreatePage.txtClassVal(driver,datArr[23]);
			Genlib.sleep(2000);
			txtClassVal.click();
			CommonFunctions.logMsg("Class Selected", test);
			
			
			WebElement txtGrossPrem = PolicyCreatePage.txtGrossPremium(driver);
			 //This will scroll the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", txtGrossPrem);
			txtGrossPrem.sendKeys(datArr[28]);
			CommonFunctions.logMsg("Gross premium entered", test);
			
			WebElement txtDiscount = PolicyCreatePage.txtDiscount(driver);
			txtDiscount.sendKeys(datArr[30]);
			CommonFunctions.logMsg("Discont entered", test);
			
			WebElement txtoutcomm1 = PolicyCreatePage.txtCommission1(driver);
			txtoutcomm1.clear();
			Genlib.sleep(1000);
			txtoutcomm1.sendKeys(datArr[35]);
			CommonFunctions.logMsg("Our Commission 1 entered", test);
			
			if (!datArr[16].equals("")) {
				
				WebElement txtIntroducerComm = PolicyCreatePage.txtIntroducerCommissionPerc(driver);
				Genlib.sleep(1000);
				txtIntroducerComm.clear();
				Genlib.sleep(1000);
				txtIntroducerComm.sendKeys(datArr[40]);
				CommonFunctions.logMsg("Introducer's Commission entered", test);
			}
			
			WebElement btnSave = PolicyCreatePage.btnSave(driver);
			btnSave.click();
			CommonFunctions.logMsg("Save btton Clicked", test);
			
			WebElement alertmsg = PolicyCreatePage.alertSuccess(driver);
			Genlib.sleep(2000);
			System.out.println(alertmsg.getText());
			
			if ((!datArr[3].equals("duplicateCheck"))  && (alertmsg.getText().equals("Policy Created Successfully."))) {
				
				WebElement btnAlertOk = PolicyCreatePage.btnAlertOk(driver);
				btnAlertOk.click(); 
				CommonFunctions.logMsg("Ok btton Clicked", test);

				hMapRetObj.put("testRunStatus", Globals.PASS);
				hMapRetObj.put("depUpdateVal", datArr[7]);
				
				Genlib.sleep(2000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
				LoggerUtils.logInfo("Policy Created Successfully");
				test.pass("Policy Created Successfully").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");

			} 
			
			else if((datArr[3].equals("duplicateCheck")) && (alertmsg.getText().equals("Policy number should be unique!"))){
				
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
			}

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
