package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.obj.BasePageRepository;
import com.pack.obj.TestBaseSetup;



public class FormErrorValidation extends TestBaseSetup{

private WebDriver driver;
private BasePageRepository basePage;
	
	@BeforeClass 
	public void setup() throws InterruptedException
	{
		driver=getDriver();
	}
	
	@Test
	public void FormValidation() {
		
		System.out.println("Form page test...");
		basePage = new BasePageRepository(driver);
		basePage.Submit_ErrorValidationForm();
		
		
	}
}
