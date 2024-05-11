package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.FileHandlingMethods;
import utils.WaitUtils;

public class UserMenuPage extends BasePage {
	
	public UserMenuPage(WebDriver driver)
	{
		super(driver);
	}

		
	@FindBy(id="userNavLabel")
	public WebElement userMenu;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a" )
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath="//*[text()='My Profile']")
	public WebElement MyProfile;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[2]")
	public WebElement MySettings;
	
	@FindBy(id="userNav-menuItems/a[3]")
	public WebElement DeveloperConsole;
	
	@FindBy(id="userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;
	
	@FindBy(xpath="//*[text()='Logout']")
	public WebElement Logout;
	
	//My profile
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']")
		public WebElement editContactButton;
	
	@FindBy(xpath="//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;
	
	@FindBy(id="aboutTab")
	public WebElement aboutTab;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement aboutTabLastname;
	
	@FindBy(xpath="//*[@value='Save All']")
	public WebElement saveAllButton;
	
	
	@FindBy(xpath="//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement userProfilePageNameDisplay;
	
	//Postlink
	
	@FindBy(css ="#publishereditablearea")
	public WebElement postLink;
	
	@FindBy(xpath="/html/body")
	public WebElement postTextArea;
	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	public WebElement shareButton;
	
	//filelink
	
	@FindBy(xpath="//*[@id='publisherAttachContentPost']")
	public WebElement fileLink;
	
	@FindBy(xpath="//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentPost;
	
	@FindBy(id="chatterUploadFileAction")
	public WebElement uploadFile;

	@FindBy(css="#chatterFile")
	public WebElement fileOpen;

	@FindBy(css="#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;

	//photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id="j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

    @FindBy(name="j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;
	
	@FindBy(id  = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photouploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement phototSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement phototSaveButton2;

	@FindBy(xpath="//div[@id='PersonalInfo']")
	public WebElement personalLink;

	@FindBy(xpath="//span[text()='Login History']")
	public WebElement loginHistorylink;

	@FindBy(xpath="//div[@class='pShowMore']")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement lDisplayLayoutLink;

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

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSetting_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7][td[2]/d")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]/")
	public WebElement Saveonemail;

	//Calendar and Reminders

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

	@FindBy(id ="contactTab")
	public WebElement contactTab;

	public boolean verifyUserMenuItems() throws IOException
	{
		 boolean menuitemsVerified= true;
		String[] expectedUserMenuItems = FileHandlingMethods.readLoginTestData("usermenu.items").split(",");
		for(int i=0;i<expectedUserMenuItems.length;i++)
		{
			String actualOption = userMenuOptions.get(i).getText();
			if(actualOption.equals(expectedUserMenuItems[i])) {
				System.out.println("userMenuPage : verifyUserMenuItems : Expected option: "+expectedUserMenuItems[i]+" Actual option: "+actualOption);
			}
			else
			{
				System.out.println("userMenuPage : verifyUserMenuItems : Expected option: "+expectedUserMenuItems[i]+" Actual option: "+actualOption);
				menuitemsVerified = false;
			}
			
		}
		
		return menuitemsVerified;
	}

	public boolean selectUserMenuOption(WebDriver driver,String option)
	{
		boolean isOptionSelected = false;
	
	//	if(userMenu.isDisplayed())
	//	{
	//		userMenu.click();
	//	}
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='"+option+"']"));
		if(WaitUtils.waitForElement(driver, userMenuOption))
		{
		userMenuOption.click();
		isOptionSelected = true;
	  }
		return isOptionSelected;
	}

}
