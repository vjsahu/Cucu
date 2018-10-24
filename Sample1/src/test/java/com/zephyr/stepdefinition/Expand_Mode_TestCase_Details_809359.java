package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Expand_Mode_TestCase_Details_809359 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	String fileName="Expand_Mode_TestCase_Details_809359";
	
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	

	@When("^User Creates a Phase,System and Subsystems$")
	public void user_Creates_a_Phase_System_and_Subsystems() throws Throwable {
	    try
	    {
	    	tr=new TestRepositoryPage(driver);
	    	bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 4, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 4, 3);
		
		
		actual[0]=tr.doubleClickOnRelease(releaseName);
		actual[1]=tr.addNode(p_Name1,p_Desc1);
		
		String[] phase=new String[1];
		phase[0]=p_Name1;
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 4, 1);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 4, 4);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[2]=tr.navigateToNode(releaseName,phase );
		bp.waitForElement();
		actual[3]=tr.addNode(s_Name1,s_Desc1);
		bp.waitForElement();
		
		
		String[] system=new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 4, 2);
		String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 4, 5);
		actual[4]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[5]=tr.navigateToNode(releaseName, system);
		bp.waitForElement();
		actual[6]=tr.addNode(ss_Name1,ss_Desc1);
		bp.waitForElement();
		
		String[] subsystem=new String[3];
		subsystem[0]=p_Name1;
		subsystem[1]=s_Name1;
		subsystem[2]=ss_Name1;
		actual[7]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[8]=tr.navigateToNode(releaseName, subsystem);
		bp.waitForElement();
		
	    }
	    catch(Exception e)
	    {
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
	    driver.close();
	     Relogin rl=new Relogin();
	     rl.reLogin();
	     throw e;
	    }
		
	}

	@When("^User creates three testcases in subsystem and selects a testcase to view testcase details in Expanded Mode$")
	public void user_creates_three_testcases_in_subsystem_and_selects_a_testcase_to_view_testcase_details_in_Expanded_Mode() throws Throwable {
		try
		{
			for(int i=0;i<=2;i++)
			{
				actual[7]=tr.addTestCase();
			}
				
		bp.waitForElement();
		actual[8]=tr.ExpandMode();
		bp.waitForElement();
		bp.waitForElement();
		
		tr.clickOnShowBreadCrumbs.click();
		bp.waitForElement();
		
		tr.clickOnPhase.click();
		
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}
	
	@Then("^User views the testcase details in Expanded Mode successfully$")
	public void user_Views_the_TestCase_Details_in_Expanded_Mode_Successfully() throws Throwable {
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     log.info("User Views the TestCase Details in Expanded Mode Successfully");
		   }
		   catch(Exception e)
			 {
			   lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			   e.printStackTrace();
			  driver.close();
			  Relogin rl=new Relogin();
			  rl.reLogin();
			  throw e;
			 }
		
	    }
	
}

	

