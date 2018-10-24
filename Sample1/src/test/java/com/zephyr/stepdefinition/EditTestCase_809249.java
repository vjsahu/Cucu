package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809249 extends LaunchBrowser 
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809249";
	
	BasePage bp;
	boolean[] actual=new boolean[32];
	   SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Test Repository Page of Release(\\d+)$")
	public void user_is_in_the_Test_Repository_Page_of_Release(int releaseNo) throws Throwable 
	{
//		   lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   try
		   {
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
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

	@When("^User creates subsystem upto eighth level$")
	public void user_creates_subsystem_upto_eighth_level() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		tr=new TestRepositoryPage(driver);
		
		String nodeName[]=new String[8];
		String nodeDesc[]=new String[8];
		for(int i=0;i<=7;i++)
		{
	      nodeName[i]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes", 4, i);
		  nodeDesc[i]="";
		}
		actual[3]=tr.doubleClickOnRelease(releaseName);
		actual[4]=tr.addNode(nodeName[0], nodeDesc[0]);
		bp.waitForElement();
		actual[5]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] node1=new String[1];
		node1[0]=nodeName[0];
		actual[6]=tr.navigateToNode(releaseName,node1);
		actual[7]=tr.addNode(nodeName[1], nodeDesc[1]);
		bp.waitForElement();
		actual[8]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
	    
	    String[] node2=new String[2];
		node2[0]=nodeName[0];
		node2[1]=nodeName[1];
		actual[9]=tr.navigateToNode(releaseName, node2);
		actual[10]=tr.addNode(nodeName[2], nodeDesc[2]);
		bp.waitForElement();
		actual[11]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
	    
	    String[] node3=new String[3];
		node3[0]=nodeName[0];
		node3[1]=nodeName[1];
		node3[2]=nodeName[2];
		actual[12]=tr.navigateToNode(releaseName, node3);
		actual[13]=tr.addNode(nodeName[3], nodeDesc[3]);
		bp.waitForElement();
		actual[14]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] node4=new String[4];
		node4[0]=nodeName[0];
		node4[1]=nodeName[1];
		node4[2]=nodeName[2];
		node4[3]=nodeName[3];
		actual[15]=tr.navigateToNode(releaseName, node4);
		actual[16]=tr.addNode(nodeName[4], nodeDesc[4]);
		bp.waitForElement();
		actual[17]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		 
		String[] node5=new String[5];
		node5[0]=nodeName[0];
		node5[1]=nodeName[1];
		node5[2]=nodeName[2];
		node5[3]=nodeName[3];
		node5[4]=nodeName[4];
		actual[18]=tr.navigateToNode(releaseName, node5);
	   
		actual[19]=tr.addNode(nodeName[5], nodeDesc[5]);
		bp.waitForElement();
		actual[20]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
	    
		String[] node6=new String[6];
		node6[0]=nodeName[0];
		node6[1]=nodeName[1];
		node6[2]=nodeName[2];
		node6[3]=nodeName[3];
		node6[4]=nodeName[4];
		node6[5]=nodeName[5];
		actual[21]=tr.navigateToNode(releaseName, node6);
	   
		actual[22]=tr.addNode(nodeName[6], nodeDesc[6]);
		bp.waitForElement();
		actual[23]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
	    
	    String[] node7=new String[7];
		node7[0]=nodeName[0];
		node7[1]=nodeName[1];
		node7[2]=nodeName[2];
		node7[3]=nodeName[3];
		node7[4]=nodeName[4];
		node7[5]=nodeName[5];
		node7[6]=nodeName[6];
		//node7[7]=nodeName[5];
		actual[24]=tr.navigateToNode(releaseName, node7);
		actual[25]=tr.addNode(nodeName[7], nodeDesc[7]);
		bp.waitForElement();
		
		actual[20]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
	    
		String[] node8=new String[8];
		node8[0]=nodeName[0];
		node8[1]=nodeName[1];
		node8[2]=nodeName[2];
		node8[3]=nodeName[3];
		node8[4]=nodeName[4];
		node8[5]=nodeName[5];
		node8[6]=nodeName[6];
		node8[7]=nodeName[7];
		actual[21]=tr.navigateToNode(releaseName, node8);
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

	@When("^Add test cases to the last level$")
	public void add_test_cases_to_the_last_level() throws Throwable 
	{
		try
		{
			actual[26]=tr.addTestCase();
			actual[27]=tr.addTestCase();
			actual[28]=tr.addTestCase();
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

	@When("^select the test case and click on Edit button$")
	public void select_the_test_case_and_click_on_Edit_button() throws Throwable {

		try
		{
		String[] testCase=new String[2];
		testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 1, 0));
		testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 2, 0));
		
		ep=new ExportPage(driver);
		actual[29]=ep.selectMultipleTestCaseFromGrid(testCase);
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
		//tr.editTestCase();
		
	}

	@Then("^Edit Test Case Page should be displayed$")
	public void edit_Test_Case_Page_should_be_displayed() throws Throwable
	{
	  tr.editTestCase();
	}

	@When("^User edit the test case fields$")
	public void user_edit_the_test_case_fields() throws Throwable {
	  
		try
		{
		ctc=new CreateTestCasePage(driver);
	   String[] detail=new String[3];
	   detail[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"EditTestCase", 1, 1));
	   detail[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 2);
	   detail[2]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 4);
	   String[] automationfield=new String[4];
	   automationfield[0]="";
	   automationfield[1]="";
	   automationfield[2]="";
	   automationfield[3]="";
	   actual[30]=ctc.editMultipleTestCase(detail,automationfield);
	   
	   actual[31]=ctc.saveMultipleTestCaseEdit();
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

	@Then("^test case should be edited Successfully$")
	public void test_case_should_be_edited_Successfully() throws Throwable 
	{
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
	   //ctc.verifyedtitMultipleTestCase();
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
