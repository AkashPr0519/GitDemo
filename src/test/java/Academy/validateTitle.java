package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

@SuppressWarnings("deprecation")
public class validateTitle extends base {
	
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	@Test
	
	public void validateAppTitle() throws IOException 
	{
		LandingPage l= new LandingPage(driver);
		
		// compare the text from the browser with actual value
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfuly validated Text message");
		
	}
	
	@AfterTest
	public void teardown()
	{
	driver.close();
	}
	

}
