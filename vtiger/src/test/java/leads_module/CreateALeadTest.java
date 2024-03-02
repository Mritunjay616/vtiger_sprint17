package leads_module;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CreatingNewLead;
import pomRepository.HomePage;
import pomRepository.LeadsInformationPage;
import pomRepository.LeadsPage;

public class CreateALeadTest extends BaseClass {
	@Test(groups = "smoke")
	public void toCreateALeadAndToVerifyTheLeadDetails() throws EncryptedDocumentException, IOException, SQLException{
		
		//TestData
		String leadSalutation = eutils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 0);
		String leadFirstName = eutils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = eutils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		String leadCompanyName = eutils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 3);
		String leadAssignToGroupOption = eutils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 4);
		
		
		//object Creation Statement of all pom classes.
		HomePage home = new HomePage(driver);
		LeadsPage leads = new LeadsPage(driver);
		CreatingNewLead createLead = new CreatingNewLead(driver);
		LeadsInformationPage leadInfo = new LeadsInformationPage(driver);
		
		
		//Actual Test Script
		home.clickOnLeadsModule();
		leads.clickonleadsPlusButton();
		createLead.selectLeadSalutation(leadSalutation);
		createLead.enterLeadFirstName(leadFirstName);
		createLead.enterLeadLastName(leadLastName);
		createLead.enterCompanyName(leadCompanyName);
		createLead.clickOnAssignToGroupsRadioButton();
		createLead.selectFromAssignToGroupDropDown(leadAssignToGroupOption);
		createLead.clicOnSaveButton();
		
		String actualLeadInfo = leadInfo.verifyLeadInformation(leadFirstName, leadLastName);
		Assert.assertTrue(actualLeadInfo.contains(leadLastName));
		System.out.println("PASS:The lead has been created");
		
		System.out.println(dutils.fetchDataFromDatabase(connection, "select * from lead;"));
		
	}
}
