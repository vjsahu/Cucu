package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CopyFromProjects_808595 extends LaunchBrowser 
{

	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	
   boolean[] actual=new boolean[5];
   SoftAssert soft=new SoftAssert();


   String fileName="CopyFromProjects_808595";
   
	@When("^select release two and navigate to phase containing test cases$")
	public void select_release_two_and_navigate_to_phase_containing_test_cases() throws Throwable 
	{
		try
		{
		String release=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 1);
		//String releaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 2);
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
	    cfp=new CopyFromProjects(driver);
	    actual[0]=cfp.selectNodeFromGlobalArea(release, phase);
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

	@When("^User select the local release$")
	public void user_select_the_local_release() throws Throwable {
	   
		try
		{
		String localRelease=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 1);
	    actual[1]=cfp.selectingLocalRelease(localRelease);
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

	@When("^drag and drop the Global phase to current release$")
	public void drag_and_drop_the_Global_phase_to_current_release() throws Throwable 
	{
		try
		{
	   String globalPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
	   String localRelease=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 1);
	   actual[2]=cfp.dragAndDropNodes(globalPhase, localRelease);
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

	@Then("^global phase should be copied to current release$")
	public void global_phase_should_be_copied_to_current_release() throws Throwable {
		
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
		 actual[3]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 ///actual[4]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 actual[4]=tr.navigateToNode1(releaseName, phase);
		 
		 tr.doubleClickOnRelease(releaseName);
		 if(actual[4]=true)
		 {
			 log.info("Global Phase Sucessfully Copied to the Current Release");
		 }
		
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	//System.out.println(actual[k]);
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
