package com.zephyr.stepdefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

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

public class Mapping_TestCase_Requirement_808598 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	String fileName="Mapping_TestCase_Requirement_808598";

	@Given("^User is in the Page Of Requirements and Add a node and Add two to three  Requirements$")
	public void user_is_in_the_Page_Of_Requirements_and_Add_a_node_and_Add_two_to_three_Requirements() throws Throwable {
	 
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		  // WebDriver driver = null;
		 lp=new LoginPage(driver);
		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,0);
		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,0);
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	try
	{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   pp.selectProject(projectName);
		   pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		  
		   rp.clickOnRequirements();
		  
		   bp=new BasePage();
		   	//String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 2, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 2, 3);
			
			req=new RequirementsPage(driver);
			
			req.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			req.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			req.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String[] phase=new String[1];
			phase[0]=p_Name1;
			req.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr=new TestRepositoryPage(driver);
			tr.navigateToNode(releaseName, phase);
			req.addRequirement();
			req.addRequirement();
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

	@When("^User is in the Page of TestRepository and Creates a phase and Creates a testcase$")
	public void user_is_in_the_Page_of_TestRepository_and_Creates_a_phase_and_Creates_a_testcase() throws Throwable {
	   try
	   {
		   bp.waitForElement();
		   rp.clickOnTestRep();
		   
		   tr.clickOnList();
		tr=new TestRepositoryPage(driver);
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 3, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 3, 3);
		//tr.doubleClickOnRelease(releaseName);
		String[] phase= new String[1];
		//[0]=p_Name1;
		phase[0]=p_Name1;
		//tr=new TestRepositoryPage(driver);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.addNode(p_Name1,p_Desc1);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.navigateToNode(releaseName,phase );
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

	@When("^User go to TestCase Details view and Maps a Requirement$")
	public void user_go_to_TestCase_Details_view_and_Maps_a_Requirement() throws Throwable {
	    try
	    {
		bp=new BasePage();
		tr.clickDetailButton();
		req.MapRequirements();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		req.ExpandRelease(releaseName);
		
		bp.waitForElement();
		
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 2, 0);
		String[] phase=new String[1];
		phase[0]=p_Name1;
	    tr=new TestRepositoryPage(driver);
	    bp.waitForElement();
	    tr.navigateToNode(releaseName, phase);
	    bp.waitForElement();
	    String requirementNum=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Requirements", 1, 0));
		req.selectRequirement(requirementNum);
		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.DOWN).perform();
		
		bp.waitForElement();
		bp.waitForElement();
		req.saveRequirement();
		bp.waitForElement();
		tr.clickOnList();
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

	@Then("^Mapping of single testcase to a Requirement is done successfully$")
	public void mapping_of_single_testcase_to_a_Requirement_is_done_successfully() throws Throwable {
	    
		log.info("Mapping of Single TestCase to a Requirement is done Successfully");
	}

}
