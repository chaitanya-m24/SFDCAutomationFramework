package Listeners;

import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.ITestListener;


import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class TestListener implements ITestListener  {
	
	
	  @Override 
	  public void onStart(ITestContext context) { 
		  System.out.println("All tests have Started executing in the test suite."); 

      }
	  
	  @Override 
	  public void onFinish(ITestContext context) 
	  {
	  System.out.println("All tests have finished executing in the test suite."); 
	  }
		
	  @Override 
	  public void onTestStart(ITestResult name) { 
	  BaseTest.test = BaseTest.extent.createTest(name.getName());
	  BaseTest.threadExtentTest.set(BaseTest.test); 
	  }
		  
	
		 
	  @Override
	  public void onTestSuccess(ITestResult result) {
	  BaseTest.threadExtentTest.get().pass(result.getName());
	  }
	
	  @Override
	  public void onTestFailure(ITestResult result) {
	  BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonUtils.captureScreenShot(BaseTest.getDriver()));
	  BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel("FAILED: " + result.getName(), ExtentColor.RED));

	}


}
