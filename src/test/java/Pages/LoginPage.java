package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super (driver);
	}

	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id = "error")
	public WebElement errorMessage; 

	@FindBy(xpath="//*[text()='Logout']")
	public WebElement Logout;
	
	@FindBy(xpath="//a[@title='Home Tab']")
	public WebElement HomeTab;
	
	@FindBy(id="forgot_password_link")
	public WebElement ForgotPassword;
	
	

	public void login(String userEmail, String passWord) {
		logger.info("Siging in to application");
		this.username.sendKeys(userEmail);
		this.password.sendKeys(passWord);
		this.loginButton.click();
		logger.info("Should be signed in to application");
	}
	
	
		
		public void clickLoginButton()
		 {
			 if(loginButton.isDisplayed())
			 {
	            loginButton.click();
			 }else
			 {
				 System.out.println("Login element not found");
				 
			 } 
		 }
	 
		public void selectrememberMeCheckbox()
		{
			if(!rememberMe.isSelected())
			{
				rememberMe.click();
			}
	}
	
		
		
		public void homePage()
		{
			if(HomeTab.isDisplayed()) {
				System.out.println("Home Page is displayed");
			}else
				System.out.println("Home Page is not displayed");
		}  
	 
	
		public String getLoginErrorMessage()
		{
			if(errorMessage.isDisplayed())
			{
			return errorMessage.getText();
		    }
			else
		    {
			return null;
		    }
		
	 }
	 public void clickLogoutButton()
	 {
		 if(Logout.isDisplayed())
		 {
	        Logout.click();
		 }else
		 {
			 System.out.println("Logout element not found");
		 } 
	 }
	 public void clickForgotPassword()
	 {
		 if(ForgotPassword.isDisplayed())
		 {
			 ForgotPassword.click();
		 }
		 else
		 {
			 System.out.println("Forgot Password Link is not found");
		 }
     }
	 public String getUsername()
		{
			return username.getText();
		}
	 public String getPassword()
		{
			return password.getText();
		}
		
	 
	 
		 
	 }

