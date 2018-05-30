package com.pack.test;


import org.testng.annotations.Test;
import com.pack.obj.BasePageRepository;
import com.pack.obj.TestBaseSetup;



public class TestForm extends TestBaseSetup {
		

	public void setup() throws InterruptedException
	{
		System.out.println("Browser Setup Started");
		
	}
	
	@Test
	public void EnterFormDetails() {
		
		System.out.println("Form page test...");
		 BasePageRepository Objrepository=new BasePageRepository();
		 Objrepository.Submit_TestingForm("kirubasankar", "selvaraj","kirubasankar.careers@gmail.com", "9790713757", "16/40 Telugu st", "Chennai", "ACT", "54321", "29/01/1986");
		
		
		
	}

}
