package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditCustomfield_809218 extends LaunchBrowser 
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditCustomfield_809218";
	
	boolean[] actual=new boolean[2];
	SoftAssert soft=new SoftAssert();
	
	@When("^User click on edit and edit custom field of type number$")
	public void user_click_on_edit_and_edit_custom_field_of_type_number() throws Throwable 
	{
		try
		{
			tr=new TestRepositoryPage(driver);
		String text=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
		String longText=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
		String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"CustomField", 1, 2));
		String checkBox=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 4);
		String pickupList=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8 ,5);
		String date=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 5);
		tr.editTestCase();
	   ctc=new CreateTestCasePage(driver);
	   actual[0]=ctc.editCustomFieldsInMultipleTestCase(text, longText, number, checkBox, pickupList, date);
	   actual[1]=ctc.saveMultipleTestCaseEdit();
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

	@Then("^custom field of type number should be modified$")
	public void custom_field_of_type_number_should_be_modified() throws Throwable 
	{
		try
		{
			
			for(int k=0;k<=actual.length-1;k++)
	          {
	           soft.assertEquals(actual[k], true);
	          }
	          soft.assertAll();
	    log.info("Custom field of type number edited successfully");
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
