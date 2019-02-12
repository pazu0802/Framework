package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	//WebDriver ldriver stands for local driver
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) 
	{
		if(browserName.equals("Chrome")) 
	{
			System.setProperty("webdriver.chrome.driver", 
					"/Users/aihaitipaziliti/Documents/Drivers/chromedriver");
			driver=new ChromeDriver();
		}
//		else if (browserName.equals("Firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", 
//					"/Users/aihaitipaziliti/Documents/Drivers/geckodriver");
//				driver=new FirefoxDriver();
//		}
//		else if(browserName.equals("IE")) 
//		{
//			
//		}
		else 
		{
		System.out.println("We do not support this browser");	
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void quitBrowser(WebDriver driver) 
	{
		driver.quit();
	}
	
	
}
