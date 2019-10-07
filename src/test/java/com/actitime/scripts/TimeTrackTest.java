package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.features.TimeTrackFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class TimeTrackTest extends BaseLib
{
	@Test
	public void createTask()
	{
		ExcelUtilities euu = new ExcelUtilities("./testdata/testdata.xlsx");
		String userName =euu.getDataFromExcel("Sheet1", 3, 1);
		String password = euu.getDataFromExcel("Sheet1", 3, 2);
		
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(userName, password);
		
		TimeTrackFeatures ttf = new TimeTrackFeatures(driver);
		ttf.clickOnCreateNewTask();
		
	}
}
