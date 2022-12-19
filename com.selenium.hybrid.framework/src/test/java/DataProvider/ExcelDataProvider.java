package DataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;
	
	public ExcelDataProvider(String excelPath)
	{
		
		try
		{
			wb=new XSSFWorkbook(new FileInputStream(new File(excelPath)));
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to load Excel file "+e);
		}
		
	}
	
	// Method overloading
	public String getStringData(int sheetIndex,int row,int column)
	{
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	public String getStringData(String sheetName,int row,int column)
	{
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	/*
	 *  Create a method which will return number of rows
	 *  Create a method which will read hyperlinkvalues and return as a String
	 * 
	 */
	
	public int getNumericData(String sheetName,int row,int column)
	{
		
		return (int)wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
}
