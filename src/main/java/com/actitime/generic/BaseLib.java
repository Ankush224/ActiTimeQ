package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib 
{
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser", "url"})
	public void preCondition(String browserName, String url)
	{
		driver = BrowserFactory.lauchBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(url);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
