package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class EnterTimeTrackPage 
{

	@FindBy(xpath = "(//td[@class = \"pagetitle\"])[2]")
	private @Getter WebElement enterTimeTrackTxt;
	
	
	@FindBy(xpath = "//td[@class = \"mainContentPadding rightPadding\"]//td//a[text() = \"Create new tasks\"]")
	private @Getter WebElement createNewTaskBtn;
	
	
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
