package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	

	@Test(dataProvider="getData")
	
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l= new LandingPage(driver);
		LoginPage lp=l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.clickLogin().click();
		log.info(username,password);
		ForgotPassword fp=lp.forgotPassword();
		fp.giveEmail().sendKeys("xxx");
		fp.sendInstruction().click();
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
	driver.close();
	}
}
