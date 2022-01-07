package modules.insuranceDNCN.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsDNCNPage {
	
	public static WebElement sideBarInsDNCN(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='anchor-caption'][normalize-space()='Insurance Debit/Credit Note']")));
		return element;
	}
	
	public static WebElement txtPolicyNo(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		return element;
	}
	
	public static WebElement txtPolicyNoVal(WebDriver driver, String datArr)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='"+datArr+"']")));
		return element;
	}
	
	public static WebElement txtInterestmarks1(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[35]/div[1]/div[1]/div[1]/div[1]/wm-textarea[1]/textarea[1]")));
		return element;
	}
	public static WebElement txtSumInsured(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[20]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")));
		return element;
	}
	public static WebElement btnSave(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[2]/button[5]")));
		return element;
	}
	
	public static WebElement btnReset(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[2]/button[4]")));
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

	
	public static WebElement txtDNCNNumber(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/app-root[1]/app-page-note[1]/div[1]/main[1]/div[1]/div[1]/div[1]/app-partial-_cdnote[1]/section[1]/form[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/wm-input[1]/input[1]")));
		return element;
	}
}
