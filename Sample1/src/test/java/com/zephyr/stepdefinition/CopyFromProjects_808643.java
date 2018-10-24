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

public class CopyFromProjects_808643 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808643";
	boolean[] actual=new boolean[6];
    SoftAssert soft=new SoftAssert();
    
    
    @Given("^User is in THE test repository page of isolated project$")
    public void user_is_in_THE_test_repository_page_of_isolated_project() throws Throwable {
    	  
    	try
    	{
    	 bp=new BasePage();
    	  lb=new LaunchBrowser();
//		   lb.preCond();
//		   String Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
//		   lb.getUrl(Url);
//		   lp=new LoginPage(driver);
//		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_2");
//		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Password_2");
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
//		   bp.waitForElement();
//		   
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Isolated_Project_1");
		   pp.selectProject(projectName);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		   pp.selectRelease(releaseName);
		   
		   rp=new ReleasePage(driver);
		   rp.clickOnTestRep();
		   
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
    
	
	
	@When("^User selects copy from other other project option from release context menu$")
	public void user_selects_copy_from_other_other_project_option_from_release_context_menu() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);  
		tr=new TestRepositoryPage(driver);
		   tr.doubleClickOnRelease(releaseName);
		   tr.clickOnCopyFromProjects();
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

	@When("^User selects the node in another Isolated project from global area$")
	public void user_selects_the_node_in_another_Isolated_project_from_global_area() throws Throwable {
		try
		{
		 cfp=new CopyFromProjects(driver);
		 String globalProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Isolated_Project_2");
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 
		 String[] node=new String[1];
		 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",7,3);
		
		 actual[0]=cfp.selectProjectFromGlobalArea(globalProject);
		 actual[1]=cfp.selectNodeFromGlobalArea(releaseName, node);
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

	@When("^User select the local phase of current release Isolated project$")
	public void user_select_the_local_phase_of_current_release_Isolated_project() throws Throwable {
		try
		{
		String localRelease=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] phase=new String[1];
        phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",5,3);
		
		 
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

	@When("^drag and drop the node from isolated project to local phase of Isolated project$")
	public void drag_and_drop_the_node_from_isolated_project_to_local_phase_of_Isolated_project() throws Throwable {
		try
		{
	   String globalPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 7, 3);
	   String localPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 5, 3);
	   actual[3]=cfp.dragAndDropNodes(globalPhase, localPhase);
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

	@Then("^selected phase should be copied to the local phase of Isolated project$")
	public void selected_phase_should_be_copied_to_the_local_phase_of_Isolated_project() throws Throwable {
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] system=new String[2];
		 system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 5, 3);
		 system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 7, 3);
		 actual[4]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 //actual[4]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 actual[5]=tr.navigateToNode1(releaseName, system);
		 if(actual[5]=true)
		 {
			 log.info("Phase Sucessfully Copied to the Current Release");
		 }
		
		 tr.doubleClickOnRelease(releaseName);
		 driver.close();
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
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		
	}


}
