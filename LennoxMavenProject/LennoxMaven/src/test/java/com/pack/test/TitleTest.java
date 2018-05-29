package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.obj.BasePageRepository;
import com.pack.obj.TestBaseSetup;



public class TitleTest extends TestBaseSetup{


	public BasePageRepository alpha;
	
	WebDriver driver;
	
	@BeforeClass
	public void Setup() throws InterruptedException
	{
		this.driver=getDriver();
		
	}
	
	@Test
	public void verifyTitlePage() {
		
		
		System.out.println("Home page test...");
		alpha=new BasePageRepository(driver);
		//alpha=new BasePageRepository();
		System.out.println("Page title is :"+alpha.getPageTitle());
		System.out.println("Verify Page title output "+alpha.verifyPageTitle());
		Assert.assertEquals(alpha.verifyPageTitle(), true);
	 
		
		}
}
