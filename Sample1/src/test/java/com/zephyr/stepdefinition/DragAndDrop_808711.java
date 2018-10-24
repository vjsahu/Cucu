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

public class DragAndDrop_808711 extends LaunchBrowser
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DragAndDrop_808711";
	
   boolean[] actual=new boolean[19];
	
	SoftAssert soft=new SoftAssert();
	
@When("^user navigates to the first local phase, system and subsystem$")
public void user_navigates_to_the_first_local_phase_system_and_subsystem() throws Throwable {
	try
	{
		bp=new BasePage();
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String[] nodes=new String[3];
	
     nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
     nodes[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 4);
	 nodes[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 5);
	

	tr=new TestRepositoryPage(driver);
	actual[0]=tr.navigateToNode(releaseName, nodes);
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

@When("^navigates to the second phase ,system and subsystem$")
public void navigates_to_the_second_phase_system_and_subsystem() throws Throwable {
	try
	{
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
	String[] nodes=new String[3];
	
     nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 0);
     nodes[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 10, 0);
	 nodes[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 11, 0);
	

	tr=new TestRepositoryPage(driver);
	actual[1]=tr.navigateNode(nodes);
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

@When("^click on first phase and select multiple test cases$")
public void click_on_first_phase_and_select_multiple_test_cases() throws Throwable {
	try
	{
		bp=new BasePage();
	String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
	actual[2]=tr.selectPhase(phase);
	actual[3]=tr.addTestCase();
	actual[4]=tr.addTestCase();
	//tr.addTestCase();
	
	ep=new ExportPage(driver);
	bp.waitForElement();
	String[] testCase=new String[2];
	testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
	testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
	actual[5]=ep.selectMultipleTestCaseFromGrid(testCase);
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

@When("^move the selected test case to the second phase$")
public void move_the_selected_test_case_to_the_second_phase() throws Throwable {
  try
  {
	  bp=new BasePage();
	WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
   String node=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 9, 0);
   actual[6]=tr.dragAndDropTestCase(ele, node);
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

@When("^select the first system and select multiple test cases$")
public void select_the_first_system_and_select_multiple_test_cases() throws Throwable {
	try
	{
		bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] nodes=new String[3]; 
		nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
	     nodes[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 4);
		 nodes[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 5);
		

		tr=new TestRepositoryPage(driver);
		actual[0]=tr.navigateToNode(releaseName, nodes);
		bp.waitForElement();
	String system=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 4);
	actual[7]=tr.selectPhase(system);
	actual[8]=tr.addTestCase();
	actual[9]=tr.addTestCase();
	actual[10]=tr.addTestCase();
	
	ep=new ExportPage(driver);
	
	String[] testCase=new String[2];
	testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
	testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
	bp.waitForElement();
	actual[11]=ep.selectMultipleTestCaseFromGrid(testCase);
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

@When("^move the selected test case to the second system$")
public void move_the_selected_test_case_to_the_second_system() throws Throwable {
	try
	{
		bp=new BasePage();
	WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
	   String node=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 10, 0);
	   bp.waitForElement();
	   actual[12]=tr.dragAndDropTestCase(ele, node);
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

@When("^click on first subsystem and select multiple test cases$")
public void click_on_first_subsystem_and_select_multiple_test_cases() throws Throwable {
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1);
		String[] nodes=new String[3]; 
		nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
	     nodes[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 4);
		 nodes[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 5);
		

		tr=new TestRepositoryPage(driver);
		actual[0]=tr.navigateToNode(releaseName, nodes);
		bp.waitForElement();
		String subystem=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 5);
	actual[13]=tr.selectPhase(subystem);
	actual[14]=tr.addTestCase();
	actual[15]=tr.addTestCase();
	actual[16]=tr.addTestCase();
	
	ep=new ExportPage(driver);
	
	String[] testCase=new String[2];
	testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",1,6));
	testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"DragAndDrop",2,6));
	bp.waitForElement();
	actual[17]=ep.selectMultipleTestCaseFromGrid(testCase);
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

@When("^move the selected test case to the second subsystem$")
public void move_the_selected_test_case_to_the_second_subsystem() throws Throwable {
	try
	{
		bp=new BasePage();
	WebElement ele=driver.findElement(By.xpath("(//*[text()='Untitled'])[1]"));
	   String node=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 11, 0);
	   actual[18]=tr.dragAndDropTestCase(ele, node);
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

@Then("^test case should be moved to the nodes$")
public void test_case_should_be_moved_to_the_nodes() throws Throwable {

	try
	{
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
