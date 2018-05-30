package com.pack.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.pack.obj.BasePageRepository;
import com.pack.obj.TestBaseSetup;



public class TitleTest extends TestBaseSetup{


	public void Setup() throws InterruptedException
	{
		System.out.println("Browser Setup Started");
		
	}
	
	@Test
	public void verifyTitlePage() {
		
		
		System.out.println("Home page test...");
		System.out.println("Page title is :"+BasePageRepository.getPageTitle());
		System.out.println("Verify Page title output "+BasePageRepository.verifyPageTitle());
		Assert.assertEquals(BasePageRepository.verifyPageTitle(), true);
	 
		
		}
}
