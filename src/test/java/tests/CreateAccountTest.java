package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Listeners.TestListener;
import Pages.CreateAccountPage;
import Pages.LoginPage;
import utils.CommonUtils;
import utils.DataUtils;
import utils.FileHandlingMethods;

@Listeners(TestListener.class)

public class CreateAccountTest extends BaseTest{

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
	public void createAccountTC_10() throws IOException
	{
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
   		LoginPage lp = new LoginPage(driver);
	    CreateAccountPage ap=new CreateAccountPage(driver);
	    driver.get(DataUtils.readLoginTestData("app.url"));
   		//driver.manage().window().maximize();
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
 		lp.loginButton.click();
		ap.allTabs();
		//CommonUtils.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		ap.selectNewContact(driver);
		Assert.assertTrue(ap.isAccountNameDisplayed(driver, FileHandlingMethods.readAccountTestData("account.name"), 
		FileHandlingMethods.readAccountTestData("account.type"), 
		FileHandlingMethods.readAccountTestData("account.priority"))); 

	}
	
	@Test 
	public void accountsTest_TC11(Method name) throws IOException {
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
   		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    test.log(Status.INFO,"SFDC Login page is opened");
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    test.log(Status.INFO,"Clicked on Username");
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
	    test.log(Status.INFO,"Clicked on Password");
 		lp.loginButton.click(); 		 
 		ap.allTabs();
 		CommonUtils.waitForElement(driver, ap.AllTabs);
 		ap.accountTab();
 		ap.createNewViewAccount(driver);
 		Assert.assertTrue(ap.isViewAccountDisplayed(driver, FileHandlingMethods.readAccountTestData("view.name"), FileHandlingMethods.readAccountTestData("view.uniquename")));

	}
	
	@Test 
	public void accountsTest_TC12(Method name) throws IOException {
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
   		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    test.log(Status.INFO,"SFDC Login page is opened");
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    test.log(Status.INFO,"Clicked on Username");
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
	    test.log(Status.INFO,"Clicked on Password");
 		lp.loginButton.click();
 		ap.allTabs();
 		CommonUtils.waitForElement(driver, ap.AllTabs);
 		ap.accountTab();
 		Assert.assertTrue(ap.isEditViewAccountDisplayed(driver, FileHandlingMethods.readAccountTestData("selectview.name"), FileHandlingMethods.readAccountTestData("edit.name"),FileHandlingMethods.readAccountTestData("filter.Field") , FileHandlingMethods.readAccountTestData("filter.Operator"), FileHandlingMethods.readAccountTestData("filter.Value")));
	}
	
	@Test 
	public void accountsTest_TC13(Method name) throws IOException {
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
   		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    test.log(Status.INFO,"SFDC Login page is opened");
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    test.log(Status.INFO,"Clicked on Username");
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
	    test.log(Status.INFO,"Clicked on Password");
 		lp.loginButton.click();
 		ap.allTabs();
		CommonUtils.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		//ap.clickOnMergeAccountButton(driver);
		Assert.assertTrue(ap.isMergeAccountsDisplayed(driver, FileHandlingMethods.readAccountTestData("merge.accountname")));
	}
	
	@Test 
	public void accountsTest_TC14(Method name) throws IOException {
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
   		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    test.log(Status.INFO,"SFDC Login page is opened");
  	    lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	    test.log(Status.INFO,"Clicked on Username");
	    lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
	    test.log(Status.INFO,"Clicked on Password");
 		lp.loginButton.click();
 		ap.allTabs();
		CommonUtils.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		Assert.assertTrue(ap.isReportDisplayed (driver, FileHandlingMethods.readAccountTestData("report.date"),FileHandlingMethods.readAccountTestData("report.name") , FileHandlingMethods.readAccountTestData("report.uniquename")));
	}
	}


