package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportTestCase_809370 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	

	boolean[] actual=new boolean[15];
	SoftAssert soft=new SoftAssert();
	
	String filename="ExportTestCase_809370";
	
	@When("^User Add a phase,system and subsystem$")
	public void user_Add_a_phase_system_and_subsystem() throws Throwable {
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 24, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 24, 1);
		
		  bp.waitForElement();
		tr=new TestRepositoryPage(driver);
		 actual[0]=tr.doubleClickOnRelease(releaseName);   
		 bp.waitForElement();
		 actual[1]=tr.addNode(Name, Desc);
		 bp.waitForElement();
		 actual[2]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 
		 
		  
		  String [] phase1=new String[1];
		  phase1[0]=Name;
		  actual[3]=tr.navigateToNode(releaseName, phase1);
		  bp.waitForElement();
		  String Name2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 25, 0);
		  String Desc2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 25, 1);
		  actual[4]=tr.addNode(Name2, Desc2);
		  bp.waitForElement();
		  actual[5]=tr.doubleClickOnRelease(releaseName);
		  bp.waitForElement();
		   
		  
		  
		   String [] system=new String[2];
		   system[0]=Name;
		   system[1]=Name2;
		   actual[6]=tr.navigateToNode(releaseName, system);
		   bp.waitForElement();
		   String Name3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 26, 0);
		   String Desc3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 26, 1);
		   actual[7]=tr.addNode(Name3, Desc3);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[8]=tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
		   //bp.waitForElement();
		   //tr.doubleClickOnRelease(releaseName);
		   
		   
		  tr.doubleClickOnRelease(releaseName);
		  String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 2);
		  String desc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 2);
		  tr.addNode(name, desc);
		  
		  bp.waitForElement();
		  bp.waitForElement();
			
		  tr.doubleClickOnRelease(releaseName);
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

	@When("^select system and choose move option$")
	public void select_system_and_choose_move_option() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 String [] system=new String[2];
		   system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 24, 0);
		   system[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 25, 0);
		   actual[9]=tr.navigateToNode(releaseName, system);
		   //actual[10]=tr.navigateToNode(releaseName, system);
		   actual[10]=tr.moveNode();
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

	@When("^naviagate to another phase$")
	public void naviagate_to_another_phase() throws Throwable {
		try
		{
		
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 
		String [] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 2);
		   //system[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 25, 0);
		   actual[11]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		   actual[12]=tr.navigateToNode(releaseName, phase);
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

	@When("^paste the selected system$")
	public void paste_the_selected_system() throws Throwable {
	   try
	   {
		tr.pasteNode();
	    String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[13]=tr.doubleClickOnRelease(releaseName);
	   
	    bp.waitForElement();
	   }
	   catch(Exception e)
		{
			e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}		
	}

	@Then("^selected system should be moved to the phase$")
	public void selected_system_should_be_moved_to_the_phase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String [] sys=new String[2];
		sys[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 2);
		sys[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 25, 0);
		actual[14]=tr.navigateToNode(releaseName, sys);
		bp.waitForElement();
		 tr.doubleClickOnRelease(releaseName);
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
		soft.assertAll();
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
