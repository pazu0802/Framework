package SeleniumSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
//Steps: 1.create an object of properties class
	//2.create an object of FileInputStream class and pass the path of the config.properties file
	//3. use load method to load the file 
	//4.print getproperty method and pass the key to get the value. 
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/aihaitipaziliti/git/Framework/FramWork2/src/test/java/SeleniumSessions/config.properties");
	
		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.get("browser"));
		
		//System.out.println(prop.get("url"));
		String URL = prop.getProperty("url");
		System.out.println(URL);
		
	}

}
