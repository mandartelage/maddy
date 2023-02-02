package neoStoxMVNTextClass1;

import java.io.IOException;

import org.testng.ITestListener;
//create normal class with name listner and implements with ITestListener 
//then listner extend with base class for using base class driver
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase1.Base;
import neoStoxPomClasses.UtlityClass;


public class Listner extends Base implements ITestListener 
{
public void onTestFailure(ITestResult result) 
{
	try {
		Reporter.log("tc"+result.getName()+" failed", true);
		UtlityClass.takeScreenshot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}		
}

public void onTestSuccess(ITestResult result) {
		Reporter.log("tc"+result.getName()+" passed", true);
	}




}
