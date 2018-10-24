package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CopyFromProjects_808613 extends LaunchBrowser 
{
	
	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	
   boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
	
	   String fileName="CopyFromProjects_808613";
	   
	@Given("^User is in the test Repository page of normal project$")
	public void user_is_in_the_test_Repository_page_of_normal_project() throws Throwable 
	{
		try
		{
		
//		 lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   //String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",2,0);
//		  // String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",2,1);
//		   String Uname="resource1.tester";
//		   String Pass="resource1.tester";
//		   lp.enterUname(Uname);
//	         lp.enterPass(Pass);
//		   lp.clickOnLogin();
		 
		
	
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User selects the phase from another normal project from global area$")
	public void user_selects_the_phase_from_another_normal_project_from_global_area() throws Throwable {
	   
		try
		{
		cfp=new CopyFromProjects(driver);
		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_2");
		 actual[3]=cfp.selectProjectFromGlobalArea(project);
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] globalPhase=new String[1];
		globalPhase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",6,3);
		 actual[4]=cfp.selectNodeFromGlobalArea(releaseName, globalPhase);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^select the current release$")
	public void select_the_current_release() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 actual[5]=cfp.selectingLocalRelease(releaseName);
		}catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^drag and drop the phase from another normal project to local release$")
	public void drag_and_drop_the_phase_from_another_normal_project_to_local_release() throws Throwable {
		try
		{
		String globalPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",6,3);
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 actual[6]=cfp.dragAndDropNodes(globalPhase, releaseName);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^selected phase should be copied to the local release$")
	public void selected_phase_should_be_copied_to_the_local_release() throws Throwable {
	 
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 6, 3);
		 actual[7]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 actual[8]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 actual[9]=tr.navigateToNode1(releaseName, phase);
		 if(actual[6]=true)
		 {
			 log.info("Phase Sucessfully Copied to the Current Release");
		 }
		
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	System.out.println(actual[k]);
	    	soft.assertEquals(actual[k], true);
	    }
		soft.assertAll();

	}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
	


	
}
