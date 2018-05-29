package com.pack.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import org.testng.Assert;


public class BasePageRepository extends TestBaseSetup{
	
	
	int i=0;
		
	WebDriver driver;
	String filePath="C:\\eclipse\\git\\LennoxMavenProject\\LennoxMaven\\inputdata.xlsx";
	String fileExtension;
	FileInputStream fileInputStream;
	String[] alpha =null;
	Iterator<Row> rowIterator =null;
	

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
	WebElement form_fName;
	WebElement form_lName;
	WebElement form_Email;
	WebElement form_mobile;
	WebElement form_Adress;
	WebElement form_SubUrb;
	WebElement form_selectState;
	WebElement form_postcode;
	WebElement form_DateOfBirth;
	WebElement form_ChkAgreement;
	WebElement form_submitButton;
	WebElement form_submitedForm;
	WebElement form_ErrorMessageLabel;	
	WebElement formerrorValidation_0;
	WebElement formerrorValidation_1;
	WebElement formerrorValidation_2;
	WebElement formerrorValidation_3;
	WebElement formerrorValidation_4;
	WebElement formerrorValidation_5;
	WebElement formerrorValidation_6;
	WebElement formerrorValidation_7;
	WebElement formerrorValidation_8;
	WebElement formerrorValidation_9;
	
	public WebDriver actingDriver(WebDriver driver)
	{
		return driver;
	}
	
	 public BasePageRepository(WebDriver driver) {
			
		this.driver = driver;
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
	 
	 public BasePageRepository() {
		 
			this.driver = getDriver();
			
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
			if(expectedDateFormat.contains("/"))
				
			{
			expectedDateFormat=dateOfBirth.replace("/", "-");
			}
			String[] date=dateOfBirth.split("-",3);
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
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
	}
	
	public void importDataFromExcel() throws IOException
	{
		
		  Map<String,String> ExcelData=new LinkedHashMap<String, String>();
			fileInputStream = new FileInputStream(new File(filePath));
			fileExtension = filePath.substring(filePath.indexOf("."));
        	System.out.println(fileExtension);
        	if(fileExtension.equals(".xls")){
            HSSFWorkbook workbook  = new HSSFWorkbook(new POIFSFileSystem(fileInputStream));
            HSSFSheet sheet=workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
            }
            else if(fileExtension.equals(".xlsx")){
            XSSFWorkbook workbook  = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
            }
            else {
            System.out.println("Wrong File Type");
            } 
        
        try {
  
        while(rowIterator.hasNext())
        {
        
        	Row row = (Row) rowIterator.next();
        	Iterator<Cell> cellIterator = row.cellIterator();
            
        	while (cellIterator.hasNext())
        	{
        	
              	Cell cell = cellIterator.next();
               
              	
              	if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					System.out.print(cell.getStringCellValue() + " ");
					if(cell.getStringCellValue().contains("dateOfBirth"))
					{
						
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						
						Date retrievedDate = cellIterator.next().getDateCellValue();
						String reportDate = df.format(retrievedDate);
						ExcelData.put(cell.getStringCellValue(),reportDate);
						
					}
					else
					{
					ExcelData.put(cell.getStringCellValue(),cellIterator.next().getStringCellValue());
					}
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue() + " ");
					ExcelData.put(cell.getStringCellValue(),cellIterator.next().getStringCellValue());
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					System.out.print(cell.getBooleanCellValue() + " ");
					ExcelData.put(cell.getStringCellValue(),cellIterator.next().getStringCellValue());
				}else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
					System.out.print(cell.getBooleanCellValue() + " ");
					ExcelData.put(cell.getStringCellValue(),cellIterator.next().getStringCellValue());

				}
              	
        		
        		}
        	}
        }
        catch (Exception e)
        {
        	e.getCause().printStackTrace();
        }
        for (int alpha=1;alpha<ExcelData.size();alpha++)
		{
        	//String firstName,String lastName,String email,String mobile,String address,String suburb,String selectstate,String postcode,String dateOfBirth)
        	//FirstName	LastName	Email	Mobile	Address	suburb	state	postcode	dateOfBirth

        	Submit_TestingForm(ExcelData.get("FirstName"),ExcelData.get("LastName"),ExcelData.get("Email"),ExcelData.get("Mobile"),ExcelData.get("Address"),ExcelData.get("suburb"),ExcelData.get("state"),ExcelData.get("postcode"),ExcelData.get("dateOfBirth"));
		}
        
        
	}
	public void verifyCompetitionCompleted()
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
	public void ErrorValidation(WebElement Elem,String inputText,String Label) 
	{
		inputText(Elem,inputText,Label, true);
	}
	
	
	
	public void inputText(WebElement Elem,String inputText)
	{
		if(Elem.isDisplayed())
		{
			Elem.sendKeys(inputText);
			Reporter.log(inputText+"has been successfully updated");
		}
	}
	
	public void inputText(WebElement Elem,String inputText,String Label, Boolean emptyvalidation)
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
	
	public void Click(WebElement Elem)
	{
		if(Elem.isDisplayed()||Elem.isEnabled())
		{
			Elem.click();
		}
	}
	
	public void disableButton(WebElement Elem)
	{
		if(!Elem.isEnabled())
		{
			System.out.println("Element is not enabled as expected");
			Reporter.log("Element is disabled Please refresh the page");
			driver.navigate().refresh();
		}
	}
	
	public void check(WebElement Elem)
	{
		if(!Elem.isSelected())
		{
			Elem.click();
			Reporter.log("Checked the Aggreement successfully");
		}
	}
	
	public void selectState(WebElement Elem, String StateName)
	{
		Select state=new Select(Elem);
		state.selectByValue(StateName);
	}
	
	public String getPageTitle()
	{
		String title;
		title=driver.getTitle();
		return title;
	}
	
	public String getDobErrorMessage(WebElement Elem)
	{
		return Elem.getText();
	}
	
	public boolean verifyPageTitle()
	{
		String expectedPageTitle="Testing form";
		return expectedPageTitle.contains(getPageTitle());
	}
	
	
	public boolean DOBValidation(WebElement Elem)
	{
		String errorNotification="You need to be 18 and above to enter this competition.";
		return errorNotification.contains(getDobErrorMessage(Elem));
	}


}

