package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class ActiveProjAndCust extends BasePage
{
	@FindBy(css = "input[value = \"Create New Customer\"]")
	private @Getter WebElement createCustBtn;
	
	@FindBy(xpath = "//table[@id =\"SuccessMessages\"]//span")
	private @Getter WebElement successMsg;
	
	@FindBy(name = "selectedCustomer")
	private @Getter WebElement dragOptions;
	
	@FindBy(xpath = "//input[contains(@value,\"Show\")]")
	private @Getter WebElement showBtn;
	
	@FindBy(xpath = "(//td[starts-with(@id , \"customerNameCell\")]//a)[1]")
	private @Getter WebElement custName;
	
	public ActiveProjAndCust(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
