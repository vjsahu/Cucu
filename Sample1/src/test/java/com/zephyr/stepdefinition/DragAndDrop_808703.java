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

public class DragAndDrop_808703 extends LaunchBrowser  
{
	
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName=" DragAndDrop_808703";
	
	boolean[] actual=new boolean[19];
    SoftAssert soft=new SoftAssert();
    
    
    @Given("^User is in the test Repository page$")
    public void user_is_in_the_test_Repository_page() throws Throwable {
    	try
		{

//	    
//			lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",3,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",3,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
//	
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
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
    }


    
	@When("^User create a phase, system and subsystem to current release$")
	public void user_create_a_phase_system_and_subsystem_to_current_release() throws Throwable {
	    
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 0);
		String Desc1=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 1);
		String p_Name2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 10, 0);
		String Desc2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 10, 1);
		String p_Name3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 11, 0);
		String Desc3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 11, 1);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.doubleClickOnRelease(releaseName);
		actual[4]=tr.addNode(p_Name1, Desc1);
		bp.waitForElement();
		bp.waitForElement();
		actual[5]=tr.doubleClickOnRelease(releaseName);
		
		bp.waitForElement();
		String[] phase=new String[1];
		phase[0]=p_Name1;
		
		actual[6]=tr.navigateToNode(releaseName, phase);
		actual[7]=tr.addNode(p_Name2, Desc2);
		String[] system=new String[2];
		system[0]=p_Name1;
		system[1]=p_Name2;
		bp.waitForElement();
		bp.waitForElement();
		actual[8]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[9]=tr.navigateToNode(releaseName, system);
		
		
		actual[10]=tr.addNode(p_Name3, Desc3);
		bp.waitForElement();
		bp.waitForElement();
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
	
	@When("^User navigate to current subsystem$")
	public void user_navigate_to_current_subsystem() throws Throwable {
		try
		{
			bp=new BasePage();
					
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] subsystem=new String[3];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",9,0);
		subsystem[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",10,0);
		subsystem[2]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",11,0);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[11]=tr.navigateToNode(releaseName, subsystem);
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
	
	@When("^drag and drop the current subsystem to current release$")
	public void drag_and_drop_the_current_subsystem_to_current_release() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	    String subsystem=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",11,0);
	    bp.waitForElement();
	    actual[12]=tr.dragAndDropNode(subsystem, releaseName);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
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
	
	@Then("^subsystem should be moved to the current release$")
	public void subsystem_should_be_moved_to_the_current_release() throws Throwable {
		
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] phase=new String[1];
	 
	    phase[0]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",11,0);
	    bp.waitForElement();
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    actual[13]=tr.navigateToNode(releaseName, phase);
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    
	    
	    if(actual[13]=true)
	    {
	    	log.info("Subsystem moved to the Current release");
	    }
	    	
	   
		
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
	
	@When("^User navigate to current system$")
	public void user_navigate_to_current_system() throws Throwable {
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] system=new String[2];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",9,0);
		system[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",10,0);
		bp.waitForElement();
		actual[14]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[15]=tr.navigateToNode(releaseName, system);
		bp.waitForElement();
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

	
	@When("^drag and drop the current system to current release$")
	public void drag_and_drop_the_current_system_to_current_release() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		String currentSystem=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",10,0);
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		
		actual[16]=tr.dragAndDropNode(currentSystem, releaseName);
	    bp.waitForElement();
	    bp.waitForElement();
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

	@Then("^system should be moved to the current release$")
	public void system_should_be_moved_to_the_current_release() throws Throwable {
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String phase[]=new String[1];
		phase[0]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",10,0);
		bp.waitForElement();
		actual[17]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[18]=tr.navigateToNode1(releaseName, phase);
		bp.waitForElement();
		
		
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
