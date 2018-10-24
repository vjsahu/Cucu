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

public class CustomizeExportReport_798193 extends LaunchBrowser {

	//LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CustomizeExportReport_798193";
	
	@Given("^User is in the Tester_Phase page$")
	public void user_is_in_the_Tester_Phase_page() throws Throwable
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
			  bp=new BasePage();
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		   
		   
		   tr.doubleClickOnRelease(releaseName);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 14, 0);
		   String desc=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 14, 0);
		   tr.addNode(name, desc);
		   bp.waitForElement();
		   bp.waitForElement();
		   
		   String[] node=new String[1];
		   node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 14, 0);
		   actual[3]=tr.navigateToNode(releaseName, node);
		   
		   for(int i=1;i<=4;i++)
		   {
		   tr.addTestCase();
		   
		     }
		  }
		  catch(Exception e)
			{
			  lb.getScreenShot(fileName);
				driver.close();
		      	Relogin rl=new Relogin();
		      	rl.reLogin();
		      	throw e;
		   	 
			}
	}

	@When("^User select the Export option$")
	public void user_select_the_Export_option() throws Throwable 
	{
		try
		{
		ep=new ExportPage(driver);
		actual[4]=ep.clickOnNodeExport();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^select all selects fieds in export page$")
	public void select_all_selects_fieds_in_export_page() throws Throwable
	{
		try
		{
			actual[5]=ep.selectallSelectFields();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^select report type as Detailed$")
	public void select_report_type_as_Detailed() throws Throwable {
	    try
	    {
		String reportType=Excel_Lib.getData(INPUT_PATH_2, "Export", 2, 6);
		actual[6]=ep.reportType(reportType);
	    }
	    catch(Exception e)
		{
	    	lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^select output type as Pdf$")
	public void select_output_type_as_Pdf() throws Throwable
    {
		try
		{
	   String outputType=Excel_Lib.getData(INPUT_PATH_2, "Export", 2, 7);
	   actual[7]=ep.outputType(outputType);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^click on Export save and download$")
	public void click_on_Export_save_and_download() throws Throwable {
	    try
	    {
	    	actual[8]=ep.saveAndDownload();
	    }
	    catch(Exception e)
		{
	    	lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^test case should be exported$")
	public void test_case_should_be_exported() throws Throwable
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	    	
	    log.info("Test Case Exported Succseessfully");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
//	    pp=new ProjectPage(driver);
//	    pp.clickOnLogout();
//	    lb=new LaunchBrowser();
//	    lb.close();
	    
	}
}
