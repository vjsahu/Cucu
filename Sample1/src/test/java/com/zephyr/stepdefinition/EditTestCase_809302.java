package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809302 extends LaunchBrowser
{

	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809302";
	
	boolean[] actual=new boolean[5];
	   SoftAssert soft=new SoftAssert();
	   
	@When("^user select a node containing test case$")
	public void user_select_a_node_containing_test_case() throws Throwable
	{
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "Common", 1, 1);
	    tr=new TestRepositoryPage(driver);
	    tr.doubleClickOnRelease(releaseName);
	    
	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Common", 6, 2);
	    String desc=Excel_Lib.getData(INPUT_PATH_2, "Common", 6, 2);
	    tr.addNode(name, desc);
	    
	    tr.doubleClickOnRelease(releaseName);
	     String[] node=new String[1];
		 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 3, 0);
		 actual[0]=tr.navigateToNode(releaseName, node);
	    //tr.navigateToNode(releaseName, node);
		 
		 
		 actual[1]=tr.addTestCase();
		 actual[2]=tr.clickDetailButton();
		 bp.waitForElement();
		 
		 ctc=new CreateTestCasePage(driver);
		 String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 3, 14));
			String hour=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 3, 15));
			String mn=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 3, 16));
			 actual[3]=ctc.enterEstimatedTime(day, hour, mn);
		 
		 bp.waitForElement();
		 
		 
//	    String[] name=new String[1];
//	    name[0]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 2, 9);
//	    actual[1]=tr.selectTestCase(name);
	   // actual[2]=tr.clickDetailButton();
		}
		catch(Exception e)
		{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	}

	@When("^edit the test case execution time$")
	public void edit_the_test_case_execution_time() throws Throwable 
	{
		try
		{
		String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 1, 14));
		String hour=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 1, 15));
		String mn=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 1, 16));
		ctc=new CreateTestCasePage(driver);
		actual[4]=ctc.enterEstimatedTime(day, hour, mn);
		}
		catch(Exception e)
		{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	}

	@Then("^test Case should be edited$")
	public void test_Case_should_be_edited() throws Throwable {
		try
		{
		 for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	    	
	    	tr.clickOnList();
		 //log.info("Edited");
	   log.info("Test Case Edited Successfully");
	}
	   catch(Exception e)
		{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
     	Relogin rl=new Relogin();
     	rl.reLogin();
     	throw e;
		}
	}


}
