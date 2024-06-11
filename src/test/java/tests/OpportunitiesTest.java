package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.LoginPage;
import Pages.OpportunitiesPage;
import constants.WaitConstants;
import utils.CommonUtils;
import utils.DataUtils;
import utils.FileHandlingMethods;

public class OpportunitiesTest extends BaseTest{
	@BeforeMethod(dependsOnGroups = {""})
	
	public void preCondtions(Method name) {
		
		System.out.println("Pre condition Login to the application");
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod
	public void postCondtions() {
		
		System.out.println("Post condition to home page of the application");
		BaseTest.getDriver().close();
		
		   	}
	@Test
	public void opportunitesDropDownTC15() throws IOException
	{
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();    	
   		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
  	    driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
   		lp.loginButton.click();
		op.allTabs();
		op.opportunitesTab();
		Assert.assertTrue(op.isOpportunitesViewDisplayed());
		System.out.println(CommonUtils.captureScreenShot(driver));
	}
	@Test
	public void createOpportunitesPageTC16() throws IOException
	{
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();    	
   		LoginPage lp = new LoginPage(driver);
    	//BaseTest.test=BaseTest.extent.createTest("Login with Valid Credentials TC002");
  	    driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
   		lp.loginButton.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		op.newButton();
		Assert.assertTrue(op.isOpportunitesPageDisplayed(driver, FileHandlingMethods.readOpportunitiesTestData("opp.name"),FileHandlingMethods.readOpportunitiesTestData("opp.accountname") , FileHandlingMethods.readOpportunitiesTestData("opp.closedate"), FileHandlingMethods.readOpportunitiesTestData("opp.stage"), FileHandlingMethods.readOpportunitiesTestData("opp.probability"),FileHandlingMethods.readOpportunitiesTestData("opp.leadsource") , FileHandlingMethods.readOpportunitiesTestData("opp.pcsource")));
    }
	
	@Test(groups =  {"Smoke"})
	
		public void opportunityPipeLineTC17() throws IOException
		{
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();    	
   		LoginPage lp = new LoginPage(driver);
  	    driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
   		lp.loginButton.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		Assert.assertTrue(op.isReportPipelinePageDisplayed());
			
	}
	@Test(groups = {"Smoke"})
	
	public void opportunityStuckTC18() throws IOException
	{
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();    	
   		LoginPage lp = new LoginPage(driver);
  	    driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
   		lp.loginButton.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		Assert.assertTrue(op.isStuckReportpageDisplayed());
		
     }
	
	@Test(enabled=false)
	
	public void quaterlyReportTC19() throws IOException
	{
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();    	
   		LoginPage lp = new LoginPage(driver);
    	//BaseTest.test=BaseTest.extent.createTest("Login with Valid Credentials TC002");
  	    driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    test.log(Status.INFO,"SFDC Login page is opened");
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
  	    test.log(Status.INFO,"Clicked on Username");
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
  	    test.log(Status.INFO,"Clicked on Password");
   		lp.loginButton.click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.allTabs();
		op.opportunitesTab();
		Assert.assertTrue(op.isQuaterlySummaryReportDisplayed(driver, FileHandlingMethods.readOpportunitiesTestData("opp.interval"), FileHandlingMethods.readOpportunitiesTestData("opp.include")));
		
     }
}
