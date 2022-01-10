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
		
		driver = setUp(driver);

		String[] datArr = strData.split("\\|");
		String[] arrMetaData = datArr[3].split("\\,");

		try {
			testSetUp(driver, datArr, test);
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
			
			
			
			String tmp = driver.findElement(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")).getAttribute("value");
			LoggerUtils.logInfo("Reference number fetched");
			Genlib.sleep(2000);
			System.out.println(tmp);
			
			hMapRetObj.put("testRunStatus", Globals.PASS);
			hMapRetObj.put("depUpdateVal", tmp);
			
			Genlib.sleep(2000);
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Globals.SCREENSHOT_DIR + datArr[0] + ".png"));
			LoggerUtils.logInfo("Official Receipt created");
			test.pass("Official Receipt created").addScreencastFromPath("file:///" + Globals.SCREENSHOT_DIR + datArr[0] + ".png");
			
			/*
			 * WebElement alertMsg = PaytoInsrPage.alertSuccess(driver); String msg =
			 * alertMsg.getText();
			 * 
			 * System.out.println(msg); Genlib.sleep(3000);
			 */
	

			/*WebElement sideBarPolicyCreate = PolicyPage.sideBarPolicyProfile(driver);
			sideBarPolicyCreate.click();
			LoggerUtils.logInfo("Sidebar Policy profile menu clicked");
			Genlib.sleep(4000);
			
			WebElement txtPolicyNumber = PolicyCreatePage.txtPolicyNumber(driver);
			txtPolicyNumber.sendKeys(datArr[7]);
			LoggerUtils.logInfo("POlicy number entered");
			test.pass("POlicy number entered"); 
			Genlib.sleep(6000);
			  
			WebElement txtInsured = PolicyCreatePage.txtInsuredCode(driver);
			txtInsured.click(); 
			Genlib.sleep(1000); 
			WebElement txtInsuredCodeVal = PolicyCreatePage.txtInsuredCodeVal(driver,datArr[12]); 
			txtInsuredCodeVal.click();
			LoggerUtils.logInfo("Insured details entered");
			test.pass("Insured details entered"); Genlib.sleep(2000);
			
			if (datArr[13].equals("Yes")) {
				WebElement chkBillTO = PolicyCreatePage.billToSameasCustomer(driver);
				chkBillTO.click(); 
				LoggerUtils.logInfo("Bill to same as Insured ");
				test.pass("Bill to same as Insured "); 
				Genlib.sleep(2000);
				  
			} else {
				WebElement txtBillTO = PolicyCreatePage.txtBillCode(driver);
				txtBillTO.click();
				Genlib.sleep(1000); 
				
				WebElement txtBillTOval = PolicyCreatePage.txtBillCodeVal(driver, datArr[14]);
				txtBillTOval.click();
				LoggerUtils.logInfo("Bill to details entered ");
				test.pass("Bill to details entered "); 
				Genlib.sleep(2000);
			}
			  
			WebElement txtInsurer = PolicyCreatePage.txtInsurer(driver);
			txtInsurer.click();
			Genlib.sleep(1000);
			WebElement txtInsurerVal = PolicyCreatePage.txtInsurerVal(driver,datArr[15]); 
			txtInsurerVal.click();
			LoggerUtils.logInfo("Insurer details entered");
			test.pass("Insurer details entered"); 
			Genlib.sleep(2000);
			
			if (!datArr[16].equals("")) {
				
				WebElement txtIntroducer = PolicyCreatePage.txtIntroducer(driver);
				txtIntroducer.click();
				Genlib.sleep(1000);
				WebElement txtIntroducerVal = PolicyCreatePage.txtIntroducerVal(driver,datArr[16]);
				txtIntroducerVal.click();
				LoggerUtils.logInfo("Introducer details entered");
				test.pass("Introducer details entered"); 
				Genlib.sleep(2000);
				
			}

			WebElement txtClass = PolicyCreatePage.txtClass(driver);
			txtClass.click();
			Genlib.sleep(2000);

			WebElement txtClassVal = PolicyCreatePage.txtClassVal(driver,datArr[23]);
			Genlib.sleep(2000);
			txtClassVal.click();
			LoggerUtils.logInfo("Class Selected");
			test.pass("Class Selected");
			Genlib.sleep(2000);
			
			
			WebElement txtGrossPrem = PolicyCreatePage.txtGrossPremium(driver);
			 //This will scroll the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", txtGrossPrem);
			txtGrossPrem.sendKeys(datArr[28]);
			LoggerUtils.logInfo("Gross premium entered");
			test.pass("Gross premium entered");
			Genlib.sleep(2000);
			
			WebElement txtDiscount = PolicyCreatePage.txtDiscount(driver);
			txtDiscount.sendKeys(datArr[30]);
			LoggerUtils.logInfo("Discont entered");
			test.pass("Discont entered");
			Genlib.sleep(2000);
			
			WebElement txtoutcomm1 = PolicyCreatePage.txtCommission1(driver);
			txtoutcomm1.clear();
			Genlib.sleep(1000);
			txtoutcomm1.sendKeys(datArr[35]);
			LoggerUtils.logInfo("Our Commission 1 entered");
			test.pass("Our Commission 1 entered");
			Genlib.sleep(2000);
			
			if (!datArr[16].equals("")) {
				
				WebElement txtIntroducerComm = PolicyCreatePage.txtIntroducerCommissionPerc(driver);
				Genlib.sleep(1000);
				txtIntroducerComm.clear();
				Genlib.sleep(1000);
				txtIntroducerComm.sendKeys(datArr[40]);
				LoggerUtils.logInfo("Introducer's Commission entered");
				test.pass("Introducer's Commission entered");
				Genlib.sleep(2000);
				
			}
			
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
