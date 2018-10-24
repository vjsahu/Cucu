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

public class EditTestCase_809184 extends LaunchBrowser 
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809184";

	boolean[] actual=new boolean[13];
	 SoftAssert soft=new SoftAssert();
	 
	@When("^User add a node and and add test cases to the node$")
	public void user_add_a_node_and_and_add_test_cases_to_the_node() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	     tr=new TestRepositoryPage(driver);
	     actual[0]=tr.doubleClickOnRelease(releaseName);
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"NodeAdd", 2, 0);
	   String desc=Excel_Lib.getData(INPUT_PATH_2,"NodeAdd", 2, 1);
	   actual[1]=tr.addNode(name, desc);
	   bp.waitForElement();
	   bp.waitForElement();
	   
	  
	   actual[2]=tr.doubleClickOnRelease(releaseName);
	   bp.waitForElement();
	   String[] phase=new String[1];
	   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"NodeAdd", 2, 0);
	   actual[3]=tr.navigateToNode(releaseName, phase);
	 
	   actual[4]=tr.addNewTestCaseInDetilview();
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

@When("^User Select the multiple test cases$")
public void user_Select_the_multiple_test_cases() throws Throwable
{
	try
	{
		actual[7]=tr.addTestCase();
		actual[8]=tr.addTestCase();
	   ep=new ExportPage(driver);
	   String[] testCase=new String[3];
	   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo",1, 0));
	   testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo",2, 0));
	   testCase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo",5, 0));
	   
	   
	   actual[9]=ep.selectMultipleTestCaseFromGrid(testCase);
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
	    e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^edit the AltId and Automation field$")
public void edit_the_AltId_and_Automation_field() throws Throwable 
{
	try
	{
	ctc=new CreateTestCasePage(driver);
	String[] altId=new String[3];
	//System.out.println(alltId[1]);
	altId[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 3, 1));
	altId[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 45, 5);
	altId[2]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 45, 5);

	String[] aut=new String[4];
	aut[0]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 5);
	aut[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 6);
	aut[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 1, 7));
	aut[3]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 8);
	actual[10]=tr.editTestCase();
	actual[11]=ctc.editMultipleTestCase(altId, aut);
    
	actual[12]=ctc.saveMultipleTestCaseEdit();
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

@Then("^test case should be edited$")
public void test_case_should_be_edited() throws Throwable
{
	try
	{
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
    	
     log.info("Test Case Edited Succssfully");  
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
