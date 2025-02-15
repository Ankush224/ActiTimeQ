package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class ProjAndCustPage 
{

	@FindBy(xpath = "//a[text() = \"Projects & Customers\"]")
	private @Getter WebElement projAndCustOption;
	
	
	public ProjAndCustPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
}
