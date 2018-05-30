package com.pack.test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pack.obj.BasePageRepository;
import com.pack.obj.TestBaseSetup;
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class TestFormMultipleEntry extends TestBaseSetup
{
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String address;
	private String suburb;
	private String selectstate;
	private String postcode;
	private String dateOfBirth;
    //Date todaysDate = new Date();
   // DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    
		public void setup() throws InterruptedException
		{
			
			System.out.println("test case for multiple input to the form and validate it");
		}
		
		@Test(dataProvider = "data")
		  public void integrationTest(Map<Object, Object> map) {
			
			try {
		    System.out.println("-------------Test case started ----------------");
		    System.out.println(map.get("FirstName"));
		    System.out.println(map.get("LastName"));
		    System.out.println(map.get("Email"));
		    System.out.println(map.get("Mobile"));
		    System.out.println(map.get("Address"));
		    System.out.println(map.get("suburb"));
		    System.out.println(map.get("state"));
		    System.out.println(map.get("postcode"));
		    System.out.println(map.get("dateOfBirth"));		    
		    
		    /*Date date =  df.parse((String) map.get("dateOfBirth"));
		    String dateOfBirth1=df.format(date);
		    System.out.println(dateOfBirth1);*/
		    
		    firstName=map.get("FirstName").toString();
		    lastName=map.get("LastName").toString();
		    email=map.get("Email").toString();
		    mobile=map.get("Mobile").toString();
		    address=map.get("Address").toString();
		    suburb=map.get("suburb").toString();
		    selectstate=map.get("state").toString();
		    postcode=map.get("postcode").toString();
		    dateOfBirth=map.get("dateOfBirth").toString();
		   
		    BasePageRepository Objrepository=new BasePageRepository();
		    Objrepository.Submit_TestingForm(firstName, lastName, email, mobile, address, suburb, selectstate, postcode,  dateOfBirth);

		    System.out.println("-------------Test case Ended ----------------");
			}
			catch(Exception ex)
			{
				System.out.println(ex.getStackTrace());
			}
		  }
		

		@DataProvider(name="data")
	    public Object[][] formData() throws IOException{      
	        
	          
	    	   return BasePageRepository.retrieveDataFromExcel();
	     
	       }
		     
       

}
