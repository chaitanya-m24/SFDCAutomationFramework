package Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.DataUtils;
import utils.FileHandlingMethods;

public class UserMenuPage extends BasePage {
	
	public UserMenuPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement myProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement mySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement developersConsole;

	@FindBy(xpath = "//a[@title='Switch to Lightning Experience']")
	public WebElement switchToLightningExperience;

	@FindBy(xpath="//a[@title='Logout']")
	public WebElement logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement fileLink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	
	// personallink

	@FindBy(xpath = "//span[@id='PersonalInfo_font']")
	public WebElement personallink;

	@FindBy(xpath = "//span[@id='LoginHistory_font']")
	public WebElement loginHistorylink;
	
	@FindBy(xpath = "//a[contains(text(),'Download login history for last six months, includ')]")
	public WebElement loginhistorydownload;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	public boolean verifyUserMenuItems() throws IOException
	{
		 boolean menuitemsVerified= true;
		String[] expectedUserMenuItems = FileHandlingMethods.readUserMenuTestData("usermenulist").split(",");
		for(int i=0;i<expectedUserMenuItems.length;i++)
		{
			String actualOption = userMenuOptions.get(i).getText();
			if(actualOption.equals(expectedUserMenuItems[i])) {
				System.out.println("Expected option: "+expectedUserMenuItems[i]+" Actual option: "+actualOption);
			}
			else
			{
				System.out.println("Expected option: "+expectedUserMenuItems[i]+" Actual option: "+actualOption);
				menuitemsVerified = false;
			}
			
		}
		
		return menuitemsVerified;
	}

	public boolean selectUserMenuOption(WebDriver driver,String option)
	{
		boolean isOptionSelected = false;
	
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='"+option+"']"));
		if(CommonUtils.waitForElement(driver, userMenuOption))
		{
		userMenuOption.click();
		isOptionSelected = true;
	  }
		return isOptionSelected;
	}
	
	public void selectUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
		} else {
			System.out.println("Element is not displayed");
		}
	}

	
	public void selectEditIcon(WebDriver driver) {
		if (CommonUtils.waitForElement(driver, editContactButton)) {
			editContactButton.click();
		} else {
			System.out.println("Edit contact button was not visible");
		}
	}

	public boolean verifyEditContactIframe(WebDriver driver) {
		boolean isIframeLoaded = false;
		if (CommonUtils.waitForElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);
			if (aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeLoaded = true;
			} else {
				System.out.println("");
			}
		}
		return isIframeLoaded;
	}

	/**
	 * @param driver
	 * @param lastName
	 * @return
	 */
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String lastName) {
		boolean isLastNameChanged = false;
		if (aboutTab.isDisplayed()) {
			aboutTab.click();
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(lastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();
		}
		if (userProfilePageNameDisplay.isDisplayed()) {
			String actualName = userProfilePageNameDisplay.getText();
			if (actualName.contains(lastName)) {
				isLastNameChanged = true;
			} else {
				System.out.println("");
			}
		}
		return isLastNameChanged;
	}
	
	/**
	 * @param driver
	 * @param message
	 * @return
	 */
	public boolean verifyCreatePost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if(postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().defaultContent();
			if(shareButton.isDisplayed()) {
				shareButton.click();
				isPostCreated = true;
			} else {
				
			}
		}
		return isPostCreated;
	}
	
	public boolean verifyFileUpload(WebDriver driver, String filePath) throws InterruptedException {
		boolean isFileUploadSuccess  = false;
		 	if(CommonUtils.waitForElement(driver, fileLink)) {
            System.out.println("File link is displayed and enabled");
			fileLink.click();
		
			if(CommonUtils.waitForElement(driver, Uploadfile)) {
				Uploadfile.click();
			}
			if(CommonUtils.waitForElement(driver, Fileopen)) {
				Fileopen.sendKeys(filePath);
				shareButton.click();
			if(CommonUtils.waitForElementToDisappear(driver, cancelUpload)) {
					if(verifyFilePostElement.isDisplayed()) {
						isFileUploadSuccess = true;
					}
				}
			}
		}
		
		return isFileUploadSuccess;
	}
	
	public void clickOnUpdatePhotoButton(WebDriver driver) {
		CommonUtils.mouseHover(driver, moderatorButton);
		if(updateButton.isDisplayed()) {
			updateButton.click();
		}
	}
	
	public boolean verifyPhotoUpload(WebDriver driver, String imageFilePath) {
		boolean isPhotoUploadSuccess = false;
		this.clickOnUpdatePhotoButton(driver);
		driver.switchTo().frame(photoUploadIframe);
		if(CommonUtils.waitForElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(imageFilePath);
			photoSaveButton.click();
		}
		if(CommonUtils.waitForElementToDisappear(driver, spinnerIcon) 
				&& CommonUtils.waitForElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			if(CommonUtils.waitForElementToDisappear(driver, spinnerWhileCropping)) {
				isPhotoUploadSuccess = true;
			}
		}
		driver.switchTo().parentFrame();
		return isPhotoUploadSuccess;
	}
	
	public boolean isMySettingPageDisplayed()
	{
		return  mySettings.isDisplayed();
	}

	public void verifyPersonalLinkandSelectLoginHistoryLink (WebDriver driver)
	{
		//boolean isLinkSelected = false;
		if(personallink.isDisplayed())
				{
				personallink.click();
				}

		CommonUtils.mouseHover(driver, loginHistorylink);
	
		if(loginHistorylink.isDisplayed())
		{
			loginHistorylink.click();
		}
		
		CommonUtils.mouseHover(driver,loginhistorydownload );
		loginhistorydownload.click();

	}
	
	public void developerConsole()
	{
		if(developersConsole.isDisplayed())
		{
			developersConsole.click();
		}else
		{
			System.out.println("Developer Console is not displayed");
		}
	}

	public void isDevConsoleClosed(WebDriver driver) throws AWTException
	{	    
		Set<String> getAllWindows=driver.getWindowHandles();
		if (getAllWindows.size() > 1) {
            String[] window = getAllWindows.toArray(new String[0]);
            driver.switchTo().window(window[1]).close();
            driver.switchTo().window(window[0]);
            
            
        } else {
            System.out.println("Developer Console window did not open.");
        }
			
	}
	

	public boolean selectLogoutbutton() {
	    boolean isSelected = false;
	        if(logout.isDisplayed() && logout.isEnabled()) {
	            logout.click();
	            System.out.println("Logout button is clicked");
	            isSelected = true;
	        } else {
	            System.out.println("Logout button is not displayed or not enabled");
	        }
	    return isSelected;
	}
	
	public boolean isVerifyLogout(WebDriver driver) {
	    boolean isLoginPageDisplayed = false;
	    
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        boolean titleUpdated = wait.until(ExpectedConditions.titleContains("Login"));
	        if (titleUpdated) {
	            isLoginPageDisplayed = true;
	            System.out.println("Logout successful. Login page displayed.");
	        } else {
	            System.out.println("Logout unsuccessful. Current title: " + driver.getTitle());
	        
	  
	    }
	    return isLoginPageDisplayed;
	}

	
	 
}