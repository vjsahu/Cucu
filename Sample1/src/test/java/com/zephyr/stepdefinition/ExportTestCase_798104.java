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

public class ExportTestCase_798104 extends LaunchBrowser 
{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	String filename="ExportTestCase_798104";
	boolean[] actual=new boolean[5];
	SoftAssert soft=new SoftAssert();
	
@When("^User Select the Release and Choose Export Tests Option$")
public void user_Select_the_Release_and_Choose_Export_Tests_Option() throws Throwable 
{
	try
	{
	 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	   tr=new TestRepositoryPage(driver);
	   actual[0]=tr.doubleClickOnRelease(releaseName);
	   bp=new BasePage();
	   bp.waitForElement();
	   
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

@When("^Select Report type as Detailed$")
public void select_Report_type_as_Detailed() throws Throwable
{
	try
	{
	String report_Type=Excel_Lib.getData(INPUT_PATH_2, "Export", 2, 6);
	 String output_Type=Excel_Lib.getData(INPUT_PATH_2, "Export", 3, 7);
	 actual[2]=ep.reportType(report_Type);
	 actual[3]=ep.outputType(output_Type);
	 actual[4]=ep.saveAndDownload();
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

@Then("^Test Case Should be Exported in detailed$")
public void test_Case_Should_be_Exported_in_detailed() throws Throwable 
{
	try
	{
	log.info("Test Case Exported");
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",2,1);
	tr.doubleClickOnRelease(releaseName);
	for(int k=0;k<=actual.length-1;k++)
    {
    	soft.assertEquals(actual[k], true);
    }
	soft.assertAll();
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
