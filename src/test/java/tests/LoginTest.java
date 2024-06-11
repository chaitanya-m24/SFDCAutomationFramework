package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import utils.DataUtils;
import Listeners.TestListener;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Pages.UserMenuPage;
import constants.FileConstants;


@Listeners(TestListener.class)

public class LoginTest extends BaseTest
{	
	@BeforeMethod(dependsOnGroups = {""})
	public void preCondtions(Method name) {
		System.out.println("Pre condtion Login to the application");
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod
	public void postCondtions() {
		
		System.out.println("post condtion to home page of the application");
		BaseTest.getDriver().close();
		
		   	}
	
	@Test
	public void loginWithValidCredentials_TC02() throws IOException {
		
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
   		test.log(Status.INFO,"Login Button is Clicked");
   		Assert.assertTrue(lp.HomeTab.isDisplayed(), "Home page is displayed");
   		
    } 
    
	
	@Test 
	public void loginErrorMessageCheck_TC01() throws IOException {
		  
	   ExtentTest test = BaseTest.threadExtentTest.get();
	   WebDriver driver = BaseTest.getDriver(); 
	   LoginPage lp = new LoginPage(driver); 
  	   //BaseTest.test=BaseTest.extent.createTest("Login Error MessageCheck TC001");
	   driver.get(DataUtils.readLoginTestData("app.url"));
	   driver.manage().window().maximize();	  
	   test.log(Status.INFO,"SFDC Login page is opened");	  
	   lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	   logger.info("Clicked on username");
	   lp.password.clear(); 
	   lp.loginButton.click();
 	   test.log(Status.INFO,"Login Button Clicked");
	   Assert.assertEquals(lp.getLoginErrorMessage(),"Please enter your password.");
	   
	  }
	  
	  
	  
	@Test 
	public void checkRememberMeTC_03() throws IOException {
	      
	   ExtentTest test = BaseTest.threadExtentTest.get();
	   WebDriver driver = BaseTest.getDriver(); 
	   LoginPage lp = new LoginPage(driver); 
	   UserMenuPage up = new UserMenuPage(driver);
	   //BaseTest.test=BaseTest.extent.createTest("Check RememberMe TC_003");
	   driver.get(DataUtils.readLoginTestData("app.url"));
	   driver.manage().window().maximize();	  
	   test.log(Status.INFO,"SFDC Login page is opened");	  
	   lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	   test.log(Status.INFO,"Clicked on username");
	   lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
	   test.log(Status.INFO,"Clicked on password");
	   lp.rememberMe.click(); 
	   test.log(Status.INFO,"Clicked on remember me");
	   lp.loginButton.click();
	   test.log(Status.INFO,"Clicked on Login button");
	   Assert.assertTrue(lp.HomeTab.isDisplayed(), "Home page is displayed");
	   up.userMenu.click(); 
	   lp.Logout.click();   
	  }
	
	@Test
	public void forgotPasswordTC_04() throws IOException {
		   ExtentTest test = BaseTest.threadExtentTest.get();
		   WebDriver driver = BaseTest.getDriver(); 
		   LoginPage lp = new LoginPage(driver); 
		   ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		   //BaseTest.test=BaseTest.extent.createTest("Forgot Password TC_04");
		   driver.get(DataUtils.readLoginTestData("app.url"));
		   driver.manage().window().maximize();	  
		   test.log(Status.INFO,"SFDC Login page is opened");
		   lp.ForgotPassword.click();
		   logger.info("Clicked on Forgot Password link");
		   // Assert that the Forgot Password page is displayed
		   Assert.assertTrue(fp.Username.isDisplayed(), "Forgot Password page is not displayed.");
		   test.log(Status.INFO, "Forgot Password page is displayed");
		   fp.Username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		   fp.Continue.click();
		   test.log(Status.INFO,"Clicked on Continue button");
		   Assert.assertEquals(fp.passwordResetMessage(),"We’ve sent you an email with a link to finish resetting your password.");
	}
	
	@Test
	public void forgotPasswordTC_04B() throws IOException {
		   ExtentTest test = BaseTest.threadExtentTest.get();
		   WebDriver driver = BaseTest.getDriver(); 
		   LoginPage lp = new LoginPage(driver); 
		   ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		   //BaseTest.test=BaseTest.extent.createTest("Forgot Password TC_004");
		   driver.get(DataUtils.readLoginTestData("app.url"));
		   driver.manage().window().maximize();	  
		   test.log(Status.INFO,"SFDC Login page is opened");		  
		   lp.username.sendKeys(DataUtils.readLoginTestData("invalid.username"));		 
		   test.log(Status.INFO,"Entered invalid username");
		   Assert.assertNotNull(lp.getUsername());
		   lp.password.sendKeys(DataUtils.readLoginTestData("invalid.password"));	
		   test.log(Status.INFO,"Entered invalid password");
		   Assert.assertNotNull(lp.getPassword());
		   lp.clickLoginButton();
		   test.log(Status.INFO,"Clicked on Login button");
		   Assert.assertEquals(lp.getLoginErrorMessage(),DataUtils.readLoginTestData("expectedloginerrormessage"),"Error message should be displayed");
	}
	
		   
	}
	
	 
     

	
	
	
	
	
	


