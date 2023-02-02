package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPageDDF {

	@FindBy (xpath = "(//input[@type= 'number'])[1]") private WebElement mobileNofield ;
	
	@FindBy(id = "lnk_signup1")  private WebElement signInbutton ;
	
	public   SignInPageDDF(WebDriver driver)
	
	{
		
	PageFactory.initElements(driver,this);	
		
	}
	
	public void mobileNofieldsendkey (String MobNum ) {
		
		mobileNofield.sendKeys(MobNum);
		Reporter.log("Entering mobile number", true);
		
	}
	
	public void  signInbuttonclick() {
		signInbutton .click();
		Reporter.log("Clicking on sign in button", true);
	}
	
}
