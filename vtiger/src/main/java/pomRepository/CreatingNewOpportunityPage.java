package pomRepository;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewOpportunityPage {
	
	WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name="potentialname")
	private WebElement OpportunityNameTextfield;
	
	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[1]")
	private WebElement organizationsLookUpButton;
	
	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[2]")
	private WebElement campaignSourceLookUpButton;
	
	@FindBy(id="search_txt")
	private WebElement organizationLookupPageSearchTextField;
	
	@FindBy(xpath = "//input[@class=\"crmbutton small create\"]")
	private WebElement organizationLookupPageSearchButton;
	
	@FindBy(id="search_txt")
	private WebElement campaignSourcePageLookupPageSearchTextField;
	
	@FindBy(name="search")
	private WebElement campaignSourcePageLookupPageSearchButton;
	
	@FindBy(name="closingdate")
	private WebElement closingDateCalenderTextField;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement OpportunitySaveButton;
	
	

	public WebElement getOpportunityNameTextfield() {
		return OpportunityNameTextfield;
	}

	public WebElement getOrganizationsLookUpButton() {
		return organizationsLookUpButton;
	}

	public WebElement getCampaignSourceLookUpButton() {
		return campaignSourceLookUpButton;
	}
	public WebElement getOrganizationLookupPageSearchTextField() {
		return organizationLookupPageSearchTextField;
	}

	public WebElement getOrganizationLookupPageSearchButton() {
		return organizationLookupPageSearchButton;
	}

	public WebElement getCampaignSourcePageLookupPageSearchTextField() {
		return campaignSourcePageLookupPageSearchTextField;
	}

	public WebElement getCampaignSourcePageLookupPageSearchButton() {
		return campaignSourcePageLookupPageSearchButton;
	}
	public WebElement getClosingDateCalenderTextField() {
		return closingDateCalenderTextField;
	}

	public WebElement getOpportunitySaveButton() {
		return OpportunitySaveButton;
	}

	
	
	
	
	
	
	public void enterOpportunityName(String OpportunityName) {
		OpportunityNameTextfield.sendKeys(OpportunityName);
	}
	
	public void enterOrganizationDetailInOrganizationLookUpPage(String titleOfThePageToSwitch, String organizationName) {
		String parentWindowTitle = driver.getTitle();
		
		organizationsLookUpButton.click();
		WebDriverUtility wUtils= new WebDriverUtility();
		wUtils.switchToChildBrowser(driver, titleOfThePageToSwitch);
		organizationLookupPageSearchTextField.sendKeys(organizationName);
		organizationLookupPageSearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
		wUtils.switchToChildBrowser(driver, parentWindowTitle);
	}
	
	public void enterCampaignDetailInCampaignLookUpPage(String titleOfTheWindowToSwitch, String campaignName) {
		String parentWindowTitle = driver.getTitle();
		
		campaignSourceLookUpButton.click();
		WebDriverUtility wUtils= new WebDriverUtility();
		wUtils.switchToChildBrowser(driver, titleOfTheWindowToSwitch);
		campaignSourcePageLookupPageSearchTextField.sendKeys(campaignName);
		campaignSourcePageLookupPageSearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		wUtils.switchToChildBrowser(driver, parentWindowTitle);
	}
	
	public void enterclosingDate(String dateInYYYY_MM_DD_Format) {
		closingDateCalenderTextField.sendKeys(dateInYYYY_MM_DD_Format);
	}
	
	public void clickOnSaveButton() {
		OpportunitySaveButton.click();
	}

}
