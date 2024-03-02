package opportunity_Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CampaignInformationPage;
import pomRepository.CampaignPage;
import pomRepository.CreatingNewCampaignPage;
import pomRepository.CreatingNewOpportunityPage;
import pomRepository.CreatingNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.OpportunitiesPage;
import pomRepository.OpportunityInformationPage;
import pomRepository.OrganizationInformationPage;
import pomRepository.OrganizationPage;



@Listeners(genericUtility.ListernersImplimentationClass.class)
public class CreateOpportunitiesTest extends BaseClass {

	@Test(retryAnalyzer = genericUtility.RetryAnalyzerImplimentationClass.class, groups = "regression")
public void createOpportunitiesWithOrganizationNameAndVerifyTest() throws EncryptedDocumentException, IOException  {
		
		//TestData
		String organizationName = eutils.fetchStringDataFromExcelSheet(IPathConstant.ORGANIZATION_SHEET_NAME, 1, 0)+jutils.generateRandomNo(895);
		String campaignName = eutils.fetchStringDataFromExcelSheet(IPathConstant.CAMPAIGN_SHEET_NAME, 1, 0);
		String opportunitiesName = eutils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 0);
		String   opportunitiesClosureDate = eutils.fetchDateDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 1);
		String organizationLoolUpPageTitle=eutils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 2);
		String CampaignLookUpPageTitle=eutils.fetchStringDataFromExcelSheet(IPathConstant.OPPORTUNITIES_SHEET_NAME, 1, 3);

	//ObjectCreation
	HomePage home = new HomePage(driver);
	OrganizationPage organization=new OrganizationPage(driver);
	CreatingNewOrganizationPage createOrganization=new CreatingNewOrganizationPage(driver);
	OrganizationInformationPage organizationInfo=new OrganizationInformationPage(driver);
	
	CampaignPage campaign=new CampaignPage(driver);
	CreatingNewCampaignPage createCampaign=new CreatingNewCampaignPage(driver);
	CampaignInformationPage campaignInfo=new CampaignInformationPage(driver);
	
	OpportunitiesPage opportunity=new OpportunitiesPage(driver);
	CreatingNewOpportunityPage createOpportunity=new CreatingNewOpportunityPage(driver);
	OpportunityInformationPage opportunityInfo=new OpportunityInformationPage(driver);
	
	
	//Test Script
	home.clickOnOrganizationModule();
	
	organization.clickOnOrganizationPlusButton();
	createOrganization.enterOrganizationName(organizationName);
	createOrganization.clickOnSaveButton();
	String actualOrganizationName = organizationInfo.verifyOrganizationInformation(organizationName);
	Assert.assertTrue(actualOrganizationName.contains(organizationName));
	System.out.println("PASS: The organization has been created");
	
	
	home.clickOnCampaignModule();

	campaign.clickOnCampaignPlusButton();
	createCampaign.enterCampaignName(campaignName);
	createCampaign.clickOnSaveButton();
	String actualCampaignName = campaignInfo.verifyCampaignName(campaignName);
	Assert.assertTrue(actualCampaignName.contains(campaignName));
	System.out.println("Pass: The campaign has been created");
	
	
	home.clickOnOpportunitiesModule();
	opportunity.clickOnOpportunitiesPlusButton();
	createOpportunity.enterOpportunityName(opportunitiesName);
	createOpportunity.enterOrganizationDetailInOrganizationLookUpPage(organizationLoolUpPageTitle, organizationName);	
	createOpportunity.enterCampaignDetailInCampaignLookUpPage(CampaignLookUpPageTitle, campaignName);
	createOpportunity.enterclosingDate(opportunitiesClosureDate);
	createOpportunity.clickOnSaveButton();
	
	String actualOpportunityName = opportunityInfo.verifyOpportunityInformation(opportunitiesName);
	Assert.assertTrue(actualOpportunityName.contains(opportunitiesName));
	System.out.println("PASS: The opportunity has been created");
}
}
