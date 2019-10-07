package com.actitime.features;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobjects.ActiveProjAndCust;
import com.actitime.pageobjects.CreateCustomer;
import com.actitime.pageobjects.EditCustInfo;
import com.actitime.pageobjects.ProjAndCustPage;
import com.actitime.pageobjects.TaskPage;


public class TaskFeatures 
{
	WebDriver driver;
    TaskPage tp;
    ProjAndCustPage pcp;
    ActiveProjAndCust apac;
    CreateCustomer cc;
    EditCustInfo eci;

   public  TaskFeatures(WebDriver driver)
   {
	   this.driver = driver;
	   tp = new TaskPage(driver);
	   pcp = new ProjAndCustPage(driver);
	   apac = new ActiveProjAndCust(driver);
	   cc = new CreateCustomer(driver);
	   eci = new EditCustInfo(driver);
   }
   
   public void clickOnTask()
   {
	   tp.getClickOnTaskOption().click();  
	   pcp.getProjAndCustOption().click(); 
   }
   
   public void createCustomer(String customerName)
   {
	   apac.getCreateCustBtn().click();
	   cc.getCustomerName().sendKeys(customerName);
	   cc.getCreateCustomerBtn().click();
   }
 
   public void verifyCreateCust(String customerName)
   {
	   String actualMsg = apac.getSuccessMsg().getText();
	   String expMsg = "Customer \""+customerName+"\" has been successfully created.";
	   
	   Assert.assertEquals(actualMsg, expMsg);
	   Reporter.log("Create project verified successfully.",true);
   }
   
   public void deleteCustomer(String custName)
   {
	   Select sel = new Select(apac.getDragOptions());
	   int dragCountNumber =sel.getOptions().size();
	   
	   int j;
	   for(j =0; j<dragCountNumber; j++)
	   {
		  String presentText = sel.getOptions().get(j).getText();
		  String actualText = custName;
		  
		  if(presentText.equalsIgnoreCase(actualText))
		  {
			  break;
		  }
	   }
	   
	   sel.getOptions().get(j).click();
	   apac.getShowBtn().click();
	   apac.getCustName().click();
	   eci.getDeleteBtn().click();
	   eci.getConfirmDeleteBtn().click();
	   Reporter.log("Customer deleteted successfully.");
   }
   
   public void verifyDeleteCust(String custName)
   {
	   String acutalText = apac.getSuccessMsg().getText();
	   String expText = "Customer has been successfully deleted.";
	   
	   Assert.assertEquals(acutalText, expText);
	   
	   Select sel = new Select(apac.getDragOptions());
	   int dragCount =sel.getOptions().size();
	   
	   for(int i =0; i< dragCount; i++)
	   {
		   String actualText =sel.getOptions().get(i).getText();
		  
		   Assert.assertNotEquals(actualText, custName);
	   }
	   
	   System.out.println("Deleted Customer verified sucessfully."); 
   }
   
   public void logout()
   {
	   apac.getLogoutBtn().click();
	   System.out.println("Logout successfully.");
   }
}
