package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809272 extends LaunchBrowser
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	BasePage bp;
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809272";
	
	boolean[] actual=new boolean[7];
	   SoftAssert soft=new SoftAssert();
	   
	@Given("^User select the test case$")
	public void user_select_the_test_case() throws Throwable 
	{
//		   lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
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
		   
		   tr.doubleClickOnRelease(releaseName);
		   
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Common",5,2);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Common",5,2);
		   
		   tr.addNode(name, desc);
		   
		   
		   tr.doubleClickOnRelease(releaseName);
		   String[] node=new String[1];
		   node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 3, 0);
		   actual[3]=tr.navigateToNode(releaseName, node);
		   
		   actual[4]=tr.addTestCase();
		   
		   ctc=new CreateTestCasePage(driver);
		   String[] fileName =new String[1];
		    fileName[0]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 2, 10);
		    tr.clickDetailButton();
		    actual[5]=ctc.uploadAttachement(fileName);
		   bp.waitForElement();
		   bp.waitForElement();
		   ctc.attachements.click();
		   bp.waitForElement();
//		   String[] name=new String[1];
//		   name[0]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 1, 9);
//		   actual[4]=tr.selectTestCase(name);
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

	@When("^User delete the attachement$")
	public void user_delete_the_attachement() throws Throwable {
	    try
	    {
		ctc=new CreateTestCasePage(driver);
	    String[] fileName =new String[1];
	    fileName[0]=Excel_Lib.getData(INPUT_PATH_2,"EditTestCase", 3, 10);
	    actual[6]=ctc.deleteAttachement(fileName);
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

	@Then("^attachement should be deleted$")
	public void attachement_should_be_deleted() throws Throwable {
		
	   try
	   {
		   for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	    	
	    	tr.clickOnList();
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
