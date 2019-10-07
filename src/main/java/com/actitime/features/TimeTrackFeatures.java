package com.actitime.features;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import com.actitime.pageobjects.EnterTimeTrackPage;

public class TimeTrackFeatures 
{
	WebDriver driver;
	
	EnterTimeTrackPage ettp;
	
	public TimeTrackFeatures(WebDriver driver)
	{
		this.driver = driver;
		ettp = new EnterTimeTrackPage(driver);
	}
	
	public void clickOnCreateNewTask()
	{
		ettp.getCreateNewTaskBtn().click();
		int windowTabCount =driver.getWindowHandles().size();
		System.out.println(windowTabCount);
		
	//	RemoteWebDriver rwb = new RemoteWebDriver((Capabilities) driver);
	//	SessionId session = rwb.getSessionId();
	//	System.out.println(session);
	}
}
