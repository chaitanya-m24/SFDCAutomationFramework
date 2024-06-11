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
import Pages.LoginPage;
import Pages.UserMenuPage;
import constants.FileConstants;
import constants.WaitConstants;
import utils.DataUtils;

@Listeners(TestListener.class)

public class UserMenuTest extends BaseTest{

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
	public void checkUsermenuDropdown_T05() throws IOException {
		
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();    	
   		LoginPage lp = new LoginPage(driver);
 	    UserMenuPage up = new UserMenuPage(driver);
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
   		up.userMenu.click();
        test.log(Status.INFO, "Clicked on the user menu drop down");
        Assert.assertTrue(up.verifyUserMenuItems(), "User menu options are not displayed as expected");
}
	@Test
	public void verifyMyProfile_TC06() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage up = new UserMenuPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.login(DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password"));
		up.selectUserMenu();
		Assert.assertTrue(up.selectUserMenuOption(driver, "My Profile"), "UserMenu option should be selected");
		up.selectEditIcon(driver);
		Assert.assertTrue(up.verifyEditContactIframe(driver), "Iframe should be loaded");
		Assert.assertTrue(up.verifyLastNameChangeInAboutTab(driver, "QA"), "LastName should be changed");
		Assert.assertTrue(up.verifyCreatePost(driver, "Hello Java"), "Post should be created");
		Thread.sleep(5000);
		Assert.assertTrue(up.verifyFileUpload(driver, FileConstants.FILE_PATH), "File should be uploaded successfully");
		Assert.assertTrue(up.verifyPhotoUpload(driver, FileConstants.IMAGE_PATH), "Photo should be uploaded successfully");
	}
	
	@Test
	public void verifyMySettings_TC07() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage up = new UserMenuPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.login(DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password"));
		up.selectUserMenu();
		Assert.assertTrue(up.verifyUserMenuItems(),"Failed to verify user menu options");
		Assert.assertTrue(up.selectUserMenuOption(driver, "My Settings"), "My Settings Should be selected");
		up.verifyPersonalLinkandSelectLoginHistoryLink(driver);
	}
	
	@Test
	public void verifyDeveloperConsole_TC08() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.login(DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password"));
		ump.selectUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify user menu options");
        Assert.assertTrue(ump.selectUserMenuOption(driver, "Developer Console"));
        
        }	
	@Test
	public void verifyLogout_TC09() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.login(DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password"));
		ump.selectUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
	    Assert.assertTrue(ump.selectLogoutbutton(), "Logout is not displayed"); 
		Assert.assertTrue(ump.isVerifyLogout(driver), "Login page is not opened after logout");
		
}
}