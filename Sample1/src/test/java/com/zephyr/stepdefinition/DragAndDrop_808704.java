package com.zephyr.stepdefinition;

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

public class DragAndDrop_808704 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DragAndDrop_808704";
   boolean[] actual=new boolean[22];
	
	SoftAssert soft=new SoftAssert();

	@When("^User create a phase,system and subsystem$")
	public void user_create_a_phase_system_and_subsystem() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 12, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 12, 1);
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		 actual[0]=tr.doubleClickOnRelease(releaseName);   
		 bp.waitForElement();
		 actual[1]=tr.addNode(Name, Desc);
		 bp.waitForElement();
		 tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 
		 
		  
		  String [] phase1=new String[1];
		  phase1[0]=Name;
		  actual[2]=tr.navigateToNode(releaseName, phase1);
		  //bp.waitForElement();
		  String Name2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 13, 0);
		  String Desc2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 13, 1);
		  actual[3]=tr.addNode(Name2, Desc2);
		  bp.waitForElement();
		  actual[4]=tr.doubleClickOnRelease(releaseName);
		  bp.waitForElement();
		   
		  
		  
		   String [] system=new String[2];
		   system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 12, 0);
		   system[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 13, 0);
		   actual[5]=tr.navigateToNode(releaseName, system);
		   bp.waitForElement();
		   String Name3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 14, 0);
		   String Desc3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 14, 1);
		   actual[6]=tr.addNode(Name3, Desc3);
		   bp.waitForElement();
		   
		   
		  
			String Name_1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
			String Desc_1=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 1);
			 actual[7]=tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			 tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			 actual[8]=tr.addNode(Name_1, Desc_1);
			 bp.waitForElement();
			 actual[9]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
			  
			   
			   String [] phase_1=new String[1];
			  phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
			  actual[10]=tr.navigateToNode(releaseName, phase_1);
			  String Name_2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
			  String Desc_2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 1);
			  actual[11]=tr.addNode(Name_2, Desc_2);
			  bp.waitForElement();
			  actual[12]=tr.doubleClickOnRelease(releaseName);
			  bp.waitForElement();
			   
			   String [] system_2=new String[2];
			   system_2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
			   system_2[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
			   actual[13]=tr.navigateToNode(releaseName, system_2);
			   bp.waitForElement();
			   
			   String Name_3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 17, 0);
			   String Desc_3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 17, 1);
			   actual[14]=tr.addNode(Name_3, Desc_3);
			   bp.waitForElement();
			   tr.doubleClickOnRelease(releaseName);
			   
		   
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

	@When("^user navigates to subsystem$")
	public void user_navigates_to_subsystem() throws Throwable {
		try
		{
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String [] subsystem=new String[3];
		 subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 12, 0);
		 subsystem[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 13, 0);
		 subsystem[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 14, 0);
		 actual[15]=tr.navigateToNode(releaseName, subsystem);
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

	@When("^user naviagtes to another phase,system and subsystem$")
	public void user_naviagtes_to_another_phase_system_and_subsystem() throws Throwable {
		try
		{
			bp=new BasePage();
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		 String [] subsystem=new String[3];
		 subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
		 subsystem[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
		 subsystem[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 17, 0);
		
		 bp.waitForElement();
		 actual[16]=tr.navigateToNode(releaseName, subsystem);
		 bp.waitForElement();
		}catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
		  	Relogin rl=new Relogin();
		  	rl.reLogin();
		  	throw e;
			 
		}
		
	}

	@When("^drag and drop the subsystem to another phase,system and subsystem$")
	public void drag_and_drop_the_subsystem_to_another_phase_system_and_subsystem() throws Throwable {
	   try
	   {
		   bp=new BasePage();
		String srcNode=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 14, 0);
		String phaseNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
		actual[17]=tr.dragAndDropNode(srcNode, phaseNode);
		bp.waitForElement();
		bp.waitForElement();
		
//		String systemNode=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
//		actual[18]=tr.dragAndDropNode(srcNode, systemNode);
//		bp.waitForElement();
//		
//		String subsystemNode=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 17, 0);
//		actual[19]=tr.dragAndDropNode(srcNode, subsystemNode);
//		bp.waitForElement();
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

	@Then("^Subsystem should be moved to the phase,system and subsystem$")
	public void subsystem_should_be_moved_to_the_phase_system_and_subsystem() throws Throwable {
	    try
	    {
	    	bp=new BasePage();
	    String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] node1=new String[2];
	    node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
	    node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 14, 0);
	    bp.waitForElement();
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    actual[18]=tr.navigateToNode(releaseName, node1);
	    //String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
		
		if(actual[18]=true)
		{
			log.info("Subsystem successfully moved to phase");
		}
		
//			String[] node2=new String[2];
//	    node2[0]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
//	    node2[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
//	    node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 14, 0);
//	    actual[21]=tr.navigateNode(node2);
//		bp.waitForElement();
//	    if(actual[21]=true)
//	    {
//	    	log.info("Subsystem successfully moved to system");
//	    }
//		String[] node3=new String[3];
//	    node3[0]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
//	    node3[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
//	    node3[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 17, 0);
//	    node3[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 14, 0);
//	    
//	    actual[22]=tr.navigateNode(node3);
//	    bp.waitForElement();
//	    if(actual[22]=true)
//	    {
//	    	log.info("Subsystem successfully moved to subsystem");
//	    }
//			
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

	@When("^user navigates to system$")
	public void user_navigates_to_system() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String [] system=new String[2];
		 system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 12, 0);
		 system[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 13, 0);
		 actual[19]=tr.navigateToNode(releaseName, system);
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

	@When("^drag and drop the system to another phase,system and subsystem$")
	public void drag_and_drop_the_system_to_another_phase_system_and_subsystem() throws Throwable {
	  try
	  {
		  
		  bp=new BasePage();
//			String [] subsystem=new String[3];
//			 subsystem[0]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
//			 subsystem[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
//			 subsystem[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 17, 0);
//			
//			 bp.waitForElement();
//			 actual[20]=tr.navigateNode(subsystem);
//			 bp.waitForElement();
			 bp.waitForElement();
			
			
		String srcNode=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 13, 0);
		String destNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
		actual[20]=tr.dragAndDropNode(srcNode, destNode);
		bp.waitForElement();
		bp.waitForElement();
		
//		String destNode2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 16, 0);
//		actual[25]=tr.dragAndDropNode(srcNode, destNode2);
//		bp.waitForElement();
//		
//		String destNode3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 17, 0);
//		actual[26]=tr.dragAndDropNode(srcNode, destNode3);
//		bp.waitForElement();
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

	@Then("^system should be moved to the phase,system and subsystem$")
	public void system_should_be_moved_to_the_phase_system_and_subsystem() throws Throwable {
		
		try
		{
			bp=new BasePage();
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		   String[] node1=new String[2];
		    node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 15, 0);
		    node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 13, 0);
		    
		    bp.waitForElement();
		    tr.doubleClickOnRelease(releaseName);
		    bp.waitForElement();
		    actual[21]=tr.navigateToNode1(releaseName, node1);
		    bp.waitForElement();
			
			if(actual[21]=true)
			{
				log.info("System successfully moved to phase");
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
