package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;


public class LoginTest extends BaseLib
{

	@Test(priority = 1)
	public void validLogin()
	{
		ExcelUtilities eu = new ExcelUtilities("./testdata/testdata.xlsx");
		String userName = eu.getDataFromExcel("Sheet1", 1, 1);
		String password = eu.getDataFromExcel("Sheet1", 1, 2);
		
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(userName, password);
		lf.verifyLogin();	
	}
	
	@Test(priority =2)
	public void invalidLogin()
	{
		ExcelUtilities eu = new ExcelUtilities("./testdata/testdata.xlsx");
		String userName = eu.getDataFromExcel("Sheet1", 2, 1);
		String password = eu.getDataFromExcel("Sheet1", 2, 2);
		
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(userName, password);
		
	}
}
