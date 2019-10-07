package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtilities
{
    WebDriver driver;
	String filepath;
	
	
	public ExcelUtilities(String filepath)
	{
		this.filepath = filepath;
	}
	
	public String getDataFromExcel(String sheet, int row, int cell)
	{
		String value = null;
		
		try
		{
			File file = new File(filepath);
			FileInputStream fis = new FileInputStream(file);
			
			Workbook wb = WorkbookFactory.create(fis);
			Cell cl = wb.getSheet(sheet).getRow(row).getCell(cell);
			
			
			switch (cl.getCellType())
			{
			case STRING:
				value = cl.getStringCellValue();
				break;
				
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cl))
				{
					SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
					value=sdf.format(cl.getDateCellValue());
				}
				else
				{
				    long lg=(long) cl.getNumericCellValue();
				    value = Long.toString(lg);
				}
				
				break;
				
			case BOOLEAN:
				boolean bl = cl.getBooleanCellValue();
				value = Boolean.toString(bl);
				break;
				
			default:
				break;
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		
		return value;
	}
}
