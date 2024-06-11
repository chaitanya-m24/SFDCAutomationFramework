package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.FileHandlingMethods;

public class OpportunitiesPage {
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// Opportunites view Webelements
	
	@FindBy(xpath="//*[@class='allTabsArrow']")
	public WebElement AllTabs;
	
	@FindBy(xpath="//a[@class='listRelatedObject opportunityBlock title']")
	public WebElement opportunites;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement viewOpportunities;
	
	@FindBy(xpath = "//select[@id='fcf']/option")
	public List<WebElement> opportunitiesDropdownItems;
	
	//create new opportunitypage  WebElements
	
	@FindBy(xpath="//input[@name='new']")
    public WebElement newButton;
	
	@FindBy(xpath="//input[@id='opp3']")
	public WebElement oppName;
	
	@FindBy(xpath="//input[@id='opp4']")
	public WebElement oppAccountName;
	
	@FindBy(xpath="//input[@id='opp9']")
	public WebElement closeDate;
	
	@FindBy(xpath="//select[@id='opp11']")
	public WebElement oppStage;
	
	@FindBy(xpath="//input[@id='opp12']")
	public WebElement oppprobability;
	
	@FindBy(xpath="//select[@id='opp6']")
	public WebElement oppleadSource;
	
	@FindBy(xpath="//input[@id='opp17']")
	public WebElement primaryCampagin;
	
	@FindBy(xpath="//div[@id='datePicker']")
    public WebElement pickdate;
	
	@FindBy(xpath="//tr/td[@onclick='DatePicker.datePicker.selectDate(this);']")
	public WebElement click;
	
	@FindBy(xpath="//input[@name='save']")
	public WebElement saveButton;
	
	@FindBy(xpath="//div[@id='opp3_ileinner']")
	public WebElement opportunityPage;
	
	//Opportunities Report WeElements
	
	@FindBy(xpath="//a[text()='Opportunity Pipeline']")
	public WebElement opportunityPipeline;
	
	@FindBy(xpath="//a[text()='Stuck Opportunities']")
	public WebElement stuckOppurtunity;
	
	@FindBy(xpath="//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")
	public WebElement reportNamePipeline;
	
	@FindBy(xpath="//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")
	public WebElement reportNameStuck;
	
	// Quarterly Summary Report WebElements
	
	@FindBy(xpath="//select[@id='quarter_q']")
	public WebElement selectInterval;
	
	@FindBy(xpath="//select[@id='open']")
	public WebElement selectinclude;
	
	@FindBy(xpath="//input[@value='Run Report']")
	public WebElement runButton;
	
	@FindBy(xpath="//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")
	public WebElement opportunityreport;
	
	
	public void allTabs()
	{
		if(AllTabs.isDisplayed())
		{
			AllTabs.click();
		}
	}
	public boolean isOpportunityPageDisplayed()
	{
		
		return opportunites.isDisplayed();
	}
	public void opportunitesTab()
	{
		if(opportunites.isDisplayed())
		{
			opportunites.click();
		}
	
	}
	
	public boolean isOpportunitesViewDisplayed() throws IOException
	{
		boolean isOpportuntyViewDisplayed=true;
    
		Select dropdown=new Select(viewOpportunities);
		 List<WebElement> dd = dropdown.getOptions();
		 viewOpportunities.click();
		 String[] expectedOpportunitiesView = FileHandlingMethods.readOpportunitiesTestData("opportunities.view").split(",");
		 
		 for (int j = 0; j < dd.size(); j++) {
					String actualOption = dd.get(j).getText();
					if(actualOption.equals(dd)) {
					
						System.out.println("ViewOpportunities : verifyViewOpportunities : Expected option: "+ expectedOpportunitiesView[j]+" Actual option: "+actualOption);
					}
					else
					{
						System.out.println("ViewOpportunities : verfyViewOpportunities : Expected option: "+ expectedOpportunitiesView[j]+" Actual option: "+actualOption);
						//isOpportuntyViewDisplayed = false;
					}
					
				
		    }
		return isOpportuntyViewDisplayed;
		
		
	}
	
	public void newButton()
	{
		if(newButton.isDisplayed())
		{
			newButton.click();
		}
	}
	
	public boolean isOpportunitesPageDisplayed(WebDriver driver,String oname,String aname,String cdate,String stage,String probability,String leadsource,String primarycampagin)
	{
		boolean isOpportunitiesPageName=false;
		oppName.sendKeys(oname);
		oppAccountName.sendKeys(aname);
		closeDate.sendKeys(cdate);
         closeDate.click();
         pickdate.click();
        click.click();
		//closeDate.sendKeys(Keys.ARROW_DOWN);
		Select oppstage=new Select(oppStage);
		oppstage.selectByVisibleText(stage);
		oppStage.sendKeys(stage);
		oppprobability.sendKeys(probability);
		Select oppsource=new Select(oppleadSource);
		oppsource.selectByVisibleText(leadsource);
		oppleadSource.sendKeys(leadsource);
		primaryCampagin.sendKeys(primarycampagin);
		saveButton.click();
		if(opportunityPage.isDisplayed())
		{
			String actualName = opportunityPage.getText();
			if(actualName.contains(oname))
			{
				isOpportunitiesPageName = true;
				
			}else
			{
				System.out.println("OpportunityPage  fail to create");
			}
		}
		return isOpportunitiesPageName;
		
	
		
	}
	
	public boolean isReportPipelinePageDisplayed()
	{ 
		String s = "Opportunity Pipeline";
		 boolean isReportpageDisplayed=true;
		if(opportunityPipeline.isDisplayed())
		{
			opportunityPipeline.click();
			
			String actualName = reportNamePipeline.getText();
			if(actualName.equalsIgnoreCase(s))
			{
				isReportpageDisplayed= true;
				
			}else
			{
				System.out.println("OpportunityReportPage  fail to create");
			}
		}
		return isReportpageDisplayed;
	}
	public boolean isStuckReportpageDisplayed()
	{String s = "Stuck Opportunities";
	 boolean isReportpageDisplayed=true;
	 if(stuckOppurtunity.isDisplayed())
		{
			stuckOppurtunity.click();
			String actualName = reportNameStuck.getText();
		if(actualName.equalsIgnoreCase(s))
		{
			isReportpageDisplayed= true;
			
		}else
		{
			System.out.println("OpportunityReportPage  fail to create");
		}
	}
	return isReportpageDisplayed;
		
	}
	
	public boolean isQuaterlySummaryReportDisplayed(WebDriver driver,String interval,String include)
	{ 
		String s="Opportunity Report";
		boolean isQuaterlyPageDisplayed=false;
		Select oppinterval=new Select(selectInterval);
		oppinterval.selectByVisibleText(interval);
		selectInterval.sendKeys(interval);
		
		Select oppinclude=new Select(selectinclude);
		oppinclude.selectByVisibleText(include);
		selectinclude.sendKeys(interval);
		 runButton.click();
		 
		 if(opportunityreport.isDisplayed())
			{
			
				String actualName = opportunityreport.getText();
			if(actualName.equalsIgnoreCase(s))
			{
				isQuaterlyPageDisplayed= true;
				
			}else
			{
				System.out.println("OpportunityReportPage  fail to create");
			}
		}
		return isQuaterlyPageDisplayed;
		
	}
	

}
