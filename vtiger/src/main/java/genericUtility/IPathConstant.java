package genericUtility;
public interface IPathConstant {

	String PROPERTY_FILE_PATH="./src/test/resources/TestData/VtigerPropertiesData.properties";
	                          
	String EXCEL_FILE_PATH="./src/test/resources/TestData/vtigerTestData.xlsx";
	       					
	String SCREENSHOT_FILE_PATH="./src/test/resources/Screenshots/";
	
	
	String LEAD_SHEET_NAME="Leads";
	String ORGANIZATION_SHEET_NAME="Organization";
	String CAMPAIGN_SHEET_NAME="Campaign";
	String OPPORTUNITIES_SHEET_NAME="Opportunities";
	
	int IMPLICIT_WAIT=20;
	int EXPLICIT_WAIT=20;
	
	String JAVASCRIPT_COMMAND_FOR_CLICK="arguments[0].click()";
	
	String DATABASE_URL="jdbc:mysql://localhost:3306/vtiger2";
	String DATABASE_USERNAME="root";
	String DATABASE_PASSWORD="root";
}
