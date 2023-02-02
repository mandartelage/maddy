package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PutPassWordDDF {
@FindBy(id = "txt_accesspin")	private WebElement passwordField ;
	
	@FindBy(id = "lnk_submitaccesspin")    private  WebElement submitbutton ;
	
	
	
	public  PutPassWordDDF (WebDriver driver)
	
	{
		
		PageFactory.initElements(driver,this);
	}
	public void PUTpasswordField (String Password) throws InterruptedException {
		passwordField.sendKeys(Password);
		Reporter.log("entering password", true);
		 Thread.sleep(1000);
		
	}
	
	public void CLICKsubmitbutton() throws InterruptedException {
		submitbutton.click();
		Reporter.log("clicking on submit button", true);
		Thread.sleep(1000);
	}
		
}
