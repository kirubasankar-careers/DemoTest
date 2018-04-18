package com.qa.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class DemoMavenTest {
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		
		/*File PathToBinary=new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary binary=new FirefoxBinary(PathToBinary);
		FirefoxProfile Fprofile=new FirefoxProfile();
		driver= new FirefoxDriver(binary,Fprofile);*/
		driver=new FirefoxDriver();
		System.setProperty("webdriver.firefox.bin",
                    "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver","C:\\eclipse\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");	
	}

  @Test
  public void gmailLogin() throws Exception {
	  
	 try
	 {
		 driver.manage().window().maximize();
	
	  driver.findElement(By.cssSelector("input#identifierId")).clear();
		driver.findElement(By.cssSelector("input#identifierId")).sendKeys("kirubha143@gmail.com");
		driver.findElement(By.cssSelector("div#identifierNext")).click();
		//FirstClass.isElementPresent(By.cssSelector("div#password input"));
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div#password input")).click();
		driver.findElement(By.cssSelector("div#password input")).sendKeys("Lakshmi@12345!");
		driver.findElement(By.cssSelector("div#passwordNext")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div.gb_Qc.gb_mb.gb_Mg.gb_R")).click();
		driver.findElement(By.cssSelector("div.gb_Kb a[target='_top']")).click();
	 }
	 
	 catch(Exception EX)
	 {
		 System.out.print("Please find the Exception: "+EX);
		 getscreenshot();
	 }
  }
  
   @AfterTest
   public void closeBrowser()
	{
		driver.quit();
	}
   
   public void getscreenshot() throws Exception 
   {
           File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
           FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
   }
}
