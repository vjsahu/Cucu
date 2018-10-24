package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditCustomField_809208 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditCustomField_809208";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	

	@Given("^User is in the Phase page$")
	public void user_is_in_the_Phase_page() throws Throwable 
	{
//		 lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   try
		   {
		   pp=new ProjectPage(driver);
		   bp=new BasePage();
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		   
		   //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"CustomField",1, 6);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"CustomField",1, 6);
		   actual[3]=tr.doubleClickOnRelease(releaseName);
		   actual[4]=tr.addNode(name, desc);
		   
		   bp.waitForElement();
		   actual[5]=tr.doubleClickOnRelease(releaseName);
		   
		   bp.waitForElement();
			String[] phases=new String[1];
			phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"CustomField",1, 6);
			actual[6]=tr.navigateToNode(releaseName, phases);
			 
			for(int i=1;i<=6;i++)
			   {
				   actual[5]=tr.addTestCase();
			   }
			    
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

	@Given("^User selected the multiple test cases$")
	public void user_selected_the_multiple_test_cases() throws Throwable {
	   try
	   {
		String[] testCase=new String[3];
	    testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 1, 0));
	    testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 2, 0));
	    testCase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 3, 0));
		ep=new ExportPage(driver);
		actual[6]=ep.selectMultipleTestCaseFromGrid(testCase);
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

	@When("^User click on Edit and edit the custom field$")
	public void user_click_on_Edit_and_edit_the_custom_field() throws Throwable 
	{
		try
		{
		String text=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
		String longText=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
		String number=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
		String checkBox=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 8, 0);
		String pickupList=Excel_Lib.getData(INPUT_PATH_2,"CustomField", 1 ,5);
		String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"CustomField", 1, 3));
		
		tr.editTestCase();
	    ctc=new CreateTestCasePage(driver);
	    
	    actual[7]=ctc.editCustomFieldsInMultipleTestCase(text, longText, number, checkBox, pickupList, date);
	    actual[8]=ctc.saveMultipleTestCaseEdit();
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

	@Then("^custom field should be edited$")
	public void custom_field_should_be_edited() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	  log.info("Custom Field edited successfully"); 
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
