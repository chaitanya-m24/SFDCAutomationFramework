package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import utils.DataUtils;
import Listeners.TestListener;
import Pages.LoginPage;
import Pages.UserMenuPage;


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
	public void loginWithValidCredentials_TC002() throws IOException {
		
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();    	
   		LoginPage lp = new LoginPage(driver);
    	BaseTest.test=BaseTest.extent.createTest("Login with Valid Credentials TC002");
  	    driver.get(DataUtils.readLoginTestData("app.url"));
   		driver.manage().window().maximize();
  	    test.log(Status.INFO,"Website is loaded");
  	    lp.username.sendKeys(DataUtils.readLoginTestData("username"));
  	    logger.info("Clicked on username");
	    lp.password.sendKeys(DataUtils.readLoginTestData("password"));
	    logger.info("Clicked on password");
   		lp.loginButton.click();
   		test.log(Status.INFO,"Login Button Clicked");
   		Assert.assertTrue(lp.HomeTab.isDisplayed(), "Home page is displayed");
   		
    } 
    
	
	@Test 
	public void loginErrorMessageCheck_TC001() throws IOException {
		  
	   ExtentTest test = BaseTest.threadExtentTest.get();
	   WebDriver driver = BaseTest.getDriver(); 
	   LoginPage lp = new LoginPage(driver); 
  	   BaseTest.test=BaseTest.extent.createTest("Login Error MessageCheck TC001");
	   driver.get(DataUtils.readLoginTestData("app.url"));
	   driver.manage().window().maximize();	  
	   test.log(Status.INFO,"Website is loaded");	  
	   lp.username.sendKeys(DataUtils.readLoginTestData("username"));
	   logger.info("Clicked on username");
	   lp.password.clear(); 
	   lp.loginButton.click();
 	   test.log(Status.INFO,"Login Button Clicked");
	   Assert.assertEquals(lp.getLoginErrorMessage(),"Please enter your password.");
	   
	  }
	  
	  
	  
	@Test 
	public void checkRememberMeTC_003() throws IOException {
	      
	   ExtentTest test = BaseTest.threadExtentTest.get();
	   WebDriver driver = BaseTest.getDriver(); 
	   LoginPage lp = new LoginPage(driver); 
	   UserMenuPage up = new UserMenuPage(driver);
	   BaseTest.test=BaseTest.extent.createTest("Check RememberMe TC_003");
	   driver.get(DataUtils.readLoginTestData("app.url"));
	   driver.manage().window().maximize();	  
	   test.log(Status.INFO,"Website is loaded");	  
	   lp.username.sendKeys(DataUtils.readLoginTestData("username"));
	   logger.info("Clicked on username");
	   lp.password.sendKeys(DataUtils.readLoginTestData("password"));
	   logger.info("Clicked on password");
	   lp.rememberMe.click(); 
	   logger.info("Clicked on remember me");
	   lp.loginButton.click();
	   logger.info("Clicked on Login button");
	   Assert.assertTrue(lp.HomeTab.isDisplayed(), "Home page is displayed");
	   up.userMenu.click(); 
	   lp.Logout.click();   
	  }
	 
     }

	
	
	
	
	
	


