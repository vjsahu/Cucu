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

public class EditTestCase_809198 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809198";

	 boolean[] actual=new boolean[10];
	   SoftAssert soft=new SoftAssert();
	   
	@When("^User Add a node and add test cases to the node$")
	public void user_Add_a_node_and_add_test_cases_to_the_node() throws Throwable 
	{   
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		tr=new TestRepositoryPage(driver);
		actual[0]=tr.doubleClickOnRelease(releaseName);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"NodeAdd",3,0);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"NodeAdd",3,1);
		actual[1]=tr.addNode(name, desc);
		bp.waitForElement();
		actual[2]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
	    String[] node=new String[1];
	    node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"NodeAdd",3,0);
	    actual[3]= tr.navigateToNode(releaseName, node);
	  
	    actual[4]=tr.addTestCase();
	    actual[5]=tr.addTestCase();
	    actual[6]=tr.addTestCase();
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

	@When("^Select the multiple test cases$")
	public void select_the_multiple_test_cases() throws Throwable
	{
		try
		{
	    ep=new ExportPage(driver);
	    String[] testCases=new String[3];
	    for(int i=0;i<=2;i++)
	    {
	     testCases[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo",i+1,2));
	    }
	    
	    actual[7]=ep.selectMultipleTestCaseFromGrid(testCases);
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

	@When("^edit the test case fields$")
	public void edit_the_test_case_fields() throws Throwable {
	   try
	   {
		ctc=new CreateTestCasePage(driver);
	    String[] detail=new String[3];
	    detail[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 4, 1));
	    detail[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 2, 2);
	    detail[2]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 2, 4);
	    String[] aut=new String[3];
	    aut[0]=Excel_Lib.getData(INPUT_PATH_2,"TestCaseNo", 199, 100);
	    aut[1]=Excel_Lib.getData(INPUT_PATH_2,"TestCaseNo", 199, 100);
	    aut[2]=Excel_Lib.getData(INPUT_PATH_2,"TestCaseNo", 199, 100);
	    
	    tr.editTestCase();
	    actual[8]=ctc.editMultipleTestCase(detail, aut);
	    
	    actual[9]=ctc.saveMultipleTestCaseEdit();
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

	@Then("^test case should be modified$")
	public void test_case_should_be_modified() throws Throwable {
	   try
	   {
		   for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
		  
		log.info("Test Case modified Successfully");
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
