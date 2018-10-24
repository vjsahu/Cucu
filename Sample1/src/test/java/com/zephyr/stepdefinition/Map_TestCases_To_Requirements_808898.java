package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Map_TestCases_To_Requirements_808898 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	String fileName="Map_TestCases_To_Requirements_808898";
	
	boolean[] actual=new boolean[12];
	 SoftAssert soft=new SoftAssert();
	 
	@Given("^User is in the page of testRepository$")
	public void user_is_in_the_page_of_testRepository() throws Throwable {
	     
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		   lp=new LoginPage(driver);
		    String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		  String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   bp=new BasePage();
		   rp= new ReleasePage(driver);
			bp.waitForElement();  
			actual[2]=rp.clickOnRequirements();
		  
	
		   	//String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 4, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 4, 3);
			
			
			req=new RequirementsPage(driver);
			actual[3]=req.doubleClickOnRelease(releaseName);
			
			req.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr=new TestRepositoryPage(driver);
			actual[4]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[5]=tr.navigateToNode(releaseName, phase);
			req.addRequirement();
			//req.addRequirement();
		   
			//bp.waitForElement();
			bp.waitForElement();
		   rp= new ReleasePage(driver);
		   bp.waitForElement();
		   actual[6]=rp.clickOnTestRep(); }
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

	@Given("^User creating a phase$")
	public void user_creating_a_phase() throws Throwable {
	    try
	    {
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 4, 6);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 4, 3);
		
		tr=new TestRepositoryPage(driver);
		actual[7]=tr.doubleClickOnRelease(releaseName);
		actual[8]=tr.addNode(p_Name1,p_Desc1);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[5]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		///bp.waitForElement();
		actual[6]=tr.navigateToNode(releaseName,phase );
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

	@Then("^User creating a two-three test cases$")
	public void user_creating_a_two_three_test_cases() throws Throwable {
	 try
	 {
		for(int i=0;i<=1;i++)
		{
			actual[9]=tr.addTestCase();
		}
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

	@Then("^User navigates to test case details$")
	public void user_navigates_to_test_case_details() throws Throwable {
	   try
	   {
		   tr.clickDetailButton();
		//tr.clickOnDetailView.click();
		tr.verifyPresentTestCase();
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

	@Then("^User Maps Requirements to test case$")
	public void user_Maps_Requirements_to_test_case() throws Throwable {
	 try
	 {
		 req=new RequirementsPage(driver);
		actual[10]=req.MapRequirements();
		bp=new BasePage();
		bp.waitForElement();
		tr.clickOnReleaseCheckBox.click();
		bp.waitForElement();
		actual[11]=req.saveRequirement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		//tr.clickOnMappedRequirements.click();
		
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

	@Then("^User views the details view of the test cases$")
	public void user_views_the_details_view_of_the_test_cases() throws Throwable {
	   try
	   {
		   for(int k=0;k<=actual.length-1;k++)
		     {
			  System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();

		log.info("User views the details view of the test cases successfully");

		int count=tr.validateMappedRequirement();
		System.out.println(count);
		bp.waitForElement();
		tr.clickOnList();
		
		tr.clickOnFolder();
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
