package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException

	{
		prop = new Properties();
		FileInputStream fis= new FileInputStream("D:\\SeleniumTraining\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Z0049Z0P\\Desktop\\Automation_Training\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();	
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Z0049Z0P\\Desktop\\Automation_Training\\geckodriver-v0.30.0-win32\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Z0049Z0P\\Desktop\\Automation_Training\\IEDriverServer_Win32_4.0.0\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}
    
	public String getScreenshotPath(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
		
	}
}
