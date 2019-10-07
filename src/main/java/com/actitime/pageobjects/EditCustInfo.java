package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class EditCustInfo
{
	@FindBy(css = "input[value = \"Delete This Customer\"]")
	private @Getter WebElement deleteBtn;
	
	@FindBy(css = "input[value = \"Delete Customer\"]")
	private @Getter WebElement confirmDeleteBtn;
	
	
	public EditCustInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
