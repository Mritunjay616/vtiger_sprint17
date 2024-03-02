package pomRepository;

import java.awt.event.ActionEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This is an object repository to store elements belonging to Homepage of the vtiger Application
 * @author Mritunjay
 */

public class HomePage {
	WebDriver driver;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
	this.driver=driver;
}
@FindBy(linkText = "Leads")
private WebElement leadsModule;

@FindBy(linkText = "Organizations")
private WebElement organizationModule;

@FindBy(linkText = "Contacts")
private WebElement contactsModule;

@FindBy(linkText = "Opportunities")
private WebElement OpportunitiesModule;

@FindBy(linkText = "Products")
private WebElement ProductsModule;

@FindBy(linkText = "More")
private WebElement MoreDropdown;

@FindBy(linkText = "Campaigns")
private WebElement CampaignsModule;

@FindBy(linkText = "Vendors")
private WebElement VendorsModule;

@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
private WebElement administratorIcon;

@FindBy(linkText = "Sign Out")
private WebElement signoutOption;

public WebElement getLeadsModule() {
	return leadsModule;
}

public WebElement getOrganizationModule() {
	return organizationModule;
}

public WebElement getContactsModule() {
	return contactsModule;
}

public WebElement getOpertunitiesModule() {
	return OpportunitiesModule;
}

public WebElement getProductsModule() {
	return ProductsModule;
}

public WebElement getMoreDropdown() {
	return MoreDropdown;
}

public WebElement getCampaignsModule() {
	return CampaignsModule;
}

public WebElement getVendorsModule() {
	return VendorsModule;
}

public WebElement getAdministratorIcon() {
	return administratorIcon;
}

public WebElement getSignoutOption() {
	return signoutOption;
}

public void clickOnLeadsModule() {
	leadsModule.click();
}
public void clickOnOrganizationModule() {
	organizationModule.click();
}
public void clickOnContactsModule() {
	contactsModule.click();
}
public void clickOnOpportunitiesModule() {
	OpportunitiesModule.click();
}

public void clickOnCampaignModule() {
	Actions action=new Actions(driver);
	
	action.moveToElement(MoreDropdown).perform();
	action.click(CampaignsModule).perform();
}

public void clickOnVendorModule() {
	Actions action=new Actions(driver);
	
	action.moveToElement(MoreDropdown).perform();
	action.click(VendorsModule).perform();
}
public void signoutAction() {
	Actions action=new Actions(driver);
	
	action.moveToElement(administratorIcon).perform();
	action.click(signoutOption).perform();
}
}

