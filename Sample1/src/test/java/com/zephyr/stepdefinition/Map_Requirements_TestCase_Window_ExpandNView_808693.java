package com.zephyr.stepdefinition;

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
import cucumber.api.java.en.When;

public class Map_Requirements_TestCase_Window_ExpandNView_808693 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	String fileName="Map_Requirements_TestCase_Window_ExpandNView_808693";
	
	
	@Given("^User is in the Requirements Page$")
	public void user_is_in_the_Requirements_Page() throws Throwable {
	    try
	    {

		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		  // WebDriver driver = null;
		 lp=new LoginPage(driver);
		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,0);
		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,0);
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	    	bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   bp.waitForElement();
		   pp.selectProject(projectName);
		   bp.waitForElement();
		   pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		  bp.waitForElement();
		  bp.waitForElement();
		   rp.clickOnRequirements();
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

	@Given("^User Creates a node and Two sub nodes a in Tree Structure$")
	public void user_Creates_a_node_and_Two_sub_nodes_a_in_Tree_Structure() throws Throwable {
	   try
	   {
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 10, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 10, 3);
		
		req=new RequirementsPage(driver);
		bp.waitForElement();
		req.doubleClickOnRelease(releaseName);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		req.addNode(p_Name1,p_Desc1);
		bp.waitForElement();
		req.doubleClickOnRelease(releaseName);
		//String[] phase=new String[1];
		//phase[0]=p_Name1;
		tr=new TestRepositoryPage(driver);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 1);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 1);
		tr.navigateToNode(releaseName,phase );
		bp.waitForElement();
		req.addNode(s_Name1,s_Desc1);
		bp.waitForElement();
		req.doubleClickOnRelease(releaseName);
		
		
		
		String[] system= new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 2);
		String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 2);
		tr.navigateToNode(releaseName, system);
		bp.waitForElement();
		req.addNode(ss_Name1,ss_Desc1);
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

	@When("^User is in the TestRepository Page and Creates a Node and Adds a TestCase$")
	public void user_is_in_the_TestRepository_Page_and_Creates_a_Node_and_Adds_a_TestCase() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		   tr=new TestRepositoryPage(driver); 
		   bp.waitForElement();
		   bp.waitForElement();
		   rp.clickOnTestRep();
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String s_Name1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 1);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 1);
		tr.doubleClickOnRelease(releaseName);
		tr.addNode(s_Name1,s_Desc1);
		tr.doubleClickOnRelease(releaseName);
		String[] system= new String[1];
		system[0]=s_Name1;
		tr.navigateToNode(releaseName,system );
		
		bp=new BasePage();
		bp.waitForElement();
		tr.addTestCase();
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

	@Then("^User Goto Details View and Map Requirements and select the Release Node$")
	public void user_Goto_Details_View_and_Map_Requirements_and_select_the_Release_Node() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			bp.waitForElement();
			req.MapRequirements();
			bp.waitForElement();
			tr.clickOnReleaseCheckBox.click();
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

	@Then("^After Expanding the Release node all the nodes under it are remain selected successfully$")
	public void after_Expanding_the_Release_node_all_the_nodes_under_it_are_remain_selected_successfully() throws Throwable {
	    try
	    {
		 bp=new BasePage();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		
		req=new RequirementsPage(driver);
		bp.waitForElement();
		req.ExpandRelease(releaseName);
		bp.waitForElement();
		req.closeInstructionWindow.click();
		//bp.waitForElement();
		//req.saveRequirement();
		bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement();
		log.info("All the node are selected");
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
