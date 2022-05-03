package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver driver;
	
	By email =By.id("user_email");
	By submit =By.xpath("//input[@type='submit']");

	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement giveEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendInstruction()
	{
		return driver.findElement(submit);
	}
	
}
