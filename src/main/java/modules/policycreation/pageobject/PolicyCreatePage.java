package modules.policycreation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PolicyCreatePage {
	
	public static WebElement btnCategory(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		return element;
	}
	
	public static WebElement txtPolicyNumber(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")));
		return element;
	}
	
	public static WebElement txtInsuredCode(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	
	public static WebElement txtInsuredCodeVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	
	public static WebElement billToSameasCustomer(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Same as Insured']")));
		return element;
	}
	public static WebElement txtBillCode(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	
	public static WebElement txtBillCodeVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	

	public static WebElement txtInsurer(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	public static WebElement txtInsurerVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	
	
	public static WebElement txtIntroducer(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[12]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	
	public static WebElement txtIntroducerVal(WebDriver driver,String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	public static WebElement policyIssueDate(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		return element;
	}
	public static WebElement policyCommenceDate(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		return element;
	}
	public static WebElement policyExpiryDate(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		return element;
	}
	public static WebElement txtClass(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	public static WebElement txtClassVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='"+datArr+"']")));
		return element;
		
	}
	public static WebElement txtGrossPremium(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	public static WebElement txtDiscount(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	public static WebElement dropGSTCode(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/wm-select[1]/select[1]")));
		return element;
	}
	public static WebElement txtCommission1(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	public static WebElement txtFirmsGSTPerc(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/wm-select[1]/select[1]")));
		return element;
	}
	public static WebElement txtIntroducerCommissionPerc(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[10]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	public static WebElement btnSave(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/button[3]")));
		return element;
	}
	public static WebElement btnCancel(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/button[1]")));
		return element;
	}
	public static WebElement btnReset(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policy[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-partial-_policyprofile[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/button[2]")));
		return element;
	}
	
	public static WebElement alertSuccess(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/modal-container[1]/app-partial-common[1]/div[1]/div[1]/div[2]/p[1]")));
		return element;
	}
	public static WebElement btnAlertOk(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/modal-container[1]/app-partial-common[1]/div[1]/div[1]/div[3]/button[1]")));
		return element;
	}
	
	
	
}
