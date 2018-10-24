package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809118 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809118";
	
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User selected the test Case$")
	public void user_selected_the_test_Case() throws Throwable 
	{      
//		   lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		 
		try
		{
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		   
		   tr.doubleClickOnRelease(releaseName);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Common", 9, 2);
		   String desc=Excel_Lib.getData(INPUT_PATH_2, "Common", 9, 2);
		   tr.addNode(name, desc);
		   
		   tr.doubleClickOnRelease(releaseName);
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 3, 0);
		   actual[3]=tr.navigateToNode(releaseName, phase);
		   
		   tr.addTestCase();
		   ep=new ExportPage(driver);
		   String[] testCase=new String[1];
		   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo", 2, 0));
		  // System.out.println(testCase[0]);
		   actual[4]= ep.selectMultipleTestCaseFromGrid(testCase);
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

	@When("^User click on clone button$")
	public void user_click_on_clone_button() throws Throwable {
	   try
	   {
		bp=new BasePage();
		bp.waitForElement();
		actual[5]=tr.verifyPastTestCase();
		actual[6]=tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
	   }
	   catch(Exception e)
		{    lb.getScreenShot(fileName);
		e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^Test Case Should be cloned Successfully$")
	public void test_Case_Should_be_cloned_Successfully() throws Throwable 
	{
		try
		{
			actual[7]=tr.verifyPresentTestCase();
			
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	    	
		}
		catch(Exception e)
		{    lb.getScreenShot(fileName);
		     e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}


}
