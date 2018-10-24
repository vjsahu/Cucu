package com.zephyr.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Modify_TC_809123 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName=" Modify_TC_809123";
	
	boolean[] actual=new boolean[14];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Lead Navigated to TestRepositorypage$")
	public void lead_Navigated_to_TestRepositorypage() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
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

	
	@When("^Lead Navigates to the Phase$")
	public void lead_Navigates_to_the_Phase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		ctc=new CreateTestCasePage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
	     bp.waitForElement();
	     String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,0);
	     String Desc=Excel_Lib.getData(INPUT_PATH,"Modify_TC",2,0);
	     actual[4]=tr.addNode(Name, Desc);
	     bp.waitForElement();
	     bp.waitForElement();
	     actual[5]=tr.doubleClickOnRelease(releaseName);
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

	
	@When("^Lead Selects a Testcase and moves to DetailView$")
	public void lead_Selects_a_Testcase_and_moves_to_DetailView() throws Throwable 
	{
		try
		{
		String navigation[]=new String[1];
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,0);
	     actual[6]=tr.navigateToNode(releaseName, navigation);
	     bp.waitForElement();
	     actual[7]=tr.addTestCase();
	     bp.waitForElement();
	     actual[8]=tr.clickDetailButton();
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

	
	@When("^Lead Modify the Testcase Name, Description and save it$")
	public void lead_Modify_the_Testcase_Name_Description_and_save_it() throws Throwable 
	{
		try
		{
		String testCaseName=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,2);
	     String testCaseDesc=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,3);
	     actual[9]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		 String changedName=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,2);
		 bp.waitForElement();
		 String modifiedTC=ctc.l1.get(0).getText();
		 boolean status=changedName.contains(modifiedTC);
		 log.info(status);
//		 SoftAssert sa=new SoftAssert();
//		 sa.assertEquals(status, true);
//		 sa.assertAll();
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

	
	@When("^Lead Modify the Priority, TagValue and save it$")
	public void lead_Modify_the_Priority_TagValue_and_save_it() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		String details[]=new String[4];
		details[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,4);
		System.out.println( details[0]);
		details[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Modify_TC",1,5));
		System.out.println(details[1]);
		details[2]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",99,99);
		details[3]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,7);
		actual[10]=ctc.enterTestCaseDetail(details);
		
		
	    String tags[]=new String[2];
	    tags[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",2,6);
	    tags[1]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",3,6);
	    actual[11]=ctc.enterMultipleTags(tags);
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

	
	@When("^Lead Modify the EstimatedTime and save it$")
	public void lead_Modify_the_EstimatedTime_and_save_it() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Modify_TC",1,8));
		String hr=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Modify_TC",1,9));
		String mn=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Modify_TC",1,10));
		actual[12]= ctc.enterEstimatedTime(day, hr, mn);
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

	
	@When("^Lead Modify the TestSteps and save it$")
	public void lead_Modify_the_TestSteps_and_save_it() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		String stepDetails[]=new String[3];
		stepDetails[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,11);
		stepDetails[1]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,12);
		stepDetails[2]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,13);
		actual[13]=ctc.enterTestCaseStepDetail(stepDetails);
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

	
	@Then("^As Lead Testcase should be Modified Successfully$")
	public void as_Lead_Testcase_should_be_Modified_Successfully() throws Throwable 
	{
		try
		{
			
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     
	    log.info("Pass - As Lead Testcase should be Modified Successfully");
	    
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
