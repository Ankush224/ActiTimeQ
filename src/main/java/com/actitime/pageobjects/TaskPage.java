package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TaskPage 
{
	@FindBy(xpath = "//div[contains(text(), \"Tasks\")]")
	private @Getter WebElement clickOnTaskOption;
	
	public TaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
