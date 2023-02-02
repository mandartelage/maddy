package neoStoxMVNTextClass1;

import org.testng.annotations.Test;

import neoStoxBase1.Base;
import neoStoxPomClasses.HomePageDDF;
import neoStoxPomClasses.PopupDashbordDDFPagr;
import neoStoxPomClasses.PutPassWordDDF;
import neoStoxPomClasses.SignInPageDDF;
import neoStoxPomClasses.UtlityClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;

//we need to extend test class  with base class 
// we need to write syntax-@Listeners packagename.classname.extension class we have to do


@Listeners(neoStoxMVNTextClass1.Listner.class)


public class ValidateNeoStoxUserNameByDataProvider extends Base
{
 HomePageDDF home;
 SignInPageDDF sinpage;
 PutPassWordDDF pass;
 PopupDashbordDDFPagr pop;
 String s="ssss";
	
	
	 @BeforeMethod
	  public void LaunchNeoStoxApp () throws EncryptedDocumentException, IOException, InterruptedException 
	 {
		 launchBrowser();//calling launch browser method form base class
			home=new HomePageDDF(driver);
			sinpage=new SignInPageDDF(driver);
			pass=new PutPassWordDDF(driver);
			pop=new PopupDashbordDDFPagr(driver);
	  }
	
	
  //@DataProvider annotation only used for @Test method
  //add parameter
	 @Test(dataProvider = "loginDetailsforValidateUserName")
  public void validateUserName(String mobNum,String password,String userName) throws EncryptedDocumentException, IOException, InterruptedException 
  {

		 home.clicksigninbutton();
		 UtlityClass.implicitWait(1000, driver);
		 
		 sinpage.mobileNofieldsendkey(mobNum);
		 Thread.sleep(1000);
		 sinpage.signInbuttonclick();
		 
		 UtlityClass.implicitWait(1000, driver);
		 pass.PUTpasswordField(password);
		 pass.CLICKsubmitbutton();
		 
		 UtlityClass.implicitWait(1000, driver);
		 pop.clickokbutton(driver);
		 Thread.sleep(1000);
		 pop.clickClosebutton(driver);
	Assert.assertEquals(pop.getActualUserName(),userName,"actual and expected test is not match then test case is fail") ;
	UtlityClass.takeScreenshot(driver, userName);
	 pop.logOutFromNeoStox();
  }
  

  @AfterMethod
  public void closeNeoStoxApp() throws InterruptedException 
  {
	  driver.close();
	  Reporter.log("Closing application", true);
	  Thread.sleep(1000);
  }

  @DataProvider(name="loginDetailsforValidateUserName")

  public String [][]getLoginDetails() {
	
	  String userDeta[][]= {{"8788549682","8788","Hi mandar telage"},{"7387901637","9362","Hi Ankush More"},{"8805568380","2303","Hi Pooja Talekar"}};
	return userDeta;

}

}
