package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class CreateCustomer 
{
	@FindBy(name = "name")
	private @Getter WebElement customerName;
	
	@FindBy(name = "createCustomerSubmit")
	private @Getter WebElement createCustomerBtn;
	
	
	public CreateCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

}
