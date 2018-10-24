package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class CopyFromProjects_808641 extends LaunchBrowser
{
	
	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	
	boolean[] actual=new boolean[6];
    SoftAssert soft=new SoftAssert();
	
    String fileName="CopyFromProjects_808641";
    
	@When("^User select the local phase of current release isolated project$")
	public void user_select_the_local_phase_of_current_release_isolated_project() throws Throwable {
		try
		{
		String localRelease=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",5,3);
		
		 cfp=new CopyFromProjects(driver);
		actual[0]=cfp.selectingNodeFromLocalArea(localRelease, phase);
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

	@When("^drag and drop the test case from normal project to local phase of isolated project$")
	public void drag_and_drop_the_test_case_from_normal_project_to_local_phase_of_isolated_project() throws Throwable 
	{
		try
		{
		  
				String[] testCase=new String[2];
				testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
				testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
				
				actual[1]=cfp.selectMultipleTestCaseFromGlobalNode(testCase);
				WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
				//String localPhase=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",2,4);
				
			    String localPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",5,3);
				
			    actual[2]=cfp.dragAndDropTestCase(ele, localPhase);
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

	@Then("^selected test case should be copied to the local phase of isolated project$")
	public void selected_test_case_should_be_copied_to_the_local_phase_of_isolated_project() throws Throwable {
	  
		try
		{
	

		
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",5,3);
		 
		 actual[3]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 actual[4]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 actual[5]=tr.navigateToNode1(releaseName,phase);
		 
		 if(actual[5]=true)
		 {
			 log.info("Test Case Copied to the Current Release local Phase");
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


