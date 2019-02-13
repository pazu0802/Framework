package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	//store all locators in this page 
	//example of Constructor- this will helps to initialize the WebDriver
	//it has same name with class, and no data type 
	//in side of Constructor, I will pass webdriver's reference 
	//otherwise, it will not identify drivers
	public LoginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]") WebElement loginBtn;
	
	public void loginToCRM(String usernameApplication, String passwordApplication) 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			//this is only for execution
		}
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginBtn.click();
	}
}
