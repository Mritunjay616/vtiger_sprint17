package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextfield;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveButton;

	public WebElement getOrganizationNameTextfield() {
		return organizationNameTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void enterOrganizationName(String OrganizationName) {
		organizationNameTextfield.sendKeys(OrganizationName);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
}
