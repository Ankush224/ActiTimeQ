package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class LoginPage 
{

	WebDriver driver;
	
	@FindBy(name = "username")
	private @Getter WebElement unTxtBx;
	@FindBy (name = "pwd")
	private @Getter WebElement unPwdBx;
	@FindBy (id ="loginButton")
	private @Getter WebElement loginBtn;
	@FindBy (id = "keepLoggedInCheckBox")
	private @Getter WebElement checkBx;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
}
