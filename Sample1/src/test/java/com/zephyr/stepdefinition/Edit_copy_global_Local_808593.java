package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class Edit_copy_global_Local_808593 extends LaunchBrowser
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
	
	String fileName="Edit_copy_global_Local_808593";
	
	boolean[] actual=new boolean[12];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in  Repository Page$")
	public void user_in_Repository_Page() throws Throwable 
	{
		try
		{
		pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
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

	@Given("^select copy from release option$")
	public void select_copy_from_release_option() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    tr.clickOnCopyFromProjects();
//	    tr.options.click();
//	    bp.waitForElement();
//	    tr.copyReleaseOption.click();
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

	@When("^navigate to global subsystem and drag$")
	public void navigate_to_global_subsystem_and_drag() throws Throwable 
	{
		try
		{
		bp.waitForElement();
		cp=new CopyFromProjects(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		actual[4]=cp.selectProjectFromGlobalArea(projectName);
	    bp.waitForElement();
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    String[] nodes=new String[3];
	    nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Phase", 13, 1);
	    nodes[1]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 14, 1);
	    nodes[2]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 15, 1);
	    actual[5]=cp.selectNodeFromGlobalArea(releaseName, nodes);
	    bp.waitForElement();
	    String[] selecttestcase=new String[3];
	    selecttestcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
	    selecttestcase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0));
	    selecttestcase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0));
	    actual[6]=cp.selectMultipleTestCaseFromGlobalNode(selecttestcase);
	    bp.waitForElement();
	  //  cp.selectingLocalRelease(releaseName);
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

	@When("^navigate to local subsystem and drop$")
	public void navigate_to_local_subsystem_and_drop() throws Throwable 
	{
		try
		{
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    String[] nodes=new String[3];
	    nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Phase", 13, 1);
	    nodes[1]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 14, 1);
	    nodes[2]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 15, 1);
	    actual[7]=cp.selectingNodeFromLocalArea(releaseName, nodes);
		bp.waitForElement();
		bp.waitForElement();
		
		
		String selectTc="(//*[text()='Untitled'])[1]";
		WebElement ele=driver.findElement(By.xpath(selectTc));
		String node=Excel_Lib.getData(INPUT_PATH_4, "Phase", 14, 1);
		actual[8]=cp.dragAndDropTestCase(ele, node);
		bp.waitForElement();
		bp.waitForElement();
		actual[9]=cp.closeCopyFromProjectReleasesPage();
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

	@Then("^Should copy testcases from Global Sub-system to Current Sub-system$")
	public void should_copy_testcases_from_Global_Sub_system_to_Current_Sub_system() throws Throwable 
	{
		try
		{
		 // navigating to node
		String releaseName1=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
		//actual[10]=tr.doubleClickOnRelease(releaseName1);
		actual[10]=bp.waitForElement();
//	    bp.waitForElement();
	    String[] navigation=new String[3];
	   // navigation[0]=Excel_Lib.getData(INPUT_PATH_4,"Phase", 10, 0);
	    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Phase", 13, 1);
	    navigation[1]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 14, 1);
	    navigation[2]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 15, 1);
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[11]=tr.navigateToNode(releaseName1, navigation);
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
