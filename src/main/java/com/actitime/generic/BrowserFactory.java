package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
  
	static WebDriver driver;

	public static WebDriver lauchBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
	       System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
	       driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       driver.navigate().to("http://127.0.0.1/login.do");
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		   System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		   driver = new FirefoxDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.navigate().to("http://127.0.0.1/login.do");
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
		   System.setProperty("webdriver.ie.driver", "./exefiles/IEDriverServer.exe");
		   driver = new InternetExplorerDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.navigate().to("http://127.0.0.1/login.do");
		}
		
		return driver;
	}
	
}
