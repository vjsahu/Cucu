package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportTestCase_798387 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	
	String filename="ExportTestCase_798387";
	boolean[] actual=new boolean[3];
	SoftAssert soft=new SoftAssert();
	
	
	@When("^User Select the Phase and choose export test option$")
	public void user_Select_the_Phase_and_choose_export_test_option() throws Throwable
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 1, 9);
		tr=new TestRepositoryPage(driver);
		//tr.doubleClickOnRelease(releaseName);
		actual[0]=tr.navigateToNode(releaseName, phase);
	    ep=new ExportPage(driver);
	    actual[1]=ep.clickOnNodeExport();
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

	
	@When("^click on Save and Download$")
	public void click_on_Save_and_Download() throws Throwable {

		try
		{
			
		
		ep=new ExportPage(driver);
		actual[2]=ep.saveAndDownload();
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


	@Then("^test case should be exported with test steps$")
	public void test_case_should_be_exported_with_test_steps() throws Throwable 
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
		
		log.info("Test Case Exported successfully");
	    
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
