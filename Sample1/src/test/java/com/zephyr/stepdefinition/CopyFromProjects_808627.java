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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CopyFromProjects_808627 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808627";
	
   boolean[] actual=new boolean[7];
	
	SoftAssert soft=new SoftAssert();
	
	@When("^User selects the Subsystem in restricted project from global area$")
	public void user_selects_the_Subsystem_in_restricted_project_from_global_area() throws Throwable 
	{
		try
		{
		 cfp=new CopyFromProjects(driver);
		 String globalProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_2");
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 
		 String[] subsystem=new String[3];
		 subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",4,3);
		 subsystem[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",4,4);
		 subsystem[2]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",4,5);
		 
		 actual[0]=cfp.selectProjectFromGlobalArea(globalProject);
		 actual[1]=cfp.selectNodeFromGlobalArea(releaseName, subsystem);
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

	@When("^User select the current release and navigate to local phase of current restricted project$")
	public void user_select_the_current_release_and_navigate_to_local_phase_of_current_restricted_project() throws Throwable 
	{
		try
	{
	String localRelease=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String[] phase=new String[1];
    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
	
	 
	actual[2]=cfp.selectingNodeFromLocalArea(localRelease, phase);
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

	@When("^drag and drop the Subsystem of restricted project to local phase$")
	public void drag_and_drop_the_Subsystem_of_restricted_project_to_local_phase() throws Throwable 
	{
		try
		{
	   String subsystem=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",4,5);
	   String localPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
	   actual[3]=cfp.dragAndDropNodes(subsystem, localPhase);
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

	@Then("^selected subsystem should be copied to the local phase of current restricted project$")
	public void selected_subsystem_should_be_copied_to_the_local_phase_of_current_restricted_project() throws Throwable {
	    
	


		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] subsystem=new String[2];
		 subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
		 subsystem[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",4,5);
		 //subsystem[2]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",4,5);
		 actual[4]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 actual[5]=tr.doubleClickOnRelease(releaseName);
		 actual[6]=tr.navigateToNode1(releaseName, subsystem);
		 if(actual[3]=true)
		 {
			 log.info("Subsystem Copied to the local phase of restricted project");
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




