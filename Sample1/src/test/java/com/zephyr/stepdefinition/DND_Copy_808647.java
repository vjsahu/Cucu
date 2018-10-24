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

public class DND_Copy_808647 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DND_Copy_808647";
	boolean[] actual=new boolean[11];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in The repository page$")
	public void user_in_The_repository_page() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		    pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@Given("^select copy From release option$")
	public void select_copy_From_release_option() throws Throwable 
	{
		try
		{
		
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[2]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    tr.options.click();
	    bp.waitForElement();
	    tr.copyReleaseOption.click();
	    bp.waitForElement();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to normal Project and imported$")
	public void navigate_to_normal_Project_and_imported() throws Throwable 
	{
		try
		{
		bp.waitForElement();
	    bp.waitForElement();
	    cp=new CopyFromProjects(driver);
	    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	    actual[3]=cp.selectProjectFromGlobalArea(projectName);
	    bp.waitForElement();
	    bp.waitForElement();
	    String[] impnod=new String[1];
	    impnod[0]=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
	    //str1[0]="allFields.xls Aug:10:2017::09:17:11";
	    actual[4]=cp.selectNodeFromImportedArea(impnod);
	    bp.waitForElement();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to P/S/SS in Current Release$")
	public void navigate_to_P_S_SS_in_Current_Release() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
		//actual[5]=tr.doubleClickOnRelease(releaseName);
		actual[5]=bp.waitForElement();
	    String[] phase=new String[3];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",13,2);
	    phase[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,2);
	    phase[2]=Excel_Lib.getData(INPUT_PATH_4,"Phase",15,2);
	    actual[6]=cp.selectingNodeFromLocalArea(releaseName, phase);
	    bp.waitForElement();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^drag and drop the node to P/S/SS$")
	public void drag_and_drop_the_node_to_P_S_SS() throws Throwable 
	{
		try
		{
		 //drag and drop to phase
	    String impnode1=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
	   String phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",13,2);
	   actual[7]=cp.dragAndDropImportedNodes(impnode1, phase1);
	    bp.waitForElement();
	    bp.waitForElement();
	  //drag and drop to system
	    //String impnode=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 2, 0);
	   String system=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,2);
	   actual[8]=cp.dragAndDropImportedNodes(impnode1, system);
	    
	    bp.waitForElement();
	    bp.waitForElement();
		  //drag and drop to system
		    //String impnode=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 2, 0);
		   String subsystem=Excel_Lib.getData(INPUT_PATH_4,"Phase",15,2);
		   actual[9]= cp.dragAndDropImportedNodes(impnode1, subsystem);
		    bp.waitForElement();
		    bp.waitForElement();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^should able to copy and Close the page$")
	public void should_able_to_copy_and_Close_the_page() throws Throwable 
	{
		try
		{
			actual[10]=cp.closeCopyFromProjectReleasesPage(); 
			bp.waitForElement();
			 if(actual[10]=true)
			    {
			    	log.info("closed the copy from releases page");
			    }
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		}catch (Exception e) 
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
