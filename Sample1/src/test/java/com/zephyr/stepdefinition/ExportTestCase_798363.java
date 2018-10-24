package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportTestCase_798363 extends LaunchBrowser 
{
	LaunchBrowser lb;
	ProjectPage pp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	
	boolean[] actual=new boolean[20];
	SoftAssert soft=new SoftAssert();
	String filename="ExportTestCase_798363";
	@When("^User move system to system of other tree node$")
	public void user_move_system_to_system_of_other_tree_node() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		tr=new TestRepositoryPage(driver);
		actual[0]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 5, 0);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 5, 0);
		
		actual[1]=tr.addNode(name, desc);
		bp.waitForElement();
		actual[2]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 5, 0);
		actual[3]=tr.navigateToNode(releaseName, phase);
		
		String sys1=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 5, 1);
		String desc1=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 5, 1);
		actual[4]=tr.addNode(sys1, desc1);
		
		bp.waitForElement();
		actual[5]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] system=new String[2];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 5, 0);
		system[1]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 5, 1);
		actual[6]=tr.navigateToNode(releaseName, system);
		
		actual[7]=tr.moveNode();
		
		actual[8]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[9]=tr.doubleClickOnRelease(releaseName);
		
		
		
		String name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 0);
		String descr1=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 0);
		
		actual[10]=tr.addNode(name1, descr1);
		bp.waitForElement();
		actual[11]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] phase1=new String[1];
		phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 0);
		actual[12]=tr.navigateToNode(releaseName, phase1);
		
		String system1=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 1);
		String description1=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 1);
		actual[13]=tr.addNode(system1, description1);
		
		bp.waitForElement();
		actual[14]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
//		String[] system2=new String[2];
//		system2[0]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 0);
//		system2[1]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 1);
//		actual[0]=tr.navigateToNode(releaseName, system2);
//		
		
		
		String[] system2=new String[2];
		system2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 0);
		system2[1]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 6, 1);
		actual[15]=tr.navigateToNode(releaseName, system2);
		actual[16]=tr.pasteNode();
		bp.waitForElement();
		bp.waitForElement();
		}
		 catch(Exception e)
		{
				lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
     	Relogin rl=new Relogin();
     	rl.reLogin();
     	throw e;
		}
	    
	}

	@When("^Export test cases at release level$")
	public void export_test_cases_at_release_level() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		actual[17]=tr.doubleClickOnRelease(releaseName);
	    ep=new ExportPage(driver);
	   
	    actual[18]=ep.clickOnNodeExport();
	    actual[19]= ep.saveAndDownload();
	    bp.waitForElement();
		}
		 catch(Exception e)
		{
				lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
     	Relogin rl=new Relogin();
     	rl.reLogin();
     	throw e;
		}
	    
	}

	@Then("^test cases should be exported$")
	public void test_cases_should_be_exported() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		tr.doubleClickOnRelease(releaseName);
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
		soft.assertAll();
	    log.info("Test Case Exported at Release Level");
	    
		}
		 catch(Exception e)
		{
				lb=new LaunchBrowser();
				   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
    	Relogin rl=new Relogin();
    	rl.reLogin();
    	throw e;
		}
	}


}
