package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DragAndDrop_808710 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DragAndDrop_808710";
	boolean[] actual=new boolean[31];
    SoftAssert soft=new SoftAssert();
	

@When("^user Add a phase and add test case to the phase$")
public void user_Add_a_phase_and_add_test_case_to_the_phase() throws Throwable {
	try
	{

	
		bp=new BasePage();
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 18, 0);
	String Desc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 18, 1);
	tr=new TestRepositoryPage(driver);
	bp.waitForElement();
	 actual[0]=tr.doubleClickOnRelease(releaseName);   
	 bp.waitForElement();
	 actual[1]=tr.addNode(Name, Desc);
	 bp.waitForElement();
	 actual[2]= tr.addTestCase();
	 actual[3]=tr.addTestCase();
	 actual[4]=tr.addTestCase();
	 tr.addTestCase();
	  tr.addTestCase();
	  tr.addTestCase();
	 bp.waitForElement();
	 actual[5]=tr.doubleClickOnRelease(releaseName);
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

@When("^Add a system  and add test case to the system$")
public void add_a_system_and_add_test_case_to_the_system() throws Throwable {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
	try
	{
	String [] phase1=new String[1];
	  phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 18, 0);
	  actual[6]=tr.navigateToNode(releaseName, phase1);
	  bp.waitForElement();
	  String Name2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 19, 0);
	  String Desc2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 19, 1);
	  actual[7]=tr.addNode(Name2, Desc2);
	  bp.waitForElement();
	  actual[8]=tr.addTestCase();
	  actual[9]=tr.addTestCase();
	  actual[10]=tr.addTestCase();
	  
	  actual[11]=tr.doubleClickOnRelease(releaseName);
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

@When("^Add subsystem and add test case to the subsystem$")
public void add_subsystem_and_add_test_case_to_the_subsystem() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
	String [] system=new String[2];
	   system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 18, 0);
	   system[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 19, 0);
	   actual[12]=tr.navigateToNode(releaseName, system);
	   bp.waitForElement();
	   String Name3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 20, 0);
	   String Desc3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 20, 1);
	   actual[13]=tr.addNode(Name3, Desc3);
	   bp.waitForElement();
	   tr.addTestCase();
	   tr.addTestCase();
	   tr.addTestCase();
	   tr.addTestCase();
	   actual[14]=tr.doubleClickOnRelease(releaseName);
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

@When("^Creates another phase ,system and subsystem$")
public void creates_another_phase_system_and_subsystem() throws Throwable {
   
	try
	{
		bp=new BasePage();
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 21, 0);
	String Desc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 21, 1);
	
	bp.waitForElement();
	 actual[15]=tr.doubleClickOnRelease(releaseName);   
	 bp.waitForElement();
	 actual[16]=tr.addNode(Name, Desc);
	 bp.waitForElement();
	 actual[17]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	 
	 
	  
	  String [] phase1=new String[1];
	  phase1[0]=Name;
	  actual[18]=tr.navigateToNode(releaseName, phase1);
	  bp.waitForElement();
	  String Name2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 22, 0);
	  String Desc2=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 22, 1);
	  actual[19]=tr.addNode(Name2, Desc2);
	  bp.waitForElement();
	  actual[20]=tr.doubleClickOnRelease(releaseName);
	  bp.waitForElement();
	   
	  
	  
	   String [] system=new String[2];
	   system[0]=Name;
	   system[1]=Name2;
	   actual[21]=tr.navigateToNode(releaseName, system);
	   bp.waitForElement();
	   String Name3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 23, 0);
	   String Desc3=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 23, 1);
	   actual[22]=tr.addNode(Name3, Desc3);
	   bp.waitForElement();
	   bp.waitForElement();
	  tr.doubleClickOnRelease(releaseName);
	  bp.waitForElement();
	  
	  String[] nodes=new String[3];
	  nodes[0]=Name;
	  nodes[1]=Name2;
	  nodes[2]=Name3;
	  
	  
	  tr.navigateToNode(releaseName, nodes);
	   //tr.doubleClickOnRelease(releaseName);
	   
	   
	  
		
	   
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

@When("^naviagates to first phase$")
public void naviagates_to_first_phase() throws Throwable {
 try
 {
	 bp=new BasePage();
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String [] phase1=new String[3];
	  phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 18, 0);
	  phase1[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 19, 0);
	  phase1[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 20, 0);
	  
	  actual[23]=tr.navigateToNode(releaseName, phase1);
	  bp.waitForElement();
	  actual[24]=tr.selectPhase(phase1[0]);
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
}

@When("^select multiple test case from phase$")
public void select_multiple_test_case_from_phase() throws Throwable {
 
	try
	{
	ep=new ExportPage(driver);
   String[] testCase=new String[2];
	testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
	testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
	
	actual[25]=ep.selectMultipleTestCaseFromGrid(testCase);
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

@When("^copy the selected test case to second phase/system/subsystem$")
public void copy_the_selected_test_case_to_second_phase_system_subsystem() throws Throwable {
   
	try
	{
		bp=new BasePage();
	WebElement src=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
	String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 21, 0);
	
	
	actual[26]=tr.copyTestCase(src, phase);
	bp.waitForElement();
	bp.waitForElement();
    //driver.navigate().refresh();
    bp.waitForElement();
    //bp.waitForElement();
    tr=new TestRepositoryPage(driver);
    
	
	String phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 18, 0);
	tr.selectPhase(phase1);
	String system=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 22, 0);
	
	  ep=new ExportPage(driver);
	   String[] testCase1=new String[2];
		testCase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
		testCase1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
		bp.waitForElement();
		
		//driver.navigate().refresh();
		bp.waitForElement();
		
		
		bp.waitForElement();
		actual[27]=ep.selectMultipleTestCaseFromGrid(testCase1);
		bp.waitForElement();
		bp.waitForElement();
		
		
		WebElement src1=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
	   actual[28]=tr.copyTestCase(src1, system);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    
        tr.selectPhase(phase1);
	ep=new ExportPage(driver);
	   String[] testCase2=new String[2];
		testCase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
		testCase2[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
		
		bp.waitForElement();
		bp.waitForElement();
		actual[29]=ep.selectMultipleTestCaseFromGrid(testCase2);
	String subsystem=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 23, 0);
	bp.waitForElement();
	bp.waitForElement();
	WebElement src2=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
	actual[30]=tr.copyTestCase(src2, subsystem);
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

@Then("^test case should be copied to the phase/system/subsystem$")
public void test_case_should_be_copied_to_the_phase_system_subsystem() throws Throwable {
	
	try
	{
	for(int k=0;k<=actual.length-1;k++)
    {
    	System.out.println(actual[k]);
    	soft.assertEquals(actual[k], true);
    }
	
	soft.assertAll();
	driver.close();
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
