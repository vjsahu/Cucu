package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportTestCase_798136 extends LaunchBrowser
{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	String filename="ExportTestCase_798136";
	boolean[] actual=new boolean[5];
	SoftAssert soft=new SoftAssert();
	
	@When("^User select the node$")
	public void user_select_the_node() throws Throwable {
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 1,9);
		tr=new TestRepositoryPage(driver);
		//tr.doubleClickOnRelease(releaseName);
		actual[0]=tr.navigateToNode(releaseName, phase);
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

	@When("^User select the multiple test cases$")
	public void user_select_the_multiple_test_cases() throws Throwable 
	{
		try
		{
		String[] testCases=new String[3];
		int k=1;
		for(int i=0;i<=testCases.length-1;i++)
		{
		int j=Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo", k, 0);
		testCases[i]=Integer.toString(j);
		k++;
		}
	
		ep=new ExportPage(driver);
		actual[1]=ep.selectMultipleTestCaseFromGrid(testCases);
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

	@When("^click on export button and select Detailed report$")
	public void click_on_export_button_and_select_Detailed_report() throws Throwable 
	{
		try
		{
			actual[2]=ep.clickOnExportTab();
        String reportType=Excel_Lib.getData(INPUT_PATH_2, "Export", 2, 6);
        actual[3]=ep.reportType(reportType);
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

	@When("^select Output type$")
	public void select_Output_type() throws Throwable {
		try
		{
		String outputType=Excel_Lib.getData(INPUT_PATH_2, "Export", 2, 7);
		actual[4]=ep.outputType(outputType);
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
		 //bp=new BasePage();
		// bp.waitForElement();
		 //ep.saveAndDownload();
	}

	@Then("^test Case should be exported Successfully$")
	public void test_Case_should_be_exported_Successfully() throws Throwable {
	  
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		tr.doubleClickOnRelease(releaseName);
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
		soft.assertAll();
		
		log.info("Test Case Exported");
	   
	   
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
