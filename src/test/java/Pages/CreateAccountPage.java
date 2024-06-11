package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;

public class CreateAccountPage extends BasePage {
	public CreateAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//*[@class='allTabsArrow']")
public WebElement AllTabs;

@FindBy(xpath="//*[@class='listRelatedObject accountBlock title']")
public WebElement Account;

@FindBy(xpath="//input[@name='new']")
public WebElement NewButton;

@FindBy(xpath="//input[@id='acc2']")
public WebElement AccountName;

 @FindBy(xpath="//div[@id='acc2_ileinner']")
public WebElement AccountNameDisplayed;

@FindBy(xpath="//select[@id='acc6']")
public WebElement Type;

@FindBy(xpath="//select[@id='00Naj000001j63u']")
public WebElement Priority;

@FindBy(xpath="//input[@name='save']")
public WebElement SaveButton;

@FindBy(xpath="//*[@class='topName']")
public WebElement IsAccountPageDisplaed;

//Create New View Account WebElements

@FindBy(xpath="//a[text()='Create New View']")
public WebElement CreateNewViewAccount;

@FindBy(xpath="//input[@id='fname']")
public WebElement ViewName;

@FindBy(xpath ="//span[@id='userNavLabel']")
public WebElement username;

@FindBy(xpath="//input[@id='devname']")
public WebElement ViewUniqueName;

@FindBy(xpath="//input[@name='save']")
public WebElement Save;

@FindBy(xpath="//select[@name='fcf']")
public WebElement IsViewAccountDisplayed;

//Edit view Name
@FindBy(xpath="//input[@id='fname']")
public WebElement EditName;

@FindBy(xpath="//a[text()='Edit']")
public WebElement EditButton;

@FindBy(xpath="//select[@id='fcol1']")
public WebElement FieldName;

@FindBy(xpath="//select[@id='fop1']")
public WebElement Operator;

@FindBy(xpath="//select[@name='fcf']")
public WebElement SelectViewAccount;

@FindBy(xpath="//input[@id='fval1']")
public WebElement Value;

//Merge Accounts WebElements

@FindBy(xpath="//a[text()='Merge Accounts']")
public WebElement MergeAccountButton;

@FindBy(xpath="//input[@id='srch']")
public WebElement SearchAccounts;

@FindBy(xpath="//input[@value='Find Accounts']")
public WebElement SearchButton;

@FindBy(xpath="//input[@name='goNext']")
public WebElement NextButton;

@FindBy(xpath="//input[@name='save']")
public WebElement MergeSave;

//Reports

@FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")
public WebElement AccountsActivity30Days;

@FindBy(xpath="//img[@id='ext-gen148']")
public WebElement DateField;

@FindBy(xpath="//input[@id='ext-gen20']")
public WebElement ChooseDateField;

@FindBy(xpath="//img[@id='ext-gen152']")
public WebElement FromDate;

@FindBy(xpath="//button[@id='ext-gen277']")
public WebElement Ftoday;

@FindBy(xpath="//input[@id='ext-gen154']")
public WebElement ToDate;

@FindBy(xpath="//button[@id='ext-gen300']")
public WebElement Ttoday;

@FindBy(xpath="//*[@id='ext-gen49']")
public WebElement SaveReport;

@FindBy(xpath="//input[@name='reportName']")
public WebElement ReportName;

@FindBy(xpath="//input[@name='reportDevName']")
public WebElement ReportUniqueName;

@FindBy(xpath="//button[@id='ext-gen295']")
public WebElement SaveandRunReport;

@FindBy(xpath="//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")
public WebElement Reportname;

public void allTabs()
{
	if(AllTabs.isDisplayed())
	{
		AllTabs.click();
	}
}
public boolean isAccountPageDisplayed()
{
	
	return Account.isDisplayed();
}
public void accountTab()
{
	if(Account.isDisplayed())
	{
		Account.click();
	}

}

public void selectNewContact(WebDriver driver)
{
	if(CommonUtils.waitForElement(driver,NewButton))
		NewButton.click();
}

public boolean isAccountNameDisplayed(WebDriver driver,String accountname,String type,String priority)
{
	boolean isAccountName= false;
	
 	AccountName.sendKeys(accountname);	
	Select select = new Select(Type);
	select.selectByVisibleText(type);
	Type.sendKeys(type);
	Select selectp = new Select(Priority);
	selectp.selectByVisibleText(priority);
 	Priority.sendKeys(priority);
 	SaveButton.click();
 	if(IsAccountPageDisplaed.isDisplayed())
	{
		String actualName = IsAccountPageDisplaed.getText();
		if(actualName.contains(accountname))
		{
			isAccountName = true;
			
		}else
		{
			System.out.println("Account fail to create");
		}
	}
 	return isAccountName;
}

public void createNewViewAccount(WebDriver driver)
{
	if(CommonUtils.waitForElement(driver,CreateNewViewAccount))
		CreateNewViewAccount.click();
}
public boolean isViewAccountDisplayed(WebDriver driver,String viewname,String viewuniquename)
{
	boolean isViewAccountName= false;
	
 	ViewName.sendKeys(viewname);
 	ViewUniqueName.sendKeys(viewuniquename);
 	Save.click();
 	if(IsViewAccountDisplayed.isDisplayed())
	{
		String actualName = IsViewAccountDisplayed.getText();
		if(actualName.contains(viewname))
		{
			isViewAccountName = true;
			
		}else
		{
			System.out.println("View fail to create");
		}
	}
 	return isViewAccountName;
   }

public boolean isEditViewAccountDisplayed(WebDriver driver,String viewname,String ename,String field,String operator,String value)
{
boolean isEditViewAccountName=false;
Select selectviewname = new Select(SelectViewAccount);
selectviewname.selectByVisibleText(viewname);
SelectViewAccount.sendKeys(viewname);
EditButton.click();
EditName.sendKeys(ename);
Select selectfield = new Select(FieldName);
selectfield.selectByVisibleText(field);
FieldName.sendKeys(field);
Select selectoperator= new Select(Operator);
selectoperator.selectByVisibleText(operator);
Operator.sendKeys(operator);
Value.sendKeys(value);
Save.click();
if(SelectViewAccount.isDisplayed())
{
	String actualName = SelectViewAccount.getText();
	if(actualName.contains(ename))
	{
		isEditViewAccountName = true;
		
	}else
	{
		System.out.println("View fail to create");
	}
}

return isEditViewAccountName;
}

public void clickOnMergeAccountButton(WebDriver driver)
{
	CommonUtils.mouseHover(driver,MergeAccountButton );
if(MergeAccountButton.isDisplayed())
{
	MergeAccountButton.click();
}
}
public boolean isMergeAccountsDisplayed(WebDriver driver,String mergeaccountname)
{
boolean isAccountMerged=false;
MergeAccountButton.click();
SearchAccounts.sendKeys(mergeaccountname);
// if(count(mergeaccountname)>2)
return isAccountMerged;

}

public boolean isReportDisplayed(WebDriver driver,String DateField,String rname,String runiquename)
{
boolean isReportDisplayed=false;
AccountsActivity30Days.click();
Select select = new Select(ChooseDateField);
select.selectByVisibleText(DateField);
ChooseDateField.sendKeys(DateField);
FromDate.click();
//Ftoday.click();
//CommonWaits.mouseHover(driver,Ftoday);
if(Ftoday.isDisplayed())
{
	Ftoday.click();
}

ToDate.click();
Ttoday.click();
SaveReport.click();
ReportName.sendKeys(rname);
ReportUniqueName.sendKeys(runiquename);
if(ReportName.isDisplayed())
{
	String actualName = ReportName.getText();
	if(actualName.contains(rname))
	{
		isReportDisplayed = true;
		
	}else
	{
		System.out.println("Account failed to create");
	}
}



return isReportDisplayed;

}
}