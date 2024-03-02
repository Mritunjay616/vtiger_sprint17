package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLead {

	public CreatingNewLead(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="salutationtype")
	private WebElement leadsSalutationDropdown;
	
	@FindBy(name="firstname")
	private WebElement leadFirstNameTextfield;
	
	@FindBy(name="lastname")
	private WebElement leadLastNameTextfield;
	
	@FindBy(name="company")
	private WebElement leadCompanyNameTextfield;
	
	@FindBy(xpath="//input[@value=\"T\"]")
	private WebElement assignToGroupRadioButton;
	
	@FindBy(name="assigned_group_id")
	private WebElement leadAssignToDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement leadSaveButton;

	public WebElement getLeadsSalutationDropdown() {
		return leadsSalutationDropdown;
	}

	public WebElement getLeadFirstNameTextfield() {
		return leadFirstNameTextfield;
	}

	public WebElement getLeadlastNameTextfield() {
		return leadLastNameTextfield;
	}

	public WebElement getLeadCompanyNameTextfield() {
		return leadCompanyNameTextfield;
	}

	public WebElement getAssignToGroupRadioButton() {
		return assignToGroupRadioButton;
	}

	public WebElement getLeadAssignToDropdown() {
		return leadAssignToDropdown;
	}

	public WebElement getLeadSaveButton() {
		return leadSaveButton;
	}
	
	public void selectLeadSalutation(String option) {
		Select select=new Select(leadsSalutationDropdown);
		select.selectByVisibleText(option);
	}
	
	public void enterLeadFirstName(String firstName) {
		leadFirstNameTextfield.sendKeys(firstName);
	}
	
	public void enterLeadLastName(String lastName) {
		leadLastNameTextfield.sendKeys(lastName);
	}
	public void enterCompanyName(String companyName) {
		leadCompanyNameTextfield.sendKeys(companyName);
	}
	
	public void clickOnAssignToGroupsRadioButton() {
		assignToGroupRadioButton.click();
	}
	
	public void selectFromAssignToGroupDropDown(String option) {
		Select select = new Select(leadAssignToDropdown);
		select.selectByVisibleText(option);
	}
	
	public void clicOnSaveButton() {
		leadSaveButton.click();
	}
}
