package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By Login =By.cssSelector("a[href*='sign_in']");
	By title =By.cssSelector(".text-center>h2");
	By navBar=By.cssSelector(".nav.navbar-nav.navbar-right"); 
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public LoginPage getLogin()
	{
	    driver.findElement(Login).click();
		return new LoginPage(driver);
		
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}
	
}
