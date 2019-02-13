package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite //ASA test suite start this will setup my execel dataProvider 
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and Test is getting ready", true);
		
		excel= new ExcelDataProvider();
		config=new ConfigDataProvider();
		//Create object of ExtentHtmlReporter and provide the path where you want store 
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		//attach the reporter which we are created 
		report.attachReporter(extent);
		Reporter.log("Setting Done- Test can be started ", true);
	}
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass //precondition
	public void setup(String browser, String appURL) 
	{
		Reporter.log("Trying to start Browser and application getting ready ", true);
		//driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStageURL());
		driver=BrowserFactory.startApplication(driver,browser,appURL);
		Reporter.log("Browser and application is up and running ", true);
	}
	
	@AfterClass
	public void teardown() 
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod //it is very helpful when you are run certain piece of code 
	//after each test cases
	//this method helps take screen shot your test cases past or failed 
	public void tearDownMethod(ITestResult result) throws IOException //interface:ITestResult:ASA your test case run after it will give you a result 
	{
		Reporter.log("Test is about to end ", true);

		if(result.getStatus()==ITestResult.FAILURE) 
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		//helps generate report keep on adding reports 
		Reporter.log("Test Completed >>> Reports generated", true);
	}
	
	
}
