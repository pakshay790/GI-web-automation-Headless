package modules.policycreation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PolicyPage {
	
	public static WebElement userName(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='User Id']")));
		return element;
	}
	
	public static WebElement lblDashboard(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/app-root[1]/app-page-policies[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")));
		return element;
	}
	
	
}
