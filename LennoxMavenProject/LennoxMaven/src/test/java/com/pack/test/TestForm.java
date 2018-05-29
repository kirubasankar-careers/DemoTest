package com.pack.test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.obj.BasePageRepository;
import com.pack.obj.TestBaseSetup;



public class TestForm extends TestBaseSetup {
	
 WebDriver driver;
 public BasePageRepository basePage;
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		this.driver=getDriver();
		
	}
	
	@Test
	public void EnterFormDetails() {
		
		System.out.println("Form page test...");
		basePage = new BasePageRepository(driver);
		basePage.Submit_TestingForm("kirubasankar", "selvaraj","kirubasankar.careers@gmail.com", "9790713757", "16/40 Telugu st", "Chennai", "ACT", "54321", "29-01-1986");
		
		
		
	}

}
