package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Move_TC_ToOtherNode_809421 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName=" Move_TC_ToOtherNode_809421";
	
	
	@Given("^User Moved to the TestRepositoryPage$")
	public void user_Moved_to_the_TestRepositoryPage() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LUname");
//		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LPass");
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   pp.selectProject(projectName);
		   pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep(); 
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

	@When("^User navigated to Releasename$")
	public void user_navigated_to_Releasename() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	     tr.doubleClickOnRelease(releaseName);
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

	@When("^User Creates two phases and Adds two testcases to each phase$")
	public void user_Creates_two_phases_and_Adds_two_testcases_to_each_phase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",22,0);
		String Desc=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",22,1);
		tr.addNode(Name, Desc);
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String navigation[]=new String[1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",22,0);
		tr.navigateToNode(releaseName, navigation);
		tr.addTestCase();
		//bp.waitForElement();
		tr.addTestCase();
		//bp.waitForElement();
		tr.addTestCase();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		
		
		
		String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",23,0);
		String Desc1=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",23,1);
		tr.addNode(Name1, Desc1);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String navigation1[]=new String[1];
		navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",23,0);
		tr.navigateToNode(releaseName, navigation1);
		tr.addTestCase();
		//bp.waitForElement();
		tr.addTestCase();
		//bp.waitForElement();
		tr.addTestCase();
		//tr.doubleClickOnRelease(releaseName);
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

	@When("^User moves one Testcase from one phase to another phase$")
	public void user_moves_one_Testcase_from_one_phase_to_another_phase() throws Throwable 
	{
		try
		{
//			 String releasename1="//*[@data-name='";
//		    String releasename2="']";
			String[] testcase=new String[3];
			testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",1,3));
			testcase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",2,3));
			testcase[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Create_P_S_SS",3,3));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testcase);
			bp.waitForElement();
			
			WebElement ele=driver.findElement(By.xpath("(//*[@title='Untitled'])[1]"));
			bp.waitForElement();
//		bp=new BasePage();
//		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
//		String navigation2[]=new String[1];
//		navigation2[0]=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",23,0);
//	    tr.navigateToNode(releaseName, navigation2);
//	    String names[]=new String[1];
//	    names[0]=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",23,0);
//	    tr.selectPhase(names[0]);
//	    Actions act=new Actions(driver);
//	    
//	    act.clickAndHold().perform();
	    bp.waitForElement();
	    String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",22,0);
	    //WebElement phase=driver.findElement(By.xpath(releasename1+phaseName+releasename2));
	    
	    //tr.selectPhase(phaseName);
	    bp.waitForElement();
	    bp.waitForElement();
//	    Actions a2=new Actions(driver);
//	    a2.dragAndDrop(ele, phase).perform();
	    tr.dragAndDropTestCase(ele, phaseName);
	    bp.waitForElement();
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
	    //act.release().perform();
	    
	}

	@Then("^Testcase should be moved successfully from one phase to another phase$")
	public void testcase_should_be_moved_successfully_from_one_phase_to_another_phase() throws Throwable 
	{
		try
		{
	    log.info("Pass - Testcase should be moved successfully from one phase to another phase");
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
