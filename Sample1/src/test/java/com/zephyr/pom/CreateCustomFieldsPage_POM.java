package com.zephyr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class CreateCustomFieldsPage_POM 
{
WebDriver driver;
	
	public CreateCustomFieldsPage_POM(WebDriver driver) 
	{
	  this.driver = driver;
	  PageFactory.initElements(LaunchBrowser.driver,this );
	}
	
	/*	****************************************************
	 * Method Name			: 
	 * Purpose				: CreateCustomField() method
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@class='misc-image setting-image']")
	public WebElement adminSetting;
	
	@FindBy(xpath="//*[text()='Administration']")
	public WebElement administration;
	
	@FindBy(xpath="//span[text()='Customizations']")
	public WebElement customizations;
	
	@FindBy(xpath="(//button[text()='Fields'])[3]")
	public WebElement testcaseFields;
	
	@FindBy(xpath="//button[text()='Lock Zephyr access']")
	public WebElement lockZephyrAccess;
	
	@FindBy(xpath="(//button[text()='Yes'])[5]")
	public WebElement confirmLockZephyrAccess;
	
	@FindBy(xpath="//*[@title='Add New Field']")
	public WebElement addNewCustomField;
	
	@FindBy(xpath="//*[@id='displayName']")
	public WebElement customFieldName;
	
	@FindBy(xpath="//*[@id='description']")
	public WebElement customFieldDescription;
	
	@FindBy(xpath="//*[@id='dataType']")
	public WebElement datatypeDropDown;
	
	@FindBy(xpath="//*[@class='picklist-input clearfix']//input")
	//@FindBy(xpath="//*[@id='fields-modal']/div/div/div[2]/zui-modal-body/div[4]/form/div/div[2]/div/div/div[2]/input")
	public WebElement picklistValues;
	
	@FindBy(xpath="//*[@class='cursor-pointer' and text()='Add ']")
	public WebElement addPicklistValues;
	
	@FindBy(xpath="//*[@id='select2-projects-container']")
	public WebElement projectAssociation;
	
	@FindBy(xpath="//*[@id='projectCheck']")
	public WebElement checkAllProject;
	
	@FindBy(xpath="//*[@id='searchableCheckbox']")
	public WebElement searchable;
	
	@FindBy(xpath="//*[@id='fields-modal']/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement saveCustomField;
	
	@FindBy(xpath="//*[@id='enable-zephyr-access']")
	public WebElement enableZephyrAccess;
	
	//@FindBy(xpath="(//button[text()='×'])[5]")
	@FindBy(xpath="//*[@id='fields-modal']/div/div/div[1]/div[2]/button")
	public WebElement closeCustomFieldWindow;
	
	/*	****************************************************
	 * Method Name			: CreateCustomUser()
	 * Purpose				: CreateCustomUser() method
	 * Author				: OPAL
	 * Date Created			: 10/08/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//a[@title='User Setup']")
	public WebElement manageUsers;
	
	@FindBy(xpath="//*[@id='ze-main-app']/resource-management/resource-management-details/div/section/div[2]/button")
	public WebElement addNewUser;
	
	@FindBy(xpath="//*[@id='resource-firstname']")
	public WebElement FirstName;
	
	@FindBy(xpath="//*[@id='resource-lastname']")
	public WebElement LastName;
	
	@FindBy(xpath="//*[@id='resource-type']")
	public WebElement Type;
	
	@FindBy(xpath="//*[@id='resource-roles']")
	public WebElement Role;
	
	@FindBy(xpath="//*[@id='resource-email']")
	public WebElement Email;
	
	@FindBy(xpath="//*[@id='resource-title']")
	public WebElement Title;
	
	@FindBy(xpath="//*[@id='resource-location']")
	public WebElement Location;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement saveNewUser;
	
	public String custom1="//*[@title='";
	 public String custom2="']";
	 
	 public String customField1="//div[text()='";
		public String customField2="']";
		
		@FindBy(xpath="//*[@id='mandotryCheckbox']")
		public WebElement mandatoryChk;
		
		@FindBy(xpath="//input[@id='uniqueCheckbox']")
		public WebElement uniqueCheckBox;
		
	
	
}
