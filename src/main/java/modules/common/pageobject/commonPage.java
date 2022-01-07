package modules.common.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonPage {
	
	public static WebElement sidebar(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@name='leftnav']")));
		return element;
	}
	
	public static WebElement sidebarInsurance(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Insurance']")));
		return element;
	}
	
	public static WebElement sidebarAR(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 100);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/app-root[1]/app-page-policies[1]/div[1]/main[1]/div[1]/aside[1]/app-partial-leftnav_new[1]/section[1]/ul[1]/li[3]/div[1]/a[1]")));
		return element;
	}
	public static WebElement sidebarAP(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		return element;
	}
	
	
	
	
	
}
