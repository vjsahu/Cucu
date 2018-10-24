package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809032 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
    
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_8090";
	
	boolean[] actual=new boolean[7];
	SoftAssert soft=new SoftAssert();
	
	@Given("^user is in the phase page$")
	public void user_is_in_the_phase_page() throws Throwable
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
//		   
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   
		   tr=new TestRepositoryPage(driver);
		   tr.doubleClickOnRelease(releaseName);
		   String name=Excel_Lib.getData(INPUT_PATH_2,"Common",8,2);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Common",8,2);
		   tr.addNode(name, desc);
		   
		   tr.doubleClickOnRelease(releaseName);
		   tr=new TestRepositoryPage(driver);
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 3, 0);
		   actual[3]=tr.navigateToNode(releaseName, phase);
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

	@When("^User select the Test Case$")
	public void user_select_the_Test_Case() throws Throwable 
	{
		try
		{
			actual[4]=tr.addTestCase();
//		String[] name=new String[1];
//		name[0]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 2, 9);
//		actual[4]=tr.selectTestCase(name);
		//actual[4]=tr.addTestCase();
		actual[5]=tr.clickDetailButton();
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

	@When("^Edit the test case name and description$")
	public void edit_the_test_case_name_and_description() throws Throwable {
	    
		try
		{
		String name=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 1, 11);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 1, 12);
		ctc=new CreateTestCasePage(driver);
		
		actual[6]=ctc.enterTestCaseNameAndDesc(name, desc);
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

	@Then("^test case should be updated$")
	public void test_case_should_be_updated() throws Throwable 
	{
		try
		{
			 for(int k=0;k<=actual.length-1;k++)
	  	     {
	  	      soft.assertEquals(actual[k], true);
	  	     }
	  	     soft.assertAll();
		log.info("Test Case Edited Successfully");
		
		tr.clickOnList();
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
