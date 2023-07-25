package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	// for sheet path
	public static final String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/OpenCartTestdata.xlsx";
	private static Workbook book;
	private static Sheet sheet;

// created method and made static no need create object
	public static Object[][] getTestData(String sheetName) {

		System.out.println("Reading data from Sheet: " + sheetName);
		// as sheet in row and column
		Object data[][] = null;

		// to read data from file
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			// for to load file to java
			book = WorkbookFactory.create(ip);

			// to get particular sheet
			sheet = book.getSheet(sheetName);

			// intilaise the object array with size
			// sheet.getLastRowNum()> for no of rows
			// sheet.getRow(0).getLastCellNum> for no of columns
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// extract data
			// for row
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				// for column
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
					// this will go to cell and pick data ad convert it to string
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}

}
