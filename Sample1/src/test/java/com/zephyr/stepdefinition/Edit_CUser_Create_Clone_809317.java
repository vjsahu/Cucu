package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Edit_CUser_Create_Clone_809317 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	NavigationPage np;
	ExportPage ep;
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_CUser_Create_Clone_809317";
	
	boolean[] actual=new boolean[9];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^User is in Testrepopage$")
	  public void user_is_in_Testrepopage() throws Throwable 
	  {
	      try
	      {
//				lb=new LaunchBrowser();
//			   lb.preCond();
//			   lp=new LoginPage(driver);
//			   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//			   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//			   lp.enterUname(Uname);
//			   lp.enterPass(Pass);
//			   lp.clickOnLogin();
	    	  bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
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

	  @When("^User moves to Releasenames$")
	  public void user_moves_to_Releasenames() throws Throwable 
	  {
	      try
	      {
	    	    
				tr=new TestRepositoryPage(driver);
				 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				 bp.waitForElement();
				 actual[3]=tr.doubleClickOnRelease(releaseName);
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

	  @When("^User Creates a Phase in release$")
	  public void user_Creates_a_Phase_in_release() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
			     String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			     String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
			     actual[4]=tr.addNode(Name, Desc);
			     bp.waitForElement();
			     String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			     tr.doubleClickOnRelease(releaseName);
			     String navigation[]=new String[1];
			     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			     actual[5]=tr.navigateToNode(releaseName, navigation);
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

	  @When("^User adds Two Testcase in Phase$")
	  public void user_adds_Two_Testcase_in_Phase() throws Throwable 
	  {
	      try
	      {
	    	  for(int i=0;i<=3;i++)
			     {
	    		  actual[6]=tr.addTestCase();
				     bp.waitForElement();
			     } 
	    	  ep=new ExportPage(driver);
				ctc=new CreateTestCasePage(driver);
		    	String testCaseNo[]=new String[3];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
				testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
				testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 4, 0));
				actual[7]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
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

	  @When("^User clones the Testcases$")
	  public void user_clones_the_Testcases() throws Throwable 
	  {
	      try
	      {
	    	  actual[8]=tr.cloneTestCase();
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

	  @Then("^Phase should be created and Testcases are cloned Successfully$")
	  public void phase_should_be_created_and_Testcases_are_cloned_Successfully() throws Throwable 
	  {
	      try
	      {
	    	  
	    	  for(int k=0;k<=actual.length-1;k++)
	          {
	           soft.assertEquals(actual[k], true);
	          }
	          soft.assertAll();
	    	  log.info("Pass - Phase should be created and Testcases are cloned Successfully");
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
