package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportTestCase_798067 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	String filename="ExportTestCase_798067";
	boolean[] actual=new boolean[5];
	SoftAssert soft=new SoftAssert();
	
	@When("^Add few test case in the node$")
	public void add_few_test_case_in_the_node() throws Throwable
	{
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

	@When("^navigate to search and select the option in these release$")
	public void navigate_to_search_and_select_the_option_in_these_release() throws Throwable
	{
		try
		{
			actual[2]=tr.clickOnSearch();
	    ep=new ExportPage(driver);
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

	@When("^export the test cases$")
	public void export_the_test_cases() throws Throwable {
	 
		try
		{
	  String searchText="";
	  actual[3]=ep.searchTestCases(searchText);
	  bp=new BasePage();
	  bp.waitForElement();
	  actual[4]=ep.clickOnExportTab();
	  ep.saveAndDownload();
	  bp.waitForElement();
	  bp.waitForElement();
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

	@Then("^should be able to export only the returned result$")
	public void should_be_able_to_export_only_the_returned_result() throws Throwable 
	{
		try
		{
			tr.clickedOnFolder();
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
	    log.info("Test Case Exported Successfully");
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
