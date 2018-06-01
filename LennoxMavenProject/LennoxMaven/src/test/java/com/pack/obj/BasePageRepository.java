package com.pack.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.Assert;



public class BasePageRepository extends TestBaseSetup{
	
	
	//static Path filePath1 = FileSystems.getDefault().getPath("inputdata.xlsx");
	public static String filePath=DefaultPath+"\\inputdata.xlsx";
	String fileExtension;
	public FileInputStream fileInputStream=null;
	private static XSSFWorkbook workbook=null;
	private static XSSFSheet sheet=null;
	String[] alpha =null;
	Iterator<Row> rowIterator =null;
	public static DataFormatter dataFormatter;
	
	int i=0;	
	private By FirstName=By.id("firstname");
	private By LastName=By.id("lastname");
	private By Email=By.xpath("//input[@data-tractionapi-type=\"EMAIL\"]");
	private By Mobile = By.name("customer.MOBILE");
	private By Address=By.name("customer.ADDRESS1");
	private By SubUrb=By.name("customer.SUBURBTOWN");
	private By selectState=By.id("state");
	private By Postcode=By.id("postcode");
	private By DateOfBirth=By.id("dob");
	private By ChkAgreement=By.xpath("//label[@class='checkbox-inline']/input");
	private By submitButton=By.id("subm");
	private By ErrorMessageLabel=By.id("eAge");	
	private By submittedForm=By.xpath("//div[@class='row marketing']/div/h2[contains(text(),'Thank you for entering the competition.')]");
	private By FirstName_errorValidation=By.cssSelector("#firstname+.error_validation");
	private By LastName_errorValidation=By.cssSelector("#lastname+.error_validation");
	private By Email_errorValidation=By.cssSelector("input[data-tractionapi-type]+.error_validation");
	private By Mobile_errorValidation= By.cssSelector("#mobile+.error_validation");
	private By Address_errorValidation=By.cssSelector("#address+.error_validation");
	private By SubUrb_errorValidation=By.cssSelector("input[name='customer.SUBURBTOWN']+.error_validation");
	private By selectState_errorValidation=By.cssSelector("#state+.error_validation");
	private By Postcode_errorValidation=By.cssSelector("#postcode+.error_validation");
	private By DateOfBirth_errorValidation=By.cssSelector("#dob+.error_validation");
	private By checkbox_errorValidation=By.cssSelector("div[data-tractionapi-inject-error-field='TermsNCond1']");
	private static WebElement form_fName;
	private static WebElement form_lName;
	private static WebElement form_Email;
	private static WebElement form_mobile;
	private static WebElement form_Adress;
	private static WebElement form_SubUrb;
	private static WebElement form_selectState;
	private static WebElement form_postcode;
	private static WebElement form_DateOfBirth;
	private static WebElement form_ChkAgreement;
	private static WebElement form_submitButton;
	private static WebElement form_submitedForm;
	private static WebElement form_ErrorMessageLabel;	
	private static WebElement formerrorValidation_0;
	private static WebElement formerrorValidation_1;
	private static WebElement formerrorValidation_2;
	private static WebElement formerrorValidation_3;
	private static WebElement formerrorValidation_4;
	private static WebElement formerrorValidation_5;
	private static WebElement formerrorValidation_6;
	private static WebElement formerrorValidation_7;
	private static WebElement formerrorValidation_8;
	private static WebElement formerrorValidation_9;
	
	 public BasePageRepository() {
			
		BasePageRepository.driver = getDriver();
		
		form_fName=driver.findElement(FirstName);
		form_lName=driver.findElement(LastName);
		form_Email=driver.findElement(Email);
		form_mobile=driver.findElement(Mobile);
		form_Adress=driver.findElement(Address);
		form_SubUrb=driver.findElement(SubUrb);
		form_selectState=driver.findElement(selectState);
		form_postcode=driver.findElement(Postcode);
		form_DateOfBirth=driver.findElement(DateOfBirth);
		form_ChkAgreement=driver.findElement(ChkAgreement);
		form_submitButton=driver.findElement(submitButton);
		form_submitedForm=driver.findElement(submittedForm);
		form_ErrorMessageLabel=driver.findElement(ErrorMessageLabel);	
		formerrorValidation_0=driver.findElement(FirstName_errorValidation);
		formerrorValidation_1=driver.findElement(LastName_errorValidation);
		formerrorValidation_2=driver.findElement(Email_errorValidation);
		formerrorValidation_3=driver.findElement(Mobile_errorValidation);
		formerrorValidation_4=driver.findElement(Address_errorValidation);
		formerrorValidation_5=driver.findElement(SubUrb_errorValidation);
		formerrorValidation_6=driver.findElement(selectState_errorValidation);
		formerrorValidation_7=driver.findElement(Postcode_errorValidation);
		formerrorValidation_8=driver.findElement(DateOfBirth_errorValidation);
		formerrorValidation_9 =driver.findElement(checkbox_errorValidation);
		}
	 
	@DataProvider(name="data")
	public static Object[][] retrieveDataFromExcel() throws IOException
	{
		
		File file = new File(filePath);
	
		FileInputStream fileInput= new FileInputStream(file);
		
		workbook= new XSSFWorkbook(fileInput);
		sheet =workbook.getSheetAt(0);
		workbook.close();
		int rowcount=sheet.getLastRowNum();
	    int columnCount= sheet.getRow(0).getLastCellNum();
	    
	    //define object array
	    Object[][] obj = new Object[rowcount][1];

	    for(int i=0;i<rowcount;i++) 
	    {
	    	Map<Object,Object> datamap= new HashMap<Object,Object>();
	    	
	    	for (int j=0; j<columnCount;j++)
	    	{
	    		XSSFCell rowData=sheet.getRow(0).getCell(j);
	    		//read cell data and store it to the map
	    		if (rowData.getStringCellValue().contains("dateOfBirth"))
	    		{
	    			
	    			XSSFCell cellDate=sheet.getRow(i+1).getCell(j);
	    			Date dateStr=cellDate.getDateCellValue();
	    			//DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	    			Date date = dateStr;
	    			System.out.println(date);        

	    			Calendar cal = Calendar.getInstance();
	    			cal.setTime(date);
	    			String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	    			datamap.put(sheet.getRow(0).getCell(j).toString(),formatedDate);
	    			
	    		}else
	    		{
	    		datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j));
	    		}
	    		
	    	}
	    	
	    	obj[i][0] =datamap;
	    	
	    }
	   // mydata.add((HashMap<Object, Object>) datamap);
	    
	    return obj;
	}
	
	public static String  convertToDate(String Date) throws ParseException{
		String dateInString = Date;
        dateInString = dateInString.substring(0, 9);
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH).parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String newFormat = new SimpleDateFormat("dd-MM-yy").format(date);
        return newFormat;
    }
	
	public void Submit_TestingForm(String firstName,String lastName,String email,String mobile,String address,String suburb,String selectstate,String postcode,String dateOfBirth)
	{
		try
		{
			inputText(form_fName, firstName);
			inputText(form_lName, lastName);
			inputText(form_Email, email);
			inputText(form_mobile, mobile);
			inputText(form_Adress, address);
			inputText(form_SubUrb, suburb);
			selectState(form_selectState,selectstate);
			inputText(form_postcode, postcode);
			String expectedDateFormat=dateOfBirth;
			/*if(expectedDateFormat.contains("/"))
				
			{
			expectedDateFormat=dateOfBirth.replace("/", "-");
			}
	*/
			String[] date=dateOfBirth.split("/",3);
			System.out.println("year:"+date[2]);
			if(Integer.parseInt(date[2])>1999)
			{
			inputText(form_DateOfBirth, expectedDateFormat);
			DOBValidation(form_ErrorMessageLabel);
			
			}else
			{
			expectedDateFormat=expectedDateFormat.replace("-", "/");
			inputText(form_DateOfBirth, expectedDateFormat);
			}

			check(form_ChkAgreement);
			if(Integer.parseInt(date[2])>1999)
			{
			disableButton(form_submitButton);
			}else
			{
			Click(form_submitButton);
			Thread.sleep(2000);
			verifyCompetitionCompleted();
			driver.navigate().refresh();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
	}
	

	
	public static void verifyCompetitionCompleted()
	{
		Assert.assertEquals(getDobErrorMessage(form_submitedForm), "Thank you for entering the competition.");
	}
	
	public void Submit_ErrorValidationForm()
	{
		try
		{
			Click(form_submitButton);
			String inputText="";
			String locator;
			String Label[]= {"First name","Last name","Email","Mobile","Address","Suburb","State","Postcode","Date of Birth","Terms and Condition"};
			for (int i=0;i<Label.length;i++)
			{
				
			locator="formerrorValidation_"+i;
			
			switch (locator) {
		    case "formerrorValidation_0":
		    	ErrorValidation(formerrorValidation_0,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_1":
		    	ErrorValidation(formerrorValidation_1,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_2":
		    	ErrorValidation(formerrorValidation_2,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_3":
		    	ErrorValidation(formerrorValidation_3,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_4":
		    	ErrorValidation(formerrorValidation_4,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_5":
		    	ErrorValidation(formerrorValidation_5,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_6":
		    	ErrorValidation(formerrorValidation_6,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_7":
		    	ErrorValidation(formerrorValidation_7,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_8":
		    	ErrorValidation(formerrorValidation_8,inputText,Label[i]);
		    	break;
		    case "formerrorValidation_9":
		    	ErrorValidation(formerrorValidation_9,inputText,Label[i]);
		    	break;
		    	}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
		}
	public static void ErrorValidation(WebElement Elem,String inputText,String Label) 
	{
		inputText(Elem,inputText,Label, true);
	}
	
	
	
	public static void inputText(WebElement Elem,String inputText)
	{
		if(Elem.isDisplayed())
		{
			Elem.clear();
			Elem.sendKeys(inputText);
			Reporter.log(inputText+"has been successfully updated");
		}
	}
	
	public static void inputText(WebElement Elem,String inputText,String Label, Boolean emptyvalidation)
	{
		
		if(inputText.isEmpty() && emptyvalidation==true && Label!="State" && Label!="Terms and Condition")
		{
			
			Assert.assertEquals(Elem.getText(), Label+" is required");
			Reporter.log(Label+" is required");
		}else if (Label=="State")
		{
			Assert.assertEquals(Elem.getText(), "Please select state");
			Reporter.log("Please select state");
		}else if(Label=="Terms and Condition") 
		{
			Assert.assertEquals(Elem.getText(), "Please read and agree to terms and conditions");
			Reporter.log("Please read and agree to terms and conditions");
		}
	}
	
	public static void Click(WebElement Elem)
	{
		if(Elem.isDisplayed()||Elem.isEnabled())
		{
			Elem.click();
		}
	}
	
	public static void disableButton(WebElement Elem)
	{
		if(!Elem.isEnabled())
		{
			System.out.println("Element is not enabled as expected");
			Reporter.log("Element is disabled Please refresh the page");
			driver.navigate().refresh();
		}
	}
	
	public static void check(WebElement Elem)
	{
		if(!Elem.isSelected())
		{
			Elem.click();
			Reporter.log("Checked the Aggreement successfully");
		}
	}
	
	public static void selectState(WebElement Elem, String StateName)
	{
		Select state=new Select(Elem);
		state.selectByValue(StateName);
	}
	
	public static String getPageTitle()
	{
		String title;
		title=driver.getTitle();
		return title;
	}
	
	public  static String getDobErrorMessage(WebElement Elem)
	{
		return Elem.getText();
	}
	
	public static boolean verifyPageTitle()
	{
		String expectedPageTitle="Testing form";
		return expectedPageTitle.contains(getPageTitle());
	}
	
	
	
	
	public static boolean DOBValidation(WebElement Elem)
	{
		String errorNotification="You need to be 18 and above to enter this competition.";
		return errorNotification.contains(getDobErrorMessage(Elem));
	}


}

