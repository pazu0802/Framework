package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	//Handle--screenshots, alerts, frames, windows, sync issue, javaScript executor
	//keep method as static we can directly call them whenever you need 
	//if not static, we must create object of helper class in base class 
	//can access it 
	public static String captureScreenshot(WebDriver driver) 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
		System.out.println("Unable capture screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	//capture date time 
	public static String getCurrentDateTime() {
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customformat.format(currentDate);
	}
	
	
	
	
	
	
}
