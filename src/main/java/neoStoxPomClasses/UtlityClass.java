package neoStoxPomClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class UtlityClass {
	

	//excel
	//wait
	//screenShot
	//scrolIntoVie
	//howToReadPropertyfile
	
	
	
	public static String ReadDataFromPropertyFile(String Key) throws IOException {
		
		//create object of properties class
		
		Properties prop=new Properties();
		
		//Created object of fileInputStream pass property file location (path)
				FileInputStream myfile =new FileInputStream("C:\\Users\\manda\\eclipse-workspace\\SoftwareTesting_MVN\\property.properties");
					
			// for the loading the file  in the  eclipse memory we use  load method and load method belong to property class
				prop.load(myfile);
				
				String value = prop.getProperty(Key);
				
				Reporter.log("read data form property file", true);
				Reporter.log("deta is "+value,true);
				
				return value;
		
	}
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException 
	{
		//excel
		File myFile = new File("E:\\\\\\\\poi-bin-5.2.3-20220909\\\\\\\\Worksheet.xlsx");
		
		 Sheet mysheet = WorkbookFactory.create(myFile).getSheet("sheet5");
		String value = mysheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading data from excel row is "+row+" cell is "+cell, true);
		Reporter.log("data is "+value, true);
		return value;
		
		
	}
	
	public static void implicitWait(int time, WebDriver driver)
	{
		//wait
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	Reporter.log("waiting for "+time+"ms", true);
	
	}
	
public static void takeScreenshot(WebDriver driver,String filename) throws IOException 
{
	//screenShot
	
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	String s=RandomString.make(2);
	File destination=new File("E:\\screenshot\\"+filename +s+".png");
		FileHandler.copy(source, destination);	
		Reporter.log("taking screenshot ", true);
		Reporter.log("screenShot taken and saved at "+destination, true);
		
}	
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
 JavascriptExecutor js = (JavascriptExecutor)driver;	
 js.executeScript("arguments[0].scrollIntoView(true)",element);
 Reporter.log("scrolling into view to "+element.getText(), true);
 
	}
	
	
	
	
	
	
	
	
}
