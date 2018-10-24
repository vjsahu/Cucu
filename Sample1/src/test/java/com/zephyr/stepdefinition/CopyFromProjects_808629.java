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

public class CopyFromProjects_808629 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808629";
   boolean[] actual=new boolean[8];
	
	SoftAssert soft=new SoftAssert();
	
	@When("^User selects the node in isolated project from global area$")
	public void user_selects_the_node_in_isolated_project_from_global_area() throws Throwable 
	{
		try
		{
		 cfp=new CopyFromProjects(driver);
		 String globalProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_2");
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 
		 String[] node=new String[1];
		 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",4,3);
		
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

	@When("^User select the current release and navigate to local Phase of restricted project$")
	public void user_select_the_current_release_and_navigate_to_local_Phase_of_restricted_project() throws Throwable {
	    // 
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

	@When("^drag and drop the test case from isolated project to local phase of restricted project$")
	public void drag_and_drop_the_test_case_from_isolated_project_to_local_phase_of_restricted_project() throws Throwable {
	   
		try
		{
		String[] testCase=new String[2];
		testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
		testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
		

	    actual[3]=cfp.selectMultipleTestCaseFromGlobalNode(testCase);
		WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
		System.out.println(ele);
		//String localPhase=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,4);
		
	    String localPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
		
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

	@Then("^selected test case should be copied to the local Phase of restricted project$")
	public void selected_test_case_should_be_copied_to_the_local_Phase_of_restricted_project() throws Throwable {
	try
	{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",3,3);
		 actual[5]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 actual[6]=tr.doubleClickOnRelease(releaseName);
		 actual[7]=tr.navigateToNode1(releaseName, phase);
		 if(actual[4]=true)
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
