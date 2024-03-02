package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement CampaignNameTextfield;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveButton;

	public WebElement getCampaignNameTextfield() {
		return CampaignNameTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void enterCampaignName(String CampaignName) {
		CampaignNameTextfield.sendKeys(CampaignName);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
}
