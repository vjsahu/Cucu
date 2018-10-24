package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DND_Move_808707 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cp;
	ImportPage ip;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DND_Move_808707";
	boolean[] actual=new boolean[6];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^user in test repository page$")
	public void user_in_test_repository_page() throws Throwable 
	{
	    try
	    {
	    	bp=new BasePage();
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

	@Given("^navigate to P/S/SS in test repository page$")
	public void navigate_to_P_S_SS_in_test_repository_page() throws Throwable 
	{
	    try
	    {
	    	tr=new TestRepositoryPage(driver);
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_4, "Projects1", 1, 1);
	    	String[] navigate=new String[3];
	    	navigate[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Phase", 13, 0);
	    	navigate[1]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 14, 0);
	    	navigate[2]=Excel_Lib.getData(INPUT_PATH_4, "Phase", 15, 0);
	    	actual[3]=tr.navigateToNode(releaseName, navigate);
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

	@When("^navigate to imported and select a node$")
	public void navigate_to_imported_and_select_a_node() throws Throwable 
	{
	    try
	    {
	    	ip=new ImportPage(driver);
	    	Actions act=new Actions(driver);
	    	act.doubleClick(ip.Imported).perform();
	    	bp.waitForElement();
	    	String filename=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 3, 0);
	    	actual[4]=ip.selectImportedFile(filename);
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

	@When("^select testcases and drag and drop to local P/S/SS$")
	public void select_testcases_and_drag_and_drop_to_local_P_S_SS() throws Throwable 
	{
	   try
	   {
		   ep=new ExportPage(driver);
		   String[] testCaseNo=new String[3];
		   testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
		   testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0));
		   testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0));
		   actual[5]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@Then("^should able to move testcases$")
	public void should_able_to_move_testcases() throws Throwable 
	{
	   try
	   {
		   
		   String p2 ="'])[1]";
		   String p1="(//div[text()='";
		   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   
		   WebElement srcNode=driver.findElement(By.xpath("(//*[text()='Sample Project'])[1]"));
		   String destNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Phase", 13, 0);
		   tr.dragAndDropTestCase(srcNode, destNode);
		   bp.waitForElement();
		   
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
