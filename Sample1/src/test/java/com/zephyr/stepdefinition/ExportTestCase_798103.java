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

public class ExportTestCase_798103 extends LaunchBrowser
{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	String filename="ExportTestCase_798103";
	boolean[] actual=new boolean[5];
	SoftAssert soft=new SoftAssert();
	
@When("^User Select the Release and choose Export Test option$")
public void user_Select_the_Release_and_choose_Export_Test_option() throws Throwable
{
	try
	{
	 tr=new TestRepositoryPage(driver);   
	 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	  
	 actual[0]=tr.doubleClickOnRelease(releaseName);
	   
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

@When("^Select report type as summary$")
public void select_report_type_as_summary() throws Throwable 
{
	//ep=new ExportPage(driver);
  try
  {
	String report_Type=Excel_Lib.getData(INPUT_PATH_2,"Export", 3, 6);
	actual[2]=ep.reportType(report_Type);
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


@When("^generate the ouput in HTML/PDF/Word format$")
public void generate_the_ouput_in_HTML_PDF_Word_format() throws Throwable {
   
	try
	{
	String output_Type=Excel_Lib.getData(INPUT_PATH_2, "Export", 1, 7);
	actual[3]=ep.outputType(output_Type);
	actual[4]=ep.saveAndDownload();
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


@Then("^all the Selected test cases Should be exported$")
public void all_the_Selected_test_cases_Should_be_exported() throws Throwable {
	try
	{
	 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	  
	 actual[0]=tr.doubleClickOnRelease(releaseName);
	   
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
