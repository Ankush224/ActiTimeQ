package com.actitime.scripts;


import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.features.TaskFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class TaskTest extends BaseLib
{
	
	@Test
	public void createCustomer()
	{
		ExcelUtilities euu = new ExcelUtilities("./testdata/testdata.xlsx");
		String userName =euu.getDataFromExcel("Sheet1", 3, 1);
		String password = euu.getDataFromExcel("Sheet1", 3, 2);
		String custName = euu.getDataFromExcel("Sheet1", 3, 3);
		
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(userName, password);
		
		TaskFeatures tf = new TaskFeatures(driver);
		tf.clickOnTask();
		tf.createCustomer(custName);	
		tf.verifyCreateCust(custName);
		tf.logout();
		
	}
	
	@Test(dependsOnMethods = {"createCustomer"})
	public void deleteCustomer()
	{
		ExcelUtilities euu = new ExcelUtilities("./testdata/testdata.xlsx");
		String userName =euu.getDataFromExcel("Sheet1", 3, 1);
		String password = euu.getDataFromExcel("Sheet1", 3, 2);
		
		LoginFeatures lf = new LoginFeatures(driver);
		lf.login(userName, password);
		
		String custName = euu.getDataFromExcel("Sheet1", 3, 3);
		
		TaskFeatures tf = new TaskFeatures(driver);
		tf.clickOnTask();
		tf.deleteCustomer(custName);
		tf.verifyDeleteCust(custName);
		tf.logout();
	}
}
