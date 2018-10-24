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

public class DND_copy_808619 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DND_copy_808619";
	
	boolean[] actual=new boolean[12];
	 SoftAssert soft=new SoftAssert();
	@Given("^user In the Repository page$")
	public void user_In_the_Repository_page() throws Throwable 
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

	@Given("^select copy Release option$")
	public void select_copy_Release_option() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
	    tr.clickOnCopyFromProjects();
//	    bp.waitForElement();
//	    tr.options.click();
//	    bp.waitForElement();
//	    tr.copyReleaseOption.click();
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

	@When("^navigate to normal project and select imported node$")
	public void navigate_to_normal_project_and_select_imported_node() throws Throwable 
	{
		try
		{
		 bp.waitForElement();
		    bp.waitForElement();
		    cp=new CopyFromProjects(driver);
		    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		    actual[4]=cp.selectProjectFromGlobalArea(projectName);
		    String[] impnod=new String[1];
		    impnod[0]=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
		    //str1[0]="allFields.xls Aug:10:2017::09:17:11";
		    actual[5]=cp.selectNodeFromImportedArea(impnod);
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

	@When("^drag and drop to phase system and subsystem$")
	public void drag_and_drop_to_phase_system_and_subsystem() throws Throwable 
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
		 actual[6]=bp.waitForElement();
		// actual[6]=tr.doubleClickOnRelease(releaseName);
		    String[] phase=new String[3];
		    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",13,0);
		    phase[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,0);
		    phase[2]=Excel_Lib.getData(INPUT_PATH_4,"Phase",15,0);
		    actual[7]= cp.selectingNodeFromLocalArea(releaseName, phase);
		    bp.waitForElement();
		    bp.waitForElement();
		    //drag and drop to phase
		    String impnode1=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
		   String phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",13,0);
		   actual[8]=cp.dragAndDropImportedNodes(impnode1, phase1);
		    bp.waitForElement();
		    bp.waitForElement();
		  //drag and drop to system
		    //String impnode=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 2, 0);
		   String system=Excel_Lib.getData(INPUT_PATH_4,"Phase",14,0);
		   actual[9]=cp.dragAndDropImportedNodes(impnode1, system);
		    
		    bp.waitForElement();
		    bp.waitForElement();
			  //drag and drop to system
			    //String impnode=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 2, 0);
			   String subsystem=Excel_Lib.getData(INPUT_PATH_4,"Phase",15,0);
			   actual[10]=cp.dragAndDropImportedNodes(impnode1, subsystem);
			    bp.waitForElement();
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

	@Then("^Should be able to DnD imported nodes$")
	public void should_be_able_to_DnD_imported_nodes() throws Throwable 
	{
		try
		{
			actual[11]=cp.closeCopyFromProjectReleasesPage();
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
