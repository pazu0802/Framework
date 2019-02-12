package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass{
	
//this is example of Abstraction 
//going through this pageFactory labors, start browser, start application, login to CRM
//quit browser.Abstraction is showing essential features and hiding the background details 
//we are trying to login to application, we are hiding user from what locators we have used, what strategy
//we have used, what actions we are performing, type and clicking and all. we just give them login to CRM.
	
	@Test(priority=1) 
	//helps us run our test cases--post condition
	public void loginApp() 
	{	//in the base class or test cases class, 
		//whenever we create object of exceldataprovider, it will 
		//excel sheet will be loaded and excel data will be ready 
		//ExcelDataProvider excel= new ExcelDataProvider();
		
		logger=report.createTest("Login To CRM");
		
		
		//we have a PageFactory class, and we use initElements() to initialize 
		//which page you want to initialize-loginPage and use .class extension.
		//this will do loginpage check all locators initialize, once all is done 
		//it will return the object of same class.
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		//same row different column 
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
	
		logger.pass("Login Success");
	}
	
	@Test(priority=2)
	public void loginApp1() 
	{	
		logger=report.createTest("Logout from CRM");
		logger.fail("Logout Failed");
	}
}
