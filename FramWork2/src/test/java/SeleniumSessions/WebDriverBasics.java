package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		//1.FF browser
		//geckodriver is class in selenium 
		System.setProperty("webdriver.gecko.driver", "/Users/aihaitipaziliti/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();//Launch browser 
		driver.get("https://www.google.com/"); //enter url 
		driver.manage().window().maximize();
		//get title
		String title = driver.getTitle();
		System.out.println(title); //Google
		//validation point 
		//compare expected vs.actual result.
		if(title.equals("Google")) {
			System.out.println("Test case is passed");
		} else {
			System.out.println("Test case is failed");
		}
		//get current url 
		System.out.println(driver.getCurrentUrl());
		//view page source
		//System.out.println(driver.getPageSource());
		//close current browser
		//driver.close();
		driver.quit();//quit the browser 
		
	}	
}
