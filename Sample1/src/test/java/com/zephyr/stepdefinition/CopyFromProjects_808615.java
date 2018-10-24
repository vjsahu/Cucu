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

public class CopyFromProjects_808615 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808615";
   boolean[] actual=new boolean[10];
	
	SoftAssert soft=new SoftAssert();

	
	
	@Given("^User is in test repository page of normal project$")
	public void user_is_in_test_repository_page_of_normal_project() throws Throwable {
	    
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
@When("^User selects the subsystem in restricted project from global area$")
public void user_selects_the_subsystem_in_restricted_project_from_global_area() throws Throwable {
	
	try
	{
	cfp=new CopyFromProjects(driver);
	 String globalProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_1");
	 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	 
	 String[] subsystem=new String[3];
	 subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
	 subsystem[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,4);
	 subsystem[2]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,5);
	 actual[3]=cfp.selectProjectFromGlobalArea(globalProject);
	 actual[4]=cfp.selectNodeFromGlobalArea(releaseName, subsystem);
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

@When("^select the current release and navigate to local system$")
public void select_the_current_release_and_navigate_to_local_system() throws Throwable {
	try
	{
	String localRelease=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String[] system=new String[2];
	system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,3);
	system[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,4);
	 
	actual[5]=cfp.selectingNodeFromLocalArea(localRelease, system);
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


@When("^drag and drop the subsystem from restricted project to local system$")
public void drag_and_drop_the_subsystem_from_restricted_project_to_local_system() throws Throwable {
   
	try
	{
	String subsystem=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,5);
	String localSystem=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,4);
	actual[6]=cfp.dragAndDropNodes(subsystem, localSystem);
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


@Then("^selected subsystem should be copied to the local system$")
public void selected_subsystem_should_be_copied_to_the_local_system() throws Throwable
{
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
	String[] system=new String[2];
	system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,3);
	system[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,4);
	 
	 actual[7]=cfp.closeCopyFromProjectReleasesPage();
	 bp=new BasePage();
	 bp.waitForElement();
	 tr=new TestRepositoryPage(driver);
	 actual[8]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	 actual[9]=tr.navigateToNode1(releaseName,system);
	 
	 if(actual[6]=true)
	 {
		 log.info("Subsystem Sucessfully Copied to the Current Release local System");
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
	e.printStackTrace();
	driver.close();
  	Relogin rl=new Relogin();
  	rl.reLogin();
  	throw e;
	 
}
	 



}
}
