package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestListener implements ITestListener
{
   public static int passCount, failCount, executionCount, skippedCount = 0;


@Override
public void onTestStart(ITestResult result) 
{
	executionCount++;
	Reporter.log(result.getName() + "script execution done.",true);

}

@Override
public void onTestSuccess(ITestResult result) 
{
	passCount++;
	Reporter.log(result.getName() + "script successfully executed.",true);

}

@Override
public void onTestFailure(ITestResult result) 
{
	failCount++;
	Reporter.log(result.getName() + "script failed.",true);
	
	TakesScreenshot ts = (TakesScreenshot) BaseLib.driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./screenshots/login.png");
	
	
	try 
	{
		Files.copy(srcFile, destFile);
	}
	
	catch (IOException e)
	{	
		e.printStackTrace();
	}
	

}

@Override
public void onTestSkipped(ITestResult result) 
{
    skippedCount++;
    Reporter.log(result.getName() + "script skipped.",true);

}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
{


}

@Override
public void onTestFailedWithTimeout(ITestResult result) 
{


}

@Override
public void onStart(ITestContext context) 
{
   Reporter.log("Framework starts at "+new Date(),true);
	
}

@Override
public void onFinish(ITestContext context) 
{
   Reporter.log("Framework ends at ="+new Date(),true);
   Reporter.log("Total number executed scripts are ="+executionCount,true);
   Reporter.log("The passed script is = "+passCount, true);
   Reporter.log("The failed script is = "+failCount, true);
   Reporter.log("The skipped script is = "+skippedCount, true);
}
}
