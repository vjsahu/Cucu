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

public class ExportTestCase_798353 extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	
	boolean[] actual=new boolean[4];
	SoftAssert soft=new SoftAssert();
	String filename="ExportTestCase_798353";
	@When("^User select the node and choose test export option$")
	public void user_select_the_node_and_choose_test_export_option() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 1, 9);
		tr=new TestRepositoryPage(driver);
		
		actual[0]=tr.navigateToNode(releaseName, phase);
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

	@When("^Select report type as Summary$")
	public void select_report_type_as_Summary() throws Throwable
	{
		 // ep=new ExportPage(driver);
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
	
	@When("^select output type$")
	public void select_output_type() throws Throwable 
	{
		try
		{
		String outputType=Excel_Lib.getData(INPUT_PATH_2,"Export",4,7);
		System.out.println("Excel-"+outputType);
		if(outputType.equals("Excel"))
		{
			//log.info("Excel Selected");
		//ep.outputType(outputType);
		}
		else if(outputType.equals("PDF"))
		{
			ep.outputType(outputType);
		}
		else if(outputType.equals("Word"))
		{
			ep.outputType(outputType);
		}
		else
		{
			ep.outputType(outputType);
		}
		
		actual[3]=ep.saveAndDownload();
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
	


	@Then("^Test Case should be exported with different estimated time$")
	public void test_Case_should_be_exported_with_different_estimated_time() throws Throwable 
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
		
		log.info("Test Case exported");
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
