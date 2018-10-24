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

public class ExportTestCase_798112 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	String filename="ExportTestCase_798112";
	boolean[] actual=new boolean[8];
		SoftAssert soft=new SoftAssert();
		

@Given("^User is in the test repository page$")
public void user_is_in_the_test_repository_page() throws Throwable {
//	lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//	   
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	   
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

@When("^User select the node and Choose test export option$")
public void user_select_the_node_and_Choose_test_export_option() throws Throwable
{
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
    String[] phase=new String[1];
    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Export", 1, 9);
	tr=new TestRepositoryPage(driver);
	tr.doubleClickOnRelease(releaseName);
	String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Common", 7, 2);
	String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Common", 7, 2);
	tr.addNode(name, desc);
	bp.waitForElement();
	tr.doubleClickOnRelease(releaseName);
	actual[3]=tr.navigateToNode(releaseName, phase);
    ep=new ExportPage(driver);
    actual[4]=ep.clickOnNodeExport();
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

@When("^Select Report type \"([^\"]*)\" as Data/Summary/Detailed/Summary$")
public void select_Report_type_as_Data_Summary_Detailed_Summary(String reportType) throws Throwable
{
	try
	{
	System.out.println(reportType);
	
	actual[5]=ep.reportType(reportType);
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


@When("^Select Output type \"([^\"]*)\" as Excel/PDF/Word/HTML$")
public void select_Output_type_as_Excel_PDF_Word_HTML(String outputType) throws Throwable 
{
	try
	{
		
		
		if(outputType.isEmpty())
		  {
			  actual[6]=true;
			  System.out.println("If Part");
		  }
		  
		  else
		  {
			  System.out.println("Entering else condition");
			actual[6]=ep.outputType(outputType);
		  }
		  
		
	
	
	actual[7]=ep.saveAndDownload();
    Thread.sleep(3000);
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
//   pp=new ProjectPage(driver);
//   pp.clickOnLogout();
}

@Then("^Test Case should be exported with test steps \"([^\"]*)\"$")
public void test_Case_should_be_exported_with_test_steps(String arg1) throws Throwable 
{
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",2,1);
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	for(int k=0;k<=actual.length-1;k++)
    {
    	soft.assertEquals(actual[k], true);
    }
	soft.assertAll();
	log.info("Test Case Exported");
   //driver.close();
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
