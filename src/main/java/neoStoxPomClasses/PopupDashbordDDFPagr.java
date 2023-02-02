package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PopupDashbordDDFPagr {
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement clickokbutton ;	
	
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement clickClosebutton ;
	
	@FindBy(id = "lbl_username") private WebElement userName ;
	
	
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	
		public  PopupDashbordDDFPagr(WebDriver driver) {
			
			PageFactory.initElements(driver,this);
		}
		
		public void clickokbutton(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(1000);
			UtlityClass.scrollIntoView(driver, clickokbutton);
			clickokbutton.click();
			Reporter.log("clicking on PopUp OK button", true);
			Thread.sleep(1000);
			
		}
		
		public void  clickClosebutton(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(1000);
			UtlityClass.scrollIntoView(driver, clickClosebutton);
			// clickClosebutton.click();
			// Reporter.log("clicking on PopUp close button", true);
			 
		}
//
//		public void validateuserName(String expectedUsername) {
//			String actualUserName=userName.getText();
//			if(expectedUsername.equals(actualUserName)) 
//			{	
//				System.out.println("tc is passed when actual and expected result are matching");
//			}
//			else {
//				System.out.println("tc is fail when actual and expected result are not matching");
//			}
//		}
		
		
		public void logOutFromNeoStox() throws InterruptedException 
		{
		userName.click();
		Thread.sleep(1000);
		logOutButton.click();
		Reporter.log("Logging out from neoStox", true);
		Thread.sleep(1000);
		}
		
		
		public String getActualUserName()
		{
			String ActualUserName = userName.getText();
			Reporter.log("getting actual user Name", true);
			Reporter.log("Actual user name is --> "+ActualUserName, true);
			return ActualUserName;
		}
		
		
}
