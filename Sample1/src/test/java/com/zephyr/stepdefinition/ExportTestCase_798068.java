package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportTestCase_798068 extends LaunchBrowser
{

	LaunchBrowser lb;
    TestRepositoryPage tr;
	ExportPage ep;
	ProjectPage pp;
	BasePage bp;
	
	boolean[] actual=new boolean[6];
	SoftAssert soft=new SoftAssert();
	String filename="ExportTestCase_798068";
	@When("^Add few test cases in the node$")
	public void add_few_test_cases_in_the_node() throws Throwable {
	   
		try
		{
		tr=new TestRepositoryPage(driver);
		actual[0]=tr.addTestCase();
		actual[1]=tr.addTestCase();
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

	@When("^navigate to search and Unselect the option in these release$")
	public void navigate_to_search_and_Unselect_the_option_in_these_release() throws Throwable {
	   
		try
		{
		ep=new ExportPage(driver);
	    String searchText="";
	    actual[2]=ep.searchTestCases(searchText);
	    bp=new BasePage();
	    bp.waitForElement();
	    actual[3]=ep.UnselectInTheseRelease();
	    actual[4]=ep.clickOnExportTab();
	    actual[5]=ep.saveAndDownload();
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

	@Then("^should be able to export all the testcases irrespective of the search results$")
	public void should_be_able_to_export_all_the_testcases_irrespective_of_the_search_results() throws Throwable
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
       log.info("All Test Cases Exported Successfully" );
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
