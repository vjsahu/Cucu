package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Edit_Copy_GlobalTOLocalRelease_808694 extends LaunchBrowser
{
	
	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	ImportPage ip;
	CopyFromProjects cp;
	
	String fileName="Edit_Copy_GlobalTOLocalRelease_808694";
	
	boolean[] actual=new boolean[12];
	 SoftAssert soft=new SoftAssert();
	@Given("^user is present in the repository page$")
	public void user_is_present_in_the_repository_page() throws Throwable 
	{
		try
		{
		pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@Given("^Select the Copy from release option$")
	public void select_the_Copy_from_release_option() throws Throwable 
	{
		try
		{
		
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
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

	@When("^drag the imported node from global release$")
	public void drag_the_imported_node_from_global_release() throws Throwable
	{
		try
		{
			bp.waitForElement();
		    bp.waitForElement();
		    cp=new CopyFromProjects(driver);
		    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		    actual[4]=cp.selectProjectFromGlobalArea(projectName);
		    bp.waitForElement();
		    bp.waitForElement();
		    String[] impnod=new String[1];
		    impnod[0]=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
		    //str1[0]="allFields.xls Aug:10:2017::09:17:11";
		    actual[5]=cp.selectNodeFromImportedArea(impnod);
		    bp.waitForElement();
		    
		    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
			//actual[6]=tr.doubleClickOnRelease(releaseName);
			actual[6]= bp.waitForElement();
		    String[] phase=new String[3];
		    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",13,1);
		    phase[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,1);
		    phase[2]=Excel_Lib.getData(INPUT_PATH_4,"Phase",15,1);
		    actual[7]=cp.selectingNodeFromLocalArea(releaseName, phase);
		    bp.waitForElement();
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^drop the node in local relase$")
	public void drop_the_node_in_local_relase() throws Throwable 
	{
		try
		{
			 //drag and drop to phase
		    String impnode1=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
		   String phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",13,1);
		   actual[8]=cp.dragAndDropImportedNodes(impnode1, phase1);
		    bp.waitForElement();
		    bp.waitForElement();
		    
		    
		    
		  //drag and drop to system
		    
		    String[] system_1=new String[1];
		    system_1[0]=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,1);
		    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
		    bp.waitForElement();
		    String system=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,1);
		    cp.selectingNodeFromLocalArea(releaseName, system_1);
		    
		   actual[9]=cp.dragAndDropImportedNodes(impnode1, system);
		    
		    bp.waitForElement();
		    bp.waitForElement();
		    
		 //drag and drop to Subsystem
			//String impnode=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 2, 0);
		    //actual[5]=cp.selectNodeFromImportedArea(impnod);
		    bp.waitForElement();
		    String[] subystem_1=new String[2];
		    subystem_1[0]=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,1);
		    subystem_1[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",15,1);
		    
		    cp.selectingNodeFromLocalArea(releaseName, subystem_1);
		  String subsystem=Excel_Lib.getData(INPUT_PATH_4,"Phase",15,1);
		  actual[10]=cp.dragAndDropImportedNodes(impnode1, subsystem);
			    bp.waitForElement();
			    bp.waitForElement();
			    
			    actual[11]=cp.closeCopyFromProjectReleasesPage(); 
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
		    
	}

	@Then("^should able to copy$")
	public void should_able_to_copy() throws Throwable 
	{
		try
		{
	    for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		}
		catch (Exception e) 
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
