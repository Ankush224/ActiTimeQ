package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginFeatures 
{
	WebDriver driver;
	LoginPage lp;
	EnterTimeTrackPage ettp;
	
	public LoginFeatures(WebDriver driver)
	{
		this.driver = driver;
		lp = new LoginPage(driver);
		ettp = new EnterTimeTrackPage(driver);
	} 
	
	public void login(String userName, String password)
	{
		lp.getUnTxtBx().sendKeys(userName);
		lp.getUnPwdBx().sendKeys(password);
		lp.getLoginBtn().click();	
	}
	
	public void verifyLogin()
	{
		   
		String actualText = "Enter Time-Track";
		String expText = ettp.getEnterTimeTrackTxt().getText();
		   
		Assert.assertEquals(actualText, expText);
		   
		String titleActualText = "actiTIME - Enter Time-Track";
		String titleExpText = driver.getTitle();
		   
		Assert.assertEquals(titleActualText, titleExpText);
		   
		Reporter.log("Home page verified successfully.",true);
	}
}
