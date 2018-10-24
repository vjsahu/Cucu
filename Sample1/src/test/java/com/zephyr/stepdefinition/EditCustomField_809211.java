package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditCustomField_809211 extends LaunchBrowser 
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditCustomField_809211";
	
	boolean[] actual=new boolean[2];
	SoftAssert soft=new SoftAssert();
	
@When("^User click on edit and edit custom field of types checkbox$")
public void user_click_on_edit_and_edit_custom_field_of_types_checkbox() throws Throwable
{
	try
	{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		tr.editTestCase();
	String text=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
	String longText=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
	String number=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
	String checkBox=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 1, 4);
	String pickupList=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8 ,5);
	String date=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
	
   ctc=new CreateTestCasePage(driver);
   
   actual[0]=ctc.editCustomFieldsInMultipleTestCase(text, longText, number,checkBox, pickupList, date);
   actual[1]=ctc.saveMultipleTestCaseEdit();
   bp.waitForElement();
	}
	
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@Then("^custom field should be edited successfully$")
public void custom_field_should_be_edited_successfully() throws Throwable
{
	try
	{
		for(int k=0;k<=actual.length-1;k++)
        {
         soft.assertEquals(actual[k], true);
        }
        soft.assertAll();
	log.info("Custom field of type checkbox is checked");
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
	}
}




