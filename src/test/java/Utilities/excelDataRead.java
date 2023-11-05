package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelDataRead {
	String TestData_Path="Data.xlsx";
	Workbook book;
	Sheet sheet;
	
	public Object[][] getTestData(String sheetName) throws InvalidFormatException{
		FileInputStream file = null;
		try{
			file= new FileInputStream(TestData_Path);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
