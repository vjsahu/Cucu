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

public class EditTestCase_809399 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809399";
	boolean[] actual=new boolean[16];
	   SoftAssert soft=new SoftAssert();
	
	@When("^User add a node and add multiple test cases in the node$")
	public void user_add_a_node_and_add_multiple_test_cases_in_the_node() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	    
		   tr=new TestRepositoryPage(driver);
		   actual[0]=tr.doubleClickOnRelease(releaseName);
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 6, 0);
		   String desc=Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 6, 1);
		   
		   actual[1]=tr.addNode(name, desc);
		   actual[2]=tr.doubleClickOnRelease(releaseName);
		   String[] node=new String[1];
		   node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 6, 0);
		   actual[3]=tr.navigateToNode(releaseName, node);
		   actual[4]=tr.addNewTestCaseInDetilview();
		   actual[5]=tr.addTestCase();
		   
		   actual[6]=tr.addTestCase();
		   actual[7]=tr.addTestCase();
		   actual[8]=tr.addTestCase();
		   actual[9]=tr.clickDetailButton();
		   ctc=new CreateTestCasePage(driver);
		   String[] tags=new String[2];
		   tags[0]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 3, 3);
		   tags[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 4, 3);
		   actual[10]=ctc.enterMultipleTags(tags);
		   bp.waitForElement();
		   actual[11]=tr.clickOnList();
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

	@When("^select the multiple test case$")
	public void select_the_multiple_test_case() throws Throwable {
		try
		{
		String[] testcase=new String[5];
		 testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 1, 0));
		 testcase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 2, 0));
		 testcase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 3, 0));
		 testcase[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 4, 0));
		 testcase[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 5, 0));
		 ep=new ExportPage(driver);
		 actual[12]=ep.selectMultipleTestCaseFromGrid(testcase);
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

	@When("^edit the tag of multi-selected test case$")
	public void edit_the_tag_of_multi_selected_test_case() throws Throwable {
	   
		try
		{
			actual[13]=tr.editTestCase();
		ctc=new CreateTestCasePage(driver);
	    String[] tags=new String[3];
	    tags[0]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 3);
	    tags[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 2, 3);
	    tags[2]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 3, 3);
	    actual[14]=ctc.editTagsInMultipleTesCase(tags);
	    actual[15]=ctc.saveMultipleTestCaseEdit();
	    bp.waitForElement();
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

	@Then("^test case should be edited successfully$")
	public void test_case_should_be_edited_successfully() throws Throwable {
	   
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
		log.info("Test Case Edited Successfully");
	}
	
}
