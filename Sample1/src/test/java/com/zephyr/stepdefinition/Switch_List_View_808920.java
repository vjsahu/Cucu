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

public class Switch_List_View_808920 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	String fileName="Switch_List_View_808920";
	
	boolean[] actual=new boolean[16];
	 SoftAssert soft=new SoftAssert();
	@Given("^User is in the page of TestRepository$")
	public void user_is_in_the_page_of_TestRepository() throws Throwable {
	    
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		  // WebDriver driver = null;
		 lp=new LoginPage(driver);
		    String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		  String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	try
	{
		bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   
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

	@When("^User Creates Two Phases and Add Few TestCases$")
	public void user_Creates_Two_Phases_and_Add_Few_TestCases() throws Throwable {
	   
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 5, 0);
		String Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 5, 3);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.doubleClickOnRelease(releaseName);
		//p_Name3=UNIQUE
		actual[4]=tr.addNode(p_Name1,Desc1);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		actual[5]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		bp.waitForElement();
		actual[6]=tr.navigateToNode(releaseName, phase);
		for(int i=0;i<=1;i++)
		{
			actual[7]=tr.addTestCase();
		}
		tr.doubleClickOnRelease(releaseName);
		
		String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 7, 0);
		String Desc2=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 3);
		
		tr=new TestRepositoryPage(driver);
		actual[8]=tr.doubleClickOnRelease(releaseName);
		actual[9]=tr.addNode(p_Name2,Desc2);
		String[] phase1=new String[1];
		phase1[0]=p_Name2;
		actual[10]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		bp.waitForElement();
		actual[11]=tr.navigateToNode(releaseName, phase1);
		for(int i=0;i<=2;i++)
		{
			actual[12]=tr.addTestCase();
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
		
		
		
		/*String[] Str1=new String[2];
		Str1[0]="abc1";
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		
		Str1[1]="abc2";
		tr.addTestCase();
		tr.addTestCase();
		//tr.addTestCase();*/
		
	}

	@When("^User Navigates from Detail view to List View$")
	public void user_Navigates_from_Detail_view_to_List_View() throws Throwable {
		
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		actual[13]=tr.verifyPastTestCase();
		bp.waitForElement();
		actual[14]=tr.SwitchView();
		actual[15]=tr.verifyPresentTestCase();
	
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

	@Then("^Navigation is done successfully$")
	public void navigation_is_done_successfully() throws Throwable {
	   
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("Navigation is done from detail view to list view successfully");
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
	

	

