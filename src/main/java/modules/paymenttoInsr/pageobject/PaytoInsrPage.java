package modules.paymenttoInsr.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaytoInsrPage {
	

	public static WebElement menuPaymenttoInsurer(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Payment to Insurers']")));
		return element;
	}
	
	public static WebElement txtInsurerName(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	
	
	public static WebElement txtCustomerNameVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	
	public static WebElement txtPaymentMode(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	
	
	public static WebElement txtPaymentModeVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	
	public static WebElement txtBankCode(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	
	
	public static WebElement txtBankCodeVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	
	public static WebElement txtAmountPaid(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	public static WebElement btnAutoknockOff(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[12]/div[1]/div[1]/div[2]/button[2]")));
		return element;
	}
	
	
	public static WebElement btnSave(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-appayment[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_appayment[1]/section[1]/form[1]/div[1]/div[2]/button[2]")));
		return element;
	}
	public static WebElement btnCancel(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		return element;
	}
	public static WebElement btnReset(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		return element;
	}
	
	public static WebElement alertSuccess(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]")));
		return element;
	}
	
	public static WebElement txtORNumber(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-receipt[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-partial-_arreceipt[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")));
		return element;
	}
	
	
}
