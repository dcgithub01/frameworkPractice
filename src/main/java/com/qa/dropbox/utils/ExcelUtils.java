package com.qa.dropbox.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	private static Workbook book;
	private static Sheet sheet;

private static String TEST_DATA_SHEET_PATH= ".\\src\\main\\java\\com\\qa\\dropbox\\testdata\\contactList.xlsx";

	public static  Object[][] getTestData(String sheetName)
	{
	 Object data [][]= null;
	{
		try {
			FileInputStream ip =new FileInputStream(TEST_DATA_SHEET_PATH);
			book=WorkbookFactory.create(ip);
			sheet=book.getSheet(sheetName);
		 data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];	
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j =0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
				
		
	}
}
}
