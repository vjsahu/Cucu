package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_Phase_Sys_Subsys_Tree_Struc_808732 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	String fileName="Create_Tree_Structure_808732";
	
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	@Given("^User is in the page of a TestRepository page$")
	public void user_is_in_the_page_of_a_TestRepository_page() throws Throwable {
		
		try
		{
			/*lb=new LaunchBrowser();
			   lb.preCond();
			   
			   lp=new LoginPage(driver);
			  
			   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
			   lp.enterUname(Uname);
			  // bp.waitForElement();
			   lp.enterPass(Pass);
			   lp.clickOnLogin();*/
			   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		  actual[0]= pp.selectProject(projectName);
		  actual[1]=pp.selectRelease(releaseName);
		  bp.waitForElement();
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
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

	@Given("^User creates a phase under the release$")
	public void user_creates_a_phase_under_the_release() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 3);
		
		
		actual[3]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]=tr.addNode(p_Name1,p_Desc1);
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

	@When("^User creates system under the release$")
	public void user_creates_system_under_the_release() throws Throwable {
		
		try
		{
	    tr=new TestRepositoryPage(driver);
	    bp=new BasePage();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 0);
		actual[5]=tr.doubleClickOnRelease(releaseName);
		
		String[] phase=new String[1];
		phase[0]=p_Name1;
		String s_Name1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 1);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 4);
		bp.waitForElement();
		actual[6]=tr.navigateToNode(releaseName,phase );
		bp.waitForElement();
		bp.waitForElement();
		actual[7]=tr.addNode(s_Name1,s_Desc1);
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

	@When("^User creates subsystem under the system$")
	public void user_creates_subsystem_under_the_system() throws Throwable {
		
		try
		{
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		actual[8]=tr.doubleClickOnRelease(releaseName);
		String p_Name1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 0);
		String s_Name1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 1);
		
		
		String[] system= new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		
		String ss_Name1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 2);
		String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 1, 5);
		bp.waitForElement();
		bp.waitForElement();
		actual[9]=tr.navigateToNode(releaseName, system);
		bp.waitForElement();
		actual[10]=tr.addNode(ss_Name1,ss_Desc1);
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

	@Then("^User successfully verifies the bread crumbs$")
	public void user_successfully_verifies_the_bread_crumbs() throws Throwable {
	 
		try
		{
		//bp=new BasePage();
		
		
		np= new NavigationPage(driver);
		String[] str9=new String[4];//
		str9[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		str9[1]=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1,5 );
		str9[2]=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 1);
		str9[3]=Excel_Lib.getData(INPUT_PATH_3, "Phases", 6, 2);
		
		bp.waitForElement();
		actual[11]=np.checkingBreadCrumbs(str9);
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
    	
		log.info("Tree Structure has been created Successfully and breadCrumbs Verified");
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
