package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	//this class is used to read the data from excel files
	//One more contractor here, it is used to load the excel file 
	//As soon as we create an object of this class 
	public ExcelDataProvider() {
		File src=new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel File "+ e.getMessage());
		}	
	}
	
	//example method overloading where method name are same, number of parameters are same 
	//type of parameters has changed
	//if we pass the sheetIndex, it will check the sheetindex, based on that 
	//index will read
	public String getStringData(int sheetIndex, int row, int column) 
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int column) 
	{
		//first we have to navigate the sheet
		//use getRow()--which row we want 
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int column) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

	}
}
