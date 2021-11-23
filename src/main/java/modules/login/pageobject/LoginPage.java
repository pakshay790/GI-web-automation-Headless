	package modules.login.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public static WebElement userName(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/app-root[1]/app-page-login[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/wm-input[1]/input[1]")));
		return element;
	}
	public static WebElement userPwd(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/app-root[1]/app-page-login[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/wm-input[1]/input[1]")));
		return element;
	}

	public static WebElement btnSubmitLogin(WebDriver driver)
	{
		WebElement element=null;
		WebDriverWait wait=new WebDriverWait(driver, 50);
		element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'LOGIN')]")));
		return element;
	}
	
	
}
