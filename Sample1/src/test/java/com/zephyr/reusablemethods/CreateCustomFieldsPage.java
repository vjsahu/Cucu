package com.zephyr.reusablemethods;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.zephyr.pom.CreateCustomFieldsPage_POM;

public class CreateCustomFieldsPage extends CreateCustomFieldsPage_POM
{
	WebDriver driver=null;
	   public Logger log;
	   BasePage bp;
	   TestRepositoryPage tr;

	public CreateCustomFieldsPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		log=Logger.getLogger(this.getClass());
	    Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}

	/*	****************************************************
	 * Method Name			: moveToCustomFields()
	 * Purpose				: move to the Custom Fields
	 * Author				: OPAL
	 * Date Created			: 10/08/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean moveToCustomFields() throws Exception
	{
		try
		{
			bp=new BasePage();
			//adminSetting.click();
			//log.info("Pass - Clicked On Administartion Setting Successfully");
			bp.waitForElement();
			administration.click();
			log.info("Pass - Clicked On Administartion Successfully");
			bp.waitForElement();
			customizations.click();
			log.info("Pass - Clicked On Customizations Option Successfully");
			bp.waitForElement();
			testcaseFields.click();
			log.info("Pass - Clicked On Fields Option in Testcases Division Successfully");
			bp.waitForElement();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: lockZephyr()
	 * Purpose				: Locks the zephyr application stop access for other users
	 * Author				: OPAL
	 * Date Created			: 10/08/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	public boolean lockZephyrAccess() throws Exception
	{
		try
		{
			bp=new BasePage();
			lockZephyrAccess.click();
			bp.waitForElement();
			confirmLockZephyrAccess.click();
			bp.waitForElement();
			log.info("Pass - Manager locked the Zephyr Access for other users Successfully");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	/*	****************************************************
	 * Method Name			: createCustomFields()
	 * Purpose				: Creates new custom fields for the Testcase
	 * Author				: OPAL
	 * Date Created			: 11/08/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean createCustomFields(String customfieldName, String customfieldDescription, String dataType,
			String piclistValues[], String allProject, String projectName, String searchableCheck, String unique,
			String mandatory) throws Exception {
		try {
			bp = new BasePage();
			addNewCustomField.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Add new Custom Field");

			customFieldName.click();
			bp.waitForElement();
			customFieldName.sendKeys(customfieldName);
			bp.waitForElement();
			log.info("Pass - New CustomField Name entered Successfully");

			customFieldDescription.click();
			bp.waitForElement();
			customFieldDescription.sendKeys(customfieldDescription);
			bp.waitForElement();
			log.info("Pass - New CustomField Description is entered Successfully");

			Select sel = new Select(datatypeDropDown);
			sel.selectByVisibleText(dataType);
			if (dataType.equals("Picklist")) {
				picklistValues.click();
				bp.waitForElement();
				log.info("Pass - Picklist datatype is checked Successfully");
				int k = piclistValues.length;
				for (int i = 0; i <= k - 1; i++) {
					picklistValues.sendKeys(piclistValues[i]);
					bp.waitForElement();
					addPicklistValues.click();
					bp.waitForElement();
					log.info("Pass - Picklist Values are added Successfully");
				}
			}
			bp.waitForElement();
			log.info("Pass - Data type '" + dataType + "' Selected Successfully");

			if (allProject.equals("allProject")) {
				checkAllProject.click();
				bp.waitForElement();
				log.info("Pass - Checkbox is checked for '" + allProject + "' in Custom Fields");
			} else {
				projectAssociation.click();
				bp.waitForElement();
				Actions a1 = new Actions(driver);
				a1.sendKeys(projectName).sendKeys(Keys.ENTER).build().perform();
				// projectAssociation.sendKeys(projectName);
				log.info("Pass - Selected the '" + projectName + "' in Project Association");
			}

			if (searchableCheck.equals("searchable")) {
				searchable.click();
				bp.waitForElement();
				log.info("Pass - Checkbox is checked for '" + searchableCheck + "' in Custom Fields");
			} else {
				log.info("Pass - 'Searchable' cant be Applicable for Number Datatype");
			}

			if (unique.equals("Unique")) {
				uniqueCheckBox.click();
				bp.waitForElement();
				log.info("Pass - Unique is checked for '" + customfieldName + "' in Custom Fields");
			}

			if (mandatory.equals("Mandatory")) {
				mandatoryChk.click();
				bp.waitForElement();
				log.info("Pass - Mandatory is checked for '" + customfieldName + "' in Custom Fields");
			}
			bp.waitForElement();
			saveCustomField.click();
			bp.waitForElement();
			bp.waitForElement();
			log.info("Pass - Custom Field is Created with '" + dataType + "' Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: moveTocreateCustomUser()
	 * Purpose				: Creates new custom fields for the Testcase
	 * Author				: OPAL
	 * Date Created			: 11/08/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean moveToCreateCustomUser() throws Exception
	{
		try
		{
			bp=new BasePage();
			adminSetting.click();
			bp.waitForElement();
			log.info("Pass - Clicked On Administartion Setting Successfully");
			administration.click();
			bp.waitForElement();
			log.info("Pass - Clicked On Administartion Successfully");
			manageUsers.click();
			bp.waitForElement();
			log.info("Pass - Clicked On manage Users Successfully");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: createCustomUser()
	 * Purpose				: Creates new custom fields for the Testcase
	 * Author				: OPAL
	 * Date Created			: 11/08/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean createCustomUser(String firstName,String lasTName,String type,String role,String email,String title,String location) throws Exception
	{
		try
		{
			bp=new BasePage();
			addNewUser.click();
			bp.waitForElement();
			log.info("Pass - Clicked On Add new User Successfully");
			FirstName.sendKeys(firstName);
			bp.waitForElement();
			log.info("Pass - Entered FirstName Successfully");
			LastName.sendKeys(lasTName);
			bp.waitForElement();
			log.info("Pass - Entered LastNmae Successfully");
			Select TYPE=new Select(Type);
			TYPE.selectByVisibleText(type);
			bp.waitForElement();
			log.info("Pass - Selected Type Successfully");
			Select ROLE=new Select(Role);
			ROLE.selectByVisibleText(role);
			bp.waitForElement();
			log.info("Pass - Selected Role Successfully");
			Email.sendKeys(email);
			bp.waitForElement();
			log.info("Pass - Entered Email Successfully");
			Title.sendKeys(title);
			bp.waitForElement();
			log.info("Pass - Entered Title Successfully");
			Location.sendKeys(location);
			bp.waitForElement();
			log.info("Pass - Entered Location Successfully");
			saveNewUser.click();
			bp.waitForElement();
			log.info("Pass - New User is Created Successfully");
			return true;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean checkAvailableCustomFields(String customFields) throws Exception
	{
	try
		{
          try
			{
	  WebElement customFieldName=driver.findElement(By.xpath(customField1+customFields+customField2));
	  
	  boolean res=customFieldName.isDisplayed();
	  System.out.println(res);
	  String customFieldText=customFieldName.getText();
	 
	  if(customFields.equals(customFieldText))
	  {
		  System.out.println("Custom Field-"+customFields+"- already present in project");
	  }
	  
	 }
	   
	    catch(NoSuchElementException e)
		{
			System.out.println("Custom Field-"+customFields+" is not present");
			return false;
			
		}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	
	
}
	

}
