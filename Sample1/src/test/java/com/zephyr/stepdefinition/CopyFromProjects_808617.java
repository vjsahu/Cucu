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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CopyFromProjects_808617 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808617";
	
   boolean[] actual=new boolean[8];
	
	SoftAssert soft=new SoftAssert();
	@When("^User selects the phase in restricted project from global area$")
	public void user_selects_the_phase_in_restricted_project_from_global_area() throws Throwable {
		try
		{
		cfp=new CopyFromProjects(driver);
		 String globalProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_1");
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
		
		 actual[0]=cfp.selectProjectFromGlobalArea(globalProject);
		 actual[1]=cfp.selectNodeFromGlobalArea(releaseName, phase);
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

	@Then("^test Case should be displyed$")
	public void test_Case_should_be_displyed() throws Throwable {
		try
		{
			cfp=new CopyFromProjects(driver);
		actual[2]=cfp.testCaseCountInCopyfromProjectReleases();
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

	@When("^User select the current release and navigate to local phase$")
	public void user_select_the_current_release_and_navigate_to_local_phase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] localPhase=new String[1];
		localPhase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,3);
	    actual[3]=cfp.selectingNodeFromLocalArea(releaseName, localPhase);
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

	@When("^drag and drop the test case from phase of restricted project to local phase$")
	public void drag_and_drop_the_test_case_from_phase_of_restricted_project_to_local_phase() throws Throwable {
	    try
	    {
	    String localPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,3);
		String[] testCase=new String[2];
	    testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
	    testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
	    cfp.selectMultipleTestCaseFromGlobalNode(testCase);
	    WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
	    
	    actual[4]=cfp.dragAndDropTestCase(ele, localPhase);
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

	
	@Then("^selected test case should be copied to the local phase$")
	public void selected_test_case_should_be_copied_to_the_local_phase() throws Throwable {
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] localPhase=new String[1];
		 localPhase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,3);
		 
		 
		 actual[5]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 actual[6]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 actual[7]=tr.navigateToNode1(releaseName, localPhase);
		 
		 if(actual[4]=true)
		 {
			 log.info("test case Sucessfully Copied to the Current Release");
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
	