package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Edit_Testcase_809148 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestcase_809148";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	
	@Given("^Tester is in the Testrepository$")
	public void tester_is_in_the_Testrepository() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();  
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

	@When("^Tester moves to the Releasename$")
	public void tester_moves_to_the_Releasename() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
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

	@When("^Tester navigates to the Phase$")
	public void tester_navigates_to_the_Phase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		
		String name=Excel_Lib.getData(INPUT_PATH,"Releases",1,1);
		String desc=Excel_Lib.getData(INPUT_PATH,"Releases",1,1);
		actual[4]=tr.addNode(name, desc);
		
	     bp.waitForElement();
	     tr.doubleClickOnRelease(releaseName);
	     String navigation[]=new String[1];
	    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,0);
	     actual[5]=tr.navigateToNode(releaseName, navigation);
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

	@When("^Tester Selects the Testcase$")
	public void tester_Selects_the_Testcase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
//		String names[]=new String[1];
//	     names[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",3,1);
	     //actual[6]=tr.selectTestCase(names);
		actual[6]=tr.addTestCase();
	     actual[7]=tr.clickOnDetails();
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

	@When("^Tester Modify the Testcase Name and Description in View$")
	public void tester_Modify_the_Testcase_Name_and_Description_in_View() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		String testCaseName=Excel_Lib.getData(INPUT_PATH,"Modify_TC",3,2);
		String testCaseDesc=Excel_Lib.getData(INPUT_PATH,"Modify_TC",3,3);
		actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@Then("^Testcase should be modified successfully by Tester$")
	public void testcase_should_be_modified_successfully_by_Tester() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	    log.info("Pass - Testcase should be modified successfully by Tester");
	    
	    
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
