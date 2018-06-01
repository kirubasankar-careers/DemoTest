package com.pack.obj;



import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.nio.file.Paths;


public class TestBaseSetup {

	
   public static WebDriver driver;
   //String chromeDriverPath="C:\\kiruba\\driver\\latest_chrome_Driver\\";
   //String firefoxDriverPath="C:\\kiruba\\driver\\firefox\\v19\\";
   static String DefaultPath=Paths.get(".").toAbsolutePath().normalize().toString();
  // String chromeDriverPath = DefaultPath+"\\chromedriver.exe";
  // String firefoxDriverPath = DefaultPath+"\\geckodriver.exe";
	
	
	public void setDriver(String browserType, String appURL) throws InterruptedException, MalformedURLException
	{
		switch(browserType)
		{
		
		case "chrome":
		{
			
			driver=initChromeDriver(appURL);
			break;
		}
		
		case "firefox":
		{
			
			driver = initFirefoxDriver(appURL);
			break;
		}
		
		default:
		{
			System.out.println("Browser:  "+browserType+" Initiated...... Launching firefox as a default browser");
			driver = initFirefoxDriver(appURL);
			
		}
		
		}
	}
	
	public WebDriver initChromeDriver(String URL) throws InterruptedException, MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver",DefaultPath+"\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(5000);	
		return driver;
	}
	
	public WebDriver initFirefoxDriver(String URL) throws InterruptedException, MalformedURLException
	{
		System.setProperty("webdriver.gecko.driver",DefaultPath+"\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();		
		Thread.sleep(5000);
		
		return driver;
	}
	

	
	@Parameters({"browserType","appURL"})
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) 
	{
		try 
		{
			setDriver(browserType,appURL);
		}
		catch(Exception e)
		{
			System.out.print("Error ...  : "+e.getStackTrace());
		}
	}
	
	public  WebDriver getDriver()
	{
		return driver;
	}
	
	@AfterClass	
	public void closeAllBrowser()
	{
		driver.quit();
	}
	
}
