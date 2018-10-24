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

public class CopyFromProjects_808588 extends LaunchBrowser
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808588";
    boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	@When("^User select same project from Global Area$")
	public void user_select_same_project_from_Global_Area() throws Throwable 
	{
		try
		{
		 cfp= new CopyFromProjects(driver);
		 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		 actual[0]=cfp.selectProjectFromGlobalArea(project);
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

	@When("^select release two, navigate to system containing test cases$")
	public void select_release_two_navigate_to_system_containing_test_cases() throws Throwable {
		
		try
		{
			
		String release=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 1);
		//String releaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 2);
	    String[] system=new String[2];
	    system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
	    system[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 4);
	    actual[1]=cfp.selectNodeFromGlobalArea(release, system);
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

	@When("^User expand the current project and select release one and naviagate to phase$")
	public void user_expand_the_current_project_and_select_release_one_and_naviagate_to_phase() throws Throwable {
		
		try
		{
			
		String release1=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop", 1, 1);
		String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
	    
	    actual[2]=cfp.selectingNodeFromLocalArea(release1, phase);
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

	@When("^drag and drop the two test case from Global system to current subsystem$")
	public void drag_and_drop_the_two_test_case_from_Global_system_to_current_subsystem() throws Throwable {
		
		try
		{
		String[] c=new String[2];
	    c[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "DragAndDrop", 1, 6));
	    c[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "DragAndDrop", 2, 6));
	    
	    actual[3]=cfp.selectMultipleTestCaseFromGlobalNode(c);
	    WebElement ele=driver.findElement(By.xpath("(//*[@title='Untitled'])[1]"));
	    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
	    
	    actual[4]=cfp.dragAndDropTestCase(ele,phase);
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

	@Then("^test case should be copied to current phase$")
	public void test_case_should_be_copied_to_current_phase() throws Throwable 
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
		 String[] phase=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
		 actual[5]=cfp.closeCopyFromProjectReleasesPage();
		 bp=new BasePage();
		 bp.waitForElement();
		 tr=new TestRepositoryPage(driver);
		 actual[6]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		
		actual[7]=tr.navigateToNode1(releaseName, phase);
		
		actual[8]=tr.verifyPresentTestCase();
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
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}

		


	}

	}



