package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {

	@Test
	public void test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/aihaitipaziliti/Documents/Drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement loginBtn=driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/a/span[2]"));
		loginBtn.click();
		Thread.sleep(2000);
		driver.quit();
	}
}
