package neoStoxMVNTextClass1;

import org.testng.annotations.Test;

import neoStoxBase1.Base;
import neoStoxPomClasses.HomePageDDF;
import neoStoxPomClasses.PopupDashbordDDFPagr;
import neoStoxPomClasses.PutPassWordDDF;
import neoStoxPomClasses.SignInPageDDF;
import neoStoxPomClasses.UtlityClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
//we need to extend test class  with base class 
// we need to write syntax-@Listeners packagename.classname.extension class we have to do


@Listeners(neoStoxMVNTextClass1.Listner.class)


public class ValidateNeoStoxUserNameByLISTNER extends Base
{
 HomePageDDF home;
 SignInPageDDF sinpage;
 PutPassWordDDF pass;
 PopupDashbordDDFPagr pop;
 String s="ssss";
	@BeforeClass
	  public void launchNeoStoxApp() throws IOException
	{
		launchBrowser();//calling launch browser method form base class
		home=new HomePageDDF(driver);
		sinpage=new SignInPageDDF(driver);
		pass=new PutPassWordDDF(driver);
		pop=new PopupDashbordDDFPagr(driver);
	  }
	
	
	 @BeforeMethod
	  public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException 
	 {
		 home.clicksigninbutton();
		 UtlityClass.implicitWait(1000, driver);
		 
		 sinpage.mobileNofieldsendkey(UtlityClass.ReadDataFromPropertyFile("mobileNo"));
		 Thread.sleep(1000);
		 sinpage.signInbuttonclick();
		 
		 UtlityClass.implicitWait(1000, driver);
		 pass.PUTpasswordField(UtlityClass.ReadDataFromPropertyFile("password"));
		 pass.CLICKsubmitbutton();
		 
		 UtlityClass.implicitWait(1000, driver);
		 pop.clickokbutton(driver);
		 Thread.sleep(1000);
		 pop.clickClosebutton(driver);
	  }
	
	
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	Assert.fail();
	Assert.assertEquals(pop.getActualUserName(),UtlityClass.ReadDataFromPropertyFile("userName"),"actual and expected test is not match then test case is fail") ;
	UtlityClass.takeScreenshot(driver, s);
  }
  

  @AfterMethod
  public void logOutFromNeoStox() throws InterruptedException 
  {
	  pop.logOutFromNeoStox();
  }

  

  @AfterClass
  public void closeNeoStoxApp() throws InterruptedException
  {
	  driver.close();
	  Reporter.log("Closing application", true);
	  Thread.sleep(1000);
  }

}
