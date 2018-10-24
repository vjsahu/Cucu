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

public class ExportTestCase_798108 extends LaunchBrowser
{
 TestRepositoryPage tr;
 ExportPage ep;
 ProjectPage pp;
 BasePage bp;
 LaunchBrowser lb;
 boolean[] actual=new boolean[5];
	SoftAssert soft=new SoftAssert();
	String filename="ExportTestCase_798108";
@When("^User Select the Node and Choose Test Export Option$")
public void user_Select_the_Node_and_Choose_Test_Export_Option() throws Throwable
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

@When("^Select Report type \"([^\"]*)\"$")
public void select_Report_type(String reportType) throws Throwable 
{
	try
	{
    
		actual[2]=ep.reportType(reportType);
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

@When("^Select Output type \"([^\"]*)\"$")
public void select_Output_type(String outputType) throws Throwable 
{
	try
	{
		System.out.println("s1"+outputType+"s2");
	  if(outputType.isEmpty())
	  {
		  actual[3]=true;
		  System.out.println("If Part");
	  }
	  
	  else
	  {
		  System.out.println("Entering else condition");
		actual[3]=ep.outputType(outputType);
	  }
	  
		actual[4]=ep.saveAndDownload();
    bp=new BasePage();
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

@Then("^Test Case should be exported with attachement\"([^\"]*)\"$")
public void test_Case_should_be_exported_with_attachement(String arg1) throws Throwable 
{
	try
	{
	bp=new BasePage();
    bp.waitForElement();
    
    String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",2,1);
    tr.doubleClickOnRelease(releaseName);
    
    for(int k=0;k<=actual.length-1;k++)
    {
    	soft.assertEquals(actual[k], true);
    }
	soft.assertAll();

	log.info("Test Case Exported with attachement");
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
