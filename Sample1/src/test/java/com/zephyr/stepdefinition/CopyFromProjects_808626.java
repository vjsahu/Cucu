package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class CopyFromProjects_808626 extends LaunchBrowser
{
	
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808626";
	
   boolean[] actual=new boolean[10];
	
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in test repository page of restricted project$")
	public void user_is_in_test_repository_page_of_restricted_project() throws Throwable {
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
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_1");
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

	@When("^User selects the system in normal project from global area$")
	public void user_selects_the_system_in_normal_project_from_global_area() throws Throwable {
		try
		{
		cfp=new CopyFromProjects(driver);
		 String globalProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 
		 String[] system=new String[2];
		 system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,3);
		 system[1]=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,4);
		 
		 actual[3]=cfp.selectProjectFromGlobalArea(globalProject);
		 actual[4]=cfp.selectNodeFromGlobalArea(releaseName, system);
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

	@When("^User select the current release and navigate to local phase of restricted project$")
	public void user_select_the_current_release_and_navigate_to_local_phase_of_restricted_project() throws Throwable {
	   
		try
		{
		String localRelease=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] phase=new String[1];
        phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
		
		 
		actual[5]=cfp.selectingNodeFromLocalArea(localRelease, phase);
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

	@When("^drag and drop the test case from system of normal project to local phase$")
	public void drag_and_drop_the_test_case_from_system_of_normal_project_to_local_phase() throws Throwable {
		try
		{
			bp=new BasePage();
		String[] testCase=new String[2];
		testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
		testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
		cfp=new CopyFromProjects(driver);
		cfp.selectMultipleTestCaseFromGlobalNode(testCase);
		WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
		//String localPhase=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,4);
		
	    String localPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
		
	    actual[6]=cfp.dragAndDropTestCase(ele, localPhase);
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

	@Then("^selected test case should be copied to the local phase of restricted project$")
	public void selected_test_case_should_be_copied_to_the_local_phase_of_restricted_project() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
		 actual[7]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 actual[8]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 actual[9]=tr.navigateToNode1(releaseName, phase);
		 if(actual[6]=true)
		 {
			 log.info("Test Case Sucessfully Copied to the local phase of restricted project");
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

