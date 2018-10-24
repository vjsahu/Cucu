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

public class EditTestCase_809040 extends LaunchBrowser 
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809040";

	boolean[] actual=new boolean[2];
	SoftAssert soft=new SoftAssert();
	
	@When("^User Select the test case$")
	public void user_Select_the_test_case() throws Throwable 
	{
		try
		{
		String[] name=new String[1];
		name[0]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 3, 9);
		tr=new TestRepositoryPage(driver);
		
		actual[0]=tr.addTestCase();
		//actual[0]=tr.selectTestCase(name);
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

	@When("^Add a attachement to the test case$")
	public void add_a_attachement_to_the_test_case() throws Throwable
	{
		try
		{
		String[] fileName=new String[2];
		fileName[0]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 2, 10);
		fileName[1]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 2, 10);
		
		ctc=new CreateTestCasePage(driver);
		
		tr.clickDetailButton();
		actual[1]=ctc.uploadAttachement(fileName);
		tr.clickOnList();
		}
		catch(Exception e)
		{   lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		
	    
	}

	@Then("^File should be attached to the test case$")
	public void file_should_be_attached_to_the_test_case() throws Throwable 
	{
		try
		{
			 for(int k=0;k<=actual.length-1;k++)
	  	     {
	  	      soft.assertEquals(actual[k], true);
	  	     }
	  	     soft.assertAll();
	    log.info("File Successfully Attached to the Test Case");
		}
		catch(Exception e)
		{   lb.getScreenShot(fileName);
		    e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}


}
