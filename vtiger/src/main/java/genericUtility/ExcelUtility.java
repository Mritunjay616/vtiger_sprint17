package genericUtility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class has generic method to fetch data from Excel Sheet.
 * @author Hp
 */

public class ExcelUtility {

	public String fetchStringDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		/**
		 * This method fetch string data from excel sheet.
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		 return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	public double fetchNumericDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		/**
		 * This method fetch numeric data from excel sheet.
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		 return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	public boolean fetchBooleanDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		/**
		 * This method fetch boolean data from excel sheet.
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		 return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}
	
	public  String fetchDateDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		/**
		 * This method fetch boolean data from excel sheet.
		 * @param sheetName
		 * @param rowNo
		 * @param cellNo
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		 return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue().toString().substring(0,10);
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility e=new ExcelUtility();
			String date = e.fetchDateDataFromExcelSheet("Opportunities", 1, 1);
		System.out.println(date);
	}
	
}
