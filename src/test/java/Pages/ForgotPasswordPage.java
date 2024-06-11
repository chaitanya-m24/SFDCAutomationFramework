package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
	public ForgotPasswordPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='un']")
	public WebElement Username;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement Continue;
	
	@FindBy(xpath="//input[@name='cancel']")
	public WebElement Cancel;
	
	@FindBy(xpath="//p[contains(text(),'We’ve sent you an email with a link to finish rese')]")
	public WebElement resetMessage;
	
	public void ContinueButton(String userEmail) {
		logger.info("Enter username");
		this.Username.sendKeys(userEmail);		
		this.Continue.click();
		logger.info("An Email is sent to the associated account");
	}
	
	public void clickContinueButton()
	 {
		 if(Continue.isDisplayed())
		 {
           Continue.click();
		 }else
		 {
			 System.out.println("Continue Element not found");
			 
		 } 
	 }
	public void clickCancelButton()
	 {
		 if(Cancel.isDisplayed())
		 {
			 Cancel.click();
		 }else
		 {
			 System.out.println("Cancel Element not found");
			 
		 } 
	 }
	
	public String passwordResetMessage()
	{
		if(resetMessage.isDisplayed())
		{
			return resetMessage.getText();
		} else
		{
			return null;
		}
	}
	
	
	

}
