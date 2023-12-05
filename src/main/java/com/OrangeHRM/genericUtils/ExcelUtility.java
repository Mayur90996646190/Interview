package com.OrangeHRM.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	public String readDataFromExcel(String sheetname, int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String value=sh.getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	
	public void writeDataToExcel(String sheetname, int row, int col, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.createRow(row).createCell(col).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream("");
		wb.write(fos);
		wb.close();
	}
	
	@DataProvider
	public Object[][] getMultipleSetOFData(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow+1][lastCell];
		for(int i=0; i<=lastRow; i++) {
			for(int j=0; j<lastCell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}