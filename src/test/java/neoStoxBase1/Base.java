package neoStoxBase1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPomClasses.UtlityClass;

public class Base {
//protected because we have to acess web driver to the test class
	//for null pointer exception -->create driver static
	protected static WebDriver driver;
public void launchBrowser() throws IOException 

{
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	
	
	 driver =new ChromeDriver(); 
	 
	driver.manage().window().maximize();
	
	driver.get(UtlityClass.ReadDataFromPropertyFile("url"));
	
	UtlityClass.implicitWait(1000, driver);
	
	Reporter.log("launching browser",  true);
	
	//comment1
	
}	
	
	
}
