package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base {
	public WebDriver driver;
	
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	
	public void validateAppNavBar() 
	{
		
		LandingPage l= new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed");
	}
	
	@AfterTest
	public void teardown()
	{
	driver.close();
	}
	

}
