package modules.common.tests;

import java.util.HashMap;

import utility.LoggerUtils;

import com.aventstack.extentreports.ExtentTest;

import gtlib.Genlib;

public class CommonFunctions {

	public static HashMap<String, String> AddPendingInvoices(String strData, ExtentTest test, String depVal) throws Exception {
		return null;
	}
		
	public static void logMsg(String str,ExtentTest test,int wait) {
		
		LoggerUtils.logInfo(str);
		test.pass(str); 
		Genlib.sleep(wait);
	}
		
	

	

}
