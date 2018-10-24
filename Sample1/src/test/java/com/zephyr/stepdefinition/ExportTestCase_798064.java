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

public class ExportTestCase_798064 extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	String filename="ExportTestCase_798064";
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Node Page$")
	public void user_is_in_the_Node_Page() throws Throwable {
//		 lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
//		  
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
		   String[] node=new String[1];
		   node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 1, 9);
		   actual[3]=tr.navigateToNode(releaseName, node);
		}	   

		   catch(Exception e)
			{
				lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
		 	Relogin rl=new Relogin();
		 	rl.reLogin();
		 	throw e;
			}
	}

	@When("^User Add few test cases to the node$")
	public void user_Add_few_test_cases_to_the_node() throws Throwable {
	  
		try
		{
			actual[4]=tr.addTestCase();
		}
		catch(Exception e)
		{

			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
	 	Relogin rl=new Relogin();
	 	rl.reLogin();
	 	throw e;
		}
	}

	@When("^navigate to search page and click on export$")
	public void navigate_to_search_page_and_click_on_export() throws Throwable 
	
	{
		try
		{
	    String searchText=Excel_Lib.getData(INPUT_PATH_2, "TestCaseNo", 5, 5);
	    ep=new ExportPage(driver);
	    actual[5]=ep.searchTestCases(searchText);
	    bp=new BasePage();
	    bp.waitForElement();
	    actual[6]=ep.clickOnExportTab();
	    actual[7]=ep.saveAndDownload();
	    bp.waitForElement();
	    
	    tr.clickedOnFolder();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
	 	Relogin rl=new Relogin();
	 	rl.reLogin();
	 	throw e;
		}
	}

	@Then("^all the test cases present in search result should be exported$")
	public void all_the_test_cases_present_in_search_result_should_be_exported() throws Throwable 
	{
		try
		{
			 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
			 tr.doubleClickOnRelease(releaseName);
			 
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
		soft.assertAll();
	    log.info("All the Test Cases present in searched result exported");
		}
		 catch(Exception e)
		{
				lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	}

}
