package com.pack.test;

import org.testng.annotations.Test;
import com.pack.obj.BasePageRepository;
import com.pack.obj.TestBaseSetup;



public class FormErrorValidation extends TestBaseSetup{


	public void setup() throws InterruptedException
	{
		System.out.println("Start the setup");
	}
	
	@Test
	public void FormValidation() {
		
		System.out.println("Form page test...");
		BasePageRepository basePage = new BasePageRepository();
		basePage.Submit_ErrorValidationForm();
		
		
	}
}
