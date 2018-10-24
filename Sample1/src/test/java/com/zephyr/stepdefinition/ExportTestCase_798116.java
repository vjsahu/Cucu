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

public class ExportTestCase_798116 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	String filename="ExportTestCase_798116";
		boolean[] actual=new boolean[3];
			SoftAssert soft=new SoftAssert();
			
			
			@Given("^User is in the Test repository page$")
			public void user_is_in_the_Test_repository_page() throws Throwable {
				  
				try
				{
				bp=new BasePage();
				   pp=new ProjectPage(driver);
				   
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
				   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
				   actual[0]=pp.selectProject(projectName);
				   actual[1]=pp.selectRelease(releaseName);
				   
				   rp= new ReleasePage(driver);
				   actual[2]=rp.clickOnTestRep();
				   tr=new TestRepositoryPage(driver);
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
	
	@When("^User Select the node and choose export test option$")
	public void user_Select_the_node_and_choose_export_test_option() throws Throwable {
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		
		
	    String[] nodes=new String[8];
	   nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 10, 0);
	    
	    for(int i=1;i<=nodes.length-1;i++)
	    {
	    nodes[i]=Excel_Lib.getData(INPUT_PATH_2, "Export", 10, i);
	    }
		tr=new TestRepositoryPage(driver);
		//tr.doubleClickOnRelease(releaseName);
		actual[0]=tr.navigateToNode(releaseName,nodes);
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

	@When("^Select report type$")
	public void select_report_type() throws Throwable 
	{
		try
		{
	 String reportType=Excel_Lib.getData(INPUT_PATH_2,"Export",1,6);
	 System.out.println("Excel Report Type-"+reportType);
		if(reportType.equals("Data (Excel only)"))
	    {
	    	ep.reportType(reportType);
	    }
	    else if(reportType.equals("Detailed"))
	    {
	    	ep.reportType(reportType);
	    }
	    else
	    {
	    	ep.reportType(reportType);
	    }
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

	@When("^Select output type$")
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

	@Then("^test cases should be exported Sucessfully$")
	public void test_cases_should_be_exported_Sucessfully() throws Throwable
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
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
